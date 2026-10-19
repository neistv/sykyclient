package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport183;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

@ModuleInfo(
   name = "freelook",
   displayName = "Freelook",
   category = ModuleCategory.UTILITIES,
   group = "Camera Tools",
   description = "module.freelook.description"
)
public final class Freelook extends Module {
   private static final float v2 = 0.15F;
   private static boolean name;
   private static float displayName;
   private static float category;
   private final uiRecord14 group;
   private final EnumSetting<BackSupport> description = this.settings.add(new EnumSetting<>("view", BackSupport.BACK));
   private final BooleanSetting scrollZoom = this.settings.add(new BooleanSetting("scrollZoom", true));
   private final BooleanSetting smooth = this.settings.add(new BooleanSetting("smooth", true));

   public Freelook(uiRecord14 var1) {
      this.group = var1;
   }

   @Override
   public void onEnableHook() {
      this.v22();
   }

   @Override
   public void onTickHook() {
      this.v22();
   }

   @Override
   public void onRenderHook() {
      name = false;
      uiSupport183.v1();
   }

   @Override
   public void onDisableHook() {
      name = false;
      uiSupport183.v1();
   }

   private void v22() {
      class_310 var1 = this.group.v2().v1();
      class_746 var2 = var1 == null ? null : var1.field_1724;
      if (var2 != null) {
         displayName = var2.method_36454();
         category = var2.method_36455();
         uiSupport183.v1(this.smooth.getValue(), this.scrollZoom.getValue(), this.description.getValue());
         name = true;
      }
   }

   @Override
   public void onResetHook() {
      if (name) {
         uiSupport183.v1(this.smooth.getValue(), this.scrollZoom.getValue());
      }
   }

   public static boolean v17() {
      return name;
   }

   public static float v20() {
      return displayName;
   }

   public static float v21() {
      return category;
   }

   public static void v1(double var0, double var2) {
      displayName += (float)(var0 * 0.15F);
      category = class_3532.method_15363(category + (float)(var2 * 0.15F), -90.0F, 90.0F);
   }
}
