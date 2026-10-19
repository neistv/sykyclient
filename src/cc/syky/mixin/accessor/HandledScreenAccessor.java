package cc.syky.mixin.accessor;

import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_465.class})
public interface HandledScreenAccessor {
   @Accessor("field_2800")
   int syky$panelTop();

   @Accessor("field_2776")
   int syky$panelLeft();
}
