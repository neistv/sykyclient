#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;

void main() {



    if (any(lessThan(texCoord, vec2(0.0))) || any(greaterThan(texCoord, vec2(1.0)))) {
        discard;
    }

    vec4 c = texture(Sampler0, texCoord);

    if (c.a <= 0.0) {
        discard;
    }




    fragColor = c;
}
