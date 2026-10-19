#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;
uniform sampler2D Sampler2;
uniform sampler2D Sampler3;
uniform sampler2D Sampler4;
uniform sampler2D Sampler5;
uniform sampler2D Sampler6;
uniform sampler2D Sampler7;
uniform sampler2D Sampler8;
uniform sampler2D Sampler9;
uniform sampler2D Sampler10;
uniform sampler2D Sampler11;








// >>> wet-shared:ubo
layout(std140) uniform WetParams {
    mat4 InvViewProj;
    mat4 ViewProj;
    vec4 Anchor;
    vec4 Column;
    vec4 Wet;
    vec4 Look;
    vec4 March;
    vec4 Screen;
    vec4 Frame;
    vec4 SkyZenith;
    vec4 SkyGlow;
    vec4 SunDir;
};

layout(std140) uniform Fog {
    vec4 FogColor;
    float FogEnvironmentalStart;
    float FogEnvironmentalEnd;
    float FogRenderDistanceStart;
    float FogRenderDistanceEnd;
    float FogSkyEnd;
    float FogCloudsEnd;
};
// <<< wet-shared:ubo

// >>> wet-shared:geometry
vec3 positionFromDepth(vec2 uv, float depth) {
    vec4 pos = InvViewProj * vec4(uv * 2.0 - 1.0, depth * 2.0 - 1.0, 1.0);
    return pos.xyz / pos.w;
}



float sceneW(vec2 ndc, float depth) {
    vec4 row = vec4(InvViewProj[0][3], InvViewProj[1][3], InvViewProj[2][3], InvViewProj[3][3]);
    return 1.0 / dot(row, vec4(ndc, depth * 2.0 - 1.0, 1.0));
}

ivec2 framePixel(vec2 uv) {
    return clamp(ivec2(uv * Frame.xy), ivec2(0), ivec2(Frame.xy) - 1);
}




bool surfaceAt(ivec2 px, out vec3 pos, out vec3 normal) {
    float depth = texelFetch(Sampler1, px, 0).r;
    if (depth >= 1.0) {
        return false;
    }
    ivec2 last = ivec2(Frame.xy) - 1;


    vec4 h = InvViewProj * vec4((vec2(px) + 0.5) * Frame.zw * 2.0 - 1.0, depth * 2.0 - 1.0, 1.0);
    pos = h.xyz / h.w;

    ivec2 l = ivec2(max(px.x - 1, 0), px.y);
    ivec2 r = ivec2(min(px.x + 1, last.x), px.y);
    ivec2 d = ivec2(px.x, max(px.y - 1, 0));
    ivec2 u = ivec2(px.x, min(px.y + 1, last.y));
    float dl = texelFetch(Sampler1, l, 0).r;
    float dr = texelFetch(Sampler1, r, 0).r;
    float dd = texelFetch(Sampler1, d, 0).r;
    float du = texelFetch(Sampler1, u, 0).r;

    bool left = px.x == last.x || (px.x > 0 && abs(dl - depth) < abs(dr - depth));
    bool down = px.y == last.y || (px.y > 0 && abs(dd - depth) < abs(du - depth));
    float sx = left ? -1.0 : 1.0;
    float sy = down ? -1.0 : 1.0;
    vec4 hx = h + InvViewProj[0] * (2.0 * Frame.z * sx) + InvViewProj[2] * (2.0 * ((left ? dl : dr) - depth));
    vec4 hy = h + InvViewProj[1] * (2.0 * Frame.w * sy) + InvViewProj[2] * (2.0 * ((down ? dd : du) - depth));
    vec3 ddx = (hx.xyz / hx.w - pos) * sx;
    vec3 ddy = (hy.xyz / hy.w - pos) * sy;

    vec3 n = cross(ddx, ddy);
    float len = length(n);
    if (len < 1.0e-12) {
        return false;
    }
    n /= len;
    normal = dot(n, pos) > 0.0 ? -n : n;
    return true;
}
// <<< wet-shared:geometry

// >>> wet-shared:exposure
const float EXPOSURE_SIZE = 512.0;



