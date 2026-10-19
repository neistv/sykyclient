#version 330

















layout(std140) uniform OverlayParams {
    vec4 params;
};

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;

void main() {
    vec2 uv = gl_FragCoord.xy / params.xy;
    vec2 t = params.zw;

    vec4 e = texture(Sampler0, uv) * 0.125;

    vec4 c0 = texture(Sampler0, uv + t * vec2(-1.0, -1.0));
    vec4 c1 = texture(Sampler0, uv + t * vec2( 1.0, -1.0));
    vec4 c2 = texture(Sampler0, uv + t * vec2(-1.0,  1.0));
    vec4 c3 = texture(Sampler0, uv + t * vec2( 1.0,  1.0));
    vec4 center = (c0 + c1 + c2 + c3) * 0.125;

    vec4 i0 = texture(Sampler0, uv + t * vec2(-2.0,  0.0));
    vec4 i1 = texture(Sampler0, uv + t * vec2( 2.0,  0.0));
    vec4 i2 = texture(Sampler0, uv + t * vec2( 0.0, -2.0));
    vec4 i3 = texture(Sampler0, uv + t * vec2( 0.0,  2.0));
    vec4 inner = (i0 + i1 + i2 + i3) * 0.0625;

    vec4 r0 = texture(Sampler0, uv + t * vec2(-2.0, -2.0));
    vec4 r1 = texture(Sampler0, uv + t * vec2( 2.0, -2.0));
    vec4 r2 = texture(Sampler0, uv + t * vec2(-2.0,  2.0));
    vec4 r3 = texture(Sampler0, uv + t * vec2( 2.0,  2.0));
    vec4 corners = (r0 + r1 + r2 + r3) * 0.03125;

    vec4 c = e + center + inner + corners;

    if (c.a <= 0.0) {
        discard;
    }

    fragColor = c;
}
