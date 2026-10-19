package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport26;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_310.class})
public abstract class MinecraftClientAmbientOcclusionMixin {
   public MinecraftClientAmbientOcclusionMixin() {
   }

   @Inject(
      method = {"method_1588"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$removeCornerShadows(CallbackInfoReturnable<Boolean> var0) {
      if (visualSupport26.v2) {
         var0.setReturnValue(false);
      }
   }
}
