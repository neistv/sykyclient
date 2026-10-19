package cc.syky.mixin.hud;

import cc.syky.ui.uiSupport223;
import net.minecraft.class_11615;
import net.minecraft.class_11617;
import net.minecraft.class_11621;
import net.minecraft.class_11623;
import net.minecraft.class_11630;
import net.minecraft.class_1937;
import net.minecraft.class_2818;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_11621.class, class_11623.class, class_11615.class, class_11617.class})
public abstract class DebugPositionMixin {
   public DebugPositionMixin() {
   }

   @Inject(
      method = {"method_72751"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hidePosition(class_11630 var1, class_1937 var2, class_2818 var3, class_2818 var4, CallbackInfo var5) {
      if (uiSupport223.v4) {
         var5.cancel();
      }
   }
}
