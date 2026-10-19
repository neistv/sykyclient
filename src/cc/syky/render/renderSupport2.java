package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
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

public final class renderSupport2 implements AutoCloseable {
   private static final class_2960 v2 = class_2960.method_60655("syky", "pipeline/burst");
   private static final class_2960 v3 = class_2960.method_60655("syky", "core/world/burst");
   private static final int v4 = 8336;
   private static final int v5 = 144;
   private static final int v6 = 6;
   private static final float v7 = 1.6F;
   private static final float v8 = 0.1F;
   private static final float v9 = 6.5F;
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v2)
         .withVertexShader(v3)
         .withFragmentShader(v3)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BurstData", class_10789.field_60031)
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withCull(false)
         .build()
   );
   private final cloudSupport101 v10;
   private final String v11;
   private final Matrix4f v12 = new Matrix4f();
   @Nullable
   private ByteBuffer v13;
   @Nullable
   private GpuBuffer v14;
   @Nullable
   private GpuBuffer v15;
   private boolean v16;

   public static void v1() {
      Objects.requireNonNull(v1, "burst pipeline");
   }

   public renderSupport2(cloudSupport101 var1, String var2) {
      this.v10 = var1;
      this.v11 = var2;
   }

   public void v1(
      Matrix4f var1,
      Matrix4f var2,
      double var3,
      double var5,
      double var7,
      renderSupport3 var9,
      @Nullable GpuTextureView var10,
      renderSupport10.Part4 var11,
      @Nullable GpuTextureView var12,
      @Nullable GpuTextureView var13
   ) {
      int var14 = Math.min(var9.v1(), 256);
      if (var14 > 0 && var9.v11 > 0 && !(var9.v13 <= 0.0F) && !(var9.v14 <= 0.0F)) {
         class_310 var15 = this.v10.v1();
         if (var15 != null && var15.method_1522() != null) {
            class_276 var16 = var15.method_1522();
            if (var16.method_30277() != null && var16.method_30278() != null) {
               int var17 = var16.field_1481;
               if (var16.field_1482 > 0 && var17 > 0) {
                  this.v2();
                  this.v12.set(var1).mul(var2);
                  ByteBuffer var18 = Objects.requireNonNull(this.v13, "burst params");
                  GpuBuffer var19 = Objects.requireNonNull(this.v14, "burst ubo");
                  var18.clear();
                  this.v12.get(0, var18);
                  var18.position(64);
                  int var20 = var9.v12;
                  var18.putFloat((var20 >>> 16 & 0xFF) / 255.0F)
                     .putFloat((var20 >>> 8 & 0xFF) / 255.0F)
                     .putFloat((var20 & 0xFF) / 255.0F)
                     .putFloat((var20 >>> 24 & 0xFF) / 255.0F);
                  float var21 = Math.max(var9.v17, 0.0F);
                  var18.putFloat(1.0F + var21 * 6.5F).putFloat(var9.v13).putFloat(var21).putFloat(var9.v20);
                  var18.putFloat(var1.m00()).putFloat(var1.m11()).putFloat(1.6F / (var17 * 0.5F)).putFloat(0.1F);
                  var18.putFloat(var9.v15).putFloat(var9.v16).putFloat(var9.v18).putFloat(1.0F - 2.0F * Math.min(Math.max(var9.v19, 0.0F), 1.0F));
                  var18.putFloat(var9.v11).putFloat(var9.v14).putFloat(0.0F).putFloat(0.0F);

                  for (int var22 = 0; var22 < var14; var22++) {
                     var18.putFloat((float)(var9.v3[var22] - var3))
                        .putFloat((float)(var9.v4[var22] - var5))
                        .putFloat((float)(var9.v5[var22] - var7))
                        .putFloat(var9.v9[var22]);
                     var18.putFloat(var9.v6[var22]).putFloat(var9.v7[var22]).putFloat(var9.v8[var22]).putFloat(var9.v10[var22]);
                  }

                  var18.flip();
                  CommandEncoder var28 = RenderSystem.getDevice().createCommandEncoder();
                  var28.writeToBuffer(var19.slice(0L, 144 + var14 * 32), var18);
                  RenderPass var23 = var28.createRenderPass(
                     () -> "syky:burst:" + this.v11,
                     var12 != null ? var12 : var16.method_71639(),
                     OptionalInt.empty(),
                     var12 != null ? var13 : (var10 != null ? var10 : var16.method_71640()),
                     OptionalDouble.empty()
                  );

                  try {
                     var23.setPipeline(v1);
                     var23.setVertexBuffer(0, this.v15);
                     var23.setUniform("BurstData", renderSupport31.v1(var19));
                     class_12137 var24 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
                     var23.bindTexture("CoverSampler", var11.v1(), var24);
                     var23.bindTexture("CoverFrontSampler", var11.v2(), var24);
                     var23.draw(0, var14 * var9.v11 * 6);
                  } catch (Throwable var27) {
                     if (var23 != null) {
                        try {
                           var23.close();
                        } catch (Throwable var26) {
                           var27.addSuppressed(var26);
                        }
                     }

                     throw var27;
                  }

                  if (var23 != null) {
                     var23.close();
                  }
               }
            }
         }
      }
   }

   private void v2() {
      if (!this.v16) {
         try {
            this.v13 = MemoryUtil.memAlloc(8336);
            this.v15 = renderSupport31.v1("syky:burst_" + this.v11 + "_dummy_vertex");
            this.v14 = RenderSystem.getDevice().createBuffer(() -> "syky:burst_" + this.v11 + "_ubo", 136, 8336L);
            this.v16 = true;
         } catch (Throwable var2) {
            this.close();
            throw var2;
         }
      }
   }

   @Override
   public void close() {
      if (this.v14 != null) {
         this.v14.close();
         this.v14 = null;
      }

      if (this.v15 != null) {
         this.v15.close();
         this.v15 = null;
      }

      if (this.v13 != null) {
         MemoryUtil.memFree(this.v13);
         this.v13 = null;
      }

      this.v16 = false;
   }
}
