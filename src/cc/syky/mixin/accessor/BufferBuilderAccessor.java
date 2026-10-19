package cc.syky.mixin.accessor;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import net.minecraft.class_287;
import net.minecraft.class_9799;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_287.class})
public interface BufferBuilderAccessor {
   @Accessor("field_52071")
   class_9799 syky$allocator();

   @Accessor("field_1565")
   VertexFormat syky$vertexFormat();

   @Accessor("field_52073")
   class_5596 syky$drawMode();

   @Accessor("field_1556")
   boolean syky$building();

   @Accessor("field_52077")
   int syky$currentMask();

   @Accessor("field_1554")
   int syky$vertexCount();

   @Accessor("field_1554")
   void syky$setVertexCount(int var1);

   @Accessor("field_52072")
   void syky$setVertexPointer(long var1);
}
