package cc.syky.account;

import cc.syky.cloud.BlurDataSupport;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport27;
import cc.syky.render.renderSupport30;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport32;
import cc.syky.render.renderSupport33;
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
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Supplier;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class accountSupport7 implements AutoCloseable, accountSupport8 {
   private static final class_2960 v2 = class_2960.method_60655("syky", "pipeline/wobble");
   private static final class_2960 v3 = class_2960.method_60655("syky", "core/layer/wobble");
   private static final class_2960 v4 = class_2960.method_60655("syky", "pipeline/wobble_backdrop");
   private static final class_2960 v5 = class_2960.method_60655("syky", "core/layer/wobble_backdrop");
   public static final int v1 = 16;
   private static final int v6 = 320;
   private static final int v7 = 6;
   private static final float v8 = 24.0F;
   private static final int v9 = 4;
   private static final int v10 = 20;
   private static final Supplier<String> v11 = () -> "syky:wobble_composite";
   private static final Supplier<String> v12 = () -> "syky:wobble_scene_warp";
   private static final Supplier<String> v13 = () -> "syky:wobble_overlay";
   private static final Supplier<String> v14 = () -> "syky:wobble_backdrop";
   private static final RenderPipeline v15 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v2)
         .withVertexShader(v3)
         .withFragmentShader(v3)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("WobbleData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v16 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wobble_overlay"))
         .withVertexShader(class_2960.method_60655("syky", "core/layer/offscreen_overlay"))
         .withFragmentShader(class_2960.method_60655("syky", "core/layer/offscreen_overlay"))
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("OverlayParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final int v18 = 16;
   private static final RenderPipeline v19 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v4)
         .withVertexShader(v5)
         .withFragmentShader(v5)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("WobbleData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final cloudSupport101 v17;
   @Nullable
   private GpuTexture v20;
   @Nullable
   private GpuTextureView v21;
   @Nullable
   private GpuTexture v22;
   @Nullable
   private GpuTextureView v24;
   private int v25;
   private int v26;
   private int v27;
   private int v28;
   private boolean v29;
   private boolean v30;
   private final renderSupport32 v32 = new renderSupport32();
   private int v23;
   private int v33;
   @Nullable
   private BlurDataSupport v31;
   @Nullable
   private GpuBuffer v34;
   @Nullable
   private ByteBuffer v36;
   @Nullable
   private GpuBuffer v38;
   @Nullable
   private ByteBuffer v42;
   @Nullable
   private GpuBuffer v43;
   private boolean v37;

   public accountSupport7(cloudSupport101 var1) {
      this.v17 = var1;
   }

   public boolean v1(BlurDataSupport var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float[] var10) {
      if (!this.v29 && !(var4 <= 0.0F) && !(var5 <= 0.0F) && !(var8 <= 0.0F) && !(var9 <= 0.0F)) {
         if (var10 != null && var10.length >= 32) {
            class_310 var11 = this.v17.v1();
            if (var11 != null && var11.method_1522() != null && var11.method_1522().method_30277() != null) {
               float var12 = var11.method_22683().method_4495();
               if (var12 <= 0.0F) {
                  return false;
               } else {
                  this.v3();
                  if (!this.v1(var11)) {
                     return false;
                  } else {
                     this.v32.v1();
                     float var13 = this.v25 / var12;
                     float var14 = this.v26 / var12;
                     float var15 = accountSupport10.v1(var6, var8, var13, var12);
                     float var16 = accountSupport10.v1(var7, var9, var14, var12);
                     this.v23 = v1(var8 * var12);
                     this.v33 = v1(var9 * var12);
                     ByteBuffer var17 = renderSupport47.v1(this.v36);
                     var17.clear();
                     var17.putFloat(var13).putFloat(var14).putFloat(this.v23).putFloat(this.v33);
                     var17.putFloat(var2).putFloat(var3).putFloat(var4).putFloat(var5);
                     var17.putFloat(var6 + var15).putFloat(var7 + var16).putFloat(var8).putFloat(var9);
                     var17.putFloat(var15).putFloat(var16).putFloat(0.0F).putFloat(0.0F);

                     for (int var18 = 0; var18 < 16; var18++) {
                        var17.putFloat(var10[2 * var18]).putFloat(var10[2 * var18 + 1]).putFloat(0.0F).putFloat(0.0F);
                     }

                     var17.flip();
                     CommandEncoder var19 = RenderSystem.getDevice().createCommandEncoder();
                     var19.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v34)), var17);
                     var19.clearColorTexture(this.v20, 0);
                     this.v31 = var1;
                     this.v30 = this.v1(var11, var19);
                     if (this.v30) {
                        this.v31.v2(this.v24);
                     }

                     if (!renderSupport30.v1(this.v21)) {
                        this.v30 = false;
                        if (this.v31 != null) {
                           this.v31.v10();
                           this.v31 = null;
                        }

                        return false;
                     } else {
                        renderSupport33.v1(var15, var16);
                        this.v29 = true;
                        var1.v1(this);
                        return true;
                     }
                  }
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void v1() {
      if (this.v29) {
         this.v29 = false;
         this.v30 = false;
         renderSupport33.v1();
         renderSupport30.v1();
         if (this.v31 != null) {
            this.v31.v10();
            this.v31.v11();
            this.v31 = null;
         }

         class_310 var1 = this.v17.v1();
         if (var1 != null && this.v20 != null) {
            CommandEncoder var2 = RenderSystem.getDevice().createCommandEncoder();
            class_12137 var3 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
            GpuTextureView var4 = renderSupport30.v1(var1);
            GpuTextureView var5 = var1.method_1522().method_71640();
            RenderPass var6 = this.v1(var2, v11, var4, var5);

            try {
               var6.setPipeline(v15);
               cloudSupport27.v1(var6);
               var6.setVertexBuffer(0, this.v43);
               var6.bindTexture("Sampler0", this.v21, var3);
               var6.setUniform("WobbleData", renderSupport31.v1(renderSupport47.v1(this.v34)));
               var6.draw(0, this.v23 * this.v33 * 6);
            } catch (Throwable var10) {
               if (var6 != null) {
                  try {
                     var6.close();
                  } catch (Throwable var9) {
                     var10.addSuppressed(var9);
                  }
               }

               throw var10;
            }

            if (var6 != null) {
               var6.close();
            }
         }
      }
   }

   @Override
   public boolean v12() {
      return this.v29;
   }

   @Nullable
   @Override
   public GpuTextureView v13() {
      return this.v30 ? this.v24 : null;
   }

   @Override
   public void v1(@Nullable GpuTextureView var1, @Nullable GpuTextureView var2) {
      if (this.v29 && var1 != null && var2 != null) {
         CommandEncoder var3 = RenderSystem.getDevice().createCommandEncoder();
         class_12137 var4 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
         RenderPass var5 = this.v1(var3, v12, var1, null);

         try {
            var5.setPipeline(v19);
            var5.setVertexBuffer(0, this.v43);
            var5.bindTexture("Sampler0", var2, var4);
            var5.setUniform("WobbleData", renderSupport31.v1(renderSupport47.v1(this.v34)));
            var5.draw(0, this.v23 * this.v33 * 6);
         } catch (Throwable var9) {
            if (var5 != null) {
               try {
                  var5.close();
               } catch (Throwable var8) {
                  var9.addSuppressed(var8);
               }
            }

            throw var9;
         }

         if (var5 != null) {
            var5.close();
         }
      }
   }

   @Override
   public void v1(@Nullable GpuTextureView var1, int var2, int var3) {
      if (this.v29 && var1 != null && this.v20 != null && var2 > 0 && var3 > 0) {
         float var4 = Math.max(1.0F, (float)this.v25 / var2) / 4.0F;
         ByteBuffer var5 = renderSupport47.v1(this.v42);
         var5.clear();
         var5.putFloat(var2).putFloat(var3).putFloat(var4 / this.v25).putFloat(var4 / this.v26);
         var5.flip();
         CommandEncoder var6 = RenderSystem.getDevice().createCommandEncoder();
         var6.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v38)), var5);
         class_12137 var7 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
         RenderPass var8 = this.v1(var6, v13, var1, null);

         try {
            var8.setPipeline(v16);
            var8.setVertexBuffer(0, this.v43);
            var8.bindTexture("Sampler0", this.v21, var7);
            var8.setUniform("OverlayParams", renderSupport31.v1(renderSupport47.v1(this.v38)));
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

   public void v2() {
      this.v29 = false;
      this.v30 = false;
      renderSupport33.v1();
      if (this.v31 != null) {
         this.v31.v10();
         this.v31.v11();
         this.v31 = null;
      }
   }

   public void v1(long var1) {
      if (!this.v29 && this.v32.v1(var1)) {
         this.v4();
         this.v5();
      }
   }

   private boolean v1(class_310 var1, CommandEncoder var2) {
      if (this.v31 != null && this.v31.v14()) {
         GpuTextureView var3 = this.v31.v13();
         if (var3 == null || !this.v1(this.v31)) {
            return false;
         } else if (!this.v31.v1(this.v24)) {
            return false;
         } else {
            class_12137 var4 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
            RenderPass var5 = this.v1(var2, v14, renderSupport47.v1(this.v24), null);

            try {
               var5.setPipeline(v19);
               var5.setVertexBuffer(0, this.v43);
               var5.bindTexture("Sampler0", var3, var4);
               var5.setUniform("WobbleData", renderSupport31.v1(renderSupport47.v1(this.v34)));
               var5.draw(0, this.v23 * this.v33 * 6);
            } catch (Throwable var9) {
               if (var5 != null) {
                  try {
                     var5.close();
                  } catch (Throwable var8) {
                     var9.addSuppressed(var8);
                  }
               }

               throw var9;
            }

            if (var5 != null) {
               var5.close();
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private static int v1(float var0) {
      int var1 = Math.round(var0 / 24.0F);
      return var1 < 4 ? 4 : (var1 > 20 ? 20 : var1);
   }

   private RenderPass v1(CommandEncoder var1, Supplier<String> var2, GpuTextureView var3, @Nullable GpuTextureView var4) {
      return var4 == null
         ? var1.createRenderPass(var2, var3, OptionalInt.empty())
         : var1.createRenderPass(var2, var3, OptionalInt.empty(), var4, OptionalDouble.empty());
   }

   private boolean v1(class_310 var1) {
      int var2 = var1.method_1522().field_1482;
      int var3 = var1.method_1522().field_1481;
      if (var2 <= 0 || var3 <= 0) {
         return false;
      } else if (this.v20 != null && var2 == this.v25 && var3 == this.v26) {
         return true;
      } else {
         this.v4();
         this.v20 = RenderSystem.getDevice().createTexture(() -> "syky:wobble_capture", 12, TextureFormat.RGBA8, var2, var3, 1, 1);
         this.v21 = RenderSystem.getDevice().createTextureView(this.v20);
         this.v25 = var2;
         this.v26 = var3;
         return true;
      }
   }

   private boolean v1(BlurDataSupport var1) {
      int var2 = var1.v15();
      int var3 = var1.v16();
      if (var2 <= 0 || var3 <= 0) {
         return false;
      } else if (this.v22 != null && var2 == this.v27 && var3 == this.v28) {
         return true;
      } else {
         this.v5();
         this.v22 = RenderSystem.getDevice().createTexture(() -> "syky:wobble_backdrop", 12, TextureFormat.RGBA8, var2, var3, 1, 1);
         this.v24 = RenderSystem.getDevice().createTextureView(this.v22);
         this.v27 = var2;
         this.v28 = var3;
         return true;
      }
   }

   private void v3() {
      if (!this.v37) {
         try {
            this.v36 = MemoryUtil.memAlloc(320);
            this.v42 = MemoryUtil.memAlloc(16);
            this.v43 = renderSupport31.v1("syky:wobble_dummy_vertex");
            this.v34 = RenderSystem.getDevice().createBuffer(() -> "syky:wobble_ubo", 136, 320L);
            this.v38 = RenderSystem.getDevice().createBuffer(() -> "syky:wobble_overlay_ubo", 136, 16L);
            this.v37 = true;
         } catch (Throwable var2) {
            this.close();
            throw var2;
         }
      }
   }

   private void v4() {
      if (this.v21 != null) {
         this.v21.close();
         this.v21 = null;
      }

      if (this.v20 != null) {
         this.v20.close();
         this.v20 = null;
      }

      this.v25 = 0;
      this.v26 = 0;
   }

   private void v5() {
      if (this.v24 != null) {
         this.v24.close();
         this.v24 = null;
      }

      if (this.v22 != null) {
         this.v22.close();
         this.v22 = null;
      }

      this.v27 = 0;
      this.v28 = 0;
   }

   @Override
   public void close() {
      this.v2();
      this.v4();
      this.v5();
      if (this.v34 != null) {
         this.v34.close();
         this.v34 = null;
      }

      if (this.v38 != null) {
         this.v38.close();
         this.v38 = null;
      }

      if (this.v43 != null) {
         this.v43.close();
         this.v43 = null;
      }

      if (this.v36 != null) {
         MemoryUtil.memFree(this.v36);
         this.v36 = null;
      }

      if (this.v42 != null) {
         MemoryUtil.memFree(this.v42);
         this.v42 = null;
      }

      this.v37 = false;
   }
}
