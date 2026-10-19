package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport21;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.class_2398;
import net.minecraft.class_677.class_681;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_681.class})
public abstract class FireworkExplosionFilterMixin {
   public FireworkExplosionFilterMixin() {
   }

   @Inject(
      method = {"method_3030"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$skipFilteredExplosion(
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      IntList var13,
      IntList var14,
      boolean var15,
      boolean var16,
      CallbackInfo var17
   ) {
      if (visualSupport21.v12 && visualSupport21.v13.contains(class_2398.field_11248)) {
         var17.cancel();
      }
   }
}
