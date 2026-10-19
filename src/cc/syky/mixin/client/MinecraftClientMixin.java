package cc.syky.mixin.client;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.crash.CrashReporter;
import cc.syky.internal.InternalSupport58;
import cc.syky.ui.uiSupport240;
import cc.syky.ui.uiSupport258;
import cc.syky.ui.uiSupport259;
import cc.syky.ui.uiSupport34;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_310.class})
public abstract class MinecraftClientMixin {
   @Unique
   private long syky$frameStartNanos;

   public MinecraftClientMixin() {
   }

   @Inject(
      method = {"method_1574"},
      at = {@At("HEAD")}
   )
   private void syky$preTick(CallbackInfo var1) {
      Syky.heartbeat();
      uiSupport259.v1("crash.watch", CrashReporter::v2);
      SykyRuntime var2 = Syky.rootOrNull();
      if (var2 != null) {
         uiSupport259.v1("client.tick", () -> {
            var2.v21().v1();
            InternalSupport58.v1(var2.v5(), Syky.nextTick());
         });
      }
   }

   @Inject(
      method = {"method_1523"},
      at = {@At("HEAD")}
   )
   private void syky$renderHead(CallbackInfo var1) {
      Syky.heartbeat();
      uiSupport258 var2 = Syky.profilerOrNull();
      this.syky$frameStartNanos = var2 == null ? 0L : var2.v3();
      uiSupport259.v1("client.ui-clock", uiSupport34::v1);
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null) {
         uiSupport259.v1("client.render-frame", () -> {
            var3.v2().v1().v4();
            uiSupport240.v1(var3.v5());
         });
      }
   }

   @Inject(
      method = {"method_1523"},
      at = {@At("RETURN")}
   )
   private void syky$renderReturn(CallbackInfo var1) {
      uiSupport258 var2 = Syky.profilerOrNull();
      if (var2 != null) {
         var2.v1("frame.total", this.syky$frameStartNanos);
      }

      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null) {
         uiSupport259.v1("client.render-gpu", () -> var3.v2().v1().v5());
      }
   }
}
