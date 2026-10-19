// The light effects of syky cosmetics. One function per effect, chosen by the material's type code
// (cosmetics/model/FxType): adding an effect is a branch here and a constant there, nothing else.
//
// Everything returned is light: added to the frame, never blended over it, so an effect can only brighten.

struct FxParams {
    int type;
    vec3 color;
    vec3 secondary;
    float intensity;
    float speed;
    float scale;
};

// Decodes one material's row of the palette texture. The layout is written by CosmeticPalette.add.
FxParams fx_params(sampler2D palette, int row) {
    vec4 a = texelFetch(palette, ivec2(0, row), 0);
    vec4 b = texelFetch(palette, ivec2(1, row), 0);
    vec4 c = texelFetch(palette, ivec2(2, row), 0);
    FxParams p;
    p.type = int(a.a * 255.0 + 0.5);
    p.color = a.rgb;
    p.secondary = b.rgb;
    p.intensity = b.a * 4.0;
    p.speed = c.r * 16.0 - 8.0;
    p.scale = exp2(c.g * 8.0 - 3.0);
    return p;
}

float fx_hash(vec2 p) {
    return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453);
}

float fx_noise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    vec2 u = f * f * (3.0 - 2.0 * f);
    return mix(mix(fx_hash(i), fx_hash(i + vec2(1.0, 0.0)), u.x),
               mix(fx_hash(i + vec2(0.0, 1.0)), fx_hash(i + vec2(1.0, 1.0)), u.x), u.y);
}

float fx_fbm(vec2 p) {
    float v = 0.0;
    float a = 0.5;
    for (int i = 0; i < 4; i++) {
        v += a * fx_noise(p);
        p = p * 2.03 + 17.0;
        a *= 0.5;
    }
    return v;
}

vec3 fx_hue(float h) {
    return clamp(abs(fract(h + vec3(0.0, 2.0 / 3.0, 1.0 / 3.0)) * 6.0 - 3.0) - 1.0, 0.0, 1.0);
}

// tex: the material's texel (its alpha is the effect's mask). local: the vertex's rest position in its
// anchor's space, in blocks, so a pattern sticks to the model as it moves. n, v: unit normal and direction
// to the eye, in view space. t: seconds.
vec3 cosmetic_fx(FxParams p, vec4 tex, vec2 local, vec3 n, vec3 v, float t) {
    float lum = dot(tex.rgb, vec3(0.299, 0.587, 0.114));
    float facing = abs(dot(n, v));
    float time = t * p.speed;
    vec3 light;
    if (p.type == 1) {
        // Hologram: a rim that brightens toward the silhouette, scanlines rolling along the model, flicker.
        float rim = pow(1.0 - facing, 2.0);
        float lines = smoothstep(0.35, 1.0, 0.5 + 0.5 * sin(local.y * 64.0 * p.scale + time * 6.0));
        float flicker = 0.92 + 0.08 * sin(time * 37.0) * sin(time * 13.0 + 1.7);
        light = p.color * (0.18 * lum + 0.9 * rim + 0.35 * lines) * flicker;
    } else if (p.type == 2) {
        // Energy: two octaves of drifting noise, the second warped by the first, so it flows rather than scrolls.
        vec2 q = local * 6.0 * p.scale;
        float n1 = fx_fbm(q + vec2(time * 0.35, -time * 0.8));
        float n2 = fx_fbm(q * 1.7 - vec2(time * 0.6, time * 0.25) + n1);
        float e = smoothstep(0.35, 0.95, n2);
        light = mix(p.color, p.secondary, n1) * (0.25 + 1.6 * e * e);
    } else if (p.type == 3) {
        // Foil: thin-film colour, its hue turning with the angle it is seen from and across the surface.
        float h = (1.0 - facing) * 0.9 + (local.x + local.y) * p.scale * 1.5 + time * 0.05;
        float sheen = pow(1.0 - facing, 1.5) * 0.8 + 0.2;
        light = fx_hue(h) * sheen * (0.35 + 0.65 * lum);
    } else if (p.type == 4) {
        // Shimmer: a narrow band sweeping diagonally across the model, then a pause before the next.
        float sweep = fract(time * 0.2) * 3.0 - 1.0;
        float d = (local.x * 0.6 - local.y * 0.8) * p.scale - sweep;
        light = mix(p.color, vec3(1.0), 0.3) * exp(-d * d * 60.0);
    } else {
        // Glow: the texture lit from within, breathing.
        float pulse = 0.85 + 0.15 * sin(time * 6.2831853);
        light = p.color * tex.rgb * pulse;
    }
    return light * p.intensity * tex.a;
}
