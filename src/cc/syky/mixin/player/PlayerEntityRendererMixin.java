package cc.syky.mixin.player;

import cc.syky.ui.uiSupport231;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_11890;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1007.class})
public abstract class PlayerEntityRendererMixin {
   public PlayerEntityRendererMixin() {
   }

   @Inject(
      method = {"method_62604"},
      at = {@At("TAIL")}
   )
   private void syky$updated(class_11890 var1, class_10055 var2, float var3, CallbackInfo var4) {
      uiSupport259.v1("entity.player-state", () -> uiSupport231.v1(var1, var2));
   }
}
