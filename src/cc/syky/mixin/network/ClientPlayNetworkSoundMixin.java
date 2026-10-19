package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.module.visual.visualSupport44;
import cc.syky.ui.uiSupport239;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_2767;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class ClientPlayNetworkSoundMixin {
   public ClientPlayNetworkSoundMixin() {
   }

   @Inject(
      method = {"method_11146"},
      at = {@At("TAIL")}
   )
   private void syky$onPlaySound(class_2767 var1, CallbackInfo var2) {
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null) {
         uiSupport259.v1(
            "net.play-sound",
            () -> uiSupport239.v1(var3.v5(), var1.method_11894(), var1.method_11888(), var1.method_11890(), var1.method_11889(), var1.method_11893())
         );
      }
   }

   @WrapOperation(
      method = {"method_11146"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_638;method_8465(Lnet/minecraft/class_1297;DDDLnet/minecraft/class_6880;Lnet/minecraft/class_3419;FFJ)V"
      )}
   )
   private void syky$hideEdgeHitSound(
      class_638 var1,
      class_1297 var2,
      double var3,
      double var5,
      double var7,
      class_6880<class_3414> var9,
      class_3419 var10,
      float var11,
      float var12,
      long var13,
      Operation<Void> var15
   ) {
      if (!uiSupport259.v1("net.edge-hit.sound", () -> visualSupport44.v1(var9, var3, var5, var7), false)) {
         var15.call(new Object[]{var1, var2, var3, var5, var7, var9, var10, var11, var12, var13});
      }
   }
}
