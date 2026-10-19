package cc.syky.cloud;

import cc.syky.render.renderSupport28;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport36;
import cc.syky.render.renderSupport47;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
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
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.Nullable;

public final class FogSupport extends renderSupport36 {
   public static final int v5 = 512;
   public static final int v6 = 16;
   private final cloudSupport101 v7;
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v9 = class_2960.method_60655("syky", "core/post/wet_surfaces_downsample");
   private static final class_2960 v10 = class_2960.method_60655("syky", "core/post/wet_surfaces_trace");
   private static final class_2960 v11 = class_2960.method_60655("syky", "core/post/wet_surfaces_composite");
   private static final class_2960 v12 = class_2960.method_60655("syky", "core/post/wet_surfaces_water_gate");
   private static final class_2960 v13 = class_2960.method_60655("syky", "core/post/wet_surfaces_mirror");
   private static final class_2960 v14 = class_2960.method_60655("syky", "core/post/wet_surfaces_mirror_add");
   private static final int v15 = 288;
   private static final int v16 = 6;
   private static final int v18 = 6;
   private static final String[] v19 = new String[]{"Sampler0", "Sampler5", "Sampler6", "Sampler7", "Sampler8", "Sampler9"};
   private static final RenderPipeline v17 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wet_surfaces_downsample"))
         .withVertexShader(v8)
         .withFragmentShader(v9)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v20 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wet_surfaces_trace"))
         .withVertexShader(v8)
         .withFragmentShader(v10)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("WetParams", class_10789.field_60031)
         .withUniform("Fog", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withSampler("Sampler2")
         .withSampler("Sampler3")
         .withSampler("Sampler5")
         .withSampler("Sampler6")
         .withSampler("Sampler7")
         .withSampler("Sampler8")
         .withSampler("Sampler9")
         .withSampler("Sampler11")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v21 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wet_surfaces_composite"))
         .withVertexShader(v8)
         .withFragmentShader(v11)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("WetParams", class_10789.field_60031)
         .withUniform("Fog", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withSampler("Sampler2")
         .withSampler("Sampler3")
         .withSampler("Sampler4")
         .withSampler("Sampler5")
         .withSampler("Sampler6")
         .withSampler("Sampler7")
         .withSampler("Sampler8")
         .withSampler("Sampler9")
         .withSampler("Sampler10")
         .withSampler("Sampler11")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v22 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wet_surfaces_water"))
         .withVertexShader(v8)
         .withFragmentShader(v11)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("WetParams", class_10789.field_60031)
         .withUniform("Fog", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withSampler("Sampler2")
         .withSampler("Sampler3")
         .withSampler("Sampler4")
         .withSampler("Sampler5")
         .withSampler("Sampler6")
         .withSampler("Sampler7")
         .withSampler("Sampler8")
         .withSampler("Sampler9")
         .withSampler("Sampler10")
         .withSampler("Sampler11")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v24 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wet_surfaces_water_gate"))
         .withVertexShader(v8)
         .withFragmentShader(v12)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withColorWrite(false)
         .withDepthTestFunction(DepthTestFunction.LESS_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v25 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wet_surfaces_mirror"))
         .withVertexShader(v8)
         .withFragmentShader(v13)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("WetParams", class_10789.field_60031)
         .withUniform("Fog", class_10789.field_60031)
         .withSampler("Sampler1")
         .withSampler("Sampler2")
         .withSampler("Sampler3")
         .withSampler("Sampler4")
         .withSampler("Sampler10")
         .withSampler("Sampler11")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v26 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/wet_surfaces_mirror_add"))
         .withVertexShader(v8)
         .withFragmentShader(v14)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.ADDITIVE)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   @Nullable
   private GpuTexture v27;
   @Nullable
   private GpuTextureView v28;
   private boolean v29;
   private boolean v30;
   @Nullable
   private GpuTexture[] v32;
   @Nullable
   private GpuTextureView[] v23;
   @Nullable
   private GpuTexture v33;
   @Nullable
   private GpuTextureView v31;
   @Nullable
   private GpuTexture v34;
   @Nullable
   private GpuTextureView v36;
   private int v38;
   private int v42;
   private float v43;
   @Nullable
   private GpuTexture v37;
   @Nullable
   private GpuTextureView v48;
   @Nullable
   private GpuTexture v40;
   @Nullable
   private GpuTextureView v44;
   @Nullable
   private GpuTexture v47;
   @Nullable
   private GpuTextureView v49;
   @Nullable
   private CompletableFuture<ByteBuffer> v46;
   @Nullable
   private GpuTexture v51;
   @Nullable
   private GpuTextureView v50;
   private int v60;
   private int v59;
   private static final int v53 = -16776961;

   public FogSupport(cloudSupport101 var1) {
      super("wet_surfaces", 288);
      this.v7 = var1;
   }

   public void v1(int var1, int var2, ByteBuffer var3, ByteBuffer var4) {
      this.v10();
      CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
      int var6 = var1 * 16;
      int var7 = var2 * 16;
      var5.writeToTexture(renderSupport47.v1(this.v37), var3, class_1012.field_4997, 0, 0, var6, var7, 16, 16);
      var5.writeToTexture(renderSupport47.v1(this.v40), var4, class_1012.field_4997, 0, 0, var6, var7, 16, 16);
   }

   public void v7() {
      if (this.v37 != null && this.v40 != null) {
         CommandEncoder var1 = RenderSystem.getDevice().createCommandEncoder();
         var1.clearColorTexture(this.v37, 0);
         var1.clearColorTexture(this.v40, -16776961);
      }
   }

   public void v1(cloudRecord4 var1) {
      class_310 var2 = this.v7.v1();
      if (var2 != null && var2.method_1522() != null) {
         class_276 var3 = var2.method_1522();
         GpuTextureView var4 = var3.method_71639();
         GpuTextureView var5 = var3.method_71640();
         GpuBufferSlice var6 = RenderSystem.getShaderFog();
         if (var4 != null && var5 != null && var6 != null) {
            int var7 = var3.field_1482;
            int var8 = var3.field_1481;
            if (var7 > 0 && var8 > 0) {
               this.v2();
               this.v10();
               this.v11();
               this.v12();
               this.v1(var7, var8, var1.v20());
               this.v4();
               CommandEncoder var9 = RenderSystem.getDevice().createCommandEncoder();
               this.v1(var9, var1, var7, var8);
               this.v29 = true;
               this.v30 = true;
               GpuTextureView[] var10 = renderSupport47.v1(this.v23);
               renderSupport28.v1(var9, var4, var10[0], renderSupport47.v1(this.v3));
               class_12137 var11 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);

               for (int var12 = 1; var12 < 6; var12++) {
                  RenderPass var13 = var9.createRenderPass(() -> "syky:wet_surfaces_downsample", var10[var12], OptionalInt.empty());

                  try {
                     var13.setPipeline(v17);
                     var13.setVertexBuffer(0, renderSupport47.v1(this.v3));
                     var13.bindTexture("Sampler0", var10[var12 - 1], var11);
                     var13.draw(0, 6);
                  } catch (Throwable var17) {
                     if (var13 != null) {
                        try {
                           var13.close();
                        } catch (Throwable var16) {
                           var17.addSuppressed(var16);
                        }
                     }

                     throw var17;
                  }

                  if (var13 != null) {
                     var13.close();
                  }
               }

               this.v1(var9, v21, var4, var5, var5, var6);
            }
         }
      }
   }

   private void v1(CommandEncoder var1, RenderPipeline var2, GpuTextureView var3, GpuTextureView var4, GpuTextureView var5, GpuBufferSlice var6) {
      GpuTextureView[] var7 = renderSupport47.v1(this.v23);
      class_12137 var8 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      class_12137 var9 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
      class_12137 var10 = RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR);
      class_12137 var11 = RenderSystem.getSamplerCache().method_76521(FilterMode.LINEAR, true);
      GpuBufferSlice var12 = renderSupport31.v1(renderSupport47.v1(this.v2));
      RenderPass var13 = var1.createRenderPass(() -> "syky:wet_surfaces_trace", renderSupport47.v1(this.v36), OptionalInt.empty());

      try {
         var13.setPipeline(v20);
         this.v1(var13, var7, var4, var8, var9, var10, var11, var12, var6);
         var13.draw(0, 6);
      } catch (Throwable var19) {
         if (var13 != null) {
            try {
               var13.close();
            } catch (Throwable var17) {
               var19.addSuppressed(var17);
            }
         }

         throw var19;
      }

      if (var13 != null) {
         var13.close();
      }

      var13 = var1.createRenderPass(() -> "syky:wet_surfaces", var3, OptionalInt.empty());

      try {
         var13.setPipeline(var2);
         this.v1(var13, var7, var5, var8, var9, var10, var11, var12, var6);
         var13.bindTexture("Sampler4", renderSupport47.v1(this.v36), var9);
         var13.draw(0, 6);
      } catch (Throwable var18) {
         if (var13 != null) {
            try {
               var13.close();
            } catch (Throwable var16) {
               var18.addSuppressed(var16);
            }
         }

         throw var18;
      }

      if (var13 != null) {
         var13.close();
      }
   }

   private void v1(
      RenderPass var1,
      GpuTextureView[] var2,
      GpuTextureView var3,
      class_12137 var4,
      class_12137 var5,
      class_12137 var6,
      class_12137 var7,
      GpuBufferSlice var8,
      GpuBufferSlice var9
   ) {
      var1.setVertexBuffer(0, renderSupport47.v1(this.v3));

      for (int var10 = 0; var10 < 6; var10++) {
         var1.bindTexture(v19[var10], var2[var10], var4);
      }

      var1.bindTexture("Sampler1", var3, var5);
      var1.bindTexture("Sampler2", renderSupport47.v1(this.v48), var5);
      var1.bindTexture("Sampler3", renderSupport47.v1(this.v44), var6);
      var1.bindTexture("Sampler10", renderSupport47.v1(this.v49), var4);
      var1.bindTexture("Sampler11", renderSupport47.v1(this.v50), var7);
      var1.setUniform("WetParams", var8);
      var1.setUniform("Fog", var9);
   }

   public void v1(cloudRecord4 var1, GpuTextureView var2, GpuTextureView var3, GpuTextureView var4) {
      if (this.v29) {
         this.v29 = false;
         class_310 var5 = this.v7.v1();
         if (var5 != null && var5.method_1522() != null) {
            class_276 var6 = var5.method_1522();
            GpuBufferSlice var7 = RenderSystem.getShaderFog();
            if (var7 != null && var6.field_1482 == this.v60 && var6.field_1481 == this.v59) {
               CommandEncoder var8 = RenderSystem.getDevice().createCommandEncoder();
               this.v1(var8, var1, this.v60, this.v59);
               GpuTextureView var9 = this.v8();
               RenderPass var10 = var8.createRenderPass(
                  () -> "syky:wet_surfaces_water_gate", ((GpuTextureView[])renderSupport47.v1(this.v23))[0], OptionalInt.empty(), var9, OptionalDouble.of(1.0)
               );

               try {
                  var10.setPipeline(v24);
                  var10.setVertexBuffer(0, renderSupport47.v1(this.v3));
                  class_12137 var11 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
                  var10.bindTexture("Sampler0", var2, var11);
                  var10.bindTexture("Sampler1", var3, var11);
                  var10.draw(0, 6);
               } catch (Throwable var14) {
                  if (var10 != null) {
                     try {
                        var10.close();
                     } catch (Throwable var13) {
                        var14.addSuppressed(var13);
                     }
                  }

                  throw var14;
               }

               if (var10 != null) {
                  var10.close();
               }

               this.v1(var8, v22, var4, var3, var9, var7);
            }
         }
      }
   }

   private GpuTextureView v8() {
      GpuTextureView var1 = this.v31;
      if (var1 != null) {
         return var1;
      } else {
         GpuDevice var2 = RenderSystem.getDevice();
         GpuTexture var3 = var2.createTexture(() -> "syky:wet_surfaces_water_gate", 12, TextureFormat.DEPTH32, this.v60, this.v59, 1, 1);
         this.v33 = var3;
         var1 = var2.createTextureView(var3);
         this.v31 = var1;
         return var1;
      }
   }

   public void v1(cloudRecord4 var1, GpuTextureView var2) {
      if (this.v30) {
         this.v30 = false;
         class_310 var3 = this.v7.v1();
         if (var3 != null && var3.method_1522() != null) {
            class_276 var4 = var3.method_1522();
            GpuTextureView var5 = var4.method_71639();
            GpuTextureView var6 = var4.method_71640();
            GpuBufferSlice var7 = RenderSystem.getShaderFog();
            if (var5 != null && var6 != null && var7 != null && var4.field_1482 == this.v60 && var4.field_1481 == this.v59) {
               CommandEncoder var8 = RenderSystem.getDevice().createCommandEncoder();
               this.v1(var8, var1, this.v60, this.v59);
               GpuTextureView[] var9 = renderSupport47.v1(this.v23);
               class_12137 var10 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
               class_12137 var11 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
               class_12137 var12 = RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR);
               class_12137 var13 = RenderSystem.getSamplerCache().method_76521(FilterMode.LINEAR, true);
               GpuTextureView var14 = this.v1(var2.getWidth(0), var2.getHeight(0));
               RenderPass var15 = var8.createRenderPass(() -> "syky:wet_surfaces_mirror", var14, OptionalInt.empty());

               try {
                  var15.setPipeline(v25);
                  this.v1(var15, var9, var6, var10, var11, var12, var13, renderSupport31.v1(renderSupport47.v1(this.v2)), var7);
                  var15.bindTexture("Sampler4", var2, var11);
                  var15.draw(0, 6);
               } catch (Throwable var21) {
                  if (var15 != null) {
                     try {
                        var15.close();
                     } catch (Throwable var19) {
                        var21.addSuppressed(var19);
                     }
                  }

                  throw var21;
               }

               if (var15 != null) {
                  var15.close();
               }

               var15 = var8.createRenderPass(() -> "syky:wet_surfaces_mirror_add", var5, OptionalInt.empty());

               try {
                  var15.setPipeline(v26);
                  var15.setVertexBuffer(0, renderSupport47.v1(this.v3));
                  var15.bindTexture("Sampler0", var14, var10);
                  var15.draw(0, 6);
               } catch (Throwable var20) {
                  if (var15 != null) {
                     try {
                        var15.close();
                     } catch (Throwable var18) {
                        var20.addSuppressed(var18);
                     }
                  }

                  throw var20;
               }

               if (var15 != null) {
                  var15.close();
               }
            }
         }
      }
   }

