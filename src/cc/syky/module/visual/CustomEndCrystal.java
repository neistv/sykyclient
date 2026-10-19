package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "crystal",
   displayName = "Custom End Crystal",
   category = ModuleCategory.VISUAL,
   group = "Combat Items",
   description = "module.crystal.description"
)
public final class CustomEndCrystal extends Module {
   private final FloatSetting opacity = this.settings.add(new FloatSetting("opacity", 0.5F, 0.1F, 1.0F));
   private final BooleanSetting noBob = this.settings.add(new BooleanSetting("noBob", true));
   private final BooleanSetting noSpin = this.settings.add(new BooleanSetting("noSpin", true));

   public CustomEndCrystal() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport49.v2 = false;
   }

   private void onEnable() {
      visualSupport49.v3 = this.opacity.getValue();
      visualSupport49.v4 = this.noBob.getValue();
      visualSupport49.v5 = this.noSpin.getValue();
      visualSupport49.v2 = true;
   }
}
