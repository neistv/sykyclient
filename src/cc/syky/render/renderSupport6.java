package cc.syky.render;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.class_10799;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_2960;

public final class renderSupport6 {
   private static final class_2960 v2 = class_2960.method_60655("syky", "pipeline/fire_screen_effect");
   private static final class_2960 v3 = class_2960.method_60655("syky", "core/world/fire_screen_effect");
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_56864})
         .withLocation(v2)
         .withFragmentShader(v3)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .build()
   );
   private static final Map<class_2960, class_1921> v4 = new HashMap<>();

   private renderSupport6() {
   }

   public static void v1() {
      Objects.requireNonNull(v1, "fire_screen_effect pipeline");
   }

   public static class_1921 v1(class_2960 var0) {
      return v4.computeIfAbsent(
         var0,
         var0x -> class_1921.method_75940("syky_fire_screen_effect_" + var0x, class_12247.method_75927(v1).method_75934("Sampler0", var0x).method_75938())
      );
   }
}
