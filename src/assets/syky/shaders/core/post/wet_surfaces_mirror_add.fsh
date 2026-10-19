#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;



void main() {
    vec3 light = texture(Sampler0, texCoord).rgb;
    if (max(light.r, max(light.g, light.b)) < 0.002) {
        discard;
    }
    fragColor = vec4(light, 1.0);
}
