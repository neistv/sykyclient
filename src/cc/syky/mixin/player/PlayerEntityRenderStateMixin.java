package cc.syky.mixin.player;

import cc.syky.cloud.cloudSupport44;
import cc.syky.internal.InternalSupport39;
import cc.syky.ui.uiSupport167;
import net.minecraft.class_10055;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({class_10055.class})
public class PlayerEntityRenderStateMixin implements InternalSupport39 {
   @Unique
   @Nullable
   private uiSupport167 syky$wearer;
   @Unique
   private cloudSupport44 syky$motion = cloudSupport44.IDLE;

   public PlayerEntityRenderStateMixin() {
   }

   @Nullable
   @Override
   public uiSupport167 syky$wearer() {
      return this.syky$wearer;
   }

   @Override
   public void syky$wearer(@Nullable uiSupport167 var1) {
      this.syky$wearer = var1;
   }

   @Override
   public cloudSupport44 syky$motion() {
      return this.syky$motion;
   }

   @Override
   public void syky$motion(cloudSupport44 var1) {
      this.syky$motion = var1;
   }
}
