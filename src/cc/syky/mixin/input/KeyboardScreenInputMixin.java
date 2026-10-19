package cc.syky.mixin.input;

import cc.syky.internal.InternalSupport15;
import cc.syky.module.utilities.utilitiesSupport13;
import cc.syky.ui.uiSupport141;
import cc.syky.ui.uiSupport142;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_309;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_309.class})
public abstract class KeyboardScreenInputMixin {
   private static final int GLFW_KEY_ESCAPE = 256;

   public KeyboardScreenInputMixin() {
   }

   @WrapOperation(
      method = {"method_1466"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_25404(Lnet/minecraft/class_11908;)Z"
      )}
   )
   private boolean syky$keyPressToOverlay(class_437 var1, class_11908 var2, Operation<Boolean> var3) {
      uiSupport141 var4 = uiSupport142.v1;
      if (var4 != null && var4 != var1) {
         return uiSupport259.v1("clickgui.overlay.keyPressed", () -> var4.method_25404(var2), false);
      } else if (var2.comp_4795() == 256 && uiSupport259.v1("whatsnew.escape", InternalSupport15::v2, false)) {
         return true;
      } else {
         return uiSupport259.v1("hud.style.keyPressed", () -> utilitiesSupport13.v1(var2.comp_4795(), var2.comp_4797()), false)
            ? true
            : (Boolean)var3.call(new Object[]{var1, var2});
      }
   }

   @WrapOperation(
      method = {"method_1466"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_16803(Lnet/minecraft/class_11908;)Z"
      )}
   )
   private boolean syky$keyReleaseToOverlay(class_437 var1, class_11908 var2, Operation<Boolean> var3) {
      uiSupport141 var4 = uiSupport142.v1;
      return var4 != null && var4 != var1
         ? uiSupport259.v1("clickgui.overlay.keyReleased", () -> var4.method_16803(var2), false)
         : (Boolean)var3.call(new Object[]{var1, var2});
   }

   @WrapOperation(
      method = {"method_1457"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_25400(Lnet/minecraft/class_11905;)Z"
      )}
   )
   private boolean syky$charToOverlay(class_437 var1, class_11905 var2, Operation<Boolean> var3) {
      uiSupport141 var4 = uiSupport142.v1;
      if (var4 != null && var4 != var1) {
         return uiSupport259.v1("clickgui.overlay.charTyped", () -> var4.method_25400(var2), false);
      } else {
         return uiSupport259.v1("hud.style.charTyped", () -> utilitiesSupport13.v2(var2.comp_4793(), var2.comp_4794()), false)
            ? true
            : (Boolean)var3.call(new Object[]{var1, var2});
      }
   }
}
