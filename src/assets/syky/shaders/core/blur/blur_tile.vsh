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

flat out int tile;

void main() {
    vec2 corners[6] = vec2[](
        vec2(0.0, 0.0),
        vec2(1.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 0.0),
        vec2(1.0, 1.0),
        vec2(0.0, 1.0)
    );

    Tile t = tiles[gl_InstanceID];
    vec2 origin = screen.w > 0.5 ? t.src.xy : t.dst.xy;
    vec2 p = (origin + corners[gl_VertexID] * t.dst.zw) / target.xy * 2.0 - 1.0;
    gl_Position = vec4(p, 0.0, 1.0);
    tile = gl_InstanceID;
}
