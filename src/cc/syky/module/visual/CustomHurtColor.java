package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "hurtcolor",
   displayName = "Custom Hurt Color",
   category = ModuleCategory.VISUAL,
   group = "Hit Feedback",
   description = "module.hurtcolor.description"
)
public final class CustomHurtColor extends Module {
   private final ColorSetting color = this.settings.add(new ColorSetting("color", 1308557312));
   private final BooleanSetting colorArmor = this.settings.add(new BooleanSetting("colorArmor", true));
   private final BooleanSetting smooth = this.settings.add(new BooleanSetting("smooth", false));

   public CustomHurtColor() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport42.v3 = false;
      visualSupport42.v1();
   }

   private void onEnable() {
      visualSupport42.v3 = true;
      visualSupport42.v4 = this.color.getValue();
      visualSupport42.v5 = this.smooth.getValue();
      visualSupport42.v6 = this.colorArmor.getValue();
      visualSupport42.v1();
   }
}
