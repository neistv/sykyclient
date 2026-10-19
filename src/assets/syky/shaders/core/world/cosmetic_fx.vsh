#version 330

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:projection.glsl>

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV1;
in ivec2 UV2;
in vec3 Normal;

out float sphericalVertexDistance;
out float cylindricalVertexDistance;
out vec4 vertexColor;
out vec2 texCoord0;
flat out int paletteRow;
out vec2 localPos;
out vec3 viewNormal;
out vec3 viewPos;

void main() {
    vec4 view = ModelViewMat * vec4(Position, 1.0);
    gl_Position = ProjMat * view;


    gl_Position.z -= 2.0e-5 * gl_Position.w;

    sphericalVertexDistance = fog_spherical_distance(Position);
    cylindricalVertexDistance = fog_cylindrical_distance(Position);
    vertexColor = Color;
    texCoord0 = UV0;
    paletteRow = UV1.x;
    localPos = vec2(UV2) / 1024.0;
    viewNormal = mat3(ModelViewMat) * Normal;
    viewPos = view.xyz;
}
