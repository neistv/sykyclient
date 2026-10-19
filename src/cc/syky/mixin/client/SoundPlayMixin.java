package cc.syky.mixin.client;

import cc.syky.module.visual.visualSupport3;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import net.minecraft.class_1140.class_11518;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1140.class})
public abstract class SoundPlayMixin {
   public SoundPlayMixin() {
   }

   @Inject(
      method = {"method_4854"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$customSound(class_1113 var1, CallbackInfoReturnable<class_11518> var2) {
      if (uiSupport259.v1("sound.intercept", () -> visualSupport3.v1(var1), false)) {
         var2.setReturnValue(class_11518.field_60956);
      }
   }
}
