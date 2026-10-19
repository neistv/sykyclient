package cc.syky.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
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
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_10799;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class renderSupport10 implements AutoCloseable {
   public static final class_2960 v1 = class_2960.method_60655("syky", "dynamic/translucent_cover");
   public static final class_2960 v2 = class_2960.method_60655("syky", "dynamic/translucent_cover_front");
   private static final class_2960 v4 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v5 = class_2960.method_60655("syky", "core/util/cover_alpha");
   public static boolean v3 = true;
   private static final RenderPipeline v6 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/cover_alpha_clear"))
         .withVertexShader(v4)
         .withFragmentShader(v5)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withColorWrite(false, true)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v7 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/cover_copy"))
         .withVertexShader(v4)
         .withFragmentShader(class_2960.method_60655("syky", "core/util/cover_copy"))
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v8 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/depth_copy_half"))
         .withVertexShader(v4)
         .withFragmentShader(class_2960.method_60655("syky", "core/util/depth_copy_half"))
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("Sampler0")
         .withColorWrite(false)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .build()
   );
   private final renderSupport10.Part2 v9 = new renderSupport10.Part2();
   private final renderSupport10.Part2 v10 = new renderSupport10.Part2();
   private final renderSupport32 v11 = new renderSupport32();
   private renderSupport10.Part1 v12 = renderSupport10.Part1.NONE;
   @Nullable
   private class_276 v13;
   @Nullable
   private renderSupport10.Part4 v14;
   private boolean v15;
   private boolean v16;
   @Nullable
   private GpuTexture v18;
   @Nullable
   private GpuTextureView v19;
   @Nullable
   private GpuTexture v17;
   @Nullable
   private GpuTextureView v20;
   private boolean v21;
   @Nullable
   private GpuTexture v22;
   @Nullable
   private GpuTextureView v24;
   @Nullable
   private GpuBuffer v25;

   public renderSupport10() {
   }

   public void v1() {
      this.v12 = renderSupport10.Part1.NONE;
      this.v13 = null;
      this.v14 = null;
      this.v15 = false;
      this.v21 = false;
      this.v1(null);
   }

   public void v1(class_276 var1, @Nullable class_276 var2, boolean var3) {
      if (var2 != null) {
         this.v13 = var2;
         this.v12 = renderSupport10.Part1.TRANSLUCENT_TARGET;
      } else {
         GpuTextureView var4 = var1.method_71639();
         if (var4 != null) {
            CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
            this.v1(var5, v6, var4);
            this.v12 = renderSupport10.Part1.MAIN_ALPHA;
            GpuTextureView var6 = var1.method_71640();
            if (var3 && var6 != null) {
               int var7 = (var1.field_1482 + 1) / 2;
               int var8 = (var1.field_1481 + 1) / 2;
               GpuTextureView var9 = this.v1(var7, var8);
               GpuTextureView var10 = this.v2(var7, var8);
               RenderPass var11 = var5.createRenderPass(() -> "syky:translucent_cover_back", var9, OptionalInt.empty(), var10, OptionalDouble.of(1.0));

               try {
                  var11.setPipeline(v8);
                  var11.setVertexBuffer(0, this.v5());
                  var11.bindTexture("Sampler0", var6, RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false));
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

               this.v21 = true;
            }
         }
      }
   }

   public void v1(class_276 var1, @Nullable GpuTextureView var2) {
      if (!this.v15) {
         this.v15 = true;
         GpuTextureView var3 = var1.method_71639();
         GpuTextureView var4 = var1.method_71640();
         if (var3 == null || var4 == null) {
            this.v12 = renderSupport10.Part1.NONE;
         }

         GpuTextureView var5 = var2 != null ? var2 : (this.v21 ? this.v20 : null);
         switch (this.v12) {
            case NONE:
            default:
               break;
            case MAIN_ALPHA:
               if (var5 != null) {
                  GpuTextureView var13 = this.v1((var1.field_1482 + 1) / 2, (var1.field_1481 + 1) / 2);
                  CommandEncoder var7 = RenderSystem.getDevice().createCommandEncoder();
                  RenderPass var8 = var7.createRenderPass(() -> "syky:translucent_cover_copy", var13, OptionalInt.empty());

                  try {
                     var8.setPipeline(v7);
                     var8.setVertexBuffer(0, this.v5());
                     var8.bindTexture("Sampler0", var3, RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false));
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

                  this.v11.v1();
                  this.v14 = new renderSupport10.Part4(var13, var4, var5);
               }
               break;
            case TRANSLUCENT_TARGET:
               class_276 var6 = this.v13;
               if (var6 != null
                  && var6.field_1482 == var1.field_1482
                  && var6.field_1481 == var1.field_1481
                  && var6.method_71639() != null
                  && var6.method_71640() != null) {
                  this.v14 = new renderSupport10.Part4(var6.method_71639(), var6.method_71640(), var4);
               }
         }

         this.v1(this.v14);
      }
   }

   @Nullable
   public renderSupport10.Part3 v1(class_276 var1) {
      return switch (this.v12) {
         case NONE -> null;
         case MAIN_ALPHA -> {
            GpuTextureView var4 = var1.method_71639();
            GpuTextureView var3 = var1.method_71640();
            yield var4 != null && var3 != null ? new renderSupport10.Part3(var4, var3) : null;
         }
         case TRANSLUCENT_TARGET -> {
            class_276 var2 = this.v13;
            yield var2 != null
                  && var2.field_1482 == var1.field_1482
                  && var2.field_1481 == var1.field_1481
                  && var2.method_71639() != null
                  && var2.method_71640() != null
               ? new renderSupport10.Part3(var2.method_71639(), var2.method_71640())
               : null;
         }
      };
   }

   @Nullable
   public renderSupport10.Part4 v2() {
      return this.v14;
   }

   public renderSupport10.Part4 v3() {
      GpuTextureView var1 = this.v24;
      if (var1 == null) {
         GpuDevice var2 = RenderSystem.getDevice();
         GpuTexture var3 = var2.createTexture(() -> "syky:translucent_cover_none", 12, TextureFormat.RGBA8, 1, 1, 1, 1);
         var2.createCommandEncoder().clearColorTexture(var3, 0);
         this.v22 = var3;
         var1 = var2.createTextureView(var3);
         this.v24 = var1;
      }

      return new renderSupport10.Part4(var1, var1, var1);
   }

   public void v1(@Nullable renderSupport10.Part4 var1) {
      renderSupport10.Part4 var2 = var1 != null ? var1 : this.v3();
      if (!this.v16) {
         this.v16 = true;
         class_1060 var3 = class_310.method_1551().method_1531();
         var3.method_4616(v1, this.v9);
         var3.method_4616(v2, this.v10);
      }

      this.v9.v1(var2.v1().texture(), var2.v1());
      this.v10.v1(var2.v2().texture(), var2.v2());
   }

   public void v1(long var1) {
      if (this.v11.v1(var1)) {
         this.v6();
      }
   }

   private GpuTextureView v1(int var1, int var2) {
      GpuTextureView var3 = this.v19;
      GpuTexture var4 = this.v18;
      if (var3 != null && var4 != null && var4.getWidth(0) == var1 && var4.getHeight(0) == var2) {
         return var3;
      } else {
         this.v6();
         GpuDevice var5 = RenderSystem.getDevice();
         var4 = var5.createTexture(() -> "syky:translucent_cover", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v18 = var4;
         var3 = var5.createTextureView(var4);
         this.v19 = var3;
         return var3;
      }
   }

   private GpuTextureView v2(int var1, int var2) {
      GpuTextureView var3 = this.v20;
      GpuTexture var4 = this.v17;
      if (var3 != null && var4 != null && var4.getWidth(0) == var1 && var4.getHeight(0) == var2) {
         return var3;
      } else {
         this.v4();
         GpuDevice var5 = RenderSystem.getDevice();
         var4 = var5.createTexture(() -> "syky:translucent_cover_back", 12, TextureFormat.DEPTH32, var1, var2, 1, 1);
         this.v17 = var4;
         var3 = var5.createTextureView(var4);
         this.v20 = var3;
         return var3;
      }
   }

   private void v4() {
      if (this.v20 != null) {
         this.v20.close();
         this.v20 = null;
      }

      if (this.v17 != null) {
         this.v17.close();
         this.v17 = null;
      }

      this.v21 = false;
   }

   private GpuBuffer v5() {
      GpuBuffer var1 = this.v25;
      if (var1 == null) {
         var1 = renderSupport31.v1("syky:translucent_cover_dummy_vertex");
         this.v25 = var1;
      }

      return var1;
   }

   private void v1(CommandEncoder var1, RenderPipeline var2, GpuTextureView var3) {
      RenderPass var4 = var1.createRenderPass(() -> "syky:translucent_cover_alpha", var3, OptionalInt.empty());

      try {
         var4.setPipeline(var2);
         var4.setVertexBuffer(0, this.v5());
         var4.draw(0, 6);
      } catch (Throwable var8) {
         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var7) {
               var8.addSuppressed(var7);
            }
         }

         throw var8;
      }

      if (var4 != null) {
         var4.close();
      }
   }

   private void v6() {
      this.v4();
      if (this.v19 != null) {
         this.v19.close();
         this.v19 = null;
      }

      if (this.v18 != null) {
         this.v18.close();
         this.v18 = null;
      }
   }

   @Override
   public void close() {
      this.v6();
      if (this.v24 != null) {
         this.v24.close();
         this.v24 = null;
      }

      if (this.v22 != null) {
         this.v22.close();
         this.v22 = null;
      }

      if (this.v25 != null) {
         this.v25.close();
         this.v25 = null;
      }

      this.v9.close();
      this.v10.close();
   }

   public static enum Part1 {
      NONE,
      MAIN_ALPHA,
      TRANSLUCENT_TARGET;

      private Part1() {
      }
   }

   public static final class Part2 extends class_1044 {
      public Part2() {
      }

      public void v1(GpuTexture var1, GpuTextureView var2) {
         this.field_56974 = var1;
         this.field_60597 = var2;
         this.field_63613 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
      }

      public void close() {
         this.field_56974 = null;
         this.field_60597 = null;
      }
   }

   public record Part3(GpuTextureView coverage, GpuTextureView depth) {
      public GpuTextureView v1() {
         return this.coverage;
      }

      public GpuTextureView v2() {
         return this.depth;
      }
   }

   public record Part4(GpuTextureView cover, GpuTextureView front, GpuTextureView back) {
      public GpuTextureView v1() {
         return this.cover;
      }

      public GpuTextureView v2() {
         return this.front;
      }

      public GpuTextureView v3() {
         return this.back;
      }
   }
}
