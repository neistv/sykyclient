package cc.syky.mixin.input;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.internal.InternalSupport59;
import cc.syky.ui.uiSupport242;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_11908;
import net.minecraft.class_309;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_309.class})
public abstract class KeyboardMixin {
   private static final int GLFW_RELEASE = 0;
   private static final int GLFW_PRESS = 1;

   public KeyboardMixin() {
   }

   @Inject(
      method = {"method_1466"},
      at = {@At("HEAD")}
   )
   private void syky$onKey(long var1, int var3, class_11908 var4, CallbackInfo var5) {
      SykyRuntime var6 = Syky.rootOrNull();
      if (var6 != null) {
         uiSupport259.v1("event.key", () -> {
            if (var3 == 1) {
               InternalSupport59.v1(var6.v5(), var4.comp_4795(), var4.comp_4796(), var4.comp_4797());
            } else if (var3 == 0) {
               uiSupport242.v1(var6.v5(), var4.comp_4795(), var4.comp_4796(), var4.comp_4797());
            }
         });
      }
   }
}
