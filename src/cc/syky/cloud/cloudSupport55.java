package cc.syky.cloud;

public final class cloudSupport55 {
   public static final int v1 = 33;
   public static final int v2 = 1089;
   public static final int v3 = 33;
   public static final int v4 = 35937;
   private static final float v5 = 0.2126F;
   private static final float v6 = 0.7152F;
   private static final float v7 = 0.0722F;
   private static final float v8 = 0.95047F;
   private static final float v9 = 1.0F;
   private static final float v10 = 1.08883F;
   private static final float v11 = 80.0F;
   private static final float v12 = 0.05F;
   private static final float[] v13 = new float[]{0.4123908F, 0.3575843F, 0.1804808F, 0.212639F, 0.7151687F, 0.0721923F, 0.0193308F, 0.1191948F, 0.9505322F};
   private static final float[] v14 = new float[]{3.24097F, -1.5373832F, -0.4986108F, -0.9692436F, 1.8759675F, 0.0415551F, 0.0556301F, -0.203977F, 1.0569715F};
   private static final float[] v15 = new float[]{0.7328F, 0.4296F, -0.1624F, -0.7036F, 1.6975F, 0.0061F, 0.003F, 0.0136F, 0.9834F};
   private static final float[] v16 = new float[]{1.0961238F, -0.278869F, 0.1827452F, 0.454369F, 0.4735332F, 0.0720978F, -0.0096276F, -0.005698F, 1.0153255F};
   private static final int v18 = 4096;
   private static final float v19 = 8.0F;
   private static final float[] v17 = new float[4097];

   private cloudSupport55() {
   }

   public static void v1(cloudRecord8 var0, int[] var1) {
      if (var1.length != 35937) {
         throw new IllegalArgumentException("LUT array must be 35937 entries, got " + var1.length);
      } else {
         byte var2 = 32;
         float[] var3 = new float[33];

         for (int var4 = 0; var4 < 33; var4++) {
            var3[var4] = v1(var4 / 32.0F);
         }

         float[] var47 = v1(var0.v12(), var0.v13());
         float var5 = (float)Math.pow(2.0, var0.v2());

         for (int var6 = 0; var6 < 9; var6++) {
            var47[var6] *= var5;
         }

         float var48 = var0.v6();
         float var7 = 1.0F + var0.v3();
         float var8 = var0.v11();
         float var9 = var0.v7();
         float var10 = var0.v8();
         float var11 = var0.v9();
         float var12 = var0.v10();
         float var13 = var0.v5();
         float var14 = 1.0F + var0.v4();
         float var15 = var0.v19();
         cloudSupport56 var16 = var0.v17();
         float var17 = var0.v14();
         float var18 = var0.v15();
         float[] var19 = v1(var0.v16());
         float[] var20 = v1(var0.v18());
         float var21 = 0.5F / var48;
         float var22 = 0.5F / (1.0F - var48);
         float var23 = 2.0F * var48;
         float var24 = 2.0F * (1.0F - var48);
         boolean var25 = var9 != 0.0F || var10 != 0.0F || var11 != 0.0F || var12 != 0.0F;
         boolean var26 = var7 != 1.0F;
         boolean var27 = var8 != 0.0F;
         boolean var28 = var17 != 0.0F;
         boolean var29 = var13 != 0.0F;
         boolean var30 = var14 != 1.0F;
         boolean var31 = var15 != 0.0F;
         cloudSupport55.Part1 var32 = new cloudSupport55.Part1();

         for (int var33 = 0; var33 < 33; var33++) {
            float var34 = var3[var33];
            float var35 = var47[2] * var34;
            float var36 = var47[5] * var34;
            float var37 = var47[8] * var34;
            int var38 = var33 * 33;

            for (int var39 = 0; var39 < 33; var39++) {
               float var40 = var3[var39];
               float var41 = var35 + var47[1] * var40;
               float var42 = var36 + var47[4] * var40;
               float var43 = var37 + var47[7] * var40;
               int var44 = var39 * 1089 + var38;

               for (int var45 = 0; var45 < 33; var45++) {
                  float var46 = var3[var45];
                  var32.v1 = v8(var41 + var47[0] * var46);
                  var32.v2 = v8(var42 + var47[3] * var46);
                  var32.v3 = v8(var43 + var47[6] * var46);
                  if (var25) {
                     v1(var32, var9, var10, var11, var12);
                  }

                  if (var26) {
                     v1(var32, var7, var48);
                  }

                  if (var27) {
                     v1(var32, var8, var48, var21, var22, var23, var24);
                  }

                  if (var28) {
                     v1(var32, var19, var20, var17, var18);
                  }

                  if (var29) {
                     v1(var32, var13);
                  }

                  if (var30) {
                     v2(var32, var14);
                  }

                  if (var31) {
                     v1(var32, var15, var16);
                  }

                  var1[var44 + var45] = v2(var32);
               }
            }
         }
      }
   }

