#version 330




in vec2 pixelCoord;
in vec2 rectSize;
in vec4 cornerRadii;
in vec4 fragColors[8];
in float fragThicknesses[8];
in float fragSmoothness;
in float guiScale;
in vec2 fbSize;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;




const vec3 LUMA_REC709 = vec3(0.2126, 0.7152, 0.0722);












const float VIBRANCY_LUMA_LO = 0.08;
const float VIBRANCY_LUMA_HI = 0.45;

float vibrancyWeight(float fgLuma) {
    return smoothstep(VIBRANCY_LUMA_LO, VIBRANCY_LUMA_HI, fgLuma);
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
    vec2 halfSize = rectSize * 0.5;
    vec2 center = pixelCoord - halfSize;

    float maxRadius = min(halfSize.x, halfSize.y);
    vec4 radii = min(cornerRadii, vec4(maxRadius));

    float dist = roundedBoxSDF(center, halfSize, radii);

    vec4 outlineColor = fragColors[0];
    float thickness = fragThicknesses[0];



    float aa = max(fragSmoothness, 0.01) / guiScale;
    float outerCoverage = clamp(0.5 - dist / aa, 0.0, 1.0);
    float innerCoverage = clamp(0.5 - (dist + thickness) / aa, 0.0, 1.0);
    float outlineMask = outerCoverage - innerCoverage;

    if (outlineMask < 0.01) {
        discard;
    }

    vec2 screenUV = gl_FragCoord.xy / fbSize;
    vec4 bd = texture(Sampler0, screenUV);
    vec3 backdrop = bd.rgb;

    float fgLuma = dot(outlineColor.rgb, LUMA_REC709);
    float bgLuma = dot(backdrop, LUMA_REC709);
    vec3 luminosity = backdrop + (fgLuma - bgLuma);
    vec3 vibrant = mix(outlineColor.rgb, luminosity, bd.a * vibrancyWeight(fgLuma));

    fragColor = vec4(vibrant, outlineColor.a * outlineMask);
}
