package cc.syky.mixin.network;

import cc.syky.ui.uiSupport218;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkDeathMixin {
   public ClientPlayNetworkDeathMixin() {
   }

   @WrapOperation(
      method = {"method_34075"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_310;method_1507(Lnet/minecraft/class_437;)V"
      )}
   )
   private void syky$onDeathScreen(class_310 var1, class_437 var2, Operation<Void> var3) {
      boolean var4 = uiSupport259.v1("net.auto-respawn", () -> uiSupport218.v1(var1, var2), false);
      if (!var4) {
         var3.call(new Object[]{var1, var2});
      }
   }
}
