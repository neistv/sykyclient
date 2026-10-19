package cc.syky.mixin.entity;

import cc.syky.internal.Support720;
import cc.syky.internal.Support721;
import cc.syky.module.visual.ItemPhysic;
import cc.syky.ui.uiSupport171;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_10039;
import net.minecraft.class_1542;
import net.minecraft.class_238;
import net.minecraft.class_4587;
import net.minecraft.class_916;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_916.class})
public abstract class ItemEntityRendererMixin {
   @Unique
   private static final Quaternionf SYKY_POSE = new Quaternionf();

   public ItemEntityRendererMixin() {
   }

   @Inject(
      method = {"method_62470"},
      at = {@At("TAIL")}
   )
   private void syky$samplePose(class_1542 var1, class_10039 var2, float var3, CallbackInfo var4) {
      Support720 var5 = (Support720)var2;
      if (!ItemPhysic.v2) {
         var5.syky$rest(0.0F);
         var5.syky$pitch(0.0F);
         var5.syky$yaw(0.0F);
      } else {
         var5.syky$rest(0.0F);
         var5.syky$pitch(0.0F);
         var5.syky$yaw(class_1542.method_27314(var2.field_53328, var2.field_53435));
         uiSupport259.v1("item.physic-sample", () -> {
            Support721 var3x = (Support721)var1;
            var3x.syky$ensurePose();
            var5.syky$rest(uiSupport171.v3(var3x.syky$restAt(var3)));
            var5.syky$pitch(var3x.syky$pitchAt(var3));
            var5.syky$yaw(var3x.syky$yaw());
         });
      }
   }

   @WrapOperation(
      method = {"method_3996"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4587;method_46416(FFF)V"
      )}
   )
   private void syky$offsetItem(class_4587 var1, float var2, float var3, float var4, Operation<Void> var5, @Local(argsOnly = true) class_10039 var6) {
      if (!ItemPhysic.v2) {
         var5.call(new Object[]{var1, var2, var3, var4});
      } else {
         float var7 = uiSupport259.v1("item.physic-offset", () -> syky$height(var6), var3);
         var5.call(new Object[]{var1, var2, var7, var4});
      }
   }

   @WrapOperation(
      method = {"method_3996"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4587;method_22907(Lorg/joml/Quaternionfc;)V"
      )}
   )
   private void syky$orientItem(class_4587 var1, Quaternionfc var2, Operation<Void> var3, @Local(argsOnly = true) class_10039 var4) {
      if (!ItemPhysic.v2) {
         var3.call(new Object[]{var1, var2});
      } else {
         Quaternionfc var5 = uiSupport259.v1("item.physic-orient", () -> syky$orient(var4), var2);
         var3.call(new Object[]{var1, var5});
      }
   }

   @Unique
   private static float syky$height(class_10039 var0) {
      class_238 var1 = var0.field_55310.method_72173();
      return uiSupport171.v1(
         ((Support720)var0).syky$pitch(),
         (float)var1.field_1322,
         (float)var1.field_1325,
         (float)var1.field_1321,
         (float)var1.field_1324,
         var0.field_55311,
         ((Support720)var0).syky$rest(),
         var0.field_53435
      );
   }

   @Unique
   private static Quaternionfc syky$orient(class_10039 var0) {
      Support720 var1 = (Support720)var0;
      return uiSupport171.v1(SYKY_POSE, var1.syky$yaw(), var1.syky$pitch());
   }
}
