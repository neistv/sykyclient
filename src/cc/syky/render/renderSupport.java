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

public final class renderSupport implements AutoCloseable {
   private static final class_2960 v2 = class_2960.method_60655("syky", "pipeline/dust_field");
   private static final class_2960 v3 = class_2960.method_60655("syky", "core/world/dust_field");
   private static final int v4 = 160;
   private static final int v5 = 6;
   private static final float v6 = 1.6F;
   private static final float v7 = 0.1F;
   private static final float v8 = 0.72F;
   private static final float v9 = 6.5F;
   private static final float v10 = 1.4F;
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v2)
         .withVertexShader(v3)
         .withFragmentShader(v3)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("DustFieldData", class_10789.field_60031)
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .build()
   );
   private final cloudSupport101 v11;
   private final Matrix4f v12 = new Matrix4f();
   @Nullable
   private ByteBuffer v13;
   @Nullable
   private GpuBuffer v14;
   @Nullable
   private GpuBuffer v15;
   private boolean v16;

   public static void v1() {
      Objects.requireNonNull(v1, "dust field pipeline");
   }

   public renderSupport(cloudSupport101 var1) {
      this.v11 = var1;
   }

   public void v1(
      Matrix4f var1,
      Matrix4f var2,
      double var3,
      double var5,
      double var7,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      double var17,
      float var19,
      @Nullable GpuTextureView var20,
      renderSupport10.Part4 var21,
      @Nullable GpuTextureView var22,
      @Nullable GpuTextureView var23
   ) {
      int var24 = (int)Math.ceil(var9);
      if (var24 > 0 && !(var12 <= 0.0F) && !(var11 <= 0.0F)) {
         class_310 var25 = this.v11.v1();
         if (var25 != null && var25.method_1522() != null) {
            class_276 var26 = var25.method_1522();
            if (var26.method_30277() != null && var26.method_30278() != null) {
               int var27 = var26.field_1481;
               if (var26.field_1482 > 0 && var27 > 0) {
                  this.v2();
                  double var28 = var12 * 2.0;
                  this.v12.set(var1).mul(var2);
                  ByteBuffer var30 = Objects.requireNonNull(this.v13, "dust field params");
                  GpuBuffer var31 = Objects.requireNonNull(this.v14, "dust field ubo");
                  var30.clear();
                  this.v12.get(0, var30);
                  var30.position(64);
                  var30.putFloat((var10 >>> 16 & 0xFF) / 255.0F)
                     .putFloat((var10 >>> 8 & 0xFF) / 255.0F)
                     .putFloat((var10 & 0xFF) / 255.0F)
                     .putFloat((var10 >>> 24 & 0xFF) / 255.0F);
                  var30.putFloat((float)v1(var3, var28)).putFloat((float)v1(var5, var28)).putFloat((float)v1(var7, var28)).putFloat((float)var28);
                  var30.putFloat(var15).putFloat(var16).putFloat((float)v1(var17, var28)).putFloat(1.4F);
                  float var32 = Math.max(var14, 0.0F);
                  var30.putFloat(1.0F + var32 * 6.5F).putFloat(var11).putFloat(var13).putFloat(var19);
                  var30.putFloat(var1.m00()).putFloat(var1.m11()).putFloat(1.6F / (var27 * 0.5F)).putFloat(0.1F);
                  var30.putFloat(var12 * 0.72F).putFloat(var12).putFloat(var32).putFloat(var9);
                  var30.flip();
                  CommandEncoder var33 = RenderSystem.getDevice().createCommandEncoder();
                  var33.writeToBuffer(renderSupport31.v1(var31), var30);
                  RenderPass var34 = var33.createRenderPass(
                     () -> "syky:dust_field",
                     var22 != null ? var22 : var26.method_71639(),
                     OptionalInt.empty(),
                     var22 != null ? var23 : (var20 != null ? var20 : var26.method_71640()),
                     OptionalDouble.empty()
                  );

                  try {
                     var34.setPipeline(v1);
                     var34.setVertexBuffer(0, this.v15);
                     var34.setUniform("DustFieldData", renderSupport31.v1(var31));
                     class_12137 var35 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
                     var34.bindTexture("CoverSampler", var21.v1(), var35);
                     var34.bindTexture("CoverFrontSampler", var21.v2(), var35);
                     var34.draw(0, var24 * 6);
                  } catch (Throwable var38) {
                     if (var34 != null) {
                        try {
                           var34.close();
                        } catch (Throwable var37) {
                           var38.addSuppressed(var37);
                        }
                     }

                     throw var38;
                  }

                  if (var34 != null) {
                     var34.close();
                  }
               }
            }
         }
      }
   }

   private static double v1(double var0, double var2) {
      double var4 = var0 % var2;
      return var4 < 0.0 ? var4 + var2 : var4;
   }

   private void v2() {
      if (!this.v16) {
         try {
            this.v13 = MemoryUtil.memAlloc(160);
            this.v15 = renderSupport31.v1("syky:dust_field_dummy_vertex");
            this.v14 = RenderSystem.getDevice().createBuffer(() -> "syky:dust_field_ubo", 136, 160L);
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
