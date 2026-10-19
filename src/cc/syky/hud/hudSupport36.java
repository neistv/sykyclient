package cc.syky.hud;

import cc.syky.ui.uiSupport27;
import java.util.Arrays;
import java.util.Comparator;

public final class hudSupport36 {
   private hudSupport36() {
   }

   public static void v1(
      hudSupport36.Part1 var0, float[] var1, float[] var2, float[] var3, float[] var4, int var5, float var6, float var7, float var8, float var9
   ) {
      if (var5 > 0 && var0.v1(var5)) {
         float var10;
         float var11;
         float var12;
         float var13;
         if (var5 == 1) {
            float var14 = var8 * var9;
            var10 = var14;
            var11 = var14;
            var12 = var6 - var14;
            var13 = var7 - var14;
         } else {
            var10 = Float.POSITIVE_INFINITY;
            var11 = Float.POSITIVE_INFINITY;
            var12 = Float.NEGATIVE_INFINITY;
            var13 = Float.NEGATIVE_INFINITY;

            for (int var17 = 0; var17 < var5; var17++) {
               var10 = Math.min(var10, var1[var17]);
               var11 = Math.min(var11, var2[var17]);
               var12 = Math.max(var12, var1[var17] + var3[var17]);
               var13 = Math.max(var13, var2[var17] + var4[var17]);
            }
         }

         float var18 = var5 == 1 ? var6 * 0.5F : (var10 + var12) * 0.5F;
         float var15 = var5 == 1 ? var7 * 0.5F : (var11 + var13) * 0.5F;
         switch (var0) {
            case LEFT:
               for (int var23 = 0; var23 < var5; var23++) {
                  var1[var23] = uiSupport27.v1(var10, var9);
               }
               break;
            case CENTER_H:
               for (int var22 = 0; var22 < var5; var22++) {
                  var1[var22] = uiSupport27.v1(var18 - var3[var22] * 0.5F, var9);
               }
               break;
            case RIGHT:
               for (int var21 = 0; var21 < var5; var21++) {
                  var1[var21] = uiSupport27.v1(var12 - var3[var21], var9);
               }
               break;
            case TOP:
               for (int var20 = 0; var20 < var5; var20++) {
                  var2[var20] = uiSupport27.v1(var11, var9);
               }
               break;
            case CENTER_V:
               for (int var19 = 0; var19 < var5; var19++) {
                  var2[var19] = uiSupport27.v1(var15 - var4[var19] * 0.5F, var9);
               }
               break;
            case BOTTOM:
               for (int var16 = 0; var16 < var5; var16++) {
                  var2[var16] = uiSupport27.v1(var13 - var4[var16], var9);
               }
               break;
            case DISTRIBUTE_H:
               v1(var1, var3, var5, var9);
               break;
            case DISTRIBUTE_V:
               v1(var2, var4, var5, var9);
         }
      }
   }

   private static void v1(float[] var0, float[] var1, int var2, float var3) {
      Integer[] var4 = new Integer[var2];

      for (int var5 = 0; var5 < var2; var5++) {
         var4[var5] = var5;
      }

      Arrays.sort(var4, Comparator.comparingDouble(var1x -> var0[var1x]));
      int var14 = var4[0];
      int var6 = var4[var2 - 1];
      float var7 = var0[var14];
      float var8 = Math.max(var0[var6] + var1[var6], var7);
      float var9 = 0.0F;

      for (int var10 = 0; var10 < var2; var10++) {
         var9 += var1[var10];
      }

      float var15 = (var8 - var7 - var9) / (var2 - 1);
      float var11 = var1[var14];

      for (int var12 = 1; var12 < var2 - 1; var12++) {
         int var13 = var4[var12];
         var0[var13] = uiSupport27.v1(var7 + var11 + var15 * var12, var3);
         var11 += var1[var13];
      }
   }

   public static enum Part1 {
      LEFT,
      CENTER_H,
      RIGHT,
      TOP,
      CENTER_V,
      BOTTOM,
      DISTRIBUTE_H,
      DISTRIBUTE_V;

      private Part1() {
      }

      public boolean v1() {
         return this == DISTRIBUTE_H || this == DISTRIBUTE_V;
      }

      public boolean v1(int var1) {
         return this.v1() ? var1 >= 3 : var1 >= 1;
      }
   }
}
