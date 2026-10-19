package cc.syky.mixin.input;

import cc.syky.module.utilities.utilitiesSupport2;
import cc.syky.ui.uiSupport216;
import net.minecraft.class_10185;
import net.minecraft.class_743;
import net.minecraft.class_744;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_743.class})
public abstract class KeyboardInputMixin {
   public KeyboardInputMixin() {
   }

   @Inject(
      method = {"method_3129"},
      at = {@At("TAIL")}
   )
   private void syky$holdKeys(CallbackInfo var1) {
      class_744 var2 = (class_744)this;
      class_10185 var3 = var2.field_54155;
      boolean var4 = var3.comp_3165() || uiSupport216.v1;
      boolean var5 = utilitiesSupport2.v1 ? utilitiesSupport2.v2 : var3.comp_3164();
      if (var4 != var3.comp_3165() || var5 != var3.comp_3164()) {
         var2.field_54155 = new class_10185(var3.comp_3159(), var3.comp_3160(), var3.comp_3161(), var3.comp_3162(), var3.comp_3163(), var5, var4);
      }
   }
}
