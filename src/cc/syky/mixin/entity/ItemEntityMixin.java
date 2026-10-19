package cc.syky.mixin.entity;

import cc.syky.internal.Support721;
import cc.syky.module.visual.ItemPhysic;
import cc.syky.ui.uiSupport171;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1542;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1542.class})
public abstract class ItemEntityMixin implements Support721 {
   @Unique
   private boolean syky$seeded;
   @Unique
   private float syky$yaw;
   @Unique
   private float syky$tumble;
   @Unique
   private float syky$prevTumble;
   @Unique
   private float syky$settleOffset;
   @Unique
   private float syky$rest;
   @Unique
   private float syky$prevRest;

   public ItemEntityMixin() {
   }

   @Override
   public void syky$ensurePose() {
      if (!this.syky$seeded) {
         class_1542 var1 = (class_1542)this;
         this.syky$seeded = true;
         this.syky$yaw = uiSupport171.v4(class_1542.method_27314(var1.field_6012, var1.field_7203));
         this.syky$tumble = this.syky$yaw;
         this.syky$prevTumble = this.syky$tumble;
         this.syky$settleOffset = uiSupport171.v2(this.syky$tumble);
         this.syky$rest = var1.method_24828() ? 1.0F : 0.0F;
         this.syky$prevRest = this.syky$rest;
      }
   }

   @Override
   public float syky$restAt(float var1) {
      return uiSupport171.v2(this.syky$prevRest, this.syky$rest, var1);
   }

   @Override
   public float syky$pitchAt(float var1) {
      float var2 = uiSupport171.v1(this.syky$prevTumble, this.syky$tumble, var1);
      float var3 = uiSupport171.v3(this.syky$restAt(var1));
      return var2 + this.syky$settleOffset * var3;
   }

   @Override
   public float syky$yaw() {
      return this.syky$yaw;
   }

   @Override
   public boolean syky$settled() {
      return this.syky$seeded && this.syky$prevRest == 1.0F && this.syky$rest == 1.0F && this.syky$prevTumble == this.syky$tumble;
   }

   @Inject(
      method = {"method_5773"},
      at = {@At("TAIL")}
   )
   private void syky$advanceTumble(CallbackInfo var1) {
      class_1542 var2 = (class_1542)this;
      if (var2.method_73183().method_8608()) {
         if (!ItemPhysic.v2) {
            this.syky$seeded = false;
         } else {
            uiSupport259.v1("item.physic-tick", () -> this.syky$step(var2));
         }
      }
   }

   @Unique
   private void syky$step(class_1542 var1) {
      this.syky$ensurePose();
      boolean var2 = var1.method_24828();
      this.syky$prevRest = this.syky$rest;
      this.syky$prevTumble = this.syky$tumble;
      if (var2) {
         if (this.syky$rest <= 0.0F) {
            this.syky$settleOffset = uiSupport171.v2(this.syky$tumble);
         }

         this.syky$rest = uiSupport171.v1(this.syky$rest, true);
      } else {
         this.syky$rest = uiSupport171.v1(this.syky$rest, false);
         if (this.syky$rest <= 0.0F) {
            this.syky$tumble = uiSupport171.v1(this.syky$tumble);
         }
      }
   }
}
