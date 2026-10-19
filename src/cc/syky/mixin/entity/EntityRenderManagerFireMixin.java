package cc.syky.mixin.entity;

import cc.syky.module.visual.visualSupport47;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_10017;
import net.minecraft.class_11659;
import net.minecraft.class_4587;
import net.minecraft.class_898;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_898.class})
public abstract class EntityRenderManagerFireMixin {
   public EntityRenderManagerFireMixin() {
   }

   @WrapOperation(
      method = {"method_72976"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11659;method_73488(Lnet/minecraft/class_4587;Lnet/minecraft/class_10017;Lorg/joml/Quaternionf;)V"
      )}
   )
   private void syky$hideEntityFire(class_11659 var1, class_4587 var2, class_10017 var3, Quaternionf var4, Operation<Void> var5) {
      if (!visualSupport47.v9) {
         var5.call(new Object[]{var1, var2, var3, var4});
      }
   }
}
