package cc.syky.mixin.hud;

import cc.syky.module.visual.visualSupport21;
import net.minecraft.class_366;
import net.minecraft.class_367;
import net.minecraft.class_368;
import net.minecraft.class_372;
import net.minecraft.class_374;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_374.class})
public abstract class ToastManagerFilterMixin {
   public ToastManagerFilterMixin() {
   }

   @Inject(
      method = {"method_1999"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$noToasts(class_368 var1, CallbackInfo var2) {
      if (visualSupport21.v9 && (var1 instanceof class_367 || var1 instanceof class_366 || var1 instanceof class_372)) {
         var2.cancel();
      }
   }
}
