package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.IIISupport;
import cc.syky.ui.uiRecord14;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import net.minecraft.class_634;
import net.minecraft.class_640;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "capsfix",
   displayName = "Caps Fix",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.capsfix.description"
)
public final class CapsFix extends Module {
   @Nullable
   private static CapsFix v2;
   private final uiRecord14 name;

   public CapsFix(uiRecord14 var1) {
      this.name = var1;
      v2 = this;
   }

   public static String v1(String var0) {
      CapsFix var1 = v2;
      if (var1 != null && var1.isEnabled()) {
         String var2 = IIISupport.v1(var0, ".syky", var1.v17()::contains);
         return var2 == null ? var0 : var2;
      } else {
         return var0;
      }
   }

   private Set<String> v17() {
      class_634 var1 = this.name.v2().v4();
      if (var1 == null) {
         return Set.of();
      } else {
         HashSet var2 = new HashSet();

         for (class_640 var4 : var1.method_2880()) {
            String var5 = var4.method_2966().name();
            if (var5 != null && !var5.isEmpty()) {
               var2.add(var5.toLowerCase(Locale.ROOT));
            }
         }

         return var2;
      }
   }
}
