package cc.syky.render;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.class_10799;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_2960;

public final class EMISSIVESupport {
   private static final class_2960 v2 = class_2960.method_60655("syky", "pipeline/world_sprite");
   private static final class_2960 v3 = class_2960.method_60655("minecraft", "core/entity");
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_60127})
         .withLocation(v2)
         .withVertexShader(v3)
         .withFragmentShader(v3)
         .withShaderDefine("EMISSIVE")
         .withShaderDefine("NO_OVERLAY")
         .withShaderDefine("NO_CARDINAL_LIGHTING")
         .withShaderDefine("ALPHA_CUTOUT", 0.1F)
         .withSampler("Sampler0")
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .withVertexFormat(class_290.field_1580, class_5596.field_27382)
         .build()
   );
   private static final Map<class_2960, class_1921> v4 = new HashMap<>();

   private EMISSIVESupport() {
   }

   public static void v1() {
      Objects.requireNonNull(v1, "world_sprite pipeline");
   }

   public static class_1921 v1(class_2960 var0) {
      return v4.computeIfAbsent(
         var0,
         var0x -> class_1921.method_75940(
            "syky_world_sprite_" + var0x, class_12247.method_75927(v1).method_75934("Sampler0", var0x).method_75928().method_75935().method_75938()
         )
      );
   }
}
