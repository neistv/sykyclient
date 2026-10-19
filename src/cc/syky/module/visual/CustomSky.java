package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport69;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport175;
import java.nio.file.Path;
import net.minecraft.class_310;
import net.minecraft.class_3928;
import net.minecraft.class_2874.class_12326;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "sky",
   displayName = "Custom Sky",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.sky.description"
)
public final class CustomSky extends Module {
   private static final String v2 = "Custom Sky: choose a panorama or a skybox picture";
   private final uiRecord14 name;
   private final FileNotSupport2 displayName;
   private final visualSupport category;
   @Nullable
   private visualSupport7 group;
   @Nullable
   private visualSupport7 description;
   private class_12326 defaultEnabled = class_12326.field_64386;
   private int subscriptions = -1;
   private final Path enableAction;
   private final EnumSetting<visualSupport37> disableAction = this.settings.add(new EnumSetting<>("mode", visualSupport37.VANILLA));
   private final BooleanSetting enabled = this.settings
      .add(new BooleanSetting("customColor", true), SettingCondition.v1(this.disableAction, visualSupport37.VANILLA));
   private final ColorSetting v13 = this.settings
      .add(new ColorSetting("color", -1).setCondition(this.enabled), SettingCondition.v1(this.disableAction, visualSupport37.VANILLA));
   private final BooleanSetting v14 = this.settings.add(new BooleanSetting("hideSun", false), SettingCondition.v1(this.disableAction, visualSupport37.VANILLA));
   private final BooleanSetting v15 = this.settings
      .add(new BooleanSetting("hideMoon", false), SettingCondition.v1(this.disableAction, visualSupport37.VANILLA));
   private final BooleanSetting v16 = this.settings
      .add(new BooleanSetting("hideStars", false), SettingCondition.v1(this.disableAction, visualSupport37.VANILLA));
   private final visualSupport7 v18 = this.v1("picture");
   private final visualSupport7 v19 = this.v1("pictureNether");
   private final visualSupport7 v17 = this.v1("pictureEnd");
   private final SettingCondition v20 = SettingCondition.v1(this.disableAction, visualSupport37.CUSTOM).v1(SettingCondition.v1(this::v22));
   private final IntSetting v21 = this.settings.add(new IntSetting("rotation", 0, 0, 359).v1("°"), this.v20);
   private final IntSetting v22 = this.settings.add(new IntSetting("spin", 0, -120, 120).v1("°/min"), this.v20);
   private final BooleanSetting v24 = this.settings.add(new BooleanSetting("followTime", true), this.v20);
   private final BooleanSetting v25 = this.settings.add(new BooleanSetting("showSunMoon", false), this.v20);
   private final FloatSetting v26 = this.settings
      .add(new FloatSetting("brightness", 100.0F, 10.0F, 300.0F), SettingCondition.v1(this.disableAction, visualSupport37.CUSTOM));
   private final FloatSetting v27 = this.settings
      .add(
         new FloatSetting("speed", 100.0F, 0.0F, 400.0F),
         SettingCondition.v1(this.disableAction, visualSupport37.CUSTOM).v1(SettingCondition.v1(() -> !this.v22()))
      );
   private final BooleanSetting v28 = this.settings.add(new BooleanSetting("hideClouds", false));

   public CustomSky(uiRecord14 var1, Path var2) {
      this.name = var1;
      this.enableAction = var2;
      this.displayName = new FileNotSupport2(var1.v3(), var1.v4(), var2);
      this.category = new visualSupport(var1.v3(), var1.v4(), "Custom Sky: choose a panorama or a skybox picture", this.displayName::v4);
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport51.v10 = false;
      visualSupport51.v11 = false;
      visualSupport51.v18 = false;
      uiSupport175.v3 = null;
      uiSupport175.v4 = false;
      this.description = null;
      this.displayName.v4();
   }

   @Override
   public void onEnableHook() {
      uiSupport175.v3();
   }

   @Override
   public void onTickHook() {
      uiSupport175.v3();
   }

