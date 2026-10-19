package cc.syky.mixin.player;

import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport259;
import java.util.UUID;
import net.minecraft.class_1068;
import net.minecraft.class_640;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_640.class})
public abstract class PlayerListEntrySkinMixin {
   public PlayerListEntrySkinMixin() {
   }

   @Inject(
      method = {"method_52810"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$maskSelfSkin(CallbackInfoReturnable<class_8685> var1) {
      class_640 var2 = (class_640)this;
      UUID var3 = var2.method_2966().id();
      if (uiSupport259.v1("tab.streamer-skin", () -> uiSupport223.v2(var3), false)) {
         var1.setReturnValue(class_1068.method_4648(var3));
      }
   }
}