   private GpuTextureView v1(int var1, int var2) {
      GpuTextureView var3 = this.v28;
      if (var3 != null && var3.getWidth(0) == var1 && var3.getHeight(0) == var2) {
         return var3;
      } else {
         this.v9();
         GpuDevice var4 = RenderSystem.getDevice();
         GpuTexture var5 = var4.createTexture(() -> "syky:wet_surfaces_mirror_lit", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v27 = var5;
         var3 = var4.createTextureView(var5);
         this.v28 = var3;
         return var3;
      }
   }

   private void v9() {
      if (this.v28 != null) {
         this.v28.close();
         this.v28 = null;
      }

      if (this.v27 != null) {
         this.v27.close();
         this.v27 = null;
      }
   }

   private void v1(CommandEncoder var1, cloudRecord4 var2, int var3, int var4) {
      ByteBuffer var5 = renderSupport47.v1(this.v1);
      var5.clear();
      var2.v1().get(0, var5);
      var2.v2().get(64, var5);
      var5.position(128);
      var5.putFloat(var2.v3()).putFloat(var2.v5()).putFloat(var2.v4()).putFloat(var2.v6());
      var5.putFloat(var2.v7()).putFloat(var2.v8()).putFloat(var2.v9()).putFloat(var2.v10());
      var5.putFloat(var2.v11()).putFloat(var2.v12()).putFloat(var2.v13()).putFloat(var2.v29() ? 1.0F : 0.0F);
      var5.putFloat(var2.v14()).putFloat(var2.v15()).putFloat(var2.v16() ? 1.0F : 0.0F).putFloat(var2.v18());
      var5.putFloat(var2.v19()).putFloat(var2.v17()).putFloat(var2.v20()).putFloat(var2.v21() * 0.5F * var4);
      var5.putFloat(this.v38).putFloat(this.v42).putFloat(1.0F / this.v38).putFloat(1.0F / this.v42);
      var5.putFloat(var3).putFloat(var4).putFloat(1.0F / var3).putFloat(1.0F / var4);
      v1(var5, var2.v22());
      var5.putFloat(6.0F);
      v1(var5, var2.v24());
      var5.putFloat((var2.v24() >>> 24 & 0xFF) / 255.0F);
      var5.putFloat(var2.v25()).putFloat(var2.v26()).putFloat(var2.v27()).putFloat(var2.v28() ? 1.0F : 0.0F);
      var5.flip();
      var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v2)), var5);
   }

   private static void v1(ByteBuffer var0, int var1) {
      var0.putFloat((var1 >> 16 & 0xFF) / 255.0F).putFloat((var1 >> 8 & 0xFF) / 255.0F).putFloat((var1 & 0xFF) / 255.0F);
   }

   private void v10() {
      if (this.v37 == null) {
         GpuDevice var1 = RenderSystem.getDevice();
         byte var2 = 13;
         this.v37 = var1.createTexture(() -> "syky:wet_surfaces_columns", var2, TextureFormat.RGBA8, 512, 512, 1, 1);
         this.v48 = var1.createTextureView(this.v37);
         this.v40 = var1.createTexture(() -> "syky:wet_surfaces_shelter", var2, TextureFormat.RGBA8, 512, 512, 1, 1);
         this.v44 = var1.createTextureView(this.v40);
         this.v7();
      }
   }

   private void v11() {
      if (this.v51 == null) {
         GpuDevice var1 = RenderSystem.getDevice();
         this.v51 = var1.createTexture(() -> "syky:wet_surfaces_noise", 5, TextureFormat.RGBA8, 256, 256, 1, cloudSupport23.v2);
         this.v50 = var1.createTextureView(this.v51);
         CommandEncoder var2 = var1.createCommandEncoder();
         ByteBuffer var3 = cloudSupport23.v1();
         int var4 = 0;

         for (short var5 = 256; var4 < cloudSupport23.v2; var5 /= 2) {
            var2.writeToTexture(this.v51, var3, class_1012.field_4997, var4, 0, 0, 0, var5, var5);
            if (var5 > 1) {
               var3 = cloudSupport23.v1(var3, var5);
            }

            var4++;
         }
      }
   }

   private void v12() {
      if (this.v47 == null) {
         GpuDevice var1 = RenderSystem.getDevice();
         this.v47 = var1.createTexture(() -> "syky:wet_surfaces_ripples", 13, TextureFormat.RGBA8, 1134, 1134, 1, 1);
         this.v49 = var1.createTextureView(this.v47);
         var1.createCommandEncoder().clearColorTexture(this.v47, -2139062144);
         this.v46 = CompletableFuture.supplyAsync(cloudSupport24::v1, var0 -> {
            Thread var1x = new Thread(var0, "syky-ripple-bake");
            var1x.setDaemon(true);
            var1x.start();
         });
      }

      CompletableFuture var2 = this.v46;
      if (var2 != null && var2.isDone()) {
         this.v46 = null;
         RenderSystem.getDevice().createCommandEncoder().writeToTexture(this.v47, (ByteBuffer)var2.join(), class_1012.field_4997, 0, 0, 0, 0, 1134, 1134);
      }
   }

   private void v1(int var1, int var2, float var3) {
      if (this.v32 == null || this.v60 != var1 || this.v59 != var2 || this.v43 != var3) {
         this.v13();
         GpuDevice var4 = RenderSystem.getDevice();
         GpuTexture[] var5 = new GpuTexture[6];
         GpuTextureView[] var6 = new GpuTextureView[6];

         for (int var7 = 0; var7 < 6; var7++) {
            int var8 = Math.max(1, var1 >> var7);
            int var9 = Math.max(1, var2 >> var7);
            byte var10 = 12;
            var5[var7] = var4.createTexture(() -> "syky:wet_surfaces_pyramid", var10, TextureFormat.RGBA8, var8, var9, 1, 1);
            var6[var7] = var4.createTextureView(var5[var7]);
         }

         this.v32 = var5;
         this.v23 = var6;
         this.v38 = Math.max(1, Math.round(var1 * var3));
         this.v42 = Math.max(1, Math.round(var2 * var3));
         this.v34 = var4.createTexture(() -> "syky:wet_surfaces_trace", 12, TextureFormat.RGBA8, this.v38, this.v42, 1, 1);
         this.v36 = var4.createTextureView(this.v34);
         this.v60 = var1;
         this.v59 = var2;
         this.v43 = var3;
      }
   }

   @Override
   public void v5() {
      this.v13();
      this.v9();
      this.v29 = false;
      this.v30 = false;
   }

   @Override
   public void v6() {
      this.v13();
      this.v9();
      if (this.v48 != null) {
         this.v48.close();
         this.v48 = null;
      }

      if (this.v37 != null) {
         this.v37.close();
         this.v37 = null;
      }

      if (this.v44 != null) {
         this.v44.close();
         this.v44 = null;
      }

      if (this.v50 != null) {
         this.v50.close();
         this.v50 = null;
      }

      if (this.v49 != null) {
         this.v49.close();
         this.v49 = null;
      }

      if (this.v47 != null) {
         this.v47.close();
         this.v47 = null;
      }

      this.v46 = null;
      if (this.v51 != null) {
         this.v51.close();
         this.v51 = null;
      }

      if (this.v40 != null) {
         this.v40.close();
         this.v40 = null;
      }
   }

   private void v13() {
      if (this.v23 != null) {
         for (GpuTextureView var4 : this.v23) {
            var4.close();
         }

         this.v23 = null;
      }

      if (this.v32 != null) {
         for (GpuTexture var8 : this.v32) {
            var8.close();
         }

         this.v32 = null;
      }

      if (this.v36 != null) {
         this.v36.close();
         this.v36 = null;
      }

      if (this.v31 != null) {
         this.v31.close();
         this.v31 = null;
      }

      if (this.v33 != null) {
         this.v33.close();
         this.v33 = null;
      }

      if (this.v34 != null) {
         this.v34.close();
         this.v34 = null;
      }

      this.v60 = 0;
      this.v59 = 0;
      this.v43 = 0.0F;
   }
}
