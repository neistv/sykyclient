package cc.syky.render;

import cc.syky.cloud.cloudSupport27;
import cc.syky.ui.uiSupport157;
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

public final class VeilDataSupport extends renderSupport36 {
   private static final int v7 = 144;
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/layer/layer_veil");
   private static final class_2960 v9 = class_2960.method_60655("syky", "pipeline/layer_veil_x");
   private static final class_2960 v10 = class_2960.method_60655("syky", "pipeline/layer_veil");
   private static final float v11 = 0.35F;
   private static final float v12 = 23.0F;
   private static final RenderPipeline v13 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v9)
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("VeilData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v14 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v10)
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("VeilData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final renderSupport20 v15 = new renderSupport20("syky:layer_veil_scratch", false);
   private final byte[] v16 = new byte[144];
   private int v18 = -1;
   @Nullable
   private GpuTextureView v19;
   private long v17;
   public static long v5;
   public static long v6;

   public VeilDataSupport() {
      super("layer_veil", 144);
   }

   public boolean v1(class_310 var1, @Nullable GpuTextureView var2, int var3, int var4, float var5, uiSupport157 var6, long var7) {
      float var9 = var6.v1;
      float var10 = var6.v2;
      float var11 = var6.v3;
      float var12 = var6.v4;
      float var13 = var6.v5;
      float var14 = var6.v6;
      float var15 = var6.v7;
      float var16 = var6.v8;
      float var17 = var6.v9;
      float var18 = var6.v10;
      float var19 = var6.v11;
      float var20 = var6.v12;
      float var21 = var6.v13;
      float var22 = var6.v14;
      float var23 = var6.v15;
      float var24 = var6.v16;
      if (var2 == null || var3 <= 0 || var4 <= 0 || var1.method_1522() == null) {
         return false;
      } else if (!(var12 <= 0.0F) && !(var13 <= 0.0F)) {
         this.v2();
         if (this.v1 != null && this.v2 != null) {
            int var25 = cloudSupport27.v4() ? cloudSupport27.v5() : 0;
            int var26 = cloudSupport27.v4() ? cloudSupport27.v6() : 0;
            int var27 = cloudSupport27.v4() ? cloudSupport27.v7() : var3;
            int var28 = cloudSupport27.v4() ? cloudSupport27.v8() : var4;
            if (var27 > 0 && var28 > 0) {
               float var29 = Math.min(var9, 23.0F);
               int var30 = Math.max(var26, (int)Math.floor(var18 - 2.0F * var29) - 1);
               int var31 = var26 + var28 - var30;
               boolean var32 = var29 >= 0.35F && var31 > 0 && this.v1(var27, var31);
               if (var32) {
                  this.v4();
               }

               CommandEncoder var33 = RenderSystem.getDevice().createCommandEncoder();
               class_12137 var34 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
               GpuTextureView var35 = var1.method_1522().method_71640();
               float var36 = 0.5F;
               float var37 = 0.5F;
               float var38 = var3 - 0.5F;
               float var39 = var4 - 0.5F;
               if (var32) {
                  ByteBuffer var40 = this.v3();
                  v1(var40, (float)var27 / this.v15.v2(), (float)var31 / this.v15.v3(), var25, var30);
                  v1(var40, 0.0F, 0.0F, var3, var4);
                  v1(var40, 1.0F, 0.0F, var29, 1.0F);
                  v1(var40, var18, var19, var20, 0.0F);
                  v1(var40, var36, var37, var38, var39);
                  v1(var40, var10, var11, var12, var13);
                  v1(var40, var14, var15, var16, var17);
                  v1(var40, var22, var23, var24, var21);
                  v1(var40, 0.0F, 0.0F, 0.0F, 0.0F);
                  if (var7 != 0L && var7 == this.v17 && var2 == this.v19 && this.v1(var40)) {
                     v6++;
                  } else {
                     this.v1(var40, var2, var7);
                     this.v1(var33, var40);
                     this.v1(var33, v13, this.v15.v1(), null, var2, var2, var34, false);
                     v5++;
                  }
               }

               ByteBuffer var41 = this.v3();
               v1(var41, 1.0F, 1.0F, 0.0F, 0.0F);
               if (var32) {
                  v1(var41, var25, var30, this.v15.v2(), this.v15.v3());
                  v1(var41, 0.0F, 1.0F, var29, var5);
               } else {
                  v1(var41, 0.0F, 0.0F, var3, var4);
                  v1(var41, 0.0F, 0.0F, 0.0F, var5);
               }

               v1(var41, var18, var19, var20, 1.0F);
               if (var32) {
                  v1(var41, var25 + 0.5F, var30 + 0.5F, var25 + var27 - 0.5F, var30 + var31 - 0.5F);
               } else {
                  v1(var41, var36, var37, var38, var39);
               }

               v1(var41, var10, var11, var12, var13);
               v1(var41, var14, var15, var16, var17);
               v1(var41, var22, var23, var24, var21);
               if (var32) {
                  v1(var41, var30, var3, var4, 1.0F);
               } else {
                  v1(var41, 0.0F, 0.0F, 0.0F, 0.0F);
               }

               this.v1(var33, var41);
               this.v1(var33, v14, renderSupport30.v1(var1), var35, var32 ? this.v15.v1() : var2, var2, var34, true);
               return true;
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
      @Nullable GpuTextureView var6,
      class_12137 var7,
      boolean var8
   ) {
      RenderPass var9 = this.v1(var1, var3, var4);

      try {
         var9.setPipeline(var2);
         if (var8) {
            cloudSupport27.v1(var9);
         }

         var9.setVertexBuffer(0, this.v3);
         var9.bindTexture("Sampler0", var5, var7);
         var9.bindTexture("Sampler1", var6, var7);
         var9.setUniform("VeilData", renderSupport31.v1(renderSupport47.v1(this.v2)));
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
   }

   private boolean v1(ByteBuffer var1) {
      int var2 = var1.position();
      if (var2 != this.v18) {
         return false;
      } else {
         for (int var3 = 0; var3 < var2; var3++) {
            if (var1.get(var3) != this.v16[var3]) {
               return false;
            }
         }

         return true;
      }
   }

   private void v1(ByteBuffer var1, GpuTextureView var2, long var3) {
      int var5 = var1.position();
      var1.get(0, this.v16, 0, var5);
      this.v18 = var5;
      this.v19 = var2;
      this.v17 = var3;
   }

   private boolean v1(int var1, int var2) {
      GpuTextureView var3 = this.v15.v1();
      boolean var4 = this.v15.v1(var1, var2);
      if (this.v15.v1() != var3) {
         this.v18 = -1;
         this.v19 = null;
      }

      return var4;
   }

   @Override
   public void v5() {
      this.v6();
   }

   @Override
   public void v6() {
      this.v15.close();
      this.v18 = -1;
      this.v19 = null;
   }
}
