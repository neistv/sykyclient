package cc.syky.mixin.camera;

import cc.syky.cloud.cloudSupport69;
import cc.syky.module.visual.visualSupport21;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_4587;
import net.minecraft.class_757;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_757.class})
public abstract class GameRendererViewBobMixin {
   public GameRendererViewBobMixin() {
   }

   @Inject(
      method = {"method_3186"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$cameraBobUnderShaderpack(class_4587 var1, float var2, CallbackInfo var3) {
      if (visualSupport21.v1) {
         if (uiSupport259.v1("render.viewbob.shaderpack", cloudSupport69::v1, false)) {
            var3.cancel();
         }
      }
   }

   @WrapOperation(
      method = {"method_3188"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_757;method_3186(Lnet/minecraft/class_4587;F)V"
      )}
   )
   private void syky$cameraBob(class_757 var1, class_4587 var2, float var3, Operation<Void> var4) {
      if (!visualSupport21.v1) {
         var4.call(new Object[]{var1, var2, var3});
      }
   }

   @WrapOperation(
      method = {"method_3172"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_757;method_3186(Lnet/minecraft/class_4587;F)V"
      )}
   )
   private void syky$handBob(class_757 var1, class_4587 var2, float var3, Operation<Void> var4) {
      if (!visualSupport21.v1 || visualSupport21.v2) {
         var4.call(new Object[]{var1, var2, var3});
      }
   }
}
