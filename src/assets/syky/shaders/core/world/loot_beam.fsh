#version 330

#moj_import <syky:loot_beam.glsl>
#moj_import <syky:translucent_cover.glsl>
#moj_import <syky:crystal_halo.glsl>

in vec2 vUv;
in float vDepth;
flat in vec4 vColor;
flat in vec4 vShape;
flat in int vKind;

uniform sampler2D Sampler0;

layout(location = 0) out vec4 fragColor;



const float SOFT_RANGE = 0.3;




const float CORE_MIN_PX = 0.8;


const float COLUMN_HALO = 0.18;
const float FLARE_HALO = 0.3;
const float MOTE_HALO = 0.3;



const float COLUMN_DRIVE = 1.6;
const float FLARE_DRIVE = 4.0;
const float MOTE_DRIVE = 5.0;



const float POOL_GAIN = 0.32;
const float POOL_RADIUS = 0.4;



const float RING_WIDTH_PX = 0.9;
const float RING_GLOW = 0.25;
const float RING_GLOW_FALLOFF = 0.25;
const float RING_GAIN = 0.75;


const float SHEATH = 2.8;
const float SHEATH_GAIN = 0.5;

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715))));
}



float core(float d, float r) {
    float held = max(r, CORE_MIN_PX);
    float x = d / held;
    float x2 = x * x;
    return exp(-x2 * x2) * (r / held);
}


float spot(float d, float r) {
    float held = max(r, CORE_MIN_PX);
    float x = d / held;
    return exp(-x * x * 2.0) * (r / held) * (r / held);
}




float cardWindow(float r) {
    float w = max(1.0 - r * r, 0.0);
    return w * w;
}


float turnTo(float angle, float target) {
    return abs(mod(angle - target + 0.5 * TAU, TAU) - 0.5 * TAU);
}

float columnEnvelope(float v, float hb) {
    return smoothstep(0.0, 0.35, hb) * pow(1.0 - v, 1.25);
}




vec2 strand(int s, float v, float hb, float seed, float t) {
    float fs = float(s);
    float drift = 0.24 * sin(hb * (1.1 + 0.35 * fs) - t * (0.7 + 0.25 * fs) + seed * TAU + fs * 2.09) * (0.25 + 0.75 * v);
    float lit = smoothstep(0.45, 0.9, noise1(hb * 1.4 - t * (1.6 + 0.45 * fs) + fs * 37.1 + seed * 59.0));
    return vec2(drift, lit);
}



const float COLUMN_CORE_ZONE = 0.62;


const float CURL_ZONE = 0.4;




float column(vec2 uv, float pxPerU, float seed, float height, float coreU, float haloGain, float t, out float white) {
    float v = uv.y;
    float hb = v * height;
    float envelope = columnEnvelope(v, hb);
    float k = abs(uv.x) / mix(1.0, 0.75, v);
    float low = 1.0 - v;
    float halo = crystalHalo(k * k) * COLUMN_HALO * (1.0 + 0.8 * low * low * low) * haloGain;
    white = 0.0;
    float d = abs(uv.x) * pxPerU;
    float r = coreU * mix(1.0, 0.45, v) * pxPerU;
    if (abs(uv.x) > COLUMN_CORE_ZONE && d > SHEATH * 2.0 * max(r, CORE_MIN_PX)) {
        return halo * envelope;
    }


    float pulse = smoothstep(0.55, 0.95, noise1(hb * 1.1 - t * 2.4 + seed * 97.0));
    float swell = 0.8 + 0.3 * noise1(hb * 0.45 - t * 0.9 + seed * 41.0);

    float hot = core(d, r) * (swell + 0.6 * pulse) * (1.0 - 0.6 * v);
    float sheath = core(d, SHEATH * r) * SHEATH_GAIN * swell;

    float strands = 0.0;
    for (int s = 0; s < 3; s++) {
        vec2 st = strand(s, v, hb, seed, t);
        float off = uv.x - st.x;

        strands += (0.8 * core(abs(off) * pxPerU, max(coreU * 0.4 * pxPerU, 0.9))
                + 0.24 * haloGain * crystalHalo(off * off * 9.0)) * st.y;
    }

    white = hot * envelope;
    return (hot * COLUMN_DRIVE + sheath + strands + halo) * envelope;
}


