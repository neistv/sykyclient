#version 330

in vec2 texCoord;
in vec4 fragColor_;
in float pxRange;
in vec2 atlasSize;
in vec2 fadeT;
flat in vec2 inkPx;
flat in vec4 outlineRgba;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;








const float SHARPNESS = 1.0;

float median(float r, float g, float b) {
    return max(min(r, g), min(max(r, g), b));
}

float screenPxRange() {
    vec2 unitRange = vec2(pxRange) / atlasSize;
    vec2 screenTexSize = vec2(1.0) / fwidth(texCoord);
    return max(0.5 * dot(unitRange, screenTexSize), 1.0);
}













vec2 tapCoverage(vec2 tc, float range) {
    vec4 texel = texture(Sampler0, tc);
    float fill = range * (median(texel.r, texel.g, texel.b) - 0.5) + inkPx.x;
    float stroke = range * (texel.a - 0.5) + inkPx.x + inkPx.y;
    return clamp(vec2(fill, stroke) * SHARPNESS + 0.5, 0.0, 1.0);
}

void main() {
    float range = screenPxRange();









    vec2 cov = tapCoverage(texCoord, range);





















    cov = sqrt(cov);

    vec2 t = clamp(fadeT, 0.0, 1.0);
    vec2 ramp = t * t * (3.0 - 2.0 * t);
    float edge = ramp.x * ramp.y;

    float fillA = fragColor_.a * cov.x * edge;
    float strokeA = outlineRgba.a * cov.y * edge;




    float outA = fillA + strokeA * (1.0 - fillA);
    if (outA < 0.004) {
        discard;
    }
    vec3 premult = fragColor_.rgb * fillA + outlineRgba.rgb * strokeA * (1.0 - fillA);
    fragColor = vec4(premult / outA, outA);
}
