package cc.syky.mixin.accessor;

import net.minecraft.class_1041;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({class_1041.class})
public interface WindowInvoker {
   @Invoker("method_4479")
   void syky$updateWindowRegion();
}
