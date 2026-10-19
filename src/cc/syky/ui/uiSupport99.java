package cc.syky.ui;

import cc.syky.hud.hudSupport57;

public final class uiSupport99 {
   private final hudSupport57 v1;
   private boolean v2 = true;
   private float v3;

   public uiSupport99(boolean var1) {
      float var2 = var1 && uiSupport103.v1() ? 0.0F : 1.0F;
      this.v1 = uiSupport103.v1(var2);
      this.v1.v2(1.0F);
      this.v3 = var2;
   }

   public void v1(boolean var1) {
      if (this.v2 != var1) {
         this.v2 = var1;
         float var2 = var1 ? 1.0F : 0.0F;
         if (uiSupport103.v1()) {
            this.v1.v2(var2);
         } else {
            this.v1.v3(var2);
            this.v3 = var2;
         }
      }
   }

   public boolean v1() {
      return this.v2;
   }

   public void v2() {
      float var1 = this.v2 ? 1.0F : 0.0F;
      this.v1.v3(var1);
      this.v3 = var1;
   }

   public float v3() {
      this.v3 = this.v1.v2();
      return this.v3;
   }

   public float v4() {
      return this.v3;
   }

   public float v5() {
      return uiSupport103.v2(this.v3);
   }

   public boolean v6() {
      return !this.v2 && uiSupport103.v4(this.v3);
   }
}
