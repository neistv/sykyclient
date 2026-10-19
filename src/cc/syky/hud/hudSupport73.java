package cc.syky.hud;

public enum hudSupport73 implements hudSupport64 {
   RATIO_4_3("4:3", 1.3333334F),
   RATIO_5_4("5:4", 1.25F),
   RATIO_16_10("16:10", 1.6F),
   CUSTOM("Custom", 0.0F);

   private final String label;
   private final float ratio;

   private hudSupport73(String var3, float var4) {
      this.label = var3;
      this.ratio = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public float v2() {
      return this.ratio;
   }
}
