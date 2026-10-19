package cc.syky.mixin.screen;

import cc.syky.module.utilities.PvPModeSupport;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_310;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_7574;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_433.class})
public abstract class GameMenuScreenLeaveConfirmMixin {
   public GameMenuScreenLeaveConfirmMixin() {
   }

   @WrapOperation(
      method = {"method_19836"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_7574;method_46552(Lnet/minecraft/class_310;Lnet/minecraft/class_437;Ljava/lang/Runnable;Z)V"
      )}
   )
   private void syky$confirmLeave(class_7574 var1, class_310 var2, class_437 var3, Runnable var4, boolean var5, Operation<Void> var6) {
      Runnable var7 = () -> var6.call(new Object[]{var1, var2, var3, var4, var5});
      boolean var8 = PvPModeSupport.v1 && uiSupport259.v1("pvpleave.disconnect", () -> PvPModeSupport.v1(var2, var3, var7), false);
      if (!var8) {
         var7.run();
      }
   }
}
