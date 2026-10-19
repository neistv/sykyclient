package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport101;
import cc.syky.config.BooleanSetting;
import cc.syky.hud.hudSupport74;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.module.visual.visualSupport6;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport190;
import java.util.EnumSet;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_310;

@ModuleInfo(
   name = "dropguard",
   displayName = "Drop Guard",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.dropguard.description"
)
public final class DropGuard extends Module {
   private static final String v2 = "module.dropguard.notice";
   private static final int name = 40;
   private final cloudSupport101 displayName;
   private final visualSupport6<hudSupport74> category = this.settings.add(new visualSupport6<>("slots", hudSupport74.class, EnumSet.of(hudSupport74.SLOT_1)));
   private final BooleanSetting notice = this.settings.add(new BooleanSetting("notice", true));
   private int description;

   public DropGuard(uiRecord14 var1) {
      this.displayName = var1.v2();
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   @Override
   public void onResetHook() {
      this.v17();
   }

   @Override
   public void onRenderHook() {
      uiSupport190.v3 = false;
      this.description = 0;
   }

   private void v17() {
      if (this.description > 0) {
         this.description--;
      }

      if (uiSupport190.v3) {
         uiSupport190.v3 = false;
         if (this.notice.getValue() && this.description <= 0) {
            class_310 var1 = this.displayName.v1();
            if (var1 != null && var1.field_1705 != null) {
               var1.field_1705
                  .method_1758(
                     class_2561.method_43470(FogBlurSupport.v1("module.dropguard.notice", "Slot locked by Drop Guard")).method_27692(class_124.field_1061),
                     false
                  );
               this.description = 40;
            }
         }
      }
   }

   private void onEnable() {
      uiSupport190.v1 = true;
      uiSupport190.v2 = this.v22();
   }

   private void onDisable() {
      uiSupport190.v1 = false;
      uiSupport190.v2 = 0;
      uiSupport190.v3 = false;
   }

   private int v22() {
      int var1 = 0;

      for (hudSupport74 var5 : this.category.v11()) {
         if (this.category.v1(var5)) {
            var1 |= var5.v3();
         }
      }

      return var1;
   }
}
