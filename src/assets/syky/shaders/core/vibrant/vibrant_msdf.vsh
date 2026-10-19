#version 330


layout(std140) uniform MsdfData {
    vec4 screenData;
    vec4 atlasData;
    vec4 fadeData;
    vec4 outlineColor;
    vec4 chars[768];
};

out vec2 texCoord;
out vec4 fragColor_;
out float pxRange;
out vec2 atlasSize;
out vec2 fbSize;


out vec2 fadeT;

flat out vec2 inkPx;
flat out vec4 outlineRgba;

void main() {
    int charIndex = gl_VertexID / 6;
    int vertexIndex = gl_VertexID % 6;

    vec4 posSize = chars[charIndex * 3];
    vec4 uvCoords = chars[charIndex * 3 + 1];
    vec4 color = chars[charIndex * 3 + 2];

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    vec2 pos = positions[vertexIndex];
    vec2 screenPos = posSize.xy + pos * posSize.zw;
    vec2 ndcPos = (screenPos / screenData.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);

    texCoord = vec2(mix(uvCoords.x, uvCoords.z, pos.x), mix(uvCoords.y, uvCoords.w, pos.y));
    fragColor_ = color;
    pxRange = screenData.w;
    atlasSize = atlasData.xy;

    fbSize = screenData.xy * screenData.z;

    inkPx = atlasData.zw;
    outlineRgba = outlineColor;
    fadeT = vec2((screenPos.x - fadeData.x) * fadeData.y, (fadeData.z - screenPos.x) * fadeData.w);
}
