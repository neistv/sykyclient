#version 330















layout(std140) uniform GroupShadowData {
    vec4 data[67];
};

in vec2 fragPos;

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

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715)))) / 255.0;
}

void main() {
    vec4 frame = data[1];
    float guiScale = frame.z;
    int count = int(frame.w);





    float inside = 0.0;
    for (int i = 0; i < count; i++) {
        vec4 box = data[3 + i * 2];
        vec2 halfSize = box.zw * 0.5;
        vec2 p = fragPos - box.xy - halfSize;
        float corner = min(data[4 + i * 2].x, min(halfSize.x, halfSize.y));
        inside = max(inside, clamp(0.5 - roundedBoxSDF(p, halfSize, corner) * guiScale, 0.0, 1.0));
        if (inside >= 0.999) {
            discard;
        }
    }

    float mask = 0.0;
    for (int i = 0; i < count; i++) {
        vec4 shape = data[4 + i * 2];


        if (shape.y <= 0.0) {
            continue;
        }


        float sigma = max(shape.y, 0.5 / guiScale);
        vec4 box = data[3 + i * 2];
        vec2 halfSize = box.zw * 0.5;
        vec2 p = fragPos - box.xy - halfSize - shape.zw;




        vec2 reach = abs(p) - halfSize;
        if (max(reach.x, reach.y) > 3.0 * sigma) {
            continue;
        }
        float corner = min(shape.x, min(halfSize.x, halfSize.y));
        mask = max(mask, boxShadow(p, halfSize, sigma, corner));
    }

    vec4 shadowColor = data[2];
    float alpha = shadowColor.a * mask * (1.0 - inside);
    if (alpha < 0.004) {
        discard;
    }



    alpha += dither(gl_FragCoord.xy) - 0.5 / 255.0;

    fragColor = vec4(shadowColor.rgb, alpha);
}
