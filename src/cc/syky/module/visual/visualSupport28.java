package cc.syky.module.visual;

public final class visualSupport28 {
   public static final int v1 = 10;
   public static final int v2 = 2;
   private static final int[] v4 = new int[]{1, 2, 5};
   public static final int v3 = 10;

   private visualSupport28() {
   }

   public static int v1(int var0, int var1, int var2) {
      if (var2 < 1) {
         return 2;
      } else {
         long var3 = (long)Math.max(var0, 0) + Math.max(var1, 0);
         long var5 = 2L;
         long var7 = 1L;

         for (int var9 = 0; var5 < var3 && v1(var0, var5) + v1(var1, var5) > var2; var5 = 2L * v4[var9] * var7) {
            if (++var9 == v4.length) {
               var9 = 0;
               var7 *= 10L;
            }
         }

         return (int)Math.min(var5, 2147483647L);
      }
   }

   public static int v1(int var0, int var1) {
      return (int)v1(var0, (long)var1);
   }

   public static int v2(int var0, int var1) {
      return var0 > 0 && var1 > 0 ? (int)Math.max(1L, var0 * 2L / var1) : 0;
   }

   private static long v1(int var0, long var1) {
      return var0 > 0 && var1 > 0L ? (var0 + var1 - 1L) / var1 : 0L;
   }

   public static int v1(boolean var0, int var1, int var2) {
      return var0 ? Math.min(var1, (Math.max(var2, 0) + 1) / 2) : var1;
   }

   public static int v1(int var0, int var1, int var2, int var3) {
      return Math.min(Math.max(var0, var1 + Math.max(var2, 0)), var3);
   }

   public static int v1(int var0) {
      return (Math.max(var0, 0) + 10 - 1) / 10;
   }

   public static int v2(int var0) {
      return var0 / 10;
   }

   public static int v1(int var0, boolean var1) {
      return Math.max(Math.min(var0, 10), var1 ? 10 : 0);
   }

   public static int v1(LeftSupport var0, int var1, int var2, int var3) {
      return var0 == LeftSupport.LEFT ? var3 : Math.min(10, var2 - v2(var1) * 10);
   }

   public static float v3(int var0, int var1) {
      return var0 % 10 - (var1 - 1) * 0.5F;
   }

   public static visualSupport28.Part1 v4(int var0, int var1) {
      int var2 = var0 * 2 + 1;
      if (var2 < var1) {
         return visualSupport28.Part1.FULL;
      } else {
         return var2 == var1 ? visualSupport28.Part1.HALF : visualSupport28.Part1.EMPTY;
      }
   }

   public static enum Part1 {
      FULL,
      HALF,
      EMPTY;

      private Part1() {
      }
   }
}
