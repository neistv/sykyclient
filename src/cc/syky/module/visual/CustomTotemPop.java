package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "totem",
   displayName = "Custom Totem Pop",
   category = ModuleCategory.VISUAL,
   group = "Combat Items",
   description = "module.totem.description"
)
public final class CustomTotemPop extends Module implements cloudSupport100 {
   private final FloatSetting scale = this.settings.add(new FloatSetting("scale", 1.0F, 0.0F, 3.0F));
   private final FloatSetting offsetY = this.settings.add(new FloatSetting("offsetY", 0.0F, -1.0F, 1.0F));
   private final BooleanSetting flash = this.settings.add(new BooleanSetting("flash", true));
   private final ColorSetting flashColor = this.settings.add(new ColorSetting("flashColor", 1056964607).setCondition(this.flash));
   private final FloatSetting flashRadius = this.settings.add(new FloatSetting("flashRadius", 0.12F, 0.0F, 0.95F), SettingCondition.v1(this.flash));

   public CustomTotemPop() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport36.v4 = false;
      visualSupport36.v2();
   }

   private void onEnable() {
      this.v21();
      visualSupport36.v4 = true;
   }

   private void v21() {
      visualSupport36.v6 = this.scale.getValue();
      visualSupport36.v7 = this.offsetY.getValue();
      visualSupport36.v8 = this.flash.getValue();
      visualSupport36.v9 = this.flashColor.getValue();
      visualSupport36.v10 = this.flashRadius.getValue();
   }

   @Override
   public void v1() {
      if (!this.isEnabled()) {
         this.v21();
      }

      visualSupport36.v5 = true;
   }

   @Override
   public void v2() {
      visualSupport36.v5 = false;
   }
}
