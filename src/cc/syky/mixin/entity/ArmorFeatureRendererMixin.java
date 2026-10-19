package cc.syky.mixin.entity;

import cc.syky.module.visual.HideArmor;
import net.minecraft.class_10034;
import net.minecraft.class_11659;
import net.minecraft.class_4587;
import net.minecraft.class_970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_970.class})
public abstract class ArmorFeatureRendererMixin {
   public ArmorFeatureRendererMixin() {
   }

   @Inject(
      method = {"method_17157"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hideArmor(class_4587 var1, class_11659 var2, int var3, class_10034 var4, float var5, float var6, CallbackInfo var7) {
      if (HideArmor.v2) {
         var7.cancel();
      }
   }
}
