package cc.syky.mixin.item;

import cc.syky.module.visual.CustomShield;
import cc.syky.module.visual.visualSupport40;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.class_10509;
import net.minecraft.class_1058;
import net.minecraft.class_11659;
import net.minecraft.class_12249;
import net.minecraft.class_4587;
import net.minecraft.class_811;
import net.minecraft.class_9323;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin({class_10509.class})
public abstract class ShieldModelRendererMixin {
   public ShieldModelRendererMixin() {
   }

   @WrapMethod(
      method = {"method_65707"}
   )
   private void syky$shieldRender(
      class_9323 var1, class_811 var2, class_4587 var3, class_11659 var4, int var5, int var6, boolean var7, int var8, Operation<Void> var9
   ) {
      try {
         uiSupport259.v1("shield.begin", () -> syky$beginShield(var2, var3));
         var9.call(new Object[]{var1, var2, var3, var4, var5, var6, var7, var8});
      } finally {
         visualSupport40.v14 = false;
      }
   }

   private static void syky$beginShield(class_811 var0, class_4587 var1) {
      visualSupport40.v15 = CustomShield.v2.v3();
      float var2 = visualSupport40.v2();
      if (!visualSupport40.v1() && var2 <= 0.001F) {
         visualSupport40.v14 = false;
      } else {
         visualSupport40.v14 = true;
         boolean var3 = var0.method_29998();
         visualSupport40.v12 = var3;
         if (var3 && var2 > 0.001F && visualSupport40.v5 != 1.0F) {
            float var4 = 1.0F + (visualSupport40.v5 - 1.0F) * var2;
            if (var4 != 1.0F) {
               var1.method_22905(var4, var4, var4);
            }
         }
      }
   }

   @ModifyArgs(
      method = {"method_65707"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11659;method_73494(Lnet/minecraft/class_630;Lnet/minecraft/class_4587;Lnet/minecraft/class_1921;IILnet/minecraft/class_1058;ZZILnet/minecraft/class_11683$class_11792;I)V"
      )
   )
   private void syky$tintShield(Args var1) {
      uiSupport259.v1("shield.tint", () -> {
         int var1x = visualSupport40.v4();
         if (var1x != -1) {
            var1.set(4, var1x);
         }

         int var2 = visualSupport40.v3();
         if (var2 != -1) {
            if (var2 >>> 24 < 255) {
               class_1058 var3 = (class_1058)var1.get(5);
               var1.set(2, class_12249.method_76000(var3.method_45852()));
            }

            var1.set(8, var2);
         }
      });
   }
}
