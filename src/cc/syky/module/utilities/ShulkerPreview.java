package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "shulkerpreview",
   displayName = "Shulker Preview",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.shulkerpreview.description"
)
public final class ShulkerPreview extends Module {
   public ShulkerPreview() {
   }

   @Override
   public void onEnableHook() {
      utilitiesSupport7.v1 = true;
   }

   @Override
   public void onDisableHook() {
      utilitiesSupport7.v1 = false;
   }
}
