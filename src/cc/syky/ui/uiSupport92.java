package cc.syky.ui;

public final class uiSupport92 {
   public static final float v1 = 240.0F;
   public static final float v2 = 150.0F;
   public static final float v3 = 0.95F;
   public static final float v4 = 3.0F;
   public static final float v5 = 0.6F;
   public static final float v6 = 3.0F;
   public static final float v7 = 0.02F;

   private uiSupport92() {
   }

   public static float v1(float var0) {
      float var1 = var0 >= 0.6F ? 1.0F : Math.max(0.0F, var0) / 0.6F;
      float var2 = 1.0F - var1;
      return 1.0F - var2 * var2;
   }

   public static float v2(float var0) {
      return var0 >= 1.0F ? 1.0F : 1.0F - 0.050000012F * (1.0F - var0);
   }

   public static float v3(float var0) {
      if (var0 >= 1.0F) {
         return 0.0F;
      } else {
         float var1 = 1.0F - var0;
         return 3.0F * var1 * var1;
      }
   }

   public static float v4(float var0) {
      return var0 >= 1.0F ? 1.0F : 1.0F - (float)Math.pow(1.0F - var0, 3.0);
   }

   public static float v5(float var0) {
      return var0 >= 1.0F ? 1.0F : 1.0F - (float)Math.pow(1.0F - var0, 0.33333334F);
   }

   public static float v6(float var0) {
      return var0 >= 1.0F ? 0.0F : (float)Math.pow(1.0F - var0, 3.0);
   }

   public static float v7(float var0) {
      return var0 <= 0.0F ? 1.0F : 1.0F - (float)Math.pow(var0, 0.33333334F);
   }
}
