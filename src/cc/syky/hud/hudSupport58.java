package cc.syky.hud;

public final class hudSupport58 {
   private static final float v1 = 70.0F;
   private static final float v2 = 0.05F;
   private float v3;
   private float v4;
   private float v5;
   private float v6;
   private float v7;
   private float v8 = -1.0F;

   public hudSupport58() {
      this(70.0F);
   }

   public hudSupport58(float var1) {
      this.v6 = var1;
   }

   public float v1() {
      return this.v3;
   }

   public float v2() {
      return this.v4;
   }

   public float v3() {
      return this.v5;
   }

   public float v4() {
      return this.v6;
   }

   public hudSupport58 v1(float var1) {
      this.v6 = Math.max(1.0F, var1);
      return this;
   }

   public void v2(float var1) {
      this.v8 = -1.0F;
      this.v4 = this.v10(this.v4 + var1);
   }

   public void v3(float var1) {
      this.v4 = this.v10(var1);
   }

   public void v4(float var1) {
      this.v3 = this.v10(this.v3 + var1);
      this.v4 = this.v10(this.v4 + var1);
   }

   public void v5(float var1) {
      this.v8 = -1.0F;
      this.v3 = this.v4 = this.v10(var1);
   }

   public void v6(float var1) {
      this.v8 = var1 > 0.0F ? var1 : -1.0F;
   }

   public float v5() {
      if (this.v8 >= 0.0F) {
         return this.v8;
      } else {
         return this.v7 > 0.0F ? this.v4 / this.v7 : 0.0F;
      }
   }

   public void v7(float var1) {
      this.v5 = Math.max(0.0F, var1);
      if (this.v8 >= 0.0F && this.v7 > 0.0F) {
         float var2 = this.v8 * this.v7;
         this.v3 = this.v4 = Math.min(var2, this.v5);
         if (this.v5 >= var2) {
            this.v8 = -1.0F;
         }
      }

      if (this.v4 > this.v5) {
         this.v4 = this.v5;
      }

      if (this.v3 > this.v5) {
         this.v3 = this.v5;
      }
   }

   public void v8(float var1) {
      if (!(var1 <= 0.0F)) {
         if (this.v7 > 0.0F && var1 != this.v7) {
            float var2 = var1 / this.v7;
            this.v3 *= var2;
            this.v4 *= var2;
            this.v5 *= var2;
         }

         this.v7 = var1;
      }
   }

   public void v9(float var1) {
      if (this.v3 != this.v4) {
         if (!(var1 <= 0.0F)) {
            float var2 = 1.0F - (float)Math.exp(-var1 / this.v6);
            float var3 = this.v4 - this.v3;
            this.v3 += var3 * var2;
            if (Math.abs(this.v4 - this.v3) < 0.05F) {
               this.v3 = this.v4;
            }
         }
      }
   }

   public void v6() {
      this.v8 = -1.0F;
      this.v3 = this.v4 = 0.0F;
   }

   public boolean v7() {
      return this.v3 == this.v4;
   }

   private float v10(float var1) {
      if (var1 < 0.0F) {
         return 0.0F;
      } else {
         return var1 > this.v5 ? this.v5 : var1;
      }
   }
}
