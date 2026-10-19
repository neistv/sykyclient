package cc.syky.ui;

import cc.syky.hud.hudRecord4;
import java.util.List;

public final class uiSupport29 {
   private uiSupport29() {
   }

   public static void v1(hudRecord4 var0, hudRecord4 var1, float var2, uiSupport30 var3) {
      boolean var4 = v1(var0, var1) || v1(var1, var0);
      v1(true, var0, var1, var4, var2, var3);
      v1(false, var0, var1, var4, var2, var3);
   }

   private static boolean v1(hudRecord4 var0, hudRecord4 var1) {
      return var0.v2() >= var1.v2()
         && var0.v3() >= var1.v3()
         && var0.v2() + var0.v4() <= var1.v2() + var1.v4()
         && var0.v3() + var0.v5() <= var1.v3() + var1.v5();
   }

   public static void v1(hudRecord4 var0, List<hudRecord4> var1, float var2, float var3, float var4, uiSupport30 var5) {
      v1(true, var0, var1, var2, var4, var5);
      v1(false, var0, var1, var3, var4, var5);
   }

   private static void v1(boolean var0, hudRecord4 var1, hudRecord4 var2, boolean var3, float var4, uiSupport30 var5) {
      float var6 = uiSupport27.v1(var1, var0);
      float var7 = uiSupport27.v2(var1, var0);
      float var8 = uiSupport27.v1(var2, var0);
      float var9 = uiSupport27.v2(var2, var0);
      float var10 = uiSupport27.v3(var1, var0);
      float var11 = uiSupport27.v4(var1, var0);
      float var12 = uiSupport27.v3(var2, var0);
      float var13 = uiSupport27.v4(var2, var0);
      boolean var14 = uiSupport27.v1(var10, var11, var12, var13);
      float var15 = var14 ? (Math.max(var10, var12) + Math.min(var11, var13)) * 0.5F : (var10 + var11) * 0.5F;
      if (var8 >= var7) {
         v1(var0, var7, var8, var15, var4, var5);
         v1(var0, var8, var12, var13, var15, var14, var5);
      } else if (var9 <= var6) {
         v1(var0, var9, var6, var15, var4, var5);
         v1(var0, var9, var12, var13, var15, var14, var5);
      } else if (var3) {
         v1(var0, Math.min(var6, var8), Math.max(var6, var8), var15, var4, var5);
         v1(var0, Math.min(var7, var9), Math.max(var7, var9), var15, var4, var5);
      } else if (!var14) {
         boolean var16 = var12 >= var11;
         float var17 = var16 ? var11 : var10;
         float var18 = var16 ? var12 : var13;
         float var19 = (var17 + var18) * 0.5F;
         float var20 = Math.min(var10, var12);
         float var21 = Math.max(var11, var13);
         v1(var0, var6, var8, var17, var18, var19, var20, var21, var4, var5);
         v1(var0, var7, var9, var17, var18, var19, var20, var21, var4, var5);
      }
   }

   private static void v1(boolean var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, uiSupport30 var9) {
      if (Math.round(Math.abs(var1 - var2) / var8) == 0) {
         if (var0) {
            var9.v1(uiSupport30.Part1.ALIGN, var1, var6, var1, var7, 0);
         } else {
            var9.v1(uiSupport30.Part1.ALIGN, var6, var1, var7, var1, 0);
         }
      } else {
         v1(var0, Math.min(var1, var2), Math.max(var1, var2), var5, var8, var9);
         if (var0) {
            var9.v1(uiSupport30.Part1.HELPER, var1, var3, var1, var5, 0);
            var9.v1(uiSupport30.Part1.HELPER, var2, var4, var2, var5, 0);
         } else {
            var9.v1(uiSupport30.Part1.HELPER, var3, var1, var5, var1, 0);
            var9.v1(uiSupport30.Part1.HELPER, var4, var2, var5, var2, 0);
         }
      }
   }

   private static void v1(boolean var0, hudRecord4 var1, List<hudRecord4> var2, float var3, float var4, uiSupport30 var5) {
      float var6 = uiSupport27.v1(var1, var0);
      float var7 = uiSupport27.v2(var1, var0);
      float var8 = uiSupport27.v3(var1, var0);
      float var9 = uiSupport27.v4(var1, var0);
      float var10 = (var8 + var9) * 0.5F;
      hudRecord4 var11 = null;
      hudRecord4 var12 = null;
      int var13 = 0;

      for (int var14 = var2.size(); var13 < var14; var13++) {
         hudRecord4 var15 = (hudRecord4)var2.get(var13);
         if (uiSupport27.v1(var8, var9, uiSupport27.v3(var15, var0), uiSupport27.v4(var15, var0))) {
            if (uiSupport27.v2(var15, var0) <= var6 && (var11 == null || uiSupport27.v2(var15, var0) > uiSupport27.v2(var11, var0))) {
               var11 = var15;
            }

            if (uiSupport27.v1(var15, var0) >= var7 && (var12 == null || uiSupport27.v1(var15, var0) < uiSupport27.v1(var12, var0))) {
               var12 = var15;
            }
         }
      }

      if (var11 != null) {
         v1(var0, uiSupport27.v2(var11, var0), var6, v1(var11, var0, var8, var9), var4, var5);
      } else {
         v1(var0, 0.0F, var6, var10, var4, var5);
      }

      if (var12 != null) {
         v1(var0, var7, uiSupport27.v1(var12, var0), v1(var12, var0, var8, var9), var4, var5);
      } else {
         v1(var0, var7, var3, var10, var4, var5);
      }
   }

   private static float v1(hudRecord4 var0, boolean var1, float var2, float var3) {
      return (Math.max(var2, uiSupport27.v3(var0, var1)) + Math.min(var3, uiSupport27.v4(var0, var1))) * 0.5F;
   }

   private static void v1(boolean var0, float var1, float var2, float var3, float var4, uiSupport30 var5) {
      int var6 = Math.round((var2 - var1) / var4);
      if (var6 > 0) {
         if (var0) {
            var5.v1(uiSupport30.Part1.MEASURE, var1, var3, var2, var3, var6);
         } else {
            var5.v1(uiSupport30.Part1.MEASURE, var3, var1, var3, var2, var6);
         }
      }
   }

   private static void v1(boolean var0, float var1, float var2, float var3, float var4, boolean var5, uiSupport30 var6) {
      if (!var5) {
         float var7 = var4 < var2 ? var2 : var3;
         if (var0) {
            var6.v1(uiSupport30.Part1.HELPER, var1, var7, var1, var4, 0);
         } else {
            var6.v1(uiSupport30.Part1.HELPER, var7, var1, var4, var1, 0);
         }
      }
   }
}
