package cc.syky.render;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
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

public final class renderSupport5 {
   private static final class_2960 v2 = class_2960.method_60655("syky", "pipeline/world_glow");
   private static final class_2960 v3 = class_2960.method_60655("syky", "core/world/world_glow");
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_60127})
         .withLocation(v2)
         .withVertexShader(v3)
         .withFragmentShader(v3)
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withVertexFormat(class_290.field_1580, class_5596.field_27382)
         .build()
   );
   @Nullable
   private static class_1921 v4;

   private renderSupport5() {
   }

   public static void v1() {
      Objects.requireNonNull(v1, "world_glow pipeline");
   }

   public static class_1921 v2() {
      if (v4 == null) {
         v4 = class_1921.method_75940(
            "syky_world_glow",
            class_12247.method_75927(v1).method_75934("CoverSampler", renderSupport10.v1).method_75934("CoverFrontSampler", renderSupport10.v2).method_75938()
         );
      }

      return v4;
   }
}
