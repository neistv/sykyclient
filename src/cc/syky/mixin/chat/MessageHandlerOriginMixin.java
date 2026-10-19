package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport194;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.authlib.GameProfile;
import net.minecraft.class_2561;
import net.minecraft.class_338;
import net.minecraft.class_7469;
import net.minecraft.class_7591;
import net.minecraft.class_7594;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_7594.class})
public abstract class MessageHandlerOriginMixin {
   private static final String ADD_SIGNED = "Lnet/minecraft/client/gui/hud/ChatHud;addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V";
   private static final String ADD_PLAIN = "Lnet/minecraft/client/gui/hud/ChatHud;addMessage(Lnet/minecraft/text/Text;)V";

   public MessageHandlerOriginMixin() {
   }

   @WrapOperation(
      method = {"method_44943"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_338;method_44811(Lnet/minecraft/class_2561;Lnet/minecraft/class_7469;Lnet/minecraft/class_7591;)V"
      )}
   )
   private void syky$fromPlayer(
      class_338 var1, class_2561 var2, class_7469 var3, class_7591 var4, Operation<Void> var5, @Local(argsOnly = true) GameProfile var6
   ) {
      uiSupport194.v1 = true;
      uiSupport194.v2 = var6 == null ? null : var6.id();

      try {
         var5.call(new Object[]{var1, var2, var3, var4});
      } finally {
         uiSupport194.v1 = false;
         uiSupport194.v2 = null;
      }
   }

   @WrapOperation(
      method = {"method_44736", "method_45745"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_338;method_1812(Lnet/minecraft/class_2561;)V"
      )}
   )
   private void syky$fromServer(class_338 var1, class_2561 var2, Operation<Void> var3) {
      uiSupport194.v1 = true;
      uiSupport194.v2 = null;

      try {
         var3.call(new Object[]{var1, var2});
      } finally {
         uiSupport194.v1 = false;
      }
   }
}
