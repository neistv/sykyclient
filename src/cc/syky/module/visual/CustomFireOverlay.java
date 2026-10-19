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
   name = "fireoverlay",
   displayName = "Custom Fire Overlay",
   category = ModuleCategory.VISUAL,
   group = "Environment Overlays",
   description = "module.fireoverlay.description"
)
public final class CustomFireOverlay extends Module implements cloudSupport100 {
   private final FloatSetting lower = this.settings.add(new FloatSetting("lower", 0.0F, 0.0F, 1.0F));
   private final BooleanSetting customColor = this.settings.add(new BooleanSetting("customColor", false));
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -419461117).setCondition(this.customColor));
   private final BooleanSetting everywhere = this.settings.add(new BooleanSetting("everywhere", false), SettingCondition.v1(this.customColor));
   private final BooleanSetting hideWithFireResistance = this.settings.add(new BooleanSetting("hideWithFireResistance", true));
   private final BooleanSetting hideEntityFire = this.settings.add(new BooleanSetting("hideEntityFire", false));

   @Override
   public void onEnableHook() {
      visualSupport47.v2();
      this.v21();
   }

   public CustomFireOverlay() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport47.v1 = false;
      visualSupport47.v9 = false;
      visualSupport47.v2();
      visualSupport48.v1(0);
      visualSupport48.v2();
   }

   private void onEnable() {
      this.v22();
      visualSupport47.v1 = true;
      visualSupport47.v9 = this.hideEntityFire.getValue();
      this.v21();
      if (!visualSupport47.v2) {
         visualSupport48.v2();
      }
   }

   private void v21() {
      visualSupport48.v1(this.customColor.getValue() && this.everywhere.getValue() ? this.color.getValue() | 0xFF000000 : 0);
   }

   private void v22() {
      visualSupport47.v3 = this.lower.getValue();
      visualSupport47.v5 = this.customColor.getValue();
      visualSupport47.v6 = this.everywhere.getValue();
      visualSupport47.v7 = this.color.getValue();
      visualSupport47.v8 = this.hideWithFireResistance.getValue();
   }

   @Override
   public void v1() {
      if (!this.isEnabled()) {
         this.v22();
      }

      visualSupport47.v2 = true;
   }

   @Override
   public void v2() {
      visualSupport47.v2 = false;
   }
}
