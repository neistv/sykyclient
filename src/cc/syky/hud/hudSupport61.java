package cc.syky.hud;

public final class hudSupport61 {
   private final float v1;
   private long v2 = System.nanoTime();

   public hudSupport61(float var1) {
      this.v1 = var1 * 1000000.0F;
   }

   public void v1(float var1, long var2) {
      this.v2 = var2 - (long)(var1 * this.v1);
   }

   public float v1(long var1) {
      return 0.5F - 0.5F * (float)Math.cos((Math.PI * 2) * ((float)(var1 - this.v2) / this.v1));
   }

   public float v1() {
      return this.v1(System.nanoTime());
   }

   public static float v1(float var0) {
      return (float)(Math.acos(1.0 - 2.0 * Math.min(1.0F, Math.max(0.0F, var0))) / (Math.PI * 2));
   }
}