const float EXPOSURE_REACH = 240.0;


const int LEAF_TOP = 2;
const int COVERED = 4;
const int WATER_TOP = 8;
const int SOIL_TOP = 16;



vec4 columnAt(vec2 offset) {
    vec2 cell = floor(Column.zw + offset);
    if (max(abs(cell.x), abs(cell.y)) > EXPOSURE_REACH) {
        return vec4(0.0);
    }
    ivec4 v = ivec4(texelFetch(Sampler2, ivec2(mod(Column.xy + cell, EXPOSURE_SIZE)), 0) * 255.0 + 0.5);
    if ((v.b & 1) == 0) {
        return vec4(0.0);
    }
    return vec4(float(v.r + ((v.g & 15) << 8)), float(v.b), 0.0, 1.0);
}







vec4 exposureAt(vec2 offset, float height) {
    vec4 column = columnAt(offset);
    vec2 cell = floor(Column.zw + offset);
    vec4 soft = max(abs(cell.x), abs(cell.y)) > EXPOSURE_REACH
            ? vec4(0.0, 0.0, 1.0, 1.0)
            : textureLod(Sampler3, (Column.xy + Column.zw + offset) / EXPOSURE_SIZE, 0.0);
    bool onTop = column.w == 0.0 || height > column.x - 0.97;
    int flags = int(column.y);
    bool water = (flags & WATER_TOP) != 0;
    if (water && !onTop) {
        return vec4(0.0);
    }
    float covered = (flags & COVERED) != 0 ? 1.0 : 0.0;
    float shelter = (onTop ? soft.r * (1.0 - covered) : max(soft.r, soft.g)) * Look.z;
    return vec4(
            1.0 - shelter,
            !onTop ? 0.0 : (flags & LEAF_TOP) != 0 ? 1.0 : (flags & SOIL_TOP) != 0 ? 2.0 : 0.0,
            soft.a,
            onTop && water ? 1.0 : 0.0);
}




float soilAt(vec2 offset) {
    vec2 p = Column.zw + offset - 0.5;
    vec2 cell = floor(p);
    vec2 f = p - cell;
    float soil = 0.0;
    float weight = 0.0;
    for (int j = 0; j <= 1; j++) {
        for (int i = 0; i <= 1; i++) {
            vec4 column = columnAt(cell + vec2(i, j) + 0.5 - Column.zw);
            int flags = int(column.y);
            if (column.w == 0.0 || (flags & COVERED) != 0) {
                continue;
            }
            float w = (i == 1 ? f.x : 1.0 - f.x) * (j == 1 ? f.y : 1.0 - f.y) + 1.0e-3;
            soil += (flags & SOIL_TOP) != 0 ? w : 0.0;
            weight += w;
        }
    }
    return weight > 0.0 ? soil / weight : 0.0;
}




bool onWater(vec3 pos) {
    vec4 column = columnAt(pos.xz);
    return column.w > 0.0 && (int(column.y) & WATER_TOP) != 0 && Anchor.y + pos.y > column.x - 0.97;
}
// <<< wet-shared:exposure

// >>> wet-shared:field



const float NOISE_PERIOD = 2048.0;


const float COARSE_SPAN = 256.0;
const float FINE_SPAN = 32.0;




vec4 fieldsAt(vec2 world, float footprint) {
    vec4 coarse = textureLod(Sampler11, world / COARSE_SPAN, log2(max(footprint, 1.0)));
    vec4 fine = textureLod(Sampler11, world / FINE_SPAN, log2(max(footprint * 8.0, 1.0)));
    float basins = (coarse.r - 0.5) * 2.0 + 0.2 * (fine.g - 0.5) * 2.0;
    return vec4(
            clamp(basins * 1.3 + 0.5, 0.0, 1.0),
            clamp((fine.r - 0.5) * 2.4 + 0.5, 0.0, 1.0),
            (fine.ba - 0.5) * 4.0);
}







