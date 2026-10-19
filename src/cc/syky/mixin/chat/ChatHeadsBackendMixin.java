package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport213;
import cc.syky.ui.uiSupport214;
import net.minecraft.class_11735;
import net.minecraft.class_5481;
import net.minecraft.class_12225.class_12227;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(
   targets = {"net/minecraft/class_338$class_12333", "net/minecraft/class_338$class_12235"}
)
public abstract class ChatHeadsBackendMixin {
   public ChatHeadsBackendMixin() {
   }

   @ModifyArg(
      method = {"method_75807"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_12225;method_75766(Lnet/minecraft/class_11735;IILnet/minecraft/class_12225$class_12227;Lnet/minecraft/class_5481;)V"
      ),
      index = 1
   )
   private int syky$queueHead(class_11735 var1, int var2, int var3, class_12227 var4, class_5481 var5) {
      uiSupport214[] var6 = uiSupport213.v5;
      int[] var7 = uiSupport213.v6;
      if (uiSupport213.v2 && var6 != null && var7 != null && var5 == uiSupport213.v4) {
         float var8 = var4.comp_5152();
         int var9 = uiSupport213.v12;

         for (int var10 = 0; var10 < var6.length && var10 < var7.length && var9 < 256; var9++) {
            uiSupport213.v8[var9] = var6[var10];
            uiSupport213.v9[var9] = var2 + var7[var10];
            uiSupport213.v10[var9] = var3;
            uiSupport213.v11[var9] = var8;
            var10++;
         }

         uiSupport213.v12 = var9;
         return var2;
      } else {
         return var2;
      }
   }
}
