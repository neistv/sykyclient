#version 330

#moj_import <syky:translucent_cover.glsl>

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;
uniform sampler2D Sampler2;
uniform sampler2D Sampler3;
uniform sampler2D CoverBackSampler;

layout(std140) uniform FogBlurParams {
    mat4 InvViewProj;
    vec4 Range;
};







float rampAt(float rawDepth) {


    float depth = min(rawDepth, 0.999999);
    vec3 ndc = vec3(texCoord * 2.0 - 1.0, depth * 2.0 - 1.0);

    vec4 p = InvViewProj * vec4(ndc, 1.0);
    if (abs(p.w) < 1.0e-9) {
        return -1.0;
    }



    float dist = length(p.xyz / p.w);

    float t = clamp((dist - Range.x) * Range.y, 0.0, 1.0);


    return t * t * (3.0 - 2.0 * t);
}

void main() {
    float f = rampAt(texture(Sampler3, texCoord).r);






    if (Range.w > 0.5) {
        vec2 cover = coverAt(gl_FragCoord.xy);
        if (cover.x > 0.0) {
            float front = rampAt(cover.y);
            float back = rampAt(coverDepthAt(CoverBackSampler, gl_FragCoord.xy));
            if (front >= 0.0 && back >= 0.0) {
                f = mix(back, front, cover.x);
            }
        }
    }
    if (f < 0.0) {
        fragColor = vec4(0.0);
        return;
    }

    if (f <= 0.0) {
        fragColor = vec4(0.0);
        return;
    }















    vec3 blurred = mix(
            mix(
                texture(Sampler0, texCoord).rgb,
                texture(Sampler1, texCoord).rgb,
                clamp(f * 3.0 - 1.0, 0.0, 1.0)),
            texture(Sampler2, texCoord).rgb,
            clamp(f * 3.0 - 2.0, 0.0, 1.0));




    fragColor = vec4(blurred, min(f * 3.0, 1.0) * Range.z);
}
