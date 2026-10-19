package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.mixin.accessor.WindowInvoker;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport215;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "borderless",
   displayName = "Borderless Fullscreen",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.borderless.description"
)
public final class BorderlessFullscreen extends Module {
   private final uiRecord14 v2;
   @Nullable
   private Boolean name;

   public BorderlessFullscreen(uiRecord14 var1) {
      this.v2 = var1;
      this.setToggleActions(() -> this.v1(true), () -> this.v1(false));
   }

   private void v1(boolean var1) {
      uiSupport215.v1 = var1;
      if (this.name == null || this.name != var1) {
         class_310 var2 = this.v2.v2().v1();
         class_1041 var3 = var2 == null ? null : var2.method_22683();
         if (var2 != null && var3 != null) {
            this.name = var1;
            if (var3.method_4498()) {
               ((WindowInvoker)var3).syky$updateWindowRegion();
               var2.method_15993();
            }
         }
      }
   }
}
