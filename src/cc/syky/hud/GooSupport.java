package cc.syky.hud;

public enum GooSupport implements hudSupport64 {
   SUBTLE(0.15F, 0.8F, 0.1F, "Subtle"),
   NORMAL(0.1F, 0.85F, 0.1F, "Normal"),
   JELLY(0.06F, 0.9F, 0.1F, "Jelly"),
   GOO(0.03F, 0.92F, 0.2F, "Goo");

   private static final float MAX_VELOCITY = 1000.0F;
   private static final float MAX_ACCELERATION = 1000.0F;
   private static final float STOP_VELOCITY = 0.5F;
   private static final float STOP_ACCELERATION = 0.5F;
   private static final float MAX_DISP_FRAC = 0.3F;
   private static final float MAX_DISP_PX = 48.0F;
   private final hudRecord params;
   private final String label;

   private GooSupport(float var3, float var4, float var5, String var6) {
      this.params = new hudRecord(var3, var4, var5, 1000.0F, 1000.0F, 0.5F, 0.5F, 0.3F, 48.0F);
      this.label = var6;
   }

   public hudRecord v2() {
      return this.params;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
