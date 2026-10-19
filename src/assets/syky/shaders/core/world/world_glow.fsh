#version 330

#moj_import <minecraft:fog.glsl>
#moj_import <syky:translucent_cover.glsl>

in float sphericalVertexDistance;
in float cylindricalVertexDistance;
in vec4 vertexColor;
in vec2 quadCoord;
flat in vec2 orbShape;
flat in float spineHalf;
flat in float ditherPhase;

layout(location = 0) out vec4 fragColor;





const float CORE_FALLOFF = 0.87;





const float HALO_FALLOFF = 0.60;




const float WHITE_DRIVE = 0.25;

float orb(float d2, float falloff) {
    float window = max(1.0 - d2, 0.0);
    return exp(-falloff * d2) * window * window;
}

float dither(vec2 coord) {
    return fract(52.9829189 * fract(dot(coord, vec2(0.06711056, 0.00583715))));
}

void main() {



    float onSpine = clamp(quadCoord.x, -spineHalf, spineHalf);
    vec2 offset = vec2(quadCoord.x - onSpine, quadCoord.y);
    float d2 = dot(offset, offset);
    if (d2 > 1.0) {
        discard;
    }




    float invCore = 1.0 / max(orbShape.x, 1.0e-4);
    float core = orb(d2 * invCore * invCore, CORE_FALLOFF);
    float intensity = (core + orbShape.y * orb(d2, HALO_FALLOFF)) * vertexColor.a;










    float jitter = (fract(dither(gl_FragCoord.xy) + ditherPhase) - 0.5) * (1.0 / 255.0);











    vec3 base = mix(vertexColor.rgb, vec3(1.0), min(core * WHITE_DRIVE, 1.0));
    vec3 lit = clamp(base * intensity + jitter, 0.0, 1.0);

    float level = max(max(lit.r, lit.g), lit.b);





    if (level < 1.0e-4) {
        discard;
    }




    vec4 color = vec4(lit / level, level);

    fragColor = apply_fog(
            color,
            sphericalVertexDistance,
            cylindricalVertexDistance,
            FogEnvironmentalStart,
            FogEnvironmentalEnd,
            FogRenderDistanceStart,
            FogRenderDistanceEnd,
            FogColor);

    fragColor.a *= coverShow(gl_FragCoord.xy, gl_FragCoord.z);
}
