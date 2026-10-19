#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;

void main() {


    fragColor = texture(Sampler0, clamp(texCoord, 0.0, 1.0));
}
