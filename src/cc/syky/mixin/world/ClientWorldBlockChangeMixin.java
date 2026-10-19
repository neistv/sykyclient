package cc.syky.mixin.world;

import cc.syky.ui.uiSupport180;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_638.class})
public abstract class ClientWorldBlockChangeMixin {
   public ClientWorldBlockChangeMixin() {
   }

   @Inject(
      method = {"method_30092"},
      at = {@At("RETURN")}
   )
   private void syky$blockChanged(class_2338 var1, class_2680 var2, int var3, int var4, CallbackInfoReturnable<Boolean> var5) {
      if (uiSupport180.v1 && var5.getReturnValueZ()) {
         uiSupport259.v1("lightoverlay.block", () -> uiSupport180.v1(var1));
      }
   }
}
