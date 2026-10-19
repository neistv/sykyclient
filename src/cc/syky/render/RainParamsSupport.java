package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class RainParamsSupport extends renderSupport36 {
   private final cloudSupport101 v5;
   private static final class_2960 v6 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v7 = class_2960.method_60655("syky", "core/post/rain_drops");
   private static final int v8 = 14400;
   private static final RenderPipeline v9 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/rain_drops"))
         .withVertexShader(v6)
         .withFragmentShader(v7)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RainParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   @Nullable
   private GpuTexture v10;
   @Nullable
   private GpuTextureView v11;
   private int v12;
   private int v13;

   public RainParamsSupport(cloudSupport101 var1) {
      super("rain_drops", 14400);
      this.v5 = var1;
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6) {
      class_310 var7 = this.v5.v1();
      if (var7 != null && var7.method_1522() != null) {
         class_276 var8 = var7.method_1522();
         GpuTextureView var9 = var8.method_71639();
         int var10 = var8.field_1482;
         int var11 = var8.field_1481;
         if (var9 != null && var10 > 0 && var11 > 0) {
            this.v2();
            this.v1(var10, var11);
            this.v4();
            CommandEncoder var12 = RenderSystem.getDevice().createCommandEncoder();
            renderSupport28.v1(var12, var9, renderSupport47.v1(this.v11), renderSupport47.v1(this.v3));
            ByteBuffer var13 = renderSupport47.v1(this.v1);
            var13.clear();
            var13.putFloat(var10).putFloat(var11).putFloat((float)var10 / var11).putFloat(var2);
            var13.putFloat(var1).putFloat(var3).putFloat(var4).putFloat(var5);
            var13.putFloat(var6).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F);
            renderSupport17.v1(var13, var1, var2, var5, (float)var10 / var11);
            var13.flip();
            var12.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v2)), var13);
            RenderPass var14 = this.v1(var12, var9, null);

            try {
               var14.setPipeline(v9);
               var14.setVertexBuffer(0, renderSupport47.v1(this.v3));
               var14.bindTexture("Sampler0", this.v11, RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false));
               var14.setUniform("RainParams", renderSupport31.v1(renderSupport47.v1(this.v2)));
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
         }
      }
   }

   private void v1(int var1, int var2) {
      if (this.v10 == null || this.v12 != var1 || this.v13 != var2) {
         this.v7();
         this.v10 = RenderSystem.getDevice().createTexture(() -> "syky:rain_drops_scene", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v11 = RenderSystem.getDevice().createTextureView(this.v10);
         this.v12 = var1;
         this.v13 = var2;
      }
   }

   @Override
   public void v5() {
      this.v7();
   }

   @Override
   public void v6() {
      this.v7();
   }

   private void v7() {
      if (this.v11 != null) {
         this.v11.close();
         this.v11 = null;
      }

      if (this.v10 != null) {
         this.v10.close();
         this.v10 = null;
      }

      this.v12 = 0;
      this.v13 = 0;
   }
}
