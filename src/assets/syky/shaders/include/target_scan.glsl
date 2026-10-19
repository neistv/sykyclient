// Target Marker's Scan (core/world/target_scan.fsh), the parts that are not its look: the sweep's path, how the surface
// shows through the light, the line's core, and the way the light leaves the shader. Import after fog.glsl, dynamictransforms.glsl and
// translucent_cover.glsl, whose uniforms the output reads.

// The sweep arrives as the target's height and a phase in radians (UV1, see render/world/scan/ScanVertices): the line
// runs a cosine path, slowing into each turn and crossing the body at speed, which is what a scanner does.

// Share of the height the line turns short of, at the feet and at the head. The owner's call (2026-10-15): run all the
// way to the soles and the crown and it reads as travelling too far.
const float SCAN_TURN_INSET = 0.05;

// Where the line is, in blocks above the feet.
float scanLine(float height, float phase) {
    return height * (SCAN_TURN_INSET + (1.0 - 2.0 * SCAN_TURN_INSET) * (0.5 - 0.5 * cos(phase)));
}

// The phase at which the line, rising, passes height y — in [0, π]; it passes it again falling at 2π minus that.
// Heights past either turn read as the turn.
float scanPhaseAt(float height, float y) {
    float u = clamp((y / height - SCAN_TURN_INSET) / (1.0 - 2.0 * SCAN_TURN_INSET), 0.0, 1.0);
    return acos(1.0 - 2.0 * u);
}

// How far the light reaches off the line, by the scan's presence (0 to 1): coming in, the line lights first and its
// glow spreads off it; going out, the glow draws back into the line before it goes.
float scanReach(float presence) {
    return mix(0.25, 1.0, presence);
}

// A hash with no trig: the same on every driver.
float scanHash(vec3 p) {
    p = fract(p * 0.1031);
    p += dot(p, p.zyx + 31.32);
    return fract((p.x + p.y) * p.z);
}

// The surface shows through the light: bright texels of the skin or the armour take more of it than dark ones.
float scanDetail(vec4 tex) {
    return 0.5 + 0.9 * dot(tex.rgb, vec3(0.299, 0.587, 0.114));
}

// Faces turned away from the eye catch more, which is what gives a box-built body volume under the line.
float scanEdge(vec3 viewNormal, vec3 viewPos) {
    float rim = 1.0 - abs(dot(normalize(viewNormal), normalize(-viewPos)));
    return 1.0 + 1.2 * rim * rim;
}

// The line's core at distance d from it, sigma `width`. Never thinner than about a pixel (`px`): a line under the
// raster's pitch flickers as the body moves. Widened, it keeps its energy, so a far target's line is softer and not
// brighter.
float scanCore(float d, float width, float px) {
    float sigma = max(width, px * 0.8);
    return exp(-0.5 * d * d / (sigma * sigma)) * (width / sigma);
}

// The fragment's final colour for `light`, or a discard where it adds nothing.
vec4 scanOutput(vec3 light, vec4 vertexColor, float sphericalDistance, float cylindricalDistance, float seed) {
    // Additive light fades into fog instead of mixing toward the fog colour, which would add the fog's colour.
    float fog = total_fog_value(sphericalDistance, cylindricalDistance, FogEnvironmentalStart, FogEnvironmentalEnd,
            FogRenderDistanceStart, FogRenderDistanceEnd);
    // The vertex alpha is the module's opacity times its glow, halved to fit a byte.
    light *= (1.0 - fog) * vertexColor.a * 2.0 * ColorModulator.rgb * ColorModulator.a;
    // Half a level of noise breaks the long soft ramps into grain instead of 8-bit steps.
    light += (scanHash(vec3(gl_FragCoord.xy, seed)) - 0.5) / 255.0;
    if (max(light.r, max(light.g, light.b)) < 0.003) {
        discard;
    }
    return vec4(max(light, 0.0), coverShow(gl_FragCoord.xy, gl_FragCoord.z));
}
