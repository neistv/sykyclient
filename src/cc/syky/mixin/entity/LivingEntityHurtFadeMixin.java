package cc.syky.mixin.entity;

import cc.syky.module.visual.visualSupport41;
import cc.syky.module.visual.visualSupport42;
import net.minecraft.class_1309;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({class_1309.class})
public abstract class LivingEntityHurtFadeMixin implements visualSupport41 {
   @Unique
   @Nullable
   private visualSupport42.Part1 syky$hurtDecay;

   public LivingEntityHurtFadeMixin() {
   }

   @Nullable
   @Override
   public visualSupport42.Part1 syky$hurtDecay() {
      return this.syky$hurtDecay;
   }

   @Override
   public void syky$hurtDecay(@Nullable visualSupport42.Part1 var1) {
      this.syky$hurtDecay = var1;
   }
}
