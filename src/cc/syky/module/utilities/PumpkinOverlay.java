package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "pumpkinoverlay",
   displayName = "Pumpkin Overlay",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.pumpkinoverlay.description"
)
public final class PumpkinOverlay extends Module implements cloudSupport100 {
   private final FloatSetting opacity = this.settings.add(new FloatSetting("opacity", 0.3F, 0.0F, 1.0F));

   public PumpkinOverlay() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      utilitiesSupport9.v1 = false;
   }

   private void onEnable() {
      utilitiesSupport9.v3 = this.opacity.getValue();
      utilitiesSupport9.v1 = true;
   }

   @Override
   public void v1() {
      if (!this.isEnabled()) {
         utilitiesSupport9.v3 = this.opacity.getValue();
      }

      utilitiesSupport9.v2 = true;
   }

   @Override
   public void v2() {
      utilitiesSupport9.v2 = false;
   }
}
