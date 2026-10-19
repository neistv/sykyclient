package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.hud.hudSupport73;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_1041;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "aspectratio",
   displayName = "AspectRatio",
   category = ModuleCategory.VISUAL,
   group = "View & Motion",
   description = "module.aspectratio.description"
)
public final class AspectRatio extends Module {
   private final EnumSetting<hudSupport73> v2 = this.settings.add(new EnumSetting<>("mode", hudSupport73.RATIO_4_3));
   private final FloatSetting stretch = this.settings.add(new FloatSetting("stretch", 1.0F, 0.5F, 2.5F));
   private final BooleanSetting hand = this.settings.add(new BooleanSetting("hand", false));
   @Nullable
   private hudSupport73 category;
   private float group;
   private int description;
   private int defaultEnabled;
   private final uiRecord14 subscriptions;

   public AspectRatio(uiRecord14 var1) {
      this.subscriptions = var1;
   }

   @Override
   public void onEnableHook() {
      this.v1(this.v2.getValue());
      this.category = this.v2.getValue();
      this.group = this.stretch.getValue();
      this.v17();
   }

   @Override
   public void onDisableHook() {
      visualSupport62.v1(1.0F);
      visualSupport62.v2(1.0F);
   }

   @Override
   public void onResetHook() {
      hudSupport73 var1 = this.v2.getValue();
      if (var1 != this.category) {
         this.category = var1;
         if (var1 != hudSupport73.CUSTOM) {
            this.v1(var1);
            this.group = this.stretch.getValue();
         }
      } else if (this.stretch.getValue() != this.group) {
         this.group = this.stretch.getValue();
         if (var1 != hudSupport73.CUSTOM) {
            this.v2.setValue(hudSupport73.CUSTOM);
            this.category = hudSupport73.CUSTOM;
         }
      } else if (var1 != hudSupport73.CUSTOM && this.v20()) {
         this.v1(var1);
         this.group = this.stretch.getValue();
      }

      this.v17();
   }

   private void v17() {
      visualSupport62.v1(this.stretch.getValue());
      visualSupport62.v2(this.hand.getValue() ? this.stretch.getValue() : 1.0F);
   }

   private boolean v20() {
      class_1041 var1 = this.subscriptions.v2().v1().method_22683();
      if (var1 == null) {
         return false;
      } else {
         int var2 = var1.method_4489();
         int var3 = var1.method_4506();
         if (var2 == this.description && var3 == this.defaultEnabled) {
            return false;
         } else {
            this.description = var2;
            this.defaultEnabled = var3;
            return true;
         }
      }
   }

   private void v1(hudSupport73 var1) {
      float var2 = var1.v2();
      if (!(var2 <= 0.0F)) {
         class_1041 var3 = this.subscriptions.v2().v1().method_22683();
         if (var3 != null) {
            int var4 = var3.method_4506();
            this.description = var3.method_4489();
            this.defaultEnabled = var4;
            if (var4 > 0) {
               this.stretch.setValue((float)this.description / var4 / var2);
            }
         }
      }
   }
}
