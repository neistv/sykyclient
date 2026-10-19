package cc.syky.mixin.accessor;

import net.minecraft.class_1297;
import net.minecraft.class_7422;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_1297.class})
public interface EntityTrackedPositionAccessor {
   @Accessor("field_38931")
   class_7422 syky$trackedPosition();
}
