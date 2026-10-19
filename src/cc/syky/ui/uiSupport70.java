package cc.syky.ui;

import cc.syky.hud.hudSupport54;

public final class uiSupport70 extends uiSupport61 {
   private final String v1;
   private final PressASupport v2;

   public uiSupport70(String var1, PressASupport var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   @Override
   public String v1() {
      return this.v1;
   }

   @Override
   public float v2() {
      return 83.0F;
   }

   @Override
   public float v3() {
      return this.v2.v2(this.v16(), this.v9());
   }

   private float v18() {
      return this.v5(21.0F * this.v9());
   }

   @Override
   public void v2(uiSupport35 var1) {
      this.v2.v1(var1, this.v16(), this.v18(), this.v9(), this.v10());
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (this.v2.v1(var3)) {
         return true;
      } else if (var3 == 0 && this.v1(var1, var2)) {
         if (this.v2.v3(var1, var2, this.v16(), this.v18(), this.v9())) {
            return true;
         } else {
            this.v2.v5();
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return !this.v1(var1, var2) || !this.v2.v1(var1, var2, this.v16(), this.v18(), this.v9()) && !this.v2.v2(var1, var2, this.v16(), this.v18(), this.v9())
         ? hudSupport54.ARROW
         : hudSupport54.POINTER;
   }

   @Override
   public boolean v1(int var1) {
      return this.v2.v1(var1);
   }

   @Override
   public boolean v4() {
      if (!this.v2.v4()) {
         return false;
      } else {
         this.v2.v5();
         return true;
      }
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v2.v1(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v2.v6();
   }

   @Override
   public boolean v5() {
      return this.v2.v4();
   }

   @Override
   public void v6() {
      this.v2.v5();
   }
}
