package cc.syky.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class renderSupport34 implements AutoCloseable {
   private static final class_2960 v1 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v2 = class_2960.method_60655("syky", "core/util/depth_copy");
   private static final RenderPipeline v3 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/depth_copy"))
         .withVertexShader(v1)
         .withFragmentShader(v2)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withColorWrite(false)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .build()
   );
   @Nullable
   private GpuBuffer v4;

   public renderSupport34() {
   }

   public void v1(GpuTextureView var1, GpuTextureView var2, GpuTextureView var3) {
      GpuBuffer var4 = this.v4;
      if (var4 == null) {
         var4 = renderSupport31.v1("syky:depth_copy_dummy_vertex");
         this.v4 = var4;
      }

      RenderPass var5 = RenderSystem.getDevice()
         .createCommandEncoder()
         .createRenderPass(() -> "syky:depth_copy", var3, OptionalInt.empty(), var2, OptionalDouble.of(1.0));

      try {
         var5.setPipeline(v3);
         var5.setVertexBuffer(0, var4);
         var5.bindTexture("Sampler0", var1, RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false));
         var5.draw(0, 6);
      } catch (Throwable var9) {
         if (var5 != null) {
            try {
               var5.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }
         }

         throw var9;
      }

      if (var5 != null) {
         var5.close();
      }
   }

   @Override
   public void close() {
      if (this.v4 != null) {
         this.v4.close();
         this.v4 = null;
      }
   }
}
