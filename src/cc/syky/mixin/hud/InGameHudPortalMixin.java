package cc.syky.mixin.hud;

import cc.syky.module.visual.visualSupport21;
import net.minecraft.class_329;
import net.minecraft.class_332;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_329.class})
public abstract class InGameHudPortalMixin {
   public InGameHudPortalMixin() {
   }

   @Inject(
      method = {"method_1746"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$noPortalOverlay(class_332 var1, float var2, CallbackInfo var3) {
      if (visualSupport21.v6) {
         var3.cancel();
      }
   }
}
