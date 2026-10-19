#version 330

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <syky:translucent_cover.glsl>

in vec4 vertexColor;

layout(location = 0) out vec4 fragColor;



void main() {
    vec4 color = vertexColor;
    if (color.a == 0.0) {
        discard;
    }
    fragColor = color * ColorModulator;
    fragColor.a *= coverShow(gl_FragCoord.xy, gl_FragCoord.z);
}
