#version 330

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:globals.glsl>
#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <syky:cosmetic_fx.glsl>
#moj_import <syky:translucent_cover.glsl>

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;

in float sphericalVertexDistance;
in float cylindricalVertexDistance;
in vec4 vertexColor;
in vec2 texCoord0;
flat in int paletteRow;
in vec2 localPos;
in vec3 viewNormal;
in vec3 viewPos;

layout(location = 0) out vec4 fragColor;

void main() {
    vec4 tex = texture(Sampler0, texCoord0) * vertexColor;
    vec3 n = normalize(viewNormal);
    vec3 v = normalize(-viewPos);

    vec3 light = cosmetic_fx(fx_params(Sampler1, paletteRow), tex, localPos, n, v, GameTime * 1200.0);

    float fog = total_fog_value(sphericalVertexDistance, cylindricalVertexDistance, FogEnvironmentalStart,
            FogEnvironmentalEnd, FogRenderDistanceStart, FogRenderDistanceEnd);
    light *= (1.0 - fog) * ColorModulator.rgb * ColorModulator.a;
    if (max(light.r, max(light.g, light.b)) < 0.002) {
        discard;
    }

    fragColor = vec4(light, coverShow(gl_FragCoord.xy, gl_FragCoord.z));
}
