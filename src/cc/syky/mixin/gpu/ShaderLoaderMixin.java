package cc.syky.mixin.gpu;

import cc.syky.internal.Support642;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.pipeline.CompiledRenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.class_10151;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_10151.class})
public abstract class ShaderLoaderMixin {
   public ShaderLoaderMixin() {
   }

   @WrapOperation(
      method = {"method_62945"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/pipeline/CompiledRenderPipeline;isValid()Z"
      )}
   )
   private boolean syky$letOwnRejectionsThrough(CompiledRenderPipeline var1, Operation<Boolean> var2, @Local RenderPipeline var3) {
      return var2.call(new Object[]{var1}) ? true : uiSupport259.v1("shader.rejected", () -> Support642.v1(var3.getLocation()), false);
   }
}
