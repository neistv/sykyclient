package cc.syky.ui;

public final class uiSupport206 {
   private uiSupport206() {
   }

   public static int v1(int var0, int var1, float var2) {
      float var3 = (var1 >>> 24) / 255.0F * Math.clamp(var2, 0.0F, 1.0F);
      float var4 = (var0 >>> 24) / 255.0F;
      float var5 = var4 * (1.0F - var3);
      float var6 = var3 + var5;
      if (var6 <= 0.0F) {
         return var0;
      } else {
         int var7 = v1(var1 >> 16, var0 >> 16, var3, var5, var6);
         int var8 = v1(var1 >> 8, var0 >> 8, var3, var5, var6);
         int var9 = v1(var1, var0, var3, var5, var6);
         return Math.round(var6 * 255.0F) << 24 | var7 << 16 | var8 << 8 | var9;
      }
   }

   private static int v1(int var0, int var1, float var2, float var3, float var4) {
      return Math.round(((var0 & 0xFF) * var2 + (var1 & 0xFF) * var3) / var4);
   }
}
