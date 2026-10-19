package cc.syky.mixin.accessor;

import java.util.function.Supplier;
import net.minecraft.class_804;
import net.minecraft.class_10444.class_10446;
import org.joml.Vector3fc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_10446.class})
public interface ItemLayerRenderStateAccessor {
   @Accessor("field_56967")
   class_804 syky$transform();

   @Accessor("field_56968")
   Supplier<Vector3fc[]> syky$vertices();
}
