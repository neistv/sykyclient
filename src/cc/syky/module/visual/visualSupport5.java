package cc.syky.module.visual;

public final class visualSupport5 {
   private static final int v1 = 4;
   private static final long v2 = 800L;
   private static final double v3 = 2.25;
   private static final visualSupport5.Part1[] v4 = new visualSupport5.Part1[4];
   private static int v5;

   private visualSupport5() {
   }

   public static void v1(double var0, double var2, double var4) {
      visualSupport5.Part1 var6 = v4[v5];
      var6.v1 = System.currentTimeMillis();
      var6.v2 = var0;
      var6.v3 = var2;
      var6.v4 = var4;
      var6.v5 = 0;
      v5 = (v5 + 1) % 4;
   }

   public static boolean v1(visualSupport4 var0, double var1, double var3, double var5) {
      long var7 = System.currentTimeMillis();
      int var9 = 1 << var0.ordinal();

      for (int var10 = 0; var10 < 4; var10++) {
         visualSupport5.Part1 var11 = v4[(v5 + var10) % 4];
         if ((var11.v5 & var9) == 0 && var7 - var11.v1 <= 800L) {
            double var12 = var1 - var11.v2;
            double var14 = var3 - var11.v3;
            double var16 = var5 - var11.v4;
            if (!(var12 * var12 + var14 * var14 + var16 * var16 > 2.25)) {
               var11.v5 |= var9;
               return true;
            }
         }
      }

      return false;
   }

   static {
      for (int var0 = 0; var0 < 4; var0++) {
         v4[var0] = new visualSupport5.Part1();
      }
   }

   public static final class Part1 {
      public long v1;
      public double v2;
      public double v3;
      public double v4;
      public int v5;

      public Part1() {
      }
   }
}
