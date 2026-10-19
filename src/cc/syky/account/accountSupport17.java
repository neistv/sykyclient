package cc.syky.account;

import cc.syky.render.renderSupport3;

public final class accountSupport17 {
   private static final double v1 = 0.1;
   private final int v2;
   private final double[] v3;
   private final double[] v4;
   private final double[] v5;
   private final float[] v6;
   private final float[] v7;
   private final float[] v8;
   private final float[] v9;
   private final float[] v10;
   private int v11;
   private int v12;
   private long v13;

   public accountSupport17(int var1) {
      this.v2 = Math.max(1, Math.min(var1, 256));
      this.v3 = new double[this.v2];
      this.v4 = new double[this.v2];
      this.v5 = new double[this.v2];
      this.v6 = new float[this.v2];
      this.v7 = new float[this.v2];
      this.v8 = new float[this.v2];
      this.v9 = new float[this.v2];
      this.v10 = new float[this.v2];
   }

   public int v1() {
      return this.v11;
   }

   public void v1(double var1, double var3, double var5, float var7, float var8, float var9) {
      this.v1(var1, var3, var5, var7, var8, var9, 0.0F);
   }

   public void v1(double var1, double var3, double var5, float var7, float var8, float var9, float var10) {
      int var11;
      if (this.v11 < this.v2) {
         var11 = this.v11++;
      } else {
         var11 = 0;

         for (int var12 = 1; var12 < this.v2; var12++) {
            if (this.v9[var12] > this.v9[var11]) {
               var11 = var12;
            }
         }
      }

      float var14 = (float)Math.sqrt(var7 * var7 + var8 * var8 + var9 * var9);
      boolean var13 = var14 < 1.0E-4F;
      this.v3[var11] = var1;
      this.v4[var11] = var3;
      this.v5[var11] = var5;
      this.v6[var11] = var13 ? 0.0F : var7 / var14;
      this.v7[var11] = var13 ? 1.0F : var8 / var14;
      this.v8[var11] = var13 ? 0.0F : var9 / var14;
      this.v9[var11] = Math.max(var10, 0.0F);
      this.v10[var11] = this.v12++ & 65535;
   }

   public void v1(float var1, float var2) {
      for (int var3 = this.v11 - 1; var3 >= 0; var3--) {
         this.v9[var3] = this.v9[var3] + var1;
         if (this.v9[var3] >= var2) {
            this.v1(var3);
         }
      }
   }

   public void v1(renderSupport3 var1) {
      var1.v2();

      for (int var2 = 0; var2 < this.v11; var2++) {
         var1.v1(this.v3[var2], this.v4[var2], this.v5[var2], this.v6[var2], this.v7[var2], this.v8[var2], this.v9[var2], this.v10[var2]);
      }
   }

   public float v2() {
      long var1 = System.nanoTime();
      double var3 = this.v13 == 0L ? 0.0 : Math.min((var1 - this.v13) / 1.0E9, 0.1);
      this.v13 = var1;
      return (float)var3;
   }

   public void v3() {
      this.v11 = 0;
      this.v13 = 0L;
   }

   private void v1(int var1) {
      int var2 = --this.v11;
      if (var1 != var2) {
         this.v3[var1] = this.v3[var2];
         this.v4[var1] = this.v4[var2];
         this.v5[var1] = this.v5[var2];
         this.v6[var1] = this.v6[var2];
         this.v7[var1] = this.v7[var2];
         this.v8[var1] = this.v8[var2];
         this.v9[var1] = this.v9[var2];
         this.v10[var1] = this.v10[var2];
      }
   }
}
