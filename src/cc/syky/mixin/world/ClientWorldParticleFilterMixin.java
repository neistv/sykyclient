package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport21;
import net.minecraft.class_11749;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_6012;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_638.class})
public abstract class ClientWorldParticleFilterMixin {
   public ClientWorldParticleFilterMixin() {
   }

   @Inject(
      method = {"method_31595"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$noBreakDust(class_2338 var1, class_2680 var2, CallbackInfo var3) {
      if (visualSupport21.v10) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_74254"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$noMiningDust(class_2338 var1, class_2350 var2, CallbackInfo var3) {
      if (visualSupport21.v10) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_73228"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$noExplosionDebris(class_243 var1, float var2, int var3, class_6012<class_11749> var4, CallbackInfo var5) {
      if (visualSupport21.v11) {
         var5.cancel();
      }
   }
}
