package cc.syky.ui;

import cc.syky.hud.hudSupport70;

public final class uiSupport97 {
   private uiSupport97() {
   }

   public static uiRecord7 v1(float var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      uiRecord7 var8 = uiRecord7.v1(var4);
      uiSupport169.v2(var0, var1, var2, var3, var4, var5);
      uiSupport169.v1(var0, var1, var2, var3, var8, var6, uiSupport49.v3());
      uiSupport169.v1(var0, var1, var2, var3, SignInSupport.v1(var7, var5), SignInSupport.v2(var5), var8, 1.0F);
      return var8;
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4) {
      v1(var0, var1, var2, var3, var4, 0);
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5) {
      if (!hudSupport70.v1()) {
         if (var5 >>> 24 != 0) {
            uiSupport169.v1(var0, var1, var2, var3, var5, var4);
         }
      } else {
         uiSupport169.v1(var0, var1, var2, var3);

         try {
            uiSupport169.v1(var0, var1, var2, var3, var4, var5, uiSupport49.v3());
         } finally {
            uiSupport169.v4();
         }
      }
   }

   public static int v1() {
      return uiSupport49.v2(uiSupport47.BUBBLE, hudSupport70.v1() ? 0.42F : 0.9F);
   }

   public static uiRecord7 v1(float var0, float var1, float var2, float var3, float var4) {
      return v1(var0, var1, var2, var3, 24.0F * var4, var4, SignInSupport.v80(), SignInSupport.v84());
   }
}
