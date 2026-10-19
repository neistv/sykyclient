package cc.syky.module.visual;

import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class visualSupport20 {
   private visualSupport20() {
   }

   @Nullable
   public static class_1309 v1(class_310 var0) {
      if (var0 != null && var0.field_1724 != null && var0.field_1687 != null) {
         return var0.field_1692 instanceof class_1309 var1 && v1(var1, var0.field_1724) && !visualSupport44.v1(var1) ? var1 : null;
      } else {
         return null;
      }
   }

   public static boolean v1(class_1309 var0, class_1657 var1) {
      return var0 != var1 && var0.method_5805() && !var0.method_7325() && !var0.method_5756(var1);
   }
}
