#version 330



layout(std140) uniform TextureData {
    vec4 data[1020];
};

out vec2 fragCoord;
out vec2 pixelCoord;
out vec2 texCoord;
out vec2 rectSize;
out vec4 cornerRadii;
out vec4 tintColor;
out float guiScale;

void main() {
    int base = gl_InstanceID * 5;
    vec4 rect = data[base];
    vec4 screen = data[base + 1];
    vec4 uv = data[base + 2];
    vec4 radii = data[base + 3];
    vec4 tint = data[base + 4];

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    vec2 pos = positions[gl_VertexID];





    float angle = screen.w;
    float ca = cos(angle);
    float sa = sin(angle);
    vec2 local = (pos - 0.5) * rect.zw;
    vec2 turned = vec2(ca * local.x - sa * local.y, sa * local.x + ca * local.y);
    vec2 screenPos = rect.xy + rect.zw * 0.5 + turned;

    vec2 ndcPos = (screenPos / screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);

    fragCoord = pos;
    pixelCoord = pos * rect.zw;
    rectSize = rect.zw;
    cornerRadii = radii;
    guiScale = screen.z;
    tintColor = tint;

    texCoord = vec2(mix(uv.x, uv.z, pos.x), mix(uv.y, uv.w, pos.y));
}
