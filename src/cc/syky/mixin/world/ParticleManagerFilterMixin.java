package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport21;
import net.minecraft.class_1297;
import net.minecraft.class_2394;
import net.minecraft.class_702;
import net.minecraft.class_703;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_702.class})
public abstract class ParticleManagerFilterMixin {
   public ParticleManagerFilterMixin() {
   }

   @Inject(
      method = {"method_3056"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$filterAddParticle(
      class_2394 var1, double var2, double var4, double var6, double var8, double var10, double var12, CallbackInfoReturnable<class_703> var14
   ) {
      if (visualSupport21.v12 && visualSupport21.v13.contains(var1.method_10295())) {
         var14.setReturnValue(null);
      }
   }

   @Inject(
      method = {"method_3061"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$filterEmitter(class_1297 var1, class_2394 var2, CallbackInfo var3) {
      if (visualSupport21.v12 && visualSupport21.v13.contains(var2.method_10295())) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_3051"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$filterEmitterAged(class_1297 var1, class_2394 var2, int var3, CallbackInfo var4) {
      if (visualSupport21.v12 && visualSupport21.v13.contains(var2.method_10295())) {
         var4.cancel();
      }
   }
}
