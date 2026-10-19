#version 330

in vec2 texCoord;


layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;




void main() {
    ivec2 px = ivec2(gl_FragCoord.xy);
    if (texelFetch(Sampler0, px, 0).a <= 0.0) {
        discard;
    }
    gl_FragDepth = texelFetch(Sampler1, px, 0).r;
    fragColor = vec4(0.0);
}
