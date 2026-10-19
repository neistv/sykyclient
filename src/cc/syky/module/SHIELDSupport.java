package cc.syky.module;

import cc.syky.cloud.cloudSupport101;
import cc.syky.render.renderSupport28;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport36;
import cc.syky.render.renderSupport47;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
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
import org.joml.Vector3f;

public final class SHIELDSupport extends renderSupport36 {
   private final cloudSupport101 v9;
   private static final class_2960 v10 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v11 = class_2960.method_60655("syky", "core/post/motion_blur");
   private static final int v12 = 256;
   private static final int v13 = 0;
   private static final int v14 = 64;
   private static final int v15 = 128;
   private static final int v16 = 192;
   private static final float v18 = 0.075F;
   private static final float v19 = 0.0F;
   private static final float v17 = 1.0F;
   public static final int v5 = 0;
   public static final int v6 = 1;
   public static final int v7 = 2;
   public static final int v8 = 3;
   private static final float v20 = 32.0F;
   private static final float v21 = 48.0F;
   private static final float v22 = 14.0F;
   private static final float v24 = 22.0F;
   private static final float v25 = 1.0E9F;
   private static final int v26 = 0;
   private static final int v27 = 1;
   private static final int v28 = 2;
   private static final int v29 = 3;
   private static final RenderPipeline[][] v30 = new RenderPipeline[][]{
      {v1("pipeline/motion_blur", null, false), v1("pipeline/motion_blur_shield", null, true)},
      {v1("pipeline/motion_blur_half_short", "HALF_SHORT", false), v1("pipeline/motion_blur_half_short_shield", "HALF_SHORT", true)},
      {v1("pipeline/motion_blur_low_long", "LOW_LONG", false), v1("pipeline/motion_blur_low_long_shield", "LOW_LONG", true)},
      {v1("pipeline/motion_blur_half_long", "HALF_LONG", false), v1("pipeline/motion_blur_half_long_shield", "HALF_LONG", true)}
   };
   private static final RenderPipeline v32 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/motion_blur_entities"))
         .withVertexShader(v10)
         .withFragmentShader(class_2960.method_60655("syky", "core/post/motion_blur_entities"))
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withSampler("FloorSampler")
         .withSampler("SeamSampler")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final GpuTextureView[] v23 = new GpuTextureView[3];
   private boolean v33;
   @Nullable
   private GpuTextureView v31;
   @Nullable
   private GpuTextureView v34;
   @Nullable
   private GpuTexture v36;
   @Nullable
   private GpuTextureView v38;
   @Nullable
   private GpuTexture v42;
   @Nullable
   private GpuTextureView v43;
   @Nullable
   private GpuTexture v37;
   @Nullable
   private GpuTextureView v48;
   private float v40 = 1.0E9F;
   private float v44 = 1.0E9F;
   @Nullable
   private GpuTexture v47;
   @Nullable
   private GpuTextureView v49;
   private int v46;
   private int v51;

   public SHIELDSupport(cloudSupport101 var1) {
      super("motion_blur", 256);
      this.v9 = var1;
   }

   private static RenderPipeline v1(String var0, @Nullable String var1, boolean var2) {
      Builder var3 = v1(var0);
      if (var1 != null) {
         var3 = var3.withShaderDefine(var1);
      }

      if ("HALF_LONG".equals(var1)) {
         var3 = var3.withSampler("HalfSampler").withSampler("LowSampler");
      }

      if (var2) {
         var3 = var3.withShaderDefine("SHIELD").withSampler("EntitySampler");
      }

      return class_10799.method_67887(var3.build());
   }

