#version 330

in vec4 vertexColor;
in float down;

layout(location = 0) out vec4 fragColor;

void main() {

    float left = 1.0 - down;
    float a = vertexColor.a * left * left;
    if (a <= 0.0) {
        discard;
    }
    fragColor = vec4(vertexColor.rgb, a);
}
