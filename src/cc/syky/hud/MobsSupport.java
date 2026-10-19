package cc.syky.hud;

public enum MobsSupport implements hudSupport64 {
   PLAYERS("Players"),
   MOBS("Mobs");

   private final String label;

   private MobsSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
