package cc.syky.mixin.network;

import cc.syky.module.visual.visualSupport51;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.class_315;
import net.minecraft.class_8791;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_315.class})
public abstract class GameOptionsSyncMixin {
   public GameOptionsSyncMixin() {
   }

   @ModifyReturnValue(
      method = {"method_53842"},
      at = {@At("RETURN")}
   )
   private class_8791 syky$swapMainArm(class_8791 var1) {
      return !visualSupport51.v31
         ? var1
         : new class_8791(
            var1.comp_1951(),
            var1.comp_1952(),
            var1.comp_1953(),
            var1.comp_1954(),
            var1.comp_1955(),
            var1.comp_1956().method_5928(),
            var1.comp_1957(),
            var1.comp_1958(),
            var1.comp_2906()
         );
   }
}
