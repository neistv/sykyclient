package cc.syky.mixin.item;

import cc.syky.cloud.cloudSupport35;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1921;
import net.minecraft.class_9801;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1921.class})
public abstract class RenderLayerHandBlurMixin {
   public RenderLayerHandBlurMixin() {
   }

   @Inject(
      method = {"method_60895"},
      at = {@At("HEAD")}
   )
   private void syky$handBlurMeasure(class_9801 var1, CallbackInfo var2) {
      if (cloudSupport35.v12) {
         cloudSupport35.v13 = var1;
         uiSupport259.v1("render.handblur.measure", cloudSupport35::v3);
      }
   }
}
