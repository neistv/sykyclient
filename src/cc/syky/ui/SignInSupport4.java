package cc.syky.ui;

import cc.syky.cloud.SykySession;

public final class SignInSupport4 extends uiSupport138 {
   private static final String v1 = " • Alpha";

   public SignInSupport4(Runnable var1, float var2, boolean var3) {
      super(AltManagerSupport.ACCOUNT, var1, var2, var3);
   }

   @Override
   public void v1(float var1) {
      float var2 = this.v2();
      float var3 = 20.0F * var2;
      uiSupport169.v1(
         uiSupport143.v8,
         this.v9 + 12.0F * var2,
         this.v10 + (this.v12 - var3) / 2.0F,
         var3,
         var3,
         uiSupport155.v1(SignInSupport.v12(), SignInSupport.v13(), var1),
         uiRecord7.ZERO
      );
      float var4 = 18.0F * var2;
      float var5 = this.v9 + 44.0F * var2;
      float var6 = uiSupport169.v1(this.v10 + this.v12 / 2.0F, var4);
      SykySession.Part1 var7 = SykySession.v1();
      if (var7 == null) {
         uiSupport169.v1("syky_sans_strong", "Sign in", var5, var6, var4, uiSupport155.v1(SignInSupport.v14(), SignInSupport.v16(), var1));
      } else {
         String var8 = uiSupport223.v2 ? "Protected" : var7.v2();
         uiSupport169.v1("syky_sans_strong", var8, var5, var6, var4, uiSupport155.v1(SignInSupport.v14(), SignInSupport.v16(), var1));
         uiSupport169.v1(
            "syky_sans_strong",
            " • Alpha",
            var5 + uiSupport169.v2("syky_sans_strong", var8, var4),
            var6,
            var4,
            uiSupport155.v1(SignInSupport.v15(), SignInSupport.v18(), var1)
         );
      }
   }

   @Override
   public boolean v1(float var1, float var2) {
      return var1 >= this.v9 && var2 >= this.v10 && var1 < this.v9 + this.v11 && var2 < this.v10 + this.v12;
   }
}
