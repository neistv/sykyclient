package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport26;
import net.minecraft.class_2350;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_638.class})
public abstract class ClientWorldShadingMixin {
   public ClientWorldShadingMixin() {
   }

   @ModifyVariable(
      method = {"method_24852"},
      at = @At("HEAD"),
      argsOnly = true
   )
   private boolean syky$unshadeFaces(boolean var1, class_2350 var2) {
      return var1 && !visualSupport26.v1;
   }
}
