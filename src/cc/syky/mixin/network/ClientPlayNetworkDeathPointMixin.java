package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkDeathPointMixin {
   public ClientPlayNetworkDeathPointMixin() {
   }

   @Inject(
      method = {"method_34075"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_746;method_22419()Z"
      )}
   )
   private void syky$onLocalDeath(CallbackInfo var1) {
      SykyRuntime var2 = Syky.rootOrNull();
      if (var2 != null) {
         uiSupport259.v1("net.death-point", () -> var2.v12().v2());
      }
   }
}
