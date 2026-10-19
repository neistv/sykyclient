#version 330

#moj_import <syky:ground_ring.glsl>




out vec2 vLocal;
flat out vec4 vColor;
flat out vec2 vTurn;
flat out vec3 vArc;
flat out int vRing;

const int RIM_SEGMENTS = 32;
const int VERTICES_PER_RING = RIM_SEGMENTS * 6;

const vec2 QUAD[6] = vec2[](
    vec2(0.0, 0.0),
    vec2(1.0, 0.0),
    vec2(1.0, 1.0),
    vec2(0.0, 0.0),
    vec2(1.0, 1.0),
    vec2(0.0, 1.0)
);


uniform sampler2D Sampler0;

void collapse() {

    gl_Position = vec4(2.0, 2.0, 2.0, 1.0);
    vLocal = vec2(0.0);
    vColor = vec4(0.0);
    vTurn = vec2(1.0, 0.0);
    vArc = vec3(0.0, 1.0, 0.5 * TAU);
    vRing = 0;
}

void main() {
    int ring = gl_VertexID / VERTICES_PER_RING;
    int local = gl_VertexID - ring * VERTICES_PER_RING;

    vec4 centre = Rings[ring * 4];
    vec4 colour = Rings[ring * 4 + 1];
    vec4 extra = Rings[ring * 4 + 2];
    if (colour.a <= 0.0) {
        collapse();
        return;
    }




    vec4 clip = ViewProj * vec4(centre.xyz, 1.0);
    float band = RIM_BAND * RIM_WIDTH * 1.5;
    if (clip.w > 1.0e-3) {
        float p11 = length(vec3(ViewProj[0][1], ViewProj[1][1], ViewProj[2][1]));
        float pixel = 2.0 * clip.w / (p11 * float(textureSize(Sampler0, 0).y) * centre.w);
        float seen = max(abs(centre.y) / max(length(centre.xyz), 1.0e-4), 0.08);
        band = max(band, RIM_BAND * RIM_MIN_PX * 1.6 * pixel / seen);
    }
    band = min(band, 1.0);

    int quad = local / 6;
    vec2 k = QUAD[local - quad * 6];
    float a = (float(quad) + k.x) * (TAU / float(RIM_SEGMENTS));


    float radius = k.y > 0.5 ? (1.0 + band) / cos(TAU / float(2 * RIM_SEGMENTS)) : max(1.0 - band, 0.0);
    vec2 off = vec2(cos(a), sin(a)) * radius;
    vec3 pos = centre.xyz + vec3(off.x * centre.w, LIFT, off.y * centre.w);

    gl_Position = ViewProj * vec4(pos, 1.0);
    vLocal = off;
    vColor = colour;
    vTurn = extra.zw;
    vArc = vec3(arcFacing(centre.xyz), extra.x);
    vRing = ring;
}
