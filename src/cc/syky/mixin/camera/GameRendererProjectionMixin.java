package cc.syky.mixin.camera;

import cc.syky.module.visual.visualSupport62;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_757;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_757.class})
public abstract class GameRendererProjectionMixin {
   public GameRendererProjectionMixin() {
   }

   @Inject(
      method = {"method_22973"},
      at = {@At("RETURN")}
   )
   private void syky$worldProjection(float var1, CallbackInfoReturnable<Matrix4f> var2) {
      float var3 = uiSupport259.v1("render.aspect", visualSupport62::v1, 1.0F);
      if (Math.abs(var3 - 1.0F) >= 1.0E-4F) {
         Matrix4f var4 = (Matrix4f)var2.getReturnValue();
         var4.m00(var4.m00() * var3);
      }
   }

   @ModifyArg(
      method = {"method_3188"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11279;method_71095(IIF)Lcom/mojang/blaze3d/buffers/GpuBufferSlice;"
      ),
      index = 0
   )
   private int syky$handProjection(int var1) {
      float var2 = uiSupport259.v1("render.aspect.hand", visualSupport62::v2, 1.0F);
      return var1 > 0 && !(Math.abs(var2 - 1.0F) < 1.0E-4F) ? Math.max(1, Math.round(var1 / var2)) : var1;
   }
}
