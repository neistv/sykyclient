package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport35;
import cc.syky.ui.uiSupport219;
import net.minecraft.class_1163;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1163.class})
public abstract class BiomeColorsMixin {
   public BiomeColorsMixin() {
   }

   @Inject(
      method = {"method_4961"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private static void syky$waterColor(class_1920 var0, class_2338 var1, CallbackInfoReturnable<Integer> var2) {
      if (visualSupport35.v1) {
         var2.setReturnValue(visualSupport35.v2 & 16777215);
      } else if (uiSupport219.v3) {
         var2.setReturnValue(4159204);
      }
   }

   @Inject(
      method = {"method_4962"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$grassColor(class_1920 var0, class_2338 var1, CallbackInfoReturnable<Integer> var2) {
      if (uiSupport219.v3) {
         var2.setReturnValue(9551193);
      }
   }

   @Inject(
      method = {"method_4966"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$foliageColor(class_1920 var0, class_2338 var1, CallbackInfoReturnable<Integer> var2) {
      if (uiSupport219.v3) {
         var2.setReturnValue(7842607);
      }
   }
}
