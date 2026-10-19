package cc.syky.mixin.gpu;

import cc.syky.ui.uiSupport163;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_10860;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_10860.class})
public abstract class GlCommandEncoderMixin {
   public GlCommandEncoderMixin() {
   }

   @WrapOperation(
      method = {"method_68346"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/opengl/GlStateManager;_glBindFramebuffer(II)V"
      )}
   )
   private void syky$keepTargetInRun(int var1, int var2, Operation<Void> var3) {
      if (uiSupport163.v1) {
         uiSupport163.v2++;
      } else {
         var3.call(new Object[]{var1, var2});
      }
   }
}
