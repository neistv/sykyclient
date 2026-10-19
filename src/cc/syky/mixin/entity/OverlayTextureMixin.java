package cc.syky.mixin.entity;

import cc.syky.internal.Support774;
import cc.syky.module.visual.visualSupport42;
import cc.syky.module.visual.visualSupport52;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_4608;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_4608.class})
public abstract class OverlayTextureMixin implements visualSupport52 {
   @Shadow
   @Final
   private class_1043 field_21013;
   @Unique
   private boolean syky$rampApplied;
   @Unique
   private int syky$rampArgb;
   @Unique
   private final boolean[] syky$rowApplied = new boolean[16];
   @Unique
   private final int[] syky$rowFrom = new int[16];
   @Unique
   private final int[] syky$rowTo = new int[16];

   public OverlayTextureMixin() {
   }

   @Override
   public void syky$sync(boolean var1, int var2) {
      if (var1) {
         if (this.syky$rampApplied && this.syky$rampArgb == var2) {
            return;
         }

         this.syky$paint(var2, true);
         this.syky$rampApplied = true;
         this.syky$rampArgb = var2;
      } else {
         if (!this.syky$rampApplied) {
            return;
         }

         this.syky$paint(-1291911168, false);
         this.syky$rampApplied = false;
      }
   }

   @Override
   public void syky$syncRow(int var1, boolean var2, int var3, int var4) {
      boolean var5 = this.syky$rowApplied[var1];
      if (var2 ? !var5 || this.syky$rowFrom[var1] != var3 || this.syky$rowTo[var1] != var4 : var5) {
         class_1011 var6 = this.field_21013.method_4525();
         if (var6 != null) {
            if (var2) {
               for (int var7 = 0; var7 < 16; var7++) {
                  int var8 = var7;
                  int var9 = uiSupport259.v1("overlay.row-texel", () -> Support774.v1(var3, var4, var8), -1);
                  var6.method_61941(var7, var1, var9);
               }

               this.syky$rowFrom[var1] = var3;
               this.syky$rowTo[var1] = var4;
            } else {
               syky$restoreWhiteRow(var6, var1);
            }

            this.field_21013.method_4524();
            this.syky$rowApplied[var1] = var2;
         }
      }
   }

   @Unique
   private void syky$paint(int var1, boolean var2) {
      class_1011 var3 = this.field_21013.method_4525();
      if (var3 != null) {
         for (int var4 = 0; var4 < 8; var4++) {
            syky$paintRow(var3, var4, var1, var2);
         }

         this.field_21013.method_4524();
      }
   }

   @Unique
   private static void syky$paintRow(class_1011 var0, int var1, int var2, boolean var3) {
      int var4 = var2 >>> 24 & 0xFF;
      int var5 = var2 & 16777215;

      for (int var6 = 0; var6 < 16; var6++) {
         int var7 = var3 ? 255 - Math.round(var4 * (var6 / 15.0F)) : var4;
         var0.method_61941(var6, var1, var7 << 24 | var5);
      }
   }

   @Unique
   private static void syky$restoreWhiteRow(class_1011 var0, int var1) {
      for (int var2 = 0; var2 < 16; var2++) {
         int var3 = (int)((1.0F - var2 / 15.0F * 0.75F) * 255.0F);
         var0.method_61941(var2, var1, var3 << 24 | 16777215);
      }
   }

   @Inject(
      method = {"method_23624"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$hurtUv(float var0, boolean var1, CallbackInfoReturnable<Integer> var2) {
      if (var1 && visualSupport42.v3) {
         var2.setReturnValue(class_4608.method_23625(class_4608.method_23210(1.0F), class_4608.method_23212(true)));
      }
   }
}
