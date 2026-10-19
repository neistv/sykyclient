package cc.syky.ui;

public final class uiSupport20 {
   public static final int v1 = 3;
   public static final int v2 = 30;
   public static final int v3 = 10;
   private static final float v4 = 1000.0F;
   private static final String[] v5 = v1();

   private uiSupport20() {
   }

   public static boolean v1(float var0, int var1) {
      return var0 > 0.0F && var0 <= var1 * 1000.0F;
   }

   public static int v1(float var0) {
      if (var0 <= 0.0F) {
         return 0;
      } else {
         float var1 = var0 / 1000.0F;
         int var2 = (int)Math.ceil(var1);
         return var2 > 30 ? 30 : var2;
      }
   }

   public static String v2(float var0) {
      return v5[v1(var0)];
   }

   public static String v1(int var0) {
      int var1 = var0 < 0 ? 0 : Math.min(var0, 30);
      return v5[var1];
   }

   private static String[] v1() {
      String[] var0 = new String[31];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = var1 + "s";
      }

      return var0;
   }
}
