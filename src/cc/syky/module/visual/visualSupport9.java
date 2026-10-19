package cc.syky.module.visual;

import cc.syky.cloud.cloudSupport22;
import cc.syky.cloud.cloudSupport69;
import cc.syky.internal.InternalSupport36;
import cc.syky.render.renderRecord;
import cc.syky.render.renderSupport10;
import cc.syky.render.renderSupport12;
import cc.syky.render.renderSupport13;
import cc.syky.render.renderSupport15;
import cc.syky.render.renderSupport3;
import cc.syky.render.renderSupport38;
import cc.syky.render.renderSupport7;
import cc.syky.render.renderSupport9;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_10366;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4588;
import net.minecraft.class_4608;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Vector3f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class visualSupport9 {
   private static final Logger v9 = LoggerFactory.getLogger("syky.render3d");
   @Nullable
   private static renderSupport13 v10;
   private static boolean v11;
   private static boolean v12;
   private static final Matrix4f v13 = new Matrix4f();
   private static boolean v14;
   private static long v15;
   private static final float v16 = 1.428148F;
   private static float v18 = 1.428148F;
   private static final Matrix4f v19 = new Matrix4f();
   private static boolean v17;
   private static final double v20 = 0.5;
   private static final double v21 = 4.0;
   public static long v1;
   public static long v2;
   public static long v3;
   public static long v4;
   public static boolean v5 = true;
   public static boolean v6;
   public static final float v7 = 0.015F;
   public static final double v8 = 0.001;
   private static final float v22 = 0.7F;
   private static final float v24 = 0.002F;
   private static final Vector3f v25 = new Vector3f(1.0F, 0.0F, 0.0F);
   private static final Vector3f v26 = new Vector3f(0.0F, 1.0F, 0.0F);
   private static final Matrix4f v27 = new Matrix4f();
   private static boolean v28;
   private static boolean v29;
   private static boolean v30;
   private static final List<visualSupport9.Part1> v32 = new CopyOnWriteArrayList<>();
   private static final Vector3f v23 = new Vector3f();

   public static void v1(Matrix4f var0) {
      v13.set(var0);
      v14 = true;
   }

   public static void v1() {
      v14 = false;
      v17 = false;
      v15++;
   }

   public static long v2() {
      return v15;
   }

   @Nullable
   public static Matrix4f v3() {
      return v14 ? v13 : null;
   }

   public static void v2(Matrix4f var0) {
      float var1 = Math.abs(var0.m11());
      if (Float.isFinite(var1) && var1 > 1.0E-4F) {
         v18 = var1;
      }

      v19.set(var0);
      v17 = true;
   }

   @Nullable
   public static Matrix4f v4() {
      return v17 ? v19 : null;
   }

   public static boolean v1(double var0, double var2, double var4, double var6, double var8, double var10) {
      renderSupport13 var12 = v10;
      if (var12 != null && v5) {
         if (!var12.v27()) {
            v4++;
         }

         v1++;
         if (var12.v1(var0, var2, var4, var6, var8, var10, 0.5, 4.0)) {
            v2++;
            return false;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public static boolean v2(double var0, double var2, double var4, double var6, double var8, double var10) {
      renderSupport13 var12 = v10;
      if (var12 != null && v5) {
         v1++;
         if (var12.v2(var0, var2, var4, var6, var8, var10, 0.5, 4.0)) {
            v2++;
            return false;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public static float v5() {
      return v18;
   }

   private visualSupport9() {
   }

   public static void v1(renderSupport13 var0) {
      v10 = var0;
      v28 = false;
   }

   public static void v6() {
      v10 = null;
   }

   public static double v7() {
      renderSupport13 var0 = v10;
      return var0 == null ? 0.0 : var0.v28();
   }

   public static double v8() {
      renderSupport13 var0 = v10;
      return var0 == null ? 0.0 : var0.v29();
   }

   public static double v9() {
      renderSupport13 var0 = v10;
      return var0 == null ? 0.0 : var0.v30();
   }

   public static Vector3f v10() {
      renderSupport13 var0 = v10;
      return var0 == null ? v25 : var0.v23();
   }

   public static Vector3f v11() {
      renderSupport13 var0 = v10;
      return var0 == null ? v26 : var0.v33();
   }

   public static Matrix4f v12() {
      renderSupport13 var0 = v10;
      return var0 == null ? v27 : var0.v32();
   }

   public static void v1(
      Matrix4f var0, Matrix4f var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, double var10, float var12
   ) {
      renderSupport13 var13 = v10;
      if (var13 != null) {
         var13.v22()
            .v1(
               var0,
               var1,
               var13.v28(),
               var13.v29(),
               var13.v30(),
               var2,
               var3,
               var4,
               var5,
               var6,
               var7,
               var8,
               var9,
               var10,
               var12,
               v4(var13),
               v1(var13, v4(var13)),
               null,
               null
            );
         Matrix4f var14 = v1(var13, var1);
         if (var14 != null) {
            var13.v22()
               .v1(
                  var0,
                  var14,
                  var13.v28(),
                  var13.v29(),
                  var13.v30(),
                  var2,
                  var3,
                  var4,
                  var5,
                  var6,
                  var7,
                  var8,
                  var9,
                  var10,
                  var12,
                  null,
                  var13.v14().v3(),
                  var13.v8().v2(),
                  var13.v8().v3()
               );
         }
      }
   }

   @Nullable
   private static Matrix4f v1(renderSupport13 var0, Matrix4f var1) {
      if (!var0.v8().v1()) {
         return null;
      } else {
         float var2 = var0.v1(var0.v28(), var0.v29(), var0.v30());
         return !Float.isNaN(var2) && var0.v8().v1(var0.v10())
            ? var0.v9().set(var1).translate(0.0F, 2.0F * (float)(var2 - var0.v29()), 0.0F).scale(1.0F, -1.0F, 1.0F)
            : null;
      }
   }

   public static void v1(visualSupport8 var0, Matrix4f var1, Matrix4f var2, renderSupport3 var3) {
      renderSupport13 var4 = v10;
      if (var4 != null) {
         GpuTextureView var5 = v4(var4);
         var4.v1(var0).v1(var1, var2, var4.v28(), var4.v29(), var4.v30(), var3, var5, v1(var4, var5), null, null);
         Matrix4f var6 = v1(var4, var2);
         if (var6 != null) {
            var4.v1(var0).v1(var1, var6, var4.v28(), var4.v29(), var4.v30(), var3, null, var4.v14().v3(), var4.v8().v2(), var4.v8().v3());
         }
      }
   }

   public static void v1(Matrix4f var0, Matrix4f var1, cloudSupport22 var2) {
      renderSupport13 var3 = v10;
      if (var3 != null && var2.v2() > 0) {
         GpuTextureView var4 = v4(var3);
         var3.v24().v1(var0, var1, var3.v28(), var3.v29(), var3.v30(), var2, var4, v1(var3, var4));
      }
   }

   public static void v1(Matrix4f var0, Matrix4f var1, renderSupport7 var2) {
      renderSupport13 var3 = v10;
      if (var3 != null && var2.v2() > 0) {
         GpuTextureView var4 = v4(var3);
         var3.v25().v1(var0, var1, var3.v28(), var3.v29(), var3.v30(), var2, var4, v1(var3, var4));
      }
   }

   public static float v1(double var0, double var2, double var4) {
      renderSupport13 var6 = v10;
      return var6 == null ? Float.NaN : var6.v1(var0, var2, var4);
   }

   public static void v1(WorldRenderContext var0) {
      v11 = cloudSupport69.v1();
      renderSupport13 var1 = v10;
      if (var1 != null) {
         var1.v5().v5();
         var1.v12().v20();
         var1.v6().v5();
         var1.v7().v20();
         var1.v8().v1(v12 && !v11);
         var1.v11();
         var1.v13();

         try {
            var1.v14().v1();
         } catch (Throwable var3) {
            v9.warn("translucent cover reset failed", var3);
         }

         var1.v1(var0);
         v3++;
         v2(var1);
      }
   }

   private static void v2(renderSupport13 var0) {
      if (!v28 && var0.v27()) {
         v28 = true;
         double var1 = var0.v28();
         double var3 = var0.v29();
         double var5 = var0.v30();

         try {
            v1(var1, var3, var5, 0.0F, 1.0F, 0.0F, 0);
            v1(var1, var3, var5, var1, var3, var5, var1, var3, var5, 0);
         } catch (Throwable var8) {
            v9.warn("world render warm-up failed; the first effect of the session will pay for itself", var8);
         }
      }
   }

   public static void v1(boolean var0) {
      v12 = var0;
   }

   @Nullable
   public static GpuTextureView v13() {
      renderSupport13 var0 = v10;
      return var0 == null ? null : var0.v8().v4();
   }

   public static boolean v14() {
      return v11;
   }

   public static void v1(boolean var0, boolean var1, boolean var2, boolean var3) {
      renderSupport13 var4 = v10;
      if (var4 != null) {
         renderSupport12 var5 = var4.v12();
         renderSupport15 var6 = var4.v5();
         if (v11) {
            var5.v17();
         } else {
            boolean var7 = !var5.v5();
            boolean var8 = !var6.v8();
            if (var7) {
               if (!v29) {
                  v29 = true;
                  v9.info("in-place shape drain active at the translucent seam");
               }

               v1("shape colour", var5::v10);
               v3(var4);
            } else {
               var5.v17();
            }

            if (var8) {
               v1("sprite colour", var6::v4);
            }

            boolean var9 = var0 || !var6.v7() || !var5.v5() || !var5.v7() || !v26();
            class_276 var10 = var4.v10();
            class_276 var11 = var4.v20();
            boolean var12 = renderSupport10.v3 && (var9 || var1 || var2) && var4.v21();
            boolean var13 = var9 || var3;

            try {
               if (var13) {
                  var4.v15();
               }
            } finally {
               if (var7) {
                  v1("shape depth seal", var5::v12);
                  v1(var4, "stroke depth seal", var5::v13);
               }
            }

            if (var12) {
               var4.v14().v1(var10, var11, !var13 && var1);
            }
         }
      }
   }

   public static void v15() {
      renderSupport13 var0 = v10;
      if (var0 != null && !v11) {
         var0.v16();
      }
   }

   @Nullable
   public static GpuTextureView v16() {
      renderSupport13 var0 = v10;
      return var0 != null && !v11 ? var0.v18() : null;
   }

   @Nullable
   public static GpuTextureView v18() {
      renderSupport13 var0 = v10;
      return var0 == null ? null : v4(var0);
   }

   public static void v19() {
      renderSupport13 var0 = v10;
      if (var0 != null) {
         if (v11) {
            var0.v14().v1(null);
         } else {
            var0.v14().v1(var0.v10(), var0.v17());
         }
      }
   }

   @Nullable
   public static renderSupport10.Part3 v17() {
      renderSupport13 var0 = v10;
      return var0 != null && !v11 ? var0.v14().v1(var0.v10()) : null;
   }

   public static boolean v20() {
      renderSupport13 var0 = v10;
      return var0 != null && !v11 && var0.v14().v2() != null;
   }

   public static void v21() {
      renderSupport13 var0 = v10;
      if (var0 != null) {
         var0.v14().v1(null);
      }
   }

   @Nullable
   public static renderSupport10.Part4 v22() {
      renderSupport13 var0 = v10;
      if (var0 == null) {
         return null;
      } else {
         renderSupport10.Part4 var1 = var0.v14().v2();
         return var1 != null ? var1 : var0.v14().v3();
      }
   }

   private static void v1(String var0, Runnable var1) {
      Matrix4fStack var2 = RenderSystem.getModelViewStack();
      var2.pushMatrix();

      try {
         var2.identity();
         var1.run();
      } catch (Throwable var7) {
         v9.warn("{} failed at the translucent seam", var0, var7);
      } finally {
         var2.popMatrix();
      }
   }

   private static void v3(renderSupport13 var0) {
      v1(var0, "outline", var0.v12()::v11);
   }

   private static void v1(renderSupport13 var0, String var1, Runnable var2) {
      Matrix4fStack var3 = RenderSystem.getModelViewStack();
      var3.pushMatrix();

      try {
         var3.set(var0.v32());
         var2.run();
      } catch (Throwable var8) {
         v9.warn("{} drain failed", var1, var8);
      } finally {
         var3.popMatrix();
      }
   }

   public static renderRecord v24() {
      renderSupport13 var0 = v10;
      return var0 == null ? new renderRecord(0L, 0L) : var0.v19();
   }

   private static renderSupport10.Part4 v1(renderSupport13 var0, @Nullable GpuTextureView var1) {
      renderSupport10.Part4 var2 = var0.v14().v2();
      return var2 != null && var1 != null ? var2 : var0.v14().v3();
   }

   @Nullable
   private static GpuTextureView v4(renderSupport13 var0) {
      return v11 ? null : var0.v17();
   }

   public static void v3(@Nullable Matrix4f var0) {
      renderSupport13 var1 = v10;
      if (var1 != null && (!var1.v5().v7() || !var1.v12().v5() || !var1.v12().v7() || !v26())) {
         var1.v12().v17();
         GpuTextureView var2 = v4(var1);
         if (!v30) {
            v30 = true;
            v9.info(
               "late world drain active: {} billboard batch(es), shapes={}, solid-depth copy={}", new Object[]{var1.v5().v2(), !var1.v12().v5(), var2 != null}
            );
         }

         GpuBufferSlice var3 = RenderSystem.getProjectionMatrixBuffer();
         class_10366 var4 = RenderSystem.getProjectionType();
         GpuBufferSlice var5 = RenderSystem.getShaderFog();
         GpuTextureView var6 = renderSupport38.v2();
         boolean var7 = false;

         try {
            if (var0 != null) {
               RenderSystem.setProjectionMatrix(var1.v3().method_71123(var0), class_10366.field_54953);
               var7 = true;
            }

            if (v11) {
               RenderSystem.setShaderFog(var1.v4());
            }

            if (var2 != null) {
               renderSupport38.v2(var2);
            }

            v6(var1);
            v5(var1);
         } finally {
            renderSupport38.v2(var6);
            if (v11) {
               RenderSystem.setShaderFog(var5);
            }

            if (var7) {
               RenderSystem.setProjectionMatrix(var3, var4);
            }
         }
      }
   }

   private static void v5(renderSupport13 var0) {
      if (!var0.v6().v7() || !var0.v7().v7()) {
         if (!var0.v8().v1(var0.v10())) {
            var0.v6().v5();
            var0.v7().v20();
         } else {
            GpuTextureView var1 = renderSupport38.v1();
            GpuTextureView var2 = renderSupport38.v2();
            Matrix4fStack var3 = RenderSystem.getModelViewStack();
            var3.pushMatrix();

            try {
               renderSupport38.v1(var0.v8().v2());
               renderSupport38.v2(var0.v8().v3());
               var3.identity();
               var0.v14().v1(null);
               var0.v7().v16();
               var0.v6().v3();
            } catch (Throwable var8) {
               v9.warn("mirror drain failed", var8);
            } finally {
               var0.v14().v1(var0.v14().v2());
               renderSupport38.v1(var1);
               renderSupport38.v2(var2);
               var3.popMatrix();
            }
         }
      }
   }

   public static void v1(visualSupport9.Part1 var0) {
      v32.add(var0);
   }

   private static boolean v26() {
      for (visualSupport9.Part1 var1 : v32) {
         if (!var1.v2()) {
            return false;
         }
      }

      return true;
   }

   public static void v4(@Nullable Matrix4f var0) {
      renderSupport13 var1 = v10;
      if (var1 != null && !var1.v12().v8()) {
         GpuBufferSlice var2 = RenderSystem.getProjectionMatrixBuffer();
         class_10366 var3 = RenderSystem.getProjectionType();
         boolean var4 = false;
         Matrix4fStack var5 = RenderSystem.getModelViewStack();
         var5.pushMatrix();

         try {
            var5.identity();
            if (var0 != null) {
               RenderSystem.setProjectionMatrix(var1.v3().method_71123(var0), class_10366.field_54953);
               var4 = true;
            }

            var1.v12().v14();
            if (!var1.v12().v9()) {
               var5.set(var1.v32());
               var1.v12().v15();
            }
         } catch (Throwable var10) {
            v9.warn("through-walls shape drain failed", var10);
         } finally {
            if (var4) {
               RenderSystem.setProjectionMatrix(var2, var3);
            }

            var5.popMatrix();
         }
      }
   }

   public static void v25() {
      renderSupport13 var0 = v10;
      if (var0 != null) {
         var0.v26();
      }
   }

   public static void v1(class_243 var0, class_243 var1, int var2, int var3, float var4, renderSupport9 var5) {
      v1(var0.field_1352, var0.field_1351, var0.field_1350, var1.field_1352, var1.field_1351, var1.field_1350, var2, var3, var4, var5);
   }

   public static void v1(double var0, double var2, double var4, double var6, double var8, double var10, int var12, int var13, float var14, renderSupport9 var15) {
      renderSupport13 var16 = v10;
      if (var16 != null && var16.v27()) {
         class_4588 var17 = var16.v1(var15);
         if (var17 != null) {
            Matrix4f var18 = var16.v32();
            float var19 = (float)(var0 - var16.v28());
            float var20 = (float)(var2 - var16.v29());
            float var21 = (float)(var4 - var16.v30());
            float var22 = (float)(var6 - var16.v28());
            float var23 = (float)(var8 - var16.v29());
            float var24 = (float)(var10 - var16.v30());
            float var25 = var22 - var19;
            float var26 = var23 - var20;
            float var27 = var24 - var21;
            float var28 = (float)Math.sqrt(var25 * var25 + var26 * var26 + var27 * var27);
            if (!(var28 < 1.0E-6F)) {
               float var29 = var25 / var28;
               float var30 = var26 / var28;
               float var31 = var27 / var28;
               var17.method_22918(var18, var19, var20, var21).method_39415(var12).method_22914(var29, var30, var31).method_75298(var14);
               var17.method_22918(var18, var22, var23, var24).method_39415(var13).method_22914(var29, var30, var31).method_75298(var14);
            }
         }
      }
   }

   public static void v1(class_238 var0, int var1, float var2) {
      renderSupport13 var3 = v10;
      if (var3 != null && var3.v27()) {
         float var4 = var2 * 0.015F;
         if (!(var4 <= 0.0F) && var1 >>> 24 != 0) {
            double var5 = var0.field_1323;
            double var7 = var0.field_1320;
            double var9 = var0.field_1322;
            double var11 = var0.field_1325;
            double var13 = var0.field_1321;
            double var15 = var0.field_1324;
            double var17 = (var5 + var7) * 0.5;
            double var19 = (var9 + var11) * 0.5;
            double var21 = (var13 + var15) * 0.5;
            float var23 = (float)(var7 - var5) * 0.5F;
            float var24 = (float)(var11 - var9) * 0.5F;
            float var25 = (float)(var15 - var13) * 0.5F;
            v1(var3, var5, var9, var13, var7, var9, var13, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var5, var11, var13, var7, var11, var13, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var5, var9, var15, var7, var9, var15, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var5, var11, var15, var7, var11, var15, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var5, var9, var13, var5, var11, var13, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var7, var9, var13, var7, var11, var13, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var5, var9, var15, var5, var11, var15, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var7, var9, var15, var7, var11, var15, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var5, var9, var13, var5, var9, var15, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var7, var9, var13, var7, var9, var15, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var5, var11, var13, var5, var11, var15, var17, var19, var21, var4, var23, var24, var25, var1);
            v1(var3, var7, var11, var13, var7, var11, var15, var17, var19, var21, var4, var23, var24, var25, var1);
         }
      }
   }

   private static void v1(
      renderSupport13 var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      float var19,
      float var20,
      float var21,
      float var22,
      int var23
   ) {
      float var24 = Math.max(
         var0.v1((float)(var1 - var0.v28()), (float)(var3 - var0.v29()), (float)(var5 - var0.v30())),
         var0.v1((float)(var7 - var0.v28()), (float)(var9 - var0.v29()), (float)(var11 - var0.v30()))
      );
      float var25 = Math.max(var19, 1.4F * var24);
      v1(
         var0,
         var1,
         var3,
         var5,
         var7,
         var9,
         var11,
         var13,
         var15,
         var17,
         Math.min(var25, var20),
         Math.min(var25, var21),
         Math.min(var25, var22),
         0.0F,
         var23,
         false,
         false,
         false
      );
   }

   public static void v1(long var0, Matrix4f var2, float var3, float var4, float var5, int var6) {
      Vector3f var7 = var2.transformPosition(var3, var4, var5, v23);
      visualSupport10.v1(var0, var7.x, var7.y, var7.z, var6);
   }

   public static void v1(class_238 var0, int var1) {
      renderSupport13 var2 = v10;
      if (var2 != null && var2.v27()) {
         class_4588 var3 = var2.v12().v1();
         Matrix4f var4 = var2.v32();
         float var5 = (float)(var0.field_1323 - var2.v28());
         float var6 = (float)(var0.field_1320 - var2.v28());
         float var7 = (float)(var0.field_1322 - var2.v29());
         float var8 = (float)(var0.field_1325 - var2.v29());
         float var9 = (float)(var0.field_1321 - var2.v30());
         float var10 = (float)(var0.field_1324 - var2.v30());
         boolean var11 = var5 <= 0.0F && var6 >= 0.0F && var7 <= 0.0F && var8 >= 0.0F && var9 <= 0.0F && var10 >= 0.0F;
         v1(var3, var4, var5, var6, var7, var8, var9, var10, var11 ? var1 : v1(var1), !var11);
      }
   }

   private static int v1(int var0) {
      float var1 = (var0 >>> 24 & 0xFF) / 255.0F;
      int var2 = Math.round((1.0F - (1.0F - var1) * (1.0F - var1)) * 255.0F);
      return var0 & 16777215 | var2 << 24;
   }

   public static void v1(List<class_238> var0, int var1, boolean var2) {
      renderSupport13 var3 = v10;
      if (var3 != null && var3.v27() && !var0.isEmpty()) {
         if (var2) {
            v1(var3.v12().v3(), var3, var0, var1, 0.0F, false);
         } else {
            v1(var3.v12().v2(), var3, var0, var1, 0.0F, true);
         }
      }
   }

   public static void v1(List<class_238> var0, int var1) {
      renderSupport13 var2 = v10;
      if (var2 != null && var2.v27() && !var0.isEmpty() && var1 >>> 24 != 0) {
         v1(var2.v12().v18(), var2, var0, var1, 0.0F, true);
      }
   }

   private static void v1(class_4588 var0, renderSupport13 var1, List<class_238> var2, int var3, float var4, boolean var5) {
      Matrix4f var6 = var1.v32();
      double var7 = var1.v28();
      double var9 = var1.v29();
      double var11 = var1.v30();

      for (int var13 = 0; var13 < var2.size(); var13++) {
         class_238 var14 = (class_238)var2.get(var13);
         float var15 = (float)(var14.field_1323 - var7);
         float var16 = (float)(var14.field_1320 - var7);
         float var17 = (float)(var14.field_1322 - var9);
         float var18 = (float)(var14.field_1325 - var9);
         float var19 = (float)(var14.field_1321 - var11);
         float var20 = (float)(var14.field_1324 - var11);
         if ((!var5 || var15 > 0.0F) && !v1(var2, var14, 0, false)) {
            float var21 = var15 - var4;
            v1(var0, var6, var21, var17, var19, var21, var17, var20, var21, var18, var20, var21, var18, var19, var3);
         }

         if ((!var5 || var16 < 0.0F) && !v1(var2, var14, 0, true)) {
            float var22 = var16 + var4;
            v1(var0, var6, var22, var17, var19, var22, var18, var19, var22, var18, var20, var22, var17, var20, var3);
         }

         if ((!var5 || var17 > 0.0F) && !v1(var2, var14, 1, false)) {
            float var23 = var17 - var4;
            v1(var0, var6, var15, var23, var19, var16, var23, var19, var16, var23, var20, var15, var23, var20, var3);
         }

         if ((!var5 || var18 < 0.0F) && !v1(var2, var14, 1, true)) {
            float var24 = var18 + var4;
            v1(var0, var6, var15, var24, var19, var15, var24, var20, var16, var24, var20, var16, var24, var19, var3);
         }

         if ((!var5 || var19 > 0.0F) && !v1(var2, var14, 2, false)) {
            float var25 = var19 - var4;
            v1(var0, var6, var15, var17, var25, var15, var18, var25, var16, var18, var25, var16, var17, var25, var3);
         }

         if ((!var5 || var20 < 0.0F) && !v1(var2, var14, 2, true)) {
            float var26 = var20 + var4;
            v1(var0, var6, var15, var17, var26, var16, var17, var26, var16, var18, var26, var15, var18, var26, var3);
         }
      }
   }

   public static void v1(int var0, boolean var1, double var2, double var4, double var6, double var8, double var10, int var12) {
      v1(var0, var1, var2, var4, var6, var8, var10, var12, false);
   }

   public static void v1(int var0, boolean var1, double var2, double var4, double var6, double var8, double var10, int var12, boolean var13) {
      renderSupport13 var14 = v10;
      if (var14 != null && var14.v27() && var12 >>> 24 != 0) {
         v1(var13 ? var14.v12().v3() : var14.v12().v2(), var14, var0, var1, var2, var4, var6, var8, var10, var12, 0.0F);
      }
   }

   public static void v2(int var0, boolean var1, double var2, double var4, double var6, double var8, double var10, int var12) {
      renderSupport13 var13 = v10;
      if (var13 != null && var13.v27() && var12 >>> 24 != 0) {
         v1(var13.v12().v18(), var13, var0, var1, var2, var4, var6, var8, var10, var12, 0.0F);
      }
   }

   private static void v1(
      class_4588 var0, renderSupport13 var1, int var2, boolean var3, double var4, double var6, double var8, double var10, double var12, int var14, float var15
   ) {
      double var16 = var2 == 0 ? var1.v28() : (var2 == 1 ? var1.v29() : var1.v30());
      if (var3 ? !(var16 <= var4) : !(var16 >= var4)) {
         Matrix4f var18 = var1.v32();
         float var19 = (float)(var4 - var16) + (var3 ? var15 : -var15);
         switch (var2) {
            case 0:
               float var25 = (float)(var6 - var1.v29());
               float var27 = (float)(var8 - var1.v29());
               float var29 = (float)(var10 - var1.v30());
               float var31 = (float)(var12 - var1.v30());
               v1(var0, var18, var19, var25, var29, var19, var27, var29, var19, var27, var31, var19, var25, var31, var14);
               break;
            case 1:
               float var24 = (float)(var6 - var1.v28());
               float var26 = (float)(var8 - var1.v28());
               float var28 = (float)(var10 - var1.v30());
               float var30 = (float)(var12 - var1.v30());
               v1(var0, var18, var24, var19, var28, var24, var19, var30, var26, var19, var30, var26, var19, var28, var14);
               break;
            default:
               float var20 = (float)(var6 - var1.v28());
               float var21 = (float)(var8 - var1.v28());
               float var22 = (float)(var10 - var1.v29());
               float var23 = (float)(var12 - var1.v29());
               v1(var0, var18, var20, var22, var19, var21, var22, var19, var21, var23, var19, var20, var23, var19, var14);
         }
      }
   }

   public static void v1(InternalSupport36 var0, int var1, int var2, float var3, double var4, double var6) {
      v1(var0, var1, var2, var3, var4, var6, 0, 0.0F);
   }

   public static void v1(InternalSupport36 var0, int var1, int var2, float var3, double var4, double var6, int var8, float var9) {
      renderSupport13 var10 = v10;
      if (var10 != null && var10.v27()) {
         var10.v12().v6().v1(var10, var0, var1, var2, var3 * 0.015F, (float)(1.0 - var4), var6, var8, var9);
      }
   }

   private static boolean v1(List<class_238> var0, class_238 var1, int var2, boolean var3) {
      double var4 = 1.0E-4;

      for (int var6 = 0; var6 < var0.size(); var6++) {
         class_238 var7 = (class_238)var0.get(var6);
         if (var7 != var1) {
            boolean var8;
            boolean var9;
            if (var2 == 0) {
               var8 = Math.abs(var3 ? var7.field_1323 - var1.field_1320 : var7.field_1320 - var1.field_1323) < var4;
               var9 = var7.field_1322 <= var1.field_1322 + var4
                  && var7.field_1325 >= var1.field_1325 - var4
                  && var7.field_1321 <= var1.field_1321 + var4
                  && var7.field_1324 >= var1.field_1324 - var4;
            } else if (var2 == 1) {
               var8 = Math.abs(var3 ? var7.field_1322 - var1.field_1325 : var7.field_1325 - var1.field_1322) < var4;
               var9 = var7.field_1323 <= var1.field_1323 + var4
                  && var7.field_1320 >= var1.field_1320 - var4
                  && var7.field_1321 <= var1.field_1321 + var4
                  && var7.field_1324 >= var1.field_1324 - var4;
            } else {
               var8 = Math.abs(var3 ? var7.field_1321 - var1.field_1324 : var7.field_1324 - var1.field_1321) < var4;
               var9 = var7.field_1323 <= var1.field_1323 + var4
                  && var7.field_1320 >= var1.field_1320 - var4
                  && var7.field_1322 <= var1.field_1322 + var4
                  && var7.field_1325 >= var1.field_1325 - var4;
            }

            if (var8 && var9) {
               return true;
            }
         }
      }

      return false;
   }

   public static void v1(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18) {
      renderSupport13 var19 = v10;
      if (var19 != null && var19.v27()) {
         v1(var19.v12().v19(), var19, var0, var2, var4, var6, var8, var10, var12, var14, var16, var18);
         if (var19.v8().v1()) {
            float var20 = var19.v1((var0 + var6 + var12) / 3.0, (var2 + var8 + var14) / 3.0, (var4 + var10 + var16) / 3.0);
            if (!Float.isNaN(var20)) {
               double var21 = 2.0 * var20;
               v1(var19.v7().v19(), var19, var0, var21 - var2, var4, var6, var21 - var8, var10, var12, var21 - var14, var16, var18);
            }
         }
      }
   }

   private static void v1(
      class_4588 var0,
      renderSupport13 var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      int var20
   ) {
      Matrix4f var21 = var1.v32();
      float var22 = (float)(var2 - var1.v28());
      float var23 = (float)(var4 - var1.v29());
      float var24 = (float)(var6 - var1.v30());
      float var25 = (float)(var8 - var1.v28());
      float var26 = (float)(var10 - var1.v29());
      float var27 = (float)(var12 - var1.v30());
      float var28 = (float)(var14 - var1.v28());
      float var29 = (float)(var16 - var1.v29());
      float var30 = (float)(var18 - var1.v30());
      v1(var0, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var28, var29, var30, var20);
   }

   public static void v1(
      double var0,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      int var24,
      int var25
   ) {
      renderSupport13 var26 = v10;
      if (var26 != null && var26.v27()) {
         v1(var26.v12().v19(), var26, var0, var2, var4, var6, var8, var10, var12, var14, var16, var18, var20, var22, var24, var25);
         if (var26.v8().v1()) {
            float var27 = var26.v1((var0 + var6 + var12 + var18) / 4.0, (var2 + var8 + var14 + var20) / 4.0, (var4 + var10 + var16 + var22) / 4.0);
            if (!Float.isNaN(var27)) {
               double var28 = 2.0 * var27;
               v1(
                  var26.v7().v19(),
                  var26,
                  var0,
                  var28 - var2,
                  var4,
                  var6,
                  var28 - var8,
                  var10,
                  var12,
                  var28 - var14,
                  var16,
                  var18,
                  var28 - var20,
                  var22,
                  var24,
                  var25
               );
            }
         }
      }
   }

   private static void v1(
      class_4588 var0,
      renderSupport13 var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      int var26,
      int var27
   ) {
      Matrix4f var28 = var1.v32();
      var0.method_22918(var28, (float)(var2 - var1.v28()), (float)(var4 - var1.v29()), (float)(var6 - var1.v30())).method_39415(var26);
      var0.method_22918(var28, (float)(var8 - var1.v28()), (float)(var10 - var1.v29()), (float)(var12 - var1.v30())).method_39415(var26);
      var0.method_22918(var28, (float)(var14 - var1.v28()), (float)(var16 - var1.v29()), (float)(var18 - var1.v30())).method_39415(var27);
      var0.method_22918(var28, (float)(var20 - var1.v28()), (float)(var22 - var1.v29()), (float)(var24 - var1.v30())).method_39415(var27);
   }

   private static void v1(class_4588 var0, Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, boolean var9) {
      if (!var9 || var4 > 0.0F) {
         v1(var0, var1, var2, var4, var6, var3, var4, var6, var3, var4, var7, var2, var4, var7, var8);
      }

      if (!var9 || var5 < 0.0F) {
         v1(var0, var1, var2, var5, var6, var2, var5, var7, var3, var5, var7, var3, var5, var6, var8);
      }

      if (!var9 || var6 > 0.0F) {
         v1(var0, var1, var2, var4, var6, var2, var5, var6, var3, var5, var6, var3, var4, var6, var8);
      }

      if (!var9 || var7 < 0.0F) {
         v1(var0, var1, var2, var4, var7, var3, var4, var7, var3, var5, var7, var2, var5, var7, var8);
      }

      if (!var9 || var2 > 0.0F) {
         v1(var0, var1, var2, var4, var6, var2, var4, var7, var2, var5, var7, var2, var5, var6, var8);
      }

      if (!var9 || var3 < 0.0F) {
         v1(var0, var1, var3, var4, var6, var3, var5, var6, var3, var5, var7, var3, var4, var7, var8);
      }
   }

   public static void v1(
      double var0,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      int var18,
      float var19,
      boolean var20
   ) {
      v1(var0, var2, var4, var6, var8, var10, var12, var14, var16, var18, var19, var20, false, false);
   }

   public static void v1(
      double var0,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      int var18,
      float var19,
      boolean var20,
      boolean var21,
      boolean var22
   ) {
      renderSupport13 var23 = v10;
      if (var23 != null && var23.v27()) {
         float var24 = var19 * 0.015F;
         if (!(var24 <= 0.0F) && var18 >>> 24 != 0) {
            v1(var23, var0, var2, var4, var6, var8, var10, var12, var14, var16, var24, var24, var24, 0.002F, var18, var20, var21, var22);
         }
      }
   }

   private static void v1(
      renderSupport13 var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      float var19,
      float var20,
      float var21,
      float var22,
      int var23,
      boolean var24,
      boolean var25,
      boolean var26
   ) {
      float var27 = (float)(var1 - var0.v28());
      float var28 = (float)(var7 - var0.v28());
      float var29 = (float)(var3 - var0.v29());
      float var30 = (float)(var9 - var0.v29());
      float var31 = (float)(var5 - var0.v30());
      float var32 = (float)(var11 - var0.v30());
      float var33 = (float)(var13 - var0.v28());
      float var34 = (float)(var15 - var0.v29());
      float var35 = (float)(var17 - var0.v30());
      float var36 = v1(var27, var28, var33, var19, var22);
      float var37 = v2(var27, var28, var33, var19, var22);
      float var38 = v1(var29, var30, var34, var20, var22);
      float var39 = v2(var29, var30, var34, var20, var22);
      float var40 = v1(var31, var32, var35, var21, var22);
      float var41 = v2(var31, var32, var35, var21, var22);
      float var42 = Math.abs(var27 - var28);
      float var43 = Math.abs(var29 - var30);
      float var44 = Math.abs(var31 - var32);
      byte var45;
      if (var42 >= var43 && var42 >= var44) {
         var45 = 0;
      } else if (var43 >= var44) {
         var45 = 1;
      } else {
         var45 = 2;
      }

      float var46 = (var45 == 0 ? Math.max(var20, var21) : (var45 == 1 ? Math.max(var21, var19) : Math.max(var19, var20))) - var22;
      float var47 = var25 ? var46 : var22;
      float var48 = var26 ? var46 : var22;
      if (var45 == 0) {
         var36 -= var47;
         var37 += var48;
      } else if (var45 == 1) {
         var38 -= var47;
         var39 += var48;
      } else {
         var40 -= var47;
         var41 += var48;
      }

      float var49 = (var36 + var37) * 0.5F;
      float var50 = (var38 + var39) * 0.5F;
      float var51 = (var40 + var41) * 0.5F;
      float var52 = (var37 - var36) * 0.5F;
      float var53 = (var39 - var38) * 0.5F;
      float var54 = (var41 - var40) * 0.5F;
      renderSupport12 var55 = var0.v12();
      class_4588 var56 = var24 ? var55.v3(var23) : var55.v2(var23);
      class_4588 var57 = var24 ? null : var55.v4();
      if (var45 == 0) {
         if (var53 <= 0.0F || var54 <= 0.0F || var37 - var36 <= 0.0F) {
            return;
         }

         visualSupport11.v1(var0, var56, var57, 0, var36, var50, var51, var37, var50, var51, var53, var54, var23);
      } else if (var45 == 1) {
         if (var54 <= 0.0F || var52 <= 0.0F || var39 - var38 <= 0.0F) {
            return;
         }

         visualSupport11.v1(var0, var56, var57, 1, var49, var38, var51, var49, var39, var51, var54, var52, var23);
      } else {
         if (var52 <= 0.0F || var53 <= 0.0F || var41 - var40 <= 0.0F) {
            return;
         }

         visualSupport11.v1(var0, var56, var57, 2, var49, var50, var40, var49, var50, var41, var52, var53, var23);
      }
   }

   private static float v1(float var0, float var1, float var2, float var3, float var4) {
      if (Math.abs(var0 - var1) > 1.0E-5F) {
         return Math.min(var0, var1);
      } else if (var0 > var2) {
         return var0 - var3 + var4;
      } else {
         return var0 < var2 ? var0 - var4 : var0 - var3 * 0.5F;
      }
   }

   private static float v2(float var0, float var1, float var2, float var3, float var4) {
      if (Math.abs(var0 - var1) > 1.0E-5F) {
         return Math.max(var0, var1);
      } else if (var0 > var2) {
         return var0 + var4;
      } else {
         return var0 < var2 ? var0 + var3 - var4 : var0 + var3 * 0.5F;
      }
   }

   private static void v1(
      class_4588 var0,
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      int var14
   ) {
      long var15 = visualSupport10.v1(var0, class_290.field_1576, 4);
      if (var15 != 0L) {
         int var17 = visualSupport10.v1(var14);
         v1(var15, var1, var2, var3, var4, var17);
         v1(var15 + 16L, var1, var5, var6, var7, var17);
         v1(var15 + 32L, var1, var8, var9, var10, var17);
         v1(var15 + 48L, var1, var11, var12, var13, var17);
      } else {
         var0.method_22918(var1, var2, var3, var4).method_39415(var14);
         var0.method_22918(var1, var5, var6, var7).method_39415(var14);
         var0.method_22918(var1, var8, var9, var10).method_39415(var14);
         var0.method_22918(var1, var11, var12, var13).method_39415(var14);
      }
   }

   public static void v1(class_2960 var0, class_243 var1, float var2, float var3, int var4) {
      v1(var0, var1.field_1352, var1.field_1351, var1.field_1350, var2, var3, var4);
   }

   public static void v1(class_2960 var0, double var1, double var3, double var5, float var7, float var8, int var9) {
      renderSupport13 var10 = v10;
      if (var10 != null && var10.v27()) {
         v1(var10.v5().v1(var0, renderSupport9.SPRITE), var10, var1, var3, var5, var7, var8, var9, class_4608.field_21444);
      }
   }

   public static void v1(double var0, double var2, double var4, float var6, float var7, float var8, int var9) {
      renderSupport13 var10 = v10;
      if (var10 != null && var10.v27()) {
         v1(var10.v5().v1(), var10, var0, var2, var4, var6, var6, var9, v1(var7, var8));
         if (var10.v8().v1()) {
            float var11 = var10.v1(var0, var2, var4);
            if (!Float.isNaN(var11)) {
               v1(var10.v6().v1(), var10, var0, 2.0 * var11 - var2, var4, var6, var6, var9, v1(var7, var8));
            }
         }
      }
   }

   public static void v1(double var0, double var2, double var4, double var6, double var8, double var10, float var12, float var13, float var14, int var15) {
      renderSupport13 var16 = v10;
      if (var16 != null && var16.v27()) {
         float var17 = var12 * 0.5F;
         if (!(var17 <= 0.0F)) {
            float var18 = (float)(var0 - var16.v28());
            float var19 = (float)(var2 - var16.v29());
            float var20 = (float)(var4 - var16.v30());
            float var21 = (float)(var6 - var0);
            float var22 = (float)(var8 - var2);
            float var23 = (float)(var10 - var4);
            float var24 = (float)Math.sqrt(var21 * var21 + var22 * var22 + var23 * var23);
            if (var24 < 1.0E-5F) {
               v1(var0, var2, var4, var12, var13, var14, var15);
            } else {
               float var25 = 1.0F / var24;
               float var26 = var21 * var25;
               float var27 = var22 * var25;
               float var28 = var23 * var25;
               float var29 = var18 + var21 * 0.5F;
               float var30 = var19 + var22 * 0.5F;
               float var31 = var20 + var23 * 0.5F;
               float var32 = var27 * var31 - var28 * var30;
               float var33 = var28 * var29 - var26 * var31;
               float var34 = var26 * var30 - var27 * var29;
               float var35 = (float)Math.sqrt(var32 * var32 + var33 * var33 + var34 * var34);
               if (var35 < 1.0E-4F) {
                  Vector3f var36 = var16.v33();
                  var32 = var27 * var36.z - var28 * var36.y;
                  var33 = var28 * var36.x - var26 * var36.z;
                  var34 = var26 * var36.y - var27 * var36.x;
                  var35 = (float)Math.sqrt(var32 * var32 + var33 * var33 + var34 * var34);
               }

               if (var35 < 1.0E-4F) {
                  Vector3f var53 = var16.v23();
                  var32 = var53.x;
                  var33 = var53.y;
                  var34 = var53.z;
                  var35 = 1.0F;
               }

               float var54 = 1.0F / var35;
               var32 *= var54;
               var33 *= var54;
               var34 *= var54;
               float var37 = var27 * var34 - var28 * var33;
               float var38 = var28 * var32 - var26 * var34;
               float var39 = var26 * var33 - var27 * var32;
               float var40 = var24 * 0.5F + var17;
               float var41 = var26 * var40;
               float var42 = var27 * var40;
               float var43 = var28 * var40;
               var32 *= var17;
               var33 *= var17;
               var34 *= var17;
               float var44 = var40 / var17;
               float var45 = (1.0F - var44) * 0.5F;
               float var46 = (1.0F + var44) * 0.5F;
               v1(
                  var16.v5().v1(),
                  var16.v32(),
                  var29,
                  var30,
                  var31,
                  var41,
                  var42,
                  var43,
                  var32,
                  var33,
                  var34,
                  var37,
                  var38,
                  var39,
                  var45,
                  var46,
                  var15,
                  v1(var13, var14)
               );
            }
         }
      }
   }

   private static int v1(float var0, float var1) {
      return v1(var0) | v1(var1) << 16;
   }

   private static int v1(float var0) {
      return Math.round(Math.max(0.0F, Math.min(1.0F, var0)) * 32767.0F);
   }

   private static void v1(class_287 var0, renderSupport13 var1, double var2, double var4, double var6, float var8, float var9, int var10, int var11) {
      Matrix4f var12 = var1.v32();
      float var13 = (float)(var2 - var1.v28());
      float var14 = (float)(var4 - var1.v29());
      float var15 = (float)(var6 - var1.v30());
      Vector3f var16 = var1.v23();
      Vector3f var17 = var1.v33();
      float var18 = var8 * 0.5F;
      float var19 = var9 * 0.5F;
      float var20 = var16.x * var18;
      float var21 = var16.y * var18;
      float var22 = var16.z * var18;
      float var23 = var17.x * var19;
      float var24 = var17.y * var19;
      float var25 = var17.z * var19;
      float var26 = var13 - var20 + var23;
      float var27 = var14 - var21 + var24;
      float var28 = var15 - var22 + var25;
      float var29 = var13 + var20 + var23;
      float var30 = var14 + var21 + var24;
      float var31 = var15 + var22 + var25;
      float var32 = var13 + var20 - var23;
      float var33 = var14 + var21 - var24;
      float var34 = var15 + var22 - var25;
      float var35 = var13 - var20 - var23;
      float var36 = var14 - var21 - var24;
      float var37 = var15 - var22 - var25;
      int var38 = 15728880;
      float var39 = var17.y * var16.z - var17.z * var16.y;
      float var40 = var17.z * var16.x - var17.x * var16.z;
      float var41 = var17.x * var16.y - var17.y * var16.x;
      long var42 = visualSupport10.v1(var0, class_290.field_1580, 4);
      if (var42 != 0L) {
         int var44 = visualSupport10.v1(var10);
         short var45 = visualSupport10.v1(var39, var40);
         byte var46 = visualSupport10.v1(var41);
         long var47 = 36L;
         v1(var42, var12, var35, var36, var37, var44, 0.0F, 1.0F, var11, var38, var45, var46);
         v1(var42 + var47, var12, var32, var33, var34, var44, 1.0F, 1.0F, var11, var38, var45, var46);
         v1(var42 + 2L * var47, var12, var29, var30, var31, var44, 1.0F, 0.0F, var11, var38, var45, var46);
         v1(var42 + 3L * var47, var12, var26, var27, var28, var44, 0.0F, 0.0F, var11, var38, var45, var46);
      } else {
         v1(var0, var12, var35, var36, var37, var10, 0.0F, 1.0F, var11, var38, var39, var40, var41);
         v1(var0, var12, var32, var33, var34, var10, 1.0F, 1.0F, var11, var38, var39, var40, var41);
         v1(var0, var12, var29, var30, var31, var10, 1.0F, 0.0F, var11, var38, var39, var40, var41);
         v1(var0, var12, var26, var27, var28, var10, 0.0F, 0.0F, var11, var38, var39, var40, var41);
      }
   }

   private static void v1(
      class_287 var0,
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      int var16,
      int var17
   ) {
      int var18 = 15728880;
      long var19 = visualSupport10.v1(var0, class_290.field_1580, 4);
      if (var19 != 0L) {
         int var21 = visualSupport10.v1(var16);
         short var22 = visualSupport10.v1(var11, var12);
         byte var23 = visualSupport10.v1(var13);
         long var24 = 36L;
         v1(var19, var1, var2 - var5 - var8, var3 - var6 - var9, var4 - var7 - var10, var21, var14, 1.0F, var17, var18, var22, var23);
         v1(var19 + var24, var1, var2 + var5 - var8, var3 + var6 - var9, var4 + var7 - var10, var21, var15, 1.0F, var17, var18, var22, var23);
         v1(var19 + 2L * var24, var1, var2 + var5 + var8, var3 + var6 + var9, var4 + var7 + var10, var21, var15, 0.0F, var17, var18, var22, var23);
         v1(var19 + 3L * var24, var1, var2 - var5 + var8, var3 - var6 + var9, var4 - var7 + var10, var21, var14, 0.0F, var17, var18, var22, var23);
      } else {
         v1(var0, var1, var2 - var5 - var8, var3 - var6 - var9, var4 - var7 - var10, var16, var14, 1.0F, var17, var18, var11, var12, var13);
         v1(var0, var1, var2 + var5 - var8, var3 + var6 - var9, var4 + var7 - var10, var16, var15, 1.0F, var17, var18, var11, var12, var13);
         v1(var0, var1, var2 + var5 + var8, var3 + var6 + var9, var4 + var7 + var10, var16, var15, 0.0F, var17, var18, var11, var12, var13);
         v1(var0, var1, var2 - var5 + var8, var3 - var6 + var9, var4 - var7 + var10, var16, var14, 0.0F, var17, var18, var11, var12, var13);
      }
   }

   private static void v1(
      class_4588 var0,
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      int var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12
   ) {
      if (v6) {
         var0.method_22918(var1, var2, var3, var4)
            .method_39415(var5)
            .method_22913(var6, var7)
            .method_22922(var8)
            .method_60803(var9)
            .method_22914(var10, var11, var12);
      } else {
         Vector3f var13 = var1.transformPosition(var2, var3, var4, v23);
         var0.method_23919(var13.x, var13.y, var13.z, var5, var6, var7, var8, var9, var10, var11, var12);
      }
   }

   private static void v1(
      long var0, Matrix4f var2, float var3, float var4, float var5, int var6, float var7, float var8, int var9, int var10, short var11, byte var12
   ) {
      Vector3f var13 = var2.transformPosition(var3, var4, var5, v23);
      visualSupport10.v1(var0, var13.x, var13.y, var13.z, var6, var7, var8, var9, var10, var11, var12);
   }

   private static void v6(renderSupport13 var0) {
      renderSupport12 var1 = var0.v12();
      renderSupport15 var2 = var0.v5();
      Matrix4fStack var3 = RenderSystem.getModelViewStack();
      var3.pushMatrix();

      try {
         var3.identity();

         try {
            var1.v10();
         } catch (Throwable var16) {
            v9.warn("shape drain failed", var16);
         }

         v3(var0);

         try {
            var1.v16();
         } catch (Throwable var15) {
            v9.warn("additive shape drain failed", var15);
         }

         try {
            var2.v3();
         } catch (Throwable var14) {
            v9.warn("billboard drain failed", var14);
         }

         for (visualSupport9.Part1 var5 : v32) {
            if (!var5.v2()) {
               try {
                  var5.v3();
               } catch (Throwable var13) {
                  v9.warn("late drain failed", var13);
               }
            }
         }
      } finally {
         var3.popMatrix();
      }
   }

   public interface Part1 {
      boolean v2();

      void v3();
   }
}
