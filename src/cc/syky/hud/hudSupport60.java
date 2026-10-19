package cc.syky.hud;

public final class hudSupport60 {
   private hudSupport60() {
   }

   public static float v1(float var0) {
      return var0 * var0 * (3.0F - 2.0F * var0);
   }

   public static float v2(float var0) {
      float var1 = 1.0F - var0;
      return 1.0F - var1 * var1 * var1;
   }

   public static float v3(float var0) {
      return v1(var0, 0.34F, 1.15F, 0.64F, 1.0F);
   }

   public static float v4(float var0) {
      return v1(var0, 0.42F, 0.0F, 1.0F, 1.0F);
   }

   public static float v5(float var0) {
      if (var0 <= 0.0F) {
         return 0.0F;
      } else if (var0 >= 1.0F) {
         return 1.0F;
      } else {
         return var0 < 0.5F ? 4.0F * var0 * var0 * var0 : 1.0F - (float)Math.pow(-2.0F * var0 + 2.0F, 3.0) / 2.0F;
      }
   }

   public static float v1(float var0, float var1, float var2, float var3, float var4) {
      if (var0 <= 0.0F) {
         return 0.0F;
      } else if (var0 >= 1.0F) {
         return 1.0F;
      } else {
         float var5 = var0;

         for (int var6 = 0; var6 < 8; var6++) {
            float var7 = v1(var5, var1, var3);
            float var8 = v2(var5, var1, var3);
            if (Math.abs(var8) < 1.0E-6F) {
               break;
            }

            float var9 = (var7 - var0) / var8;
            var5 -= var9;
            if (Math.abs(var9) < 1.0E-6F) {
               break;
            }
         }

         return v1(var5, var2, var4);
      }
   }

   private static float v1(float var0, float var1, float var2) {
      float var3 = 1.0F - var0;
      return 3.0F * var3 * var3 * var0 * var1 + 3.0F * var3 * var0 * var0 * var2 + var0 * var0 * var0;
   }

   private static float v2(float var0, float var1, float var2) {
      float var3 = 1.0F - var0;
      return 3.0F * var3 * var3 * var1 + 6.0F * var3 * var0 * (var2 - var1) + 3.0F * var0 * var0 * (1.0F - var2);
   }
}
