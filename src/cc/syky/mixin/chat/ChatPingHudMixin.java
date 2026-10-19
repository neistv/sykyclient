package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport204;
import cc.syky.ui.uiSupport206;
import cc.syky.ui.uiSupport207;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_303;
import net.minecraft.class_338;
import net.minecraft.class_303.class_7590;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({class_338.class})
public abstract class ChatPingHudMixin {
   public ChatPingHudMixin() {
   }

   @ModifyExpressionValue(
      method = {"method_44811"},
      at = {@At(
         value = "NEW",
         target = "(ILnet/minecraft/class_2561;Lnet/minecraft/class_7469;Lnet/minecraft/class_7591;)Lnet/minecraft/class_303;"
      )}
   )
   private class_303 syky$tagMention(class_303 var1) {
      if (uiSupport207.v3) {
         uiSupport207.v3 = false;
         ((uiSupport204)var1).syky$mention(true);
      }

      return var1;
   }

   @ModifyExpressionValue(
      method = {"method_1815"},
      at = {@At(
         value = "NEW",
         target = "(ILnet/minecraft/class_5481;Lnet/minecraft/class_7591;Z)Lnet/minecraft/class_303$class_7590;"
      )}
   )
   private class_7590 syky$tagMentionRow(class_7590 var1, @Local(argsOnly = true) class_303 var2) {
      if (((uiSupport204)var2).syky$mention()) {
         ((uiSupport204)var1).syky$mention(true);
      }

      return var1;
   }

   @ModifyArg(
      method = {"method_75802"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_338$class_12233;method_75809(IIIII)V"
      ),
      index = 4
   )
   private static int syky$highlightRow(int var0, @Local(argsOnly = true) class_7590 var1, @Local(argsOnly = true,ordinal = 1) float var2) {
      int var3 = uiSupport207.v4;
      return var3 != 0 && ((uiSupport204)var1).syky$mention() ? uiSupport259.v1("chat.ping.highlight", () -> uiSupport206.v1(var0, var3, var2), var0) : var0;
   }
}
