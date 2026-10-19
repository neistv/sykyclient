package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport2;
import cc.syky.ui.uiSupport259;
import cc.syky.ui.uiSupport3;
import net.minecraft.class_156;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4011;
import net.minecraft.class_425;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_425.class})
public abstract class SplashOverlayMixin {
   @Shadow
   @Final
   private class_310 field_18217;
   @Shadow
   @Final
   private class_4011 field_17767;
   @Shadow
   @Final
   private boolean field_18219;
   @Shadow
   private float field_17770;
   @Shadow
   private long field_17771;
   @Shadow
   private long field_18220;

   public SplashOverlayMixin() {
   }

   @Inject(
      method = {"method_25394"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$loadingWatermark(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (uiSupport2.v3) {
         long var6 = class_156.method_658();
         if (this.field_18219 && this.field_18220 == -1L) {
            this.field_18220 = var6;
         }

         float var8 = this.field_17771 > -1L ? (float)(var6 - this.field_17771) / 1000.0F : -1.0F;
         float var9 = this.field_18220 > -1L ? (float)(var6 - this.field_18220) / 500.0F : -1.0F;
         float var10 = class_3532.method_15363(this.field_17770 * 0.95F + this.field_17767.method_18229() * 0.050000012F, 0.0F, 1.0F);
         boolean var11 = uiSupport259.v1(
            "gui.loading-watermark", () -> uiSupport3.v1(this.field_18217, var1, var2, var3, var4, this.field_18219, var9, var8, var10), false
         );
         if (var11) {
            this.field_17770 = var10;
            if (var8 >= 2.0F) {
               this.field_18217.method_18502(null);
               class_310 var12 = this.field_18217;
               var12.method_63588(() -> uiSupport259.v1("gui.loading-release", () -> uiSupport3.v1(var12)));
            }

            var5.cancel();
         }
      }
   }
}