   private void onEnable() {
      visualSupport51.v10 = true;
      boolean var1 = this.disableAction.getValue() == visualSupport37.CUSTOM;
      class_310 var2 = this.name.v2().v1();
      class_12326 var3 = var2 != null && var2.field_1687 != null ? var2.field_1687.method_8597().comp_5220() : null;
      if (var3 != null) {
         this.defaultEnabled = var3;
      }

      visualSupport7 var4 = var1 && var3 != null ? this.v1(var3) : null;
      visualSupport7 var5 = var1 ? this.v1(var3 != null ? var3 : this.defaultEnabled) : null;
      this.v1(var2, var5 != null && var5.v10() ? var5 : null);
      this.v21();
      boolean var6 = uiSupport175.v3 != null;
      boolean var7 = var4 != null && (var4.v10() ? var6 : !this.v22() && var3 != class_12326.field_64385);
      visualSupport51.v11 = var7;
      uiSupport175.v4 = var7 && var3 == class_12326.field_64385 && !cloudSupport69.v1();
      visualSupport51.v12 = !var1 && this.enabled.getValue();
      visualSupport51.v13 = this.v13.getValue();
      boolean var8 = var7 && var6 && this.v25.getValue();
      visualSupport51.v14 = var7 ? !var8 : !var1 && this.v14.getValue();
      visualSupport51.v15 = var7 ? !var8 : !var1 && this.v15.getValue();
      visualSupport51.v16 = var7 || !var1 && this.v16.getValue();
      visualSupport51.v18 = this.v28.getValue();
      uiSupport175.v11 = this.v26.getValue() / 100.0F;
      uiSupport175.v12 = this.v27.getValue() / 100.0F;
      uiSupport175.v6 = this.v21.getValue().intValue();
      uiSupport175.v7 = this.v22.getValue().intValue() / 60.0F;
      uiSupport175.v8 = this.v24.getValue();
   }

   private void v1(@Nullable class_310 var1, @Nullable visualSupport7 var2) {
      if (var2 != null && var1 != null && var1.field_1773 != null) {
         this.description = var2;
         this.displayName
            .v1(
               var2.getName(),
               var2.v12(),
               FileNotSupport2.v1(var1.method_22683().method_4506(), ((Integer)var1.field_1690.method_41808().method_41753()).intValue())
            );
         boolean var3 = var1.field_1687 != null && !(var1.field_1755 instanceof class_3928);
         this.displayName.v1(var3);
         uiSupport175.v3 = this.displayName.v1();
         uiSupport175.v5 = this.displayName.v2();
      } else {
         uiSupport175.v3 = null;
         this.description = null;
         this.displayName.v4();
      }
   }

   private void v21() {
      visualSupport7[] var1 = new visualSupport7[]{this.v18, this.v19, this.v17};
      int var2 = 0;

      for (int var3 = 0; var3 < var1.length; var3++) {
         if (var1[var3].v10()) {
            var2 |= 1 << var3;
         }
      }

      if (var2 != this.subscriptions) {
         this.subscriptions = var2;

         for (int var5 = 0; var5 < var1.length; var5++) {
            if ((var2 & 1 << var5) == 0) {
               Path var4 = this.enableAction.resolve(var1[var5].getName() + ".cube");
               this.name.v3().v1(() -> visualSupport39.v2(var4));
            }
         }
      }
   }

   private visualSupport7 v1(class_12326 var1) {
      return switch (var1) {
         case field_64386 -> this.v18;
         case field_64385 -> this.v19;
         case field_64387 -> this.v17;
         default -> throw new MatchException(null, null);
      };
   }

   private boolean v22() {
      return this.v18.v10() || this.v19.v10() || this.v17.v10();
   }

   private visualSupport7 v1(String var1) {
      visualSupport7 var2 = new visualSupport7(var1, "Select picture");
      var2.v2(() -> this.v2(var2)).v1(() -> this.v1(var2));
      return this.settings.add(var2, SettingCondition.v1(this.disableAction, visualSupport37.CUSTOM));
   }

   @Nullable
   private String v1(visualSupport7 var1) {
      if (this.category.v1() && this.group == var1) {
         return "Choosing...";
      } else {
         return this.isEnabled() && this.description == var1 ? this.displayName.v3() : null;
      }
   }

   private void v2(visualSupport7 var1) {
      if (!this.category.v1()) {
         this.group = var1;
      }

      this.category.v1(var1);
   }
}
