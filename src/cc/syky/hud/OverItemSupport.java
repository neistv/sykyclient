package cc.syky.hud;

public enum OverItemSupport implements hudSupport64 {
   BEHIND("Behind item"),
   OVER("Over item");

   private final String label;

   private OverItemSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
