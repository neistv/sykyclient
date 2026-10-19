package cc.syky.mixin.world;

import cc.syky.module.visual.TimeChanger;
import cc.syky.module.visual.visualSupport51;
import net.minecraft.class_1937;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1937.class})
public abstract class WorldTimeMixin {
   public WorldTimeMixin() {
   }

   @Inject(
      method = {"method_8532"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$overrideTime(CallbackInfoReturnable<Long> var1) {
      if (this instanceof class_638) {
         float var2 = TimeChanger.v2.v3();
         if (!(var2 <= 0.001F)) {
            long var3 = (Long)var1.getReturnValue();
            long var5 = Math.floorMod(var3, 24000L);
            long var7 = Math.floorMod(visualSupport51.v19, 24000L);
            long var9 = Math.floorMod(var7 - var5, 24000L);
            long var11 = Math.floorMod(var5 + Math.round((double)var9 * var2), 24000L);
            var1.setReturnValue(var3 - var5 + var11);
         }
      }
   }
}
