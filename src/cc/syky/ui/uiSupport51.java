package cc.syky.ui;

import cc.syky.cloud.cloudSupport16;

public final class uiSupport51 {
   private uiSupport51() {
   }

   public static float v1(int var0) {
      float var1 = uiSupport169.v2("syky_sans_strong", Integer.toString(var0), 12.0F);
      return Math.max(20.0F, var1 + 12.0F);
   }

   public static float v1(float var0) {
      return SignInSupport.v4(20.0F, var0);
   }

   public static void v1(float var0, float var1, int var2, float var3, float var4) {
      String var5 = Integer.toString(var2);
      float var6 = 12.0F * var3;
      float var7 = uiSupport169.v2("syky_sans_strong", var5, var6);
      float var8 = SignInSupport.v4(20.0F, var3);
      float var9 = Math.max(var8, uiSupport169.v1(var7 + 12.0F * var3));
      uiRecord7 var10 = uiRecord7.v1(var8 / 2.0F);
      uiSupport169.v1(var0 - var9, var1, var9, var8, uiSupport155.v1(cloudSupport16.v6(), var4), var10);
      uiSupport169.v1(var0 - var9, var1, var9, var8, uiSupport155.v1(SignInSupport.v1(cloudSupport16.v7(), var3), var4), SignInSupport.v2(var3), var10, 1.0F);
      uiSupport169.v1(
         "syky_sans_strong",
         var5,
         var0 - var9 + (var9 - var7) / 2.0F,
         uiSupport169.v1(var1 + var8 / 2.0F, var6),
         var6,
         uiSupport155.v1(cloudSupport16.v8(), var4)
      );
   }
}
