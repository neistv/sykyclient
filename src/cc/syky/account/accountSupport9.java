package cc.syky.account;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport27;
import cc.syky.render.VeilDataSupport;
import cc.syky.render.renderSupport21;
import cc.syky.render.renderSupport30;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport33;
import cc.syky.render.renderSupport36;
import cc.syky.render.renderSupport44;
import cc.syky.ui.uiSupport157;
import cc.syky.ui.uiSupport158;
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
import java.util.OptionalInt;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class accountSupport9 extends renderSupport36 implements accountSupport8 {
   private static final int v5 = 3;
   private static final class_2960 v6 = class_2960.method_60655("syky", "pipeline/layer");
   private static final class_2960 v7 = class_2960.method_60655("syky", "core/layer/layer");
   private static final int v8 = 16;
   private static final RenderPipeline v9 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v6)
         .withVertexShader(v7)
         .withFragmentShader(v7)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("LayerData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v10 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/layer_overlay"))
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
   private final cloudSupport101 v11;
   @Nullable
   private final renderSupport21 v12;
   @Nullable
   private final VeilDataSupport v13;
   private final GpuTexture[] v14 = new GpuTexture[3];
   private final GpuTextureView[] v15 = new GpuTextureView[3];
   private final float[] v16 = new float[3];
   private final float[] v18 = new float[3];
   private final float[] v19 = new float[3];
   private final float[] v17 = new float[3];
   private final uiSupport158[] v20 = new uiSupport158[3];
   private final boolean[] v21 = new boolean[3];
   private int v22;
   private int v24;
   private int v25;

   public accountSupport9(cloudSupport101 var1, @Nullable renderSupport21 var2, @Nullable VeilDataSupport var3) {
      super("layer", 16);
      this.v11 = var1;
      this.v12 = var2;
      this.v13 = var3;
   }

   @Override
   public String v1() {
      return "layer_composite";
   }

   public boolean v7() {
      return this.v1(0.0F, 0.0F);
   }

   public boolean v1(float var1, float var2) {
      return this.v1(var1, var2, null);
   }

   public boolean v1(uiSupport158 var1) {
      return this.v1(var1, false);
   }

   public boolean v1(uiSupport158 var1, boolean var2) {
      boolean var3 = this.v1(0.0F, 0.0F, var1, var2);
      if (!var3) {
         var1.v1();
      }

      return var3;
   }

   private boolean v1(float var1, float var2, @Nullable uiSupport158 var3) {
      return this.v1(var1, var2, var3, false);
   }

   private boolean v1(float var1, float var2, @Nullable uiSupport158 var3, boolean var4) {
      if (this.v25 >= 3) {
         return false;
      } else {
         class_310 var5 = this.v11.v1();
         if (var5 != null && var5.method_1522() != null && var5.method_1522().method_30277() != null) {
            this.v2();
            int var6 = this.v25;
            int var9 = var5.method_1522().field_1482;
            int var10 = var5.method_1522().field_1481;
            boolean var11 = var3 != null && var4 && var3.v2(var9, var10);
            GpuTexture var7;
            GpuTextureView var8;
            if (var11 && var3 != null) {
               var8 = var3.v8();
               var7 = var3.v7();
               if (var8 == null || var7 == null || !renderSupport30.v1(var8, var7)) {
                  return false;
               }
            } else if (var3 == null) {
               if (!this.v1(var5, this.v25)) {
                  return false;
               }

               this.v4();
               var7 = this.v14[var6];
               var8 = this.v15[var6];
            } else {
               var3.v1();
               var8 = var9 > 0 && var10 > 0 ? var3.v3(var9, var10) : null;
               var7 = var3.v7();
               if (var8 == null || var7 == null) {
                  return false;
               }
            }

            if (!var11) {
               CommandEncoder var12 = RenderSystem.getDevice().createCommandEncoder();
               var12.clearColorTexture(var7, 0);
               if (!renderSupport30.v1(var8)) {
                  return false;
               }
            }

            this.v20[var6] = var3;
            this.v21[var6] = var11;
            this.v19[var6] = renderSupport33.v2();
            this.v17[var6] = renderSupport33.v3();
            if (this.v12 == null) {
               var1 = 0.0F;
               var2 = 0.0F;
            }

            this.v16[var6] = var1;
            this.v18[var6] = var2;
            renderSupport33.v1(this.v19[var6] + var1, this.v17[var6] + var2);
            this.v25 = var6 + 1;
            return true;
         } else {
            return false;
         }
      }
   }

   public float v8() {
      return this.v25 > 0 ? this.v16[this.v25 - 1] : 0.0F;
   }

   public float v9() {
      return this.v25 > 0 ? this.v18[this.v25 - 1] : 0.0F;
   }

   public void v10() {
      if (this.v25 > 0) {
         renderSupport33.v1(this.v19[this.v25 - 1], this.v17[this.v25 - 1]);
      }
   }

   public void v1(float var1) {
      this.v1(var1, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.v1(var1, var2, var3, var4, var5, var6, 0.0F, 0.0F, 1.0F);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
   }

   public void v1(
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
      float var17,
      float var18,
      float var19,
      float var20,
      float var21
   ) {
      if (this.v25 > 0) {
         this.v10();
         int var22 = --this.v25;
         this.v1(var22);
         renderSupport30.v1();
         int var23 = this.v3(var22);
         int var24 = this.v4(var22);
         GpuTextureView var25 = this.v2(var22);
         class_310 var26 = this.v11.v1();
         if (var26 != null && !(var1 <= 0.0F) && var25 != null) {
            var1 = Math.min(var1, 1.0F);
            float var27 = v1(var26);
            float var28 = -this.v16[var22] * var27;
            float var29 = this.v18[var22] * var27;
            boolean var30 = var7 != var8 && var9 < 1.0F;
            boolean var31 = var12 > 0.0F && var13 > 0.0F || var21 > 0.0F;
            if (!var30 && !var31 && this.v1(var22, var4, var5, var6)
               || this.v12 == null
               || !this.v12
                  .v1(
                     var26,
                     var25,
                     var23,
                     var24,
                     var28,
                     var29,
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
                     var20,
                     var21
                  )) {
               this.v1(var26, var25, var1);
            }
         }
      }
   }

   public boolean v1(renderSupport44 var1) {
      int var2 = this.v25 - 1;
      uiSupport158 var3 = var2 >= 0 ? this.v20[var2] : null;
      if (var3 == null) {
         return false;
      } else {
         boolean var4 = renderSupport30.v2();
         if (this.v21[var2]) {
            this.v21[var2] = false;
            if (var4 && var1.v2(var3.v4())) {
               var1.v6();
               var3.v5();
               return true;
            }

            var3.v6();
            renderSupport30.v4();
         }

         if (var4) {
            var1.v1(var3.v4());
         } else {
            var3.v4().v2();
         }

         var3.v13();
         return false;
      }
   }

   private void v1(int var1) {
      uiSupport158 var2 = this.v20[var1];
      if (this.v21[var1] && var2 != null) {
         this.v21[var1] = false;
         var2.v6();
         var2.v4().v2();
         renderSupport30.v4();
      }
   }

   @Nullable
   private GpuTextureView v2(int var1) {
      uiSupport158 var2 = this.v20[var1];
      if (var2 == null) {
         return this.v14[var1] == null ? null : this.v15[var1];
      } else {
         this.v20[var1] = null;
         var2.v12();
         return var2.v8();
      }
   }

   private int v3(int var1) {
      uiSupport158 var2 = this.v20[var1];
      return var2 != null ? var2.v10() : this.v22;
   }

   private int v4(int var1) {
      uiSupport158 var2 = this.v20[var1];
      return var2 != null ? var2.v11() : this.v24;
   }

   private boolean v1(int var1, float var2, float var3, float var4) {
      return var4 <= 0.0F
         && this.v16[var1] == 0.0F
         && this.v18[var1] == 0.0F
         && Math.abs(var2 - 1.0F) * this.v22 < 0.5F
         && Math.abs(var3 - 1.0F) * this.v24 < 0.5F;
   }

   public void v1(float var1, uiSupport157 var2) {
      if (this.v25 > 0) {
         this.v10();
         int var3 = --this.v25;
         this.v1(var3);
         renderSupport30.v1();
         int var4 = this.v3(var3);
         int var5 = this.v4(var3);
         uiSupport158 var6 = this.v20[var3];
         long var7 = var6 != null ? var6.v9() : 0L;
         GpuTextureView var9 = this.v2(var3);
         class_310 var10 = this.v11.v1();
         if (var10 != null && !(var1 <= 0.0F) && var9 != null) {
            this.v1(var10, var9, var4, var5, var7, var1, var2);
         }
      }
   }

   public boolean v1(uiSupport158 var1, float var2, uiSupport157 var3) {
      class_310 var4 = this.v11.v1();
      GpuTextureView var5 = var1.v8();
      if (var4 != null && var4.method_1522() != null && var5 != null && var1.v1(var4.method_1522().field_1482, var4.method_1522().field_1481)) {
         if (var2 > 0.0F) {
            this.v2();
            this.v1(var4, var5, var1.v10(), var1.v11(), var1.v9(), var2, var3);
         }

         return true;
      } else {
         return false;
      }
   }

   private void v1(class_310 var1, GpuTextureView var2, int var3, int var4, long var5, float var7, uiSupport157 var8) {
      var7 = Math.min(var7, 1.0F);
      if (this.v13 == null || !this.v13.v1(var1, var2, var3, var4, var7, var8, var5)) {
         this.v1(var1, var2, var7);
      }
   }

   public int v11() {
      return this.v25;
   }

   @Override
   public boolean v12() {
      return this.v25 > 0;
   }

   @Nullable
   @Override
   public GpuTextureView v13() {
      return null;
   }

   @Override
   public void v1(@Nullable GpuTextureView var1, @Nullable GpuTextureView var2) {
   }

   @Override
   public void v1(@Nullable GpuTextureView var1, int var2, int var3) {
      if (var1 != null && var2 > 0 && var3 > 0 && this.v1 != null && this.v2 != null) {
         renderSupport30.v3();
         float var4 = Math.max(1.0F, (float)this.v22 / var2) / 4.0F;
         this.v1.clear();
         this.v1.putFloat(var2).putFloat(var3).putFloat(var4 / this.v22).putFloat(var4 / this.v24);
         this.v1.flip();
         CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
         var5.writeToBuffer(renderSupport31.v1(this.v2), this.v1);
         class_12137 var6 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);

         for (int var7 = 0; var7 < this.v25; var7++) {
            uiSupport158 var8 = this.v20[var7];
            GpuTextureView var9 = var8 != null ? var8.v8() : this.v15[var7];
            if (var9 != null) {
               RenderPass var10 = var5.createRenderPass(() -> "syky:layer_overlay", var1, OptionalInt.empty());

               try {
                  var10.setPipeline(v10);
                  var10.setVertexBuffer(0, this.v3);
                  var10.bindTexture("Sampler0", var9, var6);
                  var10.setUniform("OverlayParams", renderSupport31.v1(this.v2));
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
            }
         }
      }
   }

   public void v14() {
      for (int var1 = 0; var1 < 3; var1++) {
         uiSupport158 var2 = this.v20[var1];
         if (var2 != null) {
            var2.v1();
            this.v20[var1] = null;
         }

         this.v21[var1] = false;
      }

      this.v25 = 0;
   }

   private static float v1(class_310 var0) {
      if (var0.method_22683() == null) {
         return 1.0F;
      } else {
         float var1 = var0.method_22683().method_4495();
         return var1 > 0.0F ? var1 : 1.0F;
      }
   }

   private void v1(class_310 var1, GpuTextureView var2, float var3) {
      if (this.v1 != null && this.v2 != null) {
         this.v1.clear();
         this.v1.putFloat(this.v22).putFloat(this.v24).putFloat(var3).putFloat(0.0F);
         this.v1.flip();
         CommandEncoder var4 = RenderSystem.getDevice().createCommandEncoder();
         var4.writeToBuffer(renderSupport31.v1(this.v2), this.v1);
         class_12137 var5 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
         GpuTextureView var6 = renderSupport30.v1(var1);
         GpuTextureView var7 = var1.method_1522().method_71640();
         RenderPass var8 = this.v1(var4, var6, var7);

         try {
            var8.setPipeline(v9);
            cloudSupport27.v1(var8);
            var8.setVertexBuffer(0, this.v3);
            var8.bindTexture("Sampler0", var2, var5);
            var8.setUniform("LayerData", renderSupport31.v1(this.v2));
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

   private boolean v1(class_310 var1, int var2) {
      int var3 = var1.method_1522().field_1482;
      int var4 = var1.method_1522().field_1481;
      if (var3 > 0 && var4 > 0) {
         if (var3 != this.v22 || var4 != this.v24) {
            this.v15();
            this.v22 = var3;
            this.v24 = var4;
         }

         if (this.v14[var2] != null) {
            return true;
         } else {
            try {
               this.v14[var2] = RenderSystem.getDevice().createTexture(() -> "syky:ui_layer", 12, TextureFormat.RGBA8, var3, var4, 1, 1);
               this.v15[var2] = RenderSystem.getDevice().createTextureView(this.v14[var2]);
               return true;
            } catch (Throwable var6) {
               this.v5(var2);
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private void v5(int var1) {
      if (this.v15[var1] != null) {
         this.v15[var1].close();
         this.v15[var1] = null;
      }

      if (this.v14[var1] != null) {
         this.v14[var1].close();
         this.v14[var1] = null;
      }
   }

   private void v15() {
      for (int var1 = 0; var1 < 3; var1++) {
         this.v5(var1);
      }

      this.v22 = 0;
      this.v24 = 0;
   }

   @Override
   public void v5() {
      if (this.v25 == 0) {
         this.v15();
      }
   }

   @Override
   public void v6() {
      this.v15();
      this.v25 = 0;
   }
}
