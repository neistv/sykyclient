package cc.syky.mixin.camera;

import cc.syky.module.utilities.Freelook;
import cc.syky.ui.uiSupport228;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({class_4184.class})
public abstract class CameraFreelookMixin {
   public CameraFreelookMixin() {
   }

   @WrapOperation(
      method = {"method_19321"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_1297;method_5705(F)F"
      )}
   )
   private float syky$freelookYaw(class_1297 var1, float var2, Operation<Float> var3) {
      float var4 = (Float)var3.call(new Object[]{var1, var2});
      return uiSupport259.v1("camera.freelook-yaw", () -> Freelook.v17() ? Freelook.v20() : var4, var4);
   }

   @WrapOperation(
      method = {"method_19321"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_1297;method_5695(F)F"
      )}
   )
   private float syky$freelookPitch(class_1297 var1, float var2, Operation<Float> var3) {
      float var4 = (Float)var3.call(new Object[]{var1, var2});
      return uiSupport259.v1("camera.freelook-pitch", () -> Freelook.v17() ? Freelook.v21() : var4, var4);
   }

   @ModifyArg(
      method = {"method_19321"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4184;method_19318(F)F"
      ),
      index = 0
   )
   private float syky$thirdPersonDistance(float var1) {
      return uiSupport259.v1("camera.third-person-distance", () -> uiSupport228.v1(var1), var1);
   }
}
