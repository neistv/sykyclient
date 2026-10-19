package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_310;
import net.minecraft.class_638;

@ModuleInfo(
   name = "noshading",
   displayName = "No Shading",
   category = ModuleCategory.VISUAL,
   group = "Light & Color",
   description = "module.noshading.description"
)
public final class NoShading extends Module {
   private final BooleanSetting blocks = this.settings.add(new BooleanSetting("blocks", true));
   private final BooleanSetting clouds = this.settings.add(new BooleanSetting("clouds", true));
   private final BooleanSetting entities = this.settings.add(new BooleanSetting("entities", true));
   private final BooleanSetting cornerShadows = this.settings.add(new BooleanSetting("cornerShadows", false));
   private final uiRecord14 group;

   public NoShading(uiRecord14 var1) {
      this.group = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      this.v1(this.blocks.getValue(), this.clouds.getValue(), this.entities.getValue() && visualSupport27.v2, this.cornerShadows.getValue());
   }

   private void onDisable() {
      this.v1(false, false, false, false);
   }

   private void v1(boolean var1, boolean var2, boolean var3, boolean var4) {
      boolean var5 = false;
      if (var1 != visualSupport26.v1) {
         visualSupport26.v1 = var1;
         var5 = true;
      }

      if (var4 != visualSupport26.v2) {
         visualSupport26.v2 = var4;
         var5 = true;
      }

      class_310 var6 = this.group.v2().v1();
      if (var5 && var6.field_1687 != null) {
         var6.field_1769.method_3279();
      }

      if (var2 != visualSupport26.v3) {
         visualSupport26.v3 = var2;
         if (var6.field_1769 != null) {
            var6.field_1769.method_62196().method_62166();
         }
      }

      if (var3 != visualSupport26.v4) {
         visualSupport26.v4 = var3;
         class_638 var7 = var6.field_1687;
         if (var7 != null && var6.field_1773 != null) {
            var6.field_1773.method_71114().method_71036(var7.method_8597().comp_5221());
         }
      }
   }
}
