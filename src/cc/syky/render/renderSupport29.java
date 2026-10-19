package cc.syky.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.systems.RenderSystem.class_5590;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_9801;
import net.minecraft.class_9801.class_4574;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public final class renderSupport29 implements AutoCloseable {
   private static final RenderPipeline v2 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/stroke_group"))
         .withVertexShader(class_2960.method_60655("syky", "core/util/fullscreen"))
         .withFragmentShader(class_2960.method_60655("syky", "core/world/stroke_group"))
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   public static boolean v1 = true;
   private static final Vector4f v3 = new Vector4f(1.0F, 1.0F, 1.0F, 1.0F);
   private static final Vector3f v4 = new Vector3f();
   private static final Matrix4f v5 = new Matrix4f();
   private final renderSupport35 v6 = new renderSupport35("syky:stroke_group", 12, 8);
   @Nullable
   private GpuBuffer v7;
   @Nullable
   private GpuTextureView v8;
   private final renderSupport32 v9 = new renderSupport32();

   public renderSupport29() {
   }

   public static void v1() {
      Objects.requireNonNull(v2, "stroke group composite pipeline");
   }

   public void v1(GpuTextureView var1, @Nullable GpuTextureView var2) {
      this.v6.v2(var1.getWidth(0), var1.getHeight(0));
      this.v6.v1();
      this.v9.v1();
      this.v8 = var2;
   }

   public GpuTextureView v2() {
      return renderSupport47.v1(this.v6.v4());
   }

   public GpuTextureView v3() {
      return renderSupport47.v1(this.v6.v5());
   }

   public void v1(RenderPass var1) {
      GpuTextureView var2 = this.v8;
      if (var2 != null) {
         var1.bindTexture("Sampler0", var2, RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false));
      }
   }

   public void v1(class_9801 var1, RenderPipeline var2) {
      class_9801 var3 = var1;

      try {
         class_4574 var4 = var1.method_60822();
         GpuBufferSlice var5 = RenderSystem.getDynamicUniforms().method_71106(RenderSystem.getModelViewMatrix(), v3, v4, v5);
         GpuBuffer var6 = var2.getVertexFormat().uploadImmediateVertexBuffer(var1.method_60818());
         class_5590 var7 = RenderSystem.getSequentialBuffer(var4.comp_752());
         GpuBuffer var8 = var7.method_68274(var4.comp_751());
         RenderPass var9 = RenderSystem.getDevice()
            .createCommandEncoder()
            .createRenderPass(() -> "syky:stroke_group", this.v2(), OptionalInt.empty(), this.v3(), OptionalDouble.empty());

         try {
            var9.setPipeline(var2);
            RenderSystem.bindDefaultUniforms(var9);
            var9.setUniform("DynamicTransforms", var5);
            var9.setVertexBuffer(0, var6);
            this.v1(var9);
            var9.setIndexBuffer(var8, var7.method_31924());
            var9.drawIndexed(0, 0, var4.comp_751(), 1);
         } catch (Throwable var14) {
            if (var9 != null) {
               try {
                  var9.close();
               } catch (Throwable var13) {
                  var14.addSuppressed(var13);
               }
            }

            throw var14;
         }

         if (var9 != null) {
            var9.close();
         }
      } catch (Throwable var15) {
         if (var1 != null) {
            try {
               var3.close();
            } catch (Throwable var12) {
               var15.addSuppressed(var12);
            }
         }

         throw var15;
      }

      if (var1 != null) {
         var1.close();
      }
   }

   public void v1(GpuTextureView var1) {
      this.v8 = null;
      GpuBuffer var2 = this.v7;
      if (var2 == null) {
         var2 = renderSupport31.v1("syky:stroke_group_dummy_vertex");
         this.v7 = var2;
      }

      RenderPass var3 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(() -> "syky:stroke_group_composite", var1, OptionalInt.empty());

      try {
         var3.setPipeline(v2);
         var3.setVertexBuffer(0, var2);
         var3.bindTexture("Sampler0", this.v2(), RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false));
         var3.draw(0, 6);
      } catch (Throwable var7) {
         if (var3 != null) {
            try {
               var3.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }
         }

         throw var7;
      }

      if (var3 != null) {
         var3.close();
      }
   }

   public void v1(long var1) {
      if (this.v9.v1(var1)) {
         this.v6.v6();
      }
   }

   @Override
   public void close() {
      this.v6.close();
      if (this.v7 != null) {
         this.v7.close();
         this.v7 = null;
      }
   }
}
