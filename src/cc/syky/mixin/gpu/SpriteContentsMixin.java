package cc.syky.mixin.gpu;

import cc.syky.module.visual.visualSupport48;
import cc.syky.ui.uiSupport259;
import java.util.List;
import java.util.Optional;
import net.minecraft.class_1011;
import net.minecraft.class_1079;
import net.minecraft.class_1084;
import net.minecraft.class_2960;
import net.minecraft.class_7764;
import net.minecraft.class_7771;
import net.minecraft.class_7677.class_11554;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_7764.class})
public abstract class SpriteContentsMixin {
   public SpriteContentsMixin() {
   }

   @Inject(
      method = {"<init>(Lnet/minecraft/class_2960;Lnet/minecraft/class_7771;Lnet/minecraft/class_1011;Ljava/util/Optional;Ljava/util/List;Ljava/util/Optional;)V"},
      at = {@At("RETURN")}
   )
   private void syky$recolourFire(
      class_2960 var1, class_7771 var2, class_1011 var3, Optional<class_1079> var4, List<class_11554<?>> var5, Optional<class_1084> var6, CallbackInfo var7
   ) {
      uiSupport259.v1("texture.fire-recolour", () -> visualSupport48.v1(var1, var3));
   }
}
