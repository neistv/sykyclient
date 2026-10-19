package cc.syky.ui;

import net.minecraft.class_310;

public final class uiSupport89 {
   private uiSupport89() {
   }

   public static UiNode v1(UiNode var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var3 * var5;
      float var8 = var4 * var5;
      class_310 var9 = class_310.method_1551();
      float var10 = var9.method_22683().method_4486();
      float var11 = var9.method_22683().method_4502();
      float var12 = var1 + var7 > var10 ? var1 - var7 : var1;
      float var13 = var2 + var8 > var11 ? var2 - var8 : var2;
      var12 = v1(var12, var7, var6, var10);
      var13 = v1(var13, var8, 0.0F, var11);
      var0.v1(uiSupport169.v1(var12), uiSupport169.v1(var13), var7, var8);
      return var0;
   }

   public static UiNode v1(UiNode var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = var6 * var8;
      float var11 = var7 * var8;
      float var12 = var5 * var8;
      class_310 var13 = class_310.method_1551();
      float var14 = var13.method_22683().method_4486();
      float var15 = var13.method_22683().method_4502();
      float var16 = var1 + var2 - var12;
      if (var16 + var10 > var14) {
         var16 = var1 - var10 + var12;
      }

      var16 = v1(var16, var10, var9, var14);
      float var17 = var3 - var4 * var8;
      var17 = v1(var17, var11, 0.0F, var15);
      var0.v1(uiSupport169.v1(var16), uiSupport169.v1(var17), var10, var11);
      return var0;
   }

   public static float v1(float var0, float var1, float var2, float var3) {
      return Math.max(var2, Math.min(var0, Math.max(var2, var3 - var1)));
   }
}
