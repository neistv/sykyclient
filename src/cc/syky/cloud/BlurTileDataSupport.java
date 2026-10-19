package cc.syky.cloud;

import cc.syky.render.renderSupport27;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport47;
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
import com.mojang.blaze3d.vertex.VertexFormat.class_5595;
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
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class BlurTileDataSupport implements AutoCloseable {
   private static final int v4 = 128;
   private static final int v5 = 32;
   public static final int v1 = 128;
   public static final int v2 = 64;
   public static final int v3 = 96;
   private static final int v6 = 48;
   private static final int v7 = 6;
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/blur/blur_tile");
   private static final class_2960 v9 = class_2960.method_60655("syky", "core/blur/blur_tile_h");
   private static final class_2960 v10 = class_2960.method_60655("syky", "core/blur/blur_tile_v");
   private static final class_2960 v11 = class_2960.method_60655("syky", "core/blur/blur_tile_scatter");
   private static final class_2960 v12 = class_2960.method_60655("syky", "core/blur/blur_tile_composite");
   private static final class_2960 v13 = class_2960.method_60655("syky", "core/blur/blur_batched");
   private static final Supplier<String> v14 = () -> "syky:blur_tile_h";
   private static final Supplier<String> v15 = () -> "syky:blur_tile_v";
   private static final Supplier<String> v16 = () -> "syky:blur_tile_scatter";
   private static final RenderPipeline v18 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/blur_tile_h"))
         .withVertexShader(v8)
         .withFragmentShader(v9)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurTileData", class_10789.field_60031)
         .withUniform("BlurTileParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v19 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/blur_tile_v"))
         .withVertexShader(v8)
         .withFragmentShader(v10)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurTileData", class_10789.field_60031)
         .withUniform("BlurTileParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v17 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/blur_tile_scatter"))
         .withVertexShader(v8)
         .withFragmentShader(v11)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurTileData", class_10789.field_60031)
         .withUniform("BlurTileParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v20 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/blur_tile_composite"))
         .withVertexShader(v12)
         .withFragmentShader(v13)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurTilePanels", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   @Nullable
   private GpuTexture v21;
   @Nullable
   private GpuTextureView v22;
   @Nullable
   private GpuTexture v24;
   @Nullable
   private GpuTextureView v25;
   @Nullable
   private GpuTexture v26;
   @Nullable
   private GpuTextureView v27;
   private int v28;
   private int v29;
   @Nullable
   private GpuBuffer v30;
   @Nullable
   private GpuBuffer v32;
   @Nullable
   private GpuBuffer v23;
   @Nullable
   private GpuBuffer v33;
   @Nullable
   private GpuBuffer v31;
   @Nullable
   private ByteBuffer v34;
   @Nullable
   private ByteBuffer v36;
   @Nullable
   private ByteBuffer v38;
   private final renderSupport27 v42 = new renderSupport27(8192);
   private final renderSupport27 v43 = new renderSupport27(48);
   private int v37;
   private final boolean[] v48 = new boolean[128];
   private final boolean[] v40 = new boolean[128];
   private final boolean[] v44 = new boolean[128];
   private final int[] v47 = new int[128];
   private final int[] v49 = new int[128];
   private final int[] v46 = new int[128];
   private final int[] v51 = new int[128];
   private final int[] v50 = new int[128];
   private final int[] v60 = new int[128];
   private final float[] v59 = new float[128];
   private final float[] v53 = new float[128];
   private final float[] v63 = new float[128];
   private final float[] v64 = new float[128];
   private final float[] v61 = new float[128];
   private final float[] v66 = new float[128];
   private final float[] v68 = new float[128];
   private final float[] v52 = new float[128];
   private final float[] v75 = new float[128];
   private final boolean[] v73 = new boolean[128];
   private final int[] v74 = new int[128];
   private int v72;
   private float v80;
   private boolean v84;
   private final boolean[] v94 = new boolean[128];
   private final boolean[] v82 = new boolean[128];
   private final float[] v99 = new float[128];
   private final float[] v120 = new float[128];
   private final float[] v88 = new float[128];
   private final float[] v103 = new float[128];
   private final float[] v101 = new float[128];
   private final float[] v96 = new float[128];
   private final float[] v105 = new float[128];
   private final float[] v87 = new float[128];
   private final float[] v85 = new float[128];
   private int v119;
   private final float[] v98 = new float[128];
   private final float[] v124 = new float[128];
   private final float[] v117 = new float[128];
   private final float[] v45 = new float[128];
   private final float[] v104 = new float[128];
   private final float[] v125 = new float[128];
   private final float[] v141 = new float[128];
   private final float[] v145 = new float[128];
   private final float[] v162 = new float[128];
   private int v107;
   private boolean v118;
   private int v159;
   private int v176;
   private boolean v116;
   private final boolean[] v147 = new boolean[128];
   private final int[] v93 = new int[128];
   private final int[] v157 = new int[128];
   private final int[] v166 = new int[128];
   private final int[] v121 = new int[128];
   private final int[] v137 = new int[128];
   private final int[] v187 = new int[128];
   private final cloudSupport25.Part1 v138 = new cloudSupport25.Part1();
   private final cloudSupport25.Part3 v106 = new cloudSupport25.Part3();
   private final int[] v100 = new int[4];
   private final int[] v191 = new int[2];
   private final int[] v112 = new int[128];
   private final int[] v216 = new int[128];
   private boolean v41;
   private boolean v190;
   @Nullable
   private GpuTextureView v70;
   @Nullable
   private GpuTextureView v133;
   @Nullable
   private BlurTileDataSupport.Part1 v160;
   private int v172;
   private int v249;
   private float v164;
   private float v239;
   private float v198;
   private float v76;
   private int v185;
   private int v220;
   private int v223;
   private int v169;
   private boolean v153;
   private int v143;
   private boolean v188;
   private boolean v228;

   public BlurTileDataSupport() {
   }

   public boolean v1() {
      return this.v41;
   }

   public void v1(int var1, float var2, boolean var3) {
      this.v72 = var1;
      this.v80 = Math.max(var2, 0.5F);
      this.v84 = var3;
   }

   public boolean v2() {
      return this.v41 && this.v72 != 0;
   }

   public void v1(
      GpuTextureView var1,
      BlurTileDataSupport.Part1 var2,
      int var3,
      int var4,
      float var5,
      float var6,
      float var7,
      float var8,
      GpuTextureView var9,
      boolean var10
   ) {
      this.v1(var3, var4);
      this.v70 = var9;
      this.v190 = var10;
      this.v133 = var1;
      this.v160 = var2;
      this.v172 = var3;
      this.v249 = var4;
      this.v164 = var5;
      this.v239 = var6;
      this.v198 = Math.max(var7, 0.5F);
      this.v76 = var8;
      this.v37 = 0;
      this.v185 = 0;
      this.v220 = 0;
      this.v223 = 0;
      this.v169 = 0;
      this.v153 = false;
      this.v143 = 0;
      this.v228 = false;
      this.v138.v1(this.v28, this.v29);
      this.v106.v1(var3, var4);
      this.v116 = var10 == this.v118 && var3 == this.v159 && var4 == this.v176;
      this.v41 = true;
   }

   public int v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      if (this.v143 < this.v37 && this.v1(this.v143, var1, var2, var3, var4, var5, var6, var7, var8, var9)) {
         this.v44[this.v143] = true;
         return this.v143++;
      } else {
         for (int var10 = 0; var10 < this.v37; var10++) {
            if (this.v1(var10, var1, var2, var3, var4, var5, var6, var7, var8, var9)) {
               this.v44[var10] = true;
               this.v143 = var10 + 1;
               return var10;
            }
         }

         int var11 = this.v1(false, var1, var2, var3, var4, var5, var6, var7, var8, var9, this.v72);
         if (var11 >= 0) {
            this.v44[var11] = true;
            this.v73[var11] = true;
         }

         return var11;
      }
   }

   private boolean v1(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      return !this.v48[var1]
         && this.v74[var1] == this.v72
         && this.v59[var1] == var2
         && this.v53[var1] == var3
         && this.v63[var1] == var4
         && this.v64[var1] == var5
         && this.v61[var1] == var6
         && this.v66[var1] == var7
         && this.v68[var1] == var8
         && this.v52[var1] == var9
         && this.v75[var1] == var10;
   }

   private int v1(boolean var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11) {
      if (this.v37 == 128) {
         this.v223++;
         return -1;
      } else {
         cloudSupport25.v1(var2, var3, var4, var5, cloudSupport25.v1(var10), this.v164, this.v239, this.v172, this.v249, this.v100);
         int var12 = this.v37;
         if (this.v116
            && var12 < this.v107
            && this.v147[var12] == var1
            && this.v93[var12] == this.v100[0]
            && this.v157[var12] == this.v100[1]
            && this.v166[var12] == this.v100[2]
            && this.v121[var12] == this.v100[3]) {
            this.v191[0] = this.v137[var12];
            this.v191[1] = this.v187[var12];
         } else {
            if (this.v116) {
               this.v116 = false;
               this.v9();
            }

            if (!this.v1(var1)) {
               this.v223++;
               return -1;
            }
         }

         this.v37++;
         this.v48[var12] = var1;
         this.v40[var12] = false;
         this.v44[var12] = false;
         this.v50[var12] = this.v100[0];
         this.v60[var12] = this.v100[1];
         this.v46[var12] = this.v100[2];
         this.v51[var12] = this.v100[3];
         this.v47[var12] = this.v191[0];
         this.v49[var12] = this.v191[1];
         this.v59[var12] = var2;
         this.v53[var12] = var3;
         this.v63[var12] = var4;
         this.v64[var12] = var5;
         this.v61[var12] = var6;
         this.v66[var12] = var7;
         this.v68[var12] = var8;
         this.v52[var12] = var9;
         this.v75[var12] = var10;
         this.v74[var12] = var11;
         return var12;
      }
   }

   private boolean v1(boolean var1) {
      if (var1 && this.v190) {
         this.v191[0] = this.v100[0];
         this.v191[1] = this.v100[1];
         this.v106.v1(this.v100[0], this.v100[1], this.v100[0] + this.v100[2] - 1, this.v100[1] + this.v100[3] - 1);
         return true;
      } else {
         return this.v190 ? this.v106.v1(this.v100[2], this.v100[3], this.v191) : this.v138.v1(this.v100[2], this.v100[3], this.v191);
      }
   }

   private void v9() {
      for (int var1 = 0; var1 < this.v37; var1++) {
         if (this.v190) {
            this.v106.v1(this.v47[var1], this.v49[var1], this.v47[var1] + this.v46[var1] - 1, this.v49[var1] + this.v51[var1] - 1);
         } else {
            this.v138.v1(this.v46[var1], this.v51[var1], this.v191);
         }
      }
   }

   public void v1(
      CommandEncoder var1,
      cloudSupport26 var2,
      int var3,
      float[] var4,
      float[] var5,
      float[] var6,
      float[] var7,
      float[] var8,
      float[] var9,
      float[] var10,
      float[] var11,
      float[] var12
   ) {
      int var13 = 0;

      for (int var14 = 0; var14 < var2.v2() && var13 < 128; var14++) {
         if (var2.v3(var14) > 0.0F && var2.v4(var14) > 0.0F) {
            this.v1(var13++, true, false, var2.v1(var14), var2.v2(var14), var2.v3(var14), var2.v4(var14), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
         }
      }

      for (int var16 = 0; var16 < var3 && var13 < 128; var16++) {
         this.v1(var13++, false, false, var4[var16], var5[var16], var6[var16], var7[var16], var8[var16], var9[var16], var10[var16], var11[var16], var12[var16]);
      }

      for (int var17 = 0; var17 < this.v119 && var13 < 128; var17++) {
         this.v1(
            var13++,
            false,
            true,
            this.v98[var17],
            this.v124[var17],
            this.v117[var17],
            this.v45[var17],
            this.v104[var17],
            this.v125[var17],
            this.v141[var17],
            this.v145[var17],
            this.v162[var17]
         );
      }

      if (this.v37 == 0 && this.v116 && this.v1(var13)) {
         this.v228 = true;
         this.v37 = var13;

         for (int var19 = 0; var19 < var13; var19++) {
            this.v40[var19] = false;
            this.v44[var19] = false;
            this.v73[var19] = this.v82[var19];
            this.v74[var19] = 0;
         }
      } else {
         for (int var18 = 0; var18 < var13; var18++) {
            int var15 = this.v1(
               this.v94[var18],
               this.v99[var18],
               this.v120[var18],
               this.v88[var18],
               this.v103[var18],
               this.v101[var18],
               this.v96[var18],
               this.v105[var18],
               this.v87[var18],
               this.v85[var18],
               0
            );
            if (var15 >= 0) {
               this.v73[var15] = this.v82[var18];
            }
         }
      }

      this.v2(var1);
      this.v153 = true;
   }

   private void v1(
      int var1, boolean var2, boolean var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12
   ) {
      this.v94[var1] = var2;
      this.v82[var1] = var3;
      this.v99[var1] = var4;
      this.v120[var1] = var5;
      this.v88[var1] = var6;
      this.v103[var1] = var7;
      this.v101[var1] = var8;
      this.v96[var1] = var9;
      this.v105[var1] = var10;
      this.v87[var1] = var11;
      this.v85[var1] = var12;
   }

   private boolean v1(int var1) {
      if (var1 != this.v107) {
         return false;
      } else {
         for (int var2 = 0; var2 < var1; var2++) {
            if (this.v48[var2] != this.v94[var2]
               || this.v59[var2] != this.v99[var2]
               || this.v53[var2] != this.v120[var2]
               || this.v63[var2] != this.v88[var2]
               || this.v64[var2] != this.v103[var2]
               || this.v61[var2] != this.v101[var2]
               || this.v66[var2] != this.v96[var2]
               || this.v68[var2] != this.v105[var2]
               || this.v52[var2] != this.v87[var2]
               || this.v75[var2] != this.v85[var2]) {
               return false;
            }
         }

         return true;
      }
   }

   private void v2(CommandEncoder var1) {
      int var2 = 0;
      int var3 = 0;

      for (int var4 = 0; var4 < this.v37; var4++) {
         if (!this.v40[var4]) {
            if (this.v74[var4] == 0) {
               this.v112[var2++] = var4;
            } else if (this.v74[var4] == this.v72) {
               this.v216[var3++] = var4;
            } else {
               this.v40[var4] = true;
            }
         }
      }

      if (var2 != 0 || var3 != 0) {
         BlurTileDataSupport.Part1 var11 = renderSupport47.v1(this.v160);

         for (int var5 = 0; var5 < var2; var5++) {
            int var6 = this.v112[var5];
            int var7 = this.v50[var6];
            int var8 = this.v60[var6];
            int var9 = this.v50[var6] + this.v46[var6] - 1;
            int var10 = this.v60[var6] + this.v51[var6] - 1;
            if (!var11.v1(var7, var8, var9, var10)) {
               this.v169++;
               var11.v2(var7, var8, var9, var10);
            }
         }

         if (var3 > 0 && this.v84 && !var11.v1(0, 0, this.v172 - 1, this.v249 - 1)) {
            this.v169++;
            var11.v2(0, 0, this.v172 - 1, this.v249 - 1);
         }

         if (var3 > 0 && !this.v84) {
            for (int var12 = 0; var12 < var3; var12++) {
               int var14 = this.v216[var12];
               var11.v3(this.v50[var14], this.v60[var14], this.v50[var14] + this.v46[var14] - 1, this.v60[var14] + this.v51[var14] - 1);
            }
         }

         class_12137 var13 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
         GpuTextureView var15 = this.v190 ? this.v22 : this.v25;
         if (var2 > 0) {
            this.v1(var1, this.v11(), this.v12(), false, this.v198);
            boolean var16 = var2 == this.v37;
            this.v1(var1, this.v112, var2, this.v133, var15, var13, var16 && this.v228 && this.v188);
            this.v188 = var16;
         }

         if (var3 > 0) {
            GpuTextureView var17 = var11.v1();
            this.v1(var1, this.v11(), this.v12(), false, this.v80);
            this.v1(var1, this.v216, var3, var17 != null ? var17 : this.v133, var15, var13, false);
            this.v188 = false;
         }

         this.v185 += var2 + var3;
         if (this.v153) {
            this.v220 += var2 + var3;
         }
      }
   }

   private void v1(CommandEncoder var1, int[] var2, int var3, @Nullable GpuTextureView var4, @Nullable GpuTextureView var5, class_12137 var6, boolean var7) {
      for (short var8 = 0; var8 < var3; var8 += 128) {
         int var9 = Math.min(128, var3 - var8);
         if (!var7) {
            this.v1(var1, var2, var8, var9);
         }

         this.v1(var1, v14, v18, var5, var4, var6, var9);
         this.v1(var1, v15, v19, this.v10(), var5, var6, var9);
      }

      for (int var10 = 0; var10 < var3; var10++) {
         this.v40[var2[var10]] = true;
      }
   }

   public void v1(CommandEncoder var1) {
      GpuTextureView var2 = this.v70;
      if (!this.v190) {
         int var3 = 0;

         for (int var4 = 0; var4 < this.v37; var4++) {
            if (this.v48[var4] && this.v40[var4]) {
               this.v112[var3++] = var4;
            }
         }

         if (var3 != 0 && var2 != null) {
            class_12137 var7 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
            this.v1(var1, this.v172, this.v249, true, this.v198);
            this.v188 = false;

            for (short var5 = 0; var5 < var3; var5 += 128) {
               int var6 = Math.min(128, var3 - var5);
               this.v1(var1, this.v112, var5, var6);
               this.v1(var1, v16, v17, var2, this.v27, var7, var6);
            }
         }
      }
   }

   public void v1(
      CommandEncoder var1,
      GpuTextureView var2,
      @Nullable GpuTextureView var3,
      int var4,
      int var5,
      float[] var6,
      float[] var7,
      float[] var8,
      float[] var9,
      float[] var10,
      float[] var11,
      float[] var12,
      float[] var13,
      int[] var14,
      float[] var15,
      float[] var16,
      float[] var17,
      boolean[] var18,
      int[] var19,
      float[] var20,
      float[] var21,
      float var22
   ) {
      this.v2(var1);
      ByteBuffer var23 = renderSupport47.v1(this.v38);
      class_12137 var24 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      int var25 = var4 + var5;

      for (int var26 = var4; var26 < var25; var26 += 32) {
         int var27 = Math.min(32, var25 - var26);
         var23.clear();

         for (int var28 = var26; var28 < var26 + var27; var28++) {
            BlurDataSupport.v1(
               var23,
               var6[var28],
               var7[var28],
               var8[var28],
               var9[var28],
               this.v164,
               this.v239,
               var22,
               var10[var28],
               var11[var28],
               var12[var28],
               var13[var28],
               var14[var28],
               var15[var28],
               var16[var28],
               var17[var28],
               var18[var28]
            );
            this.v1(var23, var19[var28], var20[var28], var21[var28]);
         }

         var23.flip();
         var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v23)), var23);
         RenderPass var33 = var1.createRenderPass(() -> "syky:blur_tile_composite", var2, OptionalInt.empty(), var3, OptionalDouble.empty());

         try {
            var33.setPipeline(v20);
            cloudSupport27.v1(var33);
            var33.setVertexBuffer(0, this.v33);
            var33.setIndexBuffer(this.v31, class_5595.field_27372);
            var33.bindTexture("Sampler0", this.v10(), var24);
            var33.setUniform("BlurTilePanels", renderSupport31.v1(renderSupport47.v1(this.v23)));
            var33.drawIndexed(0, 0, 6, var27);
         } catch (Throwable var32) {
            if (var33 != null) {
               try {
                  var33.close();
               } catch (Throwable var31) {
                  var32.addSuppressed(var31);
               }
            }

            throw var32;
         }

         if (var33 != null) {
            var33.close();
         }
      }
   }

   private void v1(ByteBuffer var1, int var2, float var3, float var4) {
      float var5 = this.v47[var2] - this.v50[var2] - var3 * this.v172 / this.v164;
      float var6 = this.v49[var2] - this.v60[var2] + var4 * this.v249 / this.v239;
      int var7 = this.v11();
      int var8 = this.v12();
      var1.putFloat(var5 / var7).putFloat(var6 / var8);
      var1.putFloat((float)this.v172 / var7).putFloat((float)this.v249 / var8);
   }

   @Nullable
   private GpuTextureView v10() {
      return this.v190 ? this.v70 : this.v27;
   }

   private int v11() {
      return this.v190 ? this.v172 : this.v28;
   }

   private int v12() {
      return this.v190 ? this.v249 : this.v29;
   }

   public void v3() {
      if (this.v41) {
         int var1 = 0;

         for (int var2 = 0; var2 < this.v37; var2++) {
            if (!this.v48[var2] && this.v44[var2] && this.v73[var2] && this.v74[var2] == 0) {
               this.v98[var1] = this.v59[var2];
               this.v124[var1] = this.v53[var2];
               this.v117[var1] = this.v63[var2];
               this.v45[var1] = this.v64[var2];
               this.v104[var1] = this.v61[var2];
               this.v125[var1] = this.v66[var2];
               this.v141[var1] = this.v68[var2];
               this.v145[var1] = this.v52[var2];
               this.v162[var1] = this.v75[var2];
               var1++;
            }
         }

         this.v119 = var1;

         for (int var3 = 0; var3 < this.v37; var3++) {
            this.v147[var3] = this.v48[var3];
            this.v93[var3] = this.v50[var3];
            this.v157[var3] = this.v60[var3];
            this.v166[var3] = this.v46[var3];
            this.v121[var3] = this.v51[var3];
            this.v137[var3] = this.v47[var3];
            this.v187[var3] = this.v49[var3];
         }

         this.v107 = this.v37;
         this.v118 = this.v190;
         this.v159 = this.v172;
         this.v176 = this.v249;
         this.v41 = false;
         this.v133 = null;
         this.v160 = null;
         this.v70 = null;
      }
   }

   public void v4() {
      this.v107 = 0;
      this.v41 = false;
      this.v133 = null;
      this.v160 = null;
      this.v70 = null;
   }

   public int v5() {
      return this.v185;
   }

   public int v6() {
      return this.v220;
   }

   public int v7() {
      return this.v223;
   }

   public int v8() {
      return this.v169;
   }

   private void v1(CommandEncoder var1, int var2, int var3, boolean var4, float var5) {
      ByteBuffer var6 = renderSupport47.v1(this.v36);
      var6.clear();
      var6.putFloat(var2).putFloat(var3).putFloat(var5).putFloat(this.v76);
      float var7 = Math.max(this.v164 / this.v172, this.v239 / this.v249);
      var6.putFloat(this.v164).putFloat(this.v239).putFloat(var7).putFloat(var4 ? 1.0F : 0.0F);
      var6.putFloat(this.v172).putFloat(this.v249).putFloat(0.0F).putFloat(0.0F);
      var6.flip();
      this.v43.v1(var1, renderSupport47.v1(this.v32), var6);
   }

   private void v1(CommandEncoder var1, int[] var2, int var3, int var4) {
      ByteBuffer var5 = renderSupport47.v1(this.v34);
      var5.clear();

      for (int var6 = var3; var6 < var3 + var4; var6++) {
         int var7 = var2[var6];
         var5.putFloat(this.v47[var7]).putFloat(this.v49[var7]).putFloat(this.v46[var7]).putFloat(this.v51[var7]);
         var5.putFloat(this.v50[var7]).putFloat(this.v60[var7]).putFloat(0.0F).putFloat(0.0F);
         var5.putFloat(this.v59[var7]).putFloat(this.v53[var7]).putFloat(this.v63[var7]).putFloat(this.v64[var7]);
         var5.putFloat(this.v61[var7]).putFloat(this.v66[var7]).putFloat(this.v68[var7]).putFloat(this.v52[var7]);
      }

      var5.flip();
      this.v42.v1(var1, renderSupport47.v1(this.v30), var5);
   }

   private void v1(
      CommandEncoder var1, Supplier<String> var2, RenderPipeline var3, @Nullable GpuTextureView var4, @Nullable GpuTextureView var5, class_12137 var6, int var7
   ) {
      RenderPass var8 = var1.createRenderPass(var2, var4, OptionalInt.empty());

      try {
         var8.setPipeline(var3);
         var8.setVertexBuffer(0, this.v33);
         var8.setIndexBuffer(this.v31, class_5595.field_27372);
         var8.bindTexture("Sampler0", var5, var6);
         var8.setUniform("BlurTileData", renderSupport31.v1(renderSupport47.v1(this.v30)));
         var8.setUniform("BlurTileParams", renderSupport31.v1(renderSupport47.v1(this.v32)));
         var8.drawIndexed(0, 0, 6, var7);
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

   private void v1(int var1, int var2) {
      if (this.v30 == null) {
         try {
            this.v34 = MemoryUtil.memAlloc(8192);
            this.v36 = MemoryUtil.memAlloc(48);
            this.v38 = MemoryUtil.memAlloc(3072);
            GpuDevice var3 = RenderSystem.getDevice();
            short var4 = 136;
            this.v30 = var3.createBuffer(() -> "syky:blur_tile_ubo", var4, 8192L);
            this.v42.v1();
            this.v43.v1();
            this.v188 = false;
            this.v32 = var3.createBuffer(() -> "syky:blur_tile_params_ubo", var4, 48L);
            this.v23 = var3.createBuffer(() -> "syky:blur_tile_panel_ubo", var4, 3072L);
            this.v33 = renderSupport31.v1("syky:blur_tile_dummy_vertex");
            ByteBuffer var5 = MemoryUtil.memAlloc(12);

            try {
               for (short var6 = 0; var6 < 6; var6++) {
                  var5.putShort(var6);
               }

               var5.flip();
               this.v31 = var3.createBuffer(() -> "syky:blur_tile_indices", 64, var5);
            } finally {
               MemoryUtil.memFree(var5);
            }
         } catch (Throwable var11) {
            this.close();
            throw var11;
         }
      }

      int var12 = var1 + 8;
      int var13 = var2 * 2 + 8;
      if (this.v26 == null || this.v28 != var12 || this.v29 != var13) {
         this.v13();
         GpuDevice var14 = RenderSystem.getDevice();
         byte var15 = 12;
         this.v21 = var14.createTexture(() -> "syky:blur_tile_scratch_grid", var15, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v22 = var14.createTextureView(this.v21);
         this.v24 = var14.createTexture(() -> "syky:blur_tile_scratch_atlas", var15, TextureFormat.RGBA8, var12, var13, 1, 1);
         this.v25 = var14.createTextureView(this.v24);
         this.v26 = var14.createTexture(() -> "syky:blur_tile_atlas", var15, TextureFormat.RGBA8, var12, var13, 1, 1);
         this.v27 = var14.createTextureView(this.v26);
         this.v28 = var12;
         this.v29 = var13;
         this.v119 = 0;
         this.v107 = 0;
      }
   }

   private void v13() {
      if (this.v22 != null) {
         this.v22.close();
         this.v22 = null;
      }

      if (this.v21 != null) {
         this.v21.close();
         this.v21 = null;
      }

      if (this.v25 != null) {
         this.v25.close();
         this.v25 = null;
      }

      if (this.v24 != null) {
         this.v24.close();
         this.v24 = null;
      }

      if (this.v27 != null) {
         this.v27.close();
         this.v27 = null;
      }

      if (this.v26 != null) {
         this.v26.close();
         this.v26 = null;
      }

      this.v28 = 0;
      this.v29 = 0;
   }

   @Override
   public void close() {
      this.v41 = false;
      this.v133 = null;
      this.v160 = null;
      this.v70 = null;
      this.v13();
      if (this.v30 != null) {
         this.v30.close();
         this.v30 = null;
      }

      if (this.v32 != null) {
         this.v32.close();
         this.v32 = null;
      }

      if (this.v23 != null) {
         this.v23.close();
         this.v23 = null;
      }

      if (this.v33 != null) {
         this.v33.close();
         this.v33 = null;
      }

      if (this.v31 != null) {
         this.v31.close();
         this.v31 = null;
      }

      if (this.v34 != null) {
         MemoryUtil.memFree(this.v34);
         this.v34 = null;
      }

      if (this.v36 != null) {
         MemoryUtil.memFree(this.v36);
         this.v36 = null;
      }

      if (this.v38 != null) {
         MemoryUtil.memFree(this.v38);
         this.v38 = null;
      }

      this.v119 = 0;
   }

   public interface Part1 {
      boolean v1(int var1, int var2, int var3, int var4);

      void v2(int var1, int var2, int var3, int var4);

      @Nullable
      GpuTextureView v1();

      void v3(int var1, int var2, int var3, int var4);
   }
}
