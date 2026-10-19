package cc.syky.mixin.screen;

import cc.syky.internal.InternalSupport55;
import cc.syky.module.utilities.PvPModeSupport;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4185;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_7845.class_7939;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_433.class})
public abstract class GameMenuScreenReconnectMixin extends class_437 {
   @Unique
   private static final int BUTTON_WIDTH = 204;
   @Unique
   private static final int GRID_COLUMNS = 2;

   public GameMenuScreenReconnectMixin(class_2561 var1) {
      super(var1);
   }

   @Inject(
      method = {"method_20543"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_7845;method_48222()V"
      )}
   )
   private void syky$addReconnect(CallbackInfo var1, @Local class_7939 var2) {
      if (InternalSupport55.v2) {
         uiSupport259.v1("reconnect.pause", () -> {
            class_310 var2x = this.field_22787;
            if (var2x != null && InternalSupport55.v1(var2x)) {
               Runnable var3 = () -> uiSupport259.v1("reconnect.pause.rejoin", () -> InternalSupport55.v2(var2x));
               var2.method_47613(class_4185.method_46430(class_2561.method_43470("Reconnect"), var3x -> {
                  if (!uiSupport259.v1("pvpleave.reconnect", () -> PvPModeSupport.v1(var2x, this, var3), false)) {
                     var3.run();
                  }
               }).method_46432(204).method_46431(), 2);
            }
         });
      }
   }
}
