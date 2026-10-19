package cc.syky.internal;

public final class InternalSupport21 {
   private static final float[] v1 = new float[256];

   private InternalSupport21() {
   }

   public static int[] v1(int[] var0, int var1, int var2) {
      int var3 = Math.max(1, var1 / 2);
      int var4 = Math.max(1, var2 / 2);
      int[] var5 = new int[var3 * var4];

      for (int var6 = 0; var6 < var4; var6++) {
         int var7 = var6 * 2;
         int var8 = Math.min(var7 + 1, var2 - 1);

         for (int var9 = 0; var9 < var3; var9++) {
            int var10 = var9 * 2;
            int var11 = Math.min(var10 + 1, var1 - 1);
            var5[var6 * var3 + var9] = v1(var0[var7 * var1 + var10], var0[var7 * var1 + var11], var0[var8 * var1 + var10], var0[var8 * var1 + var11]);
         }
      }

      return var5;
   }

   public static int[] v1(int[] var0, int var1, int var2, int var3) {
      int[] var4 = var0;
      int var5 = var1;
      int var6 = var2;

      for (int var7 = 0; var7 < var3 && var5 > 1 && var6 > 1; var7++) {
         var4 = v1(var4, var5, var6);
         var5 = Math.max(1, var5 / 2);
         var6 = Math.max(1, var6 / 2);
      }

      return var4;
   }

   public static int[] v1(int[] var0, int var1, int var2, int var3, int var4) {
      if (var3 > 0 && var4 > 0 && var1 > 0 && var2 > 0) {
         if (var3 >= var1 && var4 >= var2) {
            return var0;
         } else {
            int var5 = Math.min(var3, var1);
            int var6 = Math.min(var4, var2);
            int[] var7 = new int[var5 * var6];

            for (int var8 = 0; var8 < var6; var8++) {
               int var9 = var8 * var2 / var6;
               int var10 = Math.max(var9 + 1, (var8 + 1) * var2 / var6);

               for (int var11 = 0; var11 < var5; var11++) {
                  int var12 = var11 * var1 / var5;
                  int var13 = Math.max(var12 + 1, (var11 + 1) * var1 / var5);
                  var7[var8 * var5 + var11] = v1(var0, var1, var12, var9, var13, var10);
               }
            }

            return var7;
         }
      } else {
         return var0;
      }
   }

   private static int v1(int[] var0, int var1, int var2, int var3, int var4, int var5) {
      float var6 = 0.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      float var10 = 0.0F;
      int var11 = 0;

      for (int var12 = var3; var12 < var5; var12++) {
         int var13 = var12 * var1;

         for (int var14 = var2; var14 < var4; var14++) {
            int var15 = var0[var13 + var14];
            float var16 = (var15 >>> 24) / 255.0F;
            var7 += var16;
            var6 += var16;
            var8 += v1(var15, 16, var16);
            var9 += v1(var15, 8, var16);
            var10 += v1(var15, 0, var16);
            var11++;
         }
      }

      if (var11 == 0) {
         return 0;
      } else {
         int var17 = Math.round(var7 / var11 * 255.0F);
         return var17 > 0 && !(var6 <= 0.0F) ? var17 << 24 | v1(var8 / var6) << 16 | v1(var9 / var6) << 8 | v1(var10 / var6) : 0;
      }
   }

   public static int v1(int var0, int var1, int var2, int var3) {
      float var4 = (var0 >>> 24) / 255.0F;
      float var5 = (var1 >>> 24) / 255.0F;
      float var6 = (var2 >>> 24) / 255.0F;
      float var7 = (var3 >>> 24) / 255.0F;
      float var8 = (var4 + var5 + var6 + var7) * 0.25F;
      if (var8 <= 0.0F) {
         return 0;
      } else {
         float var9 = var4 + var5 + var6 + var7;
         float var10 = v1(var0, 16, var4) + v1(var1, 16, var5) + v1(var2, 16, var6) + v1(var3, 16, var7);
         float var11 = v1(var0, 8, var4) + v1(var1, 8, var5) + v1(var2, 8, var6) + v1(var3, 8, var7);
         float var12 = v1(var0, 0, var4) + v1(var1, 0, var5) + v1(var2, 0, var6) + v1(var3, 0, var7);
         return Math.round(var8 * 255.0F) << 24 | v1(var10 / var9) << 16 | v1(var11 / var9) << 8 | v1(var12 / var9);
      }
   }

   private static float v1(int var0, int var1, float var2) {
      return v1[var0 >>> var1 & 0xFF] * var2;
   }

   private static int v1(float var0) {
      float var1 = var0 <= 0.0031308F ? var0 * 12.92F : 1.055F * (float)Math.pow(var0, 0.41666666F) - 0.055F;
      int var2 = Math.round(var1 * 255.0F);
      return Math.max(0, Math.min(255, var2));
   }

   static {
      for (int var0 = 0; var0 < 256; var0++) {
         float var1 = var0 / 255.0F;
         v1[var0] = var1 <= 0.04045F ? var1 / 12.92F : (float)Math.pow((var1 + 0.055F) / 1.055F, 2.4F);
      }
   }
}
