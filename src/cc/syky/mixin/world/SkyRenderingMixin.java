package cc.syky.mixin.world;

import cc.syky.cloud.cloudSupport29;
import cc.syky.module.visual.visualSupport51;
import cc.syky.ui.uiSupport175;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_12076;
import net.minecraft.class_12131;
import net.minecraft.class_2874;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_9975;
import net.minecraft.class_2874.class_12326;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_9975.class})
public abstract class SkyRenderingMixin {
   public SkyRenderingMixin() {
   }

   @Inject(
      method = {"method_74926"},
      at = {@At("HEAD")}
   )
   private void syky$latchSkyCamera(class_638 var1, float var2, class_4184 var3, class_12076 var4, CallbackInfo var5) {
      if (visualSupport51.v10 && visualSupport51.v11) {
         uiSupport259.v1("render.customsky.camera", () -> uiSupport175.v1(var3));
         if (uiSupport175.v4) {
            var4.field_63098 = 0.0F;
         }
      }
   }

   @WrapOperation(
      method = {"method_74926"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_2874;comp_5220()Lnet/minecraft/class_2874$class_12326;"
      )}
   )
   private class_12326 syky$claimSkyless(class_2874 var1, Operation<class_12326> var2) {
      class_12326 var3 = (class_12326)var2.call(new Object[]{var1});
      return var3 == class_12326.field_64385 && visualSupport51.v10 && visualSupport51.v11 && uiSupport175.v4 ? class_12326.field_64387 : var3;
   }

   @Inject(
      method = {"method_74926"},
      at = {@At("TAIL")}
   )
   private void syky$overrideSkyState(class_638 var1, float var2, class_4184 var3, class_12076 var4, CallbackInfo var5) {
      if (visualSupport51.v10) {
         if (visualSupport51.v12) {
            var4.field_63097 = 0xFF000000 | visualSupport51.v13 & 16777215;
         }

         if (visualSupport51.v16) {
            var4.field_63094 = 0.0F;
         }

         if (visualSupport51.v11) {
            uiSupport175.v9 = var4.field_63091;
            uiSupport175.v10 = var4.field_63093;
         }
      }

      if (visualSupport51.v59 || visualSupport51.v53) {
         uiSupport259.v1("render.wetsurfaces.sky", () -> cloudSupport29.v1(var4));
      }
   }

   @Inject(
      method = {"method_62302"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$replaceTopSky(int var1, CallbackInfo var2) {
      if (visualSupport51.v10 && visualSupport51.v11 && uiSupport259.v1("render.customsky", uiSupport175::v1, false)) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"method_62312"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$replaceEndSky(CallbackInfo var1) {
      if (visualSupport51.v10 && visualSupport51.v11 && (uiSupport259.v1("render.customsky", uiSupport175::v1, false) || uiSupport175.v4)) {
         var1.cancel();
      }
   }

   @Inject(
      method = {"method_62305"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$skipSkyDark(CallbackInfo var1) {
      if (visualSupport51.v10 && visualSupport51.v11 && uiSupport175.v13) {
         var1.cancel();
      }
   }

   @Inject(
      method = {"method_62306"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$skipGlowingSky(class_4587 var1, float var2, int var3, CallbackInfo var4) {
      if (visualSupport51.v10 && visualSupport51.v11 && uiSupport175.v13) {
         var4.cancel();
      }
   }

   @WrapWithCondition(
      method = {"method_62307"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_9975;method_62303(FLnet/minecraft/class_4587;)V"
      )}
   )
   private boolean syky$shouldRenderSun(class_9975 var1, float var2, class_4587 var3) {
      return !visualSupport51.v10 || !visualSupport51.v14;
   }

   @WrapWithCondition(
      method = {"method_62307"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_9975;method_62304(Lnet/minecraft/class_12131;FLnet/minecraft/class_4587;)V"
      )}
   )
   private boolean syky$shouldRenderMoon(class_9975 var1, class_12131 var2, float var3, class_4587 var4) {
      return !visualSupport51.v10 || !visualSupport51.v15;
   }
}
