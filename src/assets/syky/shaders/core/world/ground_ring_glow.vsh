#version 330


layout(std140) uniform GlowRect {
    vec4 Rect;
    vec4 Scale;
};

const vec2 QUAD[6] = vec2[](
    vec2(0.0, 0.0),
    vec2(1.0, 0.0),
    vec2(1.0, 1.0),
    vec2(0.0, 0.0),
    vec2(1.0, 1.0),
    vec2(0.0, 1.0)
);

void main() {
    gl_Position = vec4(mix(Rect.xy, Rect.zw, QUAD[gl_VertexID]), 0.0, 1.0);
}
