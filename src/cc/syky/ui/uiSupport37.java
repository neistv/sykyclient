package cc.syky.ui;

public final class uiSupport37 {
   private final float v1;
   private float v2;
   private float v3;
   private float v4;

   public uiSupport37(float var1) {
      this.v1 = var1;
   }

   public void v1(float var1, float var2) {
      this.v2 = 0.0F;
      this.v3 = var1;
      this.v4 = var2;
   }

   public void v2(float var1, float var2) {
      if (Math.abs(var1 - this.v3) + Math.abs(var2 - this.v4) > this.v1) {
         this.v1(var1, var2);
      }
   }

   public void v1() {
      this.v2 = 0.0F;
   }

   public boolean v3(float var1, float var2) {
      this.v2 += var1;
      return this.v2 >= var2;
   }
}
