package cc.syky.mixin.screen;

import cc.syky.internal.InternalSupport51;
import cc.syky.mixin.accessor.HandledScreenAccessor;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_332;
import net.minecraft.class_490;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_490.class})
public abstract class InventoryScreenBackgroundMixin {
   public InventoryScreenBackgroundMixin() {
   }

   @Inject(
      method = {"method_2389"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_332;method_25290(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/class_2960;IIFFIIII)V",
         shift = Shift.AFTER
      )}
   )
   private void syky$inventoryBackground(class_332 var1, float var2, int var3, int var4, CallbackInfo var5) {
      if (InternalSupport51.v1) {
         HandledScreenAccessor var6 = (HandledScreenAccessor)this;
         uiSupport259.v1("gui.inventory-background", () -> InternalSupport51.v1(var1, var6.syky$panelLeft(), var6.syky$panelTop()));
      }
   }
}
