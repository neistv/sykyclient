package cc.syky.mixin.screen;

import cc.syky.internal.InternalSupport55;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport224;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_2561;
import net.minecraft.class_419;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_419.class})
public abstract class DisconnectedScreenStreamerMixin {
   public DisconnectedScreenStreamerMixin() {
   }

   @ModifyExpressionValue(
      method = {"method_25426", "method_25435"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_9812;comp_2853()Lnet/minecraft/class_2561;"
      )}
   )
   @Nullable
   private class_2561 syky$maskAddresses(@Nullable class_2561 var1) {
      return var1 != null && uiSupport223.v5 ? uiSupport259.v1("disconnect.streamer-mask", () -> uiSupport224.v1(var1, InternalSupport55.v1()), var1) : var1;
   }
}
