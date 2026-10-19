package cc.syky.render;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12245;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_2960;

public final class GlobalsSupport {
   private static final class_2960 v2 = class_2960.method_60655("syky", "core/world/target_scan");
   public static final RenderPipeline v1 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[]{class_10799.field_60127})
         .withLocation(class_2960.method_60655("syky", "pipeline/target_scan"))
         .withVertexShader(v2)
         .withFragmentShader(v2)
         .withUniform("Globals", class_10789.field_60031)
         .withSampler("Sampler0")
         .withSampler("CoverSampler")
         .withSampler("CoverFrontSampler")
         .withVertexFormat(class_290.field_1580, class_5596.field_27382)
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );
   private static final int v3 = 48;
   private static final Map<GlobalsSupport.Part1, class_1921> v4 = new HashMap<>();

   private GlobalsSupport() {
   }

   public static void v1() {
      Objects.requireNonNull(v1, "target_scan pipeline");
   }

   public static class_1921 v1(class_2960 var0, class_12245 var1) {
      GlobalsSupport.Part1 var2 = new GlobalsSupport.Part1(var0, var1);
      class_1921 var3 = v4.get(var2);
      if (var3 != null) {
         return var3;
      } else {
         class_1921 var4 = class_1921.method_75940(
            "syky_target_scan",
            class_12247.method_75927(v1)
               .method_75934("Sampler0", var0)
               .method_75934("CoverSampler", renderSupport10.v1)
               .method_75934("CoverFrontSampler", renderSupport10.v2)
               .method_75930(var1)
               .method_75938()
         );
         v4.put(var2, var4);
         return var4;
      }
   }

   public static boolean v2() {
      return v4.size() > 48;
   }

   public static void v1(Consumer<class_1921> var0) {
      v4.values().forEach(var0);
      v4.clear();
   }

   public record Part1(class_2960 texture, class_12245 layering) {
      public class_2960 v1() {
         return this.texture;
      }

      public class_12245 v2() {
         return this.layering;
      }
   }
}
