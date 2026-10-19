#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;




void main() {
    vec4 stroke = texelFetch(Sampler0, ivec2(gl_FragCoord.xy), 0);
    if (stroke.a == 0.0) {
        discard;
    }
    fragColor = stroke;
}
