package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport201;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_338.class})
public abstract class ChatHudRevealMixin {
   public ChatHudRevealMixin() {
   }

   @ModifyVariable(
      method = {"method_1805"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 4
   )
   private boolean syky$revealExpanded(boolean var1) {
      return var1 || uiSupport201.v1;
   }

   @ModifyExpressionValue(
      method = {"method_1810"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_338;method_1819()Z"
      )}
   )
   private boolean syky$revealHeight(boolean var1) {
      return var1 || uiSupport201.v1;
   }

   @ModifyExpressionValue(
      method = {"method_1815"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_338;method_1819()Z"
      )}
   )
   private boolean syky$revealKeepsScrollPosition(boolean var1) {
      return var1 || uiSupport201.v1;
   }
}
