package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "fog",
   displayName = "Custom Fog",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.fog.description"
)
public final class CustomFog extends Module {
   private final EnumSetting<visualSupport46> v2 = this.settings.add(new EnumSetting<>("mode", visualSupport46.TERRAIN));
   private final BooleanSetting customColor = this.settings.add(new BooleanSetting("customColor", false), SettingCondition.v2(this.v2, visualSupport46.OFF));
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -4138753).setCondition(this.customColor));
   private final FloatSetting start = this.settings.add(new FloatSetting("start", 0.0F, 0.0F, 256.0F), SettingCondition.v2(this.v2, visualSupport46.OFF));
   private final FloatSetting end = this.settings.add(new FloatSetting("end", 128.0F, 1.0F, 512.0F), SettingCondition.v2(this.v2, visualSupport46.OFF));

   public CustomFog() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport51.v4 = false;
   }

   private void onEnable() {
      visualSupport51.v4 = true;
      visualSupport51.v5 = this.v2.getValue();
      visualSupport51.v6 = this.customColor.getValue();
      visualSupport51.v7 = this.color.getValue();
      float var1 = this.start.getValue();
      float var2 = this.end.getValue();
      visualSupport51.v8 = var1;
      visualSupport51.v9 = Math.max(var2, var1 + 1.0F);
   }
}
