package cc.syky.ui;

public final class uiSupport5 {
   private final float v1;
   private final float v2;
   private final int v3;
   private final boolean v4;
   private final float v5;
   private float v6;
   private float v7;

   public uiSupport5(float var1, float var2, int var3, boolean var4) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
      this.v5 = v3(var1, var2);
   }

   public void v1(float var1) {
      float var2 = (float)Math.exp(-this.v1 * var1);
      float var3 = this.v2 * var1;
      float var4 = (float)Math.cos(var3);
      float var5 = (float)Math.sin(var3);
      float var6 = v1(var1, this.v3, this.v4);
      this.v6 = var2 * var4 * var6;
      this.v7 = var2 * (this.v1 * var4 + this.v2 * var5) / this.v5 * var6;
   }

   public float v1() {
      return this.v6;
   }

   public float v2() {
      return this.v7;
   }

   public static float v1(float var0, int var1, boolean var2) {
      float var3 = var0;

      for (int var4 = 1; var4 < var1; var4++) {
         var3 *= var0;
      }

      float var5 = 1.0F - var3;
      return var2 ? var5 * var5 : var5;
   }

   public static float v1(float var0, float var1) {
      float var2 = var0 / var1;
      if (var2 >= 1.0F) {
         return 0.0F;
      } else {
         float var3 = 1.0F - var2;
         return var3 * var3;
      }
   }

   public static float v2(float var0, float var1) {
      float var2 = var0 / var1;
      return var2 >= 1.0F ? 1.0F : var2;
   }

   private static float v3(float var0, float var1) {
      double var2 = Math.atan2(var0, var1);
      double var4 = Math.atan2(var1, var0);
      double var6 = (var4 - var2) / var1;
      return var6 <= 0.0 ? var0 : (float)(Math.exp(-var0 * var6) * Math.hypot(var0, var1) * Math.sin(var4));
   }
}
