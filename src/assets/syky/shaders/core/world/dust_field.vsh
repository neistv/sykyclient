#version 330





layout(std140) uniform DustFieldData {
    mat4 ViewProj;
    vec4 Tint;
    vec4 Wrap;
    vec4 Motion;
    vec4 Field;
    vec4 Screen;
    vec4 Fade;
};

out vec2 vUv;
out vec4 vColor;



flat out vec4 vShape;





flat out float vDitherPhase;

const float TAU = 6.28318530718;

const float PHI = 0.6180339887;








const float MAX_GROWN_NDC = 0.22;

uint pcg(uint v) {
    uint state = v * 747796405u + 2891336453u;
    uint word = ((state >> ((state >> 28u) + 4u)) ^ state) * 277803737u;
    return (word >> 22u) ^ word;
}



vec2 split(uint h) {
    return vec2(float(h & 0xFFFFu), float(h >> 16u)) * (1.0 / 65535.0);
}

void main() {
    int pid = gl_VertexID / 6;
    int corner = gl_VertexID - pid * 6;

    vDitherPhase = fract(float(pid) * PHI);

    uint id = uint(pid);
    vec2 r01 = split(pcg(id));
    vec2 r23 = split(pcg(id + 0x9E3779B9u));
    vec2 r45 = split(pcg(id + 0x85EBCA6Bu));
    vec2 r67 = split(pcg(id + 0x165667B1u));

    float cell = Wrap.w;








    float t = Motion.x;
    vec3 drift = Motion.w
            * (0.7 + 0.6 * r67.y)
            * vec3(
                sin(t + r23.y * TAU),
                sin(2.0 * t + r45.x * TAU) * 0.65,
                sin(3.0 * t + r45.y * TAU) * 0.8);

    vec3 lattice = vec3(r01, r23.x) * cell;
    lattice.y += Motion.z;








    vec3 rel = mod(lattice + drift - Wrap.xyz + cell * 0.5, cell) - cell * 0.5;

    float edge = 1.0 - smoothstep(Fade.x, Fade.y, length(rel));




    edge *= clamp(Fade.w - float(pid), 0.0, 1.0);

    vec4 clip = ViewProj * vec4(rel, 1.0);




    if (clip.w < 0.05 || edge <= 0.002) {
        gl_Position = vec4(2.0, 2.0, 2.0, 1.0);
        vUv = vec2(0.0);
        vColor = vec4(0.0);
        vShape = vec4(1.0, 0.0, 0.0, 0.0);
        return;
    }




    vec2 r89 = split(pcg(id + 0xC2B2AE35u));
    vec2 rCD = split(pcg(id + 0x27D4EB2Fu));



    float rate = 2.0 + floor(rCD.y * 3.0);
    float twinkle = 0.5 + 0.5 * sin(rate * Motion.y + r89.x * TAU);

    float bright = 1.0 - Field.z * 0.85 * (1.0 - twinkle);






    float sort = rCD.x;
    float heat = r89.y;
    float mass = 0.6 * sort + 0.4 * heat;

    float size = Field.y * (0.6 + 0.8 * sort);
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
    vec3 tint = clamp(mix(grey, Tint.rgb, 0.8 + 0.4 * r67.x), 0.0, 1.0);

    vColor = vec4(tint, Tint.a * edge * bright * energy * (0.75 + 0.5 * heat));
    vShape = vec4(grow, sort, heat, 0.55 + 0.9 * mass);
}
