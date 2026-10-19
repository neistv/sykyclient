package cc.syky.mixin.item;

import cc.syky.cloud.cloudSupport35;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1007;
import net.minecraft.class_11659;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1007.class})
public abstract class PlayerEntityRendererHandBlurMixin {
   public PlayerEntityRendererHandBlurMixin() {
   }

   @Inject(
      method = {"method_4220"},
      at = {@At("HEAD")}
   )
   private void syky$handBlurRightArm(class_4587 var1, class_11659 var2, int var3, class_2960 var4, boolean var5, CallbackInfo var6) {
      if (cloudSupport35.v1) {
         this.syky$stage(var1, var2, var3, var4, var5, true);
         uiSupport259.v1("render.handblur.arm", cloudSupport35::v5);
      }
   }

   @Inject(
      method = {"method_4221"},
      at = {@At("HEAD")}
   )
   private void syky$handBlurLeftArm(class_4587 var1, class_11659 var2, int var3, class_2960 var4, boolean var5, CallbackInfo var6) {
      if (cloudSupport35.v1) {
         this.syky$stage(var1, var2, var3, var4, var5, false);
         uiSupport259.v1("render.handblur.arm", cloudSupport35::v5);
      }
   }

   @Inject(
      method = {"method_4220", "method_4221"},
      at = {@At("RETURN")}
   )
   private void syky$handBlurArmDrawn(CallbackInfo var1) {
      if (cloudSupport35.v1 && cloudSupport35.v3 > 0) {
         cloudSupport35.v3--;
      }
   }

   @Unique
   private void syky$stage(class_4587 var1, class_11659 var2, int var3, class_2960 var4, boolean var5, boolean var6) {
      cloudSupport35.v3++;
      cloudSupport35.v14 = this;
      cloudSupport35.v19 = var1;
      cloudSupport35.v17 = var2;
      cloudSupport35.v20 = var3;
      cloudSupport35.v21 = var4;
      cloudSupport35.v22 = var5;
      cloudSupport35.v24 = var6;
   }
}
