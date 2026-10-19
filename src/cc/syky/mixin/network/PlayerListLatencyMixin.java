package cc.syky.mixin.network;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport259;
import java.util.EnumSet;
import net.minecraft.class_2703;
import net.minecraft.class_634;
import net.minecraft.class_2703.class_5893;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_634.class})
public abstract class PlayerListLatencyMixin {
   public PlayerListLatencyMixin() {
   }

   @Inject(
      method = {"method_11113"},
      at = {@At("TAIL")}
   )
   private void syky$countLatencyBroadcast(class_2703 var1, CallbackInfo var2) {
      EnumSet var3 = var1.method_46327();
      if (var3.contains(class_5893.field_29138) && !var3.contains(class_5893.field_29136)) {
         SykyRuntime var4 = Syky.rootOrNull();
         if (var4 != null) {
            uiSupport259.v1("net.player-list-latency", () -> var4.v4().v20());
         }
      }
   }
}
