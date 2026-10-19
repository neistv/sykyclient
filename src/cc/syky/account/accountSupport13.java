package cc.syky.account;

import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiSupport155;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public final class accountSupport13 {
   private static final int v9 = 3;
   private static final int v10 = 8;
   public static final int v1 = 24;
   private static final int v11 = 5;
   private static final int v12 = 23063;
   private static final double v13 = 0.85;
   private static final double v14 = 1.15;
   private static final double v15 = 0.0;
   private static final double v16 = 0.22;
   private static final double v18 = 0.08;
   private static final double v19 = 0.92;
   private static final double v17 = 0.05;
   private static final double v20 = 0.38;
   public static final float v2 = 0.2F;
   private static final float v21 = 0.95F;
   public static final double v3 = 3.0;
   public static final double v4 = 2.7;
   public static final double v5 = 30.0;
   public static final float v6 = 0.22F;
   public static final float v7 = 0.6F;
   public static final double v8 = 720.0;
   private static final float v22 = 0.0019607844F;
   private static final float v24 = 1.5F;
   private static final float v25 = 1.0F;
   private static final float v26 = 0.14F;
   private static final int v27 = 5;
   private static final float v28 = 0.62F;
   private static final float v29 = 1.35F;
   private static final float v30 = 1.0F;
   private static final float v32 = 0.115F;
   private static final double v23 = 0.45;
   private static final Vector3f v33 = new Vector3f(0.42F, 0.78F, -0.46F).normalize();
   private static final float v31 = 0.45F;
   private static final float v34 = 0.85F;
   private static final Vector3f[] v36 = v2();
   private static final int[][] v38 = v3();
   private static float[] v42 = v3(0.45F, 0.85F);
   private static float v43 = 0.45F;
   private static float v37 = 0.85F;
   private static final Vector3f v48 = new Vector3f(0.0F, 1.0F, 0.0F);
   private static final double[] v40 = v1();

   private accountSupport13() {
   }

   private static float[] v1(float var0, float var1) {
      if (var0 != v43 || var1 != v37) {
         v42 = v3(var0, var1);
         v43 = var0;
         v37 = var1;
      }

      return v42;
   }

   private static double v1(int var0) {
      int var1 = var0 % 8;
      int var2 = v2(var0);
      int var3 = (var1 + 23063) * -1640531535;
      var3 ^= var3 >>> 15;
      var3 *= -2048144789;
      var3 ^= var3 >>> 13;
      double var4 = (var3 >>> 8) / 1.6777216E7;
      return Math.pow((var2 + var4) / 8.0, 0.85);
   }

   private static int v2(int var0) {
      return var0 % 8 * 5 % 8;
   }

   private static double[] v1() {
      double[] var0 = new double[24];

      for (int var1 = 0; var1 < 24; var1++) {
         var0[var1] = v1(var1);
      }

      return var0;
   }

   private static void v1(int var0, int var1, double var2, double var4, double var6, double var8, double var10, double[] var12) {
      double var13 = Math.toRadians(var0 * (360.0 / var1) + var10 * 0.38 - var8);
      double var15 = v40[var0];
      double var17 = 1.0 + 0.0 * (var15 - 0.5) + 0.22 * (Math.sin(Math.PI * var15) - 0.5);
      double var19 = var2 * 1.15 * var17 * var6;
      var12[0] = Math.sin(var13) * var19;
      var12[1] = 0.05 + var4 * (0.08 + 0.92 * var15);
      var12[2] = Math.cos(var13) * var19;
   }

   private static float v1(int var0, float var1, boolean var2, accountSupport13.Part2 var3) {
      float var4 = v1(var0, var3.v1());
      float var5 = Math.min(var3.v2(), 0.95F);
      float var6 = (var1 - (var2 ? 1.0F - var4 : var4) * var5) / (1.0F - var5);
      return var6 <= 0.0F ? 0.0F : Math.min(var6, 1.0F);
   }

   private static float v1(int var0, accountSupport14 var1) {
      int var2 = v2(var0);
      byte var3 = 7;

      return switch (var1) {
         case BOTTOM -> (float)var2 / var3;
         case TOP -> (float)(var3 - var2) / var3;
         case MIDDLE -> {
            double var4 = var3 / 2.0;
            double var6 = var3 % 2 == 0 ? 0.0 : 0.5;
            yield (float)((Math.abs(var2 - var4) - var6) / (var4 - var6));
         }
      };
   }

   private static float v2(float var0, float var1) {
      float var2 = var1 <= 0.0F ? 1.0F : var0 / var1;
      return var2 >= 1.0F ? 1.0F : var2 * var2 * (3.0F - 2.0F * var2);
   }

   private static float v1(float var0) {
      return var0 * var0 * (3.0F - 2.0F * var0);
   }

   private static double v1(float var0, accountSupport13.Part2 var1) {
      return var1.v3() + (1.0 - var1.v3()) * v1(var0, var1.v4());
   }

   private static double v2(float var0, accountSupport13.Part2 var1) {
      return var1.v5() * (1.0 - v1(var0, var1.v4()));
   }

   private static double v1(float var0, double var1) {
      double var3 = 1.0 - var0;
      return 1.0 - var3 * var3 * Math.cos(var1 * var0);
   }

   private static double v3(float var0, accountSupport13.Part2 var1) {
      return var1.v6() * (1.0 - v1(var0));
   }

   private static Vector3f[] v2() {
      Vector3f[] var0 = new Vector3f[7];
      var0[0] = new Vector3f(0.0F, 1.35F, 0.0F);
      var0[1] = new Vector3f(0.0F, -1.0F, 0.0F);

      for (int var1 = 0; var1 < 5; var1++) {
         double var2 = var1 * 2.0 * Math.PI / 5.0;
         var0[2 + var1] = new Vector3f((float)(Math.cos(var2) * 0.62F), 0.0F, (float)(Math.sin(var2) * 0.62F));
      }

      return var0;
   }

   private static int[][] v3() {
      int[][] var0 = new int[10][];

      for (int var1 = 0; var1 < 5; var1++) {
         int var2 = 2 + var1;
         int var3 = 2 + (var1 + 1) % 5;
         var0[var1 * 2] = new int[]{0, var2, var3};
         var0[var1 * 2 + 1] = new int[]{1, var3, var2};
      }

      return var0;
   }

   private static float[] v3(float var0, float var1) {
      float[] var2 = new float[v38.length];
      Vector3f var3 = new Vector3f();
      Vector3f var4 = new Vector3f();
      Vector3f var5 = new Vector3f();
      Vector3f var6 = new Vector3f();

      for (int var7 = 0; var7 < v38.length; var7++) {
         Vector3f var8 = v36[v38[var7][0]];
         Vector3f var9 = v36[v38[var7][1]];
         Vector3f var10 = v36[v38[var7][2]];
         var9.sub(var8, var3);
         var10.sub(var8, var4);
         var3.cross(var4, var5).normalize();
         var6.set(var8).add(var9).add(var10).mul(0.33333334F);
         if (var5.dot(var6) < 0.0F) {
            var5.negate();
         }

         float var11 = 0.5F + 0.5F * var5.dot(v33);
         var2[var7] = var0 + (1.0F - var0) * (float)Math.pow(var11, var1);
      }

      return var2;
   }

   private static void v1(
      double var0,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      float var12,
      float var13,
      int var14,
      float[] var15,
      Quaternionf var16,
      Vector3f var17,
      Vector3f var18,
      double[] var19
   ) {
      var17.set((float)(var6 - var0), (float)(var8 - var2), (float)(var10 - var4));
      if (!(var17.lengthSquared() < 1.0E-8F)) {
         var16.identity().rotationTo(v48, var17.normalize()).rotateY(var13);
         float var20 = 0.115F * var12;

         for (int var21 = 0; var21 < v38.length; var21++) {
            int[] var22 = v38[var21];

            for (int var23 = 0; var23 < 3; var23++) {
               var18.set(v36[var22[var23]]).mul(var20);
               var16.transform(var18);
               var19[var23 * 3] = var0 + var18.x;
               var19[var23 * 3 + 1] = var2 + var18.y;
               var19[var23 * 3 + 2] = var4 + var18.z;
            }

            visualSupport9.v1(var19[0], var19[1], var19[2], var19[3], var19[4], var19[5], var19[6], var19[7], var19[8], uiSupport155.v2(var14, var15[var21]));
         }
      }
   }

   public static void v1(
      double var0,
      double var2,
      double var4,
      double var6,
      double var8,
      float var10,
      boolean var11,
      accountSupport13.Part2 var12,
      int var13,
      float var14,
      accountSupport13.Part1 var15
   ) {
      if (!(var14 <= 0.0F) && !(var10 <= 0.0F)) {
         double var16 = System.currentTimeMillis() % 360000L / 2.5;
         float[] var18 = v1(var15.v4(), var15.v5());
         double var19 = var2 + var8 * 0.5;
         Quaternionf var21 = new Quaternionf();
         Vector3f var22 = new Vector3f();
         Vector3f var23 = new Vector3f();
         double[] var24 = new double[9];
         double[] var25 = new double[3];

         for (int var26 = 0; var26 < 24; var26++) {
            float var27 = v1(var26, var10, var11, var12);
            if (!(var27 <= 0.0F)) {
               float var28 = v2(var27, var12.v7());
               if (!(var14 * var28 < 0.0019607844F)) {
                  float var29 = v1(var27);
                  v1(var26, 24, var6, var8, v1(var27, var12), v2(var27, var12), var16, var25);
                  double var30 = var0 + var25[0];
                  double var32 = var2 + var25[1];
                  double var34 = var4 + var25[2];
                  float var36 = (float)Math.toRadians((var16 * 0.45 + v40[var26] * 360.0 + v3(var27, var12)) % 360.0);
                  int var37 = uiSupport155.v1(var13, var14 * var28);
                  v1(var30, var32, var34, var0, var19, var4, var29, var36, var37, var18, var21, var22, var23, var24);
                  float var38 = var12.v8() >= 1.0F ? var29 : (float)Math.pow(var29, var12.v8());
                  int var39 = uiSupport155.v1(var13, var14 * var15.v3() * var28);
                  visualSupport9.v1(var30, var32, var34, var15.v1() * var38, 1.0F, 0.0F, var39);
                  visualSupport9.v1(var30, var32, var34, var15.v2() * var38, 1.0F, 0.0F, var39);
               }
            }
         }
      }
   }

   public record Part1(float haloWide, float haloNarrow, float haloAlpha, float shadeFloor, float shadeGamma) {
      public float v1() {
         return this.haloWide;
      }

      public float v2() {
         return this.haloNarrow;
      }

      public float v3() {
         return this.haloAlpha;
      }

      public float v4() {
         return this.shadeFloor;
      }

      public float v5() {
         return this.shadeGamma;
      }
   }

   public record Part2(accountSupport14 from, float sweep, double distance, double press, double swing, double unwind, float lightUp, float haloLead) {
      public accountSupport14 v1() {
         return this.from;
      }

      public float v2() {
         return this.sweep;
      }

      public double v3() {
         return this.distance;
      }

      public double v4() {
         return this.press;
      }

      public double v5() {
         return this.swing;
      }

      public double v6() {
         return this.unwind;
      }

      public float v7() {
         return this.lightUp;
      }

      public float v8() {
         return this.haloLead;
      }
   }
}
