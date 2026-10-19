package cc.syky.mixin.accessor;

import net.minecraft.class_10444;
import net.minecraft.class_811;
import net.minecraft.class_10444.class_10446;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_10444.class})
public interface ItemRenderStateAccessor {
   @Accessor("field_55340")
   class_10446[] syky$layers();

   @Accessor("field_55339")
   int syky$layerCount();

   @Accessor("field_55337")
   class_811 syky$displayContext();
}
