package cc.syky.ui;

public final class uiSupport21 {
   private final float v1;
   private float v2;
   private long v3;
   private float v4;
   private boolean v5;

   public uiSupport21(float var1) {
      this.v1 = Math.max(1.0F, var1);
   }

   public float v1(float var1, boolean var2, long var3) {
      if (!this.v5) {
         this.v5 = true;
         this.v2 = 0.0F;
         this.v3 = var3;
         this.v4 = var1;
         return this.v4;
      } else {
         if (var2) {
            this.v2 = this.v4 - var1;
            this.v3 = var3;
         }

         this.v4 = var1 + this.v2 * this.v1(var3);
         return this.v4;
      }
   }

   public boolean v1() {
      return this.v2 == 0.0F;
   }

   public void v2() {
      this.v5 = false;
      this.v2 = 0.0F;
      this.v4 = 0.0F;
      this.v3 = 0L;
   }

   private float v1(long var1) {
      float var3 = (float)(var1 - this.v3) / 1000000.0F / this.v1;
      if (var3 <= 0.0F) {
         return 1.0F;
      } else if (var3 >= 1.0F) {
         this.v2 = 0.0F;
         return 0.0F;
      } else {
         return 1.0F - var3 * var3 * var3 * (var3 * (var3 * 6.0F - 15.0F) + 10.0F);
      }
   }
}
