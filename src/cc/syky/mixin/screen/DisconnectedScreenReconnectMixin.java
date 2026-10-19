package cc.syky.mixin.screen;

import cc.syky.internal.InternalSupport55;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4185;
import net.minecraft.class_419;
import net.minecraft.class_437;
import net.minecraft.class_8667;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_419.class})
public abstract class DisconnectedScreenReconnectMixin extends class_437 {
   @Unique
   private static final int BUTTON_WIDTH = 200;
   @Shadow
   @Final
   private class_437 field_2456;
   @Shadow
   @Final
   private class_8667 field_44552;

   public DisconnectedScreenReconnectMixin(class_2561 var1) {
      super(var1);
   }

   @Inject(
      method = {"method_25426"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_8667;method_48222()V"
      )}
   )
   private void syky$addReconnect(CallbackInfo var1) {
      if (InternalSupport55.v1) {
         uiSupport259.v1(
            "reconnect.button",
            () -> {
               class_310 var1x = this.field_22787;
               if (var1x != null && InternalSupport55.v2()) {
                  class_437 var2 = this.field_2456;
                  this.field_44552
                     .method_52736(
                        class_4185.method_46430(
                              class_2561.method_43470("Reconnect"), var2x -> uiSupport259.v1("reconnect.press", () -> InternalSupport55.v1(var2, var1x))
                           )
                           .method_46432(200)
                           .method_46431()
                     );
               }
            }
         );
      }
   }
}
