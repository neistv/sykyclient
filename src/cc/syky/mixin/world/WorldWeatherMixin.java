package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport51;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1937.class})
public abstract class WorldWeatherMixin {
   public WorldWeatherMixin() {
   }

   @Shadow
   public abstract boolean method_8608();

   @Inject(
      method = {"method_8430"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$forceRain(float var1, CallbackInfoReturnable<Float> var2) {
      if (visualSupport51.v72 && this.method_8608()) {
         var2.setReturnValue(visualSupport51.v80);
      }
   }

   @Inject(
      method = {"method_8478"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$forceThunder(float var1, CallbackInfoReturnable<Float> var2) {
      if (visualSupport51.v72 && this.method_8608()) {
         var2.setReturnValue(visualSupport51.v84);
      }
   }
}
