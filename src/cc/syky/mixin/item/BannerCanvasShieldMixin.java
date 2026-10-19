package cc.syky.mixin.item;

import cc.syky.module.visual.visualSupport40;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1058;
import net.minecraft.class_12249;
import net.minecraft.class_823;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin({class_823.class})
public abstract class BannerCanvasShieldMixin {
   public BannerCanvasShieldMixin() {
   }

   @ModifyArgs(
      method = {"method_23802"},
      at = @At(
         value = "INVOKE",
         ordinal = 0,
         target = "Lnet/minecraft/class_11659;method_73490(Lnet/minecraft/class_3879;Ljava/lang/Object;Lnet/minecraft/class_4587;Lnet/minecraft/class_1921;IIILnet/minecraft/class_1058;ILnet/minecraft/class_11683$class_11792;)V"
      )
   )
   private static void syky$tintShieldBase(Args var0) {
      uiSupport259.v1("shield.banner-base", () -> syky$washShieldFace(var0, false));
   }

   @ModifyArgs(
      method = {"method_58140"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11659;method_73490(Lnet/minecraft/class_3879;Ljava/lang/Object;Lnet/minecraft/class_4587;Lnet/minecraft/class_1921;IIILnet/minecraft/class_1058;ILnet/minecraft/class_11683$class_11792;)V"
      )
   )
   private static void syky$tintShieldLayer(Args var0) {
      uiSupport259.v1("shield.banner-layer", () -> syky$washShieldFace(var0, true));
   }

   @Unique
   private static void syky$washShieldFace(Args var0, boolean var1) {
      if (visualSupport40.v1 && visualSupport40.v14) {
         class_1058 var2 = (class_1058)var0.get(7);
         int var3 = visualSupport40.v4();
         if (var3 != -1) {
            var0.set(5, var3);
            if (var1 && var2 != null) {
               var0.set(3, class_12249.method_75996(var2.method_45852()));
            }
         }

         int var4 = visualSupport40.v3();
         if (var4 != -1) {
            int var5 = var4 >>> 24;
            var0.set(6, var5 << 24 | (Integer)var0.get(6) & 16777215);
            if (var5 < 255 && var2 != null) {
               var0.set(3, class_12249.method_76000(var2.method_45852()));
            }
         }
      }
   }
}