   private static void v1(cloudSupport55.Part1 var0, float var1, float var2, float var3, float var4) {
      float var5 = v1(var0);
      float var6 = var2 * 0.5F * v3(var5 * 2.0F) + var4 * 0.35F * v3(var5 * 4.0F);
      float var7 = 1.0F + var1 * 0.6F * v4((var5 - 0.5F) * 2.0F) + var3 * 0.5F * v4((var5 - 0.75F) * 4.0F);
      var0.v1 = var0.v1 * var7 + var6;
      var0.v2 = var0.v2 * var7 + var6;
      var0.v3 = var0.v3 * var7 + var6;
   }

   private static float v3(float var0) {
      return v6(1.0F - v7(var0));
   }

   private static float v4(float var0) {
      return v6(v7(var0));
   }

   private static void v1(cloudSupport55.Part1 var0, float var1, float var2) {
      var0.v1 = (var0.v1 - var2) * var1 + var2;
      var0.v2 = (var0.v2 - var2) * var1 + var2;
      var0.v3 = (var0.v3 - var2) * var1 + var2;
   }

   private static void v1(cloudSupport55.Part1 var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      var0.v1 = v1(var0.v1, var1, var2, var3, var4, var5, var6);
      var0.v2 = v1(var0.v2, var1, var2, var3, var4, var5, var6);
      var0.v3 = v1(var0.v3, var1, var2, var3, var4, var5, var6);
   }

