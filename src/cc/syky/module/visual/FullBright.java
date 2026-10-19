package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "fullbright",
   displayName = "FullBright",
   category = ModuleCategory.VISUAL,
   group = "Light & Color",
   description = "module.fullbright.description"
)
public final class FullBright extends Module {
   private final EnumSetting<visualSupport30> v2 = this.settings.add(new EnumSetting<>("mode", visualSupport30.CLASSIC));
   private final FloatSetting brightness = this.settings
      .add(new FloatSetting("brightness", 100.0F, 0.0F, 100.0F), SettingCondition.v1(this.v2, visualSupport30.CLASSIC));

   public FullBright() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport29.v1();
   }

   @Override
   public void onTickHook() {
      visualSupport29.v2();
   }

   private void onEnable() {
      visualSupport30 var1 = this.v2.getValue();
      visualSupport29.v1(this.brightness.getValue() / 100.0F, var1 == visualSupport30.CLASSIC, var1 == visualSupport30.NIGHT_VISION);
   }
}
