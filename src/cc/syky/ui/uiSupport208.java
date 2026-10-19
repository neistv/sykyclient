package cc.syky.ui;

import java.util.UUID;
import net.minecraft.class_1299;
import net.minecraft.class_2558;
import net.minecraft.class_2583;
import net.minecraft.class_2558.class_10609;
import net.minecraft.class_2558.class_10610;
import net.minecraft.class_2568.class_10611;
import org.jetbrains.annotations.Nullable;

public final class uiSupport208 {
   private uiSupport208() {
   }

   @Nullable
   public static UUID v1(class_2583 var0) {
      return var0.method_10969() instanceof class_10611 var1 && var1.comp_3508().field_24351 == class_1299.field_6097 ? var1.comp_3508().field_24352 : null;
   }

   @Nullable
   public static String v2(class_2583 var0) {
      String var1 = null;
      class_2558 var2 = var0.method_10970();
      if (var2 instanceof class_10610 var3) {
         var1 = uiSupport193.v2(var3.comp_3507());
      } else if (var2 instanceof class_10609 var4) {
         var1 = uiSupport193.v2(var4.comp_3506());
      }

      String var5 = var0.method_10955();
      return var1 == null && var5 != null && uiSupport193.v3(var5) ? var5 : var1;
   }
}
