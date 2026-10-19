package cc.syky.render;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.Objects;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;

public final class SEALSupport2 {
   private static final class_2960 v6 = class_2960.method_60655("syky", "core/world/area_fill");
   private static final class_2960 v7 = class_2960.method_60655("syky", "core/world/area_line");
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/world/world_line");
   private static final class_2960 v9 = class_2960.method_60655("syky", "core/world/area_skirt");
   public static final RenderPipeline v1 = class_10799.method_67887(
      v1("area_fill").withVertexShader(v6).withFragmentShader(v6).withBlend(BlendFunction.TRANSLUCENT).withDepthWrite(false).build()
   );
   public static final RenderPipeline v2 = class_10799.method_67887(
      v1("area_skirt").withVertexShader(v9).withFragmentShader(v9).withBlend(BlendFunction.TRANSLUCENT).withDepthWrite(false).build()
   );
   public static final RenderPipeline v3 = class_10799.method_67887(
      v1("area_line").withVertexShader(v7).withFragmentShader(v8).withBlend(BlendFunction.TRANSLUCENT).withDepthWrite(false).build()
   );
   public static final RenderPipeline v4 = class_10799.method_67887(
      v1("area_line_group")
         .withVertexShader(v7)
         .withFragmentShader(v8)
         .withShaderDefine("GROUPED")
         .withShaderDefine("OCCLUDED")
         .withSampler("Sampler0")
         .withoutBlend()
         .withDepthWrite(true)
         .build()
   );
   public static final RenderPipeline v5 = class_10799.method_67887(
      v1("area_line_seal")
         .withVertexShader(v7)
         .withFragmentShader(v8)
         .withShaderDefine("SEAL")
         .withoutBlend()
         .withColorWrite(false)
         .withDepthWrite(true)
         .build()
   );

   private SEALSupport2() {
   }

   private static Builder v1(String var0) {
      return RenderPipeline.builder(new Snippet[0])
         .withLocation(class_2960.method_60655("syky", "pipeline/" + var0))
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("DynamicTransforms", class_10789.field_60031)
         .withUniform("Projection", class_10789.field_60031)
         .withUniform("AreaItems", class_10789.field_60031)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withCull(false);
   }

   public static void v1() {
      Objects.requireNonNull(v1, "area fill pipeline");
      Objects.requireNonNull(v2, "area skirt pipeline");
      Objects.requireNonNull(v3, "area line pipeline");
      Objects.requireNonNull(v4, "area line group pipeline");
      Objects.requireNonNull(v5, "area seal pipeline");
   }
}
