// Shared by loot_beam.vsh and .fsh — see LootBeamPipeline. A std140 block shared across stages must match member for
// member, so it lives here once.
layout(std140) uniform BeamData {
    mat4 ViewProj;  // projection * this frame's world view rotation, camera at the origin
    vec4 Screen;    // x = proj m00, y = proj m11, z / w = one pixel's width / height, NDC
    vec4 Params;    // x = clock seconds, y = proj m22, z = proj m32, w = the widest half-size, NDC
    // Three entries a beam: [3i] = its foot relative to the camera + its height in blocks, [3i+1] = rgb + strength,
    // [3i+2].x = its seed. Length 3 × LootBeamBatch.MAX_BEAMS (64).
    vec4 Beams[192];
};

const float TAU = 6.28318530718;
const float PHI = 0.6180339887;

const int KIND_COLUMN = 0;
const int KIND_FLARE = 1;
const int KIND_MOTE = 2;
const int KIND_RING = 3;

// The ground card under a beam: its half-size, blocks — room for the pool of light to fall off in — and the ring's
// radius on it.
const float GROUND_REACH = 1.4;
const float RING_RADIUS = 0.33;

uint pcg(uint v) {
    uint state = v * 747796405u + 2891336453u;
    uint word = ((state >> ((state >> 28u) + 4u)) ^ state) * 277803737u;
    return (word >> 22u) ^ word;
}

float hash01(uint v) {
    return float(pcg(v) & 0xFFFFu) * (1.0 / 65535.0);
}

// Smooth 1D value noise in [0, 1]. Hashed on the integer lattice rather than with sin(), which loses its precision
// long before the clock wraps and turns the flicker into a frozen pattern.
float noise1(float x) {
    float i = floor(x);
    float f = x - i;
    uint n = uint(int(i));
    return mix(hash01(n), hash01(n + 1u), f * f * (3.0 - 2.0 * f));
}
