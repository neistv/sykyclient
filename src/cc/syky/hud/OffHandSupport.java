package cc.syky.hud;

public final class OffHandSupport {
   public static final int v1 = 1;
   public static final int v2 = 100;
   public static final int v3 = 25;
   private static final String[] v4 = v1();

   private OffHandSupport() {
   }

   public static boolean v1(int var0, int var1, int var2) {
      return var1 > 0 && var0 * 100L <= (long)var2 * var1;
   }

   public static String v1(int var0) {
      return v4[Math.clamp((long)var0, 0, 100)];
   }

   public static int v2(int var0) {
      int var1 = 1;

      for (int var2 = Math.abs(var0); var2 >= 10; var2 /= 10) {
         var1++;
      }

      return var1;
   }

   private static String[] v1() {
      String[] var0 = new String[101];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = var1 + "%";
      }

      return var0;
   }

   public static enum Part1 implements hudSupport64 {
      MAIN_HAND("Main hand"),
      OFF_HAND("Off hand"),
      HEAD("Helmet"),
      CHESTPLATE("Chestplate"),
      ELYTRA("Elytra"),
      LEGS("Leggings"),
      FEET("Boots");

      private final String label;

      private Part1(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
