package cc.syky.mixin.entity;

import cc.syky.internal.Support755;
import cc.syky.module.visual.visualSupport42;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_10197;
import net.minecraft.class_12249;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4608;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_10197.class})
public abstract class EquipmentRendererMixin {
   public EquipmentRendererMixin() {
   }

   @WrapOperation(
      method = {"method_64078"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_12249;method_75966(Lnet/minecraft/class_2960;)Lnet/minecraft/class_1921;"
      )}
   )
   private class_1921 syky$tintArmorLayer(class_2960 var1, Operation<class_1921> var2, @Local(argsOnly = true,ordinal = 0) Object var3) {
      return syky$hurtArmor(var3) > 0.0F ? class_12249.method_75996(var1) : (class_1921)var2.call(new Object[]{var1});
   }

   @WrapOperation(
      method = {"method_64078"},
      at = {@At(
         value = "FIELD",
         target = "Lnet/minecraft/class_4608;field_21444:I",
         opcode = 178
      )}
   )
   private int syky$tintArmorOverlay(Operation<Integer> var1, @Local(argsOnly = true,ordinal = 0) Object var2) {
      float var3 = syky$hurtArmor(var2);
      return var3 > 0.0F ? class_4608.method_23625(class_4608.method_23210(var3), class_4608.method_23212(true)) : (Integer)var1.call(new Object[0]);
   }

   @Unique
   private static float syky$hurtArmor(Object var0) {
      return visualSupport42.v3 && visualSupport42.v6 && var0 instanceof Support755 var1 ? var1.syky$hurtStrength() : 0.0F;
   }
}
