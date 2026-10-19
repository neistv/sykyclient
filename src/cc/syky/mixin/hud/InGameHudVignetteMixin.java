package cc.syky.mixin.hud;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.module.visual.visualSupport21;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_1297;
import net.minecraft.class_329;
import net.minecraft.class_332;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_329.class})
public abstract class InGameHudVignetteMixin {
   public InGameHudVignetteMixin() {
   }

   @Inject(
      method = {"method_1735"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hudUnderScreen(class_332 var1, class_1297 var2, CallbackInfo var3) {
      SykyRuntime var4 = Syky.rootOrNull();
      if (var4 != null && uiSupport259.v1("hud.vignette-under-screen", () -> var4.v3().v16(), false)) {
         var3.cancel();
      }
   }

   @ModifyExpressionValue(
      method = {"method_1735"},
      at = {@At(
         value = "FIELD",
         target = "Lnet/minecraft/class_329;field_2013:F"
      )}
   )
   private float syky$noVignetteDarkness(float var1) {
      return visualSupport21.v5 ? 0.0F : var1;
   }
}
