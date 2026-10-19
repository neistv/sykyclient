package cc.syky.cloud;

import cc.syky.internal.InternalSupport63;
import java.util.Arrays;

public final class cloudSupport48 {
   public static final double v1 = 0.1;
   public static final double v2 = 10.0;
   public static final double v3 = 0.8;
   public static final double v4 = 11.0;
   public static final double v5 = 0.4;
   private static final double v6 = 0.008333333333333333;
   private static final double v7 = 0.008333333333333333;
   private static final double v8 = 0.1;
   private final cloudSupport50 v9;
   private final InternalSupport63 v10;
   private final float[] v11;
   private final float[] v12;
   private final float[] v13;
   private final float[] v14;
   private final float[] v15;
   private final float[] v16;
   private final float[] v18;
   private final float[] v19;
   private final float[] v17;
   private final float[] v20;
   private final float[] v21;
   private final float[] v22;
   private final cloudSupport48.Part1 v24;
   private final cloudSupport48.Part1 v25;
   private final cloudSupport48.Part1 v26;
   private int v27 = -1;
   private double v28;
   private double v29 = Double.NaN;
   private int v30 = -1;
   private double v32;
   private double v23;
   private double v33;

   public cloudSupport48(cloudSupport50 var1) {
      this.v9 = var1;
      int var2 = var1.v3().v1() * 3;
      this.v10 = new InternalSupport63(var2 / 3);
      this.v11 = new float[var2];
      this.v12 = new float[var2];
      this.v13 = new float[var2];
      this.v14 = new float[var2];
      this.v15 = new float[var2];
      this.v16 = new float[var2];
      this.v18 = new float[var2];
      this.v19 = new float[var2];
      this.v17 = new float[var2];
      this.v20 = new float[var2];
      this.v21 = new float[var2];
      this.v22 = new float[var2];
      this.v24 = new cloudSupport48.Part1(var2);
      this.v25 = new cloudSupport48.Part1(var2);
      this.v26 = new cloudSupport48.Part1(var2);
      this.v10.v1(var1.v3(), this.v11, this.v12, v1(this.v13));
   }

   public InternalSupport63 v1() {
      return this.v10;
   }

   public void v1(double var1, cloudSupport44 var3) {
      this.v1(var1, var3, 0.0);
   }

   public void v1(double var1, cloudSupport44 var3, double var4) {
      boolean var6 = Double.isNaN(this.v29);
      double var7 = var6 ? 0.0 : Math.max(0.0, Math.min(var1 - this.v29, 0.1));
      this.v29 = var1;
      int var9 = this.v9.v1(var3);
      if (var6) {
         this.v27 = var9;
         this.v28 = var1;
      } else if (var9 == this.v27) {
         this.v30 = -1;
      } else if (var9 != this.v30) {
         this.v30 = var9;
         this.v32 = var1;
      } else if (var1 - this.v32 >= 0.1 || var1 < this.v32) {
         this.v30 = -1;
         this.v1(var9, 0.0, this.v14, this.v15, this.v16);
         this.v1(var9, 0.008333333333333333, this.v18, this.v19, this.v17);
         this.v24.v1(this.v14, this.v18);
         this.v25.v1(this.v15, this.v19);
         this.v26.v1(this.v16, this.v17);
         this.v27 = var9;
         this.v28 = var1;
      }

      this.v1(this.v27, var1 - this.v28, this.v11, this.v12, this.v13);
      int var10 = var7 > 0.0 ? (int)Math.ceil(var7 / 0.008333333333333333) : 0;
      this.v24.v1(this.v11, var7, var10, var6);
      this.v25.v1(this.v12, var7, var10, var6);
      this.v26.v1(this.v13, var7, var10, var6);
      int var11 = this.v9.v2(cloudSupport44.RISE);
      int var12 = this.v9.v2(cloudSupport44.FALL);
      if (var11 < 0 && var12 < 0) {
         this.v10.v1(this.v9.v3(), this.v11, this.v12, this.v13);
      } else {
         this.v1(var7, var10, Math.max(-1.0, Math.min(1.0, var4)));
         int var13 = this.v23 > 0.0 ? var11 : var12;
         float var14 = (float)Math.abs(this.v23);
         System.arraycopy(this.v11, 0, this.v20, 0, this.v11.length);
         System.arraycopy(this.v12, 0, this.v21, 0, this.v12.length);
         System.arraycopy(this.v13, 0, this.v22, 0, this.v13.length);
         if (var13 >= 0 && var14 > 0.0F) {
            this.v1(var13, var1, this.v18, this.v19, this.v17);

            for (int var15 = 0; var15 < this.v20.length; var15++) {
               this.v20[var15] = this.v20[var15] + this.v18[var15] * var14;
               this.v21[var15] = this.v21[var15] + this.v19[var15] * var14;
               this.v22[var15] = this.v22[var15] * (1.0F + (this.v17[var15] - 1.0F) * var14);
            }
         }

         this.v10.v1(this.v9.v3(), this.v20, this.v21, this.v22);
      }
   }

