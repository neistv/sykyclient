package cc.syky.mixin.camera;

import cc.syky.ui.uiSupport183;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_310;
import net.minecraft.class_5498;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_310.class})
public abstract class MinecraftClientPerspectiveMixin {
   public MinecraftClientPerspectiveMixin() {
   }

   @WrapOperation(
      method = {"method_1508"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_5498;method_31036()Lnet/minecraft/class_5498;"
      )}
   )
   private class_5498 syky$freelookPerspective(class_5498 var1, Operation<class_5498> var2) {
      class_5498 var3 = (class_5498)var2.call(new Object[]{var1});
      class_5498 var4 = uiSupport259.v1("client.freelook-perspective", () -> uiSupport183.v1(var3), var3);
      return var4 == null ? var3 : var4;
   }
}