float flare(vec2 uv, float pxPerU, float seed, float coreU, float haloGain, float t, out float white) {
    float r = length(uv);
    white = 0.0;
    if (r >= 1.0) {
        return 0.0;
    }
    float d = r * pxPerU;
    float hot = spot(d, coreU * pxPerU) * cardWindow(r);
    white = 0.35 * hot;
    float curls = 0.0;
    if (r < CURL_ZONE) {
        float angle = atan(uv.y, uv.x);
        for (int i = 0; i < 3; i++) {
            float fi = float(i);
            float target = seed * TAU + fi * (TAU / 3.0) + t * 1.4 + r * 7.0;
            float off = turnTo(angle, target) * d;
            float along = smoothstep(0.05, 0.12, r) * (1.0 - smoothstep(0.16, 0.38, r));
            float lit = 0.55 + 0.45 * noise1(t * 3.0 + fi * 17.0 + seed * 23.0);
            curls += core(off, max(coreU * 0.3 * pxPerU, 0.7)) * along * lit;
        }
    }
    float light = hot * FLARE_DRIVE + (crystalHalo(r * r) * FLARE_HALO + 0.6 * curls) * haloGain;
    return light * (0.9 + 0.1 * sin(t * 2.3 + seed * TAU));
}






float ground(vec2 uv, vec2 dx, vec2 dy, float seed, float t, float ringFade) {
    float r = length(uv);
    if (r >= 1.0) {
        return 0.0;
    }
    float window = (1.0 - r * r) * (1.0 - r * r);
    float blocks = r * GROUND_REACH;
    float pool = POOL_GAIN / (1.0 + blocks * blocks / (POOL_RADIUS * POOL_RADIUS)) * window;
    if (ringFade <= 0.0) {
        return pool;
    }
    vec2 dir = uv / max(r, 1.0e-4);
    float perPx = max(length(vec2(dot(dir, dx), dot(dir, dy))), 1.0e-5);
    float off = abs(r - RING_RADIUS / GROUND_REACH) / perPx;
    float chase = 0.5 + 0.5 * sin(atan(uv.y, uv.x) * 2.0 - t * 2.6 + seed * TAU);
    float line = core(off, RING_WIDTH_PX) + RING_GLOW * exp(-off * RING_GLOW_FALLOFF);
    return pool + line * (0.3 + 0.7 * chase * chase * chase) * RING_GAIN * ringFade;
}



float mote(vec2 uv, float pxPerU, float coreU, float fade, float held, out float white) {
    float r = length(uv);
    white = 0.0;
    if (r >= 1.0) {
        return 0.0;
    }
    float hot = spot(r * pxPerU, coreU * pxPerU) * cardWindow(r) * fade;
    white = 0.35 * hot;
    return hot * MOTE_DRIVE + crystalHalo(r * r) * MOTE_HALO * held * fade;
}

void main() {

    vec2 dx = dFdx(vUv);
    vec2 dy = dFdy(vUv);
    float pxPerU = 1.0 / max(length(vec2(dx.x, dy.x)), 1.0e-5);



    float depth = texelFetch(Sampler0, ivec2(gl_FragCoord.xy), 0).r;
    float scene = Params.z / (depth * 2.0 - 1.0 + Params.y);


    float show = clamp((scene - vDepth) / SOFT_RANGE, 0.0, 1.0);
    if (vKind == KIND_RING) {

        show = gl_FragCoord.z > depth ? 0.0 : 1.0;
    }
    if (show <= 0.0) {
        discard;
    }

    float seed = vShape.x;
    float t = Params.x;
    float white;
    float light;
    if (vKind == KIND_COLUMN) {
        light = column(vUv, pxPerU, seed, vShape.y, vShape.w, vShape.z, t, white);
    } else if (vKind == KIND_FLARE) {
        light = flare(vUv, pxPerU, seed, vShape.w, vShape.z, t, white);
    } else if (vKind == KIND_RING) {
        light = ground(vUv, dx, dy, seed, t, vShape.z);
        white = 0.0;
    } else {
        light = mote(vUv, pxPerU, vShape.w, vShape.z, vShape.y, white);
    }
    float intensity = light * vColor.a;



    float phase = seed * 7.0 + float(vKind) * PHI;
    float jitter = (fract(dither(gl_FragCoord.xy) + phase) - 0.5) * (1.5 / 255.0);



    vec3 base = mix(vColor.rgb, vec3(1.0), clamp(white * vColor.a, 0.0, 1.0));
    vec3 lit = clamp(base * intensity + jitter, 0.0, 1.0);
    float level = max(max(lit.r, lit.g), lit.b);
    if (level < 0.0035) {
        discard;
    }


    fragColor = vec4(lit / level, level * show * coverShow(gl_FragCoord.xy, gl_FragCoord.z));
}
