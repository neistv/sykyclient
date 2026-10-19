#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;



uniform sampler2D Sampler0;



uniform sampler2D Sampler1;

layout(std140) uniform GradeParams {

    vec4 params;
};





vec3 sampleGrade(vec3 c, float n1, float tile, float texel) {
    float blue = c.b * n1;
    float slice = floor(blue);
    float u = (c.r * n1 + 0.5) * texel;
    float v = (c.g * n1 + 0.5) * tile;
    vec3 lo = texture(Sampler1, vec2(slice * tile + u, v)).rgb;
    vec3 hi = texture(Sampler1, vec2(min(slice + 1.0, n1) * tile + u, v)).rgb;
    return mix(lo, hi, blue - slice);
}

void main() {
    vec4 src = texture(Sampler0, texCoord);
    fragColor = vec4(sampleGrade(clamp(src.rgb, 0.0, 1.0), params.x, params.y, params.z), src.a);
}
