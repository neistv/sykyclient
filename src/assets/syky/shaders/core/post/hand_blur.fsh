#version 330









in vec2 texCoord;

layout(location = 0) out vec4 fragColor;

layout(std140) uniform HandBlurParams {
    vec4 Params;
    vec4 Weights;
};


float ign(vec2 p) {
    return fract(52.9829189 * fract(dot(p, vec2(0.06711056, 0.00583715))));
}

vec4 decode(vec4 stored) {
    return vec4(stored.rgb * stored.rgb, stored.a);
}

#ifdef COMPOSITE


uniform sampler2D Slice0Sampler;
uniform sampler2D Slice1Sampler;
uniform sampler2D Slice2Sampler;
uniform sampler2D Slice3Sampler;

void main() {
    vec4 m = decode(texture(Slice0Sampler, texCoord)) * Weights.x;
    if (Weights.y > 0.0) {
        m += decode(texture(Slice1Sampler, texCoord)) * Weights.y;
    }
    if (Weights.z > 0.0) {
        m += decode(texture(Slice2Sampler, texCoord)) * Weights.z;
    }
    if (Weights.w > 0.0) {
        m += decode(texture(Slice3Sampler, texCoord)) * Weights.w;
    }
    m /= Weights.x + Weights.y + Weights.z + Weights.w;
    if (m.a <= 0.0) {
        discard;
    }


    fragColor = vec4(sqrt(m.rgb / m.a) * m.a, m.a);
}

#else



uniform sampler2D Hand0Sampler;
uniform sampler2D Hand1Sampler;
uniform sampler2D Hand2Sampler;
uniform sampler2D Hand3Sampler;
uniform sampler2D AccumSampler;



vec4 lightOf(vec4 h) {
    return vec4(h.a > 0.0 ? h.rgb * h.rgb / h.a : vec3(0.0), h.a);
}

void main() {
    int count = int(Params.z + 0.5);
    vec4 pose = lightOf(texture(Hand0Sampler, texCoord));
    if (count > 1) {
        pose += lightOf(texture(Hand1Sampler, texCoord));
    }
    if (count > 2) {
        pose += lightOf(texture(Hand2Sampler, texCoord));
    }
    if (count > 3) {
        pose += lightOf(texture(Hand3Sampler, texCoord));
    }
    pose /= float(count);
    vec4 m = mix(decode(texture(AccumSampler, texCoord)), pose, Params.x);
    float d = (ign(gl_FragCoord.xy + vec2(Params.y * 5.588238, Params.y * 3.157)) - 0.5) / 255.0;
    fragColor = vec4(sqrt(m.rgb) + d, m.a + d);
}

#endif
