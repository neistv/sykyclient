package cc.syky.cloud;

public record cloudRecord6(
   int columns,
   int rows,
   float width,
   float height,
   float thickness,
   float pinY,
   float pinZ,
   float gravity,
   float drag,
   float airResistance,
   float bendStiffness,
   float wind,
   float bodyDepth,
   float bodyHalfWidth
) {
   public static final int MAX_PARTICLES = 1024;

   public cloudRecord6(
      int columns,
      int rows,
      float width,
      float height,
      float thickness,
      float pinY,
      float pinZ,
      float gravity,
      float drag,
      float airResistance,
      float bendStiffness,
      float wind,
      float bodyDepth,
      float bodyHalfWidth
   ) {
      if (columns >= 2 && rows >= 2 && columns * rows <= 1024) {
         v1("width", width, 0.01F, 4.0F);
         v1("height", height, 0.01F, 4.0F);
         v1("thickness", thickness, 0.0F, 0.5F);
         v1("pinY", pinY, -4.0F, 4.0F);
         v1("pinZ", pinZ, -4.0F, 4.0F);
         v1("gravity", gravity, 0.0F, 100.0F);
         v1("drag", drag, 0.0F, 50.0F);
         v1("airResistance", airResistance, 0.0F, 20.0F);
         v1("bendStiffness", bendStiffness, 0.0F, 1.0F);
         v1("wind", wind, 0.0F, 50.0F);
         v1("bodyDepth", bodyDepth, 0.0F, 4.0F);
         v1("bodyHalfWidth", bodyHalfWidth, 0.0F, 2.0F);
         this.columns = columns;
         this.rows = rows;
         this.width = width;
         this.height = height;
         this.thickness = thickness;
         this.pinY = pinY;
         this.pinZ = pinZ;
         this.gravity = gravity;
         this.drag = drag;
         this.airResistance = airResistance;
         this.bendStiffness = bendStiffness;
         this.wind = wind;
         this.bodyDepth = bodyDepth;
         this.bodyHalfWidth = bodyHalfWidth;
      } else {
         throw new IllegalArgumentException("cloth grid " + columns + "x" + rows + " is outside 2x2..1024");
      }
   }

   public static cloudRecord6 v1() {
      return new cloudRecord6(7, 11, 0.625F, 1.0F, 0.0625F, 0.0F, 0.15625F, 14.0F, 1.2F, 0.5F, 0.35F, 0.25F, 1.5F, 0.3125F);
   }

   private static void v1(String var0, float var1, float var2, float var3) {
      if (!(var1 >= var2) || !(var1 <= var3)) {
         throw new IllegalArgumentException("cloth " + var0 + " = " + var1 + " is outside [" + var2 + ", " + var3 + "]");
      }
   }

   public int v2() {
      return this.columns;
   }

   public int v3() {
      return this.rows;
   }

   public float v4() {
      return this.width;
   }

   public float v5() {
      return this.height;
   }

   public float v6() {
      return this.thickness;
   }

   public float v7() {
      return this.pinY;
   }

   public float v8() {
      return this.pinZ;
   }

   public float v9() {
      return this.gravity;
   }

   public float v10() {
      return this.drag;
   }

   public float v11() {
      return this.airResistance;
   }

   public float v12() {
      return this.bendStiffness;
   }

   public float v13() {
      return this.wind;
   }

   public float v14() {
      return this.bodyDepth;
   }

   public float v15() {
      return this.bodyHalfWidth;
   }
}
