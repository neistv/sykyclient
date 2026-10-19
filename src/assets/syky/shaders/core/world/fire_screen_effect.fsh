#version 330

#moj_import <minecraft:dynamictransforms.glsl>

uniform sampler2D Sampler0;

in vec2 texCoord0;
in vec4 vertexColor;

layout(location = 0) out vec4 fragColor;







float heatOf(vec3 c) {
    return (c.r + c.g + c.b) / 3.0;
}



const float MIN_PIVOT = 1.0 / 255.0;





void main() {
    vec4 texel = texture(Sampler0, texCoord0);
    float alpha = texel.a * vertexColor.a;
    if (alpha == 0.0) {
        discard;
    }






    vec3 tint = vertexColor.rgb;
    float pivot = heatOf(tint);
    float heat = heatOf(texel.rgb);

    vec3 flame;
    if (pivot < MIN_PIVOT) {
        flame = tint * heat;
    } else if (heat <= pivot) {
        flame = tint * (heat / pivot);
    } else {
        flame = mix(tint, vec3(1.0), (heat - pivot) / max(1.0 - pivot, 1e-5));
    }

    fragColor = vec4(flame, alpha) * ColorModulator;
}
