package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiSupport186;
import cc.syky.ui.uiSupport187;

@ModuleInfo(
   name = "saturation",
   displayName = "Food Saturation",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.saturation.description"
)
public final class FoodSaturation extends Module {
   private final EnumSetting<uiSupport187> v2 = this.settings.add(new EnumSetting<>("mode", uiSupport187.OUTLINE));
   private final ColorSetting outlineColor = this.settings.add(new ColorSetting("outlineColor", -19351), SettingCondition.v1(this.v2, uiSupport187.OUTLINE));

   public FoodSaturation() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      uiSupport186.v1 = false;
   }

   private void onEnable() {
      uiSupport186.v1 = true;
      uiSupport186.v2 = this.v2.getValue();
      uiSupport186.v3 = this.outlineColor.getValue();
   }
}
