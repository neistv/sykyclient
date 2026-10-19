package cc.syky.mixin.network;

import cc.syky.module.visual.visualSupport44;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_2394;
import net.minecraft.class_634;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkParticleMixin {
   public ClientPlayNetworkParticleMixin() {
   }

   @WrapOperation(
      method = {"method_11077"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_638;method_8466(Lnet/minecraft/class_2394;ZZDDDDDD)V"
      )}
   )
   private void syky$hideEdgeHitParticle(
      class_638 var1,
      class_2394 var2,
      boolean var3,
      boolean var4,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      Operation<Void> var17
   ) {
      if (!uiSupport259.v1("net.edge-hit.particle", () -> visualSupport44.v1(var2, var5, var7, var9), false)) {
         var17.call(new Object[]{var1, var2, var3, var4, var5, var7, var9, var11, var13, var15});
      }
   }
}
