package cc.syky.mixin.accessor;

import net.minecraft.class_11279;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_11279.class})
public interface ProjectionMatrix3Accessor {
   @Accessor("field_60070")
   int syky$width();

   @Accessor("field_60071")
   int syky$height();

   @Accessor("field_60072")
   float syky$fov();
}
