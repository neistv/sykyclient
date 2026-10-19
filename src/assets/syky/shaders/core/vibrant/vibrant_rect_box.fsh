#version 330

layout(std140) uniform RectBoxData {
    vec4 data[1020];
};

in vec2 pixelCoord;
in vec2 rectSize;
in vec4 cornerRadii;
in float guiScale;
in float thickness;
in float smoothness;
in vec2 fbSize;
flat in int vBase;

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

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715)))) / 255.0;
}


vec3 vibrancy(vec3 c, vec4 backdrop) {
    float fgLuma = dot(c, LUMA_REC709);
    float bgLuma = dot(backdrop.rgb, LUMA_REC709);
    vec3 luminosity = backdrop.rgb + (fgLuma - bgLuma);
    return mix(c, luminosity, backdrop.a * vibrancyWeight(fgLuma));
}

void main() {
    vec2 halfSize = rectSize * 0.5;
    vec2 center = pixelCoord - halfSize;

    vec4 radii = min(cornerRadii, vec4(min(halfSize.x, halfSize.y)));
    float dist = roundedBoxSDF(center, halfSize, radii);



    float outer = clamp(0.5 - dist * guiScale, 0.0, 1.0);
    float aa = max(smoothness, 0.01) / guiScale;
    float inner = min(clamp(0.5 - (dist + thickness) / aa, 0.0, 1.0), outer);

    vec4 fillColor = data[vBase + 3];
    vec4 borderColor = data[vBase + 4];

    vec4 backdrop = texture(Sampler0, gl_FragCoord.xy / fbSize);



    vec3 fillRgb = vibrancy(fillColor.rgb, backdrop) + (dither(gl_FragCoord.xy) - 0.5 / 255.0);
    vec3 borderRgb = vibrancy(borderColor.rgb, backdrop);

    float ringLocalA = borderColor.a + fillColor.a * (1.0 - borderColor.a);
    vec3 ringPremult = borderRgb * borderColor.a + fillRgb * fillColor.a * (1.0 - borderColor.a);
    float ringArea = outer - inner;







    vec2 physicalSize = rectSize * guiScale;
    float subPixel = clamp(physicalSize.x, 0.0, 1.0) * clamp(physicalSize.y, 0.0, 1.0);
    float outA = ringLocalA * ringArea + fillColor.a * inner;
    outA = min(outA, subPixel);
    if (outA < 0.01) {
        discard;
    }
    vec3 outPremult = ringPremult * ringArea + fillRgb * fillColor.a * inner;
    fragColor = vec4(outPremult / outA, outA);
}
