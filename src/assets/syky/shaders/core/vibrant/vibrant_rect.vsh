#version 330

layout(std140) uniform RectData {
    vec4 data[1020];
};

out vec2 fragCoord;
out vec2 pixelCoord;
out vec2 rectSize;
out vec4 cornerRadii;
out float guiScale;
out float innerBlur;
out vec2 fbSize;
flat out int vBase;

void main() {
    int base = gl_InstanceID * 12;
    vec4 rect = data[base];
    vec4 screen = data[base + 1];
    vec4 radii = data[base + 2];

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    vec2 pos = positions[gl_VertexID];


    const float PAD = 2.0;
    vec2 paddedSize = rect.zw + PAD * 2.0;
    vec2 screenPos = rect.xy - PAD + pos * paddedSize;
    vec2 ndcPos = (screenPos / screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);

    pixelCoord = pos * paddedSize - PAD;
    fragCoord = pixelCoord / rect.zw;
    rectSize = rect.zw;
    cornerRadii = radii;
    guiScale = screen.z;
    innerBlur = screen.w;

    fbSize = screen.xy * screen.z;
    vBase = base;
}
