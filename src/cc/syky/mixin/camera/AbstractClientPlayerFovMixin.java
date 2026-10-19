package cc.syky.mixin.camera;

import cc.syky.module.visual.visualSupport21;
import net.minecraft.class_742;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_742.class})
public abstract class AbstractClientPlayerFovMixin {
   public AbstractClientPlayerFovMixin() {
   }

   @Inject(
      method = {"method_3118"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$staticFov(boolean var1, float var2, CallbackInfoReturnable<Float> var3) {
      if (visualSupport21.v4) {
         if (!var1 || !((class_742)this).method_31550()) {
            var3.setReturnValue(1.0F);
         }
      }
   }
}
