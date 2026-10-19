package cc.syky.cloud;

import cc.syky.render.renderSupport10;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport32;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
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
import org.joml.Vector4f;
import org.lwjgl.system.MemoryUtil;

public final class RingDataSupport implements AutoCloseable {
   private static final class_2960 v7 = class_2960.method_60655("syky", "pipeline/ground_ring");
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/world/ground_ring");
   private static final class_2960 v9 = class_2960.method_60655("syky", "pipeline/ground_ring_soft");
   private static final class_2960 v10 = class_2960.method_60655("syky", "core/world/ground_ring_soft");
   private static final class_2960 v11 = class_2960.method_60655("syky", "pipeline/ground_ring_glow");
   private static final class_2960 v12 = class_2960.method_60655("syky", "core/world/ground_ring_glow");
   public static final int v1 = 192;
   private static final int v13 = 4240;
   private static final int v14 = 144;
   private static final int v15 = 64;
   private static final int v16 = 32;
   public static final float v2 = 2.1F;
   public static final float v3 = 0.9F;
   private static final float v18 = 0.02F;
   private static final double v19 = 0.9;
   private static final float v17 = 540.0F;
   private static final float v20 = 0.001F;
   private static final float v21 = 8.0F;
   private static final float v22 = 0.5F;
   private static final double v24 = 0.5;
   private static final float v25 = 3600.0F;
   public static final RenderPipeline v4 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v7)
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RingData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   public static final RenderPipeline v5 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v9)
         .withVertexShader(v12)
         .withFragmentShader(v10)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("RingData", class_10789.field_60031)
         .withUniform("GlowRect", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   public static final RenderPipeline v6 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v11)
         .withVertexShader(v12)
         .withFragmentShader(v12)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("GlowRect", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final cloudSupport101 v26;
   private final Matrix4f v27 = new Matrix4f();
   private final Matrix4f v28 = new Matrix4f();
   private final Vector4f v29 = new Vector4f();
   private final float[] v30 = new float[8];
   private final float[] v32 = new float[8];
   private final float[] v23 = new float[8];
   private final float[] v33 = new float[64];
   private final float[] v31 = new float[64];
   private final float[] v34 = new float[64];
   private final float[] v36 = new float[64];
   private final float[] v38 = new float[64];
   private final long v42 = System.nanoTime();
   private float v43;
   private float v37;
   private float v48;
   private float v40;
   @Nullable
   private ByteBuffer v44;
   @Nullable
   private ByteBuffer v47;
   @Nullable
   private GpuBuffer v49;
   @Nullable
   private GpuBuffer v46;
   @Nullable
   private GpuBuffer v51;
   @Nullable
   private GpuTexture v50;
   private final renderSupport32 v60 = new renderSupport32();
   @Nullable
   private GpuTextureView v59;
   private int v53;
   private int v63;
   private boolean v64;

   public static void v1() {
      Objects.requireNonNull(v4, "ground ring rim pipeline");
      Objects.requireNonNull(v5, "ground ring soft pipeline");
      Objects.requireNonNull(v6, "ground ring glow pipeline");
   }

   public RingDataSupport(cloudSupport101 var1) {
      this.v26 = var1;
   }

   public void v1(
      Matrix4f var1, Matrix4f var2, double var3, double var5, double var7, cloudSupport22 var9, @Nullable GpuTextureView var10, renderSupport10.Part4 var11
   ) {
      int var12 = var9.v2();
      if (var12 > 0) {
         class_310 var13 = this.v26.v1();
         if (var13 != null && var13.method_1522() != null) {
            class_276 var14 = var13.method_1522();
            if (var14.method_30277() != null && var14.method_30278() != null && var14.field_1482 > 0 && var14.field_1481 > 0) {
               this.v3();
               this.v27.set(var1).mul(var2);
               this.v27.invert(this.v28);
               int var15 = Math.max(2, Math.min(4, Math.round(var14.field_1481 / 540.0F)));
               this.v1(var9, var12);
               boolean var16 = this.v1(var9, var12, var3, var5, var7, var14.field_1482, var14.field_1481, var15);
               ByteBuffer var17 = Objects.requireNonNull(this.v44, "ring params");
               GpuBuffer var18 = Objects.requireNonNull(this.v49, "ring ubo");
               var17.clear();
               this.v27.get(0, var17);
               this.v28.get(64, var17);
               var17.position(128);
               double var19 = (System.nanoTime() - this.v42) / 1.0E9 % 3600.0;
               var17.putFloat((float)var19).putFloat(var12).putFloat(2.1F).putFloat(0.0F);

               for (int var21 = 0; var21 < var12; var21++) {
                  int var22 = var9.v6[var21];
                  double var23 = var9.v8[var21] * (Math.PI * 2) - 2.0 * var19 * 0.9;
                  var17.putFloat((float)(var9.v2[var21] - var3))
                     .putFloat((float)(var9.v3[var21] - var5))
                     .putFloat((float)(var9.v4[var21] - var7))
                     .putFloat(var9.v5[var21]);
                  var17.putFloat((var22 >>> 16 & 0xFF) / 255.0F)
                     .putFloat((var22 >>> 8 & 0xFF) / 255.0F)
                     .putFloat((var22 & 0xFF) / 255.0F)
                     .putFloat(var9.v7[var21]);
                  float var25 = var9.v10[var21];
                  var17.putFloat((float)(Math.PI * var25)).putFloat(this.v33[var21]).putFloat((float)Math.cos(var23)).putFloat((float)Math.sin(var23));
                  var17.putFloat(this.v31[var21]).putFloat(this.v34[var21]).putFloat(this.v36[var21]).putFloat(this.v38[var21]);
               }

               var17.flip();
               CommandEncoder var69 = RenderSystem.getDevice().createCommandEncoder();
               var69.writeToBuffer(var18.slice(0L, 144 + var12 * 64), var17);
               GpuTextureView var70 = var10 != null ? var10 : var14.method_71640();
               class_12137 var71 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
               if (var16) {
                  GpuTextureView var24 = this.v1((var14.field_1482 + var15 - 1) / var15, (var14.field_1481 + var15 - 1) / var15);
                  GpuBuffer var73 = Objects.requireNonNull(this.v46, "glow rect ubo");
                  var69.writeToBuffer(var73.slice(0L, 32L), Objects.requireNonNull(this.v47, "glow rect"));
                  int var26 = uiSupport169.v1("gpu.world.rings.march");

                  try {
                     var69.clearColorTexture(Objects.requireNonNull(this.v50, "glow target"), 0);
                     RenderPass var27 = var69.createRenderPass(() -> "syky:ground_ring_soft", var24, OptionalInt.empty());

                     try {
                        var27.setPipeline(v5);
                        var27.setVertexBuffer(0, this.v51);
                        var27.setUniform("RingData", renderSupport31.v1(var18));
                        var27.setUniform("GlowRect", renderSupport31.v1(var73));
                        var27.bindTexture("Sampler0", var70, var71);
                        var27.bindTexture("CoverSampler", var11.v1(), var71);
                        var27.bindTexture("CoverFrontSampler", var11.v2(), var71);
                        var27.draw(0, 6);
                     } catch (Throwable var66) {
                        if (var27 != null) {
                           try {
                              var27.close();
                           } catch (Throwable var62) {
                              var66.addSuppressed(var62);
                           }
                        }

                        throw var66;
                     }

                     if (var27 != null) {
                        var27.close();
                     }
                  } finally {
                     uiSupport169.v1(var26);
                  }

                  int var75 = uiSupport169.v1("gpu.world.rings.glow");

                  try {
                     RenderPass var28 = var69.createRenderPass(() -> "syky:ground_ring_glow", var14.method_71639(), OptionalInt.empty());

                     try {
                        var28.setPipeline(v6);
                        var28.setVertexBuffer(0, this.v51);
                        var28.setUniform("GlowRect", renderSupport31.v1(var73));
                        var28.bindTexture("Sampler0", var24, RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false));
                        var28.draw(0, 6);
                     } catch (Throwable var64) {
                        if (var28 != null) {
                           try {
                              var28.close();
                           } catch (Throwable var61) {
                              var64.addSuppressed(var61);
                           }
                        }

                        throw var64;
                     }

                     if (var28 != null) {
                        var28.close();
                     }
                  } finally {
                     uiSupport169.v1(var75);
                  }
               }

               int var72 = uiSupport169.v1("gpu.world.rings.discs");

               try {
                  RenderPass var74 = var69.createRenderPass(() -> "syky:ground_ring", var14.method_71639(), OptionalInt.empty());

                  try {
                     var74.setPipeline(v4);
                     var74.setVertexBuffer(0, this.v51);
                     var74.setUniform("RingData", renderSupport31.v1(var18));
                     var74.bindTexture("Sampler0", var70, var71);
                     var74.bindTexture("CoverSampler", var11.v1(), var71);
                     var74.bindTexture("CoverFrontSampler", var11.v2(), var71);
                     var74.draw(0, var12 * 192);
                  } catch (Throwable var63) {
                     if (var74 != null) {
                        try {
                           var74.close();
                        } catch (Throwable var60) {
                           var63.addSuppressed(var60);
                        }
                     }

                     throw var63;
                  }

                  if (var74 != null) {
                     var74.close();
                  }
               } finally {
                  uiSupport169.v1(var72);
               }
            }
         }
      }
   }

   private void v1(cloudSupport22 var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         this.v33[var3] = var1.v9[var3];
      }

      for (int var12 = 0; var12 < var2; var12++) {
         if (!(this.v33[var12] <= 0.0F)) {
            float var4 = var1.v7[var12] * this.v33[var12];

            for (int var5 = var12 + 1; var5 < var2; var5++) {
               if (!(this.v33[var5] <= 0.0F)) {
                  double var6 = var1.v2[var12] - var1.v2[var5];
                  double var8 = var1.v4[var12] - var1.v4[var5];
                  double var10 = 0.5F * Math.min(var1.v5[var12], var1.v5[var5]);
                  if (!(var6 * var6 + var8 * var8 > var10 * var10) && !(Math.abs(var1.v3[var12] - var1.v3[var5]) > 0.5)) {
                     if (var1.v7[var5] * this.v33[var5] > var4) {
                        this.v33[var12] = 0.0F;
                        break;
                     }

                     this.v33[var5] = 0.0F;
                  }
               }
            }
         }
      }
   }

   private boolean v1(cloudSupport22 var1, int var2, double var3, double var5, double var7, int var9, int var10, int var11) {
      float var12 = 16.0F / var9;
      float var13 = 16.0F / var10;
      float var14 = Float.POSITIVE_INFINITY;
      float var15 = Float.POSITIVE_INFINITY;
      float var16 = Float.NEGATIVE_INFINITY;
      float var17 = Float.NEGATIVE_INFINITY;

      for (int var18 = 0; var18 < var2; var18++) {
         float var19 = var1.v5[var18];
         float var20 = Math.max(1.9F, 2.1F) * var19;
         float var21 = this.v33[var18] > 0.0F ? 0.9F * var19 : 0.02F;
         float var22 = (float)(var1.v2[var18] - var3);
         float var23 = (float)(var1.v3[var18] - var5) + 0.02F;
         float var24 = (float)(var1.v4[var18] - var7);

         for (int var25 = 0; var25 < 8; var25++) {
            this.v29
               .set(var22 + ((var25 & 1) == 0 ? -var20 : var20), var23 + ((var25 & 2) == 0 ? -var21 : var21), var24 + ((var25 & 4) == 0 ? -var20 : var20), 1.0F);
            this.v27.transform(this.v29);
            this.v30[var25] = this.v29.x;
            this.v32[var25] = this.v29.y;
            this.v23[var25] = this.v29.w;
         }

         this.v43 = Float.POSITIVE_INFINITY;
         this.v37 = Float.POSITIVE_INFINITY;
         this.v48 = Float.NEGATIVE_INFINITY;
         this.v40 = Float.NEGATIVE_INFINITY;

         for (int var30 = 0; var30 < 8; var30++) {
            if (this.v23[var30] >= 0.001F) {
               this.v1(this.v30[var30] / this.v23[var30], this.v32[var30] / this.v23[var30]);
            }

            for (byte var26 = 1; var26 < 8; var26 <<= 1) {
               int var27 = var30 | var26;
               if (var27 != var30 && this.v23[var30] >= 0.001F != this.v23[var27] >= 0.001F) {
                  float var28 = (0.001F - this.v23[var30]) / (this.v23[var27] - this.v23[var30]);
                  this.v1(
                     (this.v30[var30] + var28 * (this.v30[var27] - this.v30[var30])) / 0.001F,
                     (this.v32[var30] + var28 * (this.v32[var27] - this.v32[var30])) / 0.001F
                  );
               }
            }
         }

         float var31 = Math.max(this.v43 - var12, -1.0F);
         float var32 = Math.max(this.v37 - var13, -1.0F);
         float var33 = Math.min(this.v48 + var12, 1.0F);
         float var34 = Math.min(this.v40 + var13, 1.0F);
         if (var31 < var33 && var32 < var34) {
            this.v31[var18] = var31;
            this.v34[var18] = var32;
            this.v36[var18] = var33;
            this.v38[var18] = var34;
            var14 = Math.min(var14, var31);
            var15 = Math.min(var15, var32);
            var16 = Math.max(var16, var33);
            var17 = Math.max(var17, var34);
         } else {
            this.v31[var18] = 1.0F;
            this.v34[var18] = 1.0F;
            this.v36[var18] = -1.0F;
            this.v38[var18] = -1.0F;
         }
      }

      if (var14 < var16 && var15 < var17) {
         ByteBuffer var29 = Objects.requireNonNull(this.v47, "glow rect");
         var29.clear();
         var29.putFloat(var14).putFloat(var15).putFloat(var16).putFloat(var17);
         var29.putFloat(var11).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F).flip();
         return true;
      } else {
         return false;
      }
   }

   private void v1(float var1, float var2) {
      this.v43 = Math.min(this.v43, var1);
      this.v37 = Math.min(this.v37, var2);
      this.v48 = Math.max(this.v48, var1);
      this.v40 = Math.max(this.v40, var2);
   }

   private GpuTextureView v1(int var1, int var2) {
      if (this.v59 == null || this.v53 != var1 || this.v63 != var2) {
         this.v2();
         GpuDevice var3 = RenderSystem.getDevice();
         GpuTexture var4 = var3.createTexture(() -> "syky:ground_ring_glow", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v50 = var4;
         this.v59 = var3.createTextureView(var4);
         this.v53 = var1;
         this.v63 = var2;
      }

      this.v60.v1();
      return Objects.requireNonNull(this.v59, "glow view");
   }

   public void v1(long var1) {
      if (this.v60.v1(var1)) {
         this.v2();
      }
   }

   private void v2() {
      if (this.v59 != null) {
         this.v59.close();
         this.v59 = null;
      }

      if (this.v50 != null) {
         this.v50.close();
         this.v50 = null;
      }

      this.v53 = 0;
      this.v63 = 0;
   }

   private void v3() {
      if (!this.v64) {
         try {
            this.v44 = MemoryUtil.memAlloc(4240);
            this.v47 = MemoryUtil.memAlloc(32);
            this.v51 = renderSupport31.v1("syky:ground_ring_dummy_vertex");
            this.v49 = RenderSystem.getDevice().createBuffer(() -> "syky:ground_ring_ubo", 136, 4240L);
            this.v46 = RenderSystem.getDevice().createBuffer(() -> "syky:ground_ring_glow_rect", 136, 32L);
            this.v64 = true;
         } catch (Throwable var2) {
            this.close();
            throw var2;
         }
      }
   }

   @Override
   public void close() {
      this.v2();
      if (this.v49 != null) {
         this.v49.close();
         this.v49 = null;
      }

      if (this.v46 != null) {
         this.v46.close();
         this.v46 = null;
      }

      if (this.v51 != null) {
         this.v51.close();
         this.v51 = null;
      }

      if (this.v44 != null) {
         MemoryUtil.memFree(this.v44);
         this.v44 = null;
      }

      if (this.v47 != null) {
         MemoryUtil.memFree(this.v47);
         this.v47 = null;
      }

      this.v64 = false;
   }
}
