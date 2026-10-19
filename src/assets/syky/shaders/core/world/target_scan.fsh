#version 330

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:globals.glsl>
#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <syky:translucent_cover.glsl>
#moj_import <syky:target_scan.glsl>



uniform sampler2D Sampler0;

in float sphericalVertexDistance;
in float cylindricalVertexDistance;
in vec4 vertexColor;
in vec2 texCoord0;
in vec3 bodyPos;
flat in vec2 scan;
flat in float presence;
in vec3 viewNormal;
in vec3 viewPos;

layout(location = 0) out vec4 fragColor;

const float TAU = 6.28318530718;


const float CORE_WIDTH = 0.017;
const float BLOOM_FALL = 0.07;
const float HALO_FALL = 0.24;
const float CORE_WHITE = 0.85;
const float WAVE = 0.026;
const float WAVE_LENGTH = 0.62;


const float WAVE_LAPS = 420.0;


const float AFTERGLOW = 1.15;

const float TRAIL_REACH = 0.32;

const float TURN_SOFTNESS = 2.0;
const float TIP_FALL = 0.08;

void main() {

    float px = fwidth(bodyPos.y);

    vec4 tex = texture(Sampler0, texCoord0);
    if (tex.a < 0.1) {
        discard;
    }

    float height = scan.x;
    float phase = scan.y;
    float reach = scanReach(presence);




    vec2 screenX = vec2(ModelViewMat[0][0], ModelViewMat[2][0]);
    float across = dot(screenX, bodyPos.xz) / max(length(screenX), 1.0e-3);
    float k = TAU / WAVE_LENGTH;
    float arg = k * across - TAU * fract(GameTime * WAVE_LAPS);

    float amplitude = WAVE * presence;
    float wave = amplitude * sin(arg);


    float slope = amplitude * k * cos(arg);
    float level = bodyPos.y - wave;
    float d = (level - scanLine(height, phase)) * inversesqrt(1.0 + slope * slope);
    float ad = abs(d);
    float core = scanCore(d, CORE_WIDTH * mix(0.6, 1.0, presence), px);
    float bloom = exp(-ad / max(BLOOM_FALL * reach, px));
    float halo = exp(-ad / (HALO_FALL * reach));




    float rise = scanPhaseAt(height, level);
    float since = min(mod(phase - rise, TAU), mod(phase + rise, TAU));
    float trail = pow(max(0.0, 1.0 - since / (AFTERGLOW * reach)), 1.6);



    float lo = height * SCAN_TURN_INSET;
    trail *= smoothstep(0.0, TURN_SOFTNESS * lo, min(level - lo, height - lo - level));


    trail *= 1.0 - smoothstep(0.0, TRAIL_REACH * height * reach, ad);

    vec3 tint = vertexColor.rgb;
    vec3 white = mix(tint, vec3(1.0), CORE_WHITE);
    float trail2 = trail * trail;

    float tip = 0.22 * trail2 * trail2 * exp(-ad / TIP_FALL);
    vec3 light = tint * (bloom + 0.22 * halo + 0.9 * trail) * scanDetail(tex) * scanEdge(viewNormal, viewPos)
            + white * (core * 1.5 + tip);
    fragColor = scanOutput(light, vertexColor, sphericalVertexDistance, cylindricalVertexDistance, phase);
}
