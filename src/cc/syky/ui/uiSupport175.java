package cc.syky.ui;

import cc.syky.account.accountSupport22;
import cc.syky.cloud.cloudSupport69;
import cc.syky.render.renderSupport45;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_4184;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public final class uiSupport175 {
   private static final double v14 = Math.PI * 2;
   private static final double v15 = 0.1;
   private static final double[] v16 = new double[]{0.18, 0.113, 0.071, 0.043};
   public static final int v1 = -12366499;
   private static final float v18 = 0.18F;
   private static final float v19 = 0.45F;
   public static int v2 = -12366499;
   @Nullable
   public static GpuTextureView v3;
   public static boolean v4;
   public static int v5 = -12366499;
   public static float v6;
   public static float v7;
   public static boolean v8;
   public static float v9;
   public static float v10;
   public static float v11 = 1.0F;
   public static float v12 = 1.0F;
   private static final double[] v17 = new double[v16.length];
   private static long v20;
   private static double v21;
   private static final Quaternionf v22 = new Quaternionf();
   private static final Quaternionf v24 = new Quaternionf();
   private static final Matrix4f v25 = new Matrix4f();
   private static final Matrix4f v26 = new Matrix4f();
   private static boolean v27;
   public static boolean v13;

   private uiSupport175() {
   }

   public static void v1(class_4184 var0) {
      v22.set(var0.method_23767());
      v27 = true;
      v9 = 0.0F;
      v10 = 0.0F;
      v13 = false;
   }

   public static boolean v1() {
      if (cloudSupport69.v1()) {
         return false;
      } else {
         Matrix4f var0 = accountSupport22.v3();
         if (var0 != null && v27) {
            v4();
            v22.conjugate(v24);
            v25.rotation(v24);
            v26.set(var0).mul(v25).invert();
            GpuTextureView var1 = v3;
            int var2 = uiSupport169.v1("gpu.world.sky");

            try {
               if (var1 != null) {
                  v26.rotateLocalY((float)(-(Math.toRadians(v6) + v21)));
                  float var3 = (float)Math.pow(v11 * v2(), 0.45454545454545453);
                  v2 = v1(v5, var3);
                  v13 = renderSupport45.v1(var1, v26, var3);
               } else {
                  v2 = -12366499;
                  v13 = renderSupport45.v1(v26, (float)v17[0], (float)v17[1], (float)v17[2], (float)v17[3], v11);
               }
            } finally {
               uiSupport169.v1(var2);
            }

            return v13;
         } else {
            return false;
         }
      }
   }

   public static float v2() {
      if (!v8) {
         return 1.0F;
      } else {
         float var0 = Math.clamp((float)Math.cos(v9) * 2.0F + 0.5F, 0.0F, 1.0F);
         float var1 = 0.18F + 0.82F * var0;
         return var1 * (1.0F - 0.45F * Math.clamp(v10, 0.0F, 1.0F));
      }
   }

   public static int v1(int var0, float var1) {
      int var2 = Math.min(255, Math.round((var0 >> 16 & 0xFF) * var1));
      int var3 = Math.min(255, Math.round((var0 >> 8 & 0xFF) * var1));
      int var4 = Math.min(255, Math.round((var0 & 0xFF) * var1));
      return 0xFF000000 | var2 << 16 | var3 << 8 | var4;
   }

   private static void v4() {
      long var0 = System.nanoTime();
      double var2 = v20 == 0L ? 0.0 : Math.min((var0 - v20) / 1.0E9, 0.1);
      v20 = var0;
      double var4 = var2 * v12;

      for (int var6 = 0; var6 < v17.length; var6++) {
         v17[var6] = (v17[var6] + var4 * v16[var6]) % (Math.PI * 2);
      }

      v21 = ((v21 + var2 * Math.toRadians(v7)) % (Math.PI * 2) + (Math.PI * 2)) % (Math.PI * 2);
   }

   public static void v3() {
      v20 = 0L;
      v27 = false;
      v13 = false;
      v2 = -12366499;
   }
}
