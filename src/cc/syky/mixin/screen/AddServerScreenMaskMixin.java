package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport225;
import net.minecraft.class_342;
import net.minecraft.class_422;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_422.class})
public abstract class AddServerScreenMaskMixin {
   @Shadow
   private class_342 field_2474;

   public AddServerScreenMaskMixin() {
   }

   @Inject(
      method = {"method_25426"},
      at = {@At("TAIL")}
   )
   private void syky$maskAddress(CallbackInfo var1) {
      ((uiSupport225)this.field_2474).syky$maskWhenStreaming();
      this.field_2474.method_1872(false);
   }
}
