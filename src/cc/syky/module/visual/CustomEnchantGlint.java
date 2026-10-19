package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "glint",
   displayName = "Custom Enchant Glint",
   category = ModuleCategory.VISUAL,
   group = "Entities & Items",
   description = "module.glint.description"
)
public final class CustomEnchantGlint extends Module {
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -6468865));
   private final FloatSetting strength = this.settings.add(new FloatSetting("strength", 1.0F, 0.0F, 3.0F));
   private final FloatSetting size = this.settings.add(new FloatSetting("size", 1.0F, 0.1F, 5.0F));
   private final FloatSetting speed = this.settings.add(new FloatSetting("speed", 1.0F, 0.0F, 5.0F));
   private final FloatSetting angle = this.settings.add(new FloatSetting("angle", 10.0F, 0.0F, 360.0F));

   public CustomEnchantGlint() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport50.v3 = false;
   }

   private void onEnable() {
      visualSupport50.v4 = this.color.getValue();
      visualSupport50.v5 = this.strength.getValue();
      visualSupport50.v6 = this.size.getValue();
      visualSupport50.v7 = this.speed.getValue();
      visualSupport50.v8 = (float)Math.toRadians(this.angle.getValue().floatValue());
      visualSupport50.v3 = true;
   }
}
