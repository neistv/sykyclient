package cc.syky.ui;

import cc.syky.cloud.cloudSupport101;
import cc.syky.render.renderSupport23;
import cc.syky.render.renderSupport33;
import cc.syky.render.renderSupport37;
import cc.syky.render.renderSupport44;
import cc.syky.render.renderSupport47;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import net.minecraft.class_1044;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class uiSupport159 extends renderSupport37 {
   private static final class_2960 v12 = class_2960.method_60655("syky", "pipeline/texture");
   private static final class_2960 v13 = class_2960.method_60655("syky", "core/gui/texture");
   private static final class_2960 v14 = class_2960.method_60655("syky", "pipeline/vibrant_texture");
   private static final class_2960 v15 = class_2960.method_60655("syky", "core/vibrant/vibrant_texture");
   private static final class_2960 v16 = class_2960.method_60655("syky", "pipeline/texture_pixelart");
   private static final class_2960 v18 = class_2960.method_60655("syky", "core/gui/texture_pixelart");
   private static final class_2960 v19 = class_2960.method_60655("syky", "pipeline/texture_premult");
   private static final class_2960 v17 = class_2960.method_60655("syky", "core/gui/texture_premult");
   private static final int v20 = 128;
   private static final RenderPipeline v21 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v12)
         .withVertexShader(v13)
         .withFragmentShader(v13)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("TextureData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v22 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v14)
         .withVertexShader(v15)
         .withFragmentShader(v15)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("TextureData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v24 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v16)
         .withVertexShader(v18)
         .withFragmentShader(v18)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("TextureData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v25 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v19)
         .withVertexShader(v17)
         .withFragmentShader(v17)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("TextureData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final renderSupport23 v26 = new renderSupport23();
   @Nullable
   private uiSupport160 v27;
   private boolean v28;
   public static final int v10 = 80;
   public static final int v11 = 16320;

   public uiSupport159(cloudSupport101 var1, renderSupport44 var2) {
      super(var1, var2, 128);
   }

   private void v1(GpuTextureView var1, RenderPipeline var2, @Nullable GpuTextureView var3) {
      this.v1(var2, "TextureData", var1, var3, 80, 16320);
   }

   public void v1(
      class_2960 var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, 0.0F, v21, null);
   }

   public void v1(
      class_2960 var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14,
      GpuTextureView var15
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, 0.0F, v22, var15);
   }

   public void v1(
      class_2960 var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      GpuTextureView var16
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, v22, var16);
   }

   public void v1(
      class_2960 var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, v21, null);
   }

   public void v2(
      class_2960 var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, 0.0F, v24, null);
   }

   public void v1(GpuTextureView var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, -1);
   }

   public void v1(GpuTextureView var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10) {
      if (var1 != null) {
         var2 += renderSupport33.v2();
         var3 += renderSupport33.v3();
         class_310 var11 = this.v1(var2, var3, var4, var5, 0.0F);
         if (var11 != null) {
            this.v1();
            v1(renderSupport47.v1(this.v3), var2, var3, var4, var5, this.v6, this.v7, this.v5, var6, var7, var8, var9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var10);
            this.v1(v25, "TextureData", var1, null, 80, 16320);
         }
      }
   }

   private void v1(
      class_2960 var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      RenderPipeline var16,
      @Nullable GpuTextureView var17
   ) {
      var2 += renderSupport33.v2();
      var3 += renderSupport33.v3();
      class_310 var18 = this.v1(var2, var3, var4, var5, var11 + var12 + var13 + var14);
      if (var18 != null) {
         float var20 = var6;
         float var21 = var7;
         float var22 = var8;
         float var23 = var9;
         uiSupport160.Part1 var24 = var16 == v24 ? null : this.v1(var18, var1);
         GpuTextureView var19;
         if (var24 != null) {
            var19 = renderSupport47.v1(this.v27).v1();
            var20 = var24.v1() + var6 * (var24.v3() - var24.v1());
            var21 = var24.v2() + var7 * (var24.v4() - var24.v2());
            var22 = var24.v1() + var8 * (var24.v3() - var24.v1());
            var23 = var24.v2() + var9 * (var24.v4() - var24.v2());
         } else {
            class_1044 var25 = var18.method_1531().method_4619(var1);
            if (var25 == null) {
               return;
            }

            GpuTexture var26 = var25.method_68004();
            if (var26 == null) {
               return;
            }

            var19 = this.v26.v1(var26);
         }

         this.v1();
         v1(
            renderSupport47.v1(this.v3),
            var2,
            var3,
            var4,
            var5,
            this.v6,
            this.v7,
            this.v5,
            var20,
            var21,
            var22,
            var23,
            var11,
            var12,
            var13,
            var14,
            var15,
            var10
         );
         this.v1(var19, var16, var17);
      }
   }

   @Nullable
   private uiSupport160.Part1 v1(class_310 var1, class_2960 var2) {
      if (this.v27 == null) {
         if (this.v28) {
            return null;
         }

         this.v28 = true;
         this.v27 = uiSupport160.v1(var1);
         if (this.v27 == null) {
            return null;
         }
      } else if (this.v27.v2()) {
         this.v27.close();
         this.v27 = null;
         this.v28 = false;
         return null;
      }

      return this.v27.v1(var2);
   }

   public static void v1(
      ByteBuffer var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      int var17
   ) {
      var0.clear();
      var0.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
      var0.putFloat(var5).putFloat(var6).putFloat(var7).putFloat(var16);
      var0.putFloat(var8).putFloat(var9).putFloat(var10).putFloat(var11);
      var0.putFloat(var12).putFloat(var13).putFloat(var14).putFloat(var15);
      uiSupport155.v1(var0, var17);
      var0.flip();
   }

   @Override
   public void close() {
      super.close();
      this.v26.close();
      if (this.v27 != null) {
         this.v27.close();
         this.v27 = null;
         this.v28 = false;
      }
   }
}
