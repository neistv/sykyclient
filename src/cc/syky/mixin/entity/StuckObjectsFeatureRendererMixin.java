package cc.syky.mixin.entity;

import cc.syky.module.visual.visualSupport21;
import net.minecraft.class_10055;
import net.minecraft.class_11659;
import net.minecraft.class_4507;
import net.minecraft.class_4587;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_4507.class})
public abstract class StuckObjectsFeatureRendererMixin {
   public StuckObjectsFeatureRendererMixin() {
   }

   @Inject(
      method = {"method_22132"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$noStuckObjects(class_4587 var1, class_11659 var2, int var3, class_10055 var4, float var5, float var6, CallbackInfo var7) {
      if (visualSupport21.v8) {
         var7.cancel();
      }
   }
}
