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

public final class renderSupport25 extends renderSupport37 {
   private static final class_2960 v12 = class_2960.method_60655("syky", "core/gui/outline");
   private static final class_2960 v13 = class_2960.method_60655("syky", "core/vibrant/vibrant_outline");
   private static final class_2960 v14 = class_2960.method_60655("syky", "pipeline/outline_solid");
   private static final class_2960 v15 = class_2960.method_60655("syky", "core/gui/outline_solid");
   private static final class_2960 v16 = class_2960.method_60655("syky", "pipeline/vibrant_outline_solid");
   private static final class_2960 v18 = class_2960.method_60655("syky", "core/vibrant/vibrant_outline_solid");
   private static final int v19 = 512;
   private static final RenderPipeline v17 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v14)
         .withVertexShader(v12)
         .withFragmentShader(v15)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("OutlineData", class_10789.field_60031)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v20 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v16)
         .withVertexShader(v13)
         .withFragmentShader(v18)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("OutlineData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   public static final int v10 = 208;
   public static final int v11 = 16224;

   public renderSupport25(cloudSupport101 var1, renderSupport44 var2) {
      super(var1, var2, 512);
   }

   private void v1(RenderPipeline var1, @Nullable GpuTextureView var2) {
      this.v1(var1, "OutlineData", var2, null, 208, 16224);
   }

   public void v1(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10, float var11) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, v17, null);
   }

   public void v1(
      float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10, float var11, GpuTextureView var12
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, v20, var12);
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
      float var11,
      RenderPipeline var12,
      @Nullable GpuTextureView var13
   ) {
      var1 += renderSupport33.v2();
      var2 += renderSupport33.v3();
      class_310 var14 = this.v1(var1, var2, var3, var4, var7 + var8 + var9 + var10 + var6 + var11);
      if (var14 != null) {
         this.v1();
         ByteBuffer var15 = renderSupport47.v1(this.v3);
         this.v1(var15, var1, var2, var3, var4, var11, var7, var8, var9, var10);

         for (int var16 = 0; var16 < 8; var16++) {
            uiSupport155.v1(var15, var5);
         }

         var15.putFloat(var6).putFloat(var6).putFloat(var6).putFloat(var6);
         var15.putFloat(var6).putFloat(var6).putFloat(var6).putFloat(var6);
         var15.flip();
         this.v1(var12, var13);
      }
   }

   private void v1(ByteBuffer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      var1.clear();
      var1.putFloat(var2).putFloat(var3).putFloat(var4).putFloat(var5);
      var1.putFloat(this.v6).putFloat(this.v7).putFloat(var6).putFloat(this.v5);
      var1.putFloat(var7).putFloat(var8).putFloat(var9).putFloat(var10);
   }
}
