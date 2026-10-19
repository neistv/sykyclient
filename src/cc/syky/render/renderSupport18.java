package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.AddressMode;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import java.util.Objects;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public final class renderSupport18 extends renderSupport36 {
   private static final class_2960 v5 = class_2960.method_60655("syky", "pipeline/custom_sky");
   private static final class_2960 v6 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v7 = class_2960.method_60655("syky", "core/post/custom_sky");
   private static final class_2960 v8 = class_2960.method_60655("syky", "pipeline/custom_sky_picture");
   private static final class_2960 v9 = class_2960.method_60655("syky", "core/post/custom_sky_picture");
   private static final int v10 = 96;
   private static final int v11 = 0;
   private static final int v12 = 64;
   private static final int v13 = 6;
   private static final RenderPipeline v14 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v5)
         .withVertexShader(v6)
         .withFragmentShader(v7)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("CustomSkyParams", class_10789.field_60031)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v15 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v8)
         .withVertexShader(v6)
         .withFragmentShader(v9)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("CustomSkyParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final cloudSupport101 v16;

   public renderSupport18(cloudSupport101 var1) {
      super("custom_sky", 96);
      this.v16 = var1;
   }

   public boolean v1(Matrix4f var1, float var2, float var3, float var4, float var5, float var6) {
      return this.v1(v14, null, var1, var2, var3, var4, var5, var6);
   }

   public boolean v1(GpuTextureView var1, Matrix4f var2, float var3) {
      return this.v1(v15, var1, var2, 0.0F, 0.0F, 0.0F, 0.0F, var3);
   }

   private boolean v1(RenderPipeline var1, @Nullable GpuTextureView var2, Matrix4f var3, float var4, float var5, float var6, float var7, float var8) {
      class_310 var9 = this.v16.v1();
      if (var9 == null) {
         return false;
      } else {
         class_276 var10 = var9.method_1522();
         if (var10 == null || var10.method_30277() == null) {
            return false;
         } else if (var10.field_1482 <= 0 || var10.field_1481 <= 0) {
            return false;
         } else if (var2 != null && var2.isClosed()) {
            return false;
         } else {
            this.v2();
            ByteBuffer var11 = Objects.requireNonNull(this.v1, "custom sky params");
            GpuBuffer var12 = Objects.requireNonNull(this.v2, "custom sky ubo");
            var11.clear();
            var3.get(0, var11);
            var11.position(64);
            var11.putFloat(var4).putFloat(var5).putFloat(var6).putFloat(var7);
            var11.putFloat(var8).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F);
            var11.flip();
            CommandEncoder var13 = RenderSystem.getDevice().createCommandEncoder();
            var13.writeToBuffer(renderSupport31.v1(var12), var11);
            RenderPass var14 = this.v1(var13, var10.method_71639(), null);

            try {
               var14.setPipeline(var1);
               var14.setVertexBuffer(0, this.v3);
               var14.setUniform("CustomSkyParams", renderSupport31.v1(var12));
               if (var2 != null) {
                  var14.bindTexture(
                     "Sampler0",
                     var2,
                     RenderSystem.getSamplerCache()
                        .method_75293(AddressMode.CLAMP_TO_EDGE, AddressMode.CLAMP_TO_EDGE, FilterMode.LINEAR, FilterMode.LINEAR, true)
                  );
               }

               var14.draw(0, 6);
            } catch (Throwable var18) {
               if (var14 != null) {
                  try {
                     var14.close();
                  } catch (Throwable var17) {
                     var18.addSuppressed(var17);
                  }
               }

               throw var18;
            }

            if (var14 != null) {
               var14.close();
            }

            return true;
         }
      }
   }
}
