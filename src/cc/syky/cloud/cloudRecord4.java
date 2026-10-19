package cc.syky.cloud;

import org.joml.Matrix4f;

public record cloudRecord4(
   Matrix4f invViewProj,
   Matrix4f viewProj,
   float anchorX,
   float anchorZ,
   float height,
   float time,
   float columnX,
   float columnZ,
   float fracX,
   float fracZ,
   float puddles,
   float ripples,
   float drops,
   float reflection,
   float darkening,
   boolean shelter,
   int debug,
   int steps,
   float reach,
   float traceScale,
   float focalY,
   int skyColor,
   int glowColor,
   float sunX,
   float sunY,
   float sunZ,
   boolean sharpMirrors,
   boolean water
) {
   public Matrix4f v1() {
      return this.invViewProj;
   }

   public Matrix4f v2() {
      return this.viewProj;
   }

   public float v3() {
      return this.anchorX;
   }

   public float v4() {
      return this.anchorZ;
   }

   public float v5() {
      return this.height;
   }

   public float v6() {
      return this.time;
   }

   public float v7() {
      return this.columnX;
   }

   public float v8() {
      return this.columnZ;
   }

   public float v9() {
      return this.fracX;
   }

   public float v10() {
      return this.fracZ;
   }

   public float v11() {
      return this.puddles;
   }

   public float v12() {
      return this.ripples;
   }

   public float v13() {
      return this.drops;
   }

   public float v14() {
      return this.reflection;
   }

   public float v15() {
      return this.darkening;
   }

   public boolean v16() {
      return this.shelter;
   }

   public int v18() {
      return this.debug;
   }

   public int v19() {
      return this.steps;
   }

   public float v17() {
      return this.reach;
   }

   public float v20() {
      return this.traceScale;
   }

   public float v21() {
      return this.focalY;
   }

   public int v22() {
      return this.skyColor;
   }

   public int v24() {
      return this.glowColor;
   }

   public float v25() {
      return this.sunX;
   }

   public float v26() {
      return this.sunY;
   }

   public float v27() {
      return this.sunZ;
   }

   public boolean v28() {
      return this.sharpMirrors;
   }

   public boolean v29() {
      return this.water;
   }
}
