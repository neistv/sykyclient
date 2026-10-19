package cc.syky.mixin.interaction;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.ui.uiSupport188;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_310.class})
public abstract class MinecraftClientBlockBreakMixin {
   public MinecraftClientBlockBreakMixin() {
   }

   @ModifyVariable(
      method = {"method_1590"},
      at = @At("HEAD"),
      argsOnly = true
   )
   private boolean syky$holdMining(boolean var1) {
      if (!var1) {
         return false;
      } else {
         SykyRuntime var2 = Syky.rootOrNull();
         if (var2 != null && uiSupport259.v1("area-pick.mining", () -> var2.v13().v1(), false)) {
            return false;
         } else if (!uiSupport188.v1) {
            return true;
         } else {
            class_310 var3 = (class_310)this;
            class_746 var4 = var3.field_1724;
            class_638 var5 = var3.field_1687;
            if (var4 != null && var5 != null) {
               class_239 var6 = var3.field_1765;
               boolean var7 = uiSupport259.v1("durabilityguard.mining", () -> uiSupport188.v2(var4, var6, var5), false);
               return !var7;
            } else {
               return true;
            }
         }
      }
   }
}
