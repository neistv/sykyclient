#version 330

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:projection.glsl>










layout(std140) uniform AreaItems {
    ivec4 Items[1024];
};

out vec4 vertexColor;

out float down;

const int QUAD[6] = int[6](0, 1, 2, 2, 3, 0);

int low16(int v) {
    return (v << 16) >> 16;
}

void hide() {
    gl_Position = vec4(2.0, 2.0, 2.0, 1.0);
    vertexColor = vec4(0.0);
    down = 0.0;
}

void main() {
    int item = gl_VertexID / 6;
    int corner = QUAD[gl_VertexID - item * 6];
    ivec4 word = Items[item];
    int axis = word.z & 3;


    float growP = (word.z & 4) != 0 ? 1.0 : -1.0;
    float growQ = (word.z & 8) != 0 ? 1.0 : -1.0;
    float growDown = axis == 0 ? growP : growQ;
    if (axis == 1 || growDown > 0.0) {
        hide();
        return;
    }

    int side = axis == 0 ? 2 : 0;
    float facing = -(axis == 0 ? growQ : growP);

    vec3 local = vec3(float(low16(word.x)), float(word.x >> 16), float(low16(word.y))) + ModelOffset;

    if (local[side] * facing >= 0.0) {
        hide();
        return;
    }
    float len = float(word.y >> 16);
    float reach = TextureMat[2][0];

    bool along = corner == 1 || corner == 2;
    bool foot = corner == 2 || corner == 3;
    vec3 pos = local;
    pos[axis] += along ? len : 0.0;
    pos.y -= foot ? reach : 0.0;

    gl_Position = ProjMat * ModelViewMat * vec4(TextureMat[0][0] * pos, 1.0);
    vertexColor = ColorModulator;
    down = foot ? 1.0 : 0.0;
}
