package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport12;
import cc.syky.module.visual.visualSupport29;
import cc.syky.module.visual.visualSupport51;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.buffers.Std140Builder;
import net.minecraft.class_2874;
import net.minecraft.class_765;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_765.class})
public abstract class LightmapTextureManagerMixin {
   @Shadow
   private boolean field_4135;

   public LightmapTextureManagerMixin() {
   }

   @Inject(
      method = {"method_3313"},
      at = {@At("HEAD")}
   )
   private void syky$stepFullBright(float var1, CallbackInfo var2) {
      uiSupport259.v1("fullbright.step", visualSupport29::v3);
      if (visualSupport51.v3) {
         this.field_4135 = true;
      }
   }

   @WrapOperation(
      method = {"method_3313"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_2874;comp_656()F"
      )}
   )
   private float syky$fullBright(class_2874 var1, Operation<Float> var2) {
      float var3 = (Float)var2.call(new Object[]{var1});
      float var4 = visualSupport51.v1;
      return var4 <= 0.0F ? var3 : var3 + var4 * (1.0F - var3);
   }

   @WrapOperation(
      method = {"method_3313"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/buffers/Std140Builder;putFloat(F)Lcom/mojang/blaze3d/buffers/Std140Builder;",
         ordinal = 1
      )}
   )
   private Std140Builder syky$skyFactor(Std140Builder var1, float var2, Operation<Std140Builder> var3) {
      return (Std140Builder)var3.call(new Object[]{var1, uiSupport259.v1("worldtint.skyFactor", () -> visualSupport12.v1(var2), var2)});
   }

   @WrapOperation(
      method = {"method_3313"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/buffers/Std140Builder;putFloat(F)Lcom/mojang/blaze3d/buffers/Std140Builder;",
         ordinal = 3
      )}
   )
   private Std140Builder syky$nightVision(Std140Builder var1, float var2, Operation<Std140Builder> var3) {
      return (Std140Builder)var3.call(new Object[]{var1, Math.max(var2, visualSupport51.v2)});
   }

   @WrapOperation(
      method = {"method_3313"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_9848;method_64963(I)Lorg/joml/Vector3f;"
      )}
   )
   private Vector3f syky$skyLightColor(int var1, Operation<Vector3f> var2) {
      Vector3f var3 = (Vector3f)var2.call(new Object[]{var1});
      uiSupport259.v1("worldtint.skyLight", () -> visualSupport12.v1(var3));
      return var3;
   }
}
