package cc.syky.render;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import java.util.Objects;
import net.minecraft.class_10799;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class renderSupport4 {
   private static final class_2960 v6 = class_2960.method_60655("syky", "pipeline/shape_fill_through");
   private static final class_2960 v7 = class_2960.method_60655("syky", "pipeline/shape_fill_seal");
   private static final class_2960 v8 = class_2960.method_60655("syky", "pipeline/shape_fill_additive");
   private static final class_2960 v9 = class_2960.method_60655("syky", "pipeline/shape_fill_exposure");
   private static final class_2960 v10 = class_2960.method_60655("syky", "core/world/shape_exposure");
   private static final class_2960 v11 = class_2960.method_60655("syky", "pipeline/shape_fill_surface");
   private static final class_2960 v12 = class_2960.method_60655("syky", "core/world/shape_surface");
   private static final class_2960 v13 = class_2960.method_60656("core/position_color");
   private static final class_2960 v14 = class_2960.method_60655("syky", "core/world/shape_additive");
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860})
         .withLocation(v6)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withCull(false)
         .build()
   );
   public static final RenderPipeline v2 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860})
         .withLocation(v8)
         .withVertexShader(v14)
         .withFragmentShader(v14)
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   public static final RenderPipeline v3 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860})
         .withLocation(v9)
         .withVertexShader(v12)
         .withFragmentShader(v10)
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withBlend(new BlendFunction(SourceFactor.DST_COLOR, DestFactor.ONE, SourceFactor.ZERO, DestFactor.ONE))
         .withDepthTestFunction(DepthTestFunction.LESS_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .build()
   );
   public static final RenderPipeline v4 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860}).withLocation(v11).withVertexShader(v12).withFragmentShader(v13).withCull(false).build()
   );
   public static final RenderPipeline v5 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56860}).withLocation(v7).withColorWrite(false).withDepthWrite(true).withCull(false).build()
   );
   @Nullable
   private static class_1921 v15;
   @Nullable
   private static class_1921 v16;
   @Nullable
   private static class_1921 v18;
   @Nullable
   private static class_1921 v19;
   @Nullable
   private static class_1921 v17;

   private renderSupport4() {
   }

   public static void v1() {
      Objects.requireNonNull(v1, "shape_fill_through pipeline");
      Objects.requireNonNull(v5, "shape_fill_seal pipeline");
      Objects.requireNonNull(v2, "shape_fill_additive pipeline");
      Objects.requireNonNull(v3, "shape_fill_exposure pipeline");
      Objects.requireNonNull(v4, "shape_fill_surface pipeline");
   }

   public static class_1921 v2() {
      if (v15 == null) {
         v15 = class_1921.method_75940("syky_shape_fill_through", class_12247.method_75927(v1).method_75938());
      }

      return v15;
   }

   public static class_1921 v3() {
      if (v18 == null) {
         v18 = class_1921.method_75940(
            "syky_shape_fill_additive",
            class_12247.method_75927(v2).method_75934("CoverSampler", renderSupport10.v1).method_75934("CoverFrontSampler", renderSupport10.v2).method_75938()
         );
      }

      return v18;
   }

   public static class_1921 v4() {
      if (v19 == null) {
         v19 = class_1921.method_75940(
            "syky_shape_fill_exposure",
            class_12247.method_75927(v3).method_75934("CoverSampler", renderSupport10.v1).method_75934("CoverFrontSampler", renderSupport10.v2).method_75938()
         );
      }

      return v19;
   }

   public static class_1921 v5() {
      if (v17 == null) {
         v17 = class_1921.method_75940("syky_shape_fill_surface", class_12247.method_75927(v4).method_75938());
      }

      return v17;
   }

   public static class_1921 v6() {
      if (v16 == null) {
         v16 = class_1921.method_75940("syky_shape_fill_seal", class_12247.method_75927(v5).method_75938());
      }

      return v16;
   }
}
