package cc.syky.ui;

public final class uiSupport111 {
   private uiSupport111() {
   }

   public static int v1(uiSupport110 var0, float var1, float var2) {
      return uiSupport155.v1(uiSupport155.v1(var0.v7(), var0.v8(), var1), var0.v9(), var2);
   }

   public static void v1(uiSupport110 var0, float var1, float var2, float var3, int var4, float var5) {
      float var6 = var0.v3() * var3;
      float var7 = var0.v4() * var3;
      int var8 = uiSupport155.v1(var4, var5);
      uiRecord7 var9 = uiRecord7.v1(var6 / 2.0F);
      if (var0.v5()) {
         float var13 = var1 + (var0.v1() * var3 - var6) / 2.0F;
         float var14 = var2 + (var0.v2() * var3 - (3.0F * var6 + 2.0F * var7)) / 2.0F;

         for (int var15 = 0; var15 < 3; var15++) {
            uiSupport169.v1(var13, var14 + var15 * (var6 + var7), var6, var6, var8, var9);
         }
      } else {
         float var10 = var1 + (var0.v1() * var3 - (3.0F * var6 + 2.0F * var7)) / 2.0F;
         float var11 = var2 + (var0.v2() * var3 - var6) / 2.0F;

         for (int var12 = 0; var12 < 3; var12++) {
            uiSupport169.v1(var10 + var12 * (var6 + var7), var11, var6, var6, var8, var9);
         }
      }
   }

   public static boolean v1(uiSupport110 var0, float var1, float var2, float var3, float var4, float var5) {
      float var6 = var3 + var0.v1() * var5 / 2.0F;
      float var7 = var4 + var0.v2() * var5 / 2.0F;
      float var8 = var0.v6() * var5 / 2.0F;
      return var1 >= var6 - var8 && var1 <= var6 + var8 && var2 >= var7 - var8 && var2 <= var7 + var8;
   }
}
