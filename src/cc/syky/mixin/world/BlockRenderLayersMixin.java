package cc.syky.mixin.world;

import cc.syky.internal.InternalSupport52;
import net.minecraft.class_11515;
import net.minecraft.class_2246;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_4696;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_4696.class})
public abstract class BlockRenderLayersMixin {
   public BlockRenderLayersMixin() {
   }

   @Inject(
      method = {"method_23679"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$grassOnSolid(class_2680 var0, CallbackInfoReturnable<class_11515> var1) {
      if (InternalSupport52.v1 != null
         && InternalSupport52.v2
         && var0.method_27852(class_2246.field_10219)
         && !(Boolean)var0.method_11654(class_2741.field_12512)) {
         var1.setReturnValue(class_11515.field_60923);
      }
   }
}
