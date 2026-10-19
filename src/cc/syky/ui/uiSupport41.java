package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;

public final class uiSupport41 extends uiSupport45 {
   private final Runnable v1;
   private final hudSupport57 v2 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v3 = new hudSupport57(0.0F, 150.0F);
   private final uiSupport50 v4 = new uiSupport50();
   private boolean v5;
   private boolean v6;

   public uiSupport41(float var1, Runnable var2) {
      super(var1);
      this.v1 = var2;
   }

   public void v1(boolean var1, boolean var2) {
      this.v5 = var1;
      this.v6 = var1 && var2;
      this.v3.v2(var1 ? 1.0F : 0.0F);
   }

   public boolean v1() {
      return this.v5;
   }

   public float v4() {
      return hudSupport60.v1(this.v3.v2());
   }

   @Override
   public boolean v1(float var1, float var2) {
      return this.v5 && super.v1(var1, var2);
   }

   @Override
   public float v2(uiSupport35 var1) {
      this.v2.v2(this.v5 && this.v4(var1) ? 1.0F : 0.0F);
      return hudSupport60.v1(this.v2.v2());
   }

   @Override
   public void v3(uiSupport35 var1) {
      float var2 = this.v13();
      float var3 = 17.0F * var2;
      uiSupport169.v1(
         uiSupport143.v29,
         this.v9 + uiSupport169.v1((this.v11 - var3) / 2.0F),
         this.v10 + uiSupport169.v1((this.v12 - var3) / 2.0F),
         var3,
         var3,
         this.v4.v1(uiSupport155.v1(SignInSupport.v28(), SignInSupport.v30(), hudSupport60.v1(this.v2.v2())), this.v6),
         uiRecord7.ZERO
      );
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if ((var3 == 0 || var3 == 1) && this.v1(var1, var2)) {
         this.v3(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void v3(float var1, float var2) {
      if (this.v5) {
         this.v1.run();
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
   }
}
