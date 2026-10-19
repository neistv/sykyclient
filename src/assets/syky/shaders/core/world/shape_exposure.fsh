#version 330

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <syky:translucent_cover.glsl>

in vec4 vertexColor;

layout(location = 0) out vec4 fragColor;



void main() {
    vec4 color = vertexColor * ColorModulator;
    float raise = color.a * coverShow(gl_FragCoord.xy, gl_FragCoord.z);
    if (raise <= 0.0) {
        discard;
    }
    fragColor = vec4(color.rgb * raise, 0.0);
}
