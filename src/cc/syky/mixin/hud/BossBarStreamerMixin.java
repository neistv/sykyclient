package cc.syky.mixin.hud;

import cc.syky.ui.uiSupport221;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1259;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1259.class})
public abstract class BossBarStreamerMixin {
   public BossBarStreamerMixin() {
   }

   @Inject(
      method = {"method_5414"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$maskName(CallbackInfoReturnable<class_2561> var1) {
      class_310 var2 = class_310.method_1551();
      if (var2 != null && var2.method_18854()) {
         if (uiSupport223.v2) {
            class_2561 var3 = (class_2561)var1.getReturnValue();
            if (var3 != null) {
               var1.setReturnValue(uiSupport259.v1("bossbar.streamer-mask", () -> {
                  String var1x = uiSupport223.v2();
                  return var1x == null ? var3 : uiSupport221.v1(var3, var1x);
               }, var3));
            }
         }
      }
   }
}
