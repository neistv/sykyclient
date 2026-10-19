package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import cc.syky.ui.uiSupport169;
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

public final class BeamDataSupport implements AutoCloseable {
   private static final class_2960 v2 = class_2960.method_60655("syky", "pipeline/loot_beam");
   private static final class_2960 v3 = class_2960.method_60655("syky", "core/world/loot_beam");
   private static final int v4 = 66;
   private static final int v5 = 96;
   private static final int v6 = 48;
   private static final int v7 = 3168;
   private static final float v8 = 1.5F;
   private static final float v9 = 3600.0F;
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v2)
         .withVertexShader(v3)
         .withFragmentShader(v3)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BeamData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final cloudSupport101 v10;
   private final Matrix4f v11 = new Matrix4f();
   private final long v12 = System.nanoTime();
   @Nullable
   private ByteBuffer v13;
   @Nullable
   private GpuBuffer v14;
   @Nullable
   private GpuBuffer v15;
   private boolean v16;

   public static void v1() {
      Objects.requireNonNull(v1, "loot beam pipeline");
   }

   public BeamDataSupport(cloudSupport101 var1) {
      this.v10 = var1;
   }

   public void v1(
      Matrix4f var1, Matrix4f var2, double var3, double var5, double var7, renderSupport7 var9, @Nullable GpuTextureView var10, renderSupport10.Part4 var11
   ) {
      int var12 = var9.v2();
      if (var12 > 0) {
         class_310 var13 = this.v10.v1();
         if (var13 != null && var13.method_1522() != null) {
            class_276 var14 = var13.method_1522();
            if (var14.method_30277() != null && var14.method_30278() != null && var14.field_1482 > 0 && var14.field_1481 > 0) {
               this.v2();
               this.v11.set(var1).mul(var2);
               ByteBuffer var15 = Objects.requireNonNull(this.v13, "beam params");
               GpuBuffer var16 = Objects.requireNonNull(this.v14, "beam ubo");
               var15.clear();
               this.v11.get(0, var15);
               var15.position(64);
               var15.putFloat(var1.m00()).putFloat(var1.m11()).putFloat(1.0F / (var14.field_1482 * 0.5F)).putFloat(1.0F / (var14.field_1481 * 0.5F));
               double var17 = (System.nanoTime() - this.v12) / 1.0E9 % 3600.0;
               var15.putFloat((float)var17).putFloat(var1.m22()).putFloat(var1.m32()).putFloat(1.5F);

               for (int var19 = 0; var19 < var12; var19++) {
                  int var20 = var9.v6[var19];
                  var15.putFloat((float)(var9.v2[var19] - var3))
                     .putFloat((float)(var9.v3[var19] - var5))
                     .putFloat((float)(var9.v4[var19] - var7))
                     .putFloat(var9.v5[var19]);
                  var15.putFloat((var20 >>> 16 & 0xFF) / 255.0F)
                     .putFloat((var20 >>> 8 & 0xFF) / 255.0F)
                     .putFloat((var20 & 0xFF) / 255.0F)
                     .putFloat(var9.v7[var19]);
                  var15.putFloat(var9.v8[var19]).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F);
               }

               var15.flip();
               CommandEncoder var33 = RenderSystem.getDevice().createCommandEncoder();
               var33.writeToBuffer(var16.slice(0L, 96 + var12 * 48), var15);
               GpuTextureView var34 = var10 != null ? var10 : var14.method_71640();
               class_12137 var21 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
               int var22 = uiSupport169.v1("gpu.world.beams");

               try {
                  RenderPass var23 = var33.createRenderPass(() -> "syky:loot_beam", var14.method_71639(), OptionalInt.empty());

                  try {
                     var23.setPipeline(v1);
                     var23.setVertexBuffer(0, this.v15);
                     var23.setUniform("BeamData", renderSupport31.v1(var16));
                     var23.bindTexture("Sampler0", var34, var21);
                     var23.bindTexture("CoverSampler", var11.v1(), var21);
                     var23.bindTexture("CoverFrontSampler", var11.v2(), var21);
                     var23.draw(0, var12 * 66);
                  } catch (Throwable var31) {
                     if (var23 != null) {
                        try {
                           var23.close();
                        } catch (Throwable var30) {
                           var31.addSuppressed(var30);
                        }
                     }

                     throw var31;
                  }

                  if (var23 != null) {
                     var23.close();
                  }
               } finally {
                  uiSupport169.v1(var22);
               }
            }
         }
      }
   }

   private void v2() {
      if (!this.v16) {
         try {
            this.v13 = MemoryUtil.memAlloc(3168);
            this.v15 = renderSupport31.v1("syky:loot_beam_dummy_vertex");
            this.v14 = RenderSystem.getDevice().createBuffer(() -> "syky:loot_beam_ubo", 136, 3168L);
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
