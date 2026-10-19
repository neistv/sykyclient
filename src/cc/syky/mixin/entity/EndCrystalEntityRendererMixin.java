package cc.syky.mixin.entity;

import cc.syky.module.visual.visualSupport49;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_11659;
import net.minecraft.class_12249;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3879;
import net.minecraft.class_4587;
import net.minecraft.class_892;
import net.minecraft.class_11683.class_11792;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_892.class})
public abstract class EndCrystalEntityRendererMixin {
   @Unique
   private static final float SYKY_FROZEN_Y_OFFSET = -1.1F;
   @Shadow
   @Final
   @Nullable
   private static class_2960 field_4663;
   @Unique
   @Nullable
   private static class_1921 syky$translucent;

   public EndCrystalEntityRendererMixin() {
   }

   @WrapOperation(
      method = {"method_3908"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11659;method_73489(Lnet/minecraft/class_3879;Ljava/lang/Object;Lnet/minecraft/class_4587;Lnet/minecraft/class_1921;IIILnet/minecraft/class_11683$class_11792;)V"
      )}
   )
   private void syky$submitCrystal(
      class_11659 var1, class_3879 var2, Object var3, class_4587 var4, class_1921 var5, int var6, int var7, int var8, class_11792 var9, Operation<Void> var10
   ) {
      int var11 = uiSupport259.v1("crystal.tint", visualSupport49::v1, -1);
      if (var11 == -1) {
         var10.call(new Object[]{var1, var2, var3, var4, var5, var6, var7, var8, var9});
      } else {
         var1.method_73490(var2, var3, var4, syky$translucentLayer(), var6, var7, var11, null, var8, var9);
      }
   }

   @Inject(
      method = {"method_23155"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$freezeHeight(float var0, CallbackInfoReturnable<Float> var1) {
      if (uiSupport259.v1("crystal.nobob", () -> visualSupport49.v2 && visualSupport49.v4, false)) {
         var1.setReturnValue(-1.1F);
      }
   }

   @Unique
   private static class_1921 syky$translucentLayer() {
      class_1921 var0 = syky$translucent;
      if (var0 == null) {
         var0 = class_12249.method_76000(field_4663);
         syky$translucent = var0;
      }

      return var0;
   }
}
