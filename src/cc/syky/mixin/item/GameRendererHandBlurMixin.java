package cc.syky.mixin.item;

import cc.syky.cloud.cloudSupport35;
import cc.syky.module.visual.visualSupport51;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_757;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_757.class})
public abstract class GameRendererHandBlurMixin {
   public GameRendererHandBlurMixin() {
   }

   @Inject(
      method = {"method_3172"},
      at = {@At("HEAD")}
   )
   private void syky$handBlurBegin(float var1, boolean var2, Matrix4f var3, CallbackInfo var4) {
      if (visualSupport51.v44 || cloudSupport35.v11) {
         uiSupport259.v1("render.handblur.begin", cloudSupport35::v1);
      }
   }

   @Inject(
      method = {"method_3172"},
      at = {@At("RETURN")}
   )
   private void syky$handBlurEnd(float var1, boolean var2, Matrix4f var3, CallbackInfo var4) {
      if (cloudSupport35.v1 || cloudSupport35.v11) {
         uiSupport259.v1("render.handblur.end", cloudSupport35::v2);
      }
   }
}
