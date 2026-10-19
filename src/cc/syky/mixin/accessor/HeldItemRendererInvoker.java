package cc.syky.mixin.accessor;

import net.minecraft.class_11659;
import net.minecraft.class_1799;
import net.minecraft.class_4587;
import net.minecraft.class_759;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({class_759.class})
public interface HeldItemRendererInvoker {
   @Invoker("method_3223")
   void syky$renderFirstPersonMap(class_4587 var1, class_11659 var2, int var3, class_1799 var4);
}
