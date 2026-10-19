package cc.syky.mixin.player;

import cc.syky.cloud.cloudSupport90;
import cc.syky.module.visual.visualSupport16;
import cc.syky.ui.uiSupport232;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1657;
import net.minecraft.class_2561;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1657.class})
public abstract class PlayerDisplayNameMixin {
   public PlayerDisplayNameMixin() {
   }

   @Inject(
      method = {"method_5476"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$decorateName(CallbackInfoReturnable<class_2561> var1) {
      if (visualSupport16.v1 && visualSupport16.v4 || cloudSupport90.v1) {
         class_2561 var2 = (class_2561)var1.getReturnValue();
         if (var2 != null) {
            class_1657 var3 = (class_1657)this;
            if (var3.method_73183().method_8608()) {
               var1.setReturnValue(uiSupport259.v1("nametag.decorate-name", () -> uiSupport232.v2(var3.method_5667(), var3.method_7334().name(), var2), var2));
            }
         }
      }
   }
}
