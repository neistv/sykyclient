#version 330










layout(std140) uniform VeilData {
    vec4 quad;
    vec4 src;
    vec4 tap;
    vec4 band;
    vec4 valid;
    vec4 mask;
    vec4 radii;
    vec4 foot;
    vec4 split;
};

void main() {
    vec2 corners[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    gl_Position = vec4(corners[gl_VertexID] * quad.xy * 2.0 - 1.0, 0.0, 1.0);
}
