package cc.syky.ui;

import cc.syky.internal.InternalSupport38;
import net.minecraft.class_10055;
import net.minecraft.class_11890;
import net.minecraft.class_310;

public final class uiSupport231 {
   private static final uiSupport260 v1 = new uiSupport260("cosmetics.extract");

   private uiSupport231() {
   }

   public static void v1(class_11890 var0, class_10055 var1) {
      if (uiSupport223.v2) {
         class_310 var2 = class_310.method_1551();
         if (var2 != null && var0 == var2.field_1724) {
            uiSupport259.v1("entity.streamer-name", () -> {
               var1.field_53337 = uiSupport223.v1();
               if (var1.field_53525 != null) {
                  var1.field_53525 = uiSupport221.v1(var1.field_53525, uiSupport223.v2());
               }
            });
         }
      }

      try {
         InternalSupport38.v1(var0, var1);
         v1.v1();
      } catch (Throwable var3) {
         v1.v1(var3);
      }
   }
}
