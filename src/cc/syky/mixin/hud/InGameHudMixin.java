package cc.syky.mixin.hud;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.account.accountSupport21;
import cc.syky.hud.HudElement;
import cc.syky.module.utilities.utilitiesSupport9;
import cc.syky.module.visual.visualSupport44;
import cc.syky.ui.uiSupport141;
import cc.syky.ui.uiSupport181;
import cc.syky.ui.uiSupport186;
import cc.syky.ui.uiSupport221;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_10799;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_9779;
import net.minecraft.class_9848;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_329.class})
public abstract class InGameHudMixin {
   @Shadow
   @Final
   private static class_2960 field_27960;
   @Unique
   private static final class_2960 SYKY_PUMPKIN_BLUR = class_2960.method_60656("textures/misc/pumpkinblur.png");

   public InGameHudMixin() {
   }

   @Inject(
      method = {"method_1736"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$crosshair(class_332 var1, class_9779 var2, CallbackInfo var3) {
      class_310 var4 = class_310.method_1551();
      if (accountSupport21.v1 && (var4.field_1690.method_31044().method_31034() || accountSupport21.v2)) {
         float var5 = var2.method_60637(false);
         boolean var6 = uiSupport259.v1("hud.crosshair", () -> {
            accountSupport21.v1(var1, var5);
            return true;
         }, false);
         if (var6) {
            var3.cancel();
         }
      }
   }

   @ModifyExpressionValue(
      method = {"method_1736"},
      at = {@At(
         value = "FIELD",
         target = "Lnet/minecraft/class_310;field_1692:Lnet/minecraft/class_1297;"
      )}
   )
   @Nullable
   private class_1297 syky$narrowAttackIndicator(@Nullable class_1297 var1) {
      if (var1 == null) {
         return null;
      } else {
         return uiSupport259.v1("hud.crosshair.narrow", () -> visualSupport44.v1(var1), false) ? null : var1;
      }
   }

   @Inject(
      method = {"method_55804"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$suppressPlayerList(class_332 var1, class_9779 var2, CallbackInfo var3) {
      SykyRuntime var4 = Syky.rootOrNull();
      if (var4 != null && uiSupport259.v1("hud.playerlist-suppress", () -> var4.v3().v15(), false)) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_70838"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$suppressDebugHud(class_332 var1, CallbackInfo var2) {
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 != null && uiSupport259.v1("hud.debughud-suppress", () -> var3.v3().v15(), false)) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"method_55803"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$scoreboardTakeover(class_332 var1, class_9779 var2, CallbackInfo var3) {
      if (syky$elementEnabled("hud.scoreboard-takeover", "scoreboard")) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_70837"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$bossBarTakeover(class_332 var1, class_9779 var2, CallbackInfo var3) {
      if (syky$elementEnabled("hud.bossbar-takeover", "bossbar")) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_1765"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$statusEffectsTakeover(class_332 var1, class_9779 var2, CallbackInfo var3) {
      if (syky$elementEnabled("hud.potions-takeover", "active_potion")) {
         var3.cancel();
      }
   }

   @Unique
   private static boolean syky$elementEnabled(String var0, String var1) {
      return uiSupport259.v1(var0, () -> {
         SykyRuntime var1x = Syky.rootOrNull();
         if (var1x == null) {
            return false;
         } else {
            HudElement var2 = var1x.v3().v1(var1);
            return var2 != null && var2.v10();
         }
      }, false);
   }

   @WrapOperation(
      method = {"method_1757"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_332;method_51439(Lnet/minecraft/class_327;Lnet/minecraft/class_2561;IIIZ)V"
      )}
   )
   private void syky$maskScoreboardSidebar(class_332 var1, class_327 var2, class_2561 var3, int var4, int var5, int var6, boolean var7, Operation<Void> var8) {
      class_2561 var9 = uiSupport223.v2 ? uiSupport259.v1("hud.scoreboard-streamer", () -> uiSupport221.v1(var3, uiSupport223.v2()), var3) : var3;
      var8.call(new Object[]{var1, var2, var9, var4, var5, var6, var7});
   }

   @Inject(
      method = {"method_58477"},
      at = {@At("TAIL")}
   )
   private void syky$saturation(class_332 var1, class_1657 var2, int var3, int var4, CallbackInfo var5) {
      if (uiSupport186.v1) {
         uiSupport259.v1("hud.saturation", () -> uiSupport186.v1(var1, var2, var3, var4));
      }
   }

   @Inject(
      method = {"method_1759"},
      at = {@At("TAIL")}
   )
   private void syky$hotbarKeys(class_332 var1, class_9779 var2, CallbackInfo var3) {
      class_437 var4 = class_310.method_1551().field_1755;
      if (uiSupport181.v1 && (var4 == null || var4 instanceof uiSupport141)) {
         uiSupport259.v1("hud.hotbarkeys-capture", () -> uiSupport181.v1(var1));
      }
   }

   @WrapOperation(
      method = {"method_55798"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_329;method_31977(Lnet/minecraft/class_332;Lnet/minecraft/class_2960;F)V"
      )}
   )
   private void syky$pumpkinOverlay(class_329 var1, class_332 var2, class_2960 var3, float var4, Operation<Void> var5) {
      if ((utilitiesSupport9.v1 || utilitiesSupport9.v2) && !field_27960.equals(var3)) {
         float var6 = var4 * utilitiesSupport9.v3;
         if (!(var6 <= 0.0F)) {
            var5.call(new Object[]{var1, var2, var3, var6});
         }
      } else {
         var5.call(new Object[]{var1, var2, var3, var4});
      }
   }

   @Inject(
      method = {"method_55798"},
      at = {@At("TAIL")}
   )
   private void syky$pumpkinPreview(class_332 var1, class_9779 var2, CallbackInfo var3) {
      if (utilitiesSupport9.v2) {
         uiSupport259.v1(
            "hud.pumpkin-preview",
            () -> {
               class_310 var1x = class_310.method_1551();
               if (var1x.field_1724 != null
                  && var1x.field_1690.method_31044().method_31034()
                  && !var1x.field_1724.method_31550()
                  && !var1x.field_1724.method_6118(class_1304.field_6169).method_31574(class_1802.field_17519)) {
                  float var2x = utilitiesSupport9.v3;
                  if (!(var2x <= 0.0F)) {
                     int var3x = var1.method_51421();
                     int var4 = var1.method_51443();
                     var1.method_25291(class_10799.field_56883, SYKY_PUMPKIN_BLUR, 0, 0, 0.0F, 0.0F, var3x, var4, var3x, var4, class_9848.method_61317(var2x));
                  }
               }
            }
         );
      }
   }
}
