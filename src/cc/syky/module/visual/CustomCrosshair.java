package cc.syky.module.visual;

import cc.syky.account.accountSupport21;
import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "customcrosshair",
   displayName = "Custom Crosshair",
   category = ModuleCategory.VISUAL,
   group = "Crosshair & Highlights",
   description = "module.customcrosshair.description"
)
public final class CustomCrosshair extends Module {
   private final BooleanSetting v2 = this.settings.addHidden(new BooleanSetting("lines", true));
   private final BooleanSetting tStyle = this.settings.add(new BooleanSetting("tStyle", false), SettingCondition.v1(this.v2));
   private final FloatSetting length = this.settings.add(new FloatSetting("length", 2.0F, 0.0F, 30.0F), SettingCondition.v1(this.v2));
   private final FloatSetting thickness = this.settings.add(new FloatSetting("thickness", 1.0F, 1.0F, 10.0F), SettingCondition.v1(this.v2));
   private final FloatSetting gap = this.settings.add(new FloatSetting("gap", 2.0F, 0.0F, 20.0F), SettingCondition.v1(this.v2));
   private final BooleanSetting dot = this.settings.add(new BooleanSetting("dot", false));
   private final FloatSetting dotSize = this.settings.add(new FloatSetting("dotSize", 2.0F, 1.0F, 10.0F).setCondition(this.dot));
   private final BooleanSetting outline = this.settings.add(new BooleanSetting("outline", true));
   private final FloatSetting outlineThickness = this.settings.add(new FloatSetting("outlineThickness", 0.5F, 0.5F, 5.0F).setCondition(this.outline));
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -1));
   private final ColorSetting outlineColor = this.settings.add(new ColorSetting("outlineColor", -16777216).setCondition(this.outline));
   private final BooleanSetting targetHighlight = this.settings.add(new BooleanSetting("targetHighlight", false));
   private final ColorSetting targetColor = this.settings.add(new ColorSetting("targetColor", -52429).setCondition(this.targetHighlight));
   private final BooleanSetting dynamic = this.settings.add(new BooleanSetting("dynamic", true), SettingCondition.v1(this.v2));
   private final FloatSetting dynamicAmount = this.settings.add(new FloatSetting("dynamicAmount", 4.5F, 0.0F, 30.0F).setCondition(this.dynamic));
   private final BooleanSetting v18 = this.settings.addHidden(new BooleanSetting("cooldownBar", false));
   private final FloatSetting barLength = this.settings.add(new FloatSetting("barLength", 16.0F, 4.0F, 60.0F), SettingCondition.v1(this.v18));
   private final FloatSetting barThickness = this.settings.add(new FloatSetting("barThickness", 2.0F, 1.0F, 8.0F), SettingCondition.v1(this.v18));
   private final FloatSetting barOffset = this.settings.add(new FloatSetting("barOffset", 10.0F, 2.0F, 40.0F), SettingCondition.v1(this.v18));
   private final ColorSetting barColor = this.settings.add(new ColorSetting("barColor", -1), SettingCondition.v1(this.v18));
   private final ColorSetting barTrackColor = this.settings.add(new ColorSetting("barTrackColor", Integer.MIN_VALUE), SettingCondition.v1(this.v18));
   private final BooleanSetting barRounded = this.settings.add(new BooleanSetting("barRounded", true), SettingCondition.v1(this.v18));
   private final BooleanSetting barHideWhenReady = this.settings.add(new BooleanSetting("barHideWhenReady", true), SettingCondition.v1(this.v18));
   private final BooleanSetting thirdPerson = this.settings.add(new BooleanSetting("thirdPerson", false));

   @Override
   public void onEnableHook() {
      accountSupport21.v1();
   }

   public CustomCrosshair() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      accountSupport21.v1 = false;
   }

   private void onEnable() {
      accountSupport21.v3 = this.v2.getValue();
      accountSupport21.v4 = this.tStyle.getValue();
      accountSupport21.v5 = this.length.getValue();
      accountSupport21.v6 = this.thickness.getValue();
      accountSupport21.v7 = this.gap.getValue();
      accountSupport21.v8 = this.dot.getValue();
      accountSupport21.v9 = this.dotSize.getValue();
      accountSupport21.v10 = this.outline.getValue();
      accountSupport21.v11 = this.outlineThickness.getValue();
      accountSupport21.v13 = this.color.getValue();
      accountSupport21.v12 = this.outlineColor.getValue();
      accountSupport21.v14 = this.targetHighlight.getValue();
      accountSupport21.v15 = this.targetColor.getValue();
      accountSupport21.v16 = this.dynamic.getValue();
      accountSupport21.v18 = this.dynamicAmount.getValue();
      accountSupport21.v19 = this.v18.getValue();
      accountSupport21.v17 = this.barLength.getValue();
      accountSupport21.v20 = this.barThickness.getValue();
      accountSupport21.v21 = this.barOffset.getValue();
      accountSupport21.v22 = this.barColor.getValue();
      accountSupport21.v24 = this.barTrackColor.getValue();
      accountSupport21.v25 = this.barRounded.getValue();
      accountSupport21.v26 = this.barHideWhenReady.getValue();
      accountSupport21.v2 = this.thirdPerson.getValue();
      accountSupport21.v1 = true;
   }
}
