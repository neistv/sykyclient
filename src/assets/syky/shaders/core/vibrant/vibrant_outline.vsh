#version 330

layout(std140) uniform OutlineData {
    vec4 data[1014];
};

out vec2 pixelCoord;
out vec2 rectSize;
out vec4 cornerRadii;
out vec4 fragColors[8];
out float fragThicknesses[8];
out float fragSmoothness;
out float guiScale;
out vec2 fbSize;

void main() {
    int base = gl_InstanceID * 13;
    vec4 rect = data[base];
    vec4 screen = data[base + 1];
    vec4 radii = data[base + 2];
    vec4 thicknesses = data[base + 11];
    vec4 thicknesses2 = data[base + 12];

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    vec2 pos = positions[gl_VertexID];

    float maxT = max(
        max(max(thicknesses.x, thicknesses.y), max(thicknesses.z, thicknesses.w)),
        max(max(thicknesses2.x, thicknesses2.y), max(thicknesses2.z, thicknesses2.w))
    );

    float padding = maxT + 2.0;

    vec2 expandedPos = rect.xy - padding + pos * (rect.zw + padding * 2.0);
    vec2 ndcPos = (expandedPos / screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);

    pixelCoord = pos * (rect.zw + padding * 2.0) - padding;
    rectSize = rect.zw;
    cornerRadii = radii;
    fragSmoothness = screen.z;
    guiScale = screen.w;

    fbSize = screen.xy * screen.w;

    for (int i = 0; i < 8; i++) {
        fragColors[i] = data[base + 3 + i];
    }

    fragThicknesses[0] = thicknesses.x;
    fragThicknesses[1] = thicknesses.y;
    fragThicknesses[2] = thicknesses.z;
    fragThicknesses[3] = thicknesses.w;
    fragThicknesses[4] = thicknesses2.x;
    fragThicknesses[5] = thicknesses2.y;
    fragThicknesses[6] = thicknesses2.z;
    fragThicknesses[7] = thicknesses2.w;
}
