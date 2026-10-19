package cc.syky.ui;

import cc.syky.hud.AutoSupport;
import cc.syky.hud.hudSupport32;
import cc.syky.hud.hudSupport37;
import cc.syky.hud.hudSupport70;

public final class uiSupport31 {
   private static final String[] v1 = new String[1024];
   private final float[] v2 = new float[4];

   public uiSupport31() {
   }

   public void v1(hudSupport32 var1) {
      if (var1.v9().v1(this.v2)) {
         float var2 = var1.v7().v3;
         float var3 = uiSupport169.v1(this.v2[0]);
         float var4 = uiSupport169.v1(this.v2[1]);
         float var5 = uiSupport169.v1(this.v2[2]);
         float var6 = uiSupport169.v1(this.v2[3]);
         if (!(var5 <= var3) && !(var6 <= var4)) {
            float var7 = var5 - var3;
            float var8 = var6 - var4;
            float var9 = Math.min(6.0F * var2, Math.min(var7, var8) * 0.5F);
            uiRecord7 var10 = uiRecord7.v1(var9);
            if (hudSupport70.v1()) {
               uiSupport169.v1(var3, var4, var7, var8, var10, 0, 0.42F, 1.0F);
            } else {
               uiSupport169.v2(var3, var4, var7, var8, 1505278136, var10);
            }

            AutoSupport var11 = var1.v8().v2();
            float var12 = v1(2.0F, var2);
            if (var11.v7()) {
               uiSupport169.v2(var3, var4, var7, var8, var11.v13(), var12, var10);
            } else {
               uiSupport169.v1(var3, var4, var7, var8, var11.v13(), var12, var10);
            }
         }
      }
   }

   public void v2(hudSupport32 var1) {
      uiSupport30 var2 = var1.v9().v5();
      uiSupport30 var3 = var1.v10();
      if (var2.v2() != 0 || var3.v2() != 0) {
         uiSupport169.v1(null);

         try {
            hudSupport37 var4 = var1.v7();
            v1(var2, var4, true);
            v1(var3, var4, true);
            v1(var2, var4, false);
            v1(var3, var4, false);
            v1(var2, var4);
            v1(var3, var4);
         } finally {
            uiSupport169.v15();
         }
      }
   }

   private static void v1(uiSupport30 var0, hudSupport37 var1, boolean var2) {
      float var3 = var1.v3;
      float var4 = v1(2.0F, var3);
      float var5 = uiSupport169.v2();

      for (int var6 = 0; var6 < var0.v2(); var6++) {
         uiSupport30.Part2 var7 = var0.v1(var6);
         if (var7.v1 == uiSupport30.Part1.HELPER) {
            if (!var2) {
               v1(var7.v1(), var7.v1() ? var7.v2 : var7.v3, var7.v1() ? var7.v3 : var7.v2, var7.v1() ? var7.v5 : var7.v4, var5, 1946157055, false, var3);
            }
         } else {
            boolean var8 = var7.v1 == uiSupport30.Part1.ALIGN;
            byte var9 = -1;
            float var10 = var8 ? 5.0F * var3 : 0.0F;
            boolean var11 = var7.v1();
            float var12 = var11 ? var7.v2 : var7.v3;
            float var13 = (var11 ? var7.v3 : var7.v2) - var10;
            float var14 = (var11 ? var7.v5 : var7.v4) + var10;
            v1(var11, var12, var13, var14, var4, var9, var2, var3);
            if (!var8) {
               float var15 = 8.0F * var3 * 0.5F;
               v1(!var11, var13, var12 - var15, var12 + var15, var4, var9, var2, var3);
               v1(!var11, var14, var12 - var15, var12 + var15, var4, var9, var2, var3);
            }
         }
      }
   }

   private static void v1(boolean var0, float var1, float var2, float var3, float var4, int var5, boolean var6, float var7) {
      float var8 = uiSupport169.v1(var1 - var4 * 0.5F);
      float var9 = uiSupport169.v1(Math.min(var2, var3) - var4 * 0.5F);
      float var10 = uiSupport169.v1(Math.max(var2, var3) + var4 * 0.5F);
      float var11 = Math.max(var4, var10 - var9);
      float var12 = var0 ? var8 : var9;
      float var13 = var0 ? var9 : var8;
      float var14 = var0 ? var4 : var11;
      float var15 = var0 ? var11 : var4;
      if (var6) {
         uiSupport169.v1(var12, var13, var14, var15, var4 * 0.5F, 1493172224, 2.5F * var7, 0.0F, 0.0F);
      } else {
         uiSupport169.v1(var12, var13, var14, var15, var5, var4 * 0.5F);
      }
   }

   private static float v1(float var0, float var1) {
      return Math.max(uiSupport169.v2(), uiSupport169.v1(var0 * var1));
   }

   private static void v1(uiSupport30 var0, hudSupport37 var1) {
      float var2 = var1.v3;
      float var3 = 13.0F * var2;
      float var4 = 18.0F * var2;
      float var5 = 4.0F * var2;

      for (int var6 = 0; var6 < var0.v2(); var6++) {
         uiSupport30.Part2 var7 = var0.v1(var6);
         if (var7.v6 > 0) {
            String var8 = v1(var7.v6);
            float var9 = uiSupport169.v2("syky_sans", var8, var3);
            float var10 = Math.max(var4, var9 + 16.0F * var2);
            float var11 = (var7.v2 + var7.v4) * 0.5F;
            float var12 = (var7.v3 + var7.v5) * 0.5F;
            float var13 = Math.max(var5, Math.min(var11 - var10 * 0.5F, var1.v1 - var5 - var10));
            float var14 = Math.max(var5, Math.min(var12 - var4 * 0.5F, var1.v2 - var5 - var4));
            float var15 = uiSupport169.v1(var13);
            float var16 = uiSupport169.v1(var14);
            float var17 = uiSupport169.v1(var13 + var10) - var15;
            float var18 = uiSupport169.v1(var14 + var4) - var16;
            uiRecord7 var19 = uiRecord7.v1(var18 * 0.5F);
            uiSupport169.v1(var15, var16, var17, var18, var18 * 0.5F, 1711276032, 4.0F * var2, 0.0F, 1.0F * var2);
            uiSupport169.v1(var15, var16, var17, var18, -1, var19);
            uiSupport169.v1(
               "syky_sans", var8, uiSupport169.v1(var15 + (var17 - var9) * 0.5F), uiSupport169.v1(var16 + var18 * 0.5F - 0.600625F * var3), var3, -16777216
            );
         }
      }
   }

   private static String v1(int var0) {
      if (var0 >= 0 && var0 < v1.length) {
         String var1 = v1[var0];
         if (var1 == null) {
            var1 = Integer.toString(var0);
            v1[var0] = var1;
         }

         return var1;
      } else {
         return Integer.toString(var0);
      }
   }
}
