#version 330

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <syky:badge_msdf.glsl>

uniform sampler2D Sampler0;

in vec4 vertexColor;
in vec2 texCoord0;

layout(location = 0) out vec4 fragColor;

void main() {
    vec4 color = vec4(vertexColor.rgb, vertexColor.a * badge_coverage(Sampler0, texCoord0));
    if (color.a < 0.004) {
        discard;
    }
    fragColor = color * ColorModulator;
}
