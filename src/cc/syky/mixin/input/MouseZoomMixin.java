package cc.syky.mixin.input;

import cc.syky.module.utilities.Zoom;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_312;
import net.minecraft.class_7172;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_312.class})
public abstract class MouseZoomMixin {
   public MouseZoomMixin() {
   }

   @WrapOperation(
      method = {"method_1606"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_7172;method_41753()Ljava/lang/Object;",
         ordinal = 0
      )}
   )
   private Object syky$zoomSensitivity(class_7172<Double> var1, Operation<Object> var2) {
      Object var3 = var2.call(new Object[]{var1});
      double var4 = uiSupport259.v1("mouse.zoom-sensitivity", Zoom::v17, 1.0);
      return var4 >= 1.0 ? var3 : (Double)var3 * var4;
   }
}
