package cc.syky.mixin.accessor;

import java.util.Map;
import net.minecraft.class_1087;
import net.minecraft.class_2680;
import net.minecraft.class_773;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_773.class})
public interface BlockModelsAccessor {
   @Accessor("field_4162")
   Map<class_2680, class_1087> syky$models();
}
