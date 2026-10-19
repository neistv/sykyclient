package cc.syky.config;

public final class configSupport7 {
   public static final int v1 = 100;
   public static final int v2 = -1;
   public static final int v3 = 1;
   public static final int v4 = 10;
   public static final int v5 = 4;
   private static final String[] v6 = v1();

   private configSupport7() {
   }

   public static int v1(int var0, int var1, float var2) {
      if (var0 > 0 && var1 > 0 && var2 > 0.0F) {
         double var3 = (double)var1 * var2;
         int var5 = (int)(var3 + 0.5);
         if (var5 <= 0 || var0 > var5) {
            return -1;
         } else if (var0 == var5) {
            return 100;
         } else {
            int var6 = (int)Math.round(var0 / var3 * 100.0);
            return Math.min(99, Math.max(1, var6));
         }
      } else {
         return -1;
      }
   }

   public static String v1(int var0) {
      int var1 = var0 < 0 ? 0 : Math.min(var0, 100);
      return v6[var1];
   }

   public static int v2(int var0) {
      if (var0 >= 100) {
         return 3;
      } else {
         return var0 >= 10 ? 2 : 1;
      }
   }

   private static String[] v1() {
      String[] var0 = new String[101];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = var1 + "%";
      }

      return var0;
   }
}
