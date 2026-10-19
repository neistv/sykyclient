#version 330

in vec2 texCoord;


layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;



void main() {
    ivec2 base = ivec2(gl_FragCoord.xy) * 2;
    ivec2 last = textureSize(Sampler0, 0) - 1;
    gl_FragDepth = max(
            max(texelFetch(Sampler0, min(base, last), 0).r, texelFetch(Sampler0, min(base + ivec2(1, 0), last), 0).r),
            max(texelFetch(Sampler0, min(base + ivec2(0, 1), last), 0).r, texelFetch(Sampler0, min(base + 1, last), 0).r));
    fragColor = vec4(0.0);
}
