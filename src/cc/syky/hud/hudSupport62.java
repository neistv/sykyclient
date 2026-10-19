package cc.syky.hud;

public final class hudSupport62 {
   public static final int v1 = 100;
   public static final int v2 = 50;
   public static final int v3 = 140;
   private static float v4 = 1.0F;
   private static int v5;

   private hudSupport62() {
   }

   public static float v1() {
      return v4;
   }

   public static void v1(int var0) {
      float var1 = Math.max(50, Math.min(140, var0)) / 100.0F;
      if (var1 != v4) {
         v4 = var1;
         v5++;
      }
   }

   public static int v2() {
      return v5;
   }
}
