package cc.syky.mixin.accessor;

import net.minecraft.class_4341;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_4341.class})
public interface RealmsClientAccessor {
   @Accessor("field_57916")
   static void syky$setInstance(@Nullable class_4341 var0) {
      throw new AssertionError("mixin accessor was not applied");
   }
}
