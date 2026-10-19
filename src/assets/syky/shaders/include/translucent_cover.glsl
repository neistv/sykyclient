// How much of a fragment syky draws over the finished world reaches the eye through the translucent world in front of
// it — water, stained glass, ice, slime, honey, a portal, clouds. See render/world/TranslucentCover: vanilla leaves
// whatever stands behind a translucent surface 1 - a of itself, and this is that 1 - a for a fragment drawn after the
// surface instead of before it.

uniform sampler2D CoverSampler;      // a = how much of the pixel the translucent world covers
uniform sampler2D CoverFrontSampler; // r = the depth of that cover

// The cover at window position `pixel`, in the framebuffer's pixels: x = how much of it the translucent world covers,
// y = that cover's depth — 1.0, the far plane, where there is none.
vec2 coverAt(vec2 pixel) {
    // The coverage may be held at a fraction of the frame's size (Fancy reads it out at half); the depth never is.
    ivec2 frontSize = textureSize(CoverFrontSampler, 0);
    ivec2 coverSize = textureSize(CoverSampler, 0);
    ivec2 at = clamp(ivec2(pixel * vec2(coverSize) / vec2(frontSize)), ivec2(0), coverSize - 1);
    float cover = texelFetch(CoverSampler, at, 0).a;
    if (cover <= 0.0) {
        return vec2(0.0, 1.0);
    }
    return vec2(cover, texelFetch(CoverFrontSampler, clamp(ivec2(pixel), ivec2(0), frontSize - 1), 0).r);
}

// A depth read at window position `pixel` out of a texture that may be held at a fraction of the frame's size — the
// depth behind the cover is, on a frame only Fog or Motion Blur reads it.
float coverDepthAt(sampler2D depth, vec2 pixel) {
    ivec2 size = textureSize(depth, 0);
    ivec2 at = ivec2(pixel * vec2(size) / vec2(textureSize(CoverFrontSampler, 0)));
    return texelFetch(depth, clamp(at, ivec2(0), size - 1), 0).r;
}

// The share of a fragment at window position `pixel` and depth `z` that shows: 1 in front of the cover or where there
// is none, 1 - coverage behind it.
float coverShow(vec2 pixel, float z) {
    vec2 cover = coverAt(pixel);
    return z > cover.y ? 1.0 - cover.x : 1.0;
}
