package cc.syky.hud;

public final class hudSupport37 {
   public float v1;
   public float v2;
   public float v3 = 1.0F;

   public hudSupport37() {
   }

   public void v1(float var1, float var2, float var3) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3 > 0.0F ? var3 : 1.0F;
   }
}
