package cc.syky.mixin.accessor;

import java.util.List;
import net.minecraft.class_7947;
import net.minecraft.class_7948;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_7947.class})
public interface AtlasLoaderAccessor {
   @Accessor("field_41388")
   List<class_7948> syky$sources();
}
