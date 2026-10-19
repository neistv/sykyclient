package cc.syky.mixin.interaction;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport235;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_310.class})
public abstract class MinecraftClientAttackMixin {
   public MinecraftClientAttackMixin() {
   }

   @Inject(
      method = {"method_1536"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$vetoAttack(CallbackInfoReturnable<Boolean> var1) {
      class_310 var2 = (class_310)this;
      class_746 var3 = var2.field_1724;
      if (var3 != null) {
         SykyRuntime var4 = Syky.rootOrNull();
         if (var4 != null && uiSupport259.v1("attack.area-pick", () -> var4.v13().v2(), false)) {
            var1.setReturnValue(false);
         } else {
            class_239 var5 = var2.field_1765;
            class_638 var6 = var2.field_1687;
            boolean var7 = uiSupport259.v1("attack.veto", () -> uiSupport235.v1(var3, var5, var6), false);
            if (var7) {
               var1.setReturnValue(false);
            }
         }
      }
   }
}
