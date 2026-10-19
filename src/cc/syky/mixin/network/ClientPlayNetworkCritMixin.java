package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.module.visual.visualSupport44;
import cc.syky.ui.uiSupport244;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_2394;
import net.minecraft.class_2616;
import net.minecraft.class_634;
import net.minecraft.class_702;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkCritMixin {
   public ClientPlayNetworkCritMixin() {
   }

   @Inject(
      method = {"method_11160"},
      at = {@At("TAIL")}
   )
   private void syky$onEntityAnimation(class_2616 var1, CallbackInfo var2) {
      if (var1.method_11267() == 4) {
         SykyRuntime var3 = Syky.rootOrNull();
         if (var3 != null) {
            uiSupport259.v1("net.entity-crit", () -> uiSupport244.v1(var3.v5(), var1.method_11269()));
         }
      }
   }

   @WrapOperation(
      method = {"method_11160"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_702;method_3061(Lnet/minecraft/class_1297;Lnet/minecraft/class_2394;)V"
      )}
   )
   private void syky$hideEdgeHitSparks(class_702 var1, class_1297 var2, class_2394 var3, Operation<Void> var4) {
      if (!uiSupport259.v1("net.edge-hit.sparks", () -> visualSupport44.v3(var2), false)) {
         var4.call(new Object[]{var1, var2, var3});
      }
   }
}
