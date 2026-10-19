package cc.syky.mixin.interaction;

import cc.syky.ui.uiSupport190;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_746.class})
public abstract class ClientPlayerEntityDropMixin {
   public ClientPlayerEntityDropMixin() {
   }

   @Inject(
      method = {"method_7290"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$holdLockedSlot(boolean var1, CallbackInfoReturnable<Boolean> var2) {
      if (uiSupport190.v1) {
         class_746 var3 = (class_746)this;
         boolean var4 = uiSupport259.v1("dropguard.drop", () -> uiSupport190.v1(var3), false);
         if (var4) {
            var2.setReturnValue(false);
         }
      }
   }
}
