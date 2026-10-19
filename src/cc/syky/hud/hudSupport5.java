package cc.syky.hud;

import cc.syky.ui.uiSupport6;

public final class hudSupport5 {
   public static final float v1 = 380.0F;
   public static final float v2 = 210.0F;
   private static final float v4 = 100.0F;
   public static final float v3 = 0.02F;
   private boolean v5;
   private boolean v6 = true;
   private float v7 = 1.0F;
   private boolean v8;
   private boolean v9;
   private final uiSupport6 v10;

   public hudSupport5() {
      this(uiSupport6.Part1.HUD);
   }

   public hudSupport5(uiSupport6.Part1 var1) {
      this.v10 = new uiSupport6(var1);
   }

   public void v1(boolean var1, float var2) {
      this.v6 = var1;
      float var3 = var1 ? 380.0F : 210.0F;
      if (this.v5 && !(var3 <= 0.0F)) {
         float var4 = var1 ? 1.0F : 0.0F;
         if (this.v7 != var4) {
            if (var2 > 100.0F) {
               var2 = 100.0F;
            }

            if (var2 > 0.0F) {
               float var5 = var2 / var3;
               this.v7 = var1 ? Math.min(1.0F, this.v7 + var5) : Math.max(0.0F, this.v7 - var5);
            }
         }

         this.v13();
         if (!var1 && this.v7 > 0.0F && this.v10.v1() < 0.02F) {
            this.v7 = 0.0F;
            this.v13();
         }

         boolean var6 = this.v7 != var4;
         this.v9 = var6 && !this.v8;
         this.v8 = var6;
      } else {
         this.v5 = true;
         this.v12();
      }
   }

   public void v1(boolean var1) {
      this.v6 = var1;
      this.v5 = true;
      this.v12();
   }

   private void v12() {
      this.v7 = this.v6 ? 1.0F : 0.0F;
      this.v8 = false;
      this.v9 = false;
      this.v13();
   }

   public float v1() {
      return this.v7;
   }

   public boolean v2() {
      return !this.v6 && this.v7 <= 0.0F;
   }

   public boolean v3() {
      return this.v7 != (this.v6 ? 1.0F : 0.0F);
   }

   public boolean v4() {
      return this.v9;
   }

   public boolean v5() {
      return this.v9 && this.v6;
   }

   public boolean v6() {
      return !this.v6 && this.v7 > 0.0F;
   }

   public float v7() {
      return this.v10.v1();
   }

   public float v8() {
      return this.v10.v2();
   }

   public float v9() {
      return this.v10.v3();
   }

   public float v10() {
      return this.v10.v4();
   }

   public float v11() {
      return this.v10.v5();
   }

   private void v13() {
      if (this.v7 >= 1.0F) {
         this.v10.v6();
      } else {
         this.v10.v1(this.v7);
      }
   }
}
