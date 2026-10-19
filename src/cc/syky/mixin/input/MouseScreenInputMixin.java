package cc.syky.mixin.input;

import cc.syky.internal.InternalSupport15;
import cc.syky.ui.uiSupport141;
import cc.syky.ui.uiSupport142;
import cc.syky.ui.uiSupport229;
import cc.syky.ui.uiSupport230;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1041;
import net.minecraft.class_11909;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_312.class})
public abstract class MouseScreenInputMixin {
   @Shadow
   @Final
   private class_310 field_1779;

   public MouseScreenInputMixin() {
   }

   @Inject(
      method = {"method_68879"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hidePointerX(class_1041 var1, CallbackInfoReturnable<Double> var2) {
      if (this.syky$pointerHidden()) {
         var2.setReturnValue(-1000000.0);
      }
   }

   @Inject(
      method = {"method_68883"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$hidePointerY(class_1041 var1, CallbackInfoReturnable<Double> var2) {
      if (this.syky$pointerHidden()) {
         var2.setReturnValue(-1000000.0);
      }
   }

   private boolean syky$pointerHidden() {
      return uiSupport142.v1 != null || System.nanoTime() < InternalSupport15.v2;
   }

   @WrapOperation(
      method = {"method_1601"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_25402(Lnet/minecraft/class_11909;Z)Z"
      )}
   )
   private boolean syky$clickToOverlay(class_437 var1, class_11909 var2, boolean var3, Operation<Boolean> var4) {
      boolean var5 = uiSupport142.v1 != null || InternalSupport15.v1 != null;
      class_11909 var6 = var5 ? this.syky$atPointer(var2) : var2;
      if (var2.method_74245() == 2 && uiSupport259.v1("ui.middlescroll.press", () -> uiSupport229.v1(var1, var6), false)) {
         return true;
      } else {
         Boolean var7 = uiSupport259.v1("ui.click.route", () -> uiSupport230.v1(var1, var6, var3), null);
         return var7 != null ? var7 : (Boolean)var4.call(new Object[]{var1, var6, var3});
      }
   }

   @WrapOperation(
      method = {"method_1601"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_25406(Lnet/minecraft/class_11909;)Z"
      )}
   )
   private boolean syky$releaseToOverlay(class_437 var1, class_11909 var2, Operation<Boolean> var3) {
      if (var2.method_74245() == 2 && uiSupport259.v1("ui.middlescroll.release", () -> uiSupport229.v1(this.field_1779), false)) {
         return true;
      } else {
         uiSupport141 var4 = uiSupport142.v1;
         if (var4 == null) {
            if (InternalSupport15.v1 == null) {
               return (Boolean)var3.call(new Object[]{var1, var2});
            } else {
               return uiSupport259.v1("whatsnew.mouseReleased", InternalSupport15::v1, false)
                  ? true
                  : (Boolean)var3.call(new Object[]{var1, this.syky$atPointer(var2)});
            }
         } else {
            class_11909 var5 = this.syky$atPointer(var2);
            return var4 == var1
               ? (Boolean)var3.call(new Object[]{var1, var5})
               : uiSupport259.v1("clickgui.overlay.mouseReleased", () -> var4.method_25406(var5), false);
         }
      }
   }

   @WrapOperation(
      method = {"method_1598"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_25401(DDDD)Z"
      )}
   )
   private boolean syky$scrollToOverlay(class_437 var1, double var2, double var4, double var6, double var8, Operation<Boolean> var10) {
      boolean var11 = uiSupport142.v1 != null || InternalSupport15.v1 != null;
      double var12 = var11 ? this.syky$pointerX(var2) : var2;
      double var14 = var11 ? this.syky$pointerY(var4) : var4;
      Boolean var16 = uiSupport259.v1("ui.scroll.route", () -> uiSupport230.v1(var1, var12, var14, var6, var8), null);
      return var16 != null ? var16 : (Boolean)var10.call(new Object[]{var1, var12, var14, var6, var8});
   }

   @Inject(
      method = {"method_55793"},
      at = {@At("HEAD")}
   )
   private void syky$middleScroll(CallbackInfo var1) {
      if (uiSupport259.v1("ui.middlescroll.holding", uiSupport229::v2, false)) {
         uiSupport259.v1("ui.middlescroll.frame", () -> uiSupport229.v2(this.field_1779));
      }
   }

   @WrapOperation(
      method = {"method_55793"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_16014(DD)V"
      )}
   )
   private void syky$moveToOverlay(class_437 var1, double var2, double var4, Operation<Void> var6) {
      uiSupport141 var7 = uiSupport142.v1;
      if (var7 == null) {
         var6.call(new Object[]{var1, var2, var4});
      } else {
         double var8 = this.syky$pointerX(var2);
         double var10 = this.syky$pointerY(var4);
         if (var7 == var1) {
            var6.call(new Object[]{var1, var8, var10});
         } else {
            uiSupport259.v1("clickgui.overlay.mouseMoved", () -> var7.method_16014(var8, var10));
         }
      }
   }

   @WrapOperation(
      method = {"method_55793"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_437;method_25403(Lnet/minecraft/class_11909;DD)Z"
      )}
   )
   private boolean syky$dragToOverlay(class_437 var1, class_11909 var2, double var3, double var5, Operation<Boolean> var7) {
      if (var2.method_74245() == 2 && uiSupport259.v1("ui.middlescroll.drag", uiSupport229::v2, false)) {
         return true;
      } else {
         uiSupport141 var8 = uiSupport142.v1;
         if (var8 == null) {
            if (InternalSupport15.v1 == null) {
               return (Boolean)var7.call(new Object[]{var1, var2, var3, var5});
            } else {
               return uiSupport259.v1("whatsnew.mouseDragged", () -> InternalSupport15.v1(this.field_1779, var3, var5), false)
                  ? true
                  : (Boolean)var7.call(new Object[]{var1, this.syky$atPointer(var2), var3, var5});
            }
         } else {
            class_11909 var9 = this.syky$atPointer(var2);
            return var8 == var1
               ? (Boolean)var7.call(new Object[]{var1, var9, var3, var5})
               : uiSupport259.v1("clickgui.overlay.mouseDragged", () -> var8.method_25403(var9, var3, var5), false);
         }
      }
   }

   private class_11909 syky$atPointer(class_11909 var1) {
      return new class_11909(this.syky$pointerX(var1.comp_4798()), this.syky$pointerY(var1.comp_4799()), var1.comp_4800());
   }

   private double syky$pointerX(double var1) {
      return uiSupport259.v1("clickgui.pointer", () -> uiSupport142.v1(this.field_1779), var1);
   }

   private double syky$pointerY(double var1) {
      return uiSupport259.v1("clickgui.pointer", () -> uiSupport142.v2(this.field_1779), var1);
   }
}
