package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "selfnametag",
   displayName = "Self Nametag",
   category = ModuleCategory.VISUAL,
   group = "Entities & Items",
   description = "module.selfnametag.description"
)
public final class SelfNametag extends Module {
   public static boolean v2;

   public SelfNametag() {
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
