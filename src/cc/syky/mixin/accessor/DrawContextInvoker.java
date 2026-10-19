package cc.syky.mixin.accessor;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({class_332.class})
public interface DrawContextInvoker {
   @Invoker("method_25295")
   void syky$drawTexturedQuad(
      RenderPipeline var1, class_2960 var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, float var10, int var11
   );
}
