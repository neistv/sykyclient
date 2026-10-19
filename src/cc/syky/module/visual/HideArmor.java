package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "hidearmor",
   displayName = "Hide Armor",
   category = ModuleCategory.VISUAL,
   group = "Entities & Items",
   description = "module.hidearmor.description"
)
public final class HideArmor extends Module {
   public static boolean v2;

   public HideArmor() {
   }

   @Override
   public void onEnableHook() {
      v2 = true;
   }

   @Override
   public void onDisableHook() {
      v2 = false;
   }
}
