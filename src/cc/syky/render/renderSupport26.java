package cc.syky.render;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import net.minecraft.class_10799;
import net.minecraft.class_11231;
import net.minecraft.class_11241;
import net.minecraft.class_12137;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import org.joml.Matrix3x2f;
import org.joml.Matrix4f;

public final class renderSupport26 {
   public static final class_2960 v1 = class_2960.method_60655("syky", "textures/badge/syky_msdf.png");
   public static final float v2 = 8.0F;
   private static final float v3 = 1.0F;
   private static final float v4 = -0.078107215F;
   private static final float v5 = -0.08203125F;
   private static final float v6 = 1.0781428F;
   private static final float v7 = 1.0820312F;
   private static final float v8 = 0.0032894737F;
   private static final float v9 = 0.0032894737F;
   private static final float v10 = 0.9769737F;
   private static final float v11 = 0.98355263F;
   private static final int v12 = 1024;
   private static final RenderPipeline v13 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56864})
         .withLocation(class_2960.method_60655("syky", "pipeline/badge_gui"))
         .withVertexShader(class_2960.method_60655("syky", "core/badge/badge_gui"))
         .withFragmentShader(class_2960.method_60655("syky", "core/badge/badge_gui"))
         .build()
   );
   private static final RenderPipeline v14 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56856, class_10799.field_56848})
         .withLocation(class_2960.method_60655("syky", "pipeline/badge_text"))
         .withVertexShader(class_2960.method_60655("syky", "core/badge/badge_text"))
         .withFragmentShader(class_2960.method_60655("syky", "core/badge/badge_text"))
         .withSampler("Sampler0")
         .withSampler("Sampler2")
         .build()
   );
   private static final RenderPipeline v15 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56856})
         .withLocation(class_2960.method_60655("syky", "pipeline/badge_text_see_through"))
         .withVertexShader(class_2960.method_60655("syky", "core/badge/badge_text_see_through"))
         .withFragmentShader(class_2960.method_60655("syky", "core/badge/badge_text_see_through"))
         .withSampler("Sampler0")
         .withDepthWrite(false)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .build()
   );
   private static final class_1921 v16 = class_1921.method_75940(
      "syky_badge", class_12247.method_75927(v14).method_76560("Sampler0", v1, renderSupport26::v1).method_75928().method_75938()
   );
   private static final class_1921 v18 = class_1921.method_75940(
      "syky_badge_see_through", class_12247.method_75927(v15).method_76560("Sampler0", v1, renderSupport26::v1).method_75928().method_75938()
   );

   private renderSupport26() {
   }

   private static class_12137 v1() {
      return RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
   }

   public static void v1(class_332 var0, int var1, int var2, int var3) {
      class_310 var4 = class_310.method_1551();
      if (var4 != null) {
         class_11231 var5 = class_11231.method_70900(var4.method_1531().method_4619(v1).method_71659(), v1());
         v1(var0, var5, var1 + 1.0F, var2 + 1.0F, v1(var3));
         v1(var0, var5, var1, var2, var3);
      }
   }

   private static void v1(class_332 var0, class_11231 var1, float var2, float var3, int var4) {
      float var5 = var2 + -0.6248577F;
      float var6 = var2 + 8.625142F;
      float var7 = var3 + -0.65625F;
      float var8 = var3 + 8.65625F;
      Matrix3x2f var9 = new Matrix3x2f(var0.method_51448()).translate(var5, var7).scale((var6 - var5) / 1024.0F, (var8 - var7) / 1024.0F);
      var0.field_59826.method_70919(new class_11241(v13, var1, var9, 0, 0, 1024, 1024, 0.0032894737F, 0.9769737F, 0.0032894737F, 0.98355263F, var4, null));
   }

   public static void v1(class_4597 var0, Matrix4f var1, float var2, float var3, int var4, int var5, boolean var6) {
      class_4588 var7 = var0.method_73477(var6 ? v18 : v16);
      float var8 = var2 + -0.6248577F;
      float var9 = var2 + 8.625142F;
      float var10 = var3 + -0.65625F;
      float var11 = var3 + 8.65625F;
      var7.method_22918(var1, var8, var10, 0.0F).method_39415(var4).method_22913(0.0032894737F, 0.0032894737F).method_60803(var5);
      var7.method_22918(var1, var8, var11, 0.0F).method_39415(var4).method_22913(0.0032894737F, 0.98355263F).method_60803(var5);
      var7.method_22918(var1, var9, var11, 0.0F).method_39415(var4).method_22913(0.9769737F, 0.98355263F).method_60803(var5);
      var7.method_22918(var1, var9, var10, 0.0F).method_39415(var4).method_22913(0.9769737F, 0.0032894737F).method_60803(var5);
   }

   private static int v1(int var0) {
      return var0 & 0xFF000000 | (var0 & 16579836) >> 2;
   }
}
