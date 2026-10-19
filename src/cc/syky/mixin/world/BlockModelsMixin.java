package cc.syky.mixin.world;

import cc.syky.internal.InternalSupport52;
import cc.syky.module.visual.visualSupport61;
import cc.syky.ui.uiSupport219;
import cc.syky.ui.uiSupport234;
import cc.syky.ui.uiSupport259;
import java.util.Map;
import net.minecraft.class_1087;
import net.minecraft.class_2680;
import net.minecraft.class_773;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_773.class})
public abstract class BlockModelsMixin {
   @Shadow
   private Map<class_2680, class_1087> field_4162;

   public BlockModelsMixin() {
   }

   @Inject(
      method = {"method_3335"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$swapModel(class_2680 var1, CallbackInfoReturnable<class_1087> var2) {
      if (uiSupport219.v1 != null || InternalSupport52.v1 != null || visualSupport61.v1 != null) {
         class_1087 var3 = uiSupport259.v1("block.model", () -> uiSupport234.v1(var1, this.field_4162), null);
         if (var3 != null) {
            var2.setReturnValue(var3);
         }
      }
   }
}
