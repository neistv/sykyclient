#version 330

layout(std140) uniform RectData {
    vec4 data[1020];
};

in vec2 fragCoord;
in vec2 pixelCoord;
in vec2 rectSize;
in vec4 cornerRadii;
in float guiScale;
in float innerBlur;
flat in int vBase;

layout(location = 0) out vec4 fragColor;

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

vec3 toSRGB(vec3 linear) {
    return pow(linear, vec3(1.0 / 2.2));
}

vec4 toSRGB(vec4 linear) {
    return vec4(toSRGB(linear.rgb), linear.a);
}

float smoothInterpolate(float t) {
    return t * t * t * (t * (t * 6.0 - 15.0) + 10.0);
}

vec4 unpremult(vec4 c) {
    c.rgb /= max(c.a, 1e-4);
    return c;
}




vec4 sampleGradientAt(vec2 uv) {
    float x = clamp(uv.x, 0.0, 1.0);
    float y = clamp(uv.y, 0.0, 1.0);

    x = smoothInterpolate(x);
    y = smoothInterpolate(y);


    vec4 c0 = data[vBase + 3];
    vec4 c1 = data[vBase + 4];
    vec4 c2 = data[vBase + 5];
    vec4 c3 = data[vBase + 6];
    vec4 c4 = data[vBase + 7];
    vec4 c5 = data[vBase + 8];
    vec4 c6 = data[vBase + 9];
    vec4 c7 = data[vBase + 10];
    vec4 c8 = data[vBase + 11];

    vec4 top = mix(mix(c0, c1, x), mix(c1, c2, x), x);
    vec4 middle = mix(mix(c3, c4, x), mix(c4, c5, x), x);
    vec4 bottom = mix(mix(c6, c7, x), mix(c7, c8, x), x);

    return mix(mix(top, middle, y), mix(middle, bottom, y), y);
}

vec4 sampleGradient(vec2 uv) {
    if (innerBlur <= 0.0) {
        return toSRGB(unpremult(sampleGradientAt(uv)));
    }

    float blur = innerBlur * 0.01;



    vec4 sum = sampleGradientAt(uv) * 4.0;
    float weightSum = 4.0;

    sum += sampleGradientAt(uv + vec2(-blur, 0.0)) * 2.0;
    sum += sampleGradientAt(uv + vec2(blur, 0.0)) * 2.0;
    sum += sampleGradientAt(uv + vec2(0.0, -blur)) * 2.0;
    sum += sampleGradientAt(uv + vec2(0.0, blur)) * 2.0;
    weightSum += 8.0;

    sum += sampleGradientAt(uv + vec2(-blur, -blur));
    sum += sampleGradientAt(uv + vec2(blur, -blur));
    sum += sampleGradientAt(uv + vec2(-blur, blur));
    sum += sampleGradientAt(uv + vec2(blur, blur));
    weightSum += 4.0;

    float blur2 = blur * 2.0;
    sum += sampleGradientAt(uv + vec2(-blur2, 0.0)) * 0.5;
    sum += sampleGradientAt(uv + vec2(blur2, 0.0)) * 0.5;
    sum += sampleGradientAt(uv + vec2(0.0, -blur2)) * 0.5;
    sum += sampleGradientAt(uv + vec2(0.0, blur2)) * 0.5;
    weightSum += 2.0;

    return toSRGB(unpremult(sum / weightSum));
}

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715)))) / 255.0;
}

void main() {
    vec2 halfSize = rectSize * 0.5;
    vec2 center = pixelCoord - halfSize;

    float maxRadius = min(halfSize.x, halfSize.y);
    vec4 clampedRadii = min(cornerRadii, vec4(maxRadius));

    float dist = roundedBoxSDF(center, halfSize, clampedRadii);


    float alpha = clamp(0.5 - dist * guiScale, 0.0, 1.0);






    vec2 physicalSize = rectSize * guiScale;
    float subPixel = clamp(physicalSize.x, 0.0, 1.0) * clamp(physicalSize.y, 0.0, 1.0);
    alpha = min(alpha, subPixel);

    if (alpha < 0.01) {
        discard;
    }

    vec4 color = sampleGradient(fragCoord);

    float noise = dither(gl_FragCoord.xy);
    color.rgb += noise - 0.5 / 255.0;

    fragColor = vec4(color.rgb, color.a * alpha);
}
