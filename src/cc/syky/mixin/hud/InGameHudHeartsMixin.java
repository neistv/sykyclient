package cc.syky.mixin.hud;

import cc.syky.module.visual.visualSupport45;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.class_1657;
import net.minecraft.class_2960;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_329.class_6411;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_329.class})
public abstract class InGameHudHeartsMixin {
   public InGameHudHeartsMixin() {
   }

   @Unique
   private static boolean syky$on() {
      return visualSupport45.v1 || visualSupport45.v2;
   }

   @Inject(
      method = {"method_37298"},
      at = {@At("HEAD")}
   )
   private void syky$bakeHearts(CallbackInfo var1) {
      if (syky$on() && (visualSupport45.v3 || visualSupport45.v5)) {
         uiSupport259.v1("hud.hearts-bake", visualSupport45::v1);
      }
   }

   @WrapOperation(
      method = {"method_37298"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_329$class_6411;method_37301(Lnet/minecraft/class_1657;)Lnet/minecraft/class_329$class_6411;"
      )}
   )
   private class_6411 syky$heartType(class_1657 var1, Operation<class_6411> var2) {
      class_6411 var3 = (class_6411)var2.call(new Object[]{var1});
      if (!syky$on()) {
         return var3;
      } else {
         class_6411 var4 = uiSupport259.v1("hud.hearts-type", () -> visualSupport45.v1(var1, var3), var3);
         return var4 == null ? var3 : var4;
      }
   }

   @ModifyVariable(
      method = {"method_37298"},
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 0
   )
   private boolean syky$damageFlash(boolean var1) {
      return var1 && (!syky$on() || visualSupport45.v10);
   }

   @ModifyVariable(
      method = {"method_37298"},
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 3
   )
   private int syky$regenWave(int var1) {
      return syky$on() && !visualSupport45.v12 ? -1 : var1;
   }

   @ModifyExpressionValue(
      method = {"method_37298"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_5819;method_43048(I)I"
      )}
   )
   private int syky$lowHealthShake(int var1) {
      return syky$on() && !visualSupport45.v11 ? 0 : var1;
   }

   @WrapOperation(
      method = {"method_37299"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_332;method_52706(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/class_2960;IIII)V"
      )}
   )
   private void syky$recolourHeart(class_332 var1, RenderPipeline var2, class_2960 var3, int var4, int var5, int var6, int var7, Operation<Void> var8) {
      if (!syky$on()
         || !visualSupport45.v3 && !visualSupport45.v5
         || !uiSupport259.v1("hud.hearts-recolour", () -> visualSupport45.v1(var1, var3, var4, var5, var6, var7), false)) {
         var8.call(new Object[]{var1, var2, var3, var4, var5, var6, var7});
      }
   }
}
