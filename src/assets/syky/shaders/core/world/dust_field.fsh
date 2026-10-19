#version 330

#moj_import <syky:translucent_cover.glsl>
#moj_import <syky:crystal_halo.glsl>

layout(std140) uniform DustFieldData {
    mat4 ViewProj;
    vec4 Tint;
    vec4 Wrap;
    vec4 Motion;
    vec4 Field;
    vec4 Screen;
    vec4 Fade;
};

in vec2 vUv;
in vec4 vColor;
flat in vec4 vShape;
flat in float vDitherPhase;

layout(location = 0) out vec4 fragColor;





float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715))));
}




void star(vec2 uc, float dc2, float sort, float heat, out float sprite, out float whiteDrive) {
    float core = exp(-dc2 * mix(13.5, 8.5, sort));
    float ax = abs(uc.x);
    float ay = abs(uc.y);
    sprite = core + exp(-dc2 * 2.6) * 0.32
            + (exp(-ax * 2.6 - ay * 30.0) + exp(-ay * 2.6 - ax * 30.0)) * mix(0.4, 0.6, heat);
    whiteDrive = core * 0.65;
}










void orb(float dc2, float sort, float heat, out float sprite, out float whiteDrive) {
    float core = exp(-dc2 * mix(11.0, 7.0, sort));
    sprite = core * mix(5.6, 10.4, heat) + exp(-dc2 * 3.5) * 0.21;
    whiteDrive = core * 0.4;
}

void main() {



    float d2 = dot(vUv, vUv);
    if (d2 > 1.0) {
        discard;
    }
    vec2 uc = vUv * vShape.x;
    float dc2 = dot(uc, uc);

    float sprite;

    float whiteDrive;



    if (Field.w >= 0.999) {
        star(uc, dc2, vShape.y, vShape.z, sprite, whiteDrive);
    } else if (Field.w <= 0.001) {
        orb(dc2, vShape.y, vShape.z, sprite, whiteDrive);
    } else {
        float orbSprite;
        float orbWhite;
        float starSprite;
        float starWhite;
        orb(dc2, vShape.y, vShape.z, orbSprite, orbWhite);
        star(uc, dc2, vShape.y, vShape.z, starSprite, starWhite);
        sprite = mix(orbSprite, starSprite, Field.w);
        whiteDrive = mix(orbWhite, starWhite, Field.w);
    }



    sprite *= max(1.0 - dc2, 0.0);

    float aura = Fade.z * vShape.w * crystalHalo(d2);

    float intensity = (sprite + aura) * vColor.a;



    float jitter = (fract(dither(gl_FragCoord.xy) + vDitherPhase) - 0.5) * (1.5 / 255.0);















    vec3 base = mix(vColor.rgb, vec3(1.0), min(whiteDrive, 1.0));
    vec3 lit = clamp(base * intensity + jitter, 0.0, 1.0);

    float level = max(max(lit.r, lit.g), lit.b);
    if (level < 0.0035) {
        discard;
    }





    fragColor = vec4(lit / level, level * coverShow(gl_FragCoord.xy, gl_FragCoord.z));
}
