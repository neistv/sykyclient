package cc.syky.hud;

import java.util.Arrays;

public final class hudSupport4 {
   public static final int v1 = 4;
   public static final int v2 = 16;
   public static final float v3 = 10.0F;
   private static final float v5 = 0.75F;
   private static final float v6 = 0.5F;
   public static final float v4 = 0.05F;
   private static final float v7 = 16.0F;
   private static final float v8 = 0.9F;
   private static final int v9 = 3;
   private static final float v10 = 2.5F;
   private static final float v11 = 8.0F;
   private final float[] v12 = new float[16];
   private final float[] v13 = new float[16];
   private final float[] v14 = new float[16];
   private final float[] v15 = new float[16];
   private final float[] v16 = new float[16];
   private final float[] v18 = new float[16];
   private final float[] v19 = new float[16];
   private final float[] v17 = new float[16];
   private final float[] v20 = new float[16];
   private final float[] v21 = new float[16];
   private final float[] v22 = new float[16];
   private final float[] v24 = new float[16];
   private final boolean[] v25 = new boolean[16];
   private float v26;
   private float v27;
   private static final int[] v28 = new int[]{-1, 1, 0, 0};
   private static final int[] v29 = new int[]{0, 0, -1, 1};

   public hudSupport4() {
   }

   public void v1(float var1, float var2, float var3, float var4) {
      this.v5(var1, var2, var3, var4);
      System.arraycopy(this.v12, 0, this.v14, 0, 16);
      System.arraycopy(this.v13, 0, this.v15, 0, 16);
      System.arraycopy(this.v12, 0, this.v16, 0, 16);
      System.arraycopy(this.v13, 0, this.v18, 0, 16);
      Arrays.fill(this.v19, 0.0F);
      Arrays.fill(this.v17, 0.0F);
      Arrays.fill(this.v20, 0.0F);
      Arrays.fill(this.v21, 0.0F);
      Arrays.fill(this.v25, false);
   }

   public int v1(float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var3 / 3.0F;
      float var8 = var4 / 3.0F;
      int var9 = var7 > 0.0F ? v2(Math.round((var5 - var1) / var7)) : 0;
      int var10 = var8 > 0.0F ? v2(Math.round((var6 - var2) / var8)) : 0;
      int var11 = var9 + 4 * var10;
      this.v1(var11);
      return var11;
   }

   public void v1(int var1) {
      Arrays.fill(this.v25, false);
      if (var1 >= 0 && var1 < 16) {
         this.v25[var1] = true;
      }
   }

   public void v2(float var1, float var2, float var3, float var4) {
      this.v1(var1, var2, var3, var4);
   }

   public boolean v1(float var1, float var2, float var3, float var4, hudRecord var5) {
      this.v5(var1, var2, var3, var4);
      this.v3();
      this.v1(var3, var4, var5);
      this.v1(this.v20, this.v21);
      float var6 = this.v1(var5);
      this.v1(this.v19, this.v17);
      float var7 = this.v2(var5);
      this.v1(var5.v1(var3, var4));
      return var6 < var5.v7() && var7 < var5.v6();
   }

   public boolean v3(float var1, float var2, float var3, float var4) {
      float var5 = this.v26 > 0.0F ? var3 / this.v26 : 1.0F;
      float var6 = this.v27 > 0.0F ? var4 / this.v27 : 1.0F;

      for (int var7 = 0; var7 < 16; var7++) {
         this.v22[var7] = (this.v14[var7] - this.v12[var7]) * 0.75F * var5;
         this.v24[var7] = (this.v15[var7] - this.v13[var7]) * 0.75F * var6;
      }

      this.v3();
      this.v5(var1, var2, var3, var4);
      float var9 = 0.0F;

      for (int var8 = 0; var8 < 16; var8++) {
         this.v14[var8] = this.v12[var8] + this.v22[var8];
         this.v15[var8] = this.v13[var8] + this.v24[var8];
         this.v19[var8] = this.v19[var8] * 0.5F;
         this.v17[var8] = this.v17[var8] * 0.5F;
         var9 = Math.max(var9, Math.max(Math.abs(this.v22[var8]), Math.abs(this.v24[var8])));
      }

      return var9 < 0.05F;
   }

