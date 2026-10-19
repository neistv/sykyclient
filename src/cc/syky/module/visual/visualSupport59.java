package cc.syky.module.visual;

public enum visualSupport59 {
   CUSTOM(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
   NEUTRAL(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
   VIVID(0.0F, 18.0F, 20.0F, 35.0F, -15.0F, 8.0F, 0.0F, 0.0F, 25.0F, 0.0F, 0.0F, 0.0F, 0.0F),
   WARM(0.0F, 10.0F, 10.0F, 25.0F, -10.0F, 5.0F, 0.0F, 0.0F, 15.0F, 30.0F, 6.0F, 0.0F, 0.0F),
   COOL(0.0F, 10.0F, 8.0F, 20.0F, -8.0F, 5.0F, 0.0F, 0.0F, 15.0F, -28.0F, -4.0F, 0.0F, 0.0F),
   CINEMATIC(0.0F, 22.0F, -8.0F, 10.0F, -30.0F, 18.0F, 0.0F, -10.0F, 45.0F, 0.0F, 0.0F, 45.0F, 0.0F),
   FADED(0.0F, -12.0F, -20.0F, 0.0F, 0.0F, 25.0F, 0.0F, 18.0F, 20.0F, 0.0F, 0.0F, 30.0F, 0.0F),
   MONO(0.0F, 20.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 30.0F, 0.0F, 0.0F, 0.0F, 100.0F);

   private final float exposure;
   private final float contrast;
   private final float saturation;
   private final float vibrance;
   private final float highlights;
   private final float shadows;
   private final float whites;
   private final float blacks;
   private final float curve;
   private final float temperature;
   private final float tint;
   private final float split;
   private final float grayscale;

   private visualSupport59(
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15
   ) {
      this.exposure = var3;
      this.contrast = var4;
      this.saturation = var5;
      this.vibrance = var6;
      this.highlights = var7;
      this.shadows = var8;
      this.whites = var9;
      this.blacks = var10;
      this.curve = var11;
      this.temperature = var12;
      this.tint = var13;
      this.split = var14;
      this.grayscale = var15;
   }

   public float v1() {
      return this.exposure;
   }

   public float v2() {
      return this.contrast;
   }

   public float v3() {
      return this.saturation;
   }

   public float v4() {
      return this.vibrance;
   }

   public float v5() {
      return this.highlights;
   }

   public float v6() {
      return this.shadows;
   }

   public float v7() {
      return this.whites;
   }

   public float v8() {
      return this.blacks;
   }

   public float v9() {
      return this.curve;
   }

   public float v10() {
      return this.temperature;
   }

   public float v11() {
      return this.tint;
   }

   public float v12() {
      return this.split;
   }

   public float v13() {
      return this.grayscale;
   }

   public boolean v14() {
      return this.highlights != 0.0F || this.shadows != 0.0F || this.whites != 0.0F || this.blacks != 0.0F || this.curve != 0.0F;
   }

   public boolean v15() {
      return this.temperature != 0.0F || this.tint != 0.0F;
   }
}
