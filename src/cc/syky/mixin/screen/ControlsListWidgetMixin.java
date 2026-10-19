package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport259;
import cc.syky.ui.uiSupport9;
import java.util.List;
import net.minecraft.class_310;
import net.minecraft.class_4265;
import net.minecraft.class_459;
import net.minecraft.class_6599;
import net.minecraft.class_459.class_461;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_459.class})
public abstract class ControlsListWidgetMixin extends class_4265<class_461> {
   public ControlsListWidgetMixin() {
      super(null, 0, 0, 0, 0);
   }

   @Inject(
      method = {"<init>"},
      at = {@At("TAIL")}
   )
   private void syky$appendSection(class_6599 var1, class_310 var2, CallbackInfo var3) {
      class_459 var4 = (class_459)this;
      List var5 = List.of();
      List var6 = uiSupport259.v1("keybinds.section", () -> uiSupport9.v1(var4, var1, var2), var5);
      if (var6 != null) {
         for (class_461 var8 : var6) {
            this.method_25321(var8);
         }
      }
   }
}
