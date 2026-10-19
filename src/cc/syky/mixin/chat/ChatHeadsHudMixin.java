package cc.syky.mixin.chat;

import cc.syky.module.utilities.ChatHeads;
import cc.syky.ui.uiSupport209;
import cc.syky.ui.uiSupport213;
import cc.syky.ui.uiSupport214;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.Arrays;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_303;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_338;
import net.minecraft.class_5481;
import net.minecraft.class_303.class_7590;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_338.class})
public abstract class ChatHeadsHudMixin {
   @Unique
   @Nullable
   private uiSupport214[] syky$wrapping;
   @Unique
   private int syky$nextHead;

   public ChatHeadsHudMixin() {
   }

   @ModifyExpressionValue(
      method = {"method_44811"},
      at = {@At(
         value = "NEW",
         target = "(ILnet/minecraft/class_2561;Lnet/minecraft/class_7469;Lnet/minecraft/class_7591;)Lnet/minecraft/class_303;"
      )}
   )
   private class_303 syky$ownLine(class_303 var1) {
      uiSupport214[] var2 = uiSupport213.v3;
      if (var2 != null) {
         uiSupport213.v3 = null;
         ((uiSupport209)var1).syky$heads(var2);
      }

      return var1;
   }

   @WrapOperation(
      method = {"method_1815"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_303;method_75757(Lnet/minecraft/class_327;I)Ljava/util/List;"
      )}
   )
   private List<class_5481> syky$wrapWithSlot(class_303 var1, class_327 var2, int var3, Operation<List<class_5481>> var4) {
      uiSupport214[] var5 = uiSupport213.v2 ? ((uiSupport209)var1).syky$heads() : null;
      this.syky$wrapping = null;
      this.syky$nextHead = 0;
      if (var5 == null) {
         return (List<class_5481>)var4.call(new Object[]{var1, var2, var3});
      } else {
         class_2561 var6 = var1.comp_893();
         ChatHeads.Part1 var7 = uiSupport259.v1("chat.heads.slot", () -> ChatHeads.v1(var6, var5), null);
         if (var7 == null) {
            return (List<class_5481>)var4.call(new Object[]{var1, var2, var3});
         } else {
            this.syky$wrapping = var7.v2();
            return (List<class_5481>)var4.call(new Object[]{new class_303(var1.comp_892(), var7.v1(), var1.comp_915(), var1.comp_894()), var2, var3});
         }
      }
   }

   @ModifyExpressionValue(
      method = {"method_1815"},
      at = {@At(
         value = "NEW",
         target = "(ILnet/minecraft/class_5481;Lnet/minecraft/class_7591;Z)Lnet/minecraft/class_303$class_7590;"
      )}
   )
   private class_7590 syky$placeHead(class_7590 var1) {
      uiSupport214[] var2 = this.syky$wrapping;
      if (var2 == null) {
         return var1;
      } else {
         class_5481 var3 = var1.comp_896();
         int[] var4 = uiSupport259.v1("chat.heads.slot-x", () -> ChatHeads.v1(var3), null);
         int var5 = this.syky$nextHead;
         int var6 = var4 == null ? 0 : Math.min(var4.length, var2.length - var5);
         if (var4 != null && var6 > 0) {
            uiSupport209 var7 = (uiSupport209)var1;
            var7.syky$heads(Arrays.copyOfRange(var2, var5, var5 + var6));
            var7.syky$headXs(var6 == var4.length ? var4 : Arrays.copyOf(var4, var6));
            this.syky$nextHead = var5 + var6;
            if (this.syky$nextHead >= var2.length) {
               this.syky$wrapping = null;
            }
         }

         return var1;
      }
   }

   @Inject(
      method = {"method_75804"},
      at = {@At(
         value = "INVOKE",
         target = "Lorg/joml/Matrix3x2fStack;popMatrix()Lorg/joml/Matrix3x2fStack;"
      )}
   )
   private void syky$drawHeads(class_332 var1, class_327 var2, int var3, int var4, int var5, boolean var6, boolean var7, CallbackInfo var8) {
      if (uiSupport213.v12 != 0) {
         uiSupport213.v13 = var1;
         uiSupport259.v1("chat.heads.draw", ChatHeads::v17);
         uiSupport213.v12 = 0;
         uiSupport213.v13 = null;
      }
   }
}
