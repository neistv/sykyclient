package cc.syky.mixin.interaction;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_310.class})
public abstract class MinecraftClientItemUseMixin {
   public MinecraftClientItemUseMixin() {
   }

   @Inject(
      method = {"method_1583"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$areaPickUse(CallbackInfo var1) {
      SykyRuntime var2 = Syky.rootOrNull();
      if (var2 != null && uiSupport259.v1("use.area-pick", () -> var2.v13().v3(), false)) {
         var1.cancel();
      }
   }
}
