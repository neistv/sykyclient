package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_156;
import net.minecraft.class_2923;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class PingResultMixin {
   public PingResultMixin() {
   }

   @Inject(
      method = {"method_12666"},
      at = {@At("HEAD")}
   )
   private void syky$onPingResult(class_2923 var1, CallbackInfo var2) {
      long var3 = class_156.method_658() - var1.comp_2201();
      SykyRuntime var5 = Syky.rootOrNull();
      if (var5 != null) {
         var5.v21().v1(() -> uiSupport259.v1("net.ping-result", () -> var5.v4().v2(var3)));
      }
   }
}
