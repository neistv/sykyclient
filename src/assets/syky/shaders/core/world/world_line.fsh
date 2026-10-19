#version 330

in vec3 camRel;
in vec4 vertexColor;
in vec2 perpOffset;
flat in vec3 axisDir;
flat in vec2 crossHalf;
in vec2 axialEnds;

layout(location = 0) out vec4 fragColor;

#ifdef GROUPED


#ifdef OCCLUDED
uniform sampler2D Sampler0;
#endif
#endif






const float MIN_HALF_PIXELS = 0.6;

void main() {


    vec3 axis = axisDir;
    vec3 e1 = axis.x > 0.5 ? vec3(0.0, 1.0, 0.0) : (axis.y > 0.5 ? vec3(0.0, 0.0, 1.0) : vec3(1.0, 0.0, 0.0));
    vec3 e2 = cross(axis, e1);




    vec3 axisPoint = camRel - (e1 * perpOffset.x + e2 * perpOffset.y);







    vec3 ray = normalize(camRel);
    vec3 sideRaw = cross(axis, ray);
    float sideLength = length(sideRaw);
    vec3 side = sideRaw / max(sideLength, 1.0e-6);






    float offset = dot(axisPoint, side);





    float ramp = max(length(vec2(dFdx(offset), dFdy(offset))), 1.0e-7);
    float dist = abs(offset);




    float halfWidth = crossHalf.x * abs(dot(side, e1)) + crossHalf.y * abs(dot(side, e2));









    float distPx = dist / ramp;
    float halfPx = max(halfWidth / ramp, MIN_HALF_PIXELS);
    float coverage = clamp(min(distPx + 0.5, halfPx) - max(distPx - 0.5, -halfPx), 0.0, 1.0);



    coverage = mix(1.0, coverage, step(1.0e-4, sideLength));














    vec2 perpCam = -vec2(dot(axisPoint, e1), dot(axisPoint, e2));
    vec2 perpRay = vec2(dot(ray, e1), dot(ray, e2));


    vec2 crossing = mix(perpRay, vec2(1.0e-6), step(abs(perpRay), vec2(1.0e-6)));
    vec2 tA = (-crossHalf - perpCam) / crossing;
    vec2 tB = (crossHalf - perpCam) / crossing;
    float tEnter = max(max(min(tA.x, tB.x), min(tA.y, tB.y)), 0.0);
    float tExit = min(max(tA.x, tB.x), max(tA.y, tB.y));



    float alongAxis = dot(ray, axis);
    float depth = length(camRel);
    float sEnter = (tEnter - depth) * alongAxis;
    float sExit = (tExit - depth) * alongAxis;
    coverage *= step(0.0, min(max(sEnter, sExit) + axialEnds.x, axialEnds.y - min(sEnter, sExit)));

    if (coverage < (1.0 / 255.0)) {
        discard;
    }
#ifdef SEAL










    if (coverage < 0.5) {
        discard;
    }
    fragColor = vec4(0.0);
    return;
#endif
    float alpha = vertexColor.a * coverage;
#ifdef GROUPED
#ifdef OCCLUDED
    if (gl_FragCoord.z > texelFetch(Sampler0, ivec2(gl_FragCoord.xy), 0).r) {
        discard;
    }
#endif




    gl_FragDepth = 1.0 - alpha;
#endif
    fragColor = vec4(vertexColor.rgb, alpha);
}
