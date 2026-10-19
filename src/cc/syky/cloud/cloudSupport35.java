package cc.syky.cloud;

import cc.syky.mixin.accessor.GameRendererAccessor;
import cc.syky.mixin.accessor.HeldItemRendererInvoker;
import cc.syky.mixin.accessor.ProjectionMatrix3Accessor;
import cc.syky.module.visual.visualSupport51;
import cc.syky.render.COMPOSITESupport;
import cc.syky.render.renderSupport38;
import cc.syky.render.renderSupport45;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import java.nio.ByteBuffer;
import java.util.Arrays;
import net.minecraft.class_1007;
import net.minecraft.class_11659;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_5498;
import net.minecraft.class_759;
import net.minecraft.class_811;
import net.minecraft.class_9801;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_9801.class_4574;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport35 {
   private static final Logger v25 = LoggerFactory.getLogger("syky.handblur");
   private static boolean v26;
   private static final int v27 = 32;
   private static final float v28 = 1.0F;
   private static final long v29 = 500000000L;
   private static final int v30 = 64;
   private static final long v32 = 250000000L;
   private static final float v23 = (float)Math.toRadians(70.0);
   private static final float[][] v33 = new float[][]{
      {0.0F, 0.0F, 0.0F},
      {-0.5F, -0.5F, -0.5F},
      {0.5F, -0.5F, -0.5F},
      {-0.5F, 0.5F, -0.5F},
      {0.5F, 0.5F, -0.5F},
      {-0.5F, -0.5F, 0.5F},
      {0.5F, -0.5F, 0.5F},
      {-0.5F, 0.5F, 0.5F},
      {0.5F, 0.5F, 0.5F}
   };
   private static final int v31 = 0;
   private static final int v34 = 1;
   private static final int v36 = 2;
   private static final int v38 = 8;
   private static final cloudSupport35.Part1[] v42 = new cloudSupport35.Part1[8];
   private static final cloudSupport35.Part2[] v43 = new cloudSupport35.Part2[8];
   private static int v37;
   public static boolean v1;
   public static boolean v2;
   public static int v3;
   public static boolean v4;
   public static boolean v5;
   public static boolean v6;
   public static boolean v7;
   public static long v8;
   public static boolean v9;
   public static int v10;
   private static long v48;
   public static boolean v11;
   private static long v40;
   private static boolean v44;
   private static long v47;
   private static float v49;
   @Nullable
   private static class_5498 v46;
   @Nullable
   private static COMPOSITESupport v51;
   private static int v50;
   private static int v60;
   @Nullable
   private static GpuTextureView v59;
   @Nullable
   private static GpuTextureView v53;
   private static int v63;
   private static final long v64 = Long.MIN_VALUE;
   private static final long[] v61;
   private static final long[] v66;
   private static final long[] v68;
   private static final float[] v52;
   private static final float[] v75;
   private static final int[] v73;
   private static float v74;
   private static float v72;
   private static float v80;
   private static float v84;
   private static boolean v94;
   private static float v82;
   private static float v99;
   public static boolean v12;
   @Nullable
   public static class_9801 v13;
   private static final int v120 = 2;
   private static final int[] v88;
   private static final int[] v103;
   private static long v101;
   private static long v96;
   private static boolean v105;
   private static long v87;
   private static final class_4587 v85;
   private static final Matrix4f v119;
   private static final Matrix4f v98;
   private static final Matrix4f v124;
   private static final Vector3f v117;
   private static final Vector3f v45;
   private static final Vector3f v104;
   private static final Vector3f v125;
   private static final Quaternionf v141;
   private static final Quaternionf v145;
   private static final Matrix4f v162;
   private static final Vector4f v107;
   private static final Vector4f v118;
   @Nullable
   public static Object v14;
   @Nullable
   public static class_1309 v15;
   @Nullable
   public static class_1799 v16;
   @Nullable
   public static class_811 v18;
   @Nullable
   public static class_4587 v19;
   @Nullable
   public static class_11659 v17;
   public static int v20;
   @Nullable
   public static class_2960 v21;
   public static boolean v22;
   public static boolean v24;

   private cloudSupport35() {
   }

   private static float v7() {
      return switch (visualSupport51.v49) {
         case ULTRA -> 3.0F;
         case OPTIMIZED -> 4.0F;
         case FAST -> 6.0F;
      };
   }

   public static void v1() {
      if (v11) {
         renderSupport38.v1(v59);
         renderSupport38.v2(v53);
         uiSupport169.v1(v63);
         v11 = false;
      }

      for (int var0 = 0; var0 < v37; var0++) {
         v43[var0].v1();
      }

      boolean var7 = v105;
      v105 = false;
      v40++;
      v47 = System.nanoTime();
      v37 = 0;
      v3 = 0;
      v4 = false;
      v11 = false;
      v10 = 0;
      v9 = false;
      class_310 var1 = class_310.method_1551();
      class_5498 var2 = var1.field_1690.method_31044();
      if (var2 != v46) {
         for (cloudSupport35.Part1 var6 : v42) {
            var6.v4 = 0;
         }

         v46 = var2;
      }

      if (visualSupport51.v44 && !(visualSupport51.v47 <= 0.0F) && !cloudSupport69.v1()) {
         if (var1.field_1724 != null && !var1.field_1690.field_1842 && var2.method_31034()) {
            v1 = true;
            if (v47 - v48 >= 0L) {
               v49 = visualSupport51.v47 * 0.016666668F * 1.0E9F;
               v50 = var1.method_1522().field_1482;
               v60 = var1.method_1522().field_1481;
               if (!(v2(-1L) < 1.0F)) {
                  COMPOSITESupport var8 = renderSupport45.v1();
                  if (var8 != null && var8.v7()) {
                     v51 = var8;
                     v44 = var7 && !var8.v7 && !v6;
                     var1.field_1773.method_72911().method_73002();
                     var1.method_22940().method_23000().method_22993();
                     v59 = renderSupport38.v1();
                     v53 = renderSupport38.v2();
                     var8.v2(0);
                     renderSupport38.v1(var8.v1(0));
                     renderSupport38.v2(var8.v8());
                     v63 = uiSupport169.v1("gpu.hand.blur");
                     v11 = true;
                     ProjectionMatrix3Accessor var9 = (ProjectionMatrix3Accessor)((GameRendererAccessor)var1.field_1773).syky$handProjection();
                     float var10 = var9.syky$height() > 0 ? (float)var9.syky$width() / var9.syky$height() : 0.0F;
                     v99 = 1.0F / (float)Math.tan(Math.toRadians(var9.syky$fov()) * 0.5);
                     v82 = var10 > 0.0F ? v99 / var10 : 0.0F;
                     v8();
                     v12 = true;
                  }
               }
            }
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void v2() {
      v1 = false;
      v12 = false;
      if (v4) {
         v48 = v47 + 500000000L;
         if (!v26) {
            v26 = true;
            v25.info("the hand pass drew something outside the hand blur's record; the hand stays unblurred while it does");
         }
      }

      if (v11) {
         v11 = false;
         COMPOSITESupport var0 = v51;
         v51 = null;
         boolean var25 = false /* VF: Semaphore variable */;

         label334: {
            try {
               var25 = true;
               renderSupport38.v1(v59);
               renderSupport38.v2(v53);
               if (var0 == null) {
                  var25 = false;
                  break label334;
               }

               long var1 = System.nanoTime();
               long var3 = (long)v49;
               long var5 = v47 - v87;
               boolean var7 = v44 && !v4 && var5 > 0L && var5 < var3;
               long var8 = var7 ? var5 : var3;
               float var10 = v2(v47 - var8);
               int var11 = v4
                  ? 1
                  : (var7 ? Math.clamp((long)((int)Math.ceil(var10 / v7())), 1, 32) : Math.clamp((long)((int)Math.ceil(var10 / v7()) + 1), 2, 32));
               float var12 = var7 ? (float)var8 / var11 : v49 / Math.max(1, var11 - 1);
               if (!var7) {
                  Arrays.fill(v61, Long.MIN_VALUE);
               }

               v101 = v6 ? Long.MAX_VALUE : var3 / 3L;
               v96 = v47 - var8;
               float var13 = (float)var8 / var11;
               long var14 = v47 / v101;
               int var16 = 1;

               for (int var17 = 1; var17 < var11; var17++) {
                  long var18 = v47 - (long)(var12 * var17);
                  if (var18 / v101 != var14) {
                     v1(var0, var14, var16, var13);
                     var16 = 0;
                     var14 = var18 / v101;
                  }

                  var0.v2(var16);
                  renderSupport38.v1(var0.v1(var16));
                  renderSupport38.v2(var0.v8());

                  try {
                     v1(var18);
                  } finally {
                     renderSupport38.v1(v59);
                     renderSupport38.v2(v53);
                  }

                  if (++var16 == 4) {
                     v1(var0, var14, var16, var13);
                     var16 = 0;
                  }
               }

               v1(var0, var14, var16, var13);
               long var32 = v47 - var3;
               v2(v103);

               for (int var19 = 0; var19 < 4; var19++) {
                  boolean var20 = v61[var19] != Long.MIN_VALUE && v68[var19] > var32;
                  v75[var19] = var20 ? (float)(v68[var19] - Math.max(v66[var19], var32)) : 0.0F;
                  if (var20) {
                     v1(v103, v73, 4 * var19);
                  }
               }

               var0.v1(v75, v103);
               v10 = var11;
               v9 = var7;
               v8 = v8 + (System.nanoTime() - var1);
               if (!v4) {
                  v105 = true;
                  v87 = v47;
                  var25 = false;
               } else {
                  var25 = false;
               }
            } finally {
               if (var25) {
                  v12 = false;
                  uiSupport169.v1(v63);

                  for (int var22 = 0; var22 < v37; var22++) {
                     v43[var22].v1();
                  }

                  v59 = null;
                  v53 = null;
               }
            }

            v12 = false;
            uiSupport169.v1(v63);

            for (int var30 = 0; var30 < v37; var30++) {
               v43[var30].v1();
            }

            v59 = null;
            v53 = null;
            return;
         }

         v12 = false;
         uiSupport169.v1(v63);

         for (int var31 = 0; var31 < v37; var31++) {
            v43[var31].v1();
         }

         v59 = null;
         v53 = null;
      }
   }

   private static void v1(COMPOSITESupport var0, long var1, int var3, float var4) {
      if (var3 != 0) {
         int var5 = (int)Math.floorMod(var1, 4L);
         if (v61[var5] != var1) {
            v61[var5] = var1;
            v52[var5] = 0.0F;
            v66[var5] = Long.MAX_VALUE;
            v68[var5] = Long.MIN_VALUE;
            v1(v73, 4 * var5);
         }

         v1(v88);
         v8();
         v1(v73, 4 * var5, v88);
         long var6 = v101 == Long.MAX_VALUE ? v96 : var1 * v101;
         long var8 = v101 == Long.MAX_VALUE ? v47 : var6 + v101;
         v66[var5] = Math.min(v66[var5], Math.max(v96, var6));
         v68[var5] = Math.max(v68[var5], Math.min(v47, var8));
         float var10 = var3 * var4;
         v52[var5] = v52[var5] + var10;
         var0.v1(var5, var3, var10 / v52[var5], v73, 4 * var5);
      }
   }

   public static void v3() {
      class_9801 var0 = v13;
      v13 = null;
      if (v7) {
         v94 = true;
      }

      if (var0 != null && !v94) {
         class_4574 var1 = var0.method_60822();
         VertexFormat var2 = var1.comp_749();
         if (!(v82 <= 0.0F) && var2.contains(VertexFormatElement.POSITION)) {
            int var3 = var2.getVertexSize();
            int var4 = var2.getOffset(VertexFormatElement.POSITION);
            ByteBuffer var5 = var0.method_60818();
            int var6 = var1.comp_750();
            if ((long)(var6 - 1) * var3 + var4 + 12L > var5.limit()) {
               v94 = var6 > 0;
            } else {
               Matrix4f var7 = RenderSystem.getModelViewMatrix();
               float var8 = var7.m00();
               float var9 = var7.m10();
               float var10 = var7.m20();
               float var11 = var7.m30();
               float var12 = var7.m01();
               float var13 = var7.m11();
               float var14 = var7.m21();
               float var15 = var7.m31();
               float var16 = var7.m02();
               float var17 = var7.m12();
               float var18 = var7.m22();
               float var19 = var7.m32();
               float var20 = v74;
               float var21 = v72;
               float var22 = v80;
               float var23 = v84;

               for (int var24 = 0; var24 < var6; var24++) {
                  int var25 = var24 * var3 + var4;
                  float var26 = var5.getFloat(var25);
                  float var27 = var5.getFloat(var25 + 4);
                  float var28 = var5.getFloat(var25 + 8);
                  float var29 = -(var16 * var26 + var17 * var27 + var18 * var28 + var19);
                  if (!(var29 > 0.001F)) {
                     v94 = true;
                     return;
                  }

                  float var30 = (var8 * var26 + var9 * var27 + var10 * var28 + var11) * v82 / var29;
                  float var31 = (var12 * var26 + var13 * var27 + var14 * var28 + var15) * v99 / var29;
                  var20 = Math.min(var20, var30);
                  var22 = Math.max(var22, var30);
                  var21 = Math.min(var21, var31);
                  var23 = Math.max(var23, var31);
               }

               v74 = var20;
               v72 = var21;
               v80 = var22;
               v84 = var23;
            }
         } else {
            v94 = true;
         }
      }
   }

   private static void v8() {
      v74 = Float.POSITIVE_INFINITY;
      v72 = Float.POSITIVE_INFINITY;
      v80 = Float.NEGATIVE_INFINITY;
      v84 = Float.NEGATIVE_INFINITY;
      v94 = false;
   }

   private static void v1(int[] var0) {
      if (!v94 && v74 <= v80 && v72 <= v84) {
         var0[0] = Math.clamp((long)((int)Math.floor((v74 * 0.5F + 0.5F) * v50) - 2), 0, v50);
         var0[1] = Math.clamp((long)((int)Math.floor((v72 * 0.5F + 0.5F) * v60) - 2), 0, v60);
         var0[2] = Math.clamp((long)((int)Math.ceil((v80 * 0.5F + 0.5F) * v50) + 2), 0, v50);
         var0[3] = Math.clamp((long)((int)Math.ceil((v84 * 0.5F + 0.5F) * v60) + 2), 0, v60);
      } else {
         var0[0] = 0;
         var0[1] = 0;
         var0[2] = v50;
         var0[3] = v60;
      }
   }

   private static void v2(int[] var0) {
      v1(var0, 0);
   }

   private static void v1(int[] var0, int var1) {
      var0[var1] = Integer.MAX_VALUE;
      var0[var1 + 1] = Integer.MAX_VALUE;
      var0[var1 + 2] = Integer.MIN_VALUE;
      var0[var1 + 3] = Integer.MIN_VALUE;
   }

   private static void v1(int[] var0, int var1, int[] var2) {
      var0[var1] = Math.min(var0[var1], var2[0]);
      var0[var1 + 1] = Math.min(var0[var1 + 1], var2[1]);
      var0[var1 + 2] = Math.max(var0[var1 + 2], var2[2]);
      var0[var1 + 3] = Math.max(var0[var1 + 3], var2[3]);
   }

   private static void v1(int[] var0, int[] var1, int var2) {
      var0[0] = Math.min(var0[0], var1[var2]);
      var0[1] = Math.min(var0[1], var1[var2 + 1]);
      var0[2] = Math.max(var0[2], var1[var2 + 2]);
      var0[3] = Math.max(var0[3], var1[var2 + 3]);
   }

   public static void v4() {
      class_811 var0 = v18;
      cloudSupport35.Part2 var1 = v1(0, var0 == null ? -1 : var0.ordinal());
      if (var1 != null) {
         var1.v1 = 0;
         var1.v8 = var0;
      }

      v9();
   }

   public static void v5() {
      cloudSupport35.Part2 var0 = v1(1, v24 ? 1 : 0);
      if (var0 != null) {
         var0.v1 = 1;
         var0.v11 = v24;
         var0.v9 = v21;
         var0.v10 = v22;
      }

      v9();
   }

   public static void v6() {
      cloudSupport35.Part2 var0 = v1(2, 0);
      if (var0 != null) {
         var0.v1 = 2;
      }

      v9();
   }

   private static void v9() {
      v14 = null;
      v15 = null;
      v16 = null;
      v18 = null;
      v19 = null;
      v17 = null;
      v21 = null;
   }

   @Nullable
   private static cloudSupport35.Part2 v1(int var0, int var1) {
      class_4587 var2 = v19;
      if (v1 && !v2 && v37 < 8 && var2 != null && v17 != null) {
         int var3 = v37;
         cloudSupport35.Part1 var4 = v42[var3];
         class_1792 var5 = v16 == null ? null : v16.method_7909();
         if (var4.v5 != var0 || var4.v6 != var1 || var4.v7 != var5) {
            var4.v4 = 0;
            var4.v5 = var0;
            var4.v6 = var1;
            var4.v7 = var5;
         }

         if (var4.v4 > 0 && v47 - var4.v2(0) > 250000000L) {
            var4.v4 = 0;
         }

         Matrix4fStack var6 = RenderSystem.getModelViewStack();
         if (v37 == 0) {
            v98.set(var6);
            v124.set(var6).invert();
         }

         var4.v3 = (var4.v3 + 1) % 64;
         var4.v4 = Math.min(var4.v4 + 1, 64);
         var4.v1[var4.v3].set(var6).mul(var2.method_23760().method_23761());
         var4.v2[var4.v3] = v47;
         cloudSupport35.Part2 var7 = v43[v37++];
         var7.v2 = var3;
         var7.v4 = v14;
         var7.v5 = v17;
         var7.v3 = v20;
         var7.v6 = v15;
         var7.v7 = v16;
         return var7;
      } else {
         return null;
      }
   }

   private static void v1(long var0) {
      class_310 var2 = class_310.method_1551();
      Matrix4fStack var3 = RenderSystem.getModelViewStack();
      var3.pushMatrix();
      var3.set(v98);
      v2 = true;

      try {
         for (int var4 = 0; var4 < v37; var4++) {
            cloudSupport35.Part2 var5 = v43[var4];
            class_11659 var6 = var5.v5;
            if (var6 != null) {
               v1(v42[var5.v2], var0, v119);
               class_4665 var7 = v85.method_23760();
               var7.method_67801();
               var7.method_67797(v124);
               var7.method_67797(v119);
               if (var5.v1 == 0 && var5.v4 instanceof class_759 var8 && var5.v6 != null && var5.v7 != null && var5.v8 != null) {
                  var8.method_3233(var5.v6, var5.v7, var5.v8, v85, var6, var5.v3);
               } else if (var5.v1 == 1 && var5.v4 instanceof class_1007 var9 && var5.v9 != null) {
                  if (var5.v11) {
                     var9.method_4220(v85, var6, var5.v3, var5.v9, var5.v10);
                  } else {
                     var9.method_4221(v85, var6, var5.v3, var5.v9, var5.v10);
                  }
               } else if (var5.v1 == 2 && var5.v4 instanceof class_759 var10 && var5.v7 != null) {
                  ((HeldItemRendererInvoker)var10).syky$renderFirstPersonMap(v85, var6, var5.v3, var5.v7);
               }
            }
         }

         var2.field_1773.method_72911().method_73002();
         var2.method_22940().method_23000().method_22993();
      } finally {
         v2 = false;
         var3.popMatrix();
      }
   }

   private static void v1(cloudSupport35.Part1 var0, long var1, Matrix4f var3) {
      for (int var4 = 0; var4 < var0.v4 - 1; var4++) {
         long var5 = var0.v2(var4);
         long var7 = var0.v2(var4 + 1);
         if (var1 >= var7) {
            float var9 = var5 == var7 ? 0.0F : (float)(var1 - var7) / (float)(var5 - var7);
            v1(var0.v1(var4 + 1), var0.v1(var4), Math.min(1.0F, var9), var3);
            return;
         }
      }

      var3.set(var0.v1(Math.max(0, var0.v4 - 1)));
   }

   private static void v1(Matrix4f var0, Matrix4f var1, float var2, Matrix4f var3) {
      var0.getTranslation(v117);
      var1.getTranslation(v45);
      var0.getScale(v104);
      var1.getScale(v125);
      var0.getNormalizedRotation(v141);
      var1.getNormalizedRotation(v145);
      v117.lerp(v45, var2);
      v104.lerp(v125, var2);
      v141.slerp(v145, var2);
      var3.translationRotateScale(v117, v141, v104);
   }

   private static float v2(long var0) {
      if (v5) {
         return 32.0F * v7();
      } else {
         v162.setPerspective(v23, (float)v50 / v60, 0.05F, 100.0F);
         float var2 = 0.0F;

         for (cloudSupport35.Part1 var6 : v42) {
            long var7 = var0 == -1L && var6.v4 > 0 ? var6.v2(0) - (long)v49 : var0;
            var2 = Math.max(var2, v1(var6, var7));
         }

         return var2;
      }
   }

   private static float v1(cloudSupport35.Part1 var0, long var1) {
      if (var0.v4 >= 2 && v47 - var0.v2(0) <= 250000000L) {
         float var3 = 0.0F;

         for (int var4 = 0; var4 < var0.v4 - 1 && var0.v2(var4) > var1; var4++) {
            long var5 = var0.v2(var4);
            long var7 = var0.v2(var4 + 1);
            float var9 = var5 == var7 ? 1.0F : (float)(var5 - Math.max(var7, var1)) / (float)(var5 - var7);
            var3 += v1(var0.v1(var4), var0.v1(var4 + 1)) * var9;
         }

         return var3;
      } else {
         return 0.0F;
      }
   }

   private static float v1(Matrix4f var0, Matrix4f var1) {
      float var2 = 0.0F;

      for (float[] var6 : v33) {
         v107.set(var6[0], var6[1], var6[2], 1.0F);
         v118.set(var6[0], var6[1], var6[2], 1.0F);
         var0.transform(v107);
         var1.transform(v118);
         v162.transform(v107);
         v162.transform(v118);
         if (!(v107.w <= 0.0F) && !(v118.w <= 0.0F)) {
            float var7 = (v107.x / v107.w - v118.x / v118.w) * 0.5F * v50;
            float var8 = (v107.y / v107.w - v118.y / v118.w) * 0.5F * v60;
            var2 = Math.max(var2, (float)Math.sqrt(var7 * var7 + var8 * var8));
         }
      }

      return var2;
   }

   static {
      for (int var0 = 0; var0 < 8; var0++) {
         v42[var0] = new cloudSupport35.Part1();
         v43[var0] = new cloudSupport35.Part2();
      }

      v61 = new long[4];
      v66 = new long[4];
      v68 = new long[4];
      v52 = new float[4];
      v75 = new float[4];
      v73 = new int[16];
      v88 = new int[4];
      v103 = new int[4];
      v85 = new class_4587();
      v119 = new Matrix4f();
      v98 = new Matrix4f();
      v124 = new Matrix4f();
      v117 = new Vector3f();
      v45 = new Vector3f();
      v104 = new Vector3f();
      v125 = new Vector3f();
      v141 = new Quaternionf();
      v145 = new Quaternionf();
      v162 = new Matrix4f();
      v107 = new Vector4f();
      v118 = new Vector4f();
   }

   public static final class Part1 {
      public final Matrix4f[] v1 = new Matrix4f[64];
      public final long[] v2 = new long[64];
      public int v3;
      public int v4;
      public int v5 = -1;
      public int v6 = -1;
      @Nullable
      public Object v7;

      public Part1() {
         for (int var1 = 0; var1 < 64; var1++) {
            this.v1[var1] = new Matrix4f();
         }
      }

      public Matrix4f v1(int var1) {
         return this.v1[Math.floorMod(this.v3 - var1, 64)];
      }

      public long v2(int var1) {
         return this.v2[Math.floorMod(this.v3 - var1, 64)];
      }
   }

   public static final class Part2 {
      public int v1;
      public int v2;
      public int v3;
      @Nullable
      public Object v4;
      @Nullable
      public class_11659 v5;
      @Nullable
      public class_1309 v6;
      @Nullable
      public class_1799 v7;
      @Nullable
      public class_811 v8;
      @Nullable
      public class_2960 v9;
      public boolean v10;
      public boolean v11;

      public Part2() {
      }

      public void v1() {
         this.v4 = null;
         this.v5 = null;
         this.v6 = null;
         this.v7 = null;
         this.v8 = null;
         this.v9 = null;
      }
   }
}
