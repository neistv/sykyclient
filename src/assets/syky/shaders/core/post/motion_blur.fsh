#version 330

#moj_import <syky:translucent_cover.glsl>

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;
uniform sampler2D CoverBackSampler;
#ifdef HALF_LONG
uniform sampler2D HalfSampler;
uniform sampler2D LowSampler;
#endif
#ifdef SHIELD
uniform sampler2D EntitySampler;
#endif

layout(std140) uniform MotionBlurParams {
    mat4 InvViewProj;
    mat4 PrevView;
    mat4 PrevProj;
    vec4 CamDelta;
    vec4 Params;
    vec4 Screen;
    vec4 Mask;

};


const float NEAR = 0.05;



const float SPACING = 1.0;





const float HALF_FROM = 8.0;
const float HALF_FULL = 14.0;







float ign(vec2 p) {
    return fract(52.9829189 * fract(dot(p, vec2(0.06711056, 0.00583715))));
}

#ifdef SHIELD


bool entityAt(vec2 uv) {
    return texture(EntitySampler, uv).r > 0.5;
}
#endif



vec2 velocityAt(float raw, out bool valid) {



    float depth = min(raw, 0.999999);
    vec3 ndc = vec3(texCoord * 2.0 - 1.0, depth * 2.0 - 1.0);

    vec4 p = InvViewProj * vec4(ndc, 1.0);
    if (abs(p.w) < 1.0e-9) {
        valid = false;
        return vec2(0.0);
    }
    vec3 posRel = p.xyz / p.w;










    vec4 viewPrev = PrevView * vec4(posRel + CamDelta.xyz, 1.0);
    viewPrev.z = min(viewPrev.z, -NEAR);

    vec4 clipPrev = PrevProj * viewPrev;
    vec2 uvPrev = (clipPrev.xy / clipPrev.w) * 0.5 + 0.5;

    valid = true;
    return (texCoord - uvPrev) * Screen.xy * Params.x;
}









float split(float lenPx, out int shortTaps, out int longTaps) {
    float most = Params.y;


    float ideal = max(sqrt(lenPx * SPACING), SPACING);
    longTaps = int(clamp(ceil(lenPx / ideal), 1.0, most));
    float stride = lenPx / float(longTaps);
    shortTaps = int(clamp(ceil(stride / SPACING), 1.0, most));
    return stride;
}














vec4 gather(sampler2D tex, vec2 dirUv, float lenPx, float first, float spacing, int n, bool tent) {
    vec3 sum = vec3(0.0);
    float weight = 0.0;
    for (int i = 0; i < n; i++) {
        float at = first + float(i) * spacing;
        vec2 uv = clamp(texCoord + dirUv * at, vec2(0.0), vec2(1.0));
#ifdef SHIELD




        if (entityAt(uv)) {
            continue;
        }
#endif
        float w = tent ? 1.0 - 1.9 * abs(at / lenPx) : 1.0;
        vec3 c = texture(tex, uv).rgb;
        sum += c * c * w;
        weight += w;
    }
    return vec4(sum, weight);
}

void main() {
    vec4 src = texture(Sampler0, texCoord);
    float rawDepth = texture(Sampler1, texCoord).r;

    vec2 pixel = texCoord * Screen.xy;






    if (rawDepth < Mask.x) {
        fragColor = src;
        return;
    }
#ifdef SHIELD
    if (entityAt(texCoord)) {
        fragColor = src;
        return;
    }
#endif

    bool valid;
    vec2 velPx = velocityAt(rawDepth, valid);
    if (!valid) {
        fragColor = src;
        return;
    }



    if (Mask.y > 0.5) {
        vec2 cover = coverAt(pixel);
        if (cover.x > 0.0) {
            bool frontValid;
            bool backValid;
            vec2 front = velocityAt(cover.y, frontValid);
            vec2 back = velocityAt(coverDepthAt(CoverBackSampler, pixel), backValid);
            if (frontValid && backValid) {
                velPx = mix(back, front, cover.x);
            }
        }
    }
    float lenPx = length(velPx);
    if (lenPx < 0.5) {
        fragColor = src;
        return;
    }

    velPx *= min(1.0, Params.z / lenPx);
    lenPx = min(lenPx, Params.z);
#ifdef HALF_SHORT
    if (lenPx < HALF_FROM) {
        fragColor = src;
        return;
    }
#endif
#ifdef LOW_LONG
    if (lenPx < Mask.z) {
        fragColor = src;
        return;
    }
#endif
#ifdef HALF_LONG
    float toLow = clamp((lenPx - Mask.z) / (Mask.w - Mask.z), 0.0, 1.0);
    if (toLow >= 1.0) {
        fragColor = vec4(texture(LowSampler, texCoord).rgb, src.a);
        return;
    }
#endif

    int shortTaps;
    int longTaps;
    float stride = split(lenPx, shortTaps, longTaps);
    vec2 dirUv = velPx / lenPx * Screen.zw;
    vec4 light;

    if (Params.w < 0.5) {


        float spacing = stride / float(shortTaps);
        float first = -0.5 * stride + ign(gl_FragCoord.xy) * spacing;
        light = gather(Sampler0, dirUv, lenPx, first, spacing, shortTaps, false);
    } else {



#ifdef HALF_LONG

        float toHalf = clamp((lenPx - HALF_FROM) / (HALF_FULL - HALF_FROM), 0.0, 1.0);
        vec3 still = src.rgb * src.rgb;
        vec3 mixed = vec3(0.0);
        if (toHalf > 0.0) {
            vec4 combed = gather(HalfSampler, dirUv, lenPx, -0.5 * lenPx + 0.5 * stride, stride, longTaps, true);
            mixed += (combed.w > 0.0 ? combed.rgb / combed.w : still) * toHalf;
        }
        if (toHalf < 1.0) {

            int n = int(clamp(ceil(lenPx / SPACING), 2.0, HALF_FULL));
            float spacing = lenPx / float(n);
            float first = -0.5 * lenPx + ign(gl_FragCoord.xy + vec2(29.0, 17.0)) * spacing;
            vec4 direct = gather(Sampler0, dirUv, lenPx, first, spacing, n, true);
            mixed += (direct.w > 0.0 ? direct.rgb / direct.w : still) * (1.0 - toHalf);
        }
        if (toLow > 0.0) {
            vec3 low = texture(LowSampler, texCoord).rgb;
            mixed = mix(mixed, low * low, toLow);
        }
        light = vec4(mixed, 1.0);
#else
        light = gather(Sampler0, dirUv, lenPx, -0.5 * lenPx + 0.5 * stride, stride, longTaps, true);
#endif
    }
    if (light.w <= 0.0) {
        fragColor = src;
        return;
    }

    fragColor = vec4(sqrt(light.rgb / light.w), src.a);
}
