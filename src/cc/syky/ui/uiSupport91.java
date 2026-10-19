package cc.syky.ui;

import cc.syky.hud.hudSupport2;

public final class uiSupport91 {
   private static final float v1 = 100.0F;
   private float v2;
   private boolean v3;
   private boolean v4;
   private float v5;
   private float v6;
   private long v7;
   private float v8;
   private float v9;
   private float v10;
   private float v11;
   private float v12;
   private float v13;
   private float v14;
   private float v15;
   private float v16;
   private float v18;

   public uiSupport91() {
   }

   public void v1(UiNode var1, float var2, float var3) {
      this.v5 = v1(var2, var1.v9, var1.v11);
      this.v6 = v1(var3, var1.v10, var1.v12);
      this.v4 = true;
      this.v8();
   }

   public void v1() {
      this.v4 = false;
      this.v8();
   }

   private void v8() {
      this.v2 = 0.0F;
      this.v3 = false;
      this.v7 = System.nanoTime();
   }

   public void v2() {
      this.v3 = true;
   }

   public void v3() {
      this.v3 = false;
   }

   public float v4() {
      this.v9();
      return uiSupport92.v1(this.v2);
   }

   public boolean v5() {
      return this.v3;
   }

   public boolean v6() {
      return this.v3 && uiSupport92.v1(this.v2) < 0.02F;
   }

   private void v9() {
      long var1 = System.nanoTime();
      long var3 = this.v7;
      this.v7 = var1;
      float var5 = this.v3 ? 0.0F : 1.0F;
      if (this.v2 != var5 && var3 != 0L) {
         float var6 = Math.min(100.0F, (float)(var1 - var3) / 1000000.0F);
         if (!(var6 <= 0.0F)) {
            if (this.v3) {
               this.v2 = uiSupport92.v6(uiSupport92.v7(this.v2) + var6 / 150.0F);
            } else {
               this.v2 = uiSupport92.v4(uiSupport92.v5(this.v2) + var6 / 240.0F);
            }
         }
      }
   }

   public boolean v1(UiNode var1, float var2) {
      return this.v1(var1, var2, 1.0F, 1.0F, 1.0F, 0.0F);
   }

   public boolean v1(UiNode var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = this.v4 ? uiSupport92.v2(this.v2) : 1.0F;
      float var8 = this.v4 ? uiSupport92.v3(this.v2) * var2 : 0.0F;
      this.v8 = uiSupport92.v1(this.v2) * var3;
      this.v11 = var4 * var7;
      this.v12 = var5 * var7;
      this.v13 = var8 <= 0.0F ? var6 : (float)Math.hypot(var6, var8);
      if (this.v8 >= 1.0F && this.v11 == 1.0F && this.v12 == 1.0F && this.v13 <= 0.0F) {
         return false;
      } else {
         float var9 = hudSupport2.v1(var2);
         float var10 = var1.v9;
         float var11 = var1.v10;
         float var12 = var1.v9 + var1.v11;
         float var13 = var1.v10 + var1.v12;
         UiNode var14 = var1 instanceof UiScreen var15 ? var15.v13() : null;

         while (var14 != null) {
            var10 = Math.min(var10, var14.v9);
            var11 = Math.min(var11, var14.v10);
            var12 = Math.max(var12, var14.v9 + var14.v11);
            var13 = Math.max(var13, var14.v10 + var14.v12);
            var14 = var14 instanceof UiScreen var20 ? var20.v13() : null;
         }

         var10 -= var9;
         var11 -= var9;
         var12 += var9;
         var13 += var9;
         if (!uiSupport169.v2(var10, var11, var12 - var10, var13 - var11)) {
            return false;
         } else {
            this.v9 = v1(var1.v9 + var1.v11 * 0.5F, var4, var1.v9 + this.v5 * var1.v11, var7, this.v11);
            this.v10 = v1(var1.v10 + var1.v12 * 0.5F, var5, var1.v10 + this.v6 * var1.v12, var7, this.v12);
            float var21 = 2.0F * this.v13 + 1.0F;
            this.v14 = this.v9 + (var10 - this.v9) * this.v11 - var21;
            this.v15 = this.v10 + (var11 - this.v10) * this.v12 - var21;
            this.v16 = this.v9 + (var12 - this.v9) * this.v11 + var21 - this.v14;
            this.v18 = this.v10 + (var13 - this.v10) * this.v12 + var21 - this.v15;
            return true;
         }
      }
   }

   public void v7() {
      uiSupport169.v1(this.v8, this.v9, this.v10, this.v11, this.v12, this.v13, this.v14, this.v15, this.v16, this.v18);
   }

   private static float v1(float var0, float var1, float var2, float var3, float var4) {
      float var5 = 1.0F - var4;
      return Math.abs(var5) < 1.0E-6F ? var0 : (var0 * (1.0F - var1) + var1 * var2 * (1.0F - var3)) / var5;
   }

   private static float v1(float var0, float var1, float var2) {
      if (var2 <= 0.0F) {
         return 0.5F;
      } else {
         float var3 = (var0 - var1) / var2;
         return var3 <= 0.0F ? 0.0F : (var3 >= 1.0F ? 1.0F : var3);
      }
   }
}
