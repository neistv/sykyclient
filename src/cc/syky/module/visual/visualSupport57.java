package cc.syky.module.visual;

public final class visualSupport57 {
   private final float v1;
   private float v2;
   private float v3;
   private long v4;

   public visualSupport57(float var1) {
      this.v1 = var1;
   }

   public void v1(boolean var1) {
      this.v3 = var1 ? 1.0F : 0.0F;
   }

   public void v1() {
      this.v2 = this.v3;
      this.v4 = 0L;
   }

   public float v2() {
      return this.v2;
   }

   public float v3() {
      long var1 = System.nanoTime();
      float var3 = this.v4 == 0L ? 0.0F : Math.min((float)(var1 - this.v4) / 1.0E9F, 0.1F);
      this.v4 = var1;
      if (var3 > 0.0F) {
         this.v2 = this.v2 + (this.v3 - this.v2) * (1.0F - (float)Math.exp(-this.v1 * var3));
      }

      return this.v2;
   }
}
