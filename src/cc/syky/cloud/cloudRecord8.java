package cc.syky.cloud;

public record cloudRecord8(
   float exposure,
   float contrast,
   float saturation,
   float vibrance,
   float pivot,
   float highlights,
   float shadows,
   float whites,
   float blacks,
   float curve,
   float temperature,
   float tint,
   float splitStrength,
   float splitBalance,
   int splitShadowRgb,
   int splitHighlightRgb,
   float grayscale,
   cloudSupport56 bwFilter
) {
   public static final float NEUTRAL_PIVOT = 0.5F;
   public static final cloudRecord8 NEUTRAL = new cloudRecord8(
      0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 16777215, 16777215, 0.0F, cloudSupport56.NONE
   );

   public boolean v1() {
      return this.exposure == 0.0F
         && this.contrast == 0.0F
         && this.saturation == 0.0F
         && this.vibrance == 0.0F
         && this.highlights == 0.0F
         && this.shadows == 0.0F
         && this.whites == 0.0F
         && this.blacks == 0.0F
         && this.curve == 0.0F
         && this.temperature == 0.0F
         && this.tint == 0.0F
         && this.splitStrength == 0.0F
         && this.grayscale == 0.0F;
   }

   public float v2() {
      return this.exposure;
   }

   public float v3() {
      return this.contrast;
   }

   public float v4() {
      return this.saturation;
   }

   public float v5() {
      return this.vibrance;
   }

   public float v6() {
      return this.pivot;
   }

   public float v7() {
      return this.highlights;
   }

   public float v8() {
      return this.shadows;
   }

   public float v9() {
      return this.whites;
   }

   public float v10() {
      return this.blacks;
   }

   public float v11() {
      return this.curve;
   }

   public float v12() {
      return this.temperature;
   }

   public float v13() {
      return this.tint;
   }

   public float v14() {
      return this.splitStrength;
   }

   public float v15() {
      return this.splitBalance;
   }

   public int v16() {
      return this.splitShadowRgb;
   }

   public int v18() {
      return this.splitHighlightRgb;
   }

   public float v19() {
      return this.grayscale;
   }

   public cloudSupport56 v17() {
      return this.bwFilter;
   }
}
