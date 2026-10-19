package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "customhearts",
   displayName = "Custom Hearts",
   category = ModuleCategory.VISUAL,
   group = "Player Info",
   description = "module.customhearts.description"
)
public final class CustomHearts extends Module implements cloudSupport100 {
   private final BooleanSetting customHeartColor = this.settings.add(new BooleanSetting("customHeartColor", false));
   private final ColorSetting heartColor = this.settings.add(new ColorSetting("heartColor", -60653).setCondition(this.customHeartColor));
   private final BooleanSetting customGoldColor = this.settings.add(new BooleanSetting("customGoldColor", false));
   private final ColorSetting goldColor = this.settings.add(new ColorSetting("goldColor", -2838729).setCondition(this.customGoldColor));
   private final BooleanSetting poison = this.settings.add(new BooleanSetting("poison", true));
   private final BooleanSetting wither = this.settings.add(new BooleanSetting("wither", true));
   private final BooleanSetting frozen = this.settings.add(new BooleanSetting("frozen", true));
   private final BooleanSetting damageFlash = this.settings.add(new BooleanSetting("damageFlash", true));
   private final BooleanSetting lowHealthShake = this.settings.add(new BooleanSetting("lowHealthShake", true));
   private final BooleanSetting regenWave = this.settings.add(new BooleanSetting("regenWave", true));

   public CustomHearts() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport45.v1 = false;
   }

   private void onEnable() {
      this.v21();
      visualSupport45.v1 = true;
   }

   private void v21() {
      visualSupport45.v3 = this.customHeartColor.getValue();
      visualSupport45.v4 = this.heartColor.getValue();
      visualSupport45.v5 = this.customGoldColor.getValue();
      visualSupport45.v6 = this.goldColor.getValue();
      visualSupport45.v7 = this.poison.getValue();
      visualSupport45.v8 = this.wither.getValue();
      visualSupport45.v9 = this.frozen.getValue();
      visualSupport45.v10 = this.damageFlash.getValue();
      visualSupport45.v11 = this.lowHealthShake.getValue();
      visualSupport45.v12 = this.regenWave.getValue();
   }

   @Override
   public void v1() {
      if (!this.isEnabled()) {
         this.v21();
      }

      visualSupport45.v2 = true;
   }

   @Override
   public void v2() {
      visualSupport45.v2 = false;
   }
}
