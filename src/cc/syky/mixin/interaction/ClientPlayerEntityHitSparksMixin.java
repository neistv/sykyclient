package cc.syky.mixin.interaction;

import cc.syky.module.visual.visualSupport44;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1297;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_746.class})
public abstract class ClientPlayerEntityHitSparksMixin {
   public ClientPlayerEntityHitSparksMixin() {
   }

   @Inject(
      method = {"method_7277"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hideEdgeHitCrit(class_1297 var1, CallbackInfo var2) {
      if (uiSupport259.v1("edge-hit.local-crit", () -> visualSupport44.v2(var1), false)) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"method_7304"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hideEdgeHitEnchant(class_1297 var1, CallbackInfo var2) {
      if (uiSupport259.v1("edge-hit.local-enchant", () -> visualSupport44.v2(var1), false)) {
         var2.cancel();
      }
   }
}
