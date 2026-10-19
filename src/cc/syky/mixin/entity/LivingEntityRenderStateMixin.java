package cc.syky.mixin.entity;

import cc.syky.internal.Support755;
import net.minecraft.class_10042;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({class_10042.class})
public class LivingEntityRenderStateMixin implements Support755 {
   @Unique
   private float syky$hurtStrength;

   public LivingEntityRenderStateMixin() {
   }

   @Override
   public float syky$hurtStrength() {
      return this.syky$hurtStrength;
   }

   @Override
   public void syky$hurtStrength(float var1) {
      this.syky$hurtStrength = var1;
   }
}