   private static Builder v1(String var0) {
      return RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", var0))
         .withVertexShader(v10)
         .withFragmentShader(v11)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("MotionBlurParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withSampler("CoverBackSampler")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false);
   }

   public void v1(
      Matrix4f var1,
      Matrix4f var2,
      Matrix4f var3,
      Vector3f var4,
      float var5,
      float var6,
      int var7,
      int var8,
      float var9,
      GpuTextureView var10,
      GpuTextureView var11,
      GpuTextureView var12,
      boolean var13,
      @Nullable GpuTextureView var14,
      @Nullable GpuTextureView var15
   ) {
      this.v33 = var13;
      boolean var16 = var14 != null && var15 != null;
      this.v31 = var16 ? var14 : null;
      this.v34 = var16 ? var15 : null;
      this.v23[0] = var10;
      this.v23[1] = var11;
      this.v23[2] = var12;
      class_310 var17 = this.v9.v1();
      if (var17 != null && var17.method_1522() != null) {
         class_276 var18 = var17.method_1522();
         if (var18.method_30277() != null && var18.method_30278() != null) {
            this.v2();
            int var19 = var18.field_1482;
            int var20 = var18.field_1481;
            if (var19 > 0 && var20 > 0) {
               this.v1(var19, var20);
               this.v4();
               CommandEncoder var21 = RenderSystem.getDevice().createCommandEncoder();
               class_12137 var22 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
               class_12137 var23 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
               GpuTextureView var24 = var18.method_71639();
               GpuTextureView var25 = var18.method_71640();
               float var26 = 0.075F * var6 * var20;
               GpuTextureView var27 = var14;
               GpuTextureView var28 = var15;
               if (var14 != null && var15 != null) {
                  RenderPass var29 = var21.createRenderPass(() -> "syky:motion_blur_entities", renderSupport47.v1(this.v49), OptionalInt.empty());

                  try {
                     var29.setPipeline(v32);
                     var29.setVertexBuffer(0, renderSupport47.v1(this.v3));
                     var29.bindTexture("FloorSampler", var27, var23);
                     var29.bindTexture("SeamSampler", var28, var23);
                     var29.draw(0, 6);
                  } catch (Throwable var33) {
                     if (var29 != null) {
                        try {
                           var29.close();
                        } catch (Throwable var32) {
                           var33.addSuppressed(var32);
                        }
                     }

                     throw var33;
                  }

                  if (var29 != null) {
                     var29.close();
                  }
               }

               if (var8 == 0) {
                  this.v1(
                     var21,
                     var24,
                     null,
                     null,
                     var25,
                     renderSupport47.v1(this.v38),
                     var22,
                     var23,
                     var1,
                     var2,
                     var3,
                     var4,
                     var5,
                     var7,
                     var26,
                     var19,
                     var20,
                     0.0F,
                     0,
                     var9
                  );
                  this.v1(
                     var21,
                     renderSupport47.v1(this.v38),
                     null,
                     null,
                     var25,
                     var24,
                     var22,
                     var23,
                     var1,
                     var2,
                     var3,
                     var4,
                     var5,
                     var7,
                     var26,
                     var19,
                     var20,
                     1.0F,
                     0,
                     var9
                  );
               } else {
                  this.v1(
                     var21,
                     var24,
                     null,
                     null,
                     var25,
                     renderSupport47.v1(this.v43),
                     var22,
                     var23,
                     var1,
                     var2,
                     var3,
                     var4,
                     var5,
                     var7,
                     var26,
                     var19,
                     var20,
                     0.0F,
                     1,
                     var9
                  );
                  boolean var34 = var8 == 2 || var8 == 3;
                  if (var34) {
                     this.v40 = var8 == 3 ? 14.0F : 32.0F;
                     this.v44 = var8 == 3 ? 22.0F : 48.0F;
                     this.v1(
                        var21,
                        renderSupport47.v1(this.v43),
                        null,
                        null,
                        var25,
                        renderSupport47.v1(this.v48),
                        var22,
                        var23,
                        var1,
                        var2,
                        var3,
                        var4,
                        var5,
                        var7,
                        var26,
                        var19,
                        var20,
                        1.0F,
                        2,
                        var9
                     );
                  }

                  this.v1(
                     var21,
                     var24,
                     this.v43,
                     this.v48,
                     var25,
                     renderSupport47.v1(this.v38),
                     var22,
                     var23,
                     var1,
                     var2,
                     var3,
                     var4,
                     var5,
                     var7,
                     var26,
                     var19,
                     var20,
                     1.0F,
                     3,
                     var9
                  );
                  this.v40 = 1.0E9F;
                  this.v44 = 1.0E9F;
                  renderSupport28.v1(var21, renderSupport47.v1(this.v38), var24, renderSupport47.v1(this.v3));
               }
            }
         }
      }
   }

   private void v1(
      CommandEncoder var1,
      GpuTextureView var2,
      @Nullable GpuTextureView var3,
      @Nullable GpuTextureView var4,
      GpuTextureView var5,
      GpuTextureView var6,
      class_12137 var7,
      class_12137 var8,
      Matrix4f var9,
      Matrix4f var10,
      Matrix4f var11,
      Vector3f var12,
      float var13,
      int var14,
      float var15,
      int var16,
      int var17,
      float var18,
      int var19,
      float var20
   ) {
      ByteBuffer var21 = renderSupport47.v1(this.v1);
      GpuBuffer var22 = renderSupport47.v1(this.v2);
      var21.clear();
      var9.get(0, var21);
      var10.get(64, var21);
      var11.get(128, var21);
      var21.position(192);
      var21.putFloat(var12.x).putFloat(var12.y).putFloat(var12.z).putFloat(0.0F);
      var21.putFloat(var13).putFloat(var14).putFloat(var15).putFloat(var18);
      var21.putFloat(var16).putFloat(var17).putFloat(1.0F / var16).putFloat(1.0F / var17);
      var21.putFloat(var20).putFloat(this.v33 ? 1.0F : 0.0F).putFloat(this.v40).putFloat(this.v44);
      var21.flip();
      var1.writeToBuffer(renderSupport31.v1(var22), var21);
      RenderPass var23 = var1.createRenderPass(() -> "syky:motion_blur", var6, OptionalInt.empty());

      try {
         boolean var24 = this.v31 != null && this.v34 != null;
         var23.setPipeline(v30[var19][var24 ? 1 : 0]);
         var23.setVertexBuffer(0, this.v3);
         var23.bindTexture("Sampler0", var2, var7);
         if (var3 != null) {
            var23.bindTexture("HalfSampler", var3, var7);
            var23.bindTexture("LowSampler", var4 != null ? var4 : var3, var7);
         }

         var23.bindTexture("Sampler1", var5, var8);
         var23.bindTexture("CoverSampler", this.v23[0], var8);
         var23.bindTexture("CoverFrontSampler", this.v23[1], var8);
         var23.bindTexture("CoverBackSampler", this.v23[2], var8);
         if (var24) {
            var23.bindTexture("EntitySampler", renderSupport47.v1(this.v49), var8);
         }

         var23.setUniform("MotionBlurParams", renderSupport31.v1(var22));
         var23.draw(0, 6);
      } catch (Throwable var27) {
         if (var23 != null) {
            try {
               var23.close();
            } catch (Throwable var26) {
               var27.addSuppressed(var26);
            }
         }

         throw var27;
      }

      if (var23 != null) {
         var23.close();
      }
   }

   private void v1(int var1, int var2) {
      if (this.v36 == null || this.v46 != var1 || this.v51 != var2) {
         this.v7();
         this.v36 = RenderSystem.getDevice().createTexture(() -> "syky:motion_blur_scene", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v38 = RenderSystem.getDevice().createTextureView(this.v36);
         this.v42 = RenderSystem.getDevice().createTexture(() -> "syky:motion_blur_half", 12, TextureFormat.RGBA8, (var1 + 1) / 2, (var2 + 1) / 2, 1, 1);
         this.v43 = RenderSystem.getDevice().createTextureView(this.v42);
         this.v37 = RenderSystem.getDevice().createTexture(() -> "syky:motion_blur_low", 12, TextureFormat.RGBA8, (var1 + 1) / 2, (var2 + 1) / 2, 1, 1);
         this.v48 = RenderSystem.getDevice().createTextureView(this.v37);
         this.v47 = RenderSystem.getDevice().createTexture(() -> "syky:motion_blur_entities", 12, TextureFormat.RED8, var1, var2, 1, 1);
         this.v49 = RenderSystem.getDevice().createTextureView(this.v47);
         this.v46 = var1;
         this.v51 = var2;
      }
   }

   @Override
   public void v5() {
      this.v7();
   }

   @Override
   public void v6() {
      this.v7();
   }

   private void v7() {
      if (this.v38 != null) {
         this.v38.close();
         this.v38 = null;
      }

      if (this.v36 != null) {
         this.v36.close();
         this.v36 = null;
      }

      if (this.v43 != null) {
         this.v43.close();
         this.v43 = null;
      }

      if (this.v42 != null) {
         this.v42.close();
         this.v42 = null;
      }

      if (this.v48 != null) {
         this.v48.close();
         this.v48 = null;
      }

      if (this.v37 != null) {
         this.v37.close();
         this.v37 = null;
      }

      if (this.v49 != null) {
         this.v49.close();
         this.v49 = null;
      }

      if (this.v47 != null) {
         this.v47.close();
         this.v47 = null;
      }

      this.v46 = 0;
      this.v51 = 0;
   }
}
