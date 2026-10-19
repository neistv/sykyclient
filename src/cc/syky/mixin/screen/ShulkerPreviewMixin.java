package cc.syky.mixin.screen;

import cc.syky.module.utilities.utilitiesSupport7;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1735;
import net.minecraft.class_332;
import net.minecraft.class_465;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_465.class})
public abstract class ShulkerPreviewMixin {
   @Shadow
   @Nullable
   public class_1735 field_2787;

   public ShulkerPreviewMixin() {
   }

   @Inject(
      method = {"method_71085"},
      at = {@At("TAIL")}
   )
   private void syky$shulkerPreview(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (utilitiesSupport7.v1) {
         class_1735 var6 = this.field_2787;
         if (var6 != null && var6.method_7681()) {
            uiSupport259.v1("gui.shulker-preview", () -> utilitiesSupport7.v1(var1, var6.method_7677(), var2, var3));
         }
      }
   }
}
