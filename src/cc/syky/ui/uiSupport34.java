package cc.syky.ui;

public final class uiSupport34 {
   private static long v1;
   private static long v2;
   private static int v3;

   private uiSupport34() {
   }

   public static void v1() {
      v2 = v1;
      v1 = System.nanoTime();
   }

   public static void v2() {
      v3++;
   }

   public static void v3() {
      if (v3 > 0) {
         v3--;
      }
   }

   public static long v1(long var0, long var2) {
      return v3 != 0 && v2 != 0L && var0 < v2 ? var2 - (v1 - v2) : var0;
   }
}
