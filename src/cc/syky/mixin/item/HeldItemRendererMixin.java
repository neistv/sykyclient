package cc.syky.mixin.item;

import cc.syky.account.accountSupport12;
import cc.syky.cloud.cloudSupport35;
import cc.syky.module.visual.ViewModel;
import cc.syky.module.visual.visualSupport40;
import cc.syky.module.visual.visualSupport51;
import cc.syky.module.visual.visualSupport63;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_10444;
import net.minecraft.class_11659;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1819;
import net.minecraft.class_4587;
import net.minecraft.class_742;
import net.minecraft.class_759;
import net.minecraft.class_811;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_759.class})
public abstract class HeldItemRendererMixin {
   @Unique
   @Nullable
   private static class_1799 syky$phantomShield;

   public HeldItemRendererMixin() {
   }

   @Inject(
      method = {"method_3228"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4587;method_22903()V",
         shift = Shift.AFTER,
         ordinal = 0
      )}
   )
   private void syky$applyEyeSpace(
      class_742 var1,
      float var2,
      float var3,
      class_1268 var4,
      float var5,
      class_1799 var6,
      float var7,
      class_4587 var8,
      class_11659 var9,
      int var10,
      CallbackInfo var11
   ) {
      uiSupport259.v1("helditem.eyespace", () -> visualSupport63.v1(var4, var6, var8));
   }

   @Inject(
      method = {"method_3228"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_759;method_3233(Lnet/minecraft/class_1309;Lnet/minecraft/class_1799;Lnet/minecraft/class_811;Lnet/minecraft/class_4587;Lnet/minecraft/class_11659;I)V"
      )}
   )
   private void syky$scaleViewmodel(
      class_742 var1,
      float var2,
      float var3,
      class_1268 var4,
      float var5,
      class_1799 var6,
      float var7,
      class_4587 var8,
      class_11659 var9,
      int var10,
      CallbackInfo var11
   ) {
      uiSupport259.v1("helditem.scale", () -> {
         float var2x = ViewModel.v2.v2();
         if (!(var2x <= 0.001F)) {
            boolean var3x = var4 == class_1268.field_5808;
            float var4x = 1.0F + ((var3x ? visualSupport51.v26 : visualSupport51.v33) - 1.0F) * var2x;
            if (var4x != 1.0F) {
               var8.method_22905(var4x, var4x, var4x);
            }

            visualSupport63.v1(var4, var8, var4x);
         }
      });
   }

   @Inject(
      method = {"method_3233"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_10444;method_65604(Lnet/minecraft/class_4587;Lnet/minecraft/class_11659;III)V"
      )}
   )
   private void syky$captureItemModel(
      class_1309 var1, class_1799 var2, class_811 var3, class_4587 var4, class_11659 var5, int var6, CallbackInfo var7, @Local class_10444 var8
   ) {
      uiSupport259.v1("helditem.model", () -> accountSupport12.v1(var8));
   }

   @ModifyVariable(
      method = {"method_3228"},
      at = @At("HEAD"),
      argsOnly = true
   )
   @Nullable
   private class_1799 syky$phantomShieldPreview(class_1799 var1, @Local(argsOnly = true) class_742 var2, @Local(argsOnly = true) class_1268 var3) {
      return uiSupport259.v1(
         "helditem.shield-preview",
         () -> {
            if (var3 == class_1268.field_5810
               && var1.method_7960()
               && visualSupport40.v2
               && !(var2.method_6047().method_7909() instanceof class_1819)
               && !(var2.method_6079().method_7909() instanceof class_1819)) {
               if (syky$phantomShield == null) {
                  syky$phantomShield = new class_1799(class_1802.field_8255);
               }

               return syky$phantomShield;
            } else {
               return var1;
            }
         },
         var1
      );
   }

   @Inject(
      method = {"method_3233"},
      at = {@At("HEAD")}
   )
   private void syky$handBlurItem(class_1309 var1, class_1799 var2, class_811 var3, class_4587 var4, class_11659 var5, int var6, CallbackInfo var7) {
      if (cloudSupport35.v1) {
         cloudSupport35.v3++;
         cloudSupport35.v14 = this;
         cloudSupport35.v15 = var1;
         cloudSupport35.v16 = var2;
         cloudSupport35.v18 = var3;
         cloudSupport35.v19 = var4;
         cloudSupport35.v17 = var5;
         cloudSupport35.v20 = var6;
         uiSupport259.v1("helditem.handblur.item", cloudSupport35::v4);
      }
   }

   @Inject(
      method = {"method_3223"},
      at = {@At("HEAD")}
   )
   private void syky$handBlurMap(class_4587 var1, class_11659 var2, int var3, class_1799 var4, CallbackInfo var5) {
      if (cloudSupport35.v1) {
         cloudSupport35.v3++;
         cloudSupport35.v14 = this;
         cloudSupport35.v16 = var4;
         cloudSupport35.v19 = var1;
         cloudSupport35.v17 = var2;
         cloudSupport35.v20 = var3;
         uiSupport259.v1("helditem.handblur.map", cloudSupport35::v6);
      }
   }

   @Inject(
      method = {"method_3233", "method_3223"},
      at = {@At("RETURN")}
   )
   private void syky$handBlurDrawn(CallbackInfo var1) {
      if (cloudSupport35.v1 && cloudSupport35.v3 > 0) {
         cloudSupport35.v3--;
      }
   }
}
