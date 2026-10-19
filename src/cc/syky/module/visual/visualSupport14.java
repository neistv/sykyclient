package cc.syky.module.visual;

public enum visualSupport14 {
   CLEAR(0.0F, 0.0F),
   RAIN(1.0F, 0.0F),
   THUNDER(1.0F, 1.0F);

   private final float rain;
   private final float thunder;

   private visualSupport14(float var3, float var4) {
      this.rain = var3;
      this.thunder = var4;
   }

   public float v1() {
      return this.rain;
   }

   public float v2() {
      return this.thunder;
   }
}
