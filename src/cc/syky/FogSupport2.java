package cc.syky;

import cc.syky.internal.InternalSupport40;
import cc.syky.render.renderSupport10;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_2960;

public final class FogSupport2 {
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/cosmetic_fx"))
         .withVertexShader(class_2960.method_60655("syky", "core/world/cosmetic_fx"))
         .withFragmentShader(class_2960.method_60655("syky", "core/world/cosmetic_fx"))
         .withUniform("DynamicTransforms", class_10789.field_60031)
         .withUniform("Projection", class_10789.field_60031)
         .withUniform("Fog", class_10789.field_60031)
         .withUniform("Globals", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("Sampler1")
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withVertexFormat(class_290.field_1580, class_5596.field_27382)
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final Map<class_2960, class_1921> v2 = new HashMap<>();

   private FogSupport2() {
   }

   public static void v1() {
      Objects.requireNonNull(v1, "cosmetic_fx pipeline");
   }

   public static class_1921 v1(class_2960 var0) {
      return v2.computeIfAbsent(
         var0,
         var0x -> class_1921.method_75940(
            "syky_cosmetic_fx",
            class_12247.method_75927(v1)
               .method_75934("Sampler0", var0x)
               .method_75934("Sampler1", InternalSupport40.v1)
               .method_75934("CoverSampler", renderSupport10.v1)
               .method_75934("CoverFrontSampler", renderSupport10.v2)
               .method_75938()
         )
      );
   }

   public static void v2(class_2960 var0) {
      v2.remove(var0);
   }
}
