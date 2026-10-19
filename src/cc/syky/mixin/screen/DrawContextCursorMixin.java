package cc.syky.mixin.screen;

import cc.syky.hud.hudSupport56;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1041;
import net.minecraft.class_11875;
import net.minecraft.class_332;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_332.class})
public abstract class DrawContextCursorMixin {
   @Shadow
   @Nullable
   private class_11875 field_62463;

   public DrawContextCursorMixin() {
   }

   @Inject(
      method = {"method_74036"},
      at = {@At("HEAD")}
   )
   private void syky$applyCursor(class_1041 var1, CallbackInfo var2) {
      class_11875 var3 = uiSupport259.v1("gui.cursor", hudSupport56.v1, null);
      if (var3 != null) {
         this.field_62463 = var3;
      }
   }
}
