package cc.syky.util;

import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClipboardUtil {
   private static final Logger v1 = LoggerFactory.getLogger("syky.hud");

   private ClipboardUtil() {
   }

   public static boolean v1(@Nullable String var0) {
      if (var0 != null && !var0.isEmpty()) {
         class_310 var1 = class_310.method_1551();
         if (var1 != null && var1.field_1774 != null) {
            try {
               var1.field_1774.method_1455(var0);
               return true;
            } catch (Throwable var3) {
               v1.debug("clipboard write failed", var3);
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
