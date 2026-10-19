package cc.syky.mixin.gpu;

import cc.syky.account.accountSupport15;
import cc.syky.account.accountSupport22;
import cc.syky.account.accountSupport23;
import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_4184;
import net.minecraft.class_757;
import net.minecraft.class_9779;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_757.class})
public abstract class GameRendererWorldPostMixin {
   public GameRendererWorldPostMixin() {
   }

   @Shadow
   public abstract class_4184 method_19418();

   @Inject(
      method = {"method_3188"},
      at = {@At("HEAD")}
   )
   private void syky$beginWorldPostFrame(class_9779 var1, CallbackInfo var2) {
      uiSupport259.v1("render.worldpost.frame", accountSupport23::v1);
      uiSupport259.v1("render.worldview.frame", visualSupport9::v1);
   }

   @ModifyExpressionValue(
      method = {"method_3188"},
      require = 0,
      allow = 1,
      at = {@At(
         value = "INVOKE",
         target = "Lorg/joml/Matrix4f;rotation(Lorg/joml/Quaternionfc;)Lorg/joml/Matrix4f;",
         remap = false
      )}
   )
   private Matrix4f syky$latchWorldView(Matrix4f var1) {
      uiSupport259.v1("render.worldview", () -> visualSupport9.v1(var1));
      return var1;
   }

   @Inject(
      method = {"method_3188"},
      require = 0,
      allow = 1,
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11286;method_71123(Lorg/joml/Matrix4f;)Lcom/mojang/blaze3d/buffers/GpuBufferSlice;"
      )}
   )
   private void syky$latchWorldProjection(class_9779 var1, CallbackInfo var2, @Local(ordinal = 0) Matrix4f var3) {
      uiSupport259.v1("render.worldpost.projection", () -> accountSupport22.v1(var3));
      uiSupport259.v1("render.world.projection", () -> visualSupport9.v2(var3));
   }

   @Inject(
      method = {"method_3188"},
      at = {@At("RETURN")}
   )
   private void syky$rainOnLens(class_9779 var1, CallbackInfo var2) {
      uiSupport259.v1("render.raindrops", accountSupport15::v1);
   }

   @Inject(
      method = {"method_3188"},
      require = 0,
      allow = 1,
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/systems/CommandEncoder;clearDepthTexture(Lcom/mojang/blaze3d/textures/GpuTexture;D)V"
      )}
   )
   private void syky$worldPost(class_9779 var1, CallbackInfo var2) {
      uiSupport259.v1("render.worldpost", () -> accountSupport23.v1(this.method_19418()));
   }
}
