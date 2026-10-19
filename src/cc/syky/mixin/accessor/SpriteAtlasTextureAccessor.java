package cc.syky.mixin.accessor;

import net.minecraft.class_1059;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_1059.class})
public interface SpriteAtlasTextureAccessor {
   @Accessor("field_64244")
   int syky$mipLevel();
}
