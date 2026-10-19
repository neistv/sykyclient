package cc.syky.account;

import cc.syky.cloud.cloudSupport101;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport32;
import cc.syky.render.renderSupport47;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.BlendFunction;
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
import java.util.OptionalInt;
import java.util.function.Supplier;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.lwjgl.system.MemoryUtil;

public final class BlurParamsSupport implements AutoCloseable {
   private final cloudSupport101 v1;
   private final renderSupport32 v2 = new renderSupport32();
   private static final class_2960 v3 = class_2960.method_60655("syky", "pipeline/fog_blur_downsample");
   private static final class_2960 v4 = class_2960.method_60655("syky", "pipeline/fog_blur_gaussian");
   private static final class_2960 v5 = class_2960.method_60655("syky", "pipeline/fog_blur");
   private static final class_2960 v6 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v7 = class_2960.method_60655("syky", "core/blur/blur_downsample");
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/blur/gaussian");
   private static final class_2960 v9 = class_2960.method_60655("syky", "core/post/fog_blur");
   private static final int v10 = 16;
   private static final int v11 = 80;
   private static final int v12 = 64;
   private static final float v13 = 0.5F;
   private static final RenderPipeline v14 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v3)
         .withVertexShader(v6)
         .withFragmentShader(v7)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v15 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v4)
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v16 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v5)
         .withVertexShader(v6)
         .withFragmentShader(v9)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("FogBlurParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withSampler("Sampler2")
         .withSampler("Sampler3")
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withSampler("CoverBackSampler")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   @Nullable
   private GpuBuffer v18;
   @Nullable
   private ByteBuffer v19;
   @Nullable
   private GpuBuffer v17;
   @Nullable
   private ByteBuffer v20;
   @Nullable
   private GpuBuffer v21;
   @Nullable
   private GpuTexture v22;
   @Nullable
   private GpuTextureView v24;
   @Nullable
   private GpuTexture v25;
   @Nullable
   private GpuTextureView v26;
   @Nullable
   private GpuTexture v27;
   @Nullable
   private GpuTextureView v28;
   @Nullable
   private GpuTexture v29;
   @Nullable
   private GpuTextureView v30;
   @Nullable
   private GpuTexture v32;
   @Nullable
   private GpuTextureView v23;
   private int v33;
   private int v31;
   private int v34;
   private int v36;
   private int v38;
   private int v42;
   private boolean v43;
   private static final Supplier<String> v37 = () -> "syky:fog_blur_gauss_h";
   private static final Supplier<String> v48 = () -> "syky:fog_blur_gauss_v";

   public BlurParamsSupport(cloudSupport101 var1) {
      this.v1 = var1;
   }

   public void v1(Matrix4f var1, float var2, float var3, float var4, float var5, GpuTextureView var6, GpuTextureView var7, GpuTextureView var8, boolean var9) {
      class_310 var10 = this.v1.v1();
      if (var10 != null && var10.method_1522() != null) {
         class_276 var11 = var10.method_1522();
         if (var11.method_30277() != null && var11.method_30278() != null) {
            this.v1();
            int var12 = var11.field_1482;
            int var13 = var11.field_1481;
            if (var12 > 0 && var13 > 0) {
               this.v1(var12, var13);
               this.v2.v1();
               CommandEncoder var14 = RenderSystem.getDevice().createCommandEncoder();
               class_12137 var15 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
               class_12137 var16 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
               GpuTextureView var17 = var11.method_71639();
               GpuTextureView var18 = var11.method_71640();
               this.v1(var14, var17, var12, var13, this.v24, var15);
               this.v1(var14, this.v24, this.v26, var15, 1.0F / this.v34, 0.0F, var4);
               this.v1(var14, this.v26, this.v28, var15, 0.0F, 1.0F / this.v36, var4);
               this.v1(var14, this.v28, this.v34, this.v36, this.v30, var15);
               this.v1(var14, this.v30, this.v23, var15, 1.0F / this.v38, 0.0F, var4);
               this.v1(var14, this.v23, this.v30, var15, 0.0F, 1.0F / this.v42, var4);
               this.v1(var14, var17, var18, var15, var16, var1, var2, var3, var5, var6, var7, var8, var9);
            }
         }
      }
   }

   private void v1(CommandEncoder var1, @Nullable GpuTextureView var2, int var3, int var4, @Nullable GpuTextureView var5, class_12137 var6) {
      renderSupport47.v1(this.v19).clear();
      renderSupport47.v1(this.v19).putFloat(0.5F / var3).putFloat(0.5F / var4).putFloat(0.0F).putFloat(0.0F);
      renderSupport47.v1(this.v19).flip();
      var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v18)), renderSupport47.v1(this.v19));
      RenderPass var7 = var1.createRenderPass(() -> "syky:fog_blur_downsample", var5, OptionalInt.empty());

      try {
         var7.setPipeline(v14);
         var7.setVertexBuffer(0, this.v21);
         var7.bindTexture("Sampler0", var2, var6);
         var7.setUniform("BlurParams", renderSupport31.v1(renderSupport47.v1(this.v18)));
         var7.draw(0, 6);
      } catch (Throwable var11) {
         if (var7 != null) {
            try {
               var7.close();
            } catch (Throwable var10) {
               var11.addSuppressed(var10);
            }
         }

         throw var11;
      }

      if (var7 != null) {
         var7.close();
      }
   }

   private void v1(CommandEncoder var1, @Nullable GpuTextureView var2, @Nullable GpuTextureView var3, class_12137 var4, float var5, float var6, float var7) {
      renderSupport47.v1(this.v19).clear();
      renderSupport47.v1(this.v19).putFloat(var5).putFloat(var6).putFloat(1.0F).putFloat(var7);
      renderSupport47.v1(this.v19).flip();
      var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v18)), renderSupport47.v1(this.v19));
      Supplier var8 = var5 != 0.0F ? v37 : v48;
      RenderPass var9 = var1.createRenderPass(var8, var3, OptionalInt.empty());

      try {
         var9.setPipeline(v15);
         var9.setVertexBuffer(0, this.v21);
         var9.bindTexture("Sampler0", var2, var4);
         var9.setUniform("BlurParams", renderSupport31.v1(renderSupport47.v1(this.v18)));
         var9.draw(0, 6);
      } catch (Throwable var13) {
         if (var9 != null) {
            try {
               var9.close();
            } catch (Throwable var12) {
               var13.addSuppressed(var12);
            }
         }

         throw var13;
      }

      if (var9 != null) {
         var9.close();
      }
   }

   private void v1(
      CommandEncoder var1,
      GpuTextureView var2,
      GpuTextureView var3,
      class_12137 var4,
      class_12137 var5,
      Matrix4f var6,
      float var7,
      float var8,
      float var9,
      GpuTextureView var10,
      GpuTextureView var11,
      GpuTextureView var12,
      boolean var13
   ) {
      renderSupport47.v1(this.v20).clear();
      var6.get(0, this.v20);
      renderSupport47.v1(this.v20).position(64);
      renderSupport47.v1(this.v20).putFloat(var7).putFloat(1.0F / (var8 - var7)).putFloat(var9).putFloat(var13 ? 1.0F : 0.0F);
      renderSupport47.v1(this.v20).flip();
      var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v17)), renderSupport47.v1(this.v20));
      RenderPass var14 = var1.createRenderPass(() -> "syky:fog_blur", var2, OptionalInt.empty());

      try {
         var14.setPipeline(v16);
         var14.setVertexBuffer(0, this.v21);
         var14.bindTexture("Sampler0", this.v24, var4);
         var14.bindTexture("Sampler1", this.v28, var4);
         var14.bindTexture("Sampler2", this.v30, var4);
         var14.bindTexture("Sampler3", var3, var5);
         var14.bindTexture("CoverSampler", var10, var5);
         var14.bindTexture("CoverFrontSampler", var11, var5);
         var14.bindTexture("CoverBackSampler", var12, var5);
         var14.setUniform("FogBlurParams", renderSupport31.v1(renderSupport47.v1(this.v17)));
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

   private void v1() {
      if (!this.v43) {
         try {
            this.v19 = MemoryUtil.memAlloc(16);
            this.v20 = MemoryUtil.memAlloc(80);
            this.v21 = renderSupport31.v1("syky:fog_blur_dummy_vertex");
            this.v18 = RenderSystem.getDevice().createBuffer(() -> "syky:fog_blur_params_ubo", 136, 16L);
            this.v17 = RenderSystem.getDevice().createBuffer(() -> "syky:fog_blur_composite_ubo", 136, 80L);
            this.v43 = true;
         } catch (Throwable var2) {
            this.close();
            throw var2;
         }
      }
   }

   private void v1(int var1, int var2) {
      if (this.v22 == null || this.v33 != var1 || this.v31 != var2) {
         this.v2();
         this.v34 = Math.max(1, var1 / 2);
         this.v36 = Math.max(1, var2 / 2);
         this.v38 = Math.max(1, this.v34 / 2);
         this.v42 = Math.max(1, this.v36 / 2);
         this.v22 = this.v1("half_a", this.v34, this.v36);
         this.v24 = RenderSystem.getDevice().createTextureView(this.v22);
         this.v25 = this.v1("half_b", this.v34, this.v36);
         this.v26 = RenderSystem.getDevice().createTextureView(this.v25);
         this.v27 = this.v1("half_c", this.v34, this.v36);
         this.v28 = RenderSystem.getDevice().createTextureView(this.v27);
         this.v29 = this.v1("quarter_a", this.v38, this.v42);
         this.v30 = RenderSystem.getDevice().createTextureView(this.v29);
         this.v32 = this.v1("quarter_b", this.v38, this.v42);
         this.v23 = RenderSystem.getDevice().createTextureView(this.v32);
         this.v33 = var1;
         this.v31 = var2;
      }
   }

   private GpuTexture v1(String var1, int var2, int var3) {
      return RenderSystem.getDevice().createTexture(() -> "syky:fog_blur_" + var1, 12, TextureFormat.RGBA8, var2, var3, 1, 1);
   }

   public void v1(long var1) {
      if (this.v2.v1(var1)) {
         this.v2();
      }
   }

   @Override
   public void close() {
      this.v2();
      if (this.v18 != null) {
         this.v18.close();
         this.v18 = null;
      }

      if (this.v17 != null) {
         this.v17.close();
         this.v17 = null;
      }

      if (this.v21 != null) {
         this.v21.close();
         this.v21 = null;
      }

      if (this.v19 != null) {
         MemoryUtil.memFree(this.v19);
         this.v19 = null;
      }

      if (this.v20 != null) {
         MemoryUtil.memFree(this.v20);
         this.v20 = null;
      }

      this.v43 = false;
   }

   private void v2() {
      if (this.v24 != null) {
         this.v24.close();
         this.v24 = null;
      }

      if (this.v22 != null) {
         this.v22.close();
         this.v22 = null;
      }

      if (this.v26 != null) {
         this.v26.close();
         this.v26 = null;
      }

      if (this.v25 != null) {
         this.v25.close();
         this.v25 = null;
      }

      if (this.v28 != null) {
         this.v28.close();
         this.v28 = null;
      }

      if (this.v27 != null) {
         this.v27.close();
         this.v27 = null;
      }

      if (this.v30 != null) {
         this.v30.close();
         this.v30 = null;
      }

      if (this.v29 != null) {
         this.v29.close();
         this.v29 = null;
      }

      if (this.v23 != null) {
         this.v23.close();
         this.v23 = null;
      }

      if (this.v32 != null) {
         this.v32.close();
         this.v32 = null;
      }

      this.v33 = 0;
      this.v31 = 0;
   }
}
