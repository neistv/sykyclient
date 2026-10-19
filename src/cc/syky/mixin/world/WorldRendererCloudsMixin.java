package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport51;
import cc.syky.ui.uiSupport219;
import net.minecraft.class_243;
import net.minecraft.class_4063;
import net.minecraft.class_761;
import net.minecraft.class_9909;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_761.class})
public abstract class WorldRendererCloudsMixin {
   public WorldRendererCloudsMixin() {
   }

   @Inject(
      method = {"method_62204"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hideClouds(class_9909 var1, class_4063 var2, class_243 var3, long var4, float var6, int var7, float var8, CallbackInfo var9) {
      if (uiSupport219.v4 || visualSupport51.v18) {
         var9.cancel();
      }
   }
}
