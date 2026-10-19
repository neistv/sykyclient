#version 330

layout(std140) uniform VeilData {
    vec4 quad;
    vec4 src;
    vec4 tap;
    vec4 band;
    vec4 valid;
    vec4 mask;
    vec4 radii;
    vec4 foot;

    vec4 split;
};

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;




const int MAX_PAIRS = 24;


const float MIN_SIGMA = 0.35;






vec4 fetch(vec2 dst) {
    if (split.w > 0.5 && dst.y < split.x) {




        if (dst.x < 0.5 || dst.y < 0.5 || dst.x > split.y - 0.5 || dst.y > split.z - 0.5) {
            return vec4(0.0);
        }
        return texture(Sampler1, dst / split.yz);
    }
    if (dst.x < valid.x || dst.y < valid.y || dst.x > valid.z || dst.y > valid.w) {
        return vec4(0.0);
    }
    return texture(Sampler0, (dst - src.xy) / src.zw);
}





float ramp(float y, float zeroY, float fullY) {
    float span = fullY - zeroY;
    float t = clamp((y - zeroY) / (abs(span) < 1e-4 ? 1e-4 : span), 0.0, 1.0);
    return t * t * (3.0 - 2.0 * t);
}



float veil(float y) {
    return ramp(y, band.x, band.y);
}







float veilFade(float y) {
    return ramp(y, band.x, foot.w);
}

// >>> squircle-patch:core










const float SQUIRCLE_SMOOTHING = 0.75;

float squircleReach(float r, vec2 halfSize) {
    return min(r * (1.0 + SQUIRCLE_SMOOTHING), min(halfSize.x, halfSize.y));
}

float squircleExponent(float r, float reach) {
    float s = r > 0.0 ? reach / r - 1.0 : 0.0;
    return 2.0 + s * (2.9 - 0.56 * s);
}











vec2 squircleNormGrad(vec2 m, float n) {
    float a = pow(m.x, n);
    float b = pow(m.y, n);
    float sum = a + b;
    float norm = pow(sum, 1.0 / n);
    return vec2(norm, length(vec2(a, b) * norm / (max(m, vec2(1e-6)) * sum)));
}
// <<< squircle-patch:core

float roundedBoxSDF(vec2 p, vec2 b, vec4 r) {
    r.xy = (p.x > 0.0) ? r.yz : r.xw;
    r.x = (p.y > 0.0) ? r.y : r.x;
    float k = squircleReach(r.x, b);
    float n = squircleExponent(r.x, k);
    vec2 q = abs(p) - b + k;
    vec2 m = max(q, 0.0);


    if (m.x <= 0.0 || m.y <= 0.0) {
        return min(max(q.x, q.y), 0.0) + max(m.x, m.y) - k;
    }
    vec2 ng = squircleNormGrad(m, n);
    return (ng.x - k) / ng.y;
}

void main() {
    vec2 dst = gl_FragCoord.xy + quad.zw;







    float sigma = tap.z * veil(dst.y);

    vec4 acc = fetch(dst);

    if (sigma > MIN_SIGMA) {



        float twoSigmaSq = 2.0 * sigma * sigma;
        float weightSum = 1.0;
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
            acc += (fetch(dst + tap.xy * o) + fetch(dst - tap.xy * o)) * wPair;
            weightSum += 2.0 * wPair;
        }
        acc /= weightSum;
    }

    if (band.w < 0.5) {


        fragColor = acc;
        return;
    }





    vec2 p = vec2(dst.x - mask.x, mask.y - dst.y);
    float maxRadius = min(mask.z, mask.w);
    float dist = roundedBoxSDF(p, mask.zw, min(radii, vec4(maxRadius)));


    float coverage = clamp(0.5 - dist, 0.0, 1.0);









    float alpha = tap.w * mix(1.0, band.z, veilFade(dst.y))
            * mix(1.0, foot.z, ramp(dst.y, foot.x, foot.y)) * coverage;
    if (acc.a <= 0.0 || alpha <= 0.0) {
        discard;
    }
    fragColor = acc * alpha;
}