const float RIPPLE_CELL = 0.64;
const int RIPPLE_LAYERS = 8;
const float RIPPLE_LIFE = 0.6;
const float RIPPLE_WAVELENGTH = 0.1;



const float RIPPLE_SLOPE = 0.12;


const float RIPPLE_TILE_CELLS = 4.0;
const float RIPPLE_TILE_PX = 160.0;
const float RIPPLE_GUTTER = 1.0;
const float RIPPLE_SLOT_PX = 162.0;
const float RIPPLE_GRID = 7.0;
const float RIPPLE_FRAMES = 49.0;
const float RIPPLE_LOOP = 2.0;
const float RIPPLE_ATLAS_PX = 1134.0;
const float RIPPLE_RANGE = 2.0;


vec2 bakedRipples(vec2 tile, float time, float pace) {
    float t = fract(time * pace / (RIPPLE_LIFE * RIPPLE_LOOP)) * RIPPLE_FRAMES;
    float frame = floor(t);
    vec2 slot = vec2(mod(frame, RIPPLE_GRID), floor(frame / RIPPLE_GRID)) * RIPPLE_SLOT_PX;
    vec4 s = textureLod(Sampler10, (slot + RIPPLE_GUTTER + fract(tile) * RIPPLE_TILE_PX) / RIPPLE_ATLAS_PX, 0.0);

    return (mix(s.rg, s.ba, t - frame) * 255.0 - 128.0) * (RIPPLE_RANGE / 127.0);
}

vec2 rippleSlope(vec2 w, float time, float drops) {
    vec2 p = w / (RIPPLE_CELL * RIPPLE_TILE_CELLS);
    vec2 slope = vec2(0.0);
    for (int i = 0; i < RIPPLE_LAYERS; i++) {
        float amount = min(drops - float(i), 1.0);
        if (amount <= 0.0) {
            break;
        }

        int turn = i - (i / 4) * 4;
        vec2 q = p + fract(float(i) * vec2(0.618034, 0.381966));
        vec2 r = turn == 0 ? q : turn == 1 ? vec2(q.y, -q.x) : turn == 2 ? -q : vec2(-q.y, q.x);
        vec2 s = bakedRipples(r, time + float(i) * 0.37, 1.0 + 0.06 * float(i));
        s = turn == 0 ? s : turn == 1 ? vec2(-s.y, s.x) : turn == 2 ? -s : vec2(s.y, -s.x);
        slope += s * amount;
    }
    return slope * RIPPLE_SLOPE;
}
// <<< wet-shared:field

// >>> wet-shared:material


const float DAMP_SHEEN = 0.65;


const float WALL_DAMP = 0.5;


const float PUDDLE_ROUGHNESS = 0.02;



const float PUDDLE_SWELL = 0.02;


const float WATER_SWELL = 0.04;
const vec2 WATER_DRIFT = vec2(0.23, 0.17);


const float DAMP_RINGS = 0.6;





const float SOAK_WIDTH = 0.015;
const float SOAK = 1.3;
const float SOAK_ROUGHNESS = 0.14;


const float POOL_DEPTH = 0.3;



const float ROUGH_TRACE = 0.12;






const float WATER_F0 = 0.03;



const float FILM_F0 = 0.05;


const float REFLECTION_GAIN = 1.3;




const float TRACE_WORTH = 0.035;

float fresnel(float nDotV, float roughness, float f0) {
    float peak = max(1.0 - roughness, f0);
    return f0 + (peak - f0) * pow(1.0 - nDotV, 5.0);
}



float reflectance(float nDotV, float roughness, float pool, float damp) {
    return mix(fresnel(nDotV, roughness, FILM_F0) * DAMP_SHEEN * damp, fresnel(nDotV, roughness, WATER_F0), pool);
}





bool worthTracing(vec4 mat, vec3 view) {
    float amount = Look.x * REFLECTION_GAIN * reflectance(max(-view.y, 0.0), mat.z, mat.x, mat.y) * mat.w;
    return amount >= TRACE_WORTH || mat.x * mat.w > 0.002;
}



float footprintAt(vec3 pos, float dist) {
    return dist / (March.w * sqrt(max(abs(pos.y) / dist, 0.05)));
}





