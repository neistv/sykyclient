#version 330

#moj_import <syky:loot_beam.glsl>








out vec2 vUv;
out float vDepth;
flat out vec4 vColor;
flat out vec4 vShape;
flat out int vKind;

uniform sampler2D Sampler0;

const int MOTES = 8;
const int ELEMENTS = 3 + MOTES;
const int VERTICES_PER_BEAM = ELEMENTS * 6;



const float COLUMN_CORE = 0.014;
const float COLUMN_REACH = 0.32;
const float COLUMN_REACH_PX = 12.0;


const float FLARE_CORE = 0.032;
const float FLARE_REACH = 0.6;
const float FLARE_REACH_PX = 24.0;
const float FLARE_LIFT = 0.16;



const float RING_LIFT = 0.02;
const float RING_FADE_FROM = 5.0;
const float RING_FADE_TO = 14.0;


const float MOTE_CORE = 0.016;
const float MOTE_REACH = 0.016 * 5.0;
const float MOTE_REACH_PX = 9.0;



const float MOTE_SHRINK = 0.75;


const float MOTE_FAR = 32.0;

const vec2 CORNERS[6] = vec2[](
    vec2(-1.0, -1.0),
    vec2(1.0, -1.0),
    vec2(1.0, 1.0),
    vec2(-1.0, -1.0),
    vec2(1.0, 1.0),
    vec2(-1.0, 1.0)
);

void collapse() {

    gl_Position = vec4(2.0, 2.0, 2.0, 1.0);
    vUv = vec2(0.0);
    vDepth = 0.0;
    vColor = vec4(0.0);
    vShape = vec4(0.0, 0.0, 0.0, 1.0);
    vKind = KIND_COLUMN;
}




float heldEnergy(float scale) {
    return pow(max(scale, 1.0), -1.5);
}


float lineScale() {
    return 2.0 / Screen.w / 1080.0;
}



float card(vec3 centre, float reach, float reachPx, vec2 c) {
    vec4 clip = ViewProj * vec4(centre, 1.0);
    if (clip.w < 0.05) {
        collapse();
        return -1.0;
    }
    float halfH = reach * Screen.y / clip.w;
    float held = min(max(halfH, reachPx * lineScale() * Screen.w), Params.w);
    float scale = held / halfH;
    float halfW = reach * Screen.x / clip.w * scale;


    gl_Position = vec4(clip.xy + c * vec2(halfW, held) * clip.w, clip.z, clip.w);
    vDepth = clip.w;
    return reach * scale;
}








const float SEEN_HALF_WIDTH = 0.15;
const float SEEN_LOW = 0.03;
const float SEEN_HIGH = 0.35;
const float SEEN_SLACK = 0.35;
const float SEEN_FULL = 3.0;

float seen(vec3 foot) {
    vec3 side = vec3(foot.z, 0.0, -foot.x);
    float sideLength = length(side);
    side = sideLength > 1.0e-4 ? side / sideLength : vec3(1.0, 0.0, 0.0);
    ivec2 size = textureSize(Sampler0, 0);
    float hits = 0.0;
    for (int i = 0; i < 9; i++) {
        vec3 p = foot + side * (float(i % 3 - 1) * SEEN_HALF_WIDTH)
                + vec3(0.0, mix(SEEN_LOW, SEEN_HIGH, float(i / 3) * 0.5), 0.0);
        vec4 clip = ViewProj * vec4(p, 1.0);
        if (clip.w <= 0.05) {
            continue;
        }
        vec2 ndc = clip.xy / clip.w;
        if (abs(ndc.x) >= 1.0 || abs(ndc.y) >= 1.0) {
            continue;
        }
        float depth = texelFetch(Sampler0, ivec2((ndc * 0.5 + 0.5) * vec2(size)), 0).r;
        float scene = Params.z / (depth * 2.0 - 1.0 + Params.y);
        hits += step(clip.w - SEEN_SLACK, scene);
    }
    return min(hits / SEEN_FULL, 1.0);
}

