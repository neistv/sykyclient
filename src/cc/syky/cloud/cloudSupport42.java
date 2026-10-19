package cc.syky.cloud;

public final class cloudSupport42 {
   private cloudSupport42() {
   }

   public static int v1(cloudRecord6 var0) {
      int var1 = var0.v2() - 1;
      int var2 = var0.v3() - 1;
      return 4 * (2 * var1 * var2 + 2 * var2 + 2 * var1);
   }

   public static int v1(cloudRecord6 var0, boolean var1) {
      return var1 ? 4 : 4 * (var0.v2() - 1) * (var0.v3() - 1);
   }

   public static int v1(cloudSupport41 var0, cloudSupport43 var1, float[] var2, float[] var3, boolean var4) {
      int var5 = var0.v2();
      int var6 = var0.v3();
      float[] var7 = var0.v4();
      float var8 = var0.v1().v6() * 0.5F;
      v1(var7, var5, var6, var2);
      int var9 = var4 ? var5 - 1 : 1;
      int var10 = var4 ? var6 - 1 : 1;
      int var11 = (var5 - 1) / var9;
      int var12 = (var6 - 1) / var10;
      int var13 = 0;

      for (int var14 = 0; var14 < 2; var14++) {
         for (int var15 = 0; var15 + var10 < var6; var15 += var10) {
            for (int var16 = 0; var16 + var9 < var5; var16 += var9) {
               int var17 = var15 * var5 + var16;
               int var18 = var17 + var9;
               int var19 = var17 + var10 * var5;
               int var20 = var19 + var9;
               var13 = var14 == 0
                  ? v1(var3, var13, var7, var2, var1, cloudSupport43.v2(), var5, var6, var8, var17, var18, var20, var19)
                  : v1(var3, var13, var7, var2, var1, cloudSupport43.v3(), var5, var6, -var8, var17, var19, var20, var18);
            }
         }
      }

      int var23 = 0;

      for (int var25 = 0; var23 + var10 < var6; var25++) {
         int var27 = var23 * var5;
         int var29 = var27 + var10 * var5;
         var13 = v1(var3, var13, var7, var2, var27, var29, var8, var1, cloudSupport43.v4(), var25, var12, false, -1);
         int var30 = var23 * var5 + var5 - 1;
         int var31 = var30 + var10 * var5;
         var13 = v1(var3, var13, var7, var2, var30, var31, var8, var1, cloudSupport43.v5(), var25, var12, false, 1);
         var23 += var10;
      }

      var23 = 0;

      for (int var26 = 0; var23 + var9 < var5; var26++) {
         int var28 = (var6 - 1) * var5 + var23;
         var13 = v1(var3, var13, var7, var2, var28, var28 + var9, var8, var1, cloudSupport43.v7(), var26, var11, true, var5);
         var13 = v1(var3, var13, var7, var2, var23, var23 + var9, var8, var1, cloudSupport43.v6(), var26, var11, true, -var5);
         var23 += var9;
      }

      return var13 / 8;
   }

