package cc.syky.mixin.gpu;

import cc.syky.mixin.accessor.AtlasLoaderAccessor;
import cc.syky.module.visual.visualSupport60;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_10725;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_7947;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_7947.class})
public abstract class AtlasLoaderMixin {
   public AtlasLoaderMixin() {
   }

   @Inject(
      method = {"method_47668"},
      at = {@At("RETURN")}
   )
   private static void syky$addLeafTufts(class_3300 var0, class_2960 var1, CallbackInfoReturnable<class_7947> var2) {
      if (class_10725.field_56382.equals(var1)) {
         uiSupport259.v1("texture.leaf-tufts", () -> ((AtlasLoaderAccessor)var2.getReturnValue()).syky$sources().add(visualSupport60.v1));
      }
   }
}
