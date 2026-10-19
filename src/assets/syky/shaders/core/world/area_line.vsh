#version 330

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:projection.glsl>














layout(std140) uniform AreaItems {
    ivec4 Items[1024];
};

out vec3 camRel;
out vec4 vertexColor;
out vec2 perpOffset;
flat out vec3 axisDir;
flat out vec2 crossHalf;
out vec2 axialEnds;


const float CARRIER_PIXELS = 1.2;

const int QUAD[6] = int[6](0, 1, 2, 2, 3, 0);

int low16(int v) {
    return (v << 16) >> 16;
}

void hide() {
    gl_Position = vec4(2.0, 2.0, 2.0, 1.0);
    camRel = vec3(0.0);
    perpOffset = vec2(0.0);
    axialEnds = vec2(0.0);
    axisDir = vec3(1.0, 0.0, 0.0);
    crossHalf = vec2(0.0);
}

void main() {
    int item = gl_VertexID / 18;
    int rest = gl_VertexID - item * 18;
    int slot = rest / 6;
    int corner = QUAD[rest - slot * 6];
    ivec4 word = Items[item];
    vec3 local = vec3(float(low16(word.x)), float(word.x >> 16), float(low16(word.y)));
    float len = float(word.y >> 16);
    int axis = word.z & 3;
    float growP = (word.z & 4) != 0 ? 1.0 : -1.0;
    float growQ = (word.z & 8) != 0 ? 1.0 : -1.0;
    float k = TextureMat[0][0];
    float w = TextureMat[0][1];
    float e = TextureMat[0][2];
    float perPixel = TextureMat[1][0];
    vec3 forward = TextureMat[1].yzw;
    vertexColor = ColorModulator;




    int p = axis == 0 ? 1 : 0;
    int q = axis == 2 ? 1 : 2;
    float halfWidth = w * 0.5;
    vec3 a = k * (local + ModelOffset);
    a[p] += growP * (halfWidth - e);
    a[q] += growQ * (halfWidth - e);
    vec3 dir = vec3(0.0);
    dir[axis] = 1.0;
    vec3 b = a;
    b[axis] += k * len;



    float reach = w - e;
    a[axis] -= (word.z & 16) != 0 ? reach : e;
    b[axis] += (word.z & 32) != 0 ? reach : e;


    float padA = perPixel * max(dot(a, forward), 0.05);
    float padB = perPixel * max(dot(b, forward), 0.05);
    float worst = max(padA, padB);
    float grown = halfWidth + (worst > 0.0 ? CARRIER_PIXELS * worst : halfWidth);
    vec3 lo = a - grown;
    vec3 hi = a + grown;
    lo[axis] = a[axis];
    hi[axis] = b[axis];



    float fixedAt;
    if (lo[slot] > 0.0) {
        fixedAt = lo[slot];
    } else if (hi[slot] < 0.0) {
        fixedAt = hi[slot];
    } else {
        hide();
        return;
    }


    int aAxis = slot == 0 ? 1 : 0;
    int bAxis = slot == 2 ? 1 : 2;
    vec3 pos;
    pos[slot] = fixedAt;
    pos[aAxis] = corner == 1 || corner == 2 ? hi[aAxis] : lo[aAxis];
    pos[bAxis] = corner == 2 || corner == 3 ? hi[bAxis] : lo[bAxis];



    int e1 = axis == 0 ? 1 : (axis == 1 ? 2 : 0);
    int e2 = axis == 0 ? 2 : (axis == 1 ? 0 : 1);
    camRel = pos;
    perpOffset = vec2(pos[e1] - a[e1], pos[e2] - a[e2]);
    axialEnds = vec2(pos[axis] - a[axis], b[axis] - pos[axis]);
    axisDir = dir;
    crossHalf = vec2(halfWidth);
    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);
}
