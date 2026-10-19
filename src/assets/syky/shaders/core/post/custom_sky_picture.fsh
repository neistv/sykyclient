#version 330





uniform samplerCube Sampler0;

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

layout(std140) uniform CustomSkyParams {
    mat4 InvViewProj;
    vec4 Phase;
    vec4 Params;
};

void main() {


    vec4 p = InvViewProj * vec4(texCoord * 2.0 - 1.0, 0.999998, 1.0);
    vec3 rd = p.xyz / p.w;
    fragColor = vec4(min(texture(Sampler0, rd).rgb * Params.x, vec3(1.0)), 1.0);
}
