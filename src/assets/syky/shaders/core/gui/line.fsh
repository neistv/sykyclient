#version 330

in vec2 segLocal;
in float segLength;
in float halfThickness;
in float guiScale;
in vec4 lineColor;

layout(location = 0) out vec4 fragColor;

void main() {


    float overshoot = max(0.0, max(-segLocal.x, segLocal.x - segLength));
    float dist = length(vec2(overshoot, segLocal.y)) - halfThickness;



    float mask = clamp(0.5 - dist * guiScale, 0.0, 1.0);
    if (mask < 0.01) {
        discard;
    }

    fragColor = vec4(lineColor.rgb, lineColor.a * mask);
}
