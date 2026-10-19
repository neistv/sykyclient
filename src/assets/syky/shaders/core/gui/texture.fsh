#version 330

in vec2 fragCoord;
in vec2 pixelCoord;
in vec2 texCoord;
in vec2 rectSize;
in vec4 cornerRadii;
in vec4 tintColor;
in float guiScale;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;





const float ICON_EDGE_PX = 1.5;

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

// >>> minify-patch:box — keep every copy byte-identical (MinifyPatchLockstepTest).











vec4 sampleFootprint(vec2 uv, vec2 duv, float minify) {
    if (minify <= 1.0) {
        return texture(Sampler0, uv);
    }
    vec2 q = 0.25 * duv;
    vec4 a = texture(Sampler0, uv + vec2(-q.x, -q.y));
    vec4 b = texture(Sampler0, uv + vec2(q.x, -q.y));
    vec4 c = texture(Sampler0, uv + vec2(-q.x, q.y));
    vec4 d = texture(Sampler0, uv + vec2(q.x, q.y));
    float alpha = 0.25 * (a.a + b.a + c.a + d.a);
    vec3 rgb = 0.25 * (a.rgb * a.a + b.rgb * b.a + c.rgb * c.a + d.rgb * d.a);
    return vec4(rgb / max(alpha, 1e-4), alpha);
}
// <<< minify-patch:box


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

    vec2 duv = fwidth(texCoord);
    vec2 texelsPerPixel = duv * vec2(textureSize(Sampler0, 0));
    float minify = max(texelsPerPixel.x, texelsPerPixel.y);
    vec4 texColor = sampleFootprint(texCoord, duv, minify);













    float ta = texColor.a;
    if (minify <= 1.0) {
        float band = min(fwidth(ta) * ICON_EDGE_PX, 1.0);
        ta = band > 1e-4 ? clamp((ta - 0.5) / band + 0.5, 0.0, 1.0) : ta;
    }


    vec3 finalRgb = texColor.rgb * tintColor.rgb;
    float finalAlpha = ta * tintColor.a * maskAlpha;

    fragColor = vec4(finalRgb, finalAlpha);
}
