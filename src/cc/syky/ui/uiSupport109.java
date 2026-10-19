package cc.syky.ui;

import cc.syky.hud.hudSupport57;

public final class uiSupport109 {
   private final hudSupport57 v1;

   public uiSupport109(boolean var1) {
      this.v1 = new hudSupport57(var1 ? 1.0F : 0.0F, 90.0F);
   }

   public void v1(boolean var1) {
      this.v1.v2(var1 ? 1.0F : 0.0F);
   }

   public float v1() {
      return SignInSupport.v1(this.v1.v2());
   }

   public float v1(float var1, float var2, float var3, float var4) {
      float var5 = this.v1();
      float var6 = SignInSupport.v4(21.0F, var3);
      float var7 = var6 / 2.0F;
      uiRecord7 var8 = uiRecord7.v1(var7);
      uiSupport169.v1(
         var1,
         var2,
         var6,
         var6,
         uiSupport155.v1(uiSupport155.v1(SignInSupport.v75(), SignInSupport.v73(), var5), var4),
         Math.max(SignInSupport.v2(var3), SignInSupport.v4(2.0F, var3)),
         var8,
         1.0F
      );
      if (var5 <= 0.002F) {
         return var5;
      } else {
         float var9 = 11.0F * var3 * var5;
         float var10 = var1 + (var6 - var9) / 2.0F;
         float var11 = var2 + (var6 - var9) / 2.0F;
         float var12 = var9 / 2.0F;
         uiRecord7 var13 = uiRecord7.v1(var12);
         uiSupport169.v1(var10, var11, var9, var9, uiSupport155.v1(SignInSupport.v74(), var5 * var4), var13);
         uiSupport169.v1(
            var10, var11, var9, var9, uiSupport155.v1(SignInSupport.v1(SignInSupport.v72(), var3), var5 * var4), SignInSupport.v2(var3), var13, 1.0F
         );
         return var5;
      }
   }
}
