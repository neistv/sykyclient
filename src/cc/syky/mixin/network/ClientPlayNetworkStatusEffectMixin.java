package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_2783;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkStatusEffectMixin {
   public ClientPlayNetworkStatusEffectMixin() {
   }

   @Inject(
      method = {"method_11084"},
      at = {@At("TAIL")}
   )
   private void syky$onEntityStatusEffect(class_2783 var1, CallbackInfo var2) {
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null) {
         uiSupport259.v1("net.status-effect", () -> var3.v4().v1(var1.method_11943(), var1.method_11946(), var1.method_11945(), var1.method_11944()));
      }
   }
}
