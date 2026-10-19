package cc.syky.render;

import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class renderSupport14 {
   private renderSupport14() {
   }

   @Nullable
   public static GpuTextureView v1() {
      GpuTextureView var0 = renderSupport38.v1();
      return var0 != null ? var0 : v3().method_71639();
   }

   @Nullable
   public static GpuTextureView v2() {
      GpuTextureView var0 = renderSupport38.v2();
      if (var0 != null) {
         return var0;
      } else {
         class_276 var1 = v3();
         return var1.field_1478 ? var1.method_71640() : null;
      }
   }

   private static class_276 v3() {
      return class_310.method_1551().method_1522();
   }
}