   private static int v1(
      float[] var0,
      int var1,
      float[] var2,
      float[] var3,
      cloudSupport43 var4,
      int var5,
      int var6,
      int var7,
      float var8,
      int var9,
      int var10,
      int var11,
      int var12
   ) {
      float var13 = var8 >= 0.0F ? 1.0F : -1.0F;
      var1 = v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var13, var9);
      var1 = v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var13, var10);
      var1 = v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var13, var11);
      return v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var13, var12);
   }

   private static int v1(
      float[] var0, int var1, float[] var2, float[] var3, cloudSupport43 var4, int var5, int var6, int var7, float var8, float var9, int var10
   ) {
      int var11 = var10 * 3;
      int var12 = var10 % var6;
      int var13 = var10 / var6;
      float var14 = (float)var12 / (var6 - 1);
      float var15 = (float)var13 / (var7 - 1);
      var0[var1] = var2[var11] + var3[var11] * var8;
      var0[var1 + 1] = var2[var11 + 1] + var3[var11 + 1] * var8;
      var0[var1 + 2] = var2[var11 + 2] + var3[var11 + 2] * var8;
      var0[var1 + 3] = var4.v1(var5) + (var4.v3(var5) - var4.v1(var5)) * var14;
      var0[var1 + 4] = var4.v2(var5) + (var4.v4(var5) - var4.v2(var5)) * var15;
      var0[var1 + 5] = var3[var11] * var9;
      var0[var1 + 6] = var3[var11 + 1] * var9;
      var0[var1 + 7] = var3[var11 + 2] * var9;
      return var1 + 8;
   }

   private static int v1(
      float[] var0,
      int var1,
      float[] var2,
      float[] var3,
      int var4,
      int var5,
      float var6,
      cloudSupport43 var7,
      int var8,
      int var9,
      int var10,
      boolean var11,
      int var12
   ) {
      float var13 = 0.0F;
      float var14 = 0.0F;
      float var15 = 0.0F;
      int var16 = var4 - var12;
      if (var16 >= 0 && var16 < var2.length / 3) {
         var13 = var2[var4 * 3] - var2[var16 * 3];
         var14 = var2[var4 * 3 + 1] - var2[var16 * 3 + 1];
         var15 = var2[var4 * 3 + 2] - var2[var16 * 3 + 2];
      }

      float var17 = (float)Math.sqrt(var13 * var13 + var14 * var14 + var15 * var15);
      if (var17 > 1.0E-9F) {
         var13 /= var17;
         var14 /= var17;
         var15 /= var17;
      }

      float var18 = (float)var9 / var10;
      float var19 = (float)(var9 + 1) / var10;
      var1 = v1(var0, var1, var2, var3, var4, var6, var13, var14, var15, var7, var8, var11, var18, 0.0F);
      var1 = v1(var0, var1, var2, var3, var5, var6, var13, var14, var15, var7, var8, var11, var19, 0.0F);
      var1 = v1(var0, var1, var2, var3, var5, -var6, var13, var14, var15, var7, var8, var11, var19, 1.0F);
      return v1(var0, var1, var2, var3, var4, -var6, var13, var14, var15, var7, var8, var11, var18, 1.0F);
   }

   private static int v1(
      float[] var0,
      int var1,
      float[] var2,
      float[] var3,
      int var4,
      float var5,
      float var6,
      float var7,
      float var8,
      cloudSupport43 var9,
      int var10,
      boolean var11,
      float var12,
      float var13
   ) {
      int var14 = var4 * 3;
      var0[var1] = var2[var14] + var3[var14] * var5;
      var0[var1 + 1] = var2[var14 + 1] + var3[var14 + 1] * var5;
      var0[var1 + 2] = var2[var14 + 2] + var3[var14 + 2] * var5;
      float var15 = var11 ? var12 : var13;
      float var16 = var11 ? var13 : var12;
      var0[var1 + 3] = var9.v1(var10) + (var9.v3(var10) - var9.v1(var10)) * var15;
      var0[var1 + 4] = var9.v2(var10) + (var9.v4(var10) - var9.v2(var10)) * var16;
      var0[var1 + 5] = var6;
      var0[var1 + 6] = var7;
      var0[var1 + 7] = var8;
      return var1 + 8;
   }

   public static void v1(float[] var0, int var1, int var2, float[] var3) {
      for (int var4 = 0; var4 < var2; var4++) {
         int var5 = Math.max(0, var4 - 1);
         int var6 = Math.min(var2 - 1, var4 + 1);

         for (int var7 = 0; var7 < var1; var7++) {
            int var8 = (var4 * var1 + Math.max(0, var7 - 1)) * 3;
            int var9 = (var4 * var1 + Math.min(var1 - 1, var7 + 1)) * 3;
            int var10 = (var5 * var1 + var7) * 3;
            int var11 = (var6 * var1 + var7) * 3;
            float var12 = var0[var9] - var0[var8];
            float var13 = var0[var9 + 1] - var0[var8 + 1];
            float var14 = var0[var9 + 2] - var0[var8 + 2];
            float var15 = var0[var11] - var0[var10];
            float var16 = var0[var11 + 1] - var0[var10 + 1];
            float var17 = var0[var11 + 2] - var0[var10 + 2];
            float var18 = var13 * var17 - var14 * var16;
            float var19 = var14 * var15 - var12 * var17;
            float var20 = var12 * var16 - var13 * var15;
            float var21 = (float)Math.sqrt(var18 * var18 + var19 * var19 + var20 * var20);
            int var22 = (var4 * var1 + var7) * 3;
            if (var21 > 1.0E-9F) {
               var3[var22] = var18 / var21;
               var3[var22 + 1] = var19 / var21;
               var3[var22 + 2] = var20 / var21;
            } else {
               var3[var22] = 0.0F;
               var3[var22 + 1] = 0.0F;
               var3[var22 + 2] = 1.0F;
            }
         }
      }
   }
}
