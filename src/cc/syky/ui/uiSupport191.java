package cc.syky.ui;

import net.minecraft.class_310;
import net.minecraft.class_5498;

public final class uiSupport191 {
   private uiSupport191() {
   }

   public static void v1(class_310 var0, class_5498 var1) {
      class_5498 var2 = var0.field_1690.method_31044();
      if (var2 != var1) {
         var0.field_1690.method_31043(var1);
         if (var2.method_31034() != var1.method_31034()) {
            var0.field_1773.method_3167(var1.method_31034() ? var0.method_1560() : null);
         }

         var0.field_1769.method_3292();
      }
   }
}
