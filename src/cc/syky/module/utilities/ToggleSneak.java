package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport101;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_310;
import net.minecraft.class_746;

@ModuleInfo(
   name = "togglesneak",
   displayName = "Toggle Sneak",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.togglesneak.description"
)
public final class ToggleSneak extends Module {
   private final cloudSupport101 v2;
   private final utilitiesSupport3 name = new utilitiesSupport3();

   public ToggleSneak(uiRecord14 var1) {
      this.v2 = var1.v2();
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   @Override
   public void onRenderHook() {
      this.onDisable();
   }

   private void onEnable() {
      class_310 var1 = this.v2.v1();
      class_746 var2 = this.v2.v2();
      if (var1 != null && var2 != null && var2.method_5805() && !this.v1(var1)) {
         utilitiesSupport2.v2 = this.name.v1(var1.field_1690.field_1832.method_1434(), var1.field_1755 != null);
         utilitiesSupport2.v1 = true;
      } else {
         this.onDisable();
      }
   }

   private void onDisable() {
      utilitiesSupport2.v1 = false;
      utilitiesSupport2.v2 = false;
      this.name.v1();
   }

   private boolean v1(class_310 var1) {
      return (Boolean)var1.field_1690.method_42449().method_41753();
   }
}
