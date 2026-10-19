package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudRecord8;
import cc.syky.cloud.cloudSupport56;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "colorgrade",
   displayName = "Color Correction",
   category = ModuleCategory.VISUAL,
   group = "Light & Color",
   description = "module.colorgrade.description"
)
public final class ColorCorrection extends Module {
   private static final float v2 = 2.0F;
   private final EnumSetting<visualSupport59> name = this.settings.add(new EnumSetting<>("preset", visualSupport59.CUSTOM));
   private final FloatSetting exposure = this.settings.add(new FloatSetting("exposure", 0.0F, -100.0F, 100.0F));
   private final FloatSetting contrast = this.settings.add(new FloatSetting("contrast", 0.0F, -100.0F, 100.0F));
   private final FloatSetting saturation = this.settings.add(new FloatSetting("saturation", 0.0F, -100.0F, 100.0F));
   private final FloatSetting vibrance = this.settings.add(new FloatSetting("vibrance", 0.0F, -100.0F, 100.0F));
   private final BooleanSetting defaultEnabled = this.settings.addHidden(new BooleanSetting("tone", false));
   private final FloatSetting highlights = this.settings.add(new FloatSetting("highlights", 0.0F, -100.0F, 100.0F), SettingCondition.v1(this.defaultEnabled));
   private final FloatSetting shadows = this.settings.add(new FloatSetting("shadows", 0.0F, -100.0F, 100.0F), SettingCondition.v1(this.defaultEnabled));
   private final FloatSetting whites = this.settings.add(new FloatSetting("whites", 0.0F, -100.0F, 100.0F), SettingCondition.v1(this.defaultEnabled));
   private final FloatSetting blacks = this.settings.add(new FloatSetting("blacks", 0.0F, -100.0F, 100.0F), SettingCondition.v1(this.defaultEnabled));
   private final FloatSetting curve = this.settings.add(new FloatSetting("curve", 0.0F, 0.0F, 100.0F), SettingCondition.v1(this.defaultEnabled));
   private final FloatSetting pivot = this.settings.add(new FloatSetting("pivot", 50.0F, 10.0F, 90.0F), SettingCondition.v1(this.defaultEnabled));
   private final BooleanSetting v15 = this.settings.addHidden(new BooleanSetting("whiteBalance", false));
   private final FloatSetting temperature = this.settings.add(new FloatSetting("temperature", 0.0F, -100.0F, 100.0F), SettingCondition.v1(this.v15));
   private final FloatSetting tint = this.settings.add(new FloatSetting("tint", 0.0F, -100.0F, 100.0F), SettingCondition.v1(this.v15));
   private final BooleanSetting v19 = this.settings.addHidden(new BooleanSetting("splitTone", false));
   private final FloatSetting splitStrength = this.settings.add(new FloatSetting("splitStrength", 35.0F, 0.0F, 100.0F), SettingCondition.v1(this.v19));
   private final ColorSetting shadowTint = this.settings.add(new ColorSetting("shadowTint", -12816753), SettingCondition.v1(this.v19));
   private final ColorSetting highlightTint = this.settings.add(new ColorSetting("highlightTint", -13942), SettingCondition.v1(this.v19));
   private final FloatSetting splitBalance = this.settings.add(new FloatSetting("splitBalance", 0.0F, -100.0F, 100.0F), SettingCondition.v1(this.v19));
   private final BooleanSetting grayscale = this.settings.add(new BooleanSetting("grayscale", false));
   private final FloatSetting grayscaleAmount = this.settings.add(new FloatSetting("grayscaleAmount", 100.0F, 0.0F, 100.0F).setCondition(this.grayscale));
   private final EnumSetting<cloudSupport56> v26 = this.settings
      .add(new EnumSetting<>("grayscaleFilter", cloudSupport56.NONE), SettingCondition.v1(this.grayscale));
   @Nullable
   private visualSupport59 v27;
   @Nullable
   private cloudRecord8 v28;

   public ColorCorrection() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport51.v48 = false;
      visualSupport51.v40 = cloudRecord8.NEUTRAL;
   }

   private void onEnable() {
      visualSupport51.v48 = true;
      visualSupport51.v40 = this.v21();
   }

   private cloudRecord8 v21() {
      visualSupport59 var1 = this.name.getValue();
      boolean var2 = var1 != this.v27;
      if (var2 && var1 != visualSupport59.CUSTOM) {
         this.v1(var1);
      }

      cloudRecord8 var3 = this.v22();
      if (var2) {
         this.v27 = var1;
         this.v28 = var3;
      } else if (this.v27 != visualSupport59.CUSTOM && this.v28 != null && !var3.equals(this.v28)) {
         this.name.setValue(visualSupport59.CUSTOM);
         this.v27 = visualSupport59.CUSTOM;
         this.v28 = var3;
      }

      return var3;
   }

   private void v1(visualSupport59 var1) {
      this.exposure.setValue(var1.v1());
      this.contrast.setValue(var1.v2());
      this.saturation.setValue(var1.v3());
      this.vibrance.setValue(var1.v4());
      this.defaultEnabled.setValue(var1.v14());
      this.highlights.setValue(var1.v5());
      this.shadows.setValue(var1.v6());
      this.whites.setValue(var1.v7());
      this.blacks.setValue(var1.v8());
      this.curve.setValue(var1.v9());
      this.pivot.setValue(50.0F);
      this.v15.setValue(var1.v15());
      this.temperature.setValue(var1.v10());
      this.tint.setValue(var1.v11());
      this.v19.setValue(var1.v12() != 0.0F);
      this.splitBalance.setValue(0.0F);
      if (var1.v12() != 0.0F) {
         this.splitStrength.setValue(var1.v12());
      }

      this.grayscale.setValue(var1.v13() != 0.0F);
      if (var1.v13() != 0.0F) {
         this.grayscaleAmount.setValue(var1.v13());
      }
   }

   private cloudRecord8 v22() {
      return new cloudRecord8(
         this.exposure.getValue() / 100.0F * 2.0F,
         this.contrast.getValue() / 100.0F,
         this.saturation.getValue() / 100.0F,
         this.vibrance.getValue() / 100.0F,
         this.defaultEnabled.getValue() ? this.pivot.getValue() / 100.0F : 0.5F,
         this.defaultEnabled.getValue() ? this.highlights.getValue() / 100.0F : 0.0F,
         this.defaultEnabled.getValue() ? this.shadows.getValue() / 100.0F : 0.0F,
         this.defaultEnabled.getValue() ? this.whites.getValue() / 100.0F : 0.0F,
         this.defaultEnabled.getValue() ? this.blacks.getValue() / 100.0F : 0.0F,
         this.defaultEnabled.getValue() ? this.curve.getValue() / 100.0F : 0.0F,
         this.v15.getValue() ? this.temperature.getValue() / 100.0F : 0.0F,
         this.v15.getValue() ? this.tint.getValue() / 100.0F : 0.0F,
         this.v19.getValue() ? this.splitStrength.getValue() / 100.0F : 0.0F,
         this.splitBalance.getValue() / 100.0F,
         this.shadowTint.getValue() & 16777215,
         this.highlightTint.getValue() & 16777215,
         this.grayscale.getValue() ? this.grayscaleAmount.getValue() / 100.0F : 0.0F,
         this.v26.getValue()
      );
   }
}
