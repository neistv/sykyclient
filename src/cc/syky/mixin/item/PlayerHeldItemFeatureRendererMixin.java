package cc.syky.mixin.item;

import cc.syky.module.visual.visualSupport40;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.class_10055;
import net.minecraft.class_10444;
import net.minecraft.class_11659;
import net.minecraft.class_1306;
import net.minecraft.class_1799;
import net.minecraft.class_1819;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_5697;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({class_5697.class})
public abstract class PlayerHeldItemFeatureRendererMixin {
   public PlayerHeldItemFeatureRendererMixin() {
   }

   @WrapMethod(
      method = {"method_62594"}
   )
   private void syky$scopeShieldTint(
      class_10055 var1, class_10444 var2, class_1799 var3, class_1306 var4, class_4587 var5, class_11659 var6, int var7, Operation<Void> var8
   ) {
      if (!visualSupport40.v1) {
         var8.call(new Object[]{var1, var2, var3, var4, var5, var6, var7});
      } else {
         try {
            uiSupport259.v1("shield.stage-tint", () -> {
               if (var3.method_7909() instanceof class_1819) {
                  class_310 var2x = class_310.method_1551();
                  int var3x = var2x.field_1724 != null ? var2x.field_1724.method_5628() : -1;
                  visualSupport40.v13 = visualSupport40.v1(var1.field_53528, var3x);
               } else {
                  visualSupport40.v13 = -1;
               }
            });
            var8.call(new Object[]{var1, var2, var3, var4, var5, var6, var7});
         } finally {
            visualSupport40.v13 = -1;
         }
      }
   }
}
