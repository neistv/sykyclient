package cc.syky.ui;

import cc.syky.hud.hudSupport57;

public final class uiSupport103 {
   public static final float v1 = 90.0F;
   private static final float v2 = 0.32F;
   private static final float v3 = 0.95F;
   private static final float v4 = 5.0F;
   private static final float v5 = 0.005F;
   private static final int v6 = 64;

   private uiSupport103() {
   }

   public static boolean v1() {
      return true;
   }

   public static hudSupport57 v1(float var0) {
      hudSupport57 var1 = new hudSupport57(var0, 90.0F);
      return v1() ? var1.v1(5.5555553E-5F) : var1;
   }

   public static float v2(float var0) {
      float var1 = (var0 - 0.32F) / 0.63F;
      return var1 <= 0.0F ? 0.0F : (var1 >= 1.0F ? 1.0F : var1);
   }

   public static float v3(float var0) {
      float var1 = var0 <= 0.0F ? 0.0F : (var0 >= 1.0F ? 1.0F : var0);
      return 5.0F * (1.0F - var1);
   }

   public static boolean v4(float var0) {
      return var0 <= 0.0F;
   }

   public static int v5(float var0) {
      return (int)(var0 * 64.0F);
   }
}
