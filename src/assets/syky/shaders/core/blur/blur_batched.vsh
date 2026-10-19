#version 330








#define MAX_PANELS 32

struct PanelData {
    vec4 rect;
    vec4 screen;
    vec4 radii;
    vec4 tint;
    vec4 fade;
};

layout(std140) uniform BlurBatchData {
    PanelData panels[MAX_PANELS];
};

out vec2 fragCoord;
out vec2 pixelCoord;
out vec2 texCoord;
out vec2 rectSize;
out vec4 cornerRadii;
out vec4 tintColor;
out float guiScale;
out float saturation;
out float opacity;
out float edgeSigma;
out float glow;
out float tone;

void main() {
    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    PanelData p = panels[gl_InstanceID];
    vec2 pos = positions[gl_VertexID];



    float PAD = max(2.0, 1.26 * p.fade.y + 1.0);
    vec2 paddedSize = p.rect.zw + PAD * 2.0;
    vec2 screenPos = p.rect.xy - PAD + pos * paddedSize;
    vec2 ndcPos = (screenPos / p.screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);

    fragCoord = pos;
    pixelCoord = pos * paddedSize - PAD;
    rectSize = p.rect.zw;
    cornerRadii = p.radii;
    guiScale = p.screen.z;
    saturation = p.screen.w;
    tintColor = p.tint;
    opacity = p.fade.x;
    edgeSigma = p.fade.y;
    glow = p.fade.z;
    tone = p.fade.w;
    texCoord = vec2(screenPos.x / p.screen.x, 1.0 - screenPos.y / p.screen.y);
}
