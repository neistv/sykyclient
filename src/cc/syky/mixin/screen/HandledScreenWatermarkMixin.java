package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport2;
import cc.syky.ui.uiSupport259;
import cc.syky.ui.uiSupport4;
import net.minecraft.class_332;
import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_465.class})
public abstract class HandledScreenWatermarkMixin {
   public HandledScreenWatermarkMixin() {
   }

   @Inject(
      method = {"method_25420"},
      at = {@At("TAIL")}
   )
   private void syky$inventoryWatermark(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (uiSupport2.v1) {
         uiSupport259.v1("gui.inventory-watermark", () -> uiSupport4.v1(var1));
      }
   }
}
