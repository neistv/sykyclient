package cc.syky.mixin.chat;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.module.utilities.utilitiesSupport13;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_408.class})
public abstract class ChatScreenMixin extends class_437 {
   @Shadow
   public class_342 field_2382;

   public ChatScreenMixin() {
      super(null);
   }

   @Inject(
      method = {"method_25426"},
      at = {@At("TAIL")}
   )
   private void syky$initSuggestor(CallbackInfo var1) {
      SykyRuntime var2 = Syky.rootOrNull();
      if (var2 != null) {
         uiSupport259.v1("chat.suggestor-init", () -> var2.v27().v1(this.field_2382));
      }
   }

   @Inject(
      method = {"method_25394"},
      at = {@At("TAIL")}
   )
   private void syky$renderSuggestor(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      SykyRuntime var6 = Syky.rootOrNull();
      if (var6 != null) {
         uiSupport259.v1("chat.suggestor-render", () -> var6.v27().v1(var1));
      }
   }

   @Inject(
      method = {"method_25404"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$keyPressed(class_11908 var1, CallbackInfoReturnable<Boolean> var2) {
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null && uiSupport259.v1("chat.suggestor-key", () -> var3.v27().v1(var1.comp_4795()), false)) {
         var2.setReturnValue(true);
      }
   }

   @Inject(
      method = {"method_25401"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$mouseScrolled(double var1, double var3, double var5, double var7, CallbackInfoReturnable<Boolean> var9) {
      if (uiSupport259.v1("chat.scroll", () -> utilitiesSupport13.v1(var1, var3, var7), false)) {
         var9.setReturnValue(true);
      }
   }

   @ModifyVariable(
      method = {"method_44056"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 1
   )
   private String syky$outgoing(String var1) {
      String var2 = uiSupport259.v1("chat.outgoing", () -> utilitiesSupport13.v1(var1), var1);
      return var2 == null ? var1 : var2;
   }

   @WrapOperation(
      method = {"method_44056"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_634;method_45730(Ljava/lang/String;)V"
      )}
   )
   private void syky$sendCommand(class_634 var1, String var2, Operation<Void> var3) {
      if (!uiSupport259.v1("chat.command", () -> utilitiesSupport13.v1(this.field_22787, var2), false)) {
         var3.call(new Object[]{var1, var2});
      }
   }

   @Inject(
      method = {"method_25402"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$mouseClicked(class_11909 var1, boolean var2, CallbackInfoReturnable<Boolean> var3) {
      if (uiSupport259.v1("chat.click", () -> utilitiesSupport13.v1(var1.method_74245(), var1.comp_4798(), var1.comp_4799()), false)) {
         var3.setReturnValue(true);
      }
   }

   @Inject(
      method = {"method_25402"},
      at = {@At("RETURN")}
   )
   private void syky$mouseClickedReturn(class_11909 var1, boolean var2, CallbackInfoReturnable<Boolean> var3) {
      boolean var4 = var3.getReturnValueZ();
      uiSupport259.v1("chat.click-return", () -> utilitiesSupport13.v1(var4));
   }
}
