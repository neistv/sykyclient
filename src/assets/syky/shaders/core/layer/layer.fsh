#version 330

layout(std140) uniform LayerData {
    vec4 params;
};

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;

void main() {



    vec4 c = texture(Sampler0, gl_FragCoord.xy / params.xy);

    if (c.a <= 0.0) {
        discard;
    }







    fragColor = c * params.z;
}
