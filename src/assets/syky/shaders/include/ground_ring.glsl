// The Health Ring's shared half: the uniform both its programs read, and the light both of them draw — the rim pass
// (core/world/ground_ring) and the soft-light pass (core/world/ground_ring_soft). One copy, so the two halves of a
// disc can never drift apart: the rim pass adds the whitening of exactly the soft light the other pass draws.

layout(std140) uniform RingData {
    mat4 ViewProj;     // projection * this frame's world view rotation, camera at the origin
    mat4 InvViewProj;  // its inverse — turns the scene's depth back into a distance, and a pixel into a ray
    vec4 Params;       // x = clock seconds, y = rings in Rings, z = disc half-size in radii, w = unused
    // Four entries per ring: [4i] = centre relative to the camera + radius, [4i+1] = rgb + strength,
    // [4i+2] = x the lit arc's half-angle in radians (π = the whole ring), y = how much of its glow in the air is lit
    // (0..1), zw = the sweep's phase as (cos, sin),
    // [4i+3] = the part of the frame it can light, in device coordinates: xy = lower-left, zw = upper-right.
    // Length is 4 × GroundRingBatch.MAX_RINGS (64).
    vec4 Rings[256];
};

const float TAU = 6.28318530718;
const float PHI = 0.6180339887;

// Lifted off the ground so the disc never fights the block top it lies on — far enough to clear depth precision a few
// dozen blocks out, near enough that nobody sees the gap.
const float LIFT = 0.02;

// The rim: a thin band at radius 1, in radii. Never drawn thinner than RIM_MIN_PX screen pixels — a distant ring would
// otherwise shimmer in and out of the pixel grid — and its energy divided back down by the widening, so a far ring is
// as bright as a near one rather than fatter. RIM_BAND rim widths either side is all the rim pass draws: the rim is
// under 1e-4 by there.
const float RIM_WIDTH = 0.06;
const float RIM_MIN_PX = 1.25;
const float RIM_BAND = 3.2;

// The halo outside the rim and the light rising toward it inside.
const float HALO_GAIN = 0.95;
const float HALO_FALLOFF = 4.2;
const float HALO_INNER_FALLOFF = 9.0;
const float INNER_GAIN = 0.3;

// Two highlights travelling round the rim, opposite each other — a raised cosine to the seventh power.
const float SWEEP_GAIN = 1.1;

// The glow in the air: light thrown off the rim into the space round it as a glowing line seen through haze, the same
// in every direction — up, out and in alike. Its density falls off with distance from the rim as light does,
// 1 / (1 + d²): a soft round core and a long tail, windowed to nothing at AURA_REACH so it has no edge anywhere. Seen
// along the ring, at the ellipse's ends, the eye looks through more of it, so the glow is brightest there — what makes
// it read as coming off the ring rather than painted over the middle of it. Distances in radii, so the glow opens with
// the ring.
const float AURA_GAIN = 0.9;
const float AURA_SIGMA = 0.2;
const float AURA_REACH = 0.9;
// The march takes a step at most AURA_STEP radii long — never more than AURA_STEPS of them, never fewer than
// AURA_MIN_STEPS — so a ray that only clips the glow's edge pays a few steps, not the whole budget.
const int AURA_STEPS = 24;
const int AURA_MIN_STEPS = 6;
const float AURA_STEP = 0.16;
// Where 1 - exp(-AURA_GAIN × light) is past 0.9975 — under half a level of an 8-bit channel short of white.
const float AURA_SATURATED = 6.0 / AURA_GAIN;
// The glow's bounds round the rim: a box AURA_REACH round its tube.
const float BOX_OUT = 1.0 + AURA_REACH;
const float BOX_HALF = AURA_REACH;

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715))));
}

// The highlights at p, ring-local, given 1 / |p|² and the sweep's phase as (cos, sin): cos(2θ + phase) from the point
// itself — cos 2θ = (x² - y²) / r², sin 2θ = 2xy / r² — and the seventh power by multiplying. No trigonometry per pixel.
float sweepAt(vec2 p, float invR2, vec2 turn) {
    float c = ((p.x * p.x - p.y * p.y) * turn.x - 2.0 * p.x * p.y * turn.y) * invR2;
    float k = 0.5 + 0.5 * c;
    float k2 = k * k;
    return k * k2 * k2 * k2;
}

