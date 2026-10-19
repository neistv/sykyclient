package cc.syky.mixin.player;

import cc.syky.render.renderSupport26;
import cc.syky.ui.uiSupport232;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_11689;
import net.minecraft.class_2561;
import net.minecraft.class_327;
import net.minecraft.class_4597;
import net.minecraft.class_327.class_6415;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_11689.class})
public abstract class LabelCommandRendererMixin {
   public LabelCommandRendererMixin() {
   }

   @WrapOperation(
      method = {"method_73014"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_327;method_27522(Lnet/minecraft/class_2561;FFIZLorg/joml/Matrix4f;Lnet/minecraft/class_4597;Lnet/minecraft/class_327$class_6415;II)V"
      )}
   )
   private void syky$paintBadge(
      class_327 var1,
      class_2561 var2,
      float var3,
      float var4,
      int var5,
      boolean var6,
      Matrix4f var7,
      class_4597 var8,
      class_6415 var9,
      int var10,
      int var11,
      Operation<Void> var12
   ) {
      var12.call(new Object[]{var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11});
      uiSupport259.v1("nametag.badge", () -> {
         if (uiSupport232.v1(var2)) {
            renderSupport26.v1(var8, var7, var3, var4, var5, var11, var9 == class_6415.field_33994);
         }
      });
   }
}
