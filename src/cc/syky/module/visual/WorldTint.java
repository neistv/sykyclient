package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "worldtint",
   displayName = "World Tint",
   category = ModuleCategory.VISUAL,
   group = "Light & Color",
   description = "module.worldtint.description"
)
public final class WorldTint extends Module {
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -6644993));
   private final FloatSetting strength = this.settings.add(new FloatSetting("strength", 100.0F, 0.0F, 100.0F));
   private final FloatSetting skyLight = this.settings.add(new FloatSetting("skyLight", 100.0F, 0.0F, 200.0F));

   public WorldTint() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport12.v1 = false;
   }

   private void onEnable() {
      visualSupport12.v1 = true;
      visualSupport12.v2 = this.color.getRgb();
      visualSupport12.v3 = this.strength.getValue() / 100.0F;
      visualSupport12.v4 = this.skyLight.getValue() / 100.0F;
   }
}
