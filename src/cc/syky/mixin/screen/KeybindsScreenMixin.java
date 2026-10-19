package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport259;
import cc.syky.ui.uiSupport9;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_459;
import net.minecraft.class_6599;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_6599.class})
public abstract class KeybindsScreenMixin {
   @Shadow
   private class_459 field_34801;

   public KeybindsScreenMixin() {
   }

   @Inject(
      method = {"method_25404"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$captureKey(class_11908 var1, CallbackInfoReturnable<Boolean> var2) {
      class_6599 var3 = (class_6599)this;
      class_459 var4 = this.field_34801;
      if (var4 != null) {
         if (uiSupport259.v1("keybinds.capture-key", () -> uiSupport9.v1(var3, var4, var1.comp_4795(), var1.comp_4797()), false)) {
            var2.setReturnValue(true);
         }
      }
   }

   @Inject(
      method = {"method_25402"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$captureButton(class_11909 var1, boolean var2, CallbackInfoReturnable<Boolean> var3) {
      class_6599 var4 = (class_6599)this;
      class_459 var5 = this.field_34801;
      if (var5 != null) {
         if (uiSupport259.v1("keybinds.capture-button", () -> uiSupport9.v2(var4, var5, var1.method_74245(), var1.comp_4797()), false)) {
            var3.setReturnValue(true);
         }
      }
   }
}
