#version 330









// >>> wobble-patch:ubo
layout(std140) uniform WobbleData {
    vec4 screen;
    vec4 rect;
    vec4 src;
    vec4 shift;
    vec4 nodes[16];
};
// <<< wobble-patch:ubo

out vec2 texCoord;

// >>> wobble-patch:basis
vec4 bernstein(float t) {
    float s = 1.0 - t;
    return vec4(s * s * s, 3.0 * t * s * s, 3.0 * t * t * s, t * t * t);
}

vec4 bernsteinTangent(float t) {
    float s = 1.0 - t;
    return vec4(-3.0 * s * s, 3.0 * s * (1.0 - 3.0 * t), 3.0 * t * (2.0 - 3.0 * t), 3.0 * t * t);
}


vec2 blendRow(int j, vec4 b) {
    return b.x * nodes[4 * j + 0].xy
         + b.y * nodes[4 * j + 1].xy
         + b.z * nodes[4 * j + 2].xy
         + b.w * nodes[4 * j + 3].xy;
}
// <<< wobble-patch:basis

void main() {
    // >>> wobble-patch:eval
    vec2 corners[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    int cell = gl_VertexID / 6;
    int corner = gl_VertexID - cell * 6;
    int cellsX = int(screen.z);
    int cj = cell / cellsX;
    int ci = cell - cj * cellsX;

    vec2 grid = (vec2(float(ci), float(cj)) + corners[corner]) / screen.zw;





    vec2 srcPos = src.xy + grid * src.zw;
    vec2 logical = srcPos - shift.xy;



    vec2 t = (logical - rect.xy) / rect.zw;
    vec2 tc = clamp(t, 0.0, 1.0);

    vec4 bu = bernstein(tc.x);
    vec4 bv = bernstein(tc.y);
    vec4 tu = bernsteinTangent(tc.x);
    vec4 tv = bernsteinTangent(tc.y);

    vec2 r0 = blendRow(0, bu);
    vec2 r1 = blendRow(1, bu);
    vec2 r2 = blendRow(2, bu);
    vec2 r3 = blendRow(3, bu);

    vec2 q0 = blendRow(0, tu);
    vec2 q1 = blendRow(1, tu);
    vec2 q2 = blendRow(2, tu);
    vec2 q3 = blendRow(3, tu);


    vec2 warped = bv.x * r0 + bv.y * r1 + bv.z * r2 + bv.w * r3;
    vec2 dPdu   = bv.x * q0 + bv.y * q1 + bv.z * q2 + bv.w * q3;
    vec2 dPdv   = tv.x * r0 + tv.y * r1 + tv.z * r2 + tv.w * r3;





    vec2 over = t - tc;



    vec2 pos = warped + over.x * dPdu + over.y * dPdv;
    // <<< wobble-patch:eval

    vec2 ndc = (pos / screen.xy) * 2.0 - 1.0;
    ndc.y = -ndc.y;
    gl_Position = vec4(ndc, 0.0, 1.0);




    texCoord = vec2(srcPos.x / screen.x, 1.0 - srcPos.y / screen.y);
}
