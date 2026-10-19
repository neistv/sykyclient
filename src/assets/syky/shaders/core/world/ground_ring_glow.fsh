#version 330



layout(std140) uniform GlowRect {
    vec4 Rect;
    vec4 Scale;
};

uniform sampler2D Sampler0;

layout(location = 0) out vec4 fragColor;

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715))));
}

void main() {
    vec2 uv = gl_FragCoord.xy / (vec2(textureSize(Sampler0, 0)) * Scale.x);
    vec3 lit = texture(Sampler0, uv).rgb;

    lit = clamp(lit + (dither(gl_FragCoord.xy) - 0.5) * (1.0 / 255.0), 0.0, 1.0);
    float level = max(max(lit.r, lit.g), lit.b);
    if (level < 0.0035) {
        discard;
    }
    fragColor = vec4(lit / level, level);
}
