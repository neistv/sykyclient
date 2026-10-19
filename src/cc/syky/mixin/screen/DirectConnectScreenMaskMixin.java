package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport225;
import net.minecraft.class_342;
import net.minecraft.class_420;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_420.class})
public abstract class DirectConnectScreenMaskMixin {
   @Shadow
   private class_342 field_2463;

   public DirectConnectScreenMaskMixin() {
   }

   @Inject(
      method = {"method_25426"},
      at = {@At("TAIL")}
   )
   private void syky$maskAddress(CallbackInfo var1) {
      ((uiSupport225)this.field_2463).syky$maskWhenStreaming();
      this.field_2463.method_1872(false);
   }
}
