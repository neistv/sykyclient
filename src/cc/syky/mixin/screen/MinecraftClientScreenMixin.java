package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport142;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_310.class})
public abstract class MinecraftClientScreenMixin {
   public MinecraftClientScreenMixin() {
   }

   @Inject(
      method = {"method_1507"},
      at = {@At("RETURN")}
   )
   private void syky$keepClickGuiOpen(class_437 var1, CallbackInfo var2) {
      if (uiSupport142.v1 != null) {
         class_310 var3 = (class_310)this;
         uiSupport259.v1("clickgui.reattach", () -> uiSupport142.v4(var3));
      }
   }
}
