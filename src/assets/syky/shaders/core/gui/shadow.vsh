#version 330



layout(std140) uniform ShadowData {
    vec4 data[1020];
};

out vec2 localPos;
out vec2 rectSize;
out vec2 shadowOffset;
out float cornerRadius;
out float sigma;
out float guiScale;
out vec4 shadowColor;
out float edgeSigma;

void main() {
    int base = gl_InstanceID * 4;
    vec4 rect = data[base];
    vec4 screen = data[base + 1];
    vec4 params = data[base + 2];




    float sig = max(screen.w, 0.5 / screen.z);
    vec2 offset = params.yz;



    float pad = 3.0 * sig + max(abs(offset.x), abs(offset.y)) + 1.0;

    vec2 positions[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    vec2 pos = positions[gl_VertexID];
    vec2 paddedSize = rect.zw + pad * 2.0;
    vec2 screenPos = rect.xy - pad + pos * paddedSize;
    vec2 ndcPos = (screenPos / screen.xy) * 2.0 - 1.0;
    ndcPos.y = -ndcPos.y;

    gl_Position = vec4(ndcPos, 0.0, 1.0);


    localPos = pos * paddedSize - pad;
    rectSize = rect.zw;
    cornerRadius = params.x;
    shadowOffset = offset;
    sigma = sig;
    guiScale = screen.z;
    shadowColor = data[base + 3];

    edgeSigma = params.w;
}