// An arc's ends draw out into needles: over its last ARC_TIP radians the rim narrows to a point, cos^ARC_TIP_SHAPE of
// the way along — it leaves the full rim without a kink and closes on a long thin point. The needles sit INSIDE the
// arc's length, so the arc still reads as the share it stands for; a near-whole ring shortens them by ARC_TIP_CLOSE ×
// its gap, so they meet the whole ring with no pinch at the back.
const float ARC_TIP = 0.55;
const float ARC_TIP_SHAPE = 1.5;
const float ARC_TIP_CLOSE = 4.0;
// The light round a needle — halo, rise inside, glow in the air — does NOT end with it: dimmed on its own, softer curve
// from where the needle starts, it carries on ARC_GLOW_OVERHANG radians past the point. Fading on the rim's own curve
// put the end of the light exactly on the end of the steel, which reads as the glow being cut off.
const float ARC_GLOW_OVERHANG = 0.45;
// ...and it narrows with the needle, to ARC_GLOW_THIN of the ring's spread at the point: a thin source throws a thin
// light, and the full ring's spread round the steel swallowed it.
const float ARC_GLOW_THIN = 0.55;

// Which way the lit arc faces: from the ring's centre toward the camera, flat on the ground, so its middle is always the
// side the player looks at and its gap the far one. `centre` is camera-relative.
vec2 arcFacing(vec3 centre) {
    vec2 toCamera = -centre.xz;
    float len = length(toCamera);
    return len > 1.0e-4 ? toCamera / len : vec2(0.0, 1.0);
}

// The arc at p: x the rim's width, 0..1 — 1 along the arc, `halfAngle` radians each way round from `facing`,
// narrowing to a needle's point over its ends and 0 past them; y the light round it, which starts dimming with the
// needle and outlasts its point; z how far that light spreads, as a share of the ring's — every soft-light distance is
// divided by it. A half-angle of π is the whole ring, (1, 1, 1) everywhere, and draws exactly as the plain ring. p is
// ring-local, in radii, |p| = r.
vec3 arcShape(vec2 p, float r, vec2 facing, float halfAngle) {
    if (halfAngle >= 0.5 * TAU - 1.0e-4) {
        return vec3(1.0);
    }
    float angle = acos(clamp(dot(p, facing) / max(r, 1.0e-6), -1.0, 1.0));
    float tip = min(ARC_TIP, min(halfAngle, ARC_TIP_CLOSE * (0.5 * TAU - halfAngle)));
    float from = halfAngle - tip;
    float along = clamp((angle - from) / max(tip, 1.0e-4), 0.0, 1.0);
    float glow = 1.0 - smoothstep(from, halfAngle + ARC_GLOW_OVERHANG * min(1.0, tip / ARC_TIP), angle);
    float rim = pow(cos(along * 0.25 * TAU), ARC_TIP_SHAPE);
    return vec3(rim, glow, mix(ARC_GLOW_THIN, 1.0, rim));
}

// The disc's soft light at radius r, `shape` being arcShape's answer there: the halo — steep inward, gentle outward, so
// the ring's light spills onto the ground round it — and the rise of light inside, faded to nothing before the disc's
// edge.
float discSoft(float r, vec3 shape, float sw) {
    float d = (r - 1.0) / shape.z;
    float halo = HALO_GAIN * (d >= 0.0 ? exp(-d * HALO_FALLOFF) : exp(d * HALO_INNER_FALLOFF));
    float rising = smoothstep(0.1, 1.0, r);
    float inside = r < 1.0 ? INNER_GAIN * rising * rising * rising : 0.0;
    float edge = 1.0 - smoothstep(Params.z * 0.7, Params.z, r);
    return (halo * (1.0 + 0.45 * sw) + inside) * edge * shape.y;
}
