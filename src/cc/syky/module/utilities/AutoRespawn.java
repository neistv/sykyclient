package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport218;
import net.minecraft.class_310;

@ModuleInfo(
   name = "autorespawn",
   displayName = "Auto Respawn",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.autorespawn.description"
)
public final class AutoRespawn extends Module {
   private final uiRecord14 v2;

   public AutoRespawn(uiRecord14 var1) {
      this.v2 = var1;
   }

   @Override
   public void onEnableHook() {
      uiSupport218.v1 = true;
   }

   @Override
   public void onResetHook() {
      class_310 var1 = this.v2.v2().v1();
      if (var1 != null) {
         uiSupport218.v1(var1);
      }
   }

   @Override
   public void onDisableHook() {
      uiSupport218.v2(this.v2.v2().v1());
   }
}
