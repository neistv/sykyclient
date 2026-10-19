package cc.syky.mixin.item;

import cc.syky.cloud.cloudSupport35;
import net.minecraft.class_11788;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_11788.class})
public abstract class BatchingRenderCommandQueueMixin {
   public BatchingRenderCommandQueueMixin() {
   }

   @Inject(
      method = {"method_73479", "method_73482", "method_73478", "method_73488", "method_73486", "method_73490", "method_73494", "method_73481", "method_73485", "method_73484", "method_73480", "method_73483"},
      at = {@At("HEAD")}
   )
   private void syky$handBlurWatch(CallbackInfo var1) {
      if (cloudSupport35.v1 && cloudSupport35.v3 == 0 && !cloudSupport35.v2) {
         cloudSupport35.v4 = true;
      }
   }
}
