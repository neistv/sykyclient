package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.cloud.cloudSupport29;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "wetsurfaces",
   displayName = "Wet Surfaces",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.wetsurfaces.description"
)
public final class WetSurfaces extends Module implements cloudSupport100 {
   private final FloatSetting reflection = this.settings.add(new FloatSetting("reflection", 70.0F, 0.0F, 100.0F));
   private final FloatSetting wetness = this.settings.add(new FloatSetting("wetness", 60.0F, 0.0F, 100.0F));
   private final FloatSetting puddles = this.settings.add(new FloatSetting("puddles", 35.0F, 0.0F, 100.0F));
   private final FloatSetting ripples = this.settings.add(new FloatSetting("ripples", 50.0F, 0.0F, 100.0F));
   private final FloatSetting drops = this.settings.add(new FloatSetting("drops", 35.0F, 0.0F, 100.0F));
   private final BooleanSetting dryUnderRoofs = this.settings.add(new BooleanSetting("dryUnderRoofs", false));
   private final EnumSetting<visualSupport13> defaultEnabled = this.settings.add(new EnumSetting<>("quality", visualSupport13.BALANCED));

   public WetSurfaces() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport51.v59 = false;
      cloudSupport29.v1();
   }

   private void onEnable() {
      visualSupport51.v59 = true;
      this.v21();
   }

   private void v21() {
      visualSupport51.v63 = this.reflection.getValue() / 100.0F;
      visualSupport51.v64 = this.wetness.getValue() / 100.0F;
      visualSupport51.v61 = this.puddles.getValue() / 100.0F;
      visualSupport51.v66 = this.ripples.getValue() / 100.0F;
      visualSupport51.v68 = this.drops.getValue() / 100.0F;
      visualSupport51.v52 = this.dryUnderRoofs.getValue();
      visualSupport51.v75 = this.defaultEnabled.getValue();
   }

   @Override
   public void v1() {
      this.v21();
      visualSupport51.v53 = true;
   }

   @Override
   public void v2() {
      visualSupport51.v53 = false;
   }

   @Override
   public void onTickHook() {
      cloudSupport29.v1();
   }

   @Override
   public void onRenderHook() {
      cloudSupport29.v1();
   }
}
