package cc.syky.cloud;

public final class cloudSupport22 {
   public static final int v1 = 64;
   public final double[] v2 = new double[64];
   public final double[] v3 = new double[64];
   public final double[] v4 = new double[64];
   public final float[] v5 = new float[64];
   public final int[] v6 = new int[64];
   public final float[] v7 = new float[64];
   public final float[] v8 = new float[64];
   public final float[] v9 = new float[64];
   public final float[] v10 = new float[64];
   private int v11;

   public cloudSupport22() {
   }

   public void v1() {
      this.v11 = 0;
   }

   public boolean v1(double var1, double var3, double var5, float var7, int var8, float var9, float var10, float var11, float var12) {
      if (this.v11 < 64 && var9 > 0.0F && var7 > 0.0F) {
         this.v2[this.v11] = var1;
         this.v3[this.v11] = var3;
         this.v4[this.v11] = var5;
         this.v5[this.v11] = var7;
         this.v6[this.v11] = var8 & 16777215;
         this.v7[this.v11] = Math.min(var9, 1.0F);
         this.v8[this.v11] = var10;
         this.v9[this.v11] = Math.max(0.0F, Math.min(var11, 1.0F));
         this.v10[this.v11] = Math.max(0.0F, Math.min(var12, 1.0F));
         this.v11++;
         return true;
      } else {
         return this.v11 < 64;
      }
   }

   public int v2() {
      return this.v11;
   }

   public double v1(int var1) {
      return this.v2[var1];
   }

   public double v2(int var1) {
      return this.v3[var1];
   }

   public double v3(int var1) {
      return this.v4[var1];
   }

   public float v4(int var1) {
      return this.v5[var1];
   }
}
