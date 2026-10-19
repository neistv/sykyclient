package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_2693;
import net.minecraft.class_310;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class SignEditorOpenGuardMixin {
   public SignEditorOpenGuardMixin() {
   }

   @Inject(
      method = {"method_11108"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$guardSignOpen(class_2693 var1, CallbackInfo var2) {
      class_310 var3 = class_310.method_1551();
      if (var3 != null && var3.method_18854()) {
         SykyRuntime var4 = Syky.rootOrNull();
         if (var4 != null) {
            uiSupport259.v1("net.sign-guard", () -> var4.v26().v1((class_634)this, var1, var2));
         }
      }
   }
}
