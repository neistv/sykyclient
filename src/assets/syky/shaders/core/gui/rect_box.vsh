#version 330






layout(std140) uniform RectBoxData {
    vec4 data[1020];
};

out vec2 pixelCoord;
out vec2 rectSize;
out vec4 cornerRadii;
out float guiScale;
out float thickness;
out float smoothness;
flat out int vBase;

void main() {
    int base = gl_InstanceID * 6;
    vec4 rect = data[base];
    vec4 screen = data[base + 1];
    vec4 radii = data[base + 2];
    vec4 params = data[base + 5];
    float t = screen.w;
    float padding = t + 2.0;

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );
    vec2 pos = positions[gl_VertexID];

    vec2 expandedPos = rect.xy - padding + pos * (rect.zw + padding * 2.0);
    vec2 ndcPos = (expandedPos / screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;
    gl_Position = vec4(ndcPos, 0.0, 1.0);

    pixelCoord = pos * (rect.zw + padding * 2.0) - padding;
    rectSize = rect.zw;
    cornerRadii = radii;
    guiScale = screen.z;
    thickness = t;
    smoothness = params.x;
    vBase = base;
}
