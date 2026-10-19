package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "fogblur",
   displayName = "Fog Blur",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.fogblur.description"
)
public final class FogBlur extends Module {
   private static final float v2 = 5.0F;
   private final FloatSetting strength = this.settings.add(new FloatSetting("strength", 25.0F, 0.0F, 100.0F));
   private final FloatSetting start = this.settings.add(new FloatSetting("start", 28.0F, 0.0F, 256.0F));
   private final FloatSetting end = this.settings.add(new FloatSetting("end", 104.0F, 1.0F, 512.0F));
   private final FloatSetting opacity = this.settings.add(new FloatSetting("opacity", 100.0F, 0.0F, 100.0F));

   public FogBlur() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport51.v46 = false;
   }

   private void onEnable() {
      visualSupport51.v46 = true;
      visualSupport51.v51 = 5.0F * (this.strength.getValue() / 100.0F);
      visualSupport51.v74 = this.opacity.getValue() / 100.0F;
      float var1 = this.start.getValue();
      visualSupport51.v50 = var1;
      visualSupport51.v60 = Math.max(this.end.getValue(), var1 + 1.0F);
   }
}
