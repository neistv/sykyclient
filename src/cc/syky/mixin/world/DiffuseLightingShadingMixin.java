package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport26;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_308;
import net.minecraft.class_308.class_11274;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_308.class})
public abstract class DiffuseLightingShadingMixin {
   public DiffuseLightingShadingMixin() {
   }

   @WrapOperation(
      method = {"method_71036"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_308;method_71035(Lnet/minecraft/class_308$class_11274;Lorg/joml/Vector3f;Lorg/joml/Vector3f;)V"
      )}
   )
   private void syky$flagUnshadedEntities(class_308 var1, class_11274 var2, Vector3f var3, Vector3f var4, Operation<Void> var5) {
      if (visualSupport26.v4) {
         float var6 = 2.0F;
         var5.call(new Object[]{var1, var2, new Vector3f(var3).mul(var6), new Vector3f(var4).mul(var6)});
      } else {
         var5.call(new Object[]{var1, var2, var3, var4});
      }
   }
}
