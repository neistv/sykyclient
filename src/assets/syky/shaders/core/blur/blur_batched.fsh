#version 330






in vec2 fragCoord;
in vec2 pixelCoord;
in vec2 texCoord;
in vec2 rectSize;
in vec4 cornerRadii;
in vec4 tintColor;
in float guiScale;
in float saturation;
in float opacity;
in float edgeSigma;
in float glow;
in float tone;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;


const vec3 LUMA_REC709 = vec3(0.2126, 0.7152, 0.0722);





const float GLOW_SATURATION = 1.6;
const float GLOW_LUMA = 0.72;






const float TONE_MID_LUMA = 0.5;

vec3 toned(vec3 tint, float luma) {
    vec3 c = tint * (luma / TONE_MID_LUMA);
    float peak = max(max(c.r, c.g), c.b);
    return peak > 1.0 ? c / peak : c;
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










float edgeCoverage(float d, float pxPerUnit, float soft) {
    if (soft <= 0.0) {
        return clamp(0.5 - d * pxPerUnit, 0.0, 1.0);
    }
    float band = max(2.5066283 * soft, 1.0 / pxPerUnit);
    return clamp(0.5 - d / band, 0.0, 1.0);
}

void main() {
    vec2 halfSize = rectSize * 0.5;
    vec2 center = pixelCoord - halfSize;

    float maxRadius = min(halfSize.x, halfSize.y);
    vec4 r = min(cornerRadii, vec4(maxRadius));

    float dist = roundedBoxSDF(center, halfSize, r);


    float maskAlpha = edgeCoverage(dist, guiScale, edgeSigma);

    if (maskAlpha < 0.01) {
        discard;
    }

    vec4 blurred = texture(Sampler0, texCoord);

    float luma = dot(blurred.rgb, LUMA_REC709);
    blurred.rgb = mix(vec3(luma), blurred.rgb, saturation);

    vec3 paint = tone > 0.5 ? toned(tintColor.rgb, luma) : tintColor.rgb;
    vec3 finalRgb = mix(blurred.rgb, paint, tintColor.a);

    if (glow > 0.0) {
        vec3 vivid = mix(vec3(luma), blurred.rgb, GLOW_SATURATION);
        vec3 lit = clamp(vivid + (GLOW_LUMA - luma), 0.0, 1.0);
        finalRgb = mix(finalRgb, lit, glow);
    }

    float n = fract(52.9829189 * fract(dot(gl_FragCoord.xy, vec2(0.06711056, 0.00583715)))) - 0.5;
    finalRgb += n / 255.0;

    fragColor = vec4(finalRgb, maskAlpha * opacity);
}
