package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import cc.syky.ui.uiSupport155;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class RectDataSupport extends renderSupport37 {
   private static final class_2960 v12 = class_2960.method_60655("syky", "pipeline/rect");
   private static final class_2960 v13 = class_2960.method_60655("syky", "core/gui/rect");
   private static final class_2960 v14 = class_2960.method_60655("syky", "pipeline/vibrant_rect");
   private static final class_2960 v15 = class_2960.method_60655("syky", "core/vibrant/vibrant_rect");
   private static final class_2960 v16 = class_2960.method_60655("syky", "pipeline/rect_fill");
   private static final class_2960 v18 = class_2960.method_60655("syky", "core/gui/rect_fill");
   private static final class_2960 v19 = class_2960.method_60655("syky", "pipeline/vibrant_rect_fill");
   private static final class_2960 v17 = class_2960.method_60655("syky", "core/vibrant/vibrant_rect_fill");
   private static final int v20 = 256;
   private static final RenderPipeline v21 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v12)
         .withVertexShader(v13)
         .withFragmentShader(v13)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RectData", class_10789.field_60031)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v22 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v14)
         .withVertexShader(v15)
         .withFragmentShader(v15)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RectData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v24 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v16)
         .withVertexShader(v18)
         .withFragmentShader(v18)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RectData", class_10789.field_60031)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v25 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v19)
         .withVertexShader(v17)
         .withFragmentShader(v17)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RectData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final int[] v26 = new int[9];
   public static final int v10 = 192;
   public static final int v11 = 16320;

   public RectDataSupport(cloudSupport101 var1, renderSupport44 var2) {
      super(var1, var2, 256);
   }

   public void v1(float var1, float var2, float var3, float var4, int[] var5, float var6, float var7, float var8, float var9) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, 0.0F);
   }

   public void v1(float var1, float var2, float var3, float var4, int[] var5, float var6, float var7, float var8, float var9, float var10) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, v21, null);
   }

   public void v1(float var1, float var2, float var3, float var4, int[] var5, float var6, float var7, float var8, float var9, float var10, GpuTextureView var11) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, v22, var11);
   }

   public void v1(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, v24, null);
   }

   public void v1(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10, GpuTextureView var11) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, v25, var11);
   }

   private void v1(
      float var1,
      float var2,
      float var3,
      float var4,
      int[] var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      RenderPipeline var11,
      @Nullable GpuTextureView var12
   ) {
      var1 += renderSupport33.v2();
      var2 += renderSupport33.v3();
      class_310 var13 = this.v1(var1, var2, var3, var4, var6 + var7 + var8 + var9 + var10);
      if (var13 != null) {
         this.v1();
         v1(var5, this.v26);
         v2(renderSupport47.v1(this.v3), var1, var2, var3, var4, this.v6, this.v7, this.v5, var10, this.v26, var6, var7, var8, var9);
         this.v1(var11, "RectData", var12, null, 192, 16320);
      }
   }

   private void v1(
      float var1,
      float var2,
      float var3,
      float var4,
      int var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      RenderPipeline var11,
      @Nullable GpuTextureView var12
   ) {
      var1 += renderSupport33.v2();
      var2 += renderSupport33.v3();
      class_310 var13 = this.v1(var1, var2, var3, var4, var6 + var7 + var8 + var9 + var10);
      if (var13 != null) {
         this.v1();
         v1(renderSupport47.v1(this.v3), var1, var2, var3, var4, this.v6, this.v7, this.v5, var10, var5, var6, var7, var8, var9);
         this.v1(var11, "RectData", var12, null, 192, 16320);
      }
   }

   public static int[] v1(int[] var0) {
      int[] var1 = new int[9];
      v1(var0, var1);
      return var1;
   }

   public static void v1(int[] var0, int[] var1) {
      if (var0.length == 0) {
         for (int var4 = 0; var4 < 9; var4++) {
            var1[var4] = 0;
         }
      } else if (var0.length >= 9) {
         System.arraycopy(var0, 0, var1, 0, 9);
      } else if (var0.length == 1) {
         for (int var3 = 0; var3 < 9; var3++) {
            var1[var3] = var0[0];
         }
      } else if (var0.length == 4) {
         var1[0] = var0[0];
         var1[2] = var0[1];
         var1[8] = var0[2];
         var1[6] = var0[3];
         var1[1] = v1(var0[0], var0[1]);
         var1[5] = v1(var0[1], var0[2]);
         var1[7] = v1(var0[3], var0[2]);
         var1[3] = v1(var0[0], var0[3]);
         var1[4] = v1(var0[0], var0[1], var0[2], var0[3]);
      } else {
         for (int var2 = 0; var2 < 9; var2++) {
            var1[var2] = var0[var2 % var0.length];
         }
      }
   }

   public static int v1(int var0, int var1) {
      return uiSupport155.v2(var0, var1);
   }

   public static int v1(int var0, int var1, int var2, int var3) {
      return uiSupport155.v2(var0, var1, var2, var3);
   }

   public static void v1(
      ByteBuffer var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int[] var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var10, var11, var12, var13);

      for (int var14 = 0; var14 < 9; var14++) {
         uiSupport155.v1(var0, var9[var14]);
      }

      var0.flip();
   }

   public static void v2(
      ByteBuffer var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int[] var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var10, var11, var12, var13);

      for (int var14 = 0; var14 < 9; var14++) {
         uiSupport155.v2(var0, var9[var14]);
      }

      var0.flip();
   }

   public static void v1(
      ByteBuffer var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var10, var11, var12, var13);
      uiSupport155.v1(var0, var9);
      var0.position(192);
      var0.flip();
   }

   private static void v1(
      ByteBuffer var0,
      float var1,
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
      float var12
   ) {
      var0.clear();
      var0.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
      var0.putFloat(var5).putFloat(var6).putFloat(var7).putFloat(var8);
      var0.putFloat(var9).putFloat(var10).putFloat(var11).putFloat(var12);
   }
}