vec4 wetMaterial(vec3 pos, vec3 normal, out vec2 world, out vec2 swell, out vec2 bed) {
    world = Anchor.xz + pos.xz;
    swell = vec2(0.0);
    bed = vec2(0.0);
    float up = smoothstep(0.94, 0.985, normal.y);

    vec2 offset = pos.xz + normal.xz * 0.5;
    float height = Anchor.y + pos.y;
    vec4 open = exposureAt(offset, height + 0.02 * normal.y);
    if (Wet.w > 0.5) {

        if (open.w == 0.0 || up <= 0.0) {
            return vec4(0.0);
        }
        vec2 drifting = world * 0.5 + WATER_DRIFT * Anchor.w;
        swell = fieldsAt(drifting, footprintAt(pos, length(pos)) * 0.5).zw;
        return vec4(up, 0.0, PUDDLE_ROUGHNESS, up);
    }
    if (open.x <= 0.004 || open.w > 0.0) {
        return vec4(0.0);
    }


    float square = smoothstep(0.9, 0.97, max(max(abs(normal.x), abs(normal.z)), normal.y));
    vec4 fields = fieldsAt(world, footprintAt(pos, length(pos)));
    swell = fields.zw;

    float film = mix(0.55, 1.0, fields.y);
    float canopy = open.y == 1.0 ? 1.0 : 0.0;





    float pool = 0.0;
    float soak = 0.0;
    if (Wet.x > 0.0 && up > 0.0 && canopy == 0.0) {
        float soil = soilAt(offset);
        float cover = Wet.x * mix(1.0, mix(0.65, 1.0, Wet.x * Wet.x), soil);
        float threshold = mix(1.0, -0.05, cover);
        float standing = up * smoothstep(0.75, 0.95, open.x) * smoothstep(0.4, 0.6, open.z);
        pool = standing * smoothstep(threshold, threshold + 0.02, fields.x);
        soak = standing * smoothstep(threshold - SOAK_WIDTH, threshold + 0.005, fields.x);
        bed = vec2(smoothstep(threshold, threshold + POOL_DEPTH, fields.x), soil);
    }
    float damp = open.x * mix(film, SOAK, soak) * mix(WALL_DAMP, 1.0, up) * mix(1.0, 0.7, canopy) * square;
    float roughness = mix(mix(mix(0.44, 0.2, fields.y), SOAK_ROUGHNESS, soak), PUDDLE_ROUGHNESS, pool);
    return vec4(pool, damp, roughness, up);
}



float ringsOn(vec4 mat) {
    return max(mat.x, DAMP_RINGS * mat.y) * mat.w;
}






vec3 waterNormal(vec2 world, vec2 swell, float footprint, float pool, float rings) {
    if (pool <= 0.001 && rings <= 0.001) {
        return vec3(0.0, 1.0, 0.0);
    }
    vec2 s = swell * (Wet.w > 0.5 ? WATER_SWELL : PUDDLE_SWELL) * pool;
    float depth = rings * Wet.y * step(0.001, Wet.z)
            * (1.0 - smoothstep(0.35, 0.9, footprint / (RIPPLE_WAVELENGTH * RIPPLE_CELL)));
    if (depth > 0.001) {
        s += rippleSlope(world, Anchor.w, float(RIPPLE_LAYERS) * Wet.z) * depth;
    }
    return normalize(vec3(-s.x, 1.0, -s.y));
}



vec3 reflectedRay(vec3 view, vec3 n) {
    vec3 dir = reflect(view, n);
    return normalize(vec3(dir.x, max(dir.y, 0.02), dir.z));
}
// <<< wet-shared:material

// >>> wet-shared:light

float fogOf(float spherical, float cylindrical) {
    float environment = clamp((spherical - FogEnvironmentalStart)
            / max(FogEnvironmentalEnd - FogEnvironmentalStart, 1.0e-3), 0.0, 1.0);
    float distance = clamp((cylindrical - FogRenderDistanceStart)
            / max(FogRenderDistanceEnd - FogRenderDistanceStart, 1.0e-3), 0.0, 1.0);
    return max(environment, distance) * FogColor.a;
}



