package cc.syky.mixin.input;

import cc.syky.module.utilities.utilitiesSupport12;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_312.class})
public abstract class MouseScrollMixin {
   public MouseScrollMixin() {
   }

   @Inject(
      method = {"method_1598"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$scroll(long var1, double var3, double var5, CallbackInfo var7) {
      class_310 var8 = class_310.method_1551();
      if (var8.field_1755 == null && var8.method_18506() == null && var8.field_1724 != null) {
         if (var1 == var8.method_22683().method_4490()) {
            if (uiSupport259.v1("mouse.scroll", () -> utilitiesSupport12.v1(var5), false)) {
               var7.cancel();
            }
         }
      }
   }
}
