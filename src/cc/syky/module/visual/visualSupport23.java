package cc.syky.module.visual;

import cc.syky.account.accountSupport17;
import cc.syky.account.accountSupport22;
import cc.syky.render.renderSupport3;
import org.joml.Matrix4f;

public final class visualSupport23 {
   public static boolean v1;
   public static boolean v2;
   public static int v3 = 90;
   public static int v4 = -13942;
   public static float v5 = 0.11F;
   public static float v6 = 0.75F;
   public static float v7 = 7.0F;
   public static float v8 = 11.0F;
   public static float v9 = 0.85F;
   public static float v10 = 0.45F;
   public static visualSupport22 v11 = visualSupport22.ORB;
   private static final float v12 = 3.4F;
   private static final int v13 = 12;
   private static final float v14 = 0.625F;
   private static final double v15 = 3.5;
   private static final accountSupport17 v16 = new accountSupport17(12);
   private static final renderSupport3 v18 = new renderSupport3();
   private static float v19;
   private static double v17;
   private static double v20;
   private static double v21;
   private static float v22;
   private static float v24;
   private static float v25;
   private static boolean v26;

   private visualSupport23() {
   }

   public static void v1(double var0, double var2, double var4, float var6, float var7, float var8) {
      if (v1 || v2) {
         v16.v1(var0, var2, var4, var6, var7, var8);
      }
   }

   public static boolean v1() {
      return v2 || v1 && v16.v1() > 0;
   }

   public static void v2() {
      float var0 = v16.v2();
      v16.v1(var0, v6 * 1.25F);
      v1(var0);
      if (v16.v1() != 0) {
         Matrix4f var1 = accountSupport22.v3();
         if (var1 != null) {
            v16.v1(v18);
            v18.v1(v3, v4, v5, v6, v7, v8, 3.4F, v9, v10, v11 == visualSupport22.STAR ? 1.0F : 0.0F);
            visualSupport9.v1(visualSupport8.HIT, var1, visualSupport9.v12(), v18);
         }
      }
   }

   public static void v2(double var0, double var2, double var4, float var6, float var7, float var8) {
      if (!v26) {
         v19 = 0.625F;
         v26 = true;
      }

      v17 = var0 + var6 * 3.5;
      v20 = var2 + var7 * 3.5;
      v21 = var4 + var8 * 3.5;
      v22 = -var6;
      v24 = -var7;
      v25 = -var8;
   }

   public static void v3() {
      v2 = false;
      v26 = false;
      if (!v1) {
         v4();
      }
   }

   public static void v4() {
      v16.v3();
      v19 = 0.0F;
   }

   private static void v1(float var0) {
      if (v26 && v2) {
         v19 += var0;
         if (!(v19 < 0.625F)) {
            v19 -= 0.625F;
            v1(v17, v20, v21, v22, v24, v25);
         }
      }
   }
}
