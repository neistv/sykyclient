#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;

layout(std140) uniform BlurParams {
    vec4 params;
};
















void main() {
    vec2 t = params.xy;
    vec2 uv = texCoord + params.zw;

    vec3 e = texture(Sampler0, uv).rgb * 0.125;


    vec3 c0 = texture(Sampler0, uv + t * vec2(-1.0, -1.0)).rgb;
    vec3 c1 = texture(Sampler0, uv + t * vec2( 1.0, -1.0)).rgb;
    vec3 c2 = texture(Sampler0, uv + t * vec2(-1.0,  1.0)).rgb;
    vec3 c3 = texture(Sampler0, uv + t * vec2( 1.0,  1.0)).rgb;
    vec3 center = (c0 + c1 + c2 + c3) * 0.125;


    vec3 i0 = texture(Sampler0, uv + t * vec2(-2.0,  0.0)).rgb;
    vec3 i1 = texture(Sampler0, uv + t * vec2( 2.0,  0.0)).rgb;
    vec3 i2 = texture(Sampler0, uv + t * vec2( 0.0, -2.0)).rgb;
    vec3 i3 = texture(Sampler0, uv + t * vec2( 0.0,  2.0)).rgb;
    vec3 inner = (i0 + i1 + i2 + i3) * 0.0625;


    vec3 r0 = texture(Sampler0, uv + t * vec2(-2.0, -2.0)).rgb;
    vec3 r1 = texture(Sampler0, uv + t * vec2( 2.0, -2.0)).rgb;
    vec3 r2 = texture(Sampler0, uv + t * vec2(-2.0,  2.0)).rgb;
    vec3 r3 = texture(Sampler0, uv + t * vec2( 2.0,  2.0)).rgb;
    vec3 corners = (r0 + r1 + r2 + r3) * 0.03125;

    fragColor = vec4(e + center + inner + corners, 1.0);
}