void main() {
    int beam = gl_VertexID / VERTICES_PER_BEAM;
    int local = gl_VertexID - beam * VERTICES_PER_BEAM;
    int element = local / 6;
    vec2 c = CORNERS[local - element * 6];

    vec4 foot = Beams[beam * 3];
    vec4 colour = Beams[beam * 3 + 1];
    float seed = Beams[beam * 3 + 2].x;
    if (colour.a > 0.0) {
        colour.a *= seen(foot.xyz);
    }
    if (colour.a <= 0.0) {
        collapse();
        return;
    }
    float height = foot.w;
    vColor = colour;
    vUv = c;

    if (element == 0) {


        vec3 side = vec3(foot.z, 0.0, -foot.x);
        float sideLength = length(side);
        side = sideLength > 1.0e-4 ? side / sideLength : vec3(1.0, 0.0, 0.0);

        vec4 mid = ViewProj * vec4(foot.xyz + vec3(0.0, 0.5 * height, 0.0), 1.0);
        float reach = COLUMN_REACH;
        if (mid.w > 0.05) {
            float blocksPerPixel = Screen.z * mid.w / Screen.x;
            reach = max(reach, COLUMN_REACH_PX * lineScale() * blocksPerPixel);
        }
        vec3 p = foot.xyz + side * (c.x * reach) + vec3(0.0, (c.y * 0.5 + 0.5) * height, 0.0);
        gl_Position = ViewProj * vec4(p, 1.0);
        vDepth = gl_Position.w;
        vUv = vec2(c.x, c.y * 0.5 + 0.5);
        vShape = vec4(seed, height, COLUMN_REACH / reach, COLUMN_CORE / reach);
        vKind = KIND_COLUMN;
        return;
    }

    if (element == 1) {
        float reach = card(foot.xyz + vec3(0.0, FLARE_LIFT, 0.0), FLARE_REACH, FLARE_REACH_PX, c);
        if (reach < 0.0) {
            return;
        }
        vShape = vec4(seed, height, heldEnergy(reach / FLARE_REACH), FLARE_CORE / reach);
        vKind = KIND_FLARE;
        return;
    }

    if (element == 2) {
        vec3 p = foot.xyz + vec3(c.x * GROUND_REACH, RING_LIFT, c.y * GROUND_REACH);
        gl_Position = ViewProj * vec4(p, 1.0);
        vDepth = gl_Position.w;
        vec4 centre = ViewProj * vec4(foot.xyz, 1.0);
        float px = centre.w > 0.05 ? RING_RADIUS * Screen.y / centre.w / Screen.w : RING_FADE_TO;
        vShape = vec4(seed, height, smoothstep(RING_FADE_FROM, RING_FADE_TO, px), 1.0);
        vKind = KIND_RING;
        return;
    }



    if (dot(foot.xyz, foot.xyz) > MOTE_FAR * MOTE_FAR) {
        collapse();
        return;
    }
    uint id = uint(element) * 0x9E3779B9u + uint(seed * 65535.0) * 0x85EBCA6Bu;
    float r0 = hash01(id);
    float r1 = hash01(id + 0x165667B1u);
    float r2 = hash01(id + 0xC2B2AE35u);
    float r3 = hash01(id + 0x27D4EB2Fu);
    float period = 1.7 + 1.5 * r0;
    float ph = fract(Params.x / period + r1);
    float reachUp = min(height, 3.0) * (0.3 + 0.5 * r2);
    float fall = 1.0 - ph;
    float rise = reachUp * (1.0 - fall * fall);
    float turn = (r0 > 0.5 ? 1.0 : -1.0) * 2.4 * ph;
    float angle = r3 * TAU + turn;
    float radius = (0.06 + 0.2 * r2) * (1.0 - 0.55 * ph);
    vec3 centre = foot.xyz + vec3(cos(angle) * radius, 0.1 + rise, sin(angle) * radius);


    float size = (0.7 + 0.6 * r3) * max(pow(fall, MOTE_SHRINK), 0.02);
    float reach = card(centre, MOTE_REACH * size, MOTE_REACH_PX, c);
    if (reach < 0.0) {
        return;
    }
    float life = smoothstep(0.0, 0.12, ph) * (1.0 - smoothstep(0.8, 1.0, ph));

    float twinkle = 0.65 + 0.35 * sin(Params.x * (5.0 + 4.0 * r1) + r2 * TAU);

    vShape = vec4(seed, heldEnergy(reach / (MOTE_REACH * size)), life * twinkle, MOTE_CORE * size / reach);
    vKind = KIND_MOTE;
}
