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

uniform sampler2D Sampler0;

flat in int tile;

layout(location = 0) out vec4 fragColor;

void main() {
    Tile t = tiles[tile];
    ivec2 a = ivec2(gl_FragCoord.xy) - ivec2(t.src.xy) + ivec2(t.dst.xy);
    fragColor = texelFetch(Sampler0, a, 0);
}
