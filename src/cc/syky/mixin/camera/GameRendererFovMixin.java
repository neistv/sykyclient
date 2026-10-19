package cc.syky.mixin.camera;

import cc.syky.ui.uiSupport185;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_757;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_757.class})
public abstract class GameRendererFovMixin {
   public GameRendererFovMixin() {
   }

   @WrapOperation(
      method = {"method_3196"},
      at = {@At(
         value = "INVOKE",
         target = "Ljava/lang/Integer;intValue()I"
      )}
   )
   private int syky$overrideFov(Integer var1, Operation<Integer> var2) {
      int var3 = (Integer)var2.call(new Object[]{var1});
      return uiSupport259.v1("render.fov", () -> (int)uiSupport185.v1(var3), var3);
   }

   @ModifyExpressionValue(
      method = {"method_3196"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_3532;method_16439(FFF)F",
         ordinal = 0
      )}
   )
   private float syky$restoreFovFraction(float var1) {
      return var1 * uiSupport259.v1("render.fov", uiSupport185::v2, 1.0F);
   }
}
