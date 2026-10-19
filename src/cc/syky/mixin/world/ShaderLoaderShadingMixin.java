package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport27;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_10151;
import net.minecraft.class_3300;
import net.minecraft.class_3695;
import net.minecraft.class_10151.class_10153;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_10151.class})
public abstract class ShaderLoaderShadingMixin {
   public ShaderLoaderShadingMixin() {
   }

   @Inject(
      method = {"method_62942"},
      require = 0,
      at = {@At("HEAD")}
   )
   private void syky$forgetEntityLightPatch(class_3300 var1, class_3695 var2, CallbackInfoReturnable<class_10153> var3) {
      visualSupport27.v2 = false;
   }

   @ModifyExpressionValue(
      method = {"method_62939"},
      require = 0,
      at = {@At(
         value = "INVOKE",
         target = "Ljava/lang/String;join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;"
      )}
   )
   private static String syky$patchEntityLight(String var0) {
      String var1 = uiSupport259.v1("shader.noshading", () -> visualSupport27.v1(var0), var0);
      return var1 != null ? var1 : var0;
   }
}
