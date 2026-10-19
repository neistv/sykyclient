package cc.syky.mixin.world;

import cc.syky.ui.uiSupport180;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1944;
import net.minecraft.class_4076;
import net.minecraft.class_631;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_631.class})
public abstract class ClientChunkManagerLightMixin {
   public ClientChunkManagerLightMixin() {
   }

   @Inject(
      method = {"method_12247"},
      at = {@At("HEAD")}
   )
   private void syky$lightChanged(class_1944 var1, class_4076 var2, CallbackInfo var3) {
      if (uiSupport180.v1) {
         uiSupport259.v1("lightoverlay.light", () -> uiSupport180.v1(var2));
      }
   }
}
