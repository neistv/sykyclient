package cc.syky.hud;

public enum WhenItSupport implements hudSupport64 {
   RAIN("When it rains"),
   ALWAYS("Always");

   private final String label;

   private WhenItSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
