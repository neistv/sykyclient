package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_2775;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkPickupMixin {
   public ClientPlayNetworkPickupMixin() {
   }

   @Inject(
      method = {"method_11150"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_2600;method_11074(Lnet/minecraft/class_2596;Lnet/minecraft/class_2547;Lnet/minecraft/class_11980;)V",
         shift = Shift.AFTER
      )}
   )
   private void syky$onItemPickup(class_2775 var1, CallbackInfo var2) {
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null) {
         uiSupport259.v1("net.item-pickup", () -> var3.v4().v1(var1.method_11915(), var1.method_11912(), var1.method_11913()));
      }
   }
}
