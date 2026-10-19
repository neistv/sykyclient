#version 330



layout(std140) uniform LineData {
    vec4 data[1020];
};

out vec2 segLocal;
out float segLength;
out float halfThickness;
out float guiScale;
out vec4 lineColor;

void main() {
    int base = gl_InstanceID * 3;
    vec4 segment = data[base];
    vec4 screen = data[base + 1];

    vec2 a = segment.xy;
    vec2 delta = segment.zw - a;
    float len = length(delta);


    vec2 dir = len > 1.0e-5 ? delta / len : vec2(1.0, 0.0);
    vec2 nrm = vec2(-dir.y, dir.x);










    float halfT = max(screen.w, 1.0 / screen.z) * 0.5;
    float conserve = min(screen.w * screen.z, 1.0);


    float pad = 1.5;





    float capPad = halfT + pad;

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );
    vec2 pos = positions[gl_VertexID];




    float along = pos.x * (len + 2.0 * capPad) - capPad;
    float across = (pos.y * 2.0 - 1.0) * (halfT + pad);

    vec2 screenPos = a + dir * along + nrm * across;
    vec2 ndcPos = (screenPos / screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);

    segLocal = vec2(along, across);
    segLength = len;
    halfThickness = halfT;
    guiScale = screen.z;
    lineColor = data[base + 2];
    lineColor.a *= conserve;
}
