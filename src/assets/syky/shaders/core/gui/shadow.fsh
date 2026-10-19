#version 330










in vec2 localPos;
in vec2 rectSize;
in vec2 shadowOffset;
in float cornerRadius;
in float sigma;
in float guiScale;
in vec4 shadowColor;
in float edgeSigma;

layout(location = 0) out vec4 fragColor;

const float SQRT_2 = 1.4142135;
const float INV_SQRT_2PI = 0.3989423;



const int SAMPLES = 4;

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

float roundedBoxSDF(vec2 p, vec2 b, float r) {
    float k = squircleReach(r, b);
    float n = squircleExponent(r, k);
    vec2 q = abs(p) - b + k;
    vec2 m = max(q, 0.0);


    if (m.x <= 0.0 || m.y <= 0.0) {
        return min(max(q.x, q.y), 0.0) + max(m.x, m.y) - k;
    }
    vec2 ng = squircleNormGrad(m, n);
    return (ng.x - k) / ng.y;
}



vec2 erf(vec2 x) {
    vec2 s = sign(x);
    vec2 a = abs(x);
    vec2 d = 1.0 + (0.278393 + (0.230389 + 0.078108 * a * a) * a) * a;
    d *= d;
    return s - s / (d * d);
}

float gaussian(float x, float s) {
    return exp(-(x * x) / (2.0 * s * s)) * INV_SQRT_2PI / s;
}




struct Corner {
    float reach;
    float exponent;
    float invExponent;
    float reachPow;
};

float shadowSliceX(float x, float y, float s, Corner c, vec2 halfSize) {
    float delta = min(halfSize.y - c.reach - abs(y), 0.0);
    float curved = halfSize.x - c.reach + pow(max(c.reachPow - pow(abs(delta), c.exponent), 0.0), c.invExponent);
    vec2 integral = 0.5 + 0.5 * erf((x + vec2(-curved, curved)) / (SQRT_2 * s));
    return integral.y - integral.x;
}

float boxShadow(vec2 p, vec2 halfSize, float s, float corner) {



    Corner c;
    c.reach = squircleReach(corner, halfSize);
    c.exponent = squircleExponent(corner, c.reach);
    c.invExponent = 1.0 / c.exponent;
    c.reachPow = pow(c.reach, c.exponent);



    float low = p.y - halfSize.y;
    float high = p.y + halfSize.y;
    float start = clamp(-3.0 * s, low, high);
    float end = clamp(3.0 * s, low, high);

    float dy = (end - start) / float(SAMPLES);
    float y = start + dy * 0.5;
    float value = 0.0;
    for (int i = 0; i < SAMPLES; i++) {
        value += shadowSliceX(p.x, p.y - y, s, c, halfSize) * gaussian(y, s) * dy;
        y += dy;
    }
    return value;
}










float edgeCoverage(float d, float pxPerUnit, float soft) {
    if (soft <= 0.0) {
        return clamp(0.5 - d * pxPerUnit, 0.0, 1.0);
    }
    float band = max(2.5066283 * soft, 1.0 / pxPerUnit);
    return clamp(0.5 - d / band, 0.0, 1.0);
}

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715)))) / 255.0;
}

void main() {
    vec2 halfSize = rectSize * 0.5;
    vec2 p = localPos - halfSize;
    float corner = min(cornerRadius, min(halfSize.x, halfSize.y));









    float dist = roundedBoxSDF(p, halfSize, corner);
    float inside = edgeCoverage(dist, guiScale, edgeSigma);
    if (inside >= 0.999) {
        discard;
    }








    vec2 reach = abs(p - shadowOffset) - halfSize;
    if (max(reach.x, reach.y) > 3.0 * sigma) {
        discard;
    }

    float mask = boxShadow(p - shadowOffset, halfSize, sigma, corner);
    float alpha = shadowColor.a * mask * (1.0 - inside);
    if (alpha < 0.004) {
        discard;
    }



    alpha += dither(gl_FragCoord.xy) - 0.5 / 255.0;

    fragColor = vec4(shadowColor.rgb, alpha);
}
