package cc.syky.mixin.input;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.cloud.cloudSupport94;
import cc.syky.internal.InternalSupport59;
import cc.syky.ui.uiSupport229;
import cc.syky.ui.uiSupport241;
import cc.syky.ui.uiSupport242;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_11910;
import net.minecraft.class_312;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_312.class})
public abstract class MouseButtonMixin {
   private static final int GLFW_RELEASE = 0;
   private static final int GLFW_PRESS = 1;

   public MouseButtonMixin() {
   }

   @Inject(
      method = {"method_1601"},
      at = {@At("HEAD")}
   )
   private void syky$onMouseButton(long var1, class_11910 var3, int var4, CallbackInfo var5) {
      if (var3.comp_4801() == 2) {
         boolean var6 = var4 == 1;
         uiSupport259.v1("ui.middlescroll.button", () -> uiSupport229.v1(var6));
      }

      SykyRuntime var7 = Syky.rootOrNull();
      if (var7 != null) {
         if (var4 == 1) {
            uiSupport259.v1("event.mouse-button", () -> uiSupport241.v1(var7.v5(), var3.comp_4801()));
         }

         uiSupport259.v1("event.mouse-bind", () -> {
            int var3x = cloudSupport94.v1(var3.comp_4801());
            if (var4 == 1) {
               InternalSupport59.v1(var7.v5(), var3x, 0, var3.comp_4797());
            } else if (var4 == 0) {
               uiSupport242.v1(var7.v5(), var3x, 0, var3.comp_4797());
            }
         });
      }
   }
}
