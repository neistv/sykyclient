package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport26;
import java.nio.ByteBuffer;
import net.minecraft.class_2350;
import net.minecraft.class_9955;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_9955.class})
public abstract class CloudRendererShadingMixin {
   @Unique
   private static final int USE_TOP_COLOR = 32;

   public CloudRendererShadingMixin() {
   }

   @ModifyVariable(
      method = {"method_71098"},
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 2
   )
   private int syky$topColourEverywhere(int var1, ByteBuffer var2, int var3, int var4, class_2350 var5) {
      return visualSupport26.v3 ? var1 | 32 : var1;
   }
}