   public float v1() {
      float var1 = 0.0F;

      for (int var2 = 0; var2 < 16; var2++) {
         var1 = Math.max(var1, Math.max(Math.abs(this.v14[var2] - this.v12[var2]), Math.abs(this.v15[var2] - this.v13[var2])));
      }

      return var1;
   }

   public boolean v2() {
      for (int var1 = 0; var1 < 16; var1++) {
         if (!v2(this.v14[var1]) || !v2(this.v15[var1]) || !v2(this.v19[var1]) || !v2(this.v17[var1])) {
            return false;
         }
      }

      return true;
   }

   public void v1(float[] var1, float var2) {
      for (int var3 = 0; var3 < 16; var3++) {
         var1[2 * var3] = this.v16[var3] + (this.v14[var3] - this.v16[var3]) * var2;
         var1[2 * var3 + 1] = this.v18[var3] + (this.v15[var3] - this.v18[var3]) * var2;
      }

      this.v1(var1);
      this.v2(var1);
   }

   public void v4(float var1, float var2, float var3, float var4) {
      this.v5(var1, var2, var3, var4);
   }

   private void v5(float var1, float var2, float var3, float var4) {
      float var5 = var3 / 3.0F;
      float var6 = var4 / 3.0F;

      for (int var7 = 0; var7 < 4; var7++) {
         float var8 = var7 == 3 ? var2 + var4 : var2 + var7 * var6;

         for (int var9 = 0; var9 < 4; var9++) {
            int var10 = var9 + 4 * var7;
            this.v12[var10] = var9 == 3 ? var1 + var3 : var1 + var9 * var5;
            this.v13[var10] = var8;
         }
      }

      this.v26 = var3;
      this.v27 = var4;
   }

   private void v3() {
      System.arraycopy(this.v14, 0, this.v16, 0, 16);
      System.arraycopy(this.v15, 0, this.v18, 0, 16);
   }

   private void v1(float var1, float var2, hudRecord var3) {
      float var4 = var1 / 3.0F;
      float var5 = var2 / 3.0F;
      float var6 = var3.v1();

      for (int var7 = 0; var7 < 4; var7++) {
         for (int var8 = 0; var8 < 4; var8++) {
            int var9 = var8 + 4 * var7;
            if (this.v25[var9]) {
               this.v20[var9] = (this.v12[var9] - this.v14[var9]) * var6;
               this.v21[var9] = (this.v13[var9] - this.v15[var9]) * var6;
            } else {
               float var10 = 0.0F;
               float var11 = 0.0F;
               int var12 = 0;

               for (int var13 = 0; var13 < 4; var13++) {
                  int var14 = v28[var13];
                  int var15 = v29[var13];
                  int var16 = var8 + var14;
                  int var17 = var7 + var15;
                  if (var16 >= 0 && var16 < 4 && var17 >= 0 && var17 < 4) {
                     int var18 = var16 + 4 * var17;
                     var10 += (this.v14[var18] - this.v14[var9] - var14 * var4) * var6;
                     var11 += (this.v15[var18] - this.v15[var9] - var15 * var5) * var6;
                     var12++;
                  }
               }

               this.v20[var9] = var10 / var12;
               this.v21[var9] = var11 / var12;
            }
         }
      }
   }

