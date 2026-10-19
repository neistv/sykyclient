package cc.syky.mixin.entity;

import cc.syky.internal.InternalSupport38;
import cc.syky.internal.Support755;
import cc.syky.module.visual.SelfNametag;
import cc.syky.module.visual.visualSupport42;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.class_10042;
import net.minecraft.class_11890;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_4608;
import net.minecraft.class_922;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_922.class})
public abstract class LivingEntityRendererMixin {
   public LivingEntityRendererMixin() {
   }

   @Inject(
      method = {"method_62355"},
      at = {@At("TAIL")}
   )
   private void syky$captureHurtStrength(class_1309 var1, class_10042 var2, float var3, CallbackInfo var4) {
      float var5 = visualSupport42.v3 ? uiSupport259.v1("entity.hurt-strength", () -> visualSupport42.v1(var1), 0.0F) : 0.0F;
      ((Support755)var2).syky$hurtStrength(var5);
   }

   @Inject(
      method = {"method_23622"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$hurtOverlay(class_10042 var0, float var1, CallbackInfoReturnable<Integer> var2) {
      if (visualSupport42.v3) {
         float var3 = ((Support755)var0).syky$hurtStrength();
         if (var3 > 0.0F) {
            var2.setReturnValue(class_4608.method_23625(class_4608.method_23210(var3), class_4608.method_23212(true)));
         }
      }
   }

   @Inject(
      method = {"method_4055"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$selfLabel(class_1309 var1, double var2, CallbackInfoReturnable<Boolean> var4) {
      if (SelfNametag.v2) {
         class_310 var5 = class_310.method_1551();
         if (var5 != null && var1 == var5.field_1724 && var5.field_1690 != null) {
            if (!var5.field_1690.method_31044().method_31034()) {
               var4.setReturnValue(class_310.method_1498() && !var1.method_5756(var5.field_1724) && !var1.method_5782());
            }
         }
      }
   }

   @ModifyReturnValue(
      method = {"method_62463"},
      at = {@At("RETURN")}
   )
   private class_238 syky$cosmeticBounds(class_238 var1, class_1309 var2) {
      if (var2 instanceof class_11890 var3) {
         class_238 var4 = uiSupport259.v1("entity.cosmetic-bounds", () -> InternalSupport38.v1(var3, var1), var1);
         return var4 != null ? var4 : var1;
      } else {
         return var1;
      }
   }
}
