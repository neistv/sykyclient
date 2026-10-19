package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport199;
import cc.syky.ui.uiSupport207;
import cc.syky.ui.uiSupport213;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport233;
import cc.syky.ui.uiSupport259;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_303;
import net.minecraft.class_338;
import net.minecraft.class_303.class_7590;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_338.class})
public abstract class ChatHudMessageMixin {
   @Shadow
   @Final
   private List<class_303> field_2061;
   @Shadow
   @Final
   private List<class_7590> field_2064;

   public ChatHudMessageMixin() {
   }

   @ModifyVariable(
      method = {"method_44811"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 1
   )
   @Nullable
   private class_2561 syky$incoming(class_2561 var1) {
      return var1 != null && (uiSupport223.v2 || uiSupport199.v1 || uiSupport207.v1 || uiSupport213.v2)
         ? uiSupport259.v1("chat.incoming", () -> uiSupport233.v1(var1, this.field_2061, this.field_2064), var1)
         : var1;
   }
}