   private void v1(float[] var1, float[] var2) {
      for (int var3 = 0; var3 < 4; var3++) {
         for (int var4 = 0; var4 < 4; var4++) {
            int var5 = var4 + 4 * var3;
            float var6 = 0.0F;
            float var7 = 0.0F;
            int var8 = 0;

            for (int var9 = -1; var9 <= 1; var9++) {
               for (int var10 = -1; var10 <= 1; var10++) {
                  if (var10 != 0 || var9 != 0) {
                     int var11 = var4 + var10;
                     int var12 = var3 + var9;
                     if (var11 >= 0 && var11 < 4 && var12 >= 0 && var12 < 4) {
                        int var13 = var11 + 4 * var12;
                        var6 += var1[var13];
                        var7 += var2[var13];
                        var8++;
                     }
                  }
               }
            }

            this.v22[var5] = (var6 + var8 * var1[var5]) / (2.0F * var8);
            this.v24[var5] = (var7 + var8 * var2[var5]) / (2.0F * var8);
         }
      }

      System.arraycopy(this.v22, 0, var1, 0, 16);
      System.arraycopy(this.v24, 0, var2, 0, 16);
   }

   private float v1(hudRecord var1) {
      float var2 = 0.0F;

      for (int var3 = 0; var3 < 16; var3++) {
         float var4 = this.v20[var3];
         float var5 = this.v21[var3];
         float var6 = (float)Math.sqrt(var4 * var4 + var5 * var5);
         if (var6 > var1.v5()) {
            float var7 = var1.v5() / var6;
            var4 *= var7;
            var5 *= var7;
            this.v20[var3] = var4;
            this.v21[var3] = var5;
         }

         this.v19[var3] = var4 * 10.0F + this.v19[var3] * var1.v2();
         this.v17[var3] = var5 * 10.0F + this.v17[var3] * var1.v2();
         var2 += Math.abs(var4) + Math.abs(var5);
      }

      return var2;
   }

   private float v2(hudRecord var1) {
      float var2 = 0.0F;
      float var3 = 10.0F * var1.v3();

      for (int var4 = 0; var4 < 16; var4++) {
         float var5 = this.v19[var4];
         float var6 = this.v17[var4];
         float var7 = (float)Math.sqrt(var5 * var5 + var6 * var6);
         if (var7 > var1.v4()) {
            float var8 = var1.v4() / var7;
            var5 *= var8;
            var6 *= var8;
            this.v19[var4] = var5;
            this.v17[var4] = var6;
         }

         this.v14[var4] = this.v14[var4] + var5 * var3;
         this.v15[var4] = this.v15[var4] + var6 * var3;
         var2 += Math.abs(var5) + Math.abs(var6);
      }

      return var2;
   }

   private void v1(float var1) {
      float var2 = this.v4();
      if (var2 <= 1.0001F) {
         this.v1(var1, 0.0F, 0.0F);
      } else {
         float var3 = 0.0F;
         float var4 = 0.0F;

         for (int var5 = 0; var5 < 16; var5++) {
            var3 += this.v14[var5] - this.v12[var5];
            var4 += this.v15[var5] - this.v13[var5];
         }

         var3 /= 16.0F;
         var4 /= 16.0F;
         float var10 = var3 > var1 ? var3 - var1 : (var3 < -var1 ? var3 + var1 : 0.0F);
         float var6 = var4 > var1 ? var4 - var1 : (var4 < -var1 ? var4 + var1 : 0.0F);
         if (var10 != 0.0F || var6 != 0.0F) {
            for (int var7 = 0; var7 < 16; var7++) {
               this.v14[var7] = this.v14[var7] - var10;
               this.v15[var7] = this.v15[var7] - var6;
               if (this.v19[var7] * var10 > 0.0F) {
                  this.v19[var7] = 0.0F;
               }

               if (this.v17[var7] * var6 > 0.0F) {
                  this.v17[var7] = 0.0F;
               }
            }

            var3 -= var10;
            var4 -= var6;
         }

         this.v1(var1 * var2, var3, var4);
      }
   }

   private float v4() {
      float var1 = this.v26 / 3.0F;
      float var2 = this.v27 / 3.0F;
      if (var1 > 0.0F && var2 > 0.0F) {
         float var3 = Math.max(var1, var2) / Math.min(var1, var2);
         return Math.min(var3, 8.0F);
      } else {
         return 1.0F;
      }
   }

