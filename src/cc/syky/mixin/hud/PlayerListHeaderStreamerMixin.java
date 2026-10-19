package cc.syky.mixin.hud;

import cc.syky.ui.uiSupport221;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_2561;
import net.minecraft.class_355;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_355.class})
public abstract class PlayerListHeaderStreamerMixin {
   public PlayerListHeaderStreamerMixin() {
   }

   @ModifyVariable(
      method = {"method_1925"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 1
   )
   @Nullable
   private class_2561 syky$maskHeader(class_2561 var1) {
      return syky$mask(var1);
   }

   @ModifyVariable(
      method = {"method_1924"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 1
   )
   @Nullable
   private class_2561 syky$maskFooter(class_2561 var1) {
      return syky$mask(var1);
   }

   @Nullable
   private static class_2561 syky$mask(class_2561 var0) {
      if (uiSupport223.v2 && var0 != null) {
         String var1 = uiSupport223.v2();
         return var1 == null ? var0 : uiSupport259.v1("tab.streamer-mask", () -> uiSupport221.v1(var0, var1), var0);
      } else {
         return var0;
      }
   }
}