float fogAt(vec3 pos) {
    return fogOf(length(pos), max(length(pos.xz), abs(pos.y)));
}

vec3 levelAt(int level, vec2 uv) {
    if (level <= 0) return textureLod(Sampler0, uv, 0.0).rgb;
    if (level == 1) return textureLod(Sampler5, uv, 0.0).rgb;
    if (level == 2) return textureLod(Sampler6, uv, 0.0).rgb;
    if (level == 3) return textureLod(Sampler7, uv, 0.0).rgb;
    if (level == 4) return textureLod(Sampler8, uv, 0.0).rgb;
    if (level == 5) return textureLod(Sampler9, uv, 0.0).rgb;


    vec2 o = 1.0 / vec2(textureSize(Sampler9, 0));
    return 0.25 * (textureLod(Sampler9, uv + vec2(-o.x, -o.y), 0.0).rgb
            + textureLod(Sampler9, uv + vec2(o.x, -o.y), 0.0).rgb
            + textureLod(Sampler9, uv + vec2(-o.x, o.y), 0.0).rgb
            + textureLod(Sampler9, uv + vec2(o.x, o.y), 0.0).rgb);
}



vec3 pyramid(vec2 uv, float lod) {
    float l = clamp(lod, 0.0, SkyZenith.w);
    int i = int(l);
    float f = l - float(i);
    vec3 c = levelAt(i, uv);
    return f < 0.01 ? c : mix(c, levelAt(i + 1, uv), f);
}










vec3 skyModel(vec3 d) {
    float up = max(d.y, 0.0);
    float distance = 16.0 + 15.5 * length(d.xz) / max(up, 1.0e-3);
    float end = max(FogSkyEnd, 1.0);
    vec3 sky = mix(SkyZenith.rgb, FogColor.rgb, distance >= end ? 1.0 : distance / end);
    float facing = normalize(d.xz + vec2(1.0e-5, 0.0)).x * (SunDir.x > 0.0 ? 1.0 : -1.0);
    float band = max(1.0 - length(vec2(1.0 - facing, up / (0.32 * max(SkyGlow.a, 0.05)))), 0.0);
    return mix(sky, SkyGlow.rgb, SkyGlow.a * band);
}

float edgeFade(vec2 uv) {
    vec2 e = smoothstep(vec2(0.0), vec2(0.07), uv) * smoothstep(vec2(0.0), vec2(0.07), 1.0 - uv);
    return e.x * e.y;
}




vec3 missColour(vec3 dir, float roughness) {
    vec3 model = skyModel(dir);
    vec4 clip = ViewProj * vec4(dir, 0.0);
    if (clip.w <= 1.0e-4) {
        return model;
    }
    vec2 uv = clip.xy / clip.w * 0.5 + 0.5;
    if (uv.x <= 0.0 || uv.x >= 1.0 || uv.y <= 0.0 || uv.y >= 1.0) {
        return model;
    }
    if (texelFetch(Sampler1, framePixel(uv), 0).r < 1.0) {
        return model;
    }
    return mix(model, pyramid(uv, 1.0 + roughness * 3.0), edgeFade(uv));
}



const float CONE_SPREAD = 0.5;



const float GRAZING_STRETCH = 3.0;





const float LIGHT_GAIN = 4.0;
const int LIGHT_LEVEL = 4;

vec3 lightsUp(vec3 c, vec2 uv, float depth) {
    if (depth >= 1.0) {
        return c;
    }
    vec3 a = levelAt(LIGHT_LEVEL, uv);
    float peak = max(max(c.r, c.g), c.b);
    float around = max(max(a.r, a.g), max(a.b, 0.03));
    return c * (1.0 + LIGHT_GAIN * smoothstep(0.6, 0.9, peak) * smoothstep(1.6, 3.0, peak / around));
}

