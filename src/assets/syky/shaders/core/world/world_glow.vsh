#version 330

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:projection.glsl>

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV1;

out float sphericalVertexDistance;
out float cylindricalVertexDistance;
out vec4 vertexColor;
out vec2 quadCoord;




flat out vec2 orbShape;





flat out float spineHalf;






flat out float ditherPhase;

const float SHORT_SCALE = 1.0 / 32767.0;


const float PHI = 0.6180339887;

void main() {



    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    sphericalVertexDistance = fog_spherical_distance(Position);
    cylindricalVertexDistance = fog_cylindrical_distance(Position);

    vertexColor = Color * ColorModulator;
    quadCoord = UV0 * 2.0 - 1.0;
    orbShape = vec2(UV1) * SHORT_SCALE;
    spineHalf = max(abs(quadCoord.x) - 1.0, 0.0);



    ditherPhase = fract(float(gl_VertexID >> 2) * PHI);
}