   private static float v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var0 < var2 ? var0 * var3 : 0.5F + (var0 - var2) * var4;
      float var8 = v7(var7);
      float var9 = var7 + var1 * (v6(var8) - var8);
      return var9 < 0.5F ? var9 * var5 : var2 + (var9 - 0.5F) * var6;
   }

   private static void v1(cloudSupport55.Part1 var0, float[] var1, float[] var2, float var3, float var4) {
      float var5 = v7(v1(var0) + var4 * 0.5F);
      float var6 = var5 * var5;
      float var7 = (1.0F - var5) * (1.0F - var5);
      float var8 = var3 * 0.5F;
      var0.v1 = var0.v1 + (var1[0] * var7 + var2[0] * var6) * var8;
      var0.v2 = var0.v2 + (var1[1] * var7 + var2[1] * var6) * var8;
      var0.v3 = var0.v3 + (var1[2] * var7 + var2[2] * var6) * var8;
   }

   private static void v1(cloudSupport55.Part1 var0, float var1) {
      float var2 = Math.max(var0.v1, Math.max(var0.v2, var0.v3));
      float var3 = Math.min(var0.v1, Math.min(var0.v2, var0.v3));
      float var4 = v7(var2 - var3);
      float var5 = v7((var0.v1 - Math.max(var0.v2, var0.v3)) * 2.0F);
      v2(var0, 1.0F + var1 * (1.0F - var4) * (1.0F - 0.5F * var5));
   }

   private static void v2(cloudSupport55.Part1 var0, float var1) {
      float var2 = v1(var0);
      var0.v1 = var2 + (var0.v1 - var2) * var1;
      var0.v2 = var2 + (var0.v2 - var2) * var1;
      var0.v3 = var2 + (var0.v3 - var2) * var1;
   }

   private static void v1(cloudSupport55.Part1 var0, float var1, cloudSupport56 var2) {
      float var3 = var0.v1 * var2.v1() + var0.v2 * var2.v2() + var0.v3 * var2.v3();
      var0.v1 = var0.v1 + (var3 - var0.v1) * var1;
      var0.v2 = var0.v2 + (var3 - var0.v2) * var1;
      var0.v3 = var0.v3 + (var3 - var0.v3) * var1;
   }

   private static float[] v1(int var0) {
      float var1 = (var0 >> 16 & 0xFF) / 255.0F;
      float var2 = (var0 >> 8 & 0xFF) / 255.0F;
      float var3 = (var0 & 0xFF) / 255.0F;
      float var4 = var1 * 0.2126F + var2 * 0.7152F + var3 * 0.0722F;
      return new float[]{var1 - var4, var2 - var4, var3 - var4};
   }

   private static float[] v1(float var0, float var1) {
      if (var0 == 0.0F && var1 == 0.0F) {
         return new float[]{1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F};
      } else {
         float var2 = 1000000.0F / (153.75154F + var0 * 80.0F);
         double var3 = var2;
         double var5 = var3 * var3;
         double var7 = var5 * var3;
         double var9 = var3 <= 7000.0
            ? -4.607E9 / var7 + 2967800.0 / var5 + 99.11 / var3 + 0.244063
            : -2.0064E9 / var7 + 1901800.0 / var5 + 247.48 / var3 + 0.23704;
         double var11 = -3.0 * var9 * var9 + 2.87 * var9 - 0.275;
         if (var1 != 0.0F) {
            double var13 = -2.0 * var9 + 12.0 * var11 + 3.0;
            double var15 = 4.0 * var9 / var13;
            double var17 = 6.0 * var11 / var13 - var1 * 0.05F;
            double var19 = 2.0 * var15 - 8.0 * var17 + 4.0;
            var9 = 3.0 * var15 / var19;
            var11 = 2.0 * var17 / var19;
         }

         float var22 = (float)(var9 / var11);
         float var14 = (float)((1.0 - var9 - var11) / var11);
         float[] var23 = v1(v15, 0.95047F, 1.0F, 1.08883F);
         float[] var16 = v1(v15, var22, 1.0F, var14);
         float[] var24 = new float[]{var16[0] / var23[0], 0.0F, 0.0F, 0.0F, var16[1] / var23[1], 0.0F, 0.0F, 0.0F, var16[2] / var23[2]};
         float[] var18 = v1(v14, v1(v16, v1(var24, v1(v15, v13))));
         float[] var25 = v1(var18, 1.0F, 1.0F, 1.0F);
         float var20 = var25[0] * 0.2126F + var25[1] * 0.7152F + var25[2] * 0.0722F;
         if (var20 > 1.0E-4F) {
            for (int var21 = 0; var21 < 9; var21++) {
               var18[var21] /= var20;
            }
         }

         return var18;
      }
   }

   private static float[] v1(float[] var0, float[] var1) {
      float[] var2 = new float[9];

      for (int var3 = 0; var3 < 3; var3++) {
         for (int var4 = 0; var4 < 3; var4++) {
            var2[var3 * 3 + var4] = var0[var3 * 3] * var1[var4] + var0[var3 * 3 + 1] * var1[3 + var4] + var0[var3 * 3 + 2] * var1[6 + var4];
         }
      }

      return var2;
   }

   private static float[] v1(float[] var0, float var1, float var2, float var3) {
      return new float[]{
         var0[0] * var1 + var0[1] * var2 + var0[2] * var3, var0[3] * var1 + var0[4] * var2 + var0[5] * var3, var0[6] * var1 + var0[7] * var2 + var0[8] * var3
      };
   }

   private static float v1(cloudSupport55.Part1 var0) {
      return var0.v1 * 0.2126F + var0.v2 * 0.7152F + var0.v3 * 0.0722F;
   }

   private static int v2(cloudSupport55.Part1 var0) {
      return 0xFF000000 | v5(var0.v1) << 16 | v5(var0.v2) << 8 | v5(var0.v3);
   }

   private static int v5(float var0) {
      return (int)(v7(var0) * 255.0F + 0.5F);
   }

   private static float v6(float var0) {
      return var0 * var0 * (3.0F - 2.0F * var0);
   }

   private static float v7(float var0) {
      return Math.min(Math.max(var0, 0.0F), 1.0F);
   }

   public static float v1(float var0) {
      return var0 <= 0.04045F ? var0 / 12.92F : (float)Math.pow((var0 + 0.055F) / 1.055F, 2.4);
   }

   public static float v2(float var0) {
      if (var0 <= 0.0F) {
         return 0.0F;
      } else {
         return var0 <= 0.0031308F ? var0 * 12.92F : (float)(1.055 * Math.pow(var0, 0.4166666666666667) - 0.055);
      }
   }

   private static float v8(float var0) {
      if (var0 <= 0.0F) {
         return 0.0F;
      } else if (var0 >= 8.0F) {
         return v2(var0);
      } else {
         float var1 = var0 * 512.0F;
         int var2 = (int)var1;
         return v17[var2] + (v17[var2 + 1] - v17[var2]) * (var1 - var2);
      }
   }

   static {
      for (int var0 = 0; var0 <= 4096; var0++) {
         v17[var0] = v2(8.0F * var0 / 4096.0F);
      }
   }

   public static final class Part1 {
      public float v1;
      public float v2;
      public float v3;

      public Part1() {
      }
   }
}
