package cc.syky.mixin.hud;

import cc.syky.ui.uiSupport221;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_2561;
import net.minecraft.class_329;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_329.class})
public abstract class InGameHudTitleStreamerMixin {
   public InGameHudTitleStreamerMixin() {
   }

   @ModifyVariable(
      method = {"method_34004", "method_34002", "method_1758"},
      at = @At("HEAD"),
      argsOnly = true
   )
   @Nullable
   private class_2561 syky$maskName(@Nullable class_2561 var1) {
      return var1 != null && uiSupport223.v2 ? uiSupport259.v1("hud.title-streamer-mask", () -> {
         String var1x = uiSupport223.v2();
         return var1x == null ? var1 : uiSupport221.v1(var1, var1x);
      }, var1) : var1;
   }
}
