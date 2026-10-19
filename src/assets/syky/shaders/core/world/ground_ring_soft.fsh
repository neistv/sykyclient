#version 330

#moj_import <syky:ground_ring.glsl>
#moj_import <syky:translucent_cover.glsl>






layout(std140) uniform GlowRect {
    vec4 Rect;
    vec4 Scale;
};

uniform sampler2D Sampler0;

layout(location = 0) out vec4 fragColor;



float aura(vec3 q, vec2 turn, vec2 facing, float halfAngle) {
    float r2 = dot(q.xz, q.xz);
    float r = sqrt(r2);
    float rho = r - 1.0;
    vec3 shape = arcShape(q.xz, r, facing, halfAngle);
    float d2 = (rho * rho + q.y * q.y) / (shape.z * shape.z);

    float window = max(1.0 - d2 / (AURA_REACH * AURA_REACH), 0.0);
    window *= window;
    float sw = sweepAt(q.xz, 1.0 / max(r2, 1.0e-6), turn);
    return window / (1.0 + d2 / (AURA_SIGMA * AURA_SIGMA)) * (1.0 + 0.5 * sw) * shape.y;
}

void main() {


    int n = int(Scale.x + 0.5);
    ivec2 size = textureSize(Sampler0, 0);
    ivec2 last = size - 1;
    ivec2 base = ivec2(gl_FragCoord.xy) * n;
    float depth = 0.0;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
            depth = max(depth, texelFetch(Sampler0, min(base + ivec2(x, y), last), 0).r);
        }
    }


    vec2 ndc = gl_FragCoord.xy * float(n) / vec2(size) * 2.0 - 1.0;
    vec4 farPoint = InvViewProj * vec4(ndc, 1.0, 1.0);
    vec3 dir = normalize(farPoint.xyz / farPoint.w);
    float scene = 1.0e9;
    if (depth < 1.0) {
        vec4 p = InvViewProj * vec4(ndc, depth * 2.0 - 1.0, 1.0);
        scene = length(p.xyz / p.w);
    }


    vec2 cover = coverAt(vec2(min(base + ivec2(n / 2), last)) + 0.5);
    float front = 1.0e9;
    if (cover.x > 0.0 && cover.y < 1.0) {
        vec4 p = InvViewProj * vec4(ndc, cover.y * 2.0 - 1.0, 1.0);
        front = length(p.xyz / p.w);
    }
    float behind = 1.0 - cover.x;
    vec3 inv = 1.0 / mix(dir, vec3(1.0e-6), equal(dir, vec3(0.0)));
    float jitter = dither(gl_FragCoord.xy);

    vec3 light = vec3(0.0);
    int count = int(Params.y + 0.5);
    for (int i = 0; i < count; i++) {
        vec4 reach = Rings[i * 4 + 3];
        if (ndc.x < reach.x || ndc.y < reach.y || ndc.x > reach.z || ndc.y > reach.w) {
            continue;
        }
        vec4 centre = Rings[i * 4];
        vec4 colour = Rings[i * 4 + 1];
        vec4 extra = Rings[i * 4 + 2];
        float radius = centre.w;

        vec3 o = -(centre.xyz + vec3(0.0, LIFT, 0.0)) / radius;
        float sceneT = scene / radius;
        float frontT = front / radius;
        vec2 turn = extra.zw;
        vec2 facing = arcFacing(centre.xyz);
        float halfAngle = extra.x;
        float soft = 0.0;


        if (abs(dir.y) > 1.0e-6) {
            float tp = -o.y / dir.y;
            if (tp > 0.0 && tp <= sceneT) {
                vec2 q = o.xz + dir.xz * tp;
                float r2 = dot(q, q);
                float r = sqrt(r2);
                if (r < Params.z) {
                    soft += discSoft(r, arcShape(q, r, facing, halfAngle), sweepAt(q, 1.0 / max(r2, 1.0e-6), turn))
                            * (tp > frontT ? behind : 1.0);
                }
            }
        }


        float rise = extra.y;
        if (rise > 0.0) {
            vec3 t0 = (vec3(-BOX_OUT, -BOX_HALF, -BOX_OUT) - o) * inv;
            vec3 t1 = (vec3(BOX_OUT, BOX_HALF, BOX_OUT) - o) * inv;
            vec3 near = min(t0, t1);
            vec3 far = max(t0, t1);
            float from = max(max(max(near.x, near.y), near.z), 0.0);
            float to = min(min(min(far.x, far.y), far.z), sceneT);
            float a2 = dot(dir.xz, dir.xz);
            float b2 = dot(o.xz, dir.xz);
            float c2 = dot(o.xz, o.xz) - BOX_OUT * BOX_OUT;
            if (a2 > 1.0e-8) {
                float disc2 = b2 * b2 - a2 * c2;
                if (disc2 <= 0.0) {
                    to = from;
                } else {
                    float root = sqrt(disc2);
                    from = max(from, (-b2 - root) / a2);
                    to = min(to, (-b2 + root) / a2);
                }
            } else if (c2 > 0.0) {
                to = from;
            }
            if (to > from) {
                int steps = clamp(int(ceil((to - from) / AURA_STEP)), AURA_MIN_STEPS, AURA_STEPS);
                float dt = (to - from) / float(steps);


                float t = from + dt * fract(jitter + float(i) * PHI);
                float sum = 0.0;

                float sumFront = -1.0;
                for (int s = 0; s < steps; s++) {
                    if (sumFront < 0.0 && t > frontT) {
                        sumFront = sum;
                    }
                    sum += aura(o + dir * t, turn, facing, halfAngle);
                    t += dt;

                    if (sum * dt > AURA_SATURATED) {
                        break;
                    }
                }


                float all = 1.0 - exp(-AURA_GAIN * sum * dt);
                float near = sumFront < 0.0 ? all : 1.0 - exp(-AURA_GAIN * sumFront * dt);
                soft += (near + (all - near) * behind) * rise;
            }
        }

        light += colour.rgb * colour.a * soft;
    }



    fragColor = vec4(clamp(light + (jitter - 0.5) * (1.5 / 255.0), 0.0, 1.0), 1.0);
}
