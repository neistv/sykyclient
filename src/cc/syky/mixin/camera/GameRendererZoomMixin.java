package cc.syky.mixin.camera;

import cc.syky.module.utilities.utilitiesSupport;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_4184;
import net.minecraft.class_757;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_757.class})
public abstract class GameRendererZoomMixin {
   public GameRendererZoomMixin() {
   }

   @Inject(
      method = {"method_3196"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$applyZoom(class_4184 var1, float var2, boolean var3, CallbackInfoReturnable<Float> var4) {
      double var5 = var3 ? uiSupport259.v1("render.zoom", utilitiesSupport::v2, 1.0) : uiSupport259.v1("render.zoom", utilitiesSupport::v1, 1.0);
      if (!(var5 <= 1.001)) {
         var4.setReturnValue((float)(var4.getReturnValueF() / var5));
      }
   }
}
