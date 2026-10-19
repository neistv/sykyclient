package cc.syky.render;

import cc.syky.cloud.cloudRecord8;
import cc.syky.cloud.cloudSupport101;
import cc.syky.ui.uiSupport156;
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
import net.minecraft.class_1011;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.Nullable;

public final class renderSupport19 extends renderSupport36 {
   private final cloudSupport101 v5;
   private static final class_2960 v6 = class_2960.method_60655("syky", "pipeline/color_grade");
   private static final class_2960 v7 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/post/color_grade");
   private static final int v9 = 16;
   private static final RenderPipeline v10 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v6)
         .withVertexShader(v7)
         .withFragmentShader(v8)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("GradeParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   @Nullable
   private GpuTexture v11;
   @Nullable
   private GpuTextureView v12;
   private int v13;
   private int v14;
   @Nullable
   private GpuTexture v15;
   @Nullable
   private GpuTextureView v16;
   @Nullable
   private class_1011 v18;
   @Nullable
   private uiSupport156 v19;
   private boolean v17;

   public renderSupport19(cloudSupport101 var1) {
      super("color_grade", 16);
      this.v5 = var1;
   }

   public void v1(cloudRecord8 var1) {
      class_310 var2 = this.v5.v1();
      if (var2 != null && var2.method_1522() != null && var2.method_1522().method_30277() != null) {
         this.v2();
         int var3 = var2.method_1522().field_1482;
         int var4 = var2.method_1522().field_1481;
         if (var3 > 0 && var4 > 0) {
            this.v1(var3, var4);
            this.v4();
            CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
            uiSupport156 var6 = renderSupport47.v1(this.v19);
            var6.v1(var1);
            if (var6.v1(renderSupport47.v1(this.v18)) != null) {
               var5.writeToTexture(renderSupport47.v1(this.v15), renderSupport47.v1(this.v18));
               this.v17 = true;
            }

            if (this.v17) {
               GpuTextureView var7 = var2.method_1522().method_71639();
               if (var7 != null) {
                  GpuTextureView var8 = var2.method_1522().method_71640();
                  renderSupport28.v1(var5, var7, renderSupport47.v1(this.v12), renderSupport47.v1(this.v3));
                  renderSupport47.v1(this.v1).clear();
                  renderSupport47.v1(this.v1).putFloat(32.0F).putFloat(0.030303031F).putFloat(9.1827364E-4F).putFloat(0.0F);
                  renderSupport47.v1(this.v1).flip();
                  var5.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v2)), this.v1);
                  class_12137 var9 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
                  class_12137 var10 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
                  RenderPass var11 = this.v1(var5, var7, var8);

                  try {
                     var11.setPipeline(v10);
                     var11.setVertexBuffer(0, this.v3);
                     var11.bindTexture("Sampler0", this.v12, var9);
                     var11.bindTexture("Sampler1", this.v16, var10);
                     var11.setUniform("GradeParams", renderSupport31.v1(renderSupport47.v1(this.v2)));
                     var11.draw(0, 6);
                  } catch (Throwable var15) {
                     if (var11 != null) {
                        try {
                           var11.close();
                        } catch (Throwable var14) {
                           var15.addSuppressed(var14);
                        }
                     }

                     throw var15;
                  }

                  if (var11 != null) {
                     var11.close();
                  }
               }
            }
         }
      }
   }

   private void v1(int var1, int var2) {
      if (this.v15 == null) {
         this.v15 = RenderSystem.getDevice().createTexture(() -> "syky:color_grade_lut", 5, TextureFormat.RGBA8, 1089, 33, 1, 1);
         this.v16 = RenderSystem.getDevice().createTextureView(this.v15);
         this.v18 = new class_1011(class_1012.field_4997, 1089, 33, false);
         this.v17 = false;
         if (this.v19 == null) {
            this.v19 = new uiSupport156();
         } else {
            this.v19.v1();
         }
      }

      if (this.v11 == null || this.v13 != var1 || this.v14 != var2) {
         this.v7();
         this.v11 = RenderSystem.getDevice().createTexture(() -> "syky:color_grade_scene", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v12 = RenderSystem.getDevice().createTextureView(this.v11);
         this.v13 = var1;
         this.v14 = var2;
      }
   }

   @Override
   public void v5() {
      this.v7();
   }

   @Override
   public void v6() {
      this.v7();
      if (this.v16 != null) {
         this.v16.close();
         this.v16 = null;
      }

      if (this.v15 != null) {
         this.v15.close();
         this.v15 = null;
      }

      if (this.v18 != null) {
         this.v18.close();
         this.v18 = null;
      }

      this.v17 = false;
      if (this.v19 != null) {
         this.v19.close();
         this.v19 = null;
      }
   }

   private void v7() {
      if (this.v12 != null) {
         this.v12.close();
         this.v12 = null;
      }

      if (this.v11 != null) {
         this.v11.close();
         this.v11 = null;
      }

      this.v13 = 0;
      this.v14 = 0;
   }
}
