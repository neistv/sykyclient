#version 330










in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

layout(std140) uniform CustomSkyParams {
    mat4 InvViewProj;
    vec4 Phase;
    vec4 Params;
};

#define TAU 6.28318530718
#define PI  3.14159265359



































































float skyHash3(vec3 p) {
    p = fract(p * 0.3183099 + vec3(0.71, 0.113, 0.419));
    p *= 17.0;
    return fract(p.x * p.y * p.z * (p.x + p.y + p.z));
}






float skyNoise3(vec3 p) {
    vec3 i = floor(p);
    vec3 f = fract(p);
    f = f * f * (3.0 - 2.0 * f);
    float n000 = skyHash3(i + vec3(0.0, 0.0, 0.0));
    float n100 = skyHash3(i + vec3(1.0, 0.0, 0.0));
    float n010 = skyHash3(i + vec3(0.0, 1.0, 0.0));
    float n110 = skyHash3(i + vec3(1.0, 1.0, 0.0));
    float n001 = skyHash3(i + vec3(0.0, 0.0, 1.0));
    float n101 = skyHash3(i + vec3(1.0, 0.0, 1.0));
    float n011 = skyHash3(i + vec3(0.0, 1.0, 1.0));
    float n111 = skyHash3(i + vec3(1.0, 1.0, 1.0));
    return mix(
            mix(mix(n000, n100, f.x), mix(n010, n110, f.x), f.y),
            mix(mix(n001, n101, f.x), mix(n011, n111, f.x), f.y),
            f.z);
}


float skyFbm3(vec3 p, int octaves) {
    float sum = 0.0;
    float amp = 0.5;
    for (int i = 0; i < 8; ++i) {
        if (i >= octaves) {
            break;
        }
        sum += amp * skyNoise3(p);
        p *= 2.02;
        amp *= 0.5;
    }
    return sum;
}




float skyAzimuth(vec3 rd) {
    return atan(rd.z, rd.x);
}


float skyElevation(vec3 rd) {
    return asin(clamp(rd.y, -1.0, 1.0));
}























const vec3 SKY_HORIZON = vec3(0.055, 0.075, 0.115);
const vec3 SKY_ZENITH = vec3(0.010, 0.014, 0.032);
const vec3 SKY_NADIR = vec3(0.004, 0.005, 0.010);

vec3 sky(vec3 rd) {










    float up = clamp(rd.y, 0.0, 1.0);
    float down = clamp(-rd.y, 0.0, 1.0);
    vec3 above = mix(SKY_HORIZON, SKY_ZENITH, pow(up, 0.65));
    vec3 below = mix(SKY_HORIZON, SKY_NADIR, pow(down, 0.65));
    return rd.y >= 0.0 ? above : below;
}





void main() {



    vec3 ndc = vec3(texCoord * 2.0 - 1.0, 0.999998);
    vec4 p = InvViewProj * vec4(ndc, 1.0);
    if (abs(p.w) < 1.0e-9) {
        fragColor = vec4(0.0, 0.0, 0.0, 1.0);
        return;
    }
    vec3 rd = normalize(p.xyz / p.w);

    vec3 col = max(sky(rd), vec3(0.0)) * Params.x;





    col = 1.0 - exp(-col);
    col = pow(col, vec3(1.0 / 2.2));

    fragColor = vec4(col, 1.0);
}
