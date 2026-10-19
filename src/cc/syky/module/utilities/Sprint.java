package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiSupport216;

@ModuleInfo(
   name = "autosprint",
   displayName = "Sprint",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.autosprint.description"
)
public final class Sprint extends Module {
   public Sprint() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      uiSupport216.v1 = true;
   }

   private void onDisable() {
      uiSupport216.v1 = false;
   }
}
