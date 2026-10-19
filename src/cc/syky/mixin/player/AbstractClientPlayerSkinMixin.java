package cc.syky.mixin.player;

import cc.syky.ui.uiSupport223;
import net.minecraft.class_1068;
import net.minecraft.class_310;
import net.minecraft.class_742;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_742.class})
public abstract class AbstractClientPlayerSkinMixin {
   public AbstractClientPlayerSkinMixin() {
   }

   @Inject(
      method = {"method_52814"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$maskSelfSkin(CallbackInfoReturnable<class_8685> var1) {
      if (uiSupport223.v3) {
         class_310 var2 = class_310.method_1551();
         class_742 var3 = (class_742)this;
         if (var2 != null && var3 == var2.field_1724) {
            var1.setReturnValue(class_1068.method_4648(var3.method_5667()));
         }
      }
   }
}
