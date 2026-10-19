package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport101;
import cc.syky.config.BooleanSetting;
import cc.syky.config.IntSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport188;
import net.minecraft.class_124;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_746;
import net.minecraft.class_7923;

@ModuleInfo(
   name = "durabilityguard",
   displayName = "Durability Guard",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.durabilityguard.description"
)
public final class DurabilityGuard extends Module {
   private static final String v2 = "module.durabilityguard.notice";
   private static final int name = 40;
   private final cloudSupport101 displayName;
   private final IntSetting reserve = this.settings.add(new IntSetting("reserve", 10, 1, 200));
   private final BooleanSetting adaptive = this.settings.add(new BooleanSetting("adaptive", true));
   private final BooleanSetting notice = this.settings.add(new BooleanSetting("notice", true));
   private int defaultEnabled;

   public DurabilityGuard(uiRecord14 var1) {
      this.displayName = var1.v2();
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   @Override
   public void onResetHook() {
      this.v17();
      this.v20();
   }

   @Override
   public void onRenderHook() {
      uiSupport188.v4.v2();
      this.defaultEnabled = 0;
   }

   private void v17() {
      if (this.adaptive.getValue()) {
         class_746 var1 = this.displayName.v2();
         if (var1 == null) {
            uiSupport188.v4.v1();
         } else {
            class_1799 var2 = var1.method_31548().method_7391();
            if (!var2.method_7963()) {
               uiSupport188.v4.v1();
            } else {
               uiSupport188.v4.v2(class_7923.field_41178.method_10206(var2.method_7909()), var1.method_31548().method_67532(), var2.method_7919());
            }
         }
      }
   }

   private void v20() {
      if (this.defaultEnabled > 0) {
         this.defaultEnabled--;
      }

      if (uiSupport188.v5) {
         uiSupport188.v5 = false;
         if (this.notice.getValue() && this.defaultEnabled <= 0) {
            class_310 var1 = this.displayName.v1();
            if (var1 != null && var1.field_1705 != null) {
               var1.field_1705
                  .method_1758(
                     class_2561.method_43470(FogBlurSupport.v1("module.durabilityguard.notice", "Durability reserve reached"))
                        .method_27692(class_124.field_1061),
                     false
                  );
               this.defaultEnabled = 40;
            }
         }
      }
   }

   private void onEnable() {
      uiSupport188.v1 = true;
      uiSupport188.v2 = this.reserve.getValue();
      uiSupport188.v3 = this.adaptive.getValue();
   }

   private void onDisable() {
      uiSupport188.v1 = false;
      uiSupport188.v5 = false;
      uiSupport188.v4.v2();
   }
}
