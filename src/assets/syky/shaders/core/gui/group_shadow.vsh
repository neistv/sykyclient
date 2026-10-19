#version 330








layout(std140) uniform GroupShadowData {
    vec4 data[67];
};

out vec2 fragPos;

void main() {
    vec4 quad = data[0];
    vec2 screen = data[1].xy;

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );



    vec2 pos = quad.xy + positions[gl_VertexID] * quad.zw;
    vec2 ndcPos = (pos / screen) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);



    fragPos = pos;
}
