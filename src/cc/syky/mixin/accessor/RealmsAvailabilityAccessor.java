package cc.syky.mixin.accessor;

import java.util.concurrent.CompletableFuture;
import net.minecraft.class_8647;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_8647.class})
public interface RealmsAvailabilityAccessor {
   @Accessor("field_45183")
   static void syky$setCurrentFuture(@Nullable CompletableFuture<?> var0) {
      throw new AssertionError("mixin accessor was not applied");
   }
}
