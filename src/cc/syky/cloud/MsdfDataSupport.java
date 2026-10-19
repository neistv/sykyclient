package cc.syky.cloud;

import cc.syky.render.renderSupport23;
import cc.syky.render.renderSupport33;
import cc.syky.render.renderSupport37;
import cc.syky.render.renderSupport44;
import cc.syky.render.renderSupport47;
import cc.syky.ui.uiSupport155;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.minecraft.class_1044;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class MsdfDataSupport extends renderSupport37 {
   private static final class_2960 v13 = class_2960.method_60655("syky", "pipeline/msdf");
   private static final class_2960 v14 = class_2960.method_60655("syky", "core/gui/msdf");
   private static final class_2960 v15 = class_2960.method_60655("syky", "pipeline/vibrant_msdf");
   private static final class_2960 v16 = class_2960.method_60655("syky", "core/vibrant/vibrant_msdf");
   public static final int v10 = 256;
   public static final int v11 = 64;
   public static final int v12 = 12352;
   private static final int v18 = 48;
   private static final RenderPipeline v19 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v13)
         .withVertexShader(v14)
         .withFragmentShader(v14)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("MsdfData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v17 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v15)
         .withVertexShader(v16)
         .withFragmentShader(v16)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("MsdfData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private final renderSupport23 v20 = new renderSupport23();
   @Nullable
   private InvalidMSDFSupport v21;
   @Nullable
   private GpuTexture v22;
   @Nullable
   private GpuTextureView v24;
   private final ByteBuffer v25 = ByteBuffer.allocate(64).order(ByteOrder.nativeOrder());
   private long v26;
   private long v27 = -1L;
   @Nullable
   private InvalidMSDFSupport v28;
   private int v29;
   private int v30;
   private int v32;
   private int v23;
   private int v33;
   private int v31;
   private int v34;
   private int v36;
   private int v38;
   private int v42;
   private boolean v43;
   private int v37;
   @Nullable
   private RenderPipeline v48;
   @Nullable
   private GpuTextureView v40;
   @Nullable
   private GpuTextureView v44;
   private boolean v47;
   private int v49;
   private int v46;
   private int v51;
   private int v50;
   private final renderSupport44.Part3 v60 = this::v5;
   private static boolean v59 = true;
   private static long v53;
   private float v63;
   private float v64;
   private float v61;
   private float v66;
   private float v68;
   private float v52;
   private int v75;
   private float v73;
   private float v74;
   private float v72;
   private float v80;

   public static long v2() {
      return v53;
   }

   public static void v3() {
      v53 = 0L;
   }

   public static void v1(boolean var0) {
      v59 = var0;
   }

   public MsdfDataSupport(cloudSupport101 var1, renderSupport44 var2) {
      super(var1, var2, 12352);
   }

   public float v1(InvalidMSDFSupport var1, String var2, float var3, float var4, float var5, int var6) {
      return this.v1(var1, var2, var3, var4, var5, var6, cloudRecord5.NONE, v19, null);
   }

   public float v1(InvalidMSDFSupport var1, String var2, float var3, float var4, float var5, int var6, cloudRecord5 var7) {
      return this.v1(var1, var2, var3, var4, var5, var6, var7, v19, null);
   }

   public float v1(InvalidMSDFSupport var1, String var2, float var3, float var4, float var5, int var6, GpuTextureView var7) {
      return this.v1(var1, var2, var3, var4, var5, var6, cloudRecord5.NONE, v17, var7);
   }

   public float v1(InvalidMSDFSupport var1, String var2, float var3, float var4, float var5, int var6, cloudRecord5 var7, GpuTextureView var8) {
      return this.v1(var1, var2, var3, var4, var5, var6, var7, v17, var8);
   }

   private float v1(
      InvalidMSDFSupport var1, String var2, float var3, float var4, float var5, int var6, cloudRecord5 var7, RenderPipeline var8, @Nullable GpuTextureView var9
   ) {
      if (var2 != null && !var2.isEmpty()) {
         class_310 var10 = this.v1.v1();
         if (var10 != null && var10.method_1522() != null) {
            if (var5 > 0.0F && Float.isFinite(var3) && Float.isFinite(var4)) {
               GpuTextureView var11 = this.v1(var10, var1);
               if (var11 == null) {
                  return 0.0F;
               } else {
                  this.v1();
                  this.v1(var10);
                  var3 += renderSupport33.v2();
                  var4 += renderSupport33.v3();
                  this.v1(var1, var5, var7);
                  this.v73 = uiSupport155.v2(var6) / 255.0F;
                  this.v74 = uiSupport155.v3(var6) / 255.0F;
                  this.v72 = uiSupport155.v4(var6) / 255.0F;
                  this.v80 = uiSupport155.v1(var6) / 255.0F;
                  float var12 = var4 + var1.v9() * var5;
                  float var13 = var3;
                  float var14 = 0.0F;
                  int var15 = -1;
                  this.v1(var1);
                  this.v1(var8, var11, var9);
                  int var16 = 0;

                  while (var16 < var2.length()) {
                     int var17 = var2.codePointAt(var16);
                     var16 += Character.charCount(var17);
                     if (var17 == 10) {
                        float var18 = var13 - var3;
                        if (var18 > var14) {
                           var14 = var18;
                        }

                        var13 = var3;
                        var12 += var1.v8() * var5;
                        var15 = -1;
                     } else {
                        var17 = var1.v2(var17);
                        cloudSupport28 var27 = var1.v1(var17);
                        if (var27 != null) {
                           if (var15 != -1) {
                              var13 += var1.v1(var15, var17) * var5;
                           }

                           if (var27.v11) {
                              if (this.v37 == 256) {
                                 this.v5();
                                 this.v1(var8, var11, var9);
                              }

                              float var19 = var13 + var27.v7 * var5;
                              float var20 = var12 - var27.v10 * var5;
                              float var21 = var27.v1() * var5;
                              float var22 = var27.v2() * var5;
                              this.v1(var19, var20, var21, var22, var27.v3, var27.v5, var27.v4, var27.v6);
                              this.v37++;
                           }

                           var13 += var27.v2 * var5;
                           var15 = var17;
                        }
                     }
                  }

                  if (!v59) {
                     this.v5();
                  }

                  float var25 = var13 - var3;
                  return var25 > var14 ? var25 : var14;
               }
            } else {
               return 0.0F;
            }
         } else {
            return 0.0F;
         }
      } else {
         return 0.0F;
      }
   }

   private void v1(InvalidMSDFSupport var1, float var2, cloudRecord5 var3) {
      float var4 = var1.v6();
      float var5 = Math.clamp(var3.v2(), -var4, var4);
      boolean var6 = var3.v1() && var1.v7();
      float var7 = var6 ? Math.clamp(var3.v3(), 0.0F, var4 - Math.max(var5, 0.0F)) : 0.0F;
      float var8 = var2 * this.v5;
      this.v63 = var5 * var8;
      this.v64 = var7 * var8;
      this.v75 = var7 > 0.0F ? var3.v4() : 0;
      float var9 = renderSupport33.v2();
      this.v61 = var3.v5() + var9;
      this.v68 = var3.v6() + var9;
      this.v66 = 1.0F / Math.max(var3.v7(), 0.001F);
      this.v52 = 1.0F / Math.max(var3.v8(), 0.001F);
   }

   @Nullable
   private GpuTextureView v1(class_310 var1, InvalidMSDFSupport var2) {
      GpuTexture var3 = this.v22;
      if (var2 == this.v21 && var3 != null && !var3.isClosed()) {
         return this.v24;
      } else {
         class_1044 var4 = var1.method_1531().method_4619(var2.v2());
         if (var4 == null) {
            return null;
         } else {
            GpuTexture var5 = var4.method_68004();
            if (var5 == null) {
               return null;
            } else {
               GpuTextureView var6 = this.v20.v1(var5);
               this.v21 = var2;
               this.v22 = var5;
               this.v24 = var6;
               return var6;
            }
         }
      }
   }

   private void v1(RenderPipeline var1, GpuTextureView var2, @Nullable GpuTextureView var3) {
      if (this.v43 && this.v48 == var1 && this.v40 == var2 && this.v44 == var3 && this.v4() && this.v27 == this.v26) {
         v53++;
      } else {
         this.v5();
         ByteBuffer var4 = renderSupport47.v1(this.v3);
         var4.clear();
         var4.put(this.v25.array(), 0, 64);
         this.v43 = true;
         this.v37 = 0;
         this.v27 = this.v26;
         this.v48 = var1;
         this.v40 = var2;
         this.v44 = var3;
         this.v47 = cloudSupport27.v4();
         this.v49 = cloudSupport27.v5();
         this.v46 = cloudSupport27.v6();
         this.v51 = cloudSupport27.v7();
         this.v50 = cloudSupport27.v8();
         this.v2.v1(this.v60);
      }
   }

   private boolean v4() {
      boolean var1 = cloudSupport27.v4();
      return var1 != this.v47
         ? false
         : !var1 || cloudSupport27.v5() == this.v49 && cloudSupport27.v6() == this.v46 && cloudSupport27.v7() == this.v51 && cloudSupport27.v8() == this.v50;
   }

   private void v1(InvalidMSDFSupport var1) {
      int var2 = Float.floatToRawIntBits(this.v6);
      int var3 = Float.floatToRawIntBits(this.v7);
      int var4 = Float.floatToRawIntBits(this.v5);
      int var5 = Float.floatToRawIntBits(this.v63);
      int var6 = Float.floatToRawIntBits(this.v64);
      int var7 = Float.floatToRawIntBits(this.v61);
      int var8 = Float.floatToRawIntBits(this.v66);
      int var9 = Float.floatToRawIntBits(this.v68);
      int var10 = Float.floatToRawIntBits(this.v52);
      if (var1 != this.v28
         || var2 != this.v29
         || var3 != this.v30
         || var4 != this.v32
         || var5 != this.v23
         || var6 != this.v33
         || var7 != this.v31
         || var8 != this.v34
         || var9 != this.v36
         || var10 != this.v38
         || this.v75 != this.v42) {
         this.v28 = var1;
         this.v29 = var2;
         this.v30 = var3;
         this.v32 = var4;
         this.v23 = var5;
         this.v33 = var6;
         this.v31 = var7;
         this.v34 = var8;
         this.v36 = var9;
         this.v38 = var10;
         this.v42 = this.v75;
         this.v26++;
         ByteBuffer var11 = this.v25;
         var11.clear();
         var11.putFloat(this.v6).putFloat(this.v7).putFloat(this.v5).putFloat(var1.v5());
         var11.putFloat(var1.v3()).putFloat(var1.v4()).putFloat(this.v63).putFloat(this.v64);
         var11.putFloat(this.v61).putFloat(this.v66).putFloat(this.v68).putFloat(this.v52);
         uiSupport155.v1(var11, this.v75);
      }
   }

   private void v5() {
      if (this.v43) {
         this.v43 = false;
         if (this.v37 != 0) {
            ByteBuffer var1 = renderSupport47.v1(this.v3);
            var1.position(0);
            var1.limit(64 + this.v37 * 48);
            this.v2
               .v1(
                  renderSupport47.v1(this.v48),
                  "MsdfData",
                  var1,
                  this.v40,
                  this.v44,
                  this.v47,
                  this.v49,
                  this.v46,
                  this.v51,
                  this.v50,
                  0,
                  6 * this.v37,
                  0,
                  12352,
                  64
               );
         }
      }
   }

   private void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      ByteBuffer var9 = renderSupport47.v1(this.v3);
      var9.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
      var9.putFloat(var5).putFloat(var6).putFloat(var7).putFloat(var8);
      var9.putFloat(this.v73).putFloat(this.v74).putFloat(this.v72).putFloat(this.v80);
   }

   @Override
   public void close() {
      this.v43 = false;
      this.v28 = null;
      this.v21 = null;
      this.v22 = null;
      this.v24 = null;
      super.close();
      this.v20.close();
   }
}
