package cc.syky.module.visual;

public final class visualSupport25 {
   private static final int v1 = 4;
   private static final long v2 = 400L;
   private static final int[] v3 = new int[4];
   private static final long[] v4 = new long[4];
   private static final boolean[] v5 = new boolean[4];
   private static int v6;

   private visualSupport25() {
   }

   public static void v1(int var0, boolean var1) {
      v1(var0, var1, System.currentTimeMillis());
   }

   public static boolean v1(int var0) {
      return v1(var0, System.currentTimeMillis());
   }

   public static void v1() {
      for (int var0 = 0; var0 < 4; var0++) {
         v4[var0] = 0L;
      }

      v6 = 0;
   }

   public static void v1(int var0, boolean var1, long var2) {
      int var4 = v2(var0);
      if (var4 < 0) {
         var4 = v6;
         v6 = (v6 + 1) % 4;
      }

      v3[var4] = var0;
      v4[var4] = var2;
      v5[var4] = var1;
   }

   public static boolean v1(int var0, long var1) {
      int var3 = v2(var0);
      if (var3 >= 0 && v5[var3] && var1 - v4[var3] <= 400L) {
         v4[var3] = 0L;
         return true;
      } else {
         return false;
      }
   }

   private static int v2(int var0) {
      for (int var1 = 0; var1 < 4; var1++) {
         if (v4[var1] != 0L && v3[var1] == var0) {
            return var1;
         }
      }

      return -1;
   }
}
