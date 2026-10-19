package cc.syky.cloud;

import cc.syky.account.accountSupport11;
import cc.syky.account.accountSupport8;
import cc.syky.hud.hudSupport70;
import cc.syky.render.renderSupport27;
import cc.syky.render.renderSupport30;
import cc.syky.render.renderSupport31;
import cc.syky.render.renderSupport33;
import cc.syky.render.renderSupport47;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport162;
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
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class BlurDataSupport implements AutoCloseable {
   public final cloudSupport101 v11;
   private final accountSupport11 v12;
   private static final class_2960 v13 = class_2960.method_60655("syky", "pipeline/blur_downsample");
   private static final class_2960 v14 = class_2960.method_60655("syky", "pipeline/blur_gaussian");
   private static final class_2960 v15 = class_2960.method_60655("syky", "pipeline/blur");
   private static final class_2960 v16 = class_2960.method_60655("syky", "pipeline/blur_batched");
   private static final class_2960 v18 = class_2960.method_60655("syky", "core/util/fullscreen");
   private static final class_2960 v19 = class_2960.method_60655("syky", "core/blur/blur_downsample");
   private static final class_2960 v17 = class_2960.method_60655("syky", "core/blur/gaussian");
   private static final class_2960 v20 = class_2960.method_60655("syky", "core/blur/blur");
   private static final class_2960 v21 = class_2960.method_60655("syky", "core/blur/blur_batched");
   private static final int v22 = 8;
   private static final float v24 = 6.0F;
   public static final float v1 = 11.5F;
   public static final float v2 = 6.0F;
   private static final int v25 = 96;
   private static final int v26 = 16;
   private static final int v27 = 32;
   public static final int v3 = 80;
   private static final int v28 = 2560;
   private static final int v29 = 6;
   private static final Supplier<String> v30 = () -> "syky:blur_gauss_h";
   private static final Supplier<String> v32 = () -> "syky:blur_gauss_v";
   private static final RenderPipeline v23 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v13)
         .withVertexShader(v18)
         .withFragmentShader(v19)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final class_2960 v33 = class_2960.method_60655("syky", "core/blur/blur_downsample_regions");
   private static final RenderPipeline v31 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/blur_downsample_regions"))
         .withVertexShader(v33)
         .withFragmentShader(v19)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurParams", class_10789.field_60031)
         .withUniform("BlurRegions", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final int v34 = 1040;
   private static final RenderPipeline v36 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v14)
         .withVertexShader(v17)
         .withFragmentShader(v17)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurParams", class_10789.field_60031)
         .withSampler("Sampler0")
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v38 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v15)
         .withVertexShader(v20)
         .withFragmentShader(v20)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final RenderPipeline v42 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v16)
         .withVertexShader(v21)
         .withFragmentShader(v21)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("BlurBatchData", class_10789.field_60031)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   @Nullable
   private GpuBuffer v43;
   @Nullable
   private GpuBuffer v37;
   @Nullable
   private GpuBuffer v48;
   @Nullable
   private GpuBuffer v40;
   @Nullable
   private GpuBuffer v44;
   @Nullable
   private GpuBuffer v47;
   @Nullable
   private GpuBuffer v49;
   @Nullable
   private ByteBuffer v46;
   @Nullable
   private ByteBuffer v51;
   @Nullable
   private ByteBuffer v50;
   @Nullable
   private ByteBuffer v60;
   private final renderSupport27 v59 = new renderSupport27(1040);
   private final renderSupport27 v53 = new renderSupport27(16);
   private final float[] v63 = new float[32];
   private final float[] v64 = new float[32];
   private final float[] v61 = new float[32];
   private final float[] v66 = new float[32];
   private final float[] v68 = new float[32];
   private final float[] v52 = new float[32];
   private final float[] v75 = new float[32];
   private final float[] v73 = new float[32];
   private final int[] v74 = new int[32];
   private final float[] v72 = new float[32];
   private final float[] v80 = new float[32];
   private final float[] v84 = new float[32];
   private final boolean[] v94 = new boolean[32];
   private final int[] v82 = new int[32];
   private final float[] v99 = new float[32];
   private final float[] v120 = new float[32];
   private final float[] v88 = new float[32];
   private final float[] v103 = new float[32];
   private int v101;
   @Nullable
   private GpuTexture v96;
   @Nullable
   private GpuTextureView v105;
   @Nullable
   private GpuTexture v87;
   @Nullable
   private GpuTextureView v85;
   @Nullable
   private GpuTexture v119;
   @Nullable
   private GpuTextureView v98;
   @Nullable
   private GpuTextureView v124;
   @Nullable
   private GpuTexture v117;
   @Nullable
   private GpuTextureView v45;
   @Nullable
   private GpuTexture v104;
   @Nullable
   public GpuTextureView v125;
   public final cloudSupport25.Part2 v141 = new cloudSupport25.Part2();
   private boolean v145;
   @Nullable
   private GpuTexture v162;
   @Nullable
   public GpuTextureView v107;
   private boolean v118;
   private int v159;
   private float v176;
   @Nullable
   private GpuTexture v116;
   @Nullable
   public GpuTextureView v147;
   public boolean v93;
   private int v157;
   private int v166;
   private int v121;
   public int v137;
   @Nullable
   private GpuTexture v187;
   @Nullable
   public GpuTextureView v138;
   @Nullable
   public accountSupport8 v106;
   public boolean v100;
   private final BlurTileDataSupport v191 = new BlurTileDataSupport();
   private final BlurTileDataSupport v112 = new BlurTileDataSupport();
   private BlurTileDataSupport v216 = this.v191;
   private static final cloudSupport26.Part1 v41 = var0 -> {};
   private final int[] v190 = new int[4];
   private final cloudSupport26 v70 = new cloudSupport26();
   private final cloudSupport26 v133 = new cloudSupport26();
   private final cloudSupport25.Part2 v160 = new cloudSupport25.Part2();
   private int v172 = -1;
   private int v249 = -1;
   private boolean v164;
   @Nullable
   private cloudSupport26.Part1 v239;
   private boolean v198;
   private final BlurTileDataSupport.Part1 v76 = new BlurTileDataSupport.Part1() {
      @Override
      public boolean v1(int var1, int var2, int var3, int var4) {
         return BlurDataSupport.this.v141.v2(var1, var2, var3, var4, BlurDataSupport.this.v193, BlurDataSupport.this.v175);
      }

      @Override
      public void v2(int var1, int var2, int var3, int var4) {
         class_310 var5 = BlurDataSupport.this.v11.v1();
         if (var5 != null && var5.method_1522() != null) {
            BlurDataSupport.this.v141.v1(var1, var2, var3, var4, BlurDataSupport.this.v193, BlurDataSupport.this.v175);
            CommandEncoder var6 = RenderSystem.getDevice().createCommandEncoder();
            class_12137 var7 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
            GpuTextureView var8 = var5.method_1522().method_71639();
            BlurDataSupport.this.v1(var6, var8, var7, var1, var2, var3, var4);
         }
      }

      @Override
      public void v3(int var1, int var2, int var3, int var4) {
         if (BlurDataSupport.this.v223
            && BlurDataSupport.this.v169
            && !BlurDataSupport.this.v153.v2(var1, var2, var3, var4, BlurDataSupport.this.v193, BlurDataSupport.this.v175)) {
            BlurDataSupport.v10++;
            BlurDataSupport.this.v1(var1, var2, var3, var4);
         }
      }

      @Nullable
      @Override
      public GpuTextureView v1() {
         if (BlurDataSupport.this.v223) {
            return BlurDataSupport.this.v107;
         } else if (BlurDataSupport.this.v137 != 0) {
            if (!BlurDataSupport.this.v93 && BlurDataSupport.this.v125 != null && BlurDataSupport.this.v147 != null) {
               CommandEncoder var4 = RenderSystem.getDevice().createCommandEncoder();
               class_12137 var5 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
               BlurDataSupport.this.v1(
                  var4,
                  BlurDataSupport.this.v125,
                  BlurDataSupport.this.v193,
                  BlurDataSupport.this.v175,
                  BlurDataSupport.this.v147,
                  var5,
                  BlurDataSupport.this.v185,
                  BlurDataSupport.this.v220
               );
               BlurDataSupport.this.v93 = true;
            }

            return BlurDataSupport.this.v147;
         } else {
            accountSupport8 var1 = BlurDataSupport.this.v106;
            if (var1 != null && BlurDataSupport.this.v125 != null && BlurDataSupport.this.v138 != null) {
               if (!BlurDataSupport.this.v100) {
                  CommandEncoder var2 = RenderSystem.getDevice().createCommandEncoder();
                  class_12137 var3 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
                  BlurDataSupport.this.v1(
                     var2, BlurDataSupport.this.v125, BlurDataSupport.this.v193, BlurDataSupport.this.v175, BlurDataSupport.this.v138, var3
                  );
                  var1.v1(BlurDataSupport.this.v138, BlurDataSupport.this.v125);
                  BlurDataSupport.this.v100 = true;
               }

               return BlurDataSupport.this.v138;
            } else {
               return null;
            }
         }
      }
   };
   public float v185;
   public float v220;
   public boolean v223;
   public boolean v169;
   public final cloudSupport25.Part2 v153 = new cloudSupport25.Part2();
   public static boolean v4 = true;
   private boolean v143;
   public static boolean v5 = true;
   public static long v6;
   public static long v7;
   public static long v8;
   public static long v9;
   public static long v10;
   private int v188;
   private int v228;
   public int v193;
   public int v175;
   private long v241;
   private long v217 = -1L;
   private boolean v252;
   private final uiSupport162 v281 = new uiSupport162();
   private long v254 = -1L;
   private int v186;
   private int v199;
   private float v332;
   private float v251;
   private float v203;

   public BlurDataSupport(cloudSupport101 var1, accountSupport11 var2) {
      this.v12 = var2;
      this.v11 = var1;
   }

   public void v1() {
      this.v241++;
      this.v223 = false;
      this.v169 = false;
      this.v124 = null;
      this.v101 = 0;
      this.v164 = false;
      this.v106 = null;
      this.v100 = false;
      this.v121 = 0;
      this.v137 = 0;
      this.v166 = 0;
      this.v145 = false;
      this.v118 = false;
      this.v239 = null;
      if (this.v191.v1()) {
         this.v191.v4();
      }

      if (this.v112.v1()) {
         this.v112.v4();
      }

      this.v216 = this.v191;
      this.v20();
   }

   public void v2() {
      if (hudSupport70.v1()) {
         class_310 var1 = this.v11.v1();
         if (var1 != null && var1.method_1522() != null && var1.method_1522().method_30277() != null) {
            this.v26();
            this.v1(var1);
            this.v2(this.v186, this.v199);
            if (this.v217 != this.v241) {
               this.v281.v1(false);
               int var2 = this.v12.v1("gpu.blur.capture");

               try {
                  this.v2(var1);
               } finally {
                  this.v12.v1(var2);
               }

               this.v217 = this.v241;
            }
         }
      }
   }

   public void v1(float var1, float var2, float var3, float var4) {
      if (!v5 || hudSupport70.v6() || !(var3 > 0.0F) || !(var4 > 0.0F)) {
         this.v2();
      } else if (hudSupport70.v1()) {
         class_310 var5 = this.v11.v1();
         if (var5 != null && var5.method_1522() != null && var5.method_1522().method_30277() != null) {
            this.v26();
            this.v1(var5);
            this.v2(this.v186, this.v199);
            if (this.v217 != this.v241) {
               this.v281.v1(false);
               int var6 = this.v12.v1("gpu.blur.capture");

               try {
                  cloudSupport25.v1(
                     var1 + renderSupport33.v2(),
                     var2 + renderSupport33.v3(),
                     var3,
                     var4,
                     cloudSupport25.v1(0.0F),
                     this.v251,
                     this.v203,
                     this.v193,
                     this.v175,
                     this.v190
                  );
                  int var7 = this.v190[0];
                  int var8 = this.v190[1];
                  int var9 = var7 + this.v190[2] - 1;
                  int var10 = var8 + this.v190[3] - 1;
                  this.v22();
                  CommandEncoder var11 = RenderSystem.getDevice().createCommandEncoder();
                  class_12137 var12 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
                  this.v141.v1();
                  this.v141.v1(var7, var8, var9, var10, this.v193, this.v175);
                  this.v1(var11, var5.method_1522().method_71639(), var12, var7, var8, var9, var10);
                  this.v145 = true;
                  this.v143 = true;
                  v6++;
               } finally {
                  this.v12.v1(var6);
               }

               this.v217 = this.v241;
            }
         }
      }
   }

   public uiSupport162 v3() {
      return this.v281;
   }

   public void v1(cloudSupport26.Part1 var1, boolean var2, boolean var3) {
      if (!this.v164) {
         this.v216 = this.v191;
         this.v2(var1, var2, var3);
      }
   }

   public void v4() {
      if (!this.v164) {
         this.v216 = this.v112;
         this.v2(v41, false, false);
         if (!this.v164) {
            this.v216 = this.v191;
         }
      }
   }

   private void v2(cloudSupport26.Part1 var1, boolean var2, boolean var3) {
      if (hudSupport70.v1()) {
         class_310 var4 = this.v11.v1();
         if (var4 != null && var4.method_1522() != null && var4.method_1522().method_30277() != null) {
            this.v26();
            this.v1(var4);
            this.v2(this.v186, this.v199);
            this.v17();
            if (hudSupport70.v6()) {
               if (var2) {
                  this.v281.v1(true);
                  int var5 = this.v12.v1("gpu.blur.recapture");

                  try {
                     this.v2(var4);
                  } finally {
                     this.v12.v1(var5);
                  }

                  this.v217 = this.v241;
               }
            } else {
               this.v164 = true;
               if (var3) {
                  this.v239 = var1;
                  this.v198 = var2;
               } else {
                  this.v239 = null;
                  this.v1(var4, var1, var2, false);
               }
            }
         }
      }
   }

   public void v5() {
      cloudSupport26.Part1 var1 = this.v239;
      if (var1 != null) {
         this.v239 = null;
         class_310 var2 = this.v11.v1();
         if (var2 != null && var2.method_1522() != null) {
            this.v1(var2, var1, this.v198, true);
         }
      }
   }

   private void v1(class_310 var1, cloudSupport26.Part1 var2, boolean var3, boolean var4) {
      this.v70.v1();
      var2.fill(this.v70);
      boolean var5 = var3 || var4 || this.v217 != this.v241;
      if (var5) {
         this.v281.v1(var3);
      }

      int var6 = this.v12.v1(var3 ? "gpu.blur.recapture" : "gpu.blur.capture");

      try {
         CommandEncoder var7 = RenderSystem.getDevice().createCommandEncoder();
         if (var4) {
            this.v22();
            this.v1(var1, var7, this.v70);
            this.v217 = -1L;
         } else if (var5) {
            this.v2(var1);
            this.v217 = this.v241;
         }

         if (!var4 && this.v70.v2() > 0) {
            this.v22();
         }

         this.v216
            .v1(
               renderSupport47.v1(this.v125),
               this.v76,
               this.v193,
               this.v175,
               this.v251,
               this.v203,
               6.0F * hudSupport70.v2(),
               hudSupport70.v5(),
               renderSupport47.v1(this.v105),
               var4
            );
         this.v20();
         this.v216.v1(var7, this.v70, this.v101, this.v99, this.v120, this.v61, this.v66, this.v68, this.v52, this.v75, this.v73, this.v80);
         this.v216.v1(var7);
      } finally {
         this.v12.v1(var6);
      }
   }

   public void v6() {
      if (this.v164) {
         this.v17();
         this.v164 = false;
         this.v239 = null;
         BlurTileDataSupport var1 = this.v216;
         this.v216 = this.v191;
         this.v20();
         if (var1.v1()) {
            long var2 = this.v141.v3() ? (long)this.v193 * this.v175 : this.v141.v5();
            this.v281.v1(var1.v5(), var1.v6(), var1.v7(), var1.v8(), var2);
            var1.v3();
         }
      }
   }

   private void v20() {
      float var1 = 6.0F * hudSupport70.v2();
      if (this.v223 && this.v166 != 0) {
         float var2 = Math.min(this.v176, 11.5F) * (float)Math.sqrt(this.v159);
         this.v216.v1(this.v166, var2, false);
      } else if (this.v137 != 0) {
         this.v216.v1(this.v137, var1, true);
      } else if (this.v106 != null && this.v121 != 0) {
         this.v216.v1(this.v121, var1, true);
      } else {
         this.v216.v1(0, var1, false);
      }
   }

   private int v21() {
      this.v157 = this.v157 == Integer.MAX_VALUE ? 1 : this.v157 + 1;
      return this.v157;
   }

   private void v22() {
      if (this.v145) {
         this.v145 = false;
         if (this.v143) {
            this.v143 = false;
            class_310 var1 = this.v11.v1();
            if (!this.v141.v3() && var1 != null && var1.method_1522() != null) {
               v7++;
               CommandEncoder var2 = RenderSystem.getDevice().createCommandEncoder();
               this.v1(
                  var2,
                  var1.method_1522().method_71639(),
                  this.v186,
                  this.v199,
                  this.v125,
                  RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false)
               );
               this.v141.v2();
            }
         }

         CommandEncoder var5 = RenderSystem.getDevice().createCommandEncoder();
         class_12137 var6 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
         GpuTextureView var3 = this.v125;

         for (int var4 = 0; var4 < 1; var4++) {
            this.v1(var5, var3, this.v85, var6, true);
            this.v1(var5, this.v85, this.v105, var6, false);
            var3 = this.v105;
         }
      }
   }

   private void v24() {
      if (this.v118) {
         this.v118 = false;
         if (this.v169 && !this.v153.v3()) {
            v10++;
            this.v1(0, 0, this.v193 - 1, this.v175 - 1);
         }

         CommandEncoder var1 = RenderSystem.getDevice().createCommandEncoder();
         class_12137 var2 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
         GpuTextureView var3 = this.v107;

         for (int var4 = 0; var4 < this.v159; var4++) {
            this.v1(var1, var3, this.v85, var2, true, this.v176);
            this.v1(var1, this.v85, this.v98, var2, false, this.v176);
            var3 = this.v98;
         }
      }
   }

   private void v1(class_310 var1, CommandEncoder var2, cloudSupport26 var3) {
      if (this.v172 != this.v193 || this.v249 != this.v175 || !var3.v1(this.v133)) {
         this.v1(var3);
      }

      this.v141.v1(this.v160);
      this.v143 = false;
      class_12137 var4 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      GpuTextureView var5 = var1.method_1522().method_71639();
      if (this.v141.v3()) {
         this.v1(var2, var5, this.v186, this.v199, this.v125, var4);
      } else {
         int var6 = this.v141.v4();
         if (var6 != 0) {
            this.v1(this.v186, this.v199, 0.0F, 0.0F);
            this.v53.v1(var2, renderSupport47.v1(this.v44), renderSupport47.v1(this.v50));
            ByteBuffer var7 = renderSupport47.v1(this.v60);
            var7.clear();
            var7.putFloat(this.v193).putFloat(this.v175).putFloat(0.0F).putFloat(0.0F);

            for (int var8 = 0; var8 < var6; var8++) {
               var7.putFloat(this.v141.v1(var8)).putFloat(this.v141.v2(var8));
               var7.putFloat(this.v141.v3(var8)).putFloat(this.v141.v4(var8));
            }

            var7.flip();
            this.v59.v1(var2, renderSupport47.v1(this.v40), var7);
            RenderPass var13 = var2.createRenderPass(() -> "syky:blur_downsample_regions", this.v125, OptionalInt.empty());

            try {
               var13.setPipeline(v31);
               var13.setVertexBuffer(0, this.v47);
               var13.setIndexBuffer(this.v49, class_5595.field_27372);
               var13.bindTexture("Sampler0", var5, var4);
               var13.setUniform("BlurParams", renderSupport31.v1(renderSupport47.v1(this.v44)));
               var13.setUniform("BlurRegions", renderSupport31.v1(renderSupport47.v1(this.v40)));
               var13.drawIndexed(0, 0, 6, var6);
            } catch (Throwable var12) {
               if (var13 != null) {
                  try {
                     var13.close();
                  } catch (Throwable var11) {
                     var12.addSuppressed(var11);
                  }
               }

               throw var12;
            }

            if (var13 != null) {
               var13.close();
            }
         }
      }
   }

   private void v1(cloudSupport26 var1) {
      this.v160.v1();
      float var2 = cloudSupport25.v1(0.0F);

      for (int var3 = 0; var3 < var1.v2(); var3++) {
         if (var1.v3(var3) > 0.0F && var1.v4(var3) > 0.0F) {
            cloudSupport25.v1(var1.v1(var3), var1.v2(var3), var1.v3(var3), var1.v4(var3), var2, this.v251, this.v203, this.v193, this.v175, this.v190);
            int var4 = this.v190[0];
            int var5 = this.v190[1];
            if (!this.v160.v1(var4, var5, var4 + this.v190[2] - 1, var5 + this.v190[3] - 1, this.v193, this.v175)) {
               this.v160.v2();
               break;
            }
         }
      }

      this.v133.v2(var1);
      this.v172 = this.v193;
      this.v249 = this.v175;
   }

   public void v1(CommandEncoder var1, GpuTextureView var2, class_12137 var3, int var4, int var5, int var6, int var7) {
      this.v1(var1, var2, var3, this.v125, var4, var5, var6, var7);
   }

   public void v1(int var1, int var2, int var3, int var4) {
      class_310 var5 = this.v11.v1();
      if (var5 != null && var5.method_1522() != null) {
         if (!this.v153.v1(var1, var2, var3, var4, this.v193, this.v175)) {
            this.v153.v2();
            var1 = 0;
            var2 = 0;
            var3 = this.v193 - 1;
            var4 = this.v175 - 1;
         }

         CommandEncoder var6 = RenderSystem.getDevice().createCommandEncoder();
         class_12137 var7 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
         this.v1(var6, var5.method_1522().method_71639(), var7, this.v107, var1, var2, var3, var4);
      }
   }

   private void v1(CommandEncoder var1, GpuTextureView var2, class_12137 var3, @Nullable GpuTextureView var4, int var5, int var6, int var7, int var8) {
      var5 = Math.max(var5, 0);
      var6 = Math.max(var6, 0);
      var7 = Math.min(var7, this.v193 - 1);
      var8 = Math.min(var8, this.v175 - 1);
      if (var5 <= var7 && var6 <= var8) {
         this.v1(var1, this.v186, this.v199, 0.0F, 0.0F);
         RenderPass var9 = var1.createRenderPass(() -> "syky:blur_downsample_rect", var4, OptionalInt.empty());

         try {
            var9.setPipeline(v23);
            var9.enableScissor(var5, var6, var7 - var5 + 1, var8 - var6 + 1);
            var9.setVertexBuffer(0, this.v47);
            var9.bindTexture("Sampler0", var2, var3);
            var9.setUniform("BlurParams", renderSupport31.v1(renderSupport47.v1(this.v48)));
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
   }

   public void v1(@Nullable accountSupport8 var1, @Nullable accountSupport8 var2) {
      this.v1(var1, var2, 1, 6.0F * hudSupport70.v2());
   }

   public void v1(@Nullable accountSupport8 var1, @Nullable accountSupport8 var2, int var3, float var4) {
      this.v1(var1, var2, var3, var4, 0.0F, 0.0F, 0.0F, 0.0F);
   }

   public void v1(@Nullable accountSupport8 var1, @Nullable accountSupport8 var2, int var3, float var4, float var5, float var6, float var7, float var8) {
      if (hudSupport70.v1()) {
         class_310 var9 = this.v11.v1();
         if (var9 != null && var9.method_1522() != null && var9.method_1522().method_30277() != null) {
            this.v26();
            this.v1(var9);
            this.v2(this.v186, this.v199);
            this.v281.v1();
            CommandEncoder var10 = RenderSystem.getDevice().createCommandEncoder();
            class_12137 var11 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
            GpuTextureView var12 = var9.method_1522().method_71639();
            boolean var13 = v4
               && var7 > 0.0F
               && var8 > 0.0F
               && this.v185 == 0.0F
               && this.v220 == 0.0F
               && (var1 == null || !var1.v12())
               && (var2 == null || !var2.v12());
            v8++;
            int var14 = this.v12.v1("gpu.blur.nested");

            try {
               if (var13) {
                  cloudSupport25.v1(
                     var5 + renderSupport33.v2(),
                     var6 + renderSupport33.v3(),
                     var7,
                     var8,
                     cloudSupport25.v1(0.0F),
                     this.v251,
                     this.v203,
                     this.v193,
                     this.v175,
                     this.v190
                  );
                  this.v153.v1();
                  this.v169 = true;
                  v9++;
                  this.v1(this.v190[0], this.v190[1], this.v190[0] + this.v190[2] - 1, this.v190[1] + this.v190[3] - 1);
               } else {
                  this.v169 = false;
                  this.v1(var10, var12, this.v186, this.v199, this.v107, var11, this.v185, this.v220);
                  this.v1(var10, var1, var2, var12, var11);
               }
            } finally {
               this.v12.v1(var14);
            }

            this.v159 = Math.max(1, var3);
            this.v176 = var4;
            this.v118 = true;
            this.v223 = true;
            this.v166 = this.v21();
            this.v20();
         }
      }
   }

   public void v7() {
      this.v223 = false;
      this.v166 = 0;
      this.v20();
   }

   private void v1(CommandEncoder var1, @Nullable accountSupport8 var2, GpuTextureView var3, class_12137 var4) {
      if (var2 != null && var2.v12()) {
         this.v1(var1, var3, this.v186, this.v199, this.v85, var4);
         var2.v1(this.v107, this.v85);
         var2.v1(this.v107, this.v193, this.v175);
      }
   }

   private void v1(CommandEncoder var1, @Nullable accountSupport8 var2, @Nullable accountSupport8 var3, GpuTextureView var4, class_12137 var5) {
      this.v1(var1, var2, var4, var5);
      if (var3 != null && var3.v12()) {
         var3.v1(this.v107, this.v193, this.v175);
      }
   }

   public boolean v1(@Nullable GpuTextureView var1) {
      if (var1 != null && this.v14()) {
         GpuTextureView var2 = this.v13();
         if (var2 == null) {
            return false;
         } else {
            CommandEncoder var3 = RenderSystem.getDevice().createCommandEncoder();
            class_12137 var4 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
            this.v1(var3, var2, this.v193, this.v175, var1, var4);
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean v8() {
      if (!hudSupport70.v4()) {
         return false;
      } else {
         this.v5();
         return this.v216.v1() || this.v217 == this.v241;
      }
   }

   @Nullable
   public GpuTextureView v9() {
      this.v5();
      GpuTextureView var1 = this.v25();
      if (var1 != null) {
         this.v281.v2();
      }

      return var1;
   }

   @Nullable
   private GpuTextureView v25() {
      if (this.v223) {
         this.v24();
         return this.v98;
      } else if (this.v124 != null) {
         return this.v124;
      } else {
         this.v22();
         return this.v105;
      }
   }

   public void v2(@Nullable GpuTextureView var1) {
      this.v124 = var1;
   }

   public void v10() {
      this.v124 = null;
   }

   public void v1(accountSupport8 var1) {
      this.v106 = var1;
      this.v100 = false;
      this.v121 = this.v21();
      this.v20();
   }

   public void v11() {
      this.v106 = null;
      this.v100 = false;
      this.v121 = 0;
      this.v20();
   }

   public boolean v1(float var1, float var2) {
      class_310 var3 = this.v11.v1();
      if (var3 != null && var3.method_1522() != null && this.v14() && this.v105 != null) {
         this.v26();
         this.v1(var3);
         this.v2(this.v186, this.v199);
         if (this.v45 != null && !(this.v251 <= 0.0F) && !(this.v203 <= 0.0F)) {
            this.v185 = -var1 / this.v251;
            this.v220 = var2 / this.v203;
            this.v22();
            CommandEncoder var4 = RenderSystem.getDevice().createCommandEncoder();
            class_12137 var5 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
            this.v1(var4, this.v105, this.v193, this.v175, this.v45, var5, this.v185, this.v220);
            this.v124 = this.v45;
            this.v93 = false;
            this.v137 = this.v21();
            this.v20();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void v12() {
      this.v124 = null;
      this.v185 = 0.0F;
      this.v220 = 0.0F;
      this.v137 = 0;
      this.v20();
   }

   @Nullable
   public GpuTextureView v13() {
      this.v5();
      if (this.v223) {
         this.v24();
      } else {
         this.v22();
      }

      GpuTextureView var1 = this.v223 ? this.v98 : this.v105;
      if (var1 != null) {
         this.v281.v2();
      }

      return var1;
   }

   public boolean v14() {
      this.v5();
      return (this.v216.v1() || this.v217 == this.v241) && this.v105 != null;
   }

   public int v15() {
      return this.v193;
   }

   public int v16() {
      return this.v175;
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, 1.0F, 0.0F);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, float var10, float var11) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, 0.0F, false);
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
      int var9,
      float var10,
      float var11,
      float var12,
      boolean var13
   ) {
      if (!(var10 <= 0.0F)) {
         if (!(var3 <= 0.0F) && !(var4 <= 0.0F) && hudSupport70.v1()) {
            class_310 var14 = this.v11.v1();
            if (var14 != null && var14.method_1522() != null && var14.method_1522().method_30277() != null) {
               if (this.v164) {
                  if (this.v101 == 32) {
                     this.v17();
                  }

                  int var15 = this.v101;
                  if (this.v1(var15, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13)) {
                     this.v1(var14, var15, 1);
                  }
               } else {
                  this.v2();
                  var1 += renderSupport33.v2();
                  var2 += renderSupport33.v3();
                  if (!(var1 + var3 <= 0.0F) && !(var2 + var4 <= 0.0F) && !(var1 >= this.v251) && !(var2 >= this.v203)) {
                     this.v281.v2();
                     this.v1(var14, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
                  }
               }
            }
         }
      }
   }

   private boolean v1(
      int var1,
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
      boolean var14
   ) {
      float var15 = renderSupport33.v2();
      float var16 = renderSupport33.v3();
      float var17 = var2 + var15;
      float var18 = var3 + var16;
      if (!(var17 + var4 <= 0.0F) && !(var18 + var5 <= 0.0F) && !(var17 >= this.v251) && !(var18 >= this.v203)) {
         this.v99[var1] = var2;
         this.v120[var1] = var3;
         this.v63[var1] = var17;
         this.v64[var1] = var18;
         this.v61[var1] = var4;
         this.v66[var1] = var5;
         this.v68[var1] = var6;
         this.v52[var1] = var7;
         this.v75[var1] = var8;
         this.v73[var1] = var9;
         this.v74[var1] = var10;
         this.v72[var1] = var11;
         this.v80[var1] = var12;
         this.v84[var1] = var13;
         this.v94[var1] = var14;
         this.v88[var1] = var15;
         this.v103[var1] = var16;
         return true;
      } else {
         return false;
      }
   }

   private void v1(class_310 var1, int var2, int var3) {
      this.v5();
      if (this.v216.v1()) {
         boolean var9 = this.v216.v2();
         int var5 = var2;

         for (int var6 = var2; var6 < var2 + var3; var6++) {
            this.v281.v2();
            if (var9) {
               this.v99[var6] = this.v63[var6];
               this.v120[var6] = this.v64[var6];
               this.v88[var6] = 0.0F;
               this.v103[var6] = 0.0F;
            }

            int var7 = this.v216
               .v1(
                  this.v99[var6],
                  this.v120[var6],
                  this.v61[var6],
                  this.v66[var6],
                  this.v68[var6],
                  this.v52[var6],
                  this.v75[var6],
                  this.v73[var6],
                  this.v80[var6]
               );
            if (var7 < 0) {
               this.v1(
                  var1,
                  this.v63[var6],
                  this.v64[var6],
                  this.v61[var6],
                  this.v66[var6],
                  this.v68[var6],
                  this.v52[var6],
                  this.v75[var6],
                  this.v73[var6],
                  this.v74[var6],
                  this.v72[var6],
                  this.v80[var6],
                  this.v84[var6],
                  this.v94[var6]
               );
            } else {
               if (var5 != var6) {
                  this.v1(var6, var5);
               }

               this.v82[var5++] = var7;
            }
         }

         if (var5 != var2) {
            var3 = var5 - var2;
            CommandEncoder var10 = RenderSystem.getDevice().createCommandEncoder();
            this.v216
               .v1(
                  var10,
                  renderSupport30.v1(var1),
                  var1.method_1522().method_71640(),
                  var2,
                  var3,
                  this.v63,
                  this.v64,
                  this.v61,
                  this.v66,
                  this.v68,
                  this.v52,
                  this.v75,
                  this.v73,
                  this.v74,
                  this.v72,
                  this.v80,
                  this.v84,
                  this.v94,
                  this.v82,
                  this.v88,
                  this.v103,
                  this.v332
               );
         }
      } else {
         for (int var4 = var2; var4 < var2 + var3; var4++) {
            this.v281.v2();
            this.v1(
               var1,
               this.v63[var4],
               this.v64[var4],
               this.v61[var4],
               this.v66[var4],
               this.v68[var4],
               this.v52[var4],
               this.v75[var4],
               this.v73[var4],
               this.v74[var4],
               this.v72[var4],
               this.v80[var4],
               this.v84[var4],
               this.v94[var4]
            );
         }
      }
   }

   private void v1(int var1, int var2) {
      this.v63[var2] = this.v63[var1];
      this.v64[var2] = this.v64[var1];
      this.v61[var2] = this.v61[var1];
      this.v66[var2] = this.v66[var1];
      this.v68[var2] = this.v68[var1];
      this.v52[var2] = this.v52[var1];
      this.v75[var2] = this.v75[var1];
      this.v73[var2] = this.v73[var1];
      this.v74[var2] = this.v74[var1];
      this.v72[var2] = this.v72[var1];
      this.v80[var2] = this.v80[var1];
      this.v84[var2] = this.v84[var1];
      this.v94[var2] = this.v94[var1];
      this.v99[var2] = this.v99[var1];
      this.v120[var2] = this.v120[var1];
      this.v88[var2] = this.v88[var1];
      this.v103[var2] = this.v103[var1];
   }

   public boolean v18() {
      return this.v164 && !cloudSupport27.v4() && this.v101 < 32;
   }

   public void v2(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      this.v2(var1, var2, var3, var4, var5, var6, var7, var8, var9, 1.0F, 0.0F);
   }

   public void v2(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, float var10, float var11) {
      this.v2(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, 0.0F, false);
   }

   public void v2(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      float var10,
      float var11,
      float var12,
      boolean var13
   ) {
      if (!(var10 <= 0.0F)) {
         if (!(var3 <= 0.0F) && !(var4 <= 0.0F) && hudSupport70.v1()) {
            class_310 var14 = this.v11.v1();
            if (var14 != null && var14.method_1522() != null && var14.method_1522().method_30277() != null) {
               if (this.v164) {
                  if (this.v101 >= 32) {
                     this.v17();
                  }

                  int var18 = this.v101;
                  if (this.v1(var18, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13)) {
                     if (cloudSupport27.v4()) {
                        this.v1(var14, var18, 1);
                     } else {
                        this.v101 = var18 + 1;
                     }
                  }
               } else {
                  this.v2();
                  var1 += renderSupport33.v2();
                  var2 += renderSupport33.v3();
                  if (!(var1 + var3 <= 0.0F) && !(var2 + var4 <= 0.0F) && !(var1 >= this.v251) && !(var2 >= this.v203)) {
                     this.v281.v2();
                     if (cloudSupport27.v4()) {
                        this.v1(var14, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
                     } else {
                        if (this.v101 >= 32) {
                           this.v17();
                        }

                        int var15 = this.v101;
                        this.v63[var15] = var1;
                        this.v64[var15] = var2;
                        this.v61[var15] = var3;
                        this.v66[var15] = var4;
                        this.v68[var15] = var5;
                        this.v52[var15] = var6;
                        this.v75[var15] = var7;
                        this.v73[var15] = var8;
                        this.v74[var15] = var9;
                        this.v72[var15] = var10;
                        this.v80[var15] = var11;
                        this.v84[var15] = var12;
                        this.v94[var15] = var13;
                        this.v101 = var15 + 1;
                     }
                  }
               }
            }
         }
      }
   }

   public boolean v19() {
      return this.v101 > 0;
   }

   public void v17() {
      if (this.v101 != 0) {
         class_310 var1 = this.v11.v1();
         if (var1 != null && var1.method_1522() != null && var1.method_1522().method_30277() != null) {
            int var2 = this.v12.v1("gpu.blur.composite");

            try {
               if (this.v164) {
                  this.v1(var1, 0, this.v101);
               } else {
                  this.v3(var1);
               }
            } finally {
               this.v12.v1(var2);
            }

            this.v101 = 0;
         } else {
            this.v101 = 0;
         }
      }
   }

   private void v1(class_310 var1) {
      if (this.v254 != this.v241) {
         int var2 = var1.method_1522().field_1482;
         int var3 = var1.method_1522().field_1481;
         float var4 = var1.method_22683().method_4495();
         this.v186 = var2;
         this.v199 = var3;
         this.v332 = var4;
         this.v251 = var2 / var4;
         this.v203 = var3 / var4;
         this.v254 = this.v241;
      }
   }

   private void v26() {
      if (!this.v252) {
         try {
            this.v46 = MemoryUtil.memAlloc(96);
            this.v51 = MemoryUtil.memAlloc(2560);
            this.v50 = MemoryUtil.memAlloc(16);
            this.v60 = MemoryUtil.memAlloc(1040);
            this.v47 = renderSupport31.v1("syky:blur_dummy_vertex");
            ByteBuffer var1 = MemoryUtil.memAlloc(12);

            try {
               for (short var2 = 0; var2 < 6; var2++) {
                  var1.putShort(var2);
               }

               var1.flip();
               this.v49 = RenderSystem.getDevice().createBuffer(() -> "syky:blur_quad_indices", 64, var1);
            } finally {
               MemoryUtil.memFree(var1);
            }

            this.v43 = RenderSystem.getDevice().createBuffer(() -> "syky:blur_composite_ubo", 136, 96L);
            this.v37 = RenderSystem.getDevice().createBuffer(() -> "syky:blur_batched_ubo", 136, 2560L);
            this.v48 = RenderSystem.getDevice().createBuffer(() -> "syky:blur_params_ubo", 136, 16L);
            this.v40 = RenderSystem.getDevice().createBuffer(() -> "syky:blur_regions_ubo", 136, 1040L);
            this.v59.v1();
            this.v44 = RenderSystem.getDevice().createBuffer(() -> "syky:blur_region_params_ubo", 136, 16L);
            this.v53.v1();
            this.v252 = true;
         } catch (Throwable var7) {
            this.close();
            throw var7;
         }
      }
   }

   private void v2(int var1, int var2) {
      if (this.v96 == null || this.v188 != var1 || this.v228 != var2) {
         this.v27();
         this.v193 = Math.max(1, var1 / 8);
         this.v175 = Math.max(1, var2 / 8);
         this.v96 = this.v1("blur_a", this.v193, this.v175, 12);
         this.v105 = RenderSystem.getDevice().createTextureView(this.v96);
         this.v104 = this.v1("blur_raw", this.v193, this.v175, 12);
         this.v125 = RenderSystem.getDevice().createTextureView(this.v104);
         this.v141.v1();
         this.v187 = this.v1("raw_warp", this.v193, this.v175, 12);
         this.v138 = RenderSystem.getDevice().createTextureView(this.v187);
         this.v100 = false;
         this.v116 = this.v1("raw_shift", this.v193, this.v175, 12);
         this.v147 = RenderSystem.getDevice().createTextureView(this.v116);
         this.v93 = false;
         this.v162 = this.v1("nested_raw", this.v193, this.v175, 12);
         this.v107 = RenderSystem.getDevice().createTextureView(this.v162);
         this.v145 = false;
         this.v118 = false;
         this.v87 = this.v1("blur_b", this.v193, this.v175, 12);
         this.v85 = RenderSystem.getDevice().createTextureView(this.v87);
         this.v119 = this.v1("blur_c", this.v193, this.v175, 12);
         this.v98 = RenderSystem.getDevice().createTextureView(this.v119);
         this.v117 = this.v1("blur_d", this.v193, this.v175, 12);
         this.v45 = RenderSystem.getDevice().createTextureView(this.v117);
         this.v188 = var1;
         this.v228 = var2;
         this.v223 = false;
         this.v217 = -1L;
      }
   }

   private GpuTexture v1(String var1, int var2, int var3, int var4) {
      return RenderSystem.getDevice().createTexture(() -> "syky:blur_" + var1, var4, TextureFormat.RGBA8, var2, var3, 1, 1);
   }

   private void v2(class_310 var1) {
      CommandEncoder var2 = RenderSystem.getDevice().createCommandEncoder();
      class_12137 var3 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      GpuTextureView var4 = var1.method_1522().method_71639();
      this.v1(var2, var4, this.v186, this.v199, this.v125, var3);
      this.v141.v2();
      this.v143 = false;
      this.v145 = true;
   }

   public void v1(CommandEncoder var1, GpuTextureView var2, int var3, int var4, @Nullable GpuTextureView var5, class_12137 var6) {
      this.v1(var1, var2, var3, var4, var5, var6, 0.0F, 0.0F);
   }

   public void v1(CommandEncoder var1, GpuTextureView var2, int var3, int var4, @Nullable GpuTextureView var5, class_12137 var6, float var7, float var8) {
      this.v1(var1, var3, var4, var7, var8);
      RenderPass var9 = var1.createRenderPass(() -> "syky:blur_downsample", var5, OptionalInt.empty());

      try {
         var9.setPipeline(v23);
         var9.setVertexBuffer(0, this.v47);
         var9.bindTexture("Sampler0", var2, var6);
         var9.setUniform("BlurParams", renderSupport31.v1(renderSupport47.v1(this.v48)));
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

   private void v1(CommandEncoder var1, int var2, int var3, float var4, float var5) {
      this.v1(var2, var3, var4, var5);
      var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v48)), renderSupport47.v1(this.v50));
   }

   private void v1(int var1, int var2, float var3, float var4) {
      ByteBuffer var5 = renderSupport47.v1(this.v50);
      var5.clear();
      float var6 = Math.max(1.0F, (float)var1 / this.v193) / 4.0F;
      var5.putFloat(var6 / var1).putFloat(var6 / var2).putFloat(var3).putFloat(var4);
      var5.flip();
   }

   private void v1(CommandEncoder var1, @Nullable GpuTextureView var2, @Nullable GpuTextureView var3, class_12137 var4, boolean var5) {
      this.v1(var1, var2, var3, var4, var5, 6.0F * hudSupport70.v2());
   }

   private void v1(CommandEncoder var1, @Nullable GpuTextureView var2, @Nullable GpuTextureView var3, class_12137 var4, boolean var5, float var6) {
      ByteBuffer var7 = renderSupport47.v1(this.v50);
      var7.clear();
      float var8 = Math.min(Math.max(var6, 0.0F), 11.5F);
      float var9 = hudSupport70.v5();
      if (var5) {
         var7.putFloat(1.0F / this.v193).putFloat(0.0F).putFloat(var9).putFloat(var8);
      } else {
         var7.putFloat(0.0F).putFloat(1.0F / this.v175).putFloat(var9).putFloat(var8);
      }

      var7.flip();
      var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v48)), var7);
      Supplier var10 = var5 ? v30 : v32;
      RenderPass var11 = var1.createRenderPass(var10, var3, OptionalInt.empty());

      try {
         var11.setPipeline(v36);
         var11.setVertexBuffer(0, this.v47);
         var11.bindTexture("Sampler0", var2, var4);
         var11.setUniform("BlurParams", renderSupport31.v1(renderSupport47.v1(this.v48)));
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
      int var12,
      float var13,
      float var14
   ) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, 0.0F, false);
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
      int var12,
      float var13,
      float var14,
      float var15,
      boolean var16
   ) {
      var0.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
      var0.putFloat(var5).putFloat(var6).putFloat(var7).putFloat(hudSupport70.v3());
      var0.putFloat(var8).putFloat(var9).putFloat(var10).putFloat(var11);
      uiSupport155.v1(var0, var12);
      var0.putFloat(var13).putFloat(var14).putFloat(var15).putFloat(var16 ? 1.0F : 0.0F);
   }

   private void v1(
      class_310 var1,
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
      boolean var14
   ) {
      ByteBuffer var15 = renderSupport47.v1(this.v46);
      var15.clear();
      v1(var15, var2, var3, var4, var5, this.v251, this.v203, this.v332, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      var15.flip();
      CommandEncoder var16 = RenderSystem.getDevice().createCommandEncoder();
      var16.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v43)), var15);
      class_12137 var17 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      GpuTextureView var18 = this.v25();
      RenderPass var19 = var16.createRenderPass(
         () -> "syky:blur_composite", renderSupport30.v1(var1), OptionalInt.empty(), var1.method_1522().method_71640(), OptionalDouble.empty()
      );

      try {
         var19.setPipeline(v38);
         cloudSupport27.v1(var19);
         var19.setVertexBuffer(0, this.v47);
         var19.bindTexture("Sampler0", var18, var17);
         var19.setUniform("BlurData", renderSupport31.v1(renderSupport47.v1(this.v43)));
         var19.draw(0, 6);
      } catch (Throwable var23) {
         if (var19 != null) {
            try {
               var19.close();
            } catch (Throwable var22) {
               var23.addSuppressed(var22);
            }
         }

         throw var23;
      }

      if (var19 != null) {
         var19.close();
      }
   }

   private void v3(class_310 var1) {
      int var2 = this.v101;
      ByteBuffer var3 = renderSupport47.v1(this.v51);
      var3.clear();

      for (int var4 = 0; var4 < var2; var4++) {
         v1(
            var3,
            this.v63[var4],
            this.v64[var4],
            this.v61[var4],
            this.v66[var4],
            this.v251,
            this.v203,
            this.v332,
            this.v68[var4],
            this.v52[var4],
            this.v75[var4],
            this.v73[var4],
            this.v74[var4],
            this.v72[var4],
            this.v80[var4],
            this.v84[var4],
            this.v94[var4]
         );
      }

      var3.flip();
      CommandEncoder var12 = RenderSystem.getDevice().createCommandEncoder();
      var12.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v37)), var3);
      class_12137 var5 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      GpuTextureView var6 = this.v25();
      RenderPass var7 = var12.createRenderPass(
         () -> "syky:blur_composite_batched", renderSupport30.v1(var1), OptionalInt.empty(), var1.method_1522().method_71640(), OptionalDouble.empty()
      );

      try {
         var7.setPipeline(v42);
         cloudSupport27.v1(var7);
         var7.setVertexBuffer(0, this.v47);
         var7.setIndexBuffer(this.v49, class_5595.field_27372);
         var7.bindTexture("Sampler0", var6, var5);
         var7.setUniform("BlurBatchData", renderSupport31.v1(renderSupport47.v1(this.v37)));
         var7.drawIndexed(0, 0, 6, var2);
      } catch (Throwable var11) {
         if (var7 != null) {
            try {
               var7.close();
            } catch (Throwable var10) {
               var11.addSuppressed(var10);
            }
         }

         throw var11;
      }

      if (var7 != null) {
         var7.close();
      }
   }

   @Override
   public void close() {
      this.v101 = 0;
      this.v191.close();
      this.v112.close();
      this.v27();
      if (this.v43 != null) {
         this.v43.close();
         this.v43 = null;
      }

      if (this.v37 != null) {
         this.v37.close();
         this.v37 = null;
      }

      if (this.v48 != null) {
         this.v48.close();
         this.v48 = null;
      }

      if (this.v40 != null) {
         this.v40.close();
         this.v40 = null;
      }

      if (this.v44 != null) {
         this.v44.close();
         this.v44 = null;
      }

      if (this.v47 != null) {
         this.v47.close();
         this.v47 = null;
      }

      if (this.v49 != null) {
         this.v49.close();
         this.v49 = null;
      }

      if (this.v46 != null) {
         MemoryUtil.memFree(this.v46);
         this.v46 = null;
      }

      if (this.v51 != null) {
         MemoryUtil.memFree(this.v51);
         this.v51 = null;
      }

      if (this.v50 != null) {
         MemoryUtil.memFree(this.v50);
         this.v50 = null;
      }

      if (this.v60 != null) {
         MemoryUtil.memFree(this.v60);
         this.v60 = null;
      }

      this.v252 = false;
   }

   private void v27() {
      if (this.v105 != null) {
         this.v105.close();
         this.v105 = null;
      }

      if (this.v96 != null) {
         this.v96.close();
         this.v96 = null;
      }

      if (this.v125 != null) {
         this.v125.close();
         this.v125 = null;
      }

      if (this.v104 != null) {
         this.v104.close();
         this.v104 = null;
      }

      if (this.v138 != null) {
         this.v138.close();
         this.v138 = null;
      }

      if (this.v187 != null) {
         this.v187.close();
         this.v187 = null;
      }

      if (this.v147 != null) {
         this.v147.close();
         this.v147 = null;
      }

      if (this.v116 != null) {
         this.v116.close();
         this.v116 = null;
      }

      if (this.v107 != null) {
         this.v107.close();
         this.v107 = null;
      }

      if (this.v162 != null) {
         this.v162.close();
         this.v162 = null;
      }

      if (this.v85 != null) {
         this.v85.close();
         this.v85 = null;
      }

      if (this.v87 != null) {
         this.v87.close();
         this.v87 = null;
      }

      this.v188 = 0;
      this.v228 = 0;
      this.v141.v1();
      this.v217 = -1L;
      this.v254 = -1L;
      if (this.v98 != null) {
         this.v98.close();
         this.v98 = null;
      }

      if (this.v119 != null) {
         this.v119.close();
         this.v119 = null;
      }

      if (this.v45 != null) {
         this.v45.close();
         this.v45 = null;
      }

      if (this.v117 != null) {
         this.v117.close();
         this.v117 = null;
      }

      this.v124 = null;
      this.v185 = 0.0F;
      this.v220 = 0.0F;
      this.v223 = false;
   }
}
