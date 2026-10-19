package cc.syky.hud;

public final class hudSupport66 {
   public static final int v1 = 4;
   public static final int v2 = 64;
   public static final int v3 = 44;
   public static final int v4 = 0;
   public static final int v5 = 100;
   public static final int v6 = 40;
   private static boolean v7 = true;
   private static int v8 = 44;
   private static int v9 = 40;

   private hudSupport66() {
   }

   public static boolean v1() {
      return v7;
   }

   public static void v1(boolean var0) {
      v7 = var0;
   }

   public static int v2() {
      return v8;
   }

   public static void v1(int var0) {
      v8 = v1(var0, 4, 64);
   }

   public static int v3() {
      return v9;
   }

   public static void v2(int var0) {
      v9 = v1(var0, 0, 100);
   }

   public static float v4() {
      return v8 / 3.0F;
   }

   public static int v5() {
      return Math.round(v9 * 2.55F) << 24;
   }

   private static int v1(int var0, int var1, int var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }
}
