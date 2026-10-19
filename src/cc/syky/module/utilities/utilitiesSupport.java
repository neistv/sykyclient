package cc.syky.module.utilities;

public final class utilitiesSupport {
   private static final float v2 = 0.1F;
   public static final double v1 = 0.001;
   private static double v3 = 1.0;
   private static double v4 = 1.0;
   private static double v5 = 0.0;
   private static float v6 = 12.0F;
   private static boolean v7 = true;
   private static long v8;

   private utilitiesSupport() {
   }

   public static void v1(double var0) {
      v3 = Math.max(1.0, var0);
   }

   public static void v1(float var0, boolean var1) {
      v6 = var0;
      v7 = var1;
   }

   public static double v1() {
      return v4;
   }

   public static double v2() {
      long var0 = System.nanoTime();
      float var2 = v8 == 0L ? 0.0F : Math.min((float)(var0 - v8) / 1.0E9F, 0.1F);
      v8 = var0;
      double var3 = Math.log(v3);
      if (!v7) {
         v5 = var3;
      } else if (var2 > 0.0F) {
         v5 = v5 + (var3 - v5) * (1.0 - Math.exp(-v6 * var2));
      }

      v4 = Math.exp(v5);
      return v4;
   }
}
