package cc.syky.mixin.item;

import cc.syky.module.visual.visualSupport50;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_12250;
import net.minecraft.class_156;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_12250.class})
public abstract class TextureTransformGlintMixin {
   public TextureTransformGlintMixin() {
   }

   @Inject(
      method = {"method_76031"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$customGlint(float var0, CallbackInfoReturnable<Matrix4f> var1) {
      if (visualSupport50.v3) {
         Matrix4f var2 = uiSupport259.v1("glint.transform", () -> {
            long var1x = (long)(class_156.method_658() * 4.0 * visualSupport50.v7);
            float var3 = (float)(var1x % 110000L) / 110000.0F;
            float var4 = (float)(var1x % 30000L) / 30000.0F;
            return new Matrix4f().translation(-var3, var4, 0.0F).rotateZ(visualSupport50.v8).scale(var0 / visualSupport50.v6);
         }, null);
         if (var2 != null) {
            var1.setReturnValue(var2);
         }
      }
   }
}
