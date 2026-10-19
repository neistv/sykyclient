package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import java.util.OptionalInt;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class COMPOSITESupport extends renderSupport36 {
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v9 = class_2960.method_60655("syky", "core/post/hand_blur");
   private static final int v10 = 32;
   public static final int v5 = 4;
   public static final int v6 = 4;
   private static final RenderPipeline v11 = class_10799.method_67887(
      v1("pipeline/hand_blur_fold")
         .withSampler("Hand0Sampler")
         .withSampler("Hand1Sampler")
         .withSampler("Hand2Sampler")
         .withSampler("Hand3Sampler")
         .withSampler("AccumSampler")
         .build()
   );
   private static final String[] v12 = new String[]{"Hand0Sampler", "Hand1Sampler", "Hand2Sampler", "Hand3Sampler"};
   private static final String[] v13 = new String[]{"Slice0Sampler", "Slice1Sampler", "Slice2Sampler", "Slice3Sampler"};
   private static final RenderPipeline v14 = class_10799.method_67887(
      v1("pipeline/hand_blur_composite")
         .withShaderDefine("COMPOSITE")
         .withSampler("Slice0Sampler")
         .withSampler("Slice1Sampler")
         .withSampler("Slice2Sampler")
         .withSampler("Slice3Sampler")
         .withBlend(new BlendFunction(SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ZERO, DestFactor.ONE))
         .build()
   );
   private final cloudSupport101 v15;
   private final GpuTexture[] v16 = new GpuTexture[4];
   private final GpuTextureView[] v18 = new GpuTextureView[4];
   @Nullable
   private GpuTexture v19;
   @Nullable
   private GpuTextureView v17;
   private final GpuTexture[] v20 = new GpuTexture[5];
   private final GpuTextureView[] v21 = new GpuTextureView[5];
   private int v22;
   private int v24;
   private int v25;
   public boolean v7;

   private static Builder v1(String var0) {
      return RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", var0))
         .withVertexShader(v8)
         .withFragmentShader(v9)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("HandBlurParams", class_10789.field_60031)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false);
   }

   public COMPOSITESupport(cloudSupport101 var1) {
      super("hand_blur", 32);
      this.v15 = var1;
   }

   public boolean v7() {
      class_276 var1 = this.v9();
      if (var1 == null) {
         return false;
      } else {
         this.v2();
         this.v7 = this.v1(var1.field_1482, var1.field_1481);
         this.v4();
         return true;
      }
   }

   public GpuTextureView v1(int var1) {
      return this.v18[var1];
   }

   public GpuTextureView v8() {
      return renderSupport47.v1(this.v17);
   }

   public void v2(int var1) {
      RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(this.v16[var1], 0, renderSupport47.v1(this.v19), 1.0);
   }

   public void v1(int var1, int var2, float var3, int[] var4, int var5) {
      CommandEncoder var6 = RenderSystem.getDevice().createCommandEncoder();
      var6.clearColorTexture(this.v20[4], 0);
      ByteBuffer var7 = this.v3();
      v1(var7, var3, this.v25++ & 0xFF, var2, 0.0F);
      v1(var7, 0.0F, 0.0F, 0.0F, 0.0F);
      this.v1(var6, var7);
      class_12137 var8 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
      RenderPass var9 = var6.createRenderPass(() -> "syky:hand_blur_fold", this.v21[4], OptionalInt.empty());

      try {
         v1(var9, var4, var5);
         var9.setPipeline(v11);
         var9.setVertexBuffer(0, renderSupport47.v1(this.v3));

         for (int var10 = 0; var10 < 4; var10++) {
            var9.bindTexture(v12[var10], this.v18[var10 < var2 ? var10 : 0], var8);
         }

         var9.bindTexture("AccumSampler", this.v21[var1], var8);
         var9.setUniform("HandBlurParams", renderSupport31.v1(renderSupport47.v1(this.v2)));
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

      GpuTexture var14 = this.v20[var1];
      GpuTextureView var15 = this.v21[var1];
      this.v20[var1] = this.v20[4];
      this.v21[var1] = this.v21[4];
      this.v20[4] = var14;
      this.v21[4] = var15;
   }

   public void v1(float[] var1, int[] var2) {
      class_276 var3 = this.v9();
      if (var3 != null) {
         CommandEncoder var4 = RenderSystem.getDevice().createCommandEncoder();
         ByteBuffer var5 = this.v3();
         v1(var5, 0.0F, 0.0F, 0.0F, 0.0F);
         v1(var5, var1[0], var1[1], var1[2], var1[3]);
         this.v1(var4, var5);
         class_12137 var6 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
         RenderPass var7 = var4.createRenderPass(() -> "syky:hand_blur_composite", var3.method_71639(), OptionalInt.empty());

         try {
            v1(var7, var2, 0);
            var7.setPipeline(v14);
            var7.setVertexBuffer(0, renderSupport47.v1(this.v3));

            for (int var8 = 0; var8 < 4; var8++) {
               var7.bindTexture(v13[var8], this.v21[var8], var6);
            }

            var7.setUniform("HandBlurParams", renderSupport31.v1(renderSupport47.v1(this.v2)));
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
   }

   private static void v1(RenderPass var0, int[] var1, int var2) {
      int var3 = var1[var2 + 2] - var1[var2];
      int var4 = var1[var2 + 3] - var1[var2 + 1];
      var0.enableScissor(var1[var2], var1[var2 + 1], Math.max(0, var3), Math.max(0, var4));
   }

   @Nullable
   private class_276 v9() {
      class_310 var1 = this.v15.v1();
      class_276 var2 = var1 == null ? null : var1.method_1522();
      return var2 != null && var2.method_71639() != null && var2.field_1482 > 0 && var2.field_1481 > 0 ? var2 : null;
   }

   private boolean v1(int var1, int var2) {
      if (this.v19 != null && this.v22 == var1 && this.v24 == var2) {
         return false;
      } else {
         this.v10();
         GpuDevice var3 = RenderSystem.getDevice();
         byte var4 = 12;

         for (int var5 = 0; var5 < 4; var5++) {
            this.v16[var5] = var3.createTexture(() -> "syky:hand_blur_pose", var4, TextureFormat.RGBA8, var1, var2, 1, 1);
            this.v18[var5] = var3.createTextureView(this.v16[var5]);
         }

         this.v19 = var3.createTexture(() -> "syky:hand_blur_pose_depth", var4, TextureFormat.DEPTH32, var1, var2, 1, 1);
         this.v17 = var3.createTextureView(this.v19);

         for (int var6 = 0; var6 <= 4; var6++) {
            this.v20[var6] = var3.createTexture(() -> "syky:hand_blur_slice", var4, TextureFormat.RGBA8, var1, var2, 1, 1);
            this.v21[var6] = var3.createTextureView(this.v20[var6]);
         }

         this.v22 = var1;
         this.v24 = var2;
         return true;
      }
   }

   @Override
   public void v5() {
      this.v10();
   }

   @Override
   public void v6() {
      this.v10();
   }

   private void v10() {
      for (int var1 = 0; var1 < 4; var1++) {
         if (this.v18[var1] != null) {
            this.v18[var1].close();
            this.v18[var1] = null;
         }

         if (this.v16[var1] != null) {
            this.v16[var1].close();
            this.v16[var1] = null;
         }
      }

      if (this.v17 != null) {
         this.v17.close();
         this.v17 = null;
      }

      if (this.v19 != null) {
         this.v19.close();
         this.v19 = null;
      }

      for (int var2 = 0; var2 <= 4; var2++) {
         if (this.v21[var2] != null) {
            this.v21[var2].close();
            this.v21[var2] = null;
         }

         if (this.v20[var2] != null) {
            this.v20[var2].close();
            this.v20[var2] = null;
         }
      }

      this.v22 = 0;
      this.v24 = 0;
   }
}
