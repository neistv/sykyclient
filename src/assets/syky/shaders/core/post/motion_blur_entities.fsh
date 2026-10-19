#version 330





in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D FloorSampler;
uniform sampler2D SeamSampler;

void main() {
    fragColor = vec4(texture(SeamSampler, texCoord).r < texture(FloorSampler, texCoord).r ? 1.0 : 0.0);
}
