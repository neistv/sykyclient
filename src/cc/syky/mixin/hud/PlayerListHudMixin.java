package cc.syky.mixin.hud;

import cc.syky.render.renderSupport26;
import cc.syky.ui.uiSupport232;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.UUID;
import net.minecraft.class_2561;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_355;
import net.minecraft.class_640;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_355.class})
public abstract class PlayerListHudMixin {
   public PlayerListHudMixin() {
   }

   @Inject(
      method = {"method_1918"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$decorateName(class_640 var1, CallbackInfoReturnable<class_2561> var2) {
      UUID var3 = var1.method_2966().id();
      String var4 = var1.method_2966().name();
      class_2561 var5 = (class_2561)var2.getReturnValue();
      class_2561 var6 = uiSupport259.v1("tab.decorate-name", () -> uiSupport232.v1(var3, var4, var5), var5);
      if (var6 != var5) {
         var2.setReturnValue(var6);
      }
   }

   @WrapOperation(
      method = {"method_1919"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_332;method_27535(Lnet/minecraft/class_327;Lnet/minecraft/class_2561;III)V"
      )}
   )
   private void syky$paintBadge(class_332 var1, class_327 var2, class_2561 var3, int var4, int var5, int var6, Operation<Void> var7) {
      var7.call(new Object[]{var1, var2, var3, var4, var5, var6});
      uiSupport259.v1("tab.badge", () -> {
         if (uiSupport232.v1(var3)) {
            renderSupport26.v1(var1, var4, var5, var6);
         }
      });
   }
}
