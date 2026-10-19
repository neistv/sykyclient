#version 330

#moj_import <syky:ground_ring.glsl>
#moj_import <syky:translucent_cover.glsl>




in vec2 vLocal;
flat in vec4 vColor;
flat in vec2 vTurn;
flat in vec3 vArc;
flat in int vRing;

uniform sampler2D Sampler0;

layout(location = 0) out vec4 fragColor;

void main() {
    float r2 = dot(vLocal, vLocal);
    float r = sqrt(r2);
    float px = fwidth(r);
    vec3 shape = arcShape(vLocal, r, vArc.xy, vArc.z);
    float taper = shape.x;


    float own = RIM_WIDTH * taper;
    float width = max(own, px * RIM_MIN_PX);
    float off = (r - 1.0) / width;
    if (r > Params.z || abs(off) > RIM_BAND) {
        discard;
    }

    if (gl_FragCoord.z > texelFetch(Sampler0, ivec2(gl_FragCoord.xy), 0).r) {
        discard;
    }
    float sw = sweepAt(vLocal, 1.0 / max(r2, 1.0e-6), vTurn);
    float soft = discSoft(r, shape, sw);
    float edge = 1.0 - smoothstep(Params.z * 0.7, Params.z, r);
    float rim = exp(-off * off) * (own / width);
    float hot = rim * (1.0 + SWEEP_GAIN * sw) * edge;




    float drive = clamp(rim * (1.0 + 0.6 * sw) - 0.55, 0.0, 1.0);
    vec3 light = vColor.rgb * hot + drive * (1.0 - vColor.rgb) * (hot + soft);



    float jitter = (fract(dither(gl_FragCoord.xy) + float(vRing) * PHI) - 0.5) * (1.5 / 255.0);
    vec3 lit = clamp(light * vColor.a + jitter, 0.0, 1.0);
    float level = max(max(lit.r, lit.g), lit.b);
    if (level < 0.0035) {
        discard;
    }


    fragColor = vec4(lit / level, level * coverShow(gl_FragCoord.xy, gl_FragCoord.z));
}
