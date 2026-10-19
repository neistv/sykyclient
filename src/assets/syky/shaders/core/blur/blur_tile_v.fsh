#version 330







#define MAX_TILES 128

struct Tile {
    vec4 dst;
    vec4 src;
    vec4 rect;
    vec4 radii;
};

layout(std140) uniform BlurTileData {
    Tile tiles[MAX_TILES];
};

layout(std140) uniform BlurTileParams {
    vec4 target;
    vec4 screen;
    vec4 grid;
};

uniform sampler2D Sampler0;

flat in int tile;

layout(location = 0) out vec4 fragColor;

const int MAX_TAPS = 24;

void main() {
    Tile t = tiles[tile];
    ivec2 size = ivec2(grid.xy);
    ivec2 a = ivec2(gl_FragCoord.xy);
    int srcY = int(t.src.y);
    int dstY = int(t.dst.y);


    int row = dstY + clamp(srcY + (a.y - dstY), 0, size.y - 1) - srcY;
    int lo = dstY + max(0, -srcY);
    int hi = dstY + min(int(t.dst.w), size.y - srcY) - 1;

    float sigma = target.z;
    float twoSigmaSq = 2.0 * sigma * sigma;
    int reach = min(int(2.0 * sigma), MAX_TAPS);


    float g = exp(-float(reach * reach) / twoSigmaSq);
    float ratio = exp(float(2 * reach - 1) / twoSigmaSq);
    float ratioStep = exp(-2.0 / twoSigmaSq);

    vec3 num = vec3(0.0);
    float den = 0.0;
    for (int k = -reach; k <= reach; k++) {
        int y = row + k;
        if (y >= lo && y <= hi) {
            vec4 h = texelFetch(Sampler0, ivec2(a.x, y), 0);
            float w = g * h.a;
            num += h.rgb * w;
            den += w;
        }
        g *= ratio;
        ratio *= ratioStep;
    }



    fragColor = vec4(den > 0.0 ? num / den : vec3(0.0), target.w);
}
