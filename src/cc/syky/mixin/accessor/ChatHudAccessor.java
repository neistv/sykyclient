package cc.syky.mixin.accessor;

import java.util.List;
import net.minecraft.class_303;
import net.minecraft.class_338;
import net.minecraft.class_303.class_7590;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_338.class})
public interface ChatHudAccessor {
   @Accessor("field_2061")
   List<class_303> syky$messages();

   @Accessor("field_2064")
   List<class_7590> syky$visibleMessages();
}
