package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.internal.InternalSupport52;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_310;
import net.minecraft.class_776;

@ModuleInfo(
   name = "fastgrass",
   displayName = "Fast Grass",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.fastgrass.description"
)
public final class FastGrass extends Module {
   private final uiRecord14 v2;

   public FastGrass(uiRecord14 var1) {
      this.v2 = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      if (InternalSupport52.v1 == null) {
         class_310 var1 = this.v2.v2().v1();
         if (var1 != null) {
            class_776 var2 = var1.method_1541();
            if (var2 != null) {
               visualSupport33.Part2 var3 = visualSupport33.v1(var2.method_3351());
               if (var3 != null) {
                  InternalSupport52.v2 = var3.v2();
                  InternalSupport52.v1 = var3.v1();
                  this.v21();
               }
            }
         }
      }
   }

   private void onDisable() {
      if (InternalSupport52.v1 != null) {
         InternalSupport52.v1 = null;
         InternalSupport52.v2 = false;
         this.v21();
      }
   }

   private void v21() {
      class_310 var1 = this.v2.v2().v1();
      if (var1.field_1687 != null) {
         var1.field_1769.method_3279();
      }
   }
}
