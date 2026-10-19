package cc.syky.module.visual;

public final class visualSupport58 {
   private final float v1;
   private float v2;
   private float v3;

   public visualSupport58(float var1, float var2) {
      this.v2 = var1;
      this.v3 = var1;
      this.v1 = var2;
   }

   public void v1(float var1) {
      this.v3 = var1;
   }

   public float v1() {
      return this.v2;
   }

   public float v2() {
      return this.v3;
   }

   public void v3() {
      this.v2 = this.v3;
   }

   public void v2(float var1) {
      if (var1 > 0.0F) {
         this.v2 = this.v2 + (this.v3 - this.v2) * (1.0F - (float)Math.exp(-this.v1 * var1));
      }
   }
}
