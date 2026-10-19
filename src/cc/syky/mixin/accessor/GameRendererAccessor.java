package cc.syky.mixin.accessor;

import net.minecraft.class_11279;
import net.minecraft.class_757;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({class_757.class})
public interface GameRendererAccessor {
   @Accessor("field_60106")
   class_11279 syky$handProjection();

   @Invoker("method_3172")
   void syky$renderHand(float var1, boolean var2, Matrix4f var3);
}
