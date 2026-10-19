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

// >>> squircle-patch:core










const float SQUIRCLE_SMOOTHING = 0.75;

float squircleReach(float r, vec2 halfSize) {
    return min(r * (1.0 + SQUIRCLE_SMOOTHING), min(halfSize.x, halfSize.y));
}

float squircleExponent(float r, float reach) {
    float s = r > 0.0 ? reach / r - 1.0 : 0.0;
    return 2.0 + s * (2.9 - 0.56 * s);
}











vec2 squircleNormGrad(vec2 m, float n) {
    float a = pow(m.x, n);
    float b = pow(m.y, n);
    float sum = a + b;
    float norm = pow(sum, 1.0 / n);
    return vec2(norm, length(vec2(a, b) * norm / (max(m, vec2(1e-6)) * sum)));
}
// <<< squircle-patch:core

float roundedBoxSDF(vec2 p, vec2 b, vec4 r) {
    r.xy = (p.x > 0.0) ? r.yz : r.xw;
    r.x = (p.y > 0.0) ? r.y : r.x;

    float k = squircleReach(r.x, b);
    float n = squircleExponent(r.x, k);
    vec2 q = abs(p) - b + k;
    vec2 m = max(q, 0.0);


    if (m.x <= 0.0 || m.y <= 0.0) {
        return min(max(q.x, q.y), 0.0) + max(m.x, m.y) - k;
    }
    vec2 ng = squircleNormGrad(m, n);
    return (ng.x - k) / ng.y;
}





float coverage(Tile t, ivec2 texel, vec2 gridSize) {
    vec2 uv = (vec2(texel) + 0.5) / gridSize;
    vec2 p = vec2(uv.x, 1.0 - uv.y) * screen.xy;
    vec2 halfSize = t.rect.zw * 0.5;
    vec2 centred = p - (t.rect.xy + halfSize);
    vec4 r = min(t.radii, vec4(min(halfSize.x, halfSize.y)));
    return clamp(0.5 - roundedBoxSDF(centred, halfSize, r) / screen.z, 0.0, 1.0);
}

void main() {
    Tile t = tiles[tile];
    ivec2 grid = textureSize(Sampler0, 0);
    vec2 gridSize = vec2(grid);
    ivec2 local = ivec2(gl_FragCoord.xy - t.dst.xy);



    ivec2 s = clamp(ivec2(t.src.xy) + local, ivec2(0), grid - 1);
    int lo = max(int(t.src.x), 0);
    int hi = min(int(t.src.x + t.dst.z), grid.x) - 1;

    float sigma = target.z;
    float twoSigmaSq = 2.0 * sigma * sigma;
    int reach = min(int(2.0 * sigma), MAX_TAPS);




    vec2 halfSize = t.rect.zw * 0.5;
    vec2 centre = t.rect.xy + halfSize;
    vec4 r = min(t.radii, vec4(min(halfSize.x, halfSize.y)));
    float kMax = max(max(squircleReach(r.x, halfSize), squircleReach(r.y, halfSize)),
                     max(squircleReach(r.z, halfSize), squircleReach(r.w, halfSize)));
    float band = 0.5 * screen.z;
    float ay = abs((1.0 - (float(s.y) + 0.5) / gridSize.y) * screen.y - centre.y);
    float fullX = -1.0;
    if (ay <= halfSize.y - band) {
        fullX = ay <= halfSize.y - kMax ? halfSize.x - band : min(halfSize.x - kMax, halfSize.x - band);
    }



    float w = exp(-float(reach * reach) / twoSigmaSq);
    float ratio = exp(float(2 * reach - 1) / twoSigmaSq);
    float ratioStep = exp(-2.0 / twoSigmaSq);

    vec3 num = vec3(0.0);
    float den = 0.0;


    float weightSum = 0.0;
    for (int k = -reach; k <= reach; k++) {
        weightSum += w;
        int x = s.x + k;
        if (x >= lo && x <= hi) {
            float ax = abs((float(x) + 0.5) / gridSize.x * screen.x - centre.x);
            float m = ax <= fullX ? 1.0 : coverage(t, ivec2(x, s.y), gridSize);
            if (m > 0.0) {
                num += texelFetch(Sampler0, ivec2(x, s.y), 0).rgb * (m * w);
                den += m * w;
            }
        }
        w *= ratio;
        ratio *= ratioStep;
    }

    fragColor = vec4(den > 0.0 ? num / den : vec3(0.0), den / weightSum);
}
