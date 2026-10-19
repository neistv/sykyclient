package cc.syky.module.visual;

public final class visualSupport62 {
   private static final float v1 = 10.0F;
   private static final float v2 = 0.1F;
   private static final visualSupport62.Part1 v3 = new visualSupport62.Part1();
   private static final visualSupport62.Part1 v4 = new visualSupport62.Part1();

   private visualSupport62() {
   }

   public static void v1(float var0) {
      v3.v2 = var0;
   }

   public static void v2(float var0) {
      v4.v2 = var0;
   }

   public static float v1() {
      return v3.v1();
   }

   public static float v2() {
      return v4.v1();
   }

   public static final class Part1 {
      private float v1 = 1.0F;
      public float v2 = 1.0F;
      private long v3;

      public Part1() {
      }

      public float v1() {
         long var1 = System.nanoTime();
         float var3 = this.v3 == 0L ? 0.0F : Math.min((float)(var1 - this.v3) / 1.0E9F, 0.1F);
         this.v3 = var1;
         if (var3 > 0.0F) {
            this.v1 = this.v1 + (this.v2 - this.v1) * (1.0F - (float)Math.exp(-10.0F * var3));
         }

         return this.v1;
      }
   }
}
