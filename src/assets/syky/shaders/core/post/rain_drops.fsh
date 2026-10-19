#version 330

in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

uniform sampler2D Sampler0;



const int RUN_VECTORS = 896;

layout(std140) uniform RainParams {
    vec4 Screen;
    vec4 Field;
    vec4 Look;
    vec4 Layout;
    vec4 Runs[RUN_VECTORS];
};

















const float WET = 0.3;


const float REFRACTION = 0.001;


const float BEAD_CELL = 1.0 / 40.0;


const float RUN_COLUMN = 1.0 / 12.0;
const float RUN_SMALL = 1.0 / 1.85;

uint pcg(uint v) {
    uint state = v * 747796405u + 2891336453u;
    uint word = ((state >> ((state >> 28u) + 4u)) ^ state) * 277803737u;
    return (word >> 22u) ^ word;
}



vec4 roll(ivec2 cell, uint salt) {
    uint h = pcg(uint(cell.x) * 0x8DA6B343u ^ uint(cell.y) * 0xD8163841u ^ salt);
    return vec4(float(h & 255u), float((h >> 8u) & 255u), float((h >> 16u) & 255u), float(h >> 24u)) / 256.0;
}



void addDrop(vec2 p, vec2 centre, float reach, vec2 shape, float strength, inout float field, inout vec2 slope) {
    if (reach <= 0.0 || strength <= 0.0) {
        return;
    }
    vec2 d = (p - centre) / (reach * shape);
    float q = length(d);
    if (q >= 1.0) {
        return;
    }
    field += strength * (1.0 - q * q * (3.0 - 2.0 * q));
    slope -= strength * 6.0 * (1.0 - q) * d / (reach * shape);
}



float pathX(float y, float centre, float wander, vec2 seed) {
    float w = y * 20.0 + seed.x * 6.28;
    return centre + wander * sin(w + sin(w)) * (seed.y - 0.5) * 2.0;
}

struct Run {
    float x;
    float wander;
    vec2 seed;
    float top;
    float head;
    float reach;
    float speed;
    float age;
};


Run runAt(int column, float width, bool small, int back) {
    Run r;
    int first = int(small ? Layout.z : Layout.x);
    int count = int(small ? Layout.w : Layout.y);
    int c = column - first;
    r.reach = 0.0;
    if (c < 0 || c >= count) {
        return r;
    }
    int i = ((small ? int(Layout.y) : 0) + c) * 4 + back * 2;
    vec4 a = Runs[i];
    vec4 b = Runs[i + 1];
    r.x = a.x;
    r.top = a.y;
    r.head = a.z;
    r.reach = a.w;
    r.speed = b.x;
    r.age = b.y;
    r.seed = b.zw;
    r.wander = width * 0.12;
    return r;
}



float cleared(Run r, vec2 p) {
    if (r.reach <= 0.0 || p.y < r.head || p.y > r.top + r.reach) {
        return 0.0;
    }
    float off = abs(p.x - pathX(p.y, r.x, r.wander, r.seed));
    return (1.0 - smoothstep(0.5, 0.9, off / r.reach)) * (1.0 - smoothstep(1.0, 1.4, r.age));
}



void runners(vec2 p, bool small, float strength, inout float field, inout vec2 slope) {
    if (strength <= 0.0) {
        return;
    }
    float width = RUN_COLUMN * (small ? RUN_SMALL : 1.0) * Field.w;
    int column = int(floor(p.x / width));
    for (int back = 0; back < 2; back++) {
        Run r = runAt(column, width, small, back);

        if (r.reach <= 0.0 || r.age > 1.4 || p.y > r.top + r.reach || p.y < r.head - 1.5 * r.reach) {
            continue;
        }
        if (r.age <= 1.0) {
            float x = pathX(r.head, r.x, r.wander, r.seed);
            addDrop(p, vec2(x, r.head), r.reach, vec2(1.0, 1.0 + 0.5 * r.speed), strength, field, slope);
        }


        float spacing = r.reach * 2.4;
        float j = floor((r.top - p.y) / spacing);
        if (j < 0.0) {
            continue;
        }
        vec4 c = roll(ivec2(column, int(j)), uint(r.seed.x * 65536.0) ^ (small ? 0x9E3779B9u : 0u));
        float y = r.top - (j + 0.5 + (c.y - 0.5) * 0.3) * spacing;
        if (y >= r.head + r.reach * 1.2) {
            float behind = (y - r.head) / max(r.top - r.head, 1.0e-4);
            float fade = sqrt(1.0 - behind) * (1.0 - smoothstep(1.0, 1.4, r.age));
            float x = pathX(y, r.x, r.wander, r.seed);
            addDrop(p, vec2(x, y), r.reach * mix(0.55, 0.8, c.z), vec2(1.0), strength * fade, field, slope);
        }
    }
}



float wipedAt(vec2 p, bool small) {
    float width = RUN_COLUMN * (small ? RUN_SMALL : 1.0) * Field.w;
    int column = int(floor(p.x / width));
    return max(cleared(runAt(column, width, small, 0), p), cleared(runAt(column, width, small, 1), p));
}


void beads(vec2 p, inout float field, inout vec2 slope) {
    if (Field.y <= 0.0) {
        return;
    }
    float cell = BEAD_CELL * Field.w;
    ivec2 id = ivec2(floor(p / cell));
    float clock = Field.x + roll(id, 11u).x;
    float index = floor(clock);
    float life = clock - index;
    vec4 a = roll(id, 12u ^ (uint(mod(index, Screen.w)) * 0x85EBCA6Bu));
    float strength = Field.y * a.y * smoothstep(0.0, 0.025, life) * smoothstep(1.0, 0.025, life);
    if (strength <= WET * 0.5) {


        return;
    }
    vec2 centre = (vec2(id) + 0.5 + (a.zw - 0.5) * 0.4) * cell;
    float wiped = Field.z > 0.0 ? max(wipedAt(centre, false), wipedAt(centre, true)) : 0.0;
    addDrop(p, centre, cell * 0.3, vec2(1.0), strength * (1.0 - wiped), field, slope);
}

void main() {
    vec2 p = (texCoord - 0.5) * vec2(Screen.z, 1.0);
    float field = 0.0;
    vec2 slope = vec2(0.0);
    runners(p, false, Field.z * 0.7, field, slope);
    runners(p, true, Field.z, field, slope);
    beads(p, field, slope);

    float x = clamp((field - WET) / (1.0 - WET), 0.0, 1.0);
    vec2 uv = clamp(texCoord + slope * (6.0 * x * (1.0 - x) / (1.0 - WET)) * REFRACTION * Look.x,
            vec2(0.0), vec2(1.0));



    vec2 dx = dFdx(uv) * 0.25;
    vec2 dy = dFdy(uv) * 0.25;
    if (field <= WET) {
        discard;
    }
    vec3 colour = texture(Sampler0, uv + dx + dy).rgb + texture(Sampler0, uv + dx - dy).rgb
            + texture(Sampler0, uv - dx + dy).rgb + texture(Sampler0, uv - dx - dy).rgb;
    fragColor = vec4(colour * 0.25, 1.0);
}
