#version 330





#define MAX_REGIONS 64

layout(std140) uniform BlurRegions {
    vec4 grid;
    vec4 regions[MAX_REGIONS];
};

out vec2 texCoord;

void main() {
    vec2 corners[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    vec4 r = regions[gl_InstanceID];
    vec2 uv = mix(r.xy, r.zw + 1.0, corners[gl_VertexID]) / grid.xy;
    gl_Position = vec4(uv * 2.0 - 1.0, 0.0, 1.0);
    texCoord = uv;
}
