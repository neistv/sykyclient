package cc.syky.cloud;

public record cloudRecord5(float weightEm, float outlineEm, int outlineArgb, float fadeX0, float fadeX1, float fadeRampL, float fadeRampR) {
   public static final float NO_FADE_BOUND = 1.0E9F;
   public static final cloudRecord5 NONE = new cloudRecord5(0.0F, 0.0F, 0, -1.0E9F, 1.0E9F, 0.0F, 0.0F);

   public static cloudRecord5 v1(float var0, int var1) {
      return NONE.v2(var0, var1);
   }

   public static cloudRecord5 v1(float var0) {
      return NONE.v2(var0);
   }

   public cloudRecord5 v2(float var1, int var2) {
      return new cloudRecord5(this.weightEm, var1, var2, this.fadeX0, this.fadeX1, this.fadeRampL, this.fadeRampR);
   }

   public cloudRecord5 v2(float var1) {
      return new cloudRecord5(var1, this.outlineEm, this.outlineArgb, this.fadeX0, this.fadeX1, this.fadeRampL, this.fadeRampR);
   }

   public cloudRecord5 v1(float var1, float var2, float var3) {
      return this.v1(var1, var2, var3, var3);
   }

   public cloudRecord5 v1(float var1, float var2, float var3, float var4) {
      return new cloudRecord5(this.weightEm, this.outlineEm, this.outlineArgb, var1, var2, var3, var4);
   }

   public cloudRecord5 v1(float var1, float var2) {
      return this.v1(-1.0E9F, var1, 0.0F, var2);
   }

   public boolean v1() {
      return this.outlineEm > 0.0F && this.outlineArgb >>> 24 != 0;
   }

   public float v2() {
      return this.weightEm;
   }

   public float v3() {
      return this.outlineEm;
   }

   public int v4() {
      return this.outlineArgb;
   }

   public float v5() {
      return this.fadeX0;
   }

   public float v6() {
      return this.fadeX1;
   }

   public float v7() {
      return this.fadeRampL;
   }

   public float v8() {
      return this.fadeRampR;
   }
}