   private void v1(float var1, float var2, float var3) {
      for (int var4 = 0; var4 < 16; var4++) {
         float var5 = this.v14[var4] - this.v12[var4] - var2;
         if (var5 > var1 || var5 < -var1) {
            float var6 = var5 > 0.0F ? var1 : -var1;
            this.v14[var4] = this.v12[var4] + var2 + var6;
            if (this.v19[var4] * var5 > 0.0F) {
               this.v19[var4] = 0.0F;
            }
         }

         float var8 = this.v15[var4] - this.v13[var4] - var3;
         if (var8 > var1 || var8 < -var1) {
            float var7 = var8 > 0.0F ? var1 : -var1;
            this.v15[var4] = this.v13[var4] + var3 + var7;
            if (this.v17[var4] * var8 > 0.0F) {
               this.v17[var4] = 0.0F;
            }
         }
      }
   }

   private void v1(float[] var1) {
      float var2 = this.v26 / 3.0F;
      float var3 = this.v27 / 3.0F;
      if (var2 > 0.0F && var3 > 0.0F) {
         boolean var4 = var2 >= var3;
         float var5 = var4 ? var2 / var3 : var3 / var2;
         if (var5 > 1.0001F) {
            if (var5 > 16.0F) {
               var5 = 16.0F;
            }

            int var6 = var4 ? 1 : 0;
            float[] var7 = var4 ? this.v13 : this.v12;
            float var8 = 1.0F / var5;
            float var9 = 0.0F;

            for (int var10 = 0; var10 < 16; var10++) {
               var9 += var1[2 * var10 + var6] - var7[var10];
            }

            var9 /= 16.0F;

            for (int var17 = 0; var17 < 4; var17++) {
               float var11 = 0.0F;

               for (int var12 = 0; var12 < 4; var12++) {
                  int var13 = var4 ? var17 + 4 * var12 : var12 + 4 * var17;
                  var11 += var1[2 * var13 + var6] - var7[var13];
               }

               var11 /= 4.0F;
               float var19 = var9 + (var11 - var9) * 2.5F;

               for (int var20 = 0; var20 < 4; var20++) {
                  int var14 = var4 ? var17 + 4 * var20 : var20 + 4 * var17;
                  float var15 = var1[2 * var14 + var6] - var7[var14];
                  var1[2 * var14 + var6] = var7[var14] + var19 + (var15 - var11) * var8;
               }
            }
         }
      }
   }

   private void v2(float[] var1) {
      float var2 = 0.9F * this.v26 / 3.0F;
      float var3 = 0.9F * this.v27 / 3.0F;

      for (int var4 = 0; var4 < 3; var4++) {
         for (int var5 = 0; var5 < 4; var5++) {
            for (int var6 = 0; var6 < 3; var6++) {
               int var7 = var6 + 4 * var5;
               v1(var1, var7, var7 + 1, 0, this.v12, var2);
               v1(var1, var7, var7 + 1, 1, this.v13, var2);
            }
         }

         for (int var8 = 0; var8 < 3; var8++) {
            for (int var9 = 0; var9 < 4; var9++) {
               int var10 = var9 + 4 * var8;
               v1(var1, var10, var10 + 4, 0, this.v12, var3);
               v1(var1, var10, var10 + 4, 1, this.v13, var3);
            }
         }
      }
   }

   private static void v1(float[] var0, int var1, int var2, int var3, float[] var4, float var5) {
      float var6 = var0[2 * var2 + var3] - var4[var2] - (var0[2 * var1 + var3] - var4[var1]);
      float var7 = var6 > var5 ? var6 - var5 : (var6 < -var5 ? var6 + var5 : 0.0F);
      if (var7 != 0.0F) {
         float var8 = var7 * 0.5F;
         var0[2 * var1 + var3] = var0[2 * var1 + var3] + var8;
         var0[2 * var2 + var3] = var0[2 * var2 + var3] - var8;
      }
   }

   private static int v2(int var0) {
      return var0 < 0 ? 0 : (var0 >= 4 ? 3 : var0);
   }

   private static boolean v2(float var0) {
      return !Float.isNaN(var0) && !Float.isInfinite(var0);
   }
}
