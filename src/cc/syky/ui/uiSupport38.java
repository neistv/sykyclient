package cc.syky.ui;

public final class uiSupport38 {
   private static final float v1 = 100.0F;
   private float v2;
   private float v3;
   private float v4;
   private float v5;
   private long v6;
   private boolean v7;

   public uiSupport38() {
   }

   public int v1(int var1, float var2) {
      long var3 = System.nanoTime();
      long var5 = this.v6;
      this.v6 = var3;
      float var7 = 1.0F;
      if (var5 != 0L && var2 > 0.0F) {
         if (this.v7) {
            var5 = uiSupport34.v1(var5, var3);
         }

         float var8 = Math.min((float)(var3 - var5) / 1000000.0F, 100.0F);
         var7 = 1.0F - (float)Math.exp(-var8 / var2);
      }

      this.v2 = this.v2 + ((var1 >>> 24 & 0xFF) - this.v2) * var7;
      this.v3 = this.v3 + ((var1 >>> 16 & 0xFF) - this.v3) * var7;
      this.v4 = this.v4 + ((var1 >>> 8 & 0xFF) - this.v4) * var7;
      this.v5 = this.v5 + ((var1 & 0xFF) - this.v5) * var7;
      int var9 = Math.round(this.v2) << 24 | Math.round(this.v3) << 16 | Math.round(this.v4) << 8 | Math.round(this.v5);
      this.v7 = var9 == var1;
      if (!this.v7) {
         uiSupport33.v1();
      }

      return var9;
   }

   public void v1(int var1) {
      this.v2 = var1 >>> 24 & 0xFF;
      this.v3 = var1 >>> 16 & 0xFF;
      this.v4 = var1 >>> 8 & 0xFF;
      this.v5 = var1 & 0xFF;
      this.v6 = System.nanoTime();
      this.v7 = true;
   }

   public boolean v2(int var1) {
      return Math.abs((var1 >>> 24 & 0xFF) - this.v2) < 1.0F
         && Math.abs((var1 >>> 16 & 0xFF) - this.v3) < 1.0F
         && Math.abs((var1 >>> 8 & 0xFF) - this.v4) < 1.0F
         && Math.abs((var1 & 0xFF) - this.v5) < 1.0F;
   }
}
