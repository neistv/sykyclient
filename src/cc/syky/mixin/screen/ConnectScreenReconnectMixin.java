package cc.syky.mixin.screen;

import cc.syky.internal.InternalSupport55;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_437;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_9112;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_412.class})
public abstract class ConnectScreenReconnectMixin {
   public ConnectScreenReconnectMixin() {
   }

   @Inject(
      method = {"method_36877"},
      at = {@At("HEAD")}
   )
   private static void syky$remember(class_437 var0, class_310 var1, class_639 var2, class_642 var3, boolean var4, @Nullable class_9112 var5, CallbackInfo var6) {
      uiSupport259.v1("reconnect.remember", () -> InternalSupport55.v1(var2, var3));
   }
}
