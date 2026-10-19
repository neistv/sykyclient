package cc.syky.module.visual;

import cc.syky.ui.uiSupport155;

public final class visualSupport19 {
   private static final double v1 = Math.PI * 2;
   private static final long v2 = 1800L;
   private static final double v3 = 0.15;
   private static final double v4 = 0.8;
   private static final int v5 = 64;
   private static final double v6 = 0.035;
   private static final float v7 = 0.9F;
   private static final double v8 = 1.18;
   private static final double v9 = 0.4;
   private static final float v10 = 0.95F;
   private static final double v11 = 2.2;
   private static final int v12 = 6;
   private static final double v13 = 1.7;
   private static final float v14 = 0.85F;
   private static final double v15 = 0.16;

   private visualSupport19() {
   }

   private static void v1(long var0, double[] var2) {
      double var3 = var0 % 1800L / 1800.0;
      var2[0] = 0.5 - 0.5 * Math.cos((Math.PI * 2) * var3);
      var2[1] = Math.sin((Math.PI * 2) * var3);
   }

   private static void v1(double var0, double var2, double var4, double var6, int var8, int var9) {
      double var10 = var2 - 0.035;
      double var12 = var2 + 0.035;
      double var14 = var0 + var6;
      double var16 = var4;

      for (int var18 = 1; var18 <= 64; var18++) {
         double var19 = (Math.PI * 2) * var18 / 64.0;
         double var21 = var0 + Math.cos(var19) * var6;
         double var23 = var4 + Math.sin(var19) * var6;
         visualSupport9.v1(var14, var10, var16, var21, var10, var23, var21, var2, var23, var14, var2, var16, var9, var8);
         visualSupport9.v1(var14, var12, var16, var21, var12, var23, var21, var2, var23, var14, var2, var16, var9, var8);
         var14 = var21;
         var16 = var23;
      }
   }

   private static int v1(double var0, int var2, float var3) {
      float var4 = 0.85F * (float)Math.max(0.0, 1.0 - var0 / 0.16);
      float var5 = (float)Math.pow(1.0 - var0, 2.2);
      return uiSupport155.v1(uiSupport155.v1(var2, -1, var4), var3 * var5);
   }

   private static void v1(double var0, double var2, double var4, double var6, double var8, int var10, float var11) {
      for (int var12 = 0; var12 < 6; var12++) {
         double var13 = Math.pow(var12 / 6.0, 1.7);
         double var15 = Math.pow((var12 + 1.0) / 6.0, 1.7);
         int var17 = v1(var13, var10, var11);
         int var18 = v1(var15, var10, var11);
         double var19 = var2 + var8 * var13;
         double var21 = var2 + var8 * var15;
         double var23 = var0 + var6;
         double var25 = var4;

         for (int var27 = 1; var27 <= 64; var27++) {
            double var28 = (Math.PI * 2) * var27 / 64.0;
            double var30 = var0 + Math.cos(var28) * var6;
            double var32 = var4 + Math.sin(var28) * var6;
            visualSupport9.v1(var23, var19, var25, var30, var19, var32, var30, var21, var32, var23, var21, var25, var17, var18);
            var23 = var30;
            var25 = var32;
         }
      }
   }

   public static void v1(double var0, double var2, double var4, double var6, double var8, float var10, int var11, float var12, float var13) {
      if (!(var12 <= 0.0F) && !(var10 <= 0.0F)) {
         double[] var14 = new double[2];
         v1(System.currentTimeMillis(), var14);
         double var15 = var8 + 0.15;
         double var17 = var2 + var15 * var14[0];
         double var19 = 1.0 + 0.17999999999999994 * (1.0F - var10);
         double var21 = var6 * 0.8 * var19;
         double var23 = -var14[1] * var8 * 0.4;
         if (var23 != 0.0) {
            v1(var0, var17, var4, var21, var23, var11, var12 * 0.95F * Math.min(1.5F, var13));
         }

         v1(var0, var17, var4, var21, uiSupport155.v1(uiSupport155.v1(var11, -1, 0.9F), var12), uiSupport155.v1(var11, 0.0F));
      }
   }
}
