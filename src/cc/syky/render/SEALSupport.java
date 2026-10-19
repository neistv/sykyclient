package cc.syky.render;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.Objects;
import net.minecraft.class_10799;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class SEALSupport {
   private static final class_2960 v6 = class_2960.method_60655("syky", "pipeline/world_line");
   private static final class_2960 v7 = class_2960.method_60655("syky", "pipeline/world_line_through");
   private static final class_2960 v8 = class_2960.method_60655("syky", "core/world/world_line");
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860})
         .withLocation(v6)
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(class_290.field_1580, class_5596.field_27382)
         .build()
   );
   public static final RenderPipeline v2 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860})
         .withLocation(v7)
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withVertexFormat(class_290.field_1580, class_5596.field_27382)
         .build()
   );
   public static final RenderPipeline v3 = v1("world_line_group", true);
   public static final RenderPipeline v4 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("syky", "pipeline/world_line_seal"))
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withShaderDefine("SEAL")
         .withoutBlend()
         .withColorWrite(false)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .withVertexFormat(class_290.field_1580, class_5596.field_27382)
         .build()
   );
   public static final RenderPipeline v5 = v1("world_line_group_through", false);
   @Nullable
   private static class_1921 v9;
   @Nullable
   private static class_1921 v10;
   @Nullable
   private static class_1921 v11;

   private SEALSupport() {
   }

   private static RenderPipeline v1(String var0, boolean var1) {
      Builder var2 = RenderPipeline.builder(new Snippet[]{class_10799.field_56860})
         .withLocation(class_2960.method_60655("syky", "pipeline/" + var0))
         .withVertexShader(v8)
         .withFragmentShader(v8)
         .withShaderDefine("GROUPED")
         .withoutBlend()
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .withVertexFormat(class_290.field_1580, class_5596.field_27382);
      if (var1) {
         var2.withShaderDefine("OCCLUDED").withSampler("Sampler0");
      }

      return class_10799.method_67887(var2.build());
   }

   public static void v1() {
      Objects.requireNonNull(v1, "world_line pipeline");
      Objects.requireNonNull(v2, "world_line through pipeline");
      Objects.requireNonNull(v3, "world_line group pipeline");
      Objects.requireNonNull(v5, "world_line group through pipeline");
      Objects.requireNonNull(v4, "world_line seal pipeline");
   }

   public static class_1921 v2() {
      if (v11 == null) {
         v11 = class_1921.method_75940("syky_world_line_seal", class_12247.method_75927(v4).method_75938());
      }

      return v11;
   }

   public static class_1921 v3() {
      if (v9 == null) {
         v9 = class_1921.method_75940("syky_world_line", class_12247.method_75927(v1).method_75938());
      }

      return v9;
   }

   public static class_1921 v4() {
      if (v10 == null) {
         v10 = class_1921.method_75940("syky_world_line_through", class_12247.method_75927(v2).method_75938());
      }

      return v10;
   }
}