vec3 gather(vec2 uv, float lod, float stretchPx) {
    if (stretchPx < 0.5) {
        return pyramid(uv, lod);
    }
    vec2 dy = vec2(0.0, stretchPx * Frame.w);
    vec3 c = pyramid(uv, lod) * 0.4;
    c += pyramid(clamp(uv + dy, 0.0, 1.0), lod) * 0.3;
    c += pyramid(clamp(uv - dy, 0.0, 1.0), lod) * 0.3;
    return c;
}




vec3 resolveHit(vec3 pos, vec2 uv, vec3 dir, float roughness, float nDotV) {
    float depth = texelFetch(Sampler1, framePixel(uv), 0).r;
    vec3 target = positionFromDepth(uv, depth);
    float travelled = length(target - pos);
    float cone = travelled * tan(min(roughness * CONE_SPREAD, 1.2));
    float px = cone * March.w / sceneW(uv * 2.0 - 1.0, depth);
    vec3 hit = lightsUp(gather(uv, log2(max(px, 1.0)), px * GRAZING_STRETCH * pow(1.0 - nDotV, 3.0)), uv, depth);



    float direct = fogAt(target);
    float path = length(pos) + travelled;
    hit = mix(hit, FogColor.rgb, clamp((fogOf(path, path) - direct) / max(1.0 - direct, 1.0e-3), 0.0, 1.0));

    float fade = edgeFade(uv) * (1.0 - smoothstep(0.8, 1.0, travelled / March.y));
    return fade >= 0.999 ? hit : mix(missColour(dir, roughness), hit, fade);
}
// <<< wet-shared:light


vec2 screenOf(vec3 dir) {
    vec4 clip = ViewProj * vec4(dir, 0.0);
    return clip.w <= 1.0e-4 ? vec2(-1.0) : clip.xy / clip.w * 0.5 + 0.5;
}



void main() {
    ivec2 texel = ivec2(gl_FragCoord.xy);
    ivec2 px = texel * 2;
    vec2 uv = (vec2(px) + 1.0) * Frame.zw;
    vec3 light = texelFetch(Sampler4, texel, 0).rgb;
    fragColor = vec4(0.0);

    if (max(light.r, max(light.g, light.b)) < 0.002) {
        return;
    }
    vec3 pos;
    vec3 normal;
    if (!surfaceAt(px, pos, normal)) {
        return;
    }
    vec2 world;
    vec2 swell;
    vec4 mat;
    bool water = onWater(pos);
    if (water) {
        world = Anchor.xz + pos.xz;
        float up = smoothstep(0.94, 0.985, normal.y);
        swell = fieldsAt(world * 0.5 + WATER_DRIFT * Anchor.w, footprintAt(pos, length(pos)) * 0.5).zw;
        mat = vec4(up, 0.0, PUDDLE_ROUGHNESS, up);
    } else {
        vec2 bed;
        mat = wetMaterial(pos, normal, world, swell, bed);
    }
    if (mat.w <= 0.0 || max(mat.x, mat.y) <= 0.002) {
        return;
    }
    float dist = length(pos);
    vec3 view = pos / dist;
    float footprint = footprintAt(pos, dist);
    vec3 still = waterNormal(world, swell, footprint, mat.x, 0.0);
    vec3 n = waterNormal(world, swell, footprint, mat.x, water ? mat.x : ringsOn(mat));

    if (n != still) {
        vec2 a = screenOf(reflectedRay(view, still));
        vec2 b = screenOf(reflectedRay(view, n));
        if (a.x >= 0.0 && b.x >= 0.0) {
            light = textureLod(Sampler4, clamp(uv + b - a, vec2(0.0), vec2(1.0)), 0.0).rgb;
        }
    }
    float nDotV = max(dot(n, -view), 0.0);
    float shown = water ? fresnel(nDotV, mat.z, WATER_F0) : reflectance(nDotV, mat.z, mat.x, mat.y) * mat.w;
    float amount = clamp(Look.x * REFLECTION_GAIN * shown, 0.0, 1.0) * (1.0 - fogAt(pos));
    fragColor = vec4(light * amount, 1.0);
}
