package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.IntSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiSupport184;

@ModuleInfo(
   name = "fov",
   displayName = "FOV",
   category = ModuleCategory.UTILITIES,
   group = "Camera Tools",
   description = "module.fov.description"
)
public final class FOV extends Module implements cloudSupport100 {
   private final IntSetting fov = this.settings.add(new IntSetting("fov", 90, 30, 142));

   public FOV() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      uiSupport184.v3 = this.fov.getValue();
      uiSupport184.v1 = true;
   }

   private void onDisable() {
      uiSupport184.v1 = false;
   }

   @Override
   public void v1() {
      if (!this.isEnabled()) {
         uiSupport184.v3 = this.fov.getValue();
      }

      uiSupport184.v2 = true;
   }

   @Override
   public void v2() {
      uiSupport184.v2 = false;
   }
}
