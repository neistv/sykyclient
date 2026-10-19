package cc.syky.module.visual;

public final class visualSupport32 {
   private visualSupport32() {
   }

   public static float v1(float var0, boolean var1, float var2, float var3) {
      float var4 = var1 ? 0.0F : 1.0F;
      float var5 = var3 <= 0.0F ? 1.0F : Math.clamp(Math.max(0.0F, var2) / var3, 0.0F, 1.0F);
      if (var0 < var4) {
         return Math.min(var4, var0 + var5);
      } else {
         return var0 > var4 ? Math.max(var4, var0 - var5) : var0;
      }
   }

   public static float v1(float var0, float var1) {
      float var2 = Math.clamp(var0, 0.0F, 1.0F);
      float var3 = var2 * var2 * (3.0F - 2.0F * var2);
      return 1.0F - Math.clamp(var1, 0.0F, 1.0F) * var3;
   }
}
