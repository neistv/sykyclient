#version 330

layout(std140) uniform BlurData {
    vec4 rect;
    vec4 screen;
    vec4 radii;
    vec4 tint;
    vec4 fade;
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

    vec2 pos = positions[gl_VertexID];



    float PAD = max(2.0, 1.26 * fade.y + 1.0);
    vec2 paddedSize = rect.zw + PAD * 2.0;
    vec2 screenPos = rect.xy - PAD + pos * paddedSize;
    vec2 ndcPos = (screenPos / screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);

    fragCoord = pos;
    pixelCoord = pos * paddedSize - PAD;
    rectSize = rect.zw;
    cornerRadii = radii;
    guiScale = screen.z;
    saturation = screen.w;
    tintColor = tint;
    opacity = fade.x;
    edgeSigma = fade.y;
    glow = fade.z;
    tone = fade.w;



    texCoord = vec2(screenPos.x / screen.x, 1.0 - screenPos.y / screen.y);
}
