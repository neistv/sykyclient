package cc.syky.hud;

public enum RealItemSupport implements hudSupport64 {
   CUSTOM("Custom name"),
   REAL("Real item");

   private final String label;

   private RealItemSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
