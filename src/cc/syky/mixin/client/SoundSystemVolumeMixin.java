package cc.syky.mixin.client;

import cc.syky.module.visual.visualSupport31;
import cc.syky.ui.uiSupport207;
import net.minecraft.class_1140;
import net.minecraft.class_3419;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1140.class})
public abstract class SoundSystemVolumeMixin {
   public SoundSystemVolumeMixin() {
   }

   @Inject(
      method = {"method_43222"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$focusFade(float var1, class_3419 var2, CallbackInfoReturnable<Float> var3) {
      float var4 = visualSupport31.v1;
      if (var4 != 1.0F && !uiSupport207.v2) {
         var3.setReturnValue(var3.getReturnValueF() * var4);
      }
   }
}
