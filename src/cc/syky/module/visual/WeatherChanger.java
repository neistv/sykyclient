package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.EnumSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "weather",
   displayName = "Weather Changer",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.weather.description"
)
public final class WeatherChanger extends Module {
   private final EnumSetting<visualSupport14> v2 = this.settings.add(new EnumSetting<>("mode", visualSupport14.RAIN));

   public WeatherChanger() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport51.v72 = false;
   }

   private void onEnable() {
      visualSupport14 var1 = this.v2.getValue();
      visualSupport51.v72 = true;
      visualSupport51.v80 = var1.v1();
      visualSupport51.v84 = var1.v2();
   }
}
