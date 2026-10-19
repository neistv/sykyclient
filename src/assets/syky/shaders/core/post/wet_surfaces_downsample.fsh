#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;




void main() {
    vec2 texel = 1.0 / vec2(textureSize(Sampler0, 0));
    vec3 c = texture(Sampler0, texCoord + vec2(-texel.x, -texel.y)).rgb;
    c += texture(Sampler0, texCoord + vec2(texel.x, -texel.y)).rgb;
    c += texture(Sampler0, texCoord + vec2(-texel.x, texel.y)).rgb;
    c += texture(Sampler0, texCoord + vec2(texel.x, texel.y)).rgb;
    fragColor = vec4(c * 0.25, 1.0);
}
