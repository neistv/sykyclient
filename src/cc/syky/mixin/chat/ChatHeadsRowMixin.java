package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport209;
import cc.syky.ui.uiSupport213;
import net.minecraft.class_303.class_7590;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(
   targets = {"net/minecraft/class_338$1"}
)
public abstract class ChatHeadsRowMixin {
   public ChatHeadsRowMixin() {
   }

   @ModifyVariable(
      method = {"accept"},
      at = @At("HEAD"),
      argsOnly = true
   )
   private class_7590 syky$publishRow(class_7590 var1) {
      if (uiSupport213.v2) {
         uiSupport209 var2 = (uiSupport209)var1;
         uiSupport213.v4 = var1.comp_896();
         uiSupport213.v5 = var2.syky$heads();
         uiSupport213.v6 = var2.syky$headXs();
      }

      return var1;
   }
}
