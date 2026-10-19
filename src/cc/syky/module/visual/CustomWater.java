package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_310;

@ModuleInfo(
   name = "water",
   displayName = "Custom Water",
   category = ModuleCategory.VISUAL,
   group = "Environment Overlays",
   description = "module.water.description"
)
public final class CustomWater extends Module {
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -12618012));
   private final BooleanSetting hideFog = this.settings.add(new BooleanSetting("hideFog", false));
   private int displayName;
   private int category;
   private final uiRecord14 group;

   public CustomWater(uiRecord14 var1) {
      this.group = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport35.v1 = false;
      this.v21();
   }

   @Override
   public void onEnableHook() {
      this.displayName = this.color.getValue();
      this.category = 0;
      this.v21();
   }

   @Override
   public void onResetHook() {
      int var1 = this.color.getValue();
      if (var1 != this.displayName) {
         this.displayName = var1;
         this.category = 3;
      } else if (this.category > 0 && --this.category == 0) {
         this.v21();
      }
   }

   private void onEnable() {
      visualSupport35.v2 = this.color.getValue();
      visualSupport35.v3 = this.hideFog.getValue();
      visualSupport35.v1 = true;
   }

   private void v21() {
      class_310 var1 = this.group.v2().v1();
      if (var1.field_1687 != null) {
         var1.field_1769.method_3279();
      }
   }
}
