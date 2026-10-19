package cc.syky.hud;

public enum FitSupport implements hudSupport64 {
   FILL("Fill"),
   FIT("Fit"),
   STRETCH("Stretch");

   private final String label;

   private FitSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public void v1(float var1, float var2, float var3, float var4, int var5, int var6, float[] var7) {
      float var8 = Math.max(1, var5);
      float var9 = Math.max(1, var6);
      var7[0] = var1;
      var7[1] = var2;
      var7[2] = var1 + var3;
      var7[3] = var2 + var4;
      var7[4] = 0.0F;
      var7[5] = 0.0F;
      var7[6] = 1.0F;
      var7[7] = 1.0F;
      switch (this) {
         case FILL:
            float var13 = Math.max(var3 / var8, var4 / var9);
            float var14 = (1.0F - var3 / (var8 * var13)) / 2.0F;
            float var15 = (1.0F - var4 / (var9 * var13)) / 2.0F;
            var7[4] = var14;
            var7[5] = var15;
            var7[6] = 1.0F - var14;
            var7[7] = 1.0F - var15;
            break;
         case FIT:
            float var10 = Math.min(var3 / var8, var4 / var9);
            float var11 = var8 * var10;
            float var12 = var9 * var10;
            var7[0] = var1 + (var3 - var11) / 2.0F;
            var7[1] = var2 + (var4 - var12) / 2.0F;
            var7[2] = var7[0] + var11;
            var7[3] = var7[1] + var12;
         case STRETCH:
      }
   }

   public int v1(float var1, float var2, int var3, int var4, float var5) {
      float var6 = Math.max(1, var3);
      float var7 = Math.max(1, var4);
      float var8 = this == FIT ? Math.min(var1 / var6, var2 / var7) : Math.max(var1 / var6, var2 / var7);
      return Math.round(Math.max(var6, var7) * var8 * var5);
   }
}
