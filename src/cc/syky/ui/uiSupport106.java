package cc.syky.ui;

public final class uiSupport106 {
   private uiSupport106() {
   }

   public static void v1(uiSupport105 var0, float var1, float var2, float var3, float var4) {
      v1(var0, var1, var2, var3, var4, 1.0F, 0.0F);
   }

   public static void v1(uiSupport105 var0, float var1, float var2, float var3, float var4, float var5) {
      v1(var0, var1, var2, var3, var4, var5, 0.0F);
   }

   public static void v1(uiSupport105 var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var0.v1() * var3;
      float var8 = var0.v2() * var3;
      uiSupport169.v1(var1, var2, var7, var8, uiSupport155.v1(uiSupport155.v1(var0.v8(), var0.v9(), var4), var5), uiRecord7.v1(var0.v3() * var3));
      float var9 = var0.v4() * var3;
      float var10 = var0.v5() * var3;
      float var11 = var0.v7() * var3;
      float var12 = var7 - var9 - 2.0F * var11;
      float var13 = var1 + var11 + var12 * var4;
      float var14 = var2 + (var8 - var10) / 2.0F;
      float var15 = var0.v6() * var3;
      if (var0.v15()) {
         v1(var13, var14, var9, var10, var15, var3, var5);
      }

      int var16 = uiSupport155.v1(var0.v10(), var0.v11(), var4);
      if (var6 > 0.0F) {
         var16 = uiSupport155.v1(var16, SignInSupport.v61(), var6 * 0.25F);
      }

      uiSupport169.v1(var13, var14, var9, var10, uiSupport155.v1(var16, var5), uiRecord7.v1(var15));
      if (var0.v12()) {
         uiSupport169.v1(
            var13,
            var14,
            var9,
            var10,
            uiSupport155.v1(SignInSupport.v1(uiSupport155.v1(var0.v13(), var0.v14(), var4), var3), var5),
            SignInSupport.v2(var3),
            uiRecord7.v1(var15),
            1.0F
         );
      }
   }

   private static void v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = 2.0F * var5;
      uiSupport169.v1(
         var0 + var7,
         var1 + var7,
         var2 - 2.0F * var7,
         var3 - 2.0F * var7,
         Math.max(0.0F, var4 - var7),
         uiSupport155.v1(SignInSupport.v52(), var6),
         5.0F * var5,
         0.0F,
         3.0F * var5
      );
   }

   public static boolean v2(uiSupport105 var0, float var1, float var2, float var3, float var4, float var5) {
      float var6 = 2.0F * var5;
      return var1 >= var3 - var6 && var1 <= var3 + var0.v1() * var5 + var6 && var2 >= var4 - var6 && var2 <= var4 + var0.v2() * var5 + var6;
   }
}
