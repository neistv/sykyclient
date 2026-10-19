package cc.syky.account;

import cc.syky.module.visual.visualSupport58;
import cc.syky.render.renderSupport45;
import cc.syky.ui.uiSupport169;

public final class accountSupport15 {
   public static boolean v1;
   public static boolean v2;
   public static float v3 = 0.7F;
   public static float v4 = 1.0F;
   public static float v5 = 0.4F;
   public static float v6 = 1.0F;
   public static float v7 = 0.5F;
   public static float v8;
   private static final double v9 = 4096.0;
   private static final double v10 = 0.12;
   private static final double v11 = 0.48;
   private static final float v12 = 0.6F;
   private static final float v13 = 1.4F;
   private static final float v14 = 0.3F;
   private static final float v15 = 1.7F;
   private static final float v16 = 1.22F;
   private static final float v18 = 0.9F;
   private static final float v19 = 1.1F;
   private static final float v17 = 0.3F;
   private static final float v20 = 9.0F;
   private static final double v21 = 0.1;
   private static final visualSupport58 v22 = new visualSupport58(0.7F, 9.0F);
   private static final visualSupport58 v24 = new visualSupport58(1.0F, 9.0F);
   private static final visualSupport58 v25 = new visualSupport58(0.4F, 9.0F);
   private static final visualSupport58 v26 = new visualSupport58(1.0F, 9.0F);
   private static final visualSupport58 v27 = new visualSupport58(0.5F, 9.0F);
   private static final visualSupport58[] v28 = new visualSupport58[]{v22, v24, v25, v26, v27};
   private static float v29;
   private static double v30;
   private static long v32;
   private static boolean v23;

   private accountSupport15() {
   }

   public static void v1() {
      if (v1 || v2) {
         int var0 = uiSupport169.v1("gpu.world.raindrops");

         try {
            v3();
         } finally {
            uiSupport169.v1(var0);
         }
      }
   }

   private static void v3() {
      v4();
      if (!(v29 <= 0.002F)) {
         renderSupport45.v1((float)v30, 4096.0F, v22.v1() * 1.22F * v29, v27.v1() * 0.9F * v29, v1(v24.v1(), 0.6F, 1.4F), v1(v25.v1(), 0.3F, 1.7F));
      }
   }

   private static void v4() {
      long var0 = System.nanoTime();
      double var2 = v32 == 0L ? 0.0 : Math.min((var0 - v32) / 1.0E9, 0.1);
      v32 = var0;
      v5();
      float var4 = v2 ? 1.0F : v8;
      if (v23) {
         for (visualSupport58 var8 : v28) {
            var8.v2((float)var2);
         }

         float var9 = var4 > v29 ? 1.1F : 0.3F;
         v29 = v29 + (var4 - v29) * (1.0F - (float)Math.exp(-var9 * var2));
      } else {
         for (visualSupport58 var13 : v28) {
            var13.v3();
         }

         v29 = var4;
         v23 = true;
      }

      v30 = v30 + var2 * (0.12 + 0.36 * v26.v1());
      if (v30 >= 4096.0) {
         v30 -= 4096.0;
      }
   }

   private static void v5() {
      v22.v1(v3);
      v24.v1(v4);
      v25.v1(v5);
      v26.v1(v6);
      v27.v1(v7);
   }

   private static float v1(float var0, float var1, float var2) {
      return var1 + (var2 - var1) * var0;
   }

   public static void v2() {
      v32 = 0L;
      v23 = false;
   }
}
