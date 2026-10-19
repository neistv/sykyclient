package cc.syky.mixin.world;

import cc.syky.ui.uiSupport219;
import net.minecraft.class_2338;
import net.minecraft.class_4970.class_4971;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_4971.class})
public abstract class BlockRenderingSeedMixin {
   public BlockRenderingSeedMixin() {
   }

   @Inject(
      method = {"method_26190"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hideRotation(class_2338 var1, CallbackInfoReturnable<Long> var2) {
      if (uiSupport219.v2) {
         var2.setReturnValue(0L);
      }
   }
}
