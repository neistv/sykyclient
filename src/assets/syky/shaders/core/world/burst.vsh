#version 330






layout(std140) uniform BurstData {
    mat4 ViewProj;
    vec4 Tint;
    vec4 Field;
    vec4 Screen;
    vec4 Motion;
    vec4 Counts;




    vec4 Emitters[512];
};

out vec2 vUv;
out vec4 vColor;


flat out vec4 vShape;

flat out float vDitherPhase;

const float TAU = 6.28318530718;
const float PHI = 0.6180339887;




const float LIFE_MIN = 0.75;
const float LIFE_RANGE = 0.5;



const float ATTACK = 0.06;

const float MAX_GROWN_NDC = 0.22;

uint pcg(uint v) {
    uint state = v * 747796405u + 2891336453u;
    uint word = ((state >> ((state >> 28u) + 4u)) ^ state) * 277803737u;
    return (word >> 22u) ^ word;
}


vec2 split(uint h) {
    return vec2(float(h & 0xFFFFu), float(h >> 16u)) * (1.0 / 65535.0);
}

void collapse() {



    gl_Position = vec4(2.0, 2.0, 2.0, 1.0);
    vUv = vec2(0.0);
    vColor = vec4(0.0);
    vShape = vec4(1.0, 0.0, 0.0, 0.0);
}

void main() {
    int pid = gl_VertexID / 6;
    int corner = gl_VertexID - pid * 6;

    int perEmitter = max(int(Counts.x), 1);
    int emitter = pid / perEmitter;
    int local = pid - emitter * perEmitter;

    vec4 origin = Emitters[emitter * 2];
    vec4 spray = Emitters[emitter * 2 + 1];

    vDitherPhase = fract(float(pid) * PHI);

    uint id = uint(local) + uint(spray.w) * 8191u;
    vec2 r01 = split(pcg(id));
    vec2 r23 = split(pcg(id + 0x9E3779B9u));
    vec2 r45 = split(pcg(id + 0x85EBCA6Bu));

    float age = origin.w;
    float life = Counts.y * (LIFE_MIN + LIFE_RANGE * r45.x);
    float t = age / life;
    if (t >= 1.0) {
        collapse();
        return;
    }



    float cz = mix(1.0, Motion.w, r01.y);
    float sz = sqrt(max(1.0 - cz * cz, 0.0));
    float az = r01.x * TAU;

    vec3 axis = spray.xyz;
    vec3 guide = abs(axis.y) < 0.9 ? vec3(0.0, 1.0, 0.0) : vec3(1.0, 0.0, 0.0);
    vec3 t1 = normalize(cross(guide, axis));
    vec3 t2 = cross(axis, t1);
    vec3 dir = t1 * (cos(az) * sz) + t2 * (sin(az) * sz) + axis * cz;




    float v0 = Motion.x * (0.55 + 0.9 * r23.x);
    float k = max(Motion.z, 0.001);
    float travel = v0 * (1.0 - exp(-k * age)) / k;
    vec3 rel = origin.xyz + dir * travel - vec3(0.0, 0.5 * Motion.y * age * age, 0.0);

    vec4 clip = ViewProj * vec4(rel, 1.0);
    if (clip.w < 0.05) {
        collapse();
        return;
    }


    vec2 r67 = split(pcg(id + 0x165667B1u));
    vec2 r89 = split(pcg(id + 0xC2B2AE35u));

    float sort = r67.x;
    float heat = r67.y;
    float mass = 0.6 * sort + 0.4 * heat;



    float fall = 1.0 - t;
    float fade = fall * fall * smoothstep(0.0, ATTACK, t);



    float size = Field.y * (0.6 + 0.8 * sort) * (0.4 + 0.6 * fall);
    float halfH = size * Screen.y / clip.w;
    float clamped = clamp(halfH, Screen.z, Screen.w);
    float scale = clamped / halfH;
    float halfW = size * Screen.x / clip.w * scale;



    float energy = 1.0 / max(scale * scale, 1.0);

    vec2 corners[6] = vec2[](
        vec2(-1.0, -1.0),
        vec2(1.0, -1.0),
        vec2(1.0, 1.0),
        vec2(-1.0, -1.0),
        vec2(1.0, 1.0),
        vec2(-1.0, 1.0)
    );
    vec2 c = corners[corner];





    float grow = 1.0 + (Field.x - 1.0) * (0.85 + 0.3 * mass);
    grow = min(grow, max(MAX_GROWN_NDC / max(clamped, 1.0e-6), 1.0));



    gl_Position = vec4(clip.xy + c * vec2(halfW, clamped) * grow * clip.w, clip.z, clip.w);

    vUv = c;

    vec3 grey = vec3(dot(Tint.rgb, vec3(0.2126, 0.7152, 0.0722)));
    vec3 tint = clamp(mix(grey, Tint.rgb, 0.8 + 0.4 * r89.x), 0.0, 1.0);

    vColor = vec4(tint, Tint.a * fade * energy * (0.75 + 0.5 * heat));
    vShape = vec4(grow, sort, heat, 0.55 + 0.9 * mass);
}
