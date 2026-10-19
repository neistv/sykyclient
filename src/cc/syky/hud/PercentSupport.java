package cc.syky.hud;

public enum PercentSupport implements hudSupport64 {
   PERCENT("Percent"),
   DURABILITY("Durability");

   private final String label;

   private PercentSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public static int v1(int var0, int var1) {
      return Math.max(0, var1 - var0);
   }

   public static int v2(int var0, int var1) {
      return var1 > 0 && var0 > 0 ? Math.max(1, Math.round(var0 * 100.0F / var1)) : 0;
   }
}
