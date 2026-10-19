package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;

public final class renderSupport16 extends renderSupport36 {
   private final cloudSupport101 v5;
   private static final class_2960 v6 = class_2960.method_60655("syky", "pipeline/vignette");
   private static final class_2960 v7 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/post/vignette");
   private static final int v9 = 32;
   private static final RenderPipeline v10 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v6)
         .withVertexShader(v7)
         .withFragmentShader(v8)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("VignetteParams", class_10789.field_60031)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );

   public renderSupport16(cloudSupport101 var1) {
      super("vignette", 32);
      this.v5 = var1;
   }

   public void v1(int var1, float var2, float var3) {
      if (!(var2 <= 0.0F)) {
         class_310 var4 = this.v5.v1();
         if (var4 != null && var4.method_1522() != null && var4.method_1522().method_30277() != null) {
            this.v2();
            renderSupport47.v1(this.v1).clear();
            renderSupport47.v1(this.v1)
               .putFloat((var1 >>> 16 & 0xFF) / 255.0F)
               .putFloat((var1 >>> 8 & 0xFF) / 255.0F)
               .putFloat((var1 & 0xFF) / 255.0F)
               .putFloat(Math.min(var2, 1.0F));
            renderSupport47.v1(this.v1).putFloat(Math.min(Math.max(var3, 0.0F), 0.99F)).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F);
            renderSupport47.v1(this.v1).flip();
            CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
            var5.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v2)), renderSupport47.v1(this.v1));
            GpuTextureView var6 = var4.method_1522().method_71639();
            GpuTextureView var7 = var4.method_1522().method_71640();
            RenderPass var8 = this.v1(var5, var6, var7);

            try {
               var8.setPipeline(v10);
               var8.setVertexBuffer(0, this.v3);
               var8.setUniform("VignetteParams", renderSupport31.v1(renderSupport47.v1(this.v2)));
               var8.draw(0, 6);
            } catch (Throwable var12) {
               if (var8 != null) {
                  try {
                     var8.close();
                  } catch (Throwable var11) {
                     var12.addSuppressed(var11);
                  }
               }

               throw var12;
            }

            if (var8 != null) {
               var8.close();
            }
         }
      }
   }
}
