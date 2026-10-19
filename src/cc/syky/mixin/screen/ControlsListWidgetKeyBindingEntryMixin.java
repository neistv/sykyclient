package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport259;
import cc.syky.ui.uiSupport9;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_4185;
import net.minecraft.class_6599;
import net.minecraft.class_7919;
import net.minecraft.class_459.class_462;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_462.class})
public abstract class ControlsListWidgetKeyBindingEntryMixin {
   @Shadow
   @Final
   private class_304 field_2740;
   @Shadow
   @Final
   private class_4185 field_2739;
   @Shadow
   private boolean field_42497;

   public ControlsListWidgetKeyBindingEntryMixin() {
   }

   @Inject(
      method = {"method_48269"},
      at = {@At("TAIL")}
   )
   private void syky$markSykyClash(CallbackInfo var1) {
      if (!this.field_42497 && !this.field_2740.method_1415()) {
         class_304 var2 = this.field_2740;
         class_2561 var3 = uiSupport259.v1("keybinds.vanilla-clash", () -> uiSupport9.v1(var2), null);
         if (var3 != null) {
            this.field_42497 = true;
            class_310 var4 = class_310.method_1551();
            if (!(var4.field_1755 instanceof class_6599 var5 && var5.field_34799 == this.field_2740)) {
               this.field_2739
                  .method_25355(
                     class_2561.method_43470("[ ")
                        .method_10852(this.field_2739.method_25369().method_27661().method_27692(class_124.field_1068))
                        .method_27693(" ]")
                        .method_27692(class_124.field_1054)
                  );
               this.field_2739.method_47400(class_7919.method_47407(class_2561.method_43469("controls.keybinds.duplicateKeybinds", new Object[]{var3})));
            }
         }
      }
   }
}