   private void v1(double var1, int var3, double var4) {
      if (var3 != 0) {
         double var6 = var1 / var3;
         double var8 = 121.0;
         double var10 = 8.8;

         for (int var12 = 0; var12 < var3; var12++) {
            this.v33 = this.v33 + (var8 * (var4 - this.v23) - var10 * this.v33) * var6;
            this.v23 = this.v23 + this.v33 * var6;
         }
      }
   }

   private void v1(int var1, double var2, float[] var4, float[] var5, float[] var6) {
      Arrays.fill(var4, 0.0F);
      Arrays.fill(var5, 0.0F);
      v1(var6);
      if (var1 >= 0) {
         cloudSupport45 var7 = this.v9.v3(var1);
         float var8 = var7.v1(var2);
         if (var8 >= 0.0F) {
            var7.v1(var8, var4, var5, var6);
         }
      }
   }

   private static float[] v1(float[] var0) {
      Arrays.fill(var0, 1.0F);
      return var0;
   }

   public static final class Part1 {
      private final float[] v1;
      private final float[] v2;
      private final float[] v3;
      private final float[] v4;

      public Part1(int var1) {
         this.v1 = new float[var1];
         this.v2 = new float[var1];
         this.v3 = new float[var1];
         this.v4 = new float[var1];
      }

      public void v1(float[] var1, float[] var2) {
         float var3 = 120.0F;

         for (int var4 = 0; var4 < this.v3.length; var4++) {
            this.v3[var4] = this.v1[var4] - var1[var4];
            this.v4[var4] = this.v2[var4] - (var2[var4] - var1[var4]) * var3;
         }
      }

      public void v1(float[] var1, double var2, int var4, boolean var5) {
         if (var4 > 0) {
            float var6 = (float)(var2 / var4);
            float var7 = 100.0F;
            float var8 = 16.0F;

            for (int var9 = 0; var9 < this.v3.length; var9++) {
               float var10 = this.v3[var9];
               float var11 = this.v4[var9];
               if (var10 != 0.0F || var11 != 0.0F) {
                  for (int var12 = 0; var12 < var4; var12++) {
                     var11 -= (var7 * var10 + var8 * var11) * var6;
                     var10 += var11 * var6;
                  }

                  boolean var15 = Math.abs(var10) < 1.0E-6F && Math.abs(var11) < 1.0E-5F;
                  this.v3[var9] = var15 ? 0.0F : var10;
                  this.v4[var9] = var15 ? 0.0F : var11;
               }
            }
         }

         float var13 = var2 > 0.0 ? (float)(1.0 / var2) : 0.0F;

         for (int var14 = 0; var14 < var1.length; var14++) {
            var1[var14] += this.v3[var14];
            if (var5) {
               this.v2[var14] = 0.0F;
            } else if (var13 > 0.0F) {
               this.v2[var14] = (var1[var14] - this.v1[var14]) * var13;
            }

            this.v1[var14] = var1[var14];
         }
      }
   }
}
