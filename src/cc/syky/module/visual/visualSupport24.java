package cc.syky.module.visual;

import cc.syky.account.accountSupport22;
import org.joml.Matrix4f;

public final class visualSupport24 {
   public static boolean v1;
   public static boolean v2;
   public static int v3 = 3000;
   public static int v4 = -4616961;
   public static float v5 = 0.09F;
   public static float v6 = 32.0F;
   public static float v7 = 1.0F;
   public static float v8 = 0.6F;
   public static float v9 = 0.4F;
   public static visualSupport22 v10 = visualSupport22.STAR;
   private static final double v11 = 0.28;
   private static final double v12 = 1.1;
   private static final double v13 = 0.25;
   private static final double v14 = 0.1;
   private static final float v15 = 8.0F;
   private static final double v16 = Math.PI * 2;
   private static final visualSupport58 v18 = new visualSupport58(3000.0F, 8.0F);
   private static final visualSupport58 v19 = new visualSupport58(0.09F, 8.0F);
   private static final visualSupport58 v17 = new visualSupport58(32.0F, 8.0F);
   private static final visualSupport58 v20 = new visualSupport58(1.0F, 8.0F);
   private static final visualSupport58 v21 = new visualSupport58(0.6F, 8.0F);
   private static final visualSupport58 v22 = new visualSupport58(0.4F, 8.0F);
   private static final visualSupport58 v24 = new visualSupport58(1.0F, 8.0F);
   private static final visualSupport58 v25 = new visualSupport58(255.0F, 8.0F);
   private static final visualSupport58 v26 = new visualSupport58(185.0F, 8.0F);
   private static final visualSupport58 v27 = new visualSupport58(140.0F, 8.0F);
   private static final visualSupport58 v28 = new visualSupport58(255.0F, 8.0F);
   private static final visualSupport58[] v29 = new visualSupport58[]{v18, v19, v17, v20, v21, v22, v24, v25, v26, v27, v28};
   private static double v30;
   private static double v32;
   private static double v23;
   private static long v33;
   private static boolean v31;

   private visualSupport24() {
   }

   public static void v1() {
      Matrix4f var0 = accountSupport22.v3();
      if (var0 != null) {
         v3();
         visualSupport9.v1(var0, visualSupport9.v12(), v18.v1(), v5(), v19.v1(), v17.v1(), v21.v1(), v22.v1(), (float)v30, (float)v32, v23, v24.v1());
      }
   }

   private static void v3() {
      long var0 = System.nanoTime();
      double var2 = v33 == 0L ? 0.0 : Math.min((var0 - v33) / 1.0E9, 0.1);
      v33 = var0;
      v4();
      if (v31) {
         for (visualSupport58 var7 : v29) {
            var7.v2((float)var2);
         }
      } else {
         for (visualSupport58 var12 : v29) {
            var12.v3();
         }

         v31 = true;
      }

      double var9 = v20.v1();
      v30 = (v30 + var2 * var9 * 0.28) % (Math.PI * 2);
      v32 = (v32 + var2 * 1.1) % (Math.PI * 2);
      v23 += var2 * var9 * 0.25;
   }

   private static void v4() {
      v18.v1(v3);
      v19.v1(v5);
      v17.v1(v6);
      v20.v1(v7);
      v21.v1(v8);
      v22.v1(v9);
      v24.v1(v10 == visualSupport22.STAR ? 1.0F : 0.0F);
      v25.v1(v4 >>> 24 & 0xFF);
      v26.v1(v4 >>> 16 & 0xFF);
      v27.v1(v4 >>> 8 & 0xFF);
      v28.v1(v4 & 0xFF);
   }

   private static int v5() {
      return v1(v25) << 24 | v1(v26) << 16 | v1(v27) << 8 | v1(v28);
   }

   private static int v1(visualSupport58 var0) {
      return Math.max(0, Math.min(255, Math.round(var0.v1())));
   }

   public static void v2() {
      v33 = 0L;
      v31 = false;
   }
}
