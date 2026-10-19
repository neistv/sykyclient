package cc.syky.config;

public final class configSupport15 {
   private final long v1;
   private boolean v2;
   private long v3;

   public configSupport15(float var1) {
      this.v1 = (long)(var1 * 1.0E9F);
   }

   public void v1() {
      this.v2 = true;
      this.v3 = System.nanoTime();
   }

   public void v2() {
      this.v2 = false;
   }

   public float v3() {
      if (!this.v2) {
         return 0.0F;
      } else {
         float var1 = (float)(System.nanoTime() - this.v3) / (float)this.v1;
         if (var1 <= 0.0F) {
            return 1.0F;
         } else if (var1 >= 1.0F) {
            this.v2 = false;
            return 0.0F;
         } else {
            float var2 = 1.0F - var1;
            return var2 * var2 * (3.0F - 2.0F * var2);
         }
      }
   }
}
