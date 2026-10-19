package cc.syky.mixin.client;

import cc.syky.crash.CrashReporter;
import cc.syky.ui.uiSupport259;
import java.io.File;
import net.minecraft.class_128;
import net.minecraft.class_310;
import net.minecraft.class_9813;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_310.class})
public abstract class MinecraftClientCrashMixin {
   public MinecraftClientCrashMixin() {
   }

   @Inject(
      method = {"method_1565"},
      at = {@At(
         value = "INVOKE",
         target = "Ljava/lang/System;exit(I)V"
      )}
   )
   private static void syky$reportCrash(class_310 var0, File var1, class_128 var2, CallbackInfo var3) {
      uiSupport259.v1("crash.report", () -> CrashReporter.v1(var2.method_60920(class_9813.field_52181), var2.method_564(), var2.method_572()));
   }
}
