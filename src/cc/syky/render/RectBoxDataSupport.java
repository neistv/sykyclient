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

public final class RectBoxDataSupport extends renderSupport37 {
   private static final class_2960 v12 = class_2960.method_60655("syky", "pipeline/rect_box");
   private static final class_2960 v13 = class_2960.method_60655("syky", "core/gui/rect_box");
   private static final class_2960 v14 = class_2960.method_60655("syky", "pipeline/vibrant_rect_box");
   private static final class_2960 v15 = class_2960.method_60655("syky", "core/vibrant/vibrant_rect_box");
   private static final int v16 = 128;
   public static final int v10 = 96;
   public static final int v11 = 16320;
   private static final RenderPipeline v18 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v12)
         .withVertexShader(v13)
         .withFragmentShader(v13)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RectBoxData", class_10789.field_60031)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v19 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v14)
         .withVertexShader(v15)
         .withFragmentShader(v15)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RectBoxData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );

   public RectBoxDataSupport(cloudSupport101 var1, renderSupport44 var2) {
      super(var1, var2, 128);
   }

   public void v1(float var1, float var2, float var3, float var4, int var5, int var6, float var7, float var8, float var9, float var10, float var11, float var12) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, v18, null);
   }

   public void v1(
      float var1,
      float var2,
      float var3,
      float var4,
      int var5,
      int var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      GpuTextureView var13
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, v19, var13);
   }

   private void v1(
      float var1,
      float var2,
      float var3,
      float var4,
      int var5,
      int var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      RenderPipeline var13,
      @Nullable GpuTextureView var14
   ) {
      var1 += renderSupport33.v2();
      var2 += renderSupport33.v3();
      class_310 var15 = this.v1(var1, var2, var3, var4, var7 + var8 + var9 + var10 + var11 + var12);
      if (var15 != null) {
         this.v1();
         v1(renderSupport47.v1(this.v3), var1, var2, var3, var4, this.v6, this.v7, this.v5, var7, var8, var5, var6, var9, var10, var11, var12);
         this.v1(var13, "RectBoxData", var14, null, 96, 16320);
      }
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
      float var9,
      int var10,
      int var11,
      float var12,
      float var13,
      float var14,
      float var15
   ) {
      var0.clear();
      var0.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
      var0.putFloat(var5).putFloat(var6).putFloat(var7).putFloat(var8);
      var0.putFloat(var12).putFloat(var13).putFloat(var14).putFloat(var15);
      uiSupport155.v1(var0, var10);
      uiSupport155.v1(var0, var11);
      var0.putFloat(var9).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F);
      var0.flip();
   }
}
