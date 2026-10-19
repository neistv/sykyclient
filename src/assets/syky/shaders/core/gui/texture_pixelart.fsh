#version 330

in vec2 fragCoord;
in vec2 pixelCoord;
in vec2 texCoord;
in vec2 rectSize;
in vec4 cornerRadii;
in vec4 tintColor;
in float guiScale;
in vec4 uvBounds;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;

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

















vec2 pixelArtUV(vec2 uv, vec2 texSize) {
    vec2 pixel = uv * texSize;
    vec2 nearestCenter = floor(pixel + 0.5);
    vec2 dx = max(fwidth(pixel), vec2(1e-6));
    vec2 alpha = clamp((pixel - nearestCenter) / dx + 0.5, 0.0, 1.0);
    return (nearestCenter + alpha - 0.5) / texSize;
}

void main() {
    vec2 halfSize = rectSize * 0.5;
    vec2 center = pixelCoord - halfSize;

    float maxRadius = min(halfSize.x, halfSize.y);
    vec4 radii = min(cornerRadii, vec4(maxRadius));

    float dist = roundedBoxSDF(center, halfSize, radii);



    float maskAlpha = clamp(0.5 - dist * guiScale, 0.0, 1.0);

    if (maskAlpha < 0.01) {
        discard;
    }

    vec2 texSize = vec2(textureSize(Sampler0, 0));
    vec2 sampleUV = pixelArtUV(texCoord, texSize);


    vec2 uvMin = min(uvBounds.xy, uvBounds.zw) + 0.5 / texSize;
    vec2 uvMax = max(uvBounds.xy, uvBounds.zw) - 0.5 / texSize;
    sampleUV = clamp(sampleUV, uvMin, uvMax);
    vec4 texColor = texture(Sampler0, sampleUV);

    vec3 finalRgb = texColor.rgb * tintColor.rgb;
    float finalAlpha = texColor.a * tintColor.a * maskAlpha;

    fragColor = vec4(finalRgb, finalAlpha);
}
