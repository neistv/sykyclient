package cc.syky.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.OptionalInt;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;

public final class renderSupport28 {
   private static final class_2960 v1 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v2 = class_2960.method_60655("syky", "core/util/texture_copy");
   private static final RenderPipeline v3 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/texture_copy"))
         .withVertexShader(v1)
         .withFragmentShader(v2)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );

   private renderSupport28() {
   }

   public static void v1(CommandEncoder var0, GpuTextureView var1, GpuTextureView var2, GpuBuffer var3) {
      RenderPass var4 = var0.createRenderPass(() -> "syky:texture_copy", var2, OptionalInt.empty());

      try {
         var4.setPipeline(v3);
         var4.setVertexBuffer(0, var3);
         var4.bindTexture("Sampler0", var1, RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false));
         var4.draw(0, 6);
      } catch (Throwable var8) {
         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var7) {
               var8.addSuppressed(var7);
            }
         }

         throw var8;
      }

      if (var4 != null) {
         var4.close();
      }
   }
}
