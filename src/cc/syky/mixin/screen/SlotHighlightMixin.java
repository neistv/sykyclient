package cc.syky.mixin.screen;

import cc.syky.module.utilities.utilitiesSupport6;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1703;
import net.minecraft.class_332;
import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_465.class})
public abstract class SlotHighlightMixin {
   @Shadow
   @Final
   public class_1703 field_2797;

   public SlotHighlightMixin() {
   }

   @Inject(
      method = {"method_64508"},
      at = {@At("HEAD")}
   )
   private void syky$highlightSlots(class_332 var1, int var2, int var3, CallbackInfo var4) {
      if (utilitiesSupport6.v1) {
         uiSupport259.v1("gui.slot-highlight", () -> utilitiesSupport6.v1(var1, this.field_2797.field_7761, false));
      }
   }

   @Inject(
      method = {"method_64508"},
      at = {@At("TAIL")}
   )
   private void syky$highlightSlotsOver(class_332 var1, int var2, int var3, CallbackInfo var4) {
      if (utilitiesSupport6.v1) {
         uiSupport259.v1("gui.slot-highlight", () -> utilitiesSupport6.v1(var1, this.field_2797.field_7761, true));
      }
   }
}
