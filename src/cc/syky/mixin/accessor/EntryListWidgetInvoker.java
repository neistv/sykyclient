package cc.syky.mixin.accessor;

import net.minecraft.class_350;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({class_350.class})
public interface EntryListWidgetInvoker {
   @Invoker("method_65507")
   int syky$scrollbarX();
}
