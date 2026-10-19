package cc.syky.mixin.entity;

import cc.syky.module.visual.visualSupport21;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.List;
import net.minecraft.class_11659;
import net.minecraft.class_4587;
import net.minecraft.class_898;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_898.class})
public abstract class EntityRenderManagerShadowMixin {
   public EntityRenderManagerShadowMixin() {
   }

   @WrapOperation(
      method = {"method_72976"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11659;method_73479(Lnet/minecraft/class_4587;FLjava/util/List;)V"
      )}
   )
   private void syky$noEntityShadow(class_11659 var1, class_4587 var2, float var3, List<?> var4, Operation<Void> var5) {
      if (!visualSupport21.v7) {
         var5.call(new Object[]{var1, var2, var3, var4});
      }
   }
}
