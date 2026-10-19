#version 330

in vec2 texCoord;
in vec2 dir;
in float vibrancy;
in float sigma;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;


























const int MAX_PAIRS = 12;

void main() {
    float twoSigmaSq = 2.0 * sigma * sigma;



    float weightSum = 1.0;
    vec3 col = texture(Sampler0, texCoord).rgb;

    for (int k = 1; k <= MAX_PAIRS; k++) {
        float ia = float(2 * k - 1);
        float ib = ia + 1.0;


        if (ia > 2.0 * sigma) {
            break;
        }

        float wa = exp(-(ia * ia) / twoSigmaSq);
        float wb = exp(-(ib * ib) / twoSigmaSq);
        float wPair = wa + wb;

        float o = ia + wb / wPair;
        col += (texture(Sampler0, texCoord + dir * o).rgb + texture(Sampler0, texCoord - dir * o).rgb) * wPair;
        weightSum += 2.0 * wPair;
    }

    fragColor = vec4(col / weightSum, vibrancy);
}
