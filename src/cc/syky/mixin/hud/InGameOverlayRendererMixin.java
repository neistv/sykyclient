package cc.syky.mixin.hud;

import cc.syky.module.visual.visualSupport35;
import cc.syky.module.visual.visualSupport36;
import cc.syky.module.visual.visualSupport47;
import cc.syky.render.renderSupport47;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1058;
import net.minecraft.class_1088;
import net.minecraft.class_11659;
import net.minecraft.class_11701;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4603;
import net.minecraft.class_5819;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_4603.class})
public abstract class InGameOverlayRendererMixin {
   @Shadow
   @Final
   @Nullable
   private class_310 field_59970;
   @Shadow
   @Final
   @Nullable
   private class_11701 field_61744;
   @Shadow
   @Final
   @Nullable
   private class_4597 field_59971;
   @Unique
   @Nullable
   private class_4587 syky$fireMatrices;

   public InGameOverlayRendererMixin() {
   }

   @Inject(
      method = {"method_23067"},
      at = {@At("HEAD")}
   )
   private void syky$fireAdvance(boolean var1, float var2, class_11659 var3, CallbackInfo var4) {
      if (visualSupport47.v1 || visualSupport47.v2 || visualSupport47.v1() > 0.0F) {
         boolean var5 = this.onFireNow(var1) || visualSupport47.v2 && this.overlayVisible(var1);
         uiSupport259.v1("overlay.fire-advance", () -> visualSupport47.v1(var5));
      }
   }

   @Inject(
      method = {"method_23067"},
      at = {@At("HEAD")}
   )
   private void syky$totemPreview(boolean var1, float var2, class_11659 var3, CallbackInfo var4) {
      uiSupport259.v1("overlay.totem-preview", visualSupport36::v3);
   }

   @Inject(
      method = {"method_23070"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$suppressVanillaFire(class_4587 var0, class_4597 var1, class_1058 var2, CallbackInfo var3) {
      if (visualSupport47.v1 || visualSupport47.v2) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_23069"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$hideWaterOverlay(class_310 var0, class_4587 var1, class_4597 var2, CallbackInfo var3) {
      if (visualSupport35.v1 && visualSupport35.v3) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_23067"},
      at = {@At("RETURN")}
   )
   private void syky$fireDraw(boolean var1, float var2, class_11659 var3, CallbackInfo var4) {
      if ((visualSupport47.v1 || visualSupport47.v2) && !(visualSupport47.v1() <= 0.0F) && this.overlayVisible(var1)) {
         class_1058 var5 = renderSupport47.v1(this.field_61744).method_73030(class_1088.field_5370);
         if (this.syky$fireMatrices == null) {
            this.syky$fireMatrices = new class_4587();
         }

         this.syky$fireMatrices.method_34426();
         uiSupport259.v1(
            "overlay.fire-render",
            () -> visualSupport47.v1(renderSupport47.v1(this.syky$fireMatrices), renderSupport47.v1(this.field_59971), var5, visualSupport47.v1())
         );
      }
   }

   @WrapOperation(
      method = {"method_70939"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4587;method_22905(FFF)V"
      )}
   )
   private void syky$totemScale(class_4587 var1, float var2, float var3, float var4, Operation<Void> var5) {
      float var6 = uiSupport259.v1("overlay.totem-scale", visualSupport36::v4, 1.0F);
      var5.call(new Object[]{var1, var2 * var6, var3 * var6, var4 * var6});
   }

   @WrapOperation(
      method = {"method_70939"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4587;method_46416(FFF)V"
      )}
   )
   private void syky$totemTranslate(class_4587 var1, float var2, float var3, float var4, Operation<Void> var5) {
      float var6 = uiSupport259.v1("overlay.totem-offset", () -> visualSupport36.v1(var4), 0.0F);
      var5.call(new Object[]{var1, var2, var3 + var6, var4});
   }

   @Inject(
      method = {"method_70938"},
      at = {@At("HEAD")}
   )
   private void syky$totemPop(class_1799 var1, class_5819 var2, CallbackInfo var3) {
      uiSupport259.v1("overlay.totem-pop", visualSupport36::v1);
   }

   private boolean overlayVisible(boolean var1) {
      class_746 var2 = renderSupport47.v1(this.field_59970).field_1724;
      return var2 != null && !var1 && renderSupport47.v1(this.field_59970).field_1690.method_31044().method_31034() && !var2.method_7325();
   }

   private boolean onFireNow(boolean var1) {
      class_746 var2 = renderSupport47.v1(this.field_59970).field_1724;
      return this.overlayVisible(var1) && var2.method_5809() ? !visualSupport47.v8 || !fireIsHarmless(var2) : false;
   }

   private static boolean fireIsHarmless(class_1657 var0) {
      return var0.method_31549().field_7480 || var0.method_6059(class_1294.field_5918);
   }
}
