package cc.syky.render;

public final class renderSupport7 {
   public static final int v1 = 64;
   public final double[] v2 = new double[64];
   public final double[] v3 = new double[64];
   public final double[] v4 = new double[64];
   public final float[] v5 = new float[64];
   public final int[] v6 = new int[64];
   public final float[] v7 = new float[64];
   public final float[] v8 = new float[64];
   private int v9;

   public renderSupport7() {
   }

   public void v1() {
      this.v9 = 0;
   }

   public boolean v1(double var1, double var3, double var5, float var7, int var8, float var9, float var10) {
      if (this.v9 >= 64) {
         return false;
      } else if (var9 > 0.0F && var7 > 0.0F) {
         this.v2[this.v9] = var1;
         this.v3[this.v9] = var3;
         this.v4[this.v9] = var5;
         this.v5[this.v9] = var7;
         this.v6[this.v9] = var8 & 16777215;
         this.v7[this.v9] = Math.min(var9, 1.0F);
         this.v8[this.v9] = var10;
         this.v9++;
         return true;
      } else {
         return true;
      }
   }

   public int v2() {
      return this.v9;
   }
}
