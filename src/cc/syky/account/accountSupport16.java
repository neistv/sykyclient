package cc.syky.account;

import cc.syky.module.visual.visualSupport22;
import cc.syky.module.visual.visualSupport8;
import cc.syky.module.visual.visualSupport9;
import cc.syky.render.renderSupport3;
import org.joml.Matrix4f;

public final class accountSupport16 {
   public static boolean v1;
   public static boolean v2;
   public static int v3 = 5;
   public static float v4 = 2.5F;
   public static int v5 = -7351041;
   public static float v6 = 0.085F;
   public static float v7 = 0.6F;
   public static float v8 = 0.7F;
   public static float v9 = 1.0F;
   public static float v10 = 1.0F;
   public static float v11 = 0.35F;
   public static visualSupport22 v12 = visualSupport22.ORB;
   private static final float v13 = 6.0F;
   private static final int v14 = 256;
   private static final int v15 = 16;
   private static final double v16 = 0.05;
   private static final float v18 = 0.05F;
   private static final double v19 = 5.0;
   private static final double v17 = 4.0;
   private static final float v20 = 1.6F;
   private static final accountSupport17 v21 = new accountSupport17(256);
   private static final renderSupport3 v22 = new renderSupport3();
   private static int v24 = 1;
   private static int v25;
   private static boolean v26;
   private static double v27;
   private static double v28;
   private static double v29;
   private static float v30;
   private static float v32;
   private static float v23;
   private static float v33;
   private static double v31;
   private static double v34;
   private static double v36;
   private static boolean v38;

   private accountSupport16() {
   }

   public static void v1(double var0, double var2, double var4, double var6, double var8, double var10) {
      v25++;
      v1(var0, var2, var4, var6, var8, var10, v6());
   }

   public static void v1() {
      v24 = Math.max(v25, 1);
      v25 = 0;
   }

   private static int v6() {
      float var0 = Math.max(v7 * 1.25F, 0.05F);
      int var1 = (int)(12.8F / var0);
      return Math.max(1, var1 / v24);
   }

   private static void v1(double var0, double var2, double var4, double var6, double var8, double var10, int var12) {
      if (v1 || v2) {
         double var13 = var6 - var0;
         double var15 = var8 - var2;
         double var17 = var10 - var4;
         double var19 = Math.sqrt(var13 * var13 + var15 * var15 + var17 * var17);
         if (!(var19 < 0.05)) {
            int var21 = Math.max(Math.round((float)(var19 * v4)), 1);
            int var22 = Math.min(Math.min(var21, var12), 16);
            float var23 = (float)(var13 / var19);
            float var24 = (float)(var15 / var19);
            float var25 = (float)(var17 / var19);

            for (int var26 = 0; var26 < var22; var26++) {
               double var27 = (var26 + 1.0) / var22;
               float var29 = 0.05F * (float)(1.0 - var27);
               v21.v1(var0 + var13 * var27, var2 + var15 * var27, var4 + var17 * var27, var23, var24, var25, var29);
            }
         }
      }
   }

   public static boolean v2() {
      return v2 || v1 && v21.v1() > 0;
   }

   public static void v3() {
      float var0 = v21.v2();
      v21.v1(var0, v7 * 1.25F);
      v1(var0);
      if (v21.v1() != 0) {
         Matrix4f var1 = accountSupport22.v3();
         if (var1 != null) {
            v21.v1(v22);
            v22.v1(v3, v5, v6, v7, v8, v9, 6.0F, v10, v11, v12 == visualSupport22.STAR ? 1.0F : 0.0F);
            visualSupport9.v1(visualSupport8.TRAIL, var1, visualSupport9.v12(), v22);
         }
      }
   }

   public static void v1(double var0, double var2, double var4, float var6, float var7, float var8) {
      v26 = true;
      v27 = var0;
      v28 = var2;
      v29 = var4;
      v30 = var6;
      v32 = var7;
      v23 = var8;
   }

   public static void v4() {
      v2 = false;
      v26 = false;
      v38 = false;
      if (!v1) {
         v5();
      }
   }

   public static void v5() {
      v21.v3();
      v33 = 0.0F;
      v38 = false;
      v24 = 1;
      v25 = 0;
   }

   private static void v1(float var0) {
      if (v26 && v2) {
         v33 += var0 / 1.6F;
         boolean var1 = v33 >= 1.0F;
         if (var1) {
            v33 = v33 - (float)Math.floor(v33);
         }

         float var2 = v23;
         float var3 = -v30;
         float var4 = (float)Math.sqrt(var2 * var2 + var3 * var3);
         if (!(var4 < 1.0E-4F)) {
            var2 /= var4;
            var3 /= var4;
            double var5 = (v33 * 2.0 - 1.0) * 4.0;
            double var7 = v27 + v30 * 5.0 + var2 * var5;
            double var9 = v28 + v32 * 5.0;
            double var11 = v29 + v23 * 5.0 + var3 * var5;
            if (v38 && !var1) {
               double var13 = Math.sqrt((var7 - v31) * (var7 - v31) + (var9 - v34) * (var9 - v34) + (var11 - v36) * (var11 - v36));
               if (var13 < 1.0 / Math.max(v4, 0.1F)) {
                  return;
               }

               v1(v31, v34, v36, var7, var9, var11, v6());
            }

            v31 = var7;
            v34 = var9;
            v36 = var11;
            v38 = true;
         }
      }
   }
}
