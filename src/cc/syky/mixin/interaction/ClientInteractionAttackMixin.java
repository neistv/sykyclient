package cc.syky.mixin.interaction;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.module.visual.visualSupport64;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_636.class})
public abstract class ClientInteractionAttackMixin {
   public ClientInteractionAttackMixin() {
   }

   @Inject(
      method = {"method_2918"},
      at = {@At("HEAD")}
   )
   private void syky$onAttackEntity(class_1657 var1, class_1297 var2, CallbackInfo var3) {
      SykyRuntime var4 = Syky.rootOrNull();
      if (var4 != null) {
         uiSupport259.v1("event.attack-entity", () -> visualSupport64.v1(var4.v5(), var2));
      }
   }
}
