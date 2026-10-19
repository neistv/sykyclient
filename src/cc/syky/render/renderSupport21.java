package cc.syky.render;

import cc.syky.cloud.cloudSupport27;
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
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class renderSupport21 extends renderSupport36 {
   private static final int v5 = 144;
   private static final class_2960 v6 = class_2960.method_60655("syky", "core/layer/layer_transform");
   private static final class_2960 v7 = class_2960.method_60655("syky", "pipeline/layer_transform_x");
   private static final class_2960 v8 = class_2960.method_60655("syky", "pipeline/layer_transform");
   private static final float v9 = 0.35F;
   private static final float v10 = 19.0F;
   private static final RenderPipeline v11 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v7)
         .withVertexShader(v6)
         .withFragmentShader(v6)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("TransformData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v12 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v8)
         .withVertexShader(v6)
         .withFragmentShader(v6)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("TransformData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final renderSupport20 v13 = new renderSupport20("syky:layer_transform_scratch", true);

   public renderSupport21() {
      super("layer_transform", 144);
   }

   public boolean v1(
      class_310 var1,
      @Nullable GpuTextureView var2,
      int var3,
      int var4,
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
      float var15
   ) {
      return this.v1(
         var1,
         var2,
         var3,
         var4,
         var5,
         var6,
         var7,
         var8,
         var9,
         var10,
         var11,
         var12,
         var13,
         var14,
         var15,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F
      );
   }

   public boolean v1(
      class_310 var1,
      @Nullable GpuTextureView var2,
      int var3,
      int var4,
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
      float var17,
      float var18,
      float var19,
      float var20,
      float var21,
      float var22,
      float var23,
      float var24,
      float var25,
      float var26,
      float var27
   ) {
      return this.v1(
         var1,
         var2,
         var5,
         var6,
         var3,
         var4,
         var5,
         var6,
         var5 + var3,
         var6 + var4,
         var7,
         var8,
         var9,
         var10,
         var11,
         var12,
         var13,
         var14,
         var15,
         var16,
         var17,
         var18,
         var19,
         var20,
         var21,
         var22,
         var23,
         var24,
         var25,
         var26,
         var27
      );
   }

   public boolean v1(
      class_310 var1,
      @Nullable GpuTextureView var2,
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
      float var17,
      float var18,
      float var19
   ) {
      return this.v1(
         var1,
         var2,
         var3,
         var4,
         var5,
         var6,
         var7,
         var8,
         var9,
         var10,
         var11,
         var12,
         var13,
         var14,
         var15,
         var16,
         var17,
         var18,
         var19,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F
      );
   }

   public boolean v1(
      class_310 var1,
      @Nullable GpuTextureView var2,
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
      float var17,
      float var18,
      float var19,
      float var20,
      float var21,
      float var22,
      float var23,
      float var24,
      float var25,
      float var26,
      float var27,
      float var28,
      float var29,
      float var30,
      float var31
   ) {
      if (var2 == null || !(var5 > 0.0F) || !(var6 > 0.0F) || var1.method_1522() == null) {
         return false;
      } else if (var14 > 0.0F && var15 > 0.0F) {
         this.v2();
         if (this.v1 != null && this.v2 != null) {
            int var32 = var1.method_1522().field_1482;
            int var33 = var1.method_1522().field_1481;
            int var34 = cloudSupport27.v4() ? cloudSupport27.v5() : 0;
            int var35 = cloudSupport27.v4() ? cloudSupport27.v6() : 0;
            int var36 = cloudSupport27.v4() ? cloudSupport27.v7() : var32;
            int var37 = cloudSupport27.v4() ? cloudSupport27.v8() : var33;
            if (var36 > 0 && var37 > 0) {
               float var38 = Math.min(var16, 19.0F);
               boolean var39 = var38 >= 0.35F && this.v13.v1(var36, var37);
               if (var39) {
                  this.v4();
               }

               CommandEncoder var40 = RenderSystem.getDevice().createCommandEncoder();
               class_12137 var41 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
               GpuTextureView var42 = var1.method_1522().method_71640();
               float var43 = Math.max(var7, var3 + 1.0F);
               float var44 = Math.max(var8, var4 + 1.0F);
               float var45 = Math.min(var9, var3 + var5 - 1.0F);
               float var46 = Math.min(var10, var4 + var6 - 1.0F);
               if (!var39) {
                  ByteBuffer var49 = this.v3();
                  v1(var49, 1.0F, 1.0F, 0.0F, 0.0F);
                  v1(var49, var12, var13, 1.0F / var14, 1.0F / var15);
                  v1(var49, var3, var4, var5, var6);
                  v1(var49, 0.0F, 0.0F, 0.0F, var11);
                  v1(var49, var43, var44, var45, var46);
                  v1(var49, 1.0F, var17, var18, var19);
                  v1(var49, var20, var21, var22, var23);
                  v1(var49, var24, var25, var26, var27);
                  v1(var49, var28, var29, var30, var31);
                  this.v1(var40, var49);
                  this.v1(var40, v12, renderSupport30.v1(var1), var42, var2, var41, true);
                  return true;
               } else {
                  ByteBuffer var47 = this.v3();
                  v1(var47, (float)var36 / this.v13.v2(), (float)var37 / this.v13.v3(), var34, var35);
                  v1(var47, var12, var13, 1.0F / var14, 1.0F / var15);
                  v1(var47, var3, var4, var5, var6);
                  v1(var47, 1.0F, 0.0F, var38, 1.0F);
                  v1(var47, var43, var44, var45, var46);
                  v1(var47, 0.0F, var17, var18, 1.0F);
                  v1(var47, 0.0F, 0.0F, 0.0F, 0.0F);
                  v1(var47, 0.0F, 0.0F, 0.0F, 0.0F);
                  v1(var47, 0.0F, 0.0F, 0.0F, 0.0F);
                  this.v1(var40, var47);
                  this.v1(var40, v11, this.v13.v1(), null, var2, var41, false);
                  var47 = this.v3();
                  v1(var47, 1.0F, 1.0F, 0.0F, 0.0F);
                  v1(var47, 0.0F, 0.0F, 1.0F, 1.0F);
                  v1(var47, var34, var35, this.v13.v2(), this.v13.v3());
                  v1(var47, 0.0F, 1.0F, var38, var11);
                  v1(var47, var34 + 1.0F, var35 + 1.0F, var34 + var36 - 1.0F, var35 + var37 - 1.0F);
                  v1(var47, 1.0F, var17, var18, var19);
                  v1(var47, var20, var21, var22, var23);
                  v1(var47, var24, var25, var26, var27);
                  v1(var47, var28, var29, var30, var31);
                  this.v1(var40, var47);
                  this.v1(var40, v12, renderSupport30.v1(var1), var42, this.v13.v1(), var41, true);
                  return true;
               }
            } else {
               return true;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void v1(
      CommandEncoder var1,
      RenderPipeline var2,
      @Nullable GpuTextureView var3,
      @Nullable GpuTextureView var4,
      @Nullable GpuTextureView var5,
      class_12137 var6,
      boolean var7
   ) {
      RenderPass var8 = this.v1(var1, var3, var4);

      try {
         var8.setPipeline(var2);
         if (var7) {
            cloudSupport27.v1(var8);
         }

         var8.setVertexBuffer(0, this.v3);
         var8.bindTexture("Sampler0", var5, var6);
         var8.setUniform("TransformData", renderSupport31.v1(renderSupport47.v1(this.v2)));
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

   @Override
   public void v5() {
      this.v13.close();
   }

   @Override
   public void v6() {
      this.v13.close();
   }
}
