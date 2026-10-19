#version 330

layout(std140) uniform TransformData {
    vec4 quad;
    vec4 xform;
    vec4 src;
    vec4 tap;
    vec4 valid;
    vec4 misc;

    vec4 mask;
    vec4 radii;
    vec4 cut;

};

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;




const int MAX_PAIRS = 20;











vec4 fetch(vec2 dst) {
    vec2 s = (dst - xform.xy) * xform.zw + xform.xy;
    if (s.x < valid.x || s.y < valid.y || s.x > valid.z || s.y > valid.w) {
        return vec4(0.0);
    }
    return texture(Sampler0, (s - src.xy) / src.zw);
}









float ramp(float y) {
    float span = misc.z - misc.y;
    if (abs(span) < 1e-4) {
        return 1.0;
    }
    float t = clamp((y - misc.y) / span, 0.0, 1.0);
    return t * t * (3.0 - 2.0 * t);
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















float surfaceCoverage(vec2 dst) {
    if (mask.z <= 0.0 || mask.w <= 0.0) {
        return 1.0;
    }

    vec2 p = vec2(dst.x - mask.x, mask.y - dst.y);
    float maxRadius = min(mask.z, mask.w);
    float dist = roundedBoxSDF(p, mask.zw, min(radii, vec4(maxRadius)));
    float band = max(cut.x, 1.0);
    float t = clamp((0.5 - dist) / band, 0.0, 1.0);
    return cut.x > 0.0 ? t * t * (3.0 - 2.0 * t) : t;
}







float holeCoverage(vec2 dst) {
    if (cut.w <= 0.0) {
        return 1.0;
    }
    return clamp(length(dst - cut.yz) - cut.w + 0.5, 0.0, 1.0);
}

void main() {
    vec2 dst = gl_FragCoord.xy + quad.zw;






    float edge = ramp(dst.y);
    float sigma = tap.z * edge;

    vec4 acc = fetch(dst);

    if (sigma > 0.0) {






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




    float coverage = misc.x > 0.5 ? surfaceCoverage(dst) * holeCoverage(dst) : 1.0;



    if (misc.x > 0.5 && (acc.a <= 0.0 || coverage <= 0.0)) {
        discard;
    }









    fragColor = acc * tap.w * mix(1.0, misc.w, edge) * coverage;
}
