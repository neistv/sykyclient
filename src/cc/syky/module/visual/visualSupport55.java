package cc.syky.module.visual;

public final class visualSupport55 {
   private visualSupport55() {
   }

   public static int v1(int var0, int var1, int var2) {
      int var3 = var0 >>> 24 & 0xFF;
      if (var3 == 0) {
         return 0;
      } else {
         int var4 = v1(var2);
         int var5 = v2(var2);
         float var6 = var4 == 0 ? 0.0F : (float)(var4 - var5) / var4;
         float var7 = var4 / 255.0F;
         int var8 = v1(var1);
         int var9 = v2(var1);
         float var10 = var8 == 0 ? 0.0F : (float)(var8 - var9) / var8;
         float var11 = var8 / 255.0F;
         int var12 = v1(var0);
         int var13 = v2(var0);
         float var14 = var6 > 0.0F ? Math.clamp((float)(var12 - var13) / Math.max(var12, 1) * (var10 / var6), 0.0F, 1.0F) : var10;
         float var15 = var7 > 0.0F ? Math.clamp(var12 / 255.0F * (var11 / var7), 0.0F, 1.0F) : var11;
         int var16 = Math.round(var3 * ((var1 >>> 24 & 0xFF) / 255.0F));
         return var16 << 24 | v1(v2(var1, var8, var9), var14, var15);
      }
   }

   private static int v1(int var0) {
      return Math.max(var0 >>> 16 & 0xFF, Math.max(var0 >>> 8 & 0xFF, var0 & 0xFF));
   }

   private static int v2(int var0) {
      return Math.min(var0 >>> 16 & 0xFF, Math.min(var0 >>> 8 & 0xFF, var0 & 0xFF));
   }

   private static float v2(int var0, int var1, int var2) {
      int var3 = var1 - var2;
      if (var3 == 0) {
         return 0.0F;
      } else {
         int var4 = var0 >>> 16 & 0xFF;
         int var5 = var0 >>> 8 & 0xFF;
         int var6 = var0 & 0xFF;
         float var7;
         if (var1 == var4) {
            var7 = (float)(var5 - var6) / var3;
         } else if (var1 == var5) {
            var7 = 2.0F + (float)(var6 - var4) / var3;
         } else {
            var7 = 4.0F + (float)(var4 - var5) / var3;
         }

         var7 *= 60.0F;
         return var7 < 0.0F ? var7 + 360.0F : var7;
      }
   }

   private static int v1(float var0, float var1, float var2) {
      float var3 = var2 * var1;
      float var4 = var3 * (1.0F - Math.abs(var0 / 60.0F % 2.0F - 1.0F));
      float var5 = var2 - var3;
      float var6;
      float var7;
      float var8;
      if (var0 < 60.0F) {
         var6 = var3;
         var7 = var4;
         var8 = 0.0F;
      } else if (var0 < 120.0F) {
         var6 = var4;
         var7 = var3;
         var8 = 0.0F;
      } else if (var0 < 180.0F) {
         var6 = 0.0F;
         var7 = var3;
         var8 = var4;
      } else if (var0 < 240.0F) {
         var6 = 0.0F;
         var7 = var4;
         var8 = var3;
      } else if (var0 < 300.0F) {
         var6 = var4;
         var7 = 0.0F;
         var8 = var3;
      } else {
         var6 = var3;
         var7 = 0.0F;
         var8 = var4;
      }

      return v1(var6 + var5) << 16 | v1(var7 + var5) << 8 | v1(var8 + var5);
   }

   private static int v1(float var0) {
      return Math.round(Math.clamp(var0, 0.0F, 1.0F) * 255.0F);
   }
}
