#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

layout(std140) uniform VignetteParams {
    vec4 tint;
    vec4 params;
};




void main() {
    vec2 p = (texCoord - 0.5) * 2.0;
    float d = length(p);
    fragColor = vec4(tint.rgb, smoothstep(params.x, 1.0, d) * tint.a);
}
