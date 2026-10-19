package cc.syky.mixin.interaction;

import cc.syky.ui.uiSupport188;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_3965;
import net.minecraft.class_636;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_636.class})
public abstract class ClientInteractionDurabilityMixin {
   public ClientInteractionDurabilityMixin() {
   }

   @Inject(
      method = {"method_2919"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$holdItemUse(class_1657 var1, class_1268 var2, CallbackInfoReturnable<class_1269> var3) {
      if (uiSupport188.v1) {
         boolean var4 = uiSupport259.v1("durabilityguard.use", () -> uiSupport188.v1(var1, var2), false);
         if (var4) {
            var3.setReturnValue(class_1269.field_5814);
         }
      }
   }

   @Inject(
      method = {"method_2896"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$holdBlockUse(class_746 var1, class_1268 var2, class_3965 var3, CallbackInfoReturnable<class_1269> var4) {
      if (uiSupport188.v1) {
         boolean var5 = uiSupport259.v1("durabilityguard.blockuse", () -> uiSupport188.v2(var1, var2), false);
         if (var5) {
            var4.setReturnValue(class_1269.field_5814);
         }
      }
   }
}
