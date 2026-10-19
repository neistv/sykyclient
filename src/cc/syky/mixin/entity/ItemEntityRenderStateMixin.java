package cc.syky.mixin.entity;

import cc.syky.internal.Support720;
import net.minecraft.class_10039;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({class_10039.class})
public class ItemEntityRenderStateMixin implements Support720 {
   @Unique
   private float syky$rest;
   @Unique
   private float syky$pitch;
   @Unique
   private float syky$yaw;

   public ItemEntityRenderStateMixin() {
   }

   @Override
   public float syky$rest() {
      return this.syky$rest;
   }

   @Override
   public void syky$rest(float var1) {
      this.syky$rest = var1;
   }

   @Override
   public float syky$pitch() {
      return this.syky$pitch;
   }

   @Override
   public void syky$pitch(float var1) {
      this.syky$pitch = var1;
   }

   @Override
   public float syky$yaw() {
      return this.syky$yaw;
   }

   @Override
   public void syky$yaw(float var1) {
      this.syky$yaw = var1;
   }
}
