package cc.syky.mixin.screen;

import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport225;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_342;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_342.class})
public abstract class TextFieldWidgetMaskMixin implements uiSupport225 {
   @Unique
   private static final String[] syky$STARS = new String[129];
   @Unique
   private boolean syky$masked;

   public TextFieldWidgetMaskMixin() {
   }

   @Override
   public void syky$maskWhenStreaming() {
      this.syky$masked = true;
   }

   @ModifyExpressionValue(
      method = {"method_48579", "method_74215", "method_52719", "method_71504", "method_1889", "method_25360"},
      at = {@At(
         value = "FIELD",
         target = "Lnet/minecraft/class_342;field_2092:Ljava/lang/String;",
         opcode = 180
      )}
   )
   private String syky$shown(String var1) {
      return this.syky$masked && uiSupport223.v5 ? syky$stars(var1.length()) : var1;
   }

   @Unique
   private static String syky$stars(int var0) {
      if (var0 >= syky$STARS.length) {
         return "*".repeat(var0);
      } else {
         String var1 = syky$STARS[var0];
         if (var1 == null) {
            var1 = "*".repeat(var0);
            syky$STARS[var0] = var1;
         }

         return var1;
      }
   }
}
