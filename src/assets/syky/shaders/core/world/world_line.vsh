#version 330

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:projection.glsl>

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV1;
in ivec2 UV2;
in vec3 Normal;









out vec3 camRel;
out vec4 vertexColor;




out vec2 perpOffset;



flat out vec3 axisDir;


flat out vec2 crossHalf;




out vec2 axialEnds;



const float HALF_SCALE = 0.25 / 32767.0;


const float AXIAL_SCALE = 1.0 / 512.0;

void main() {


    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    camRel = Position;
    vertexColor = Color * ColorModulator;
    perpOffset = UV0;
    axisDir = abs(Normal);
    crossHalf = vec2(UV2) * HALF_SCALE;
    axialEnds = vec2(UV1) * AXIAL_SCALE;
}
