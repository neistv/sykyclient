package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport31;
import cc.syky.cloud.cloudSupport32;
import cc.syky.cloud.cloudSupport33;
import cc.syky.cloud.cloudSupport34;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import java.util.EnumSet;
import net.minecraft.class_310;

@ModuleInfo(
   name = "tracker",
   displayName = "Tracker",
   category = ModuleCategory.VISUAL,
   group = "Crosshair & Highlights",
   description = "module.tracker.description"
)
public final class Tracker extends Module {
   private final IntSetting density = this.settings.add(new IntSetting("density", 26, 4, 96));
   private final FloatSetting chaos = this.settings.add(new FloatSetting("chaos", 0.6F, 0.0F, 1.0F));
   private final FloatSetting strobe = this.settings.add(new FloatSetting("strobe", 0.45F, 0.0F, 1.0F));
   private final FloatSetting zoneHold = this.settings.add(new FloatSetting("zoneHold", 2.5F, 0.5F, 8.0F));
   private final FloatSetting spread = this.settings.add(new FloatSetting("spread", 0.45F, 0.0F, 1.0F));
   private final FloatSetting range = this.settings.add(new FloatSetting("range", 128.0F, 16.0F, 256.0F));
   private final visualSupport6<cloudSupport32> defaultEnabled = this.settings
      .add(new visualSupport6<>("modes", cloudSupport32.class, EnumSet.allOf(cloudSupport32.class)));
   private final visualSupport6<cloudSupport34> subscriptions = this.settings
      .add(new visualSupport6<>("kinds", cloudSupport34.class, EnumSet.allOf(cloudSupport34.class)));
   private final EnumSetting<cloudSupport33> enableAction = this.settings.add(new EnumSetting<>("links", cloudSupport33.LINES));
   private final BooleanSetting labels = this.settings.add(new BooleanSetting("labels", true));
   private final FloatSetting thickness = this.settings.add(new FloatSetting("thickness", 1.0F, 0.5F, 3.0F));
   private final ColorSetting boxColor = this.settings.add(new ColorSetting("boxColor", -1));
   private final ColorSetting crossColor = this.settings.add(new ColorSetting("crossColor", -1));
   private final ColorSetting panelColor = this.settings.add(new ColorSetting("panelColor", 1308622847));
   private final ColorSetting tickColor = this.settings.add(new ColorSetting("tickColor", -1));
   private final ColorSetting wireColor = this.settings.add(new ColorSetting("wireColor", -1), SettingCondition.v2(this.enableAction, cloudSupport33.OFF));
   private final ColorSetting tagColor = this.settings.add(new ColorSetting("tagColor", -1).setCondition(this.labels));
   private final uiRecord14 v17;

   public Tracker(uiRecord14 var1) {
      this.v17 = var1;
      this.setToggleActions(this::v17, cloudSupport31::v1);
   }

   private void v17() {
      cloudSupport31.v1 = true;
      cloudSupport31.v9 = this.density.getValue();
      cloudSupport31.v11 = this.chaos.getValue();
      cloudSupport31.v12 = this.strobe.getValue();
      cloudSupport31.v13 = this.zoneHold.getValue();
      cloudSupport31.v14 = this.spread.getValue();
      cloudSupport31.v10 = this.range.getValue();
      cloudSupport31.v15 = this.enableAction.getValue();
      cloudSupport31.v16 = this.labels.getValue();
      cloudSupport31.v8 = this.thickness.getValue();
      cloudSupport31.v2 = this.boxColor.getValue();
      cloudSupport31.v3 = this.crossColor.getValue();
      cloudSupport31.v4 = this.panelColor.getValue();
      cloudSupport31.v5 = this.tickColor.getValue();
      cloudSupport31.v6 = this.wireColor.getValue();
      cloudSupport31.v7 = this.tagColor.getValue();
      cloudSupport31.v18 = this.v20();
      cloudSupport31.v19 = this.v21();
   }

   private int v20() {
      int var1 = 0;

      for (cloudSupport34 var5 : cloudSupport34.values()) {
         if (this.subscriptions.v1(var5)) {
            var1 |= 1 << var5.ordinal();
         }
      }

      return var1;
   }

   private int v21() {
      int var1 = 0;

      for (cloudSupport32 var5 : cloudSupport32.values()) {
         if (this.defaultEnabled.v1(var5)) {
            var1 |= 1 << var5.ordinal();
         }
      }

      return var1;
   }

   @Override
   public void onDisableHook() {
      cloudSupport31.v2();
   }

   @Override
   public void onRenderHook() {
      cloudSupport31.v2();
   }

   @Override
   public void onResetHook() {
      class_310 var1 = this.v17.v2().v1();
      if (var1 == null) {
         cloudSupport31.v2();
      } else {
         cloudSupport31.v1(var1);
      }
   }
}
