package cc.syky.mixin.entity;

import cc.syky.module.visual.visualSupport49;
import net.minecraft.class_9946;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_9946.class})
public abstract class EndCrystalEntityModelMixin {
   public EndCrystalEntityModelMixin() {
   }

   @ModifyVariable(
      method = {"method_62083"},
      at = @At("STORE"),
      ordinal = 0
   )
   private float syky$freezeSpin(float var1) {
      return visualSupport49.v2 && visualSupport49.v5 ? 0.0F : var1;
   }
}
