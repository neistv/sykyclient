package cc.syky.mixin.client;

import cc.syky.cloud.cloudSupport57;
import cc.syky.ui.uiSupport215;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1041;
import net.minecraft.class_313;
import net.minecraft.class_319;
import net.minecraft.class_323;
import net.minecraft.class_6417;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1041.class})
public abstract class WindowBorderlessMixin {
   @Shadow
   private boolean field_5191;
   @Shadow
   private int field_5183;
   @Shadow
   private int field_5198;
   @Shadow
   private int field_5182;
   @Shadow
   private int field_5197;
   @Shadow
   private int field_5175;
   @Shadow
   private int field_5185;
   @Shadow
   private int field_5174;
   @Shadow
   private int field_5184;
   @Shadow
   @Final
   private class_323 field_5195;
   @Unique
   private boolean syky$borderless;

   public WindowBorderlessMixin() {
   }

   @Inject(
      method = {"method_4479"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void syky$borderlessFullscreen(CallbackInfo var1) {
      if (!class_6417.field_52734) {
         boolean var2 = this.field_5191 && uiSupport215.v1;
         if (var2 || this.syky$borderless) {
            class_1041 var3 = (class_1041)this;
            if (uiSupport259.v1("window.borderless", () -> this.syky$lay(var3, var2), false)) {
               var1.cancel();
            }
         }
      }
   }

   @Unique
   private boolean syky$lay(class_1041 var1, boolean var2) {
      if (!var2) {
         cloudSupport57.v2(var1);
         this.syky$borderless = false;
         if (this.field_5191) {
            this.field_5183 = this.field_5175;
            this.field_5198 = this.field_5185;
            this.field_5182 = this.field_5174;
            this.field_5197 = this.field_5184;
         }

         return false;
      } else {
         class_313 var3 = this.field_5195.method_1681(var1);
         if (var3 == null) {
            return false;
         } else {
            if (!this.syky$borderless && !cloudSupport57.v1(var1)) {
               this.field_5175 = this.field_5183;
               this.field_5185 = this.field_5198;
               this.field_5174 = this.field_5182;
               this.field_5184 = this.field_5197;
            }

            class_319 var4 = var3.method_1617();
            this.field_5183 = var3.method_1616();
            this.field_5198 = var3.method_1618();
            this.field_5182 = var4.method_1668();
            this.field_5197 = var4.method_1669();
            cloudSupport57.v1(var1, this.field_5183, this.field_5198, this.field_5182, this.field_5197);
            this.syky$borderless = true;
            return true;
         }
      }
   }
}
