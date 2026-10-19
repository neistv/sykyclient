package cc.syky.mixin.input;

import cc.syky.module.utilities.Freelook;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_312;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_312.class})
public abstract class MouseFreelookMixin {
   public MouseFreelookMixin() {
   }

   @WrapOperation(
      method = {"method_1606"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_746;method_5872(DD)V"
      )}
   )
   private void syky$divertLook(class_746 var1, double var2, double var4, Operation<Void> var6) {
      boolean var7 = uiSupport259.v1("mouse.freelook-divert", () -> {
         if (!Freelook.v17()) {
            return false;
         } else {
            Freelook.v1(var2, var4);
            return true;
         }
      }, false);
      if (!var7) {
         var6.call(new Object[]{var1, var2, var4});
      }
   }
}
