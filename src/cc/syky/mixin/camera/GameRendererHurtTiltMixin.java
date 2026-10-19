package cc.syky.mixin.camera;

import cc.syky.module.visual.visualSupport21;
import net.minecraft.class_1309;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_757;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_757.class})
public abstract class GameRendererHurtTiltMixin {
   @Shadow
   @Final
   private class_310 field_4015;

   public GameRendererHurtTiltMixin() {
   }

   @Inject(
      method = {"method_3198"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$noHurtTilt(class_4587 var1, float var2, CallbackInfo var3) {
      if (visualSupport21.v3) {
         if (this.field_4015.method_1560() instanceof class_1309 var5 && !var5.method_29504()) {
            var3.cancel();
         }
      }
   }
}
