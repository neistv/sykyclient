package cc.syky.mixin.accessor;

import net.minecraft.class_2338;
import net.minecraft.class_636;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_636.class})
public interface ClientInteractionBreakAccessor {
   @Accessor("field_3715")
   float syky$breakingProgress();

   @Accessor("field_3714")
   @Nullable
   class_2338 syky$breakingPos();
}
