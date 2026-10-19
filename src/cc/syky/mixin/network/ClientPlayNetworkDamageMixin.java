package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.module.visual.visualSupport44;
import cc.syky.ui.uiSupport243;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_634;
import net.minecraft.class_8143;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkDamageMixin {
   public ClientPlayNetworkDamageMixin() {
   }

   @Inject(
      method = {"method_49034"},
      at = {@At("TAIL")}
   )
   private void syky$onEntityDamage(class_8143 var1, CallbackInfo var2) {
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null) {
         uiSupport259.v1("net.entity-damage", () -> {
            if (!visualSupport44.v1()) {
               var3.v4().v1(var1.comp_1267(), var1.comp_1269(), var1.comp_1268());
               uiSupport243.v1(var3.v5(), var1.comp_1267(), var1.comp_1269());
            }
         });
      }
   }

   @WrapOperation(
      method = {"method_49034"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_1297;method_48922(Lnet/minecraft/class_1282;)V"
      )}
   )
   private void syky$hideEdgeHit(class_1297 var1, class_1282 var2, Operation<Void> var3) {
      if (!uiSupport259.v1("net.edge-hit.damage", () -> visualSupport44.v1(var1, var2), false)) {
         var3.call(new Object[]{var1, var2});
      }
   }
}
