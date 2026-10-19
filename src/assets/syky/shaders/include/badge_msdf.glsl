#version 330

// Coverage of the syky badge at this fragment, from its MTSDF atlas (textures/badge/syky_msdf.png, baked by
// tools/msdf/bake_badge.py). The edge is resolved per fragment from the field, so the badge is exactly as
// sharp at 8 GUI px as on a 4K nametag a block away, with no mip level or pixel grid behind it.
//
// The filter is the one the MSDF text uses (core/gui/msdf.fsh, which explains both choices at length): a
// one-pixel box, and a square-root correction of the coverage for the gamma-encoded blend, so the badge's
// edge weighs the same as the letters beside it.

// Must equal the bake's -pxrange and BadgeGlyph.PX_RANGE.
const float BADGE_PX_RANGE = 20.0;

float badge_median(vec3 c) {
    return max(min(c.r, c.g), min(max(c.r, c.g), c.b));
}

float badge_coverage(sampler2D atlas, vec2 uv) {
    vec2 unitRange = vec2(BADGE_PX_RANGE) / vec2(textureSize(atlas, 0));
    vec2 screenTexSize = vec2(1.0) / fwidth(uv);
    float screenPxRange = max(0.5 * dot(unitRange, screenTexSize), 1.0);
    float distance = badge_median(texture(atlas, uv).rgb) - 0.5;
    return sqrt(clamp(screenPxRange * distance + 0.5, 0.0, 1.0));
}
