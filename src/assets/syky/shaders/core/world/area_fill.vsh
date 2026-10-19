#version 330

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:projection.glsl>










layout(std140) uniform AreaItems {
    ivec4 Items[1024];
};

out vec4 vertexColor;


const int QUAD[6] = int[6](0, 1, 2, 2, 3, 0);

int low16(int v) {
    return (v << 16) >> 16;
}

void main() {
    int item = gl_VertexID / 6;
    int corner = QUAD[gl_VertexID - item * 6];
    ivec4 word = Items[item];
    int axis = (word.x >> 16) & 3;
    bool positive = ((word.x >> 18) & 1) == 1;
    float k = TextureMat[0][0];


    int uAxis = axis == 0 ? 2 : 0;
    int vAxis = axis == 1 ? 2 : 1;
    float plane = float(low16(word.x)) + ModelOffset[axis];
    vertexColor = ColorModulator;

    if (positive ? plane >= 0.0 : plane <= 0.0) {
        gl_Position = vec4(2.0, 2.0, 2.0, 1.0);
        return;
    }
    float u0 = k * (float(low16(word.y)) + ModelOffset[uAxis]);
    float u1 = k * (float(word.y >> 16) + ModelOffset[uAxis]);
    float v0 = k * (float(low16(word.z)) + ModelOffset[vAxis]);
    float v1 = k * (float(word.z >> 16) + ModelOffset[vAxis]);



    bool firstHigh = corner == 1 || corner == 2;
    bool secondHigh = corner == 2 || corner == 3;
    vec3 pos;
    pos[axis] = k * plane;
    if (axis == 0) {
        pos.y = firstHigh ? v1 : v0;
        pos.z = secondHigh ? u1 : u0;
    } else if (axis == 1) {
        pos.x = secondHigh ? u1 : u0;
        pos.z = firstHigh ? v1 : v0;
    } else {
        pos.x = firstHigh ? u1 : u0;
        pos.y = secondHigh ? v1 : v0;
    }
    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);
}
