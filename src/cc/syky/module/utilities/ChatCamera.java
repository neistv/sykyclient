package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport191;
import cc.syky.ui.uiSupport240;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_423;
import net.minecraft.class_5498;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "chatcamera",
   displayName = "Chat Camera",
   category = ModuleCategory.UTILITIES,
   group = "Camera Tools",
   description = "module.chatcamera.description"
)
public final class ChatCamera extends Module {
   private static final float v2 = 4.0F;
   private static final float name = 1.4F;
   private static final float displayName = 14.0F;
   private static final float category = 0.1F;
   @Nullable
   private static ChatCamera group;
   private final uiRecord14 description;
   private final EnumSetting<BackSupport> defaultEnabled = this.settings.add(new EnumSetting<>("view", BackSupport.BACK));
   private final FloatSetting distance = this.settings.add(new FloatSetting("distance", 4.0F, 1.0F, 4.0F));
   private final BooleanSetting smooth = this.settings.add(new BooleanSetting("smooth", true));
   private boolean disableAction;
   @Nullable
   private class_5498 enabled;
   @Nullable
   private class_5498 v13;
   private float v14;
   private long v15;

   public ChatCamera(uiRecord14 var1) {
      this.description = var1;
      group = this;
   }

   @Override
   public void onEnableHook() {
      this.addSubscription(this.description.v1().v1(uiSupport240.class, var1 -> this.v20(), 0));
   }

   @Override
   public void onDisableHook() {
      this.v4(this.description.v2().v1());
   }

   @Override
   public void onRenderHook() {
      this.v4(this.description.v2().v1());
   }

   private void v20() {
      class_310 var1 = this.description.v2().v1();
      if (var1 != null) {
         if (this.disableAction) {
            this.v3(var1);
         } else if (v1(var1)) {
            this.v2(var1);
         }
      }
   }

   private static boolean v1(class_310 var0) {
      return var0.field_1755 instanceof class_408 && !(var0.field_1755 instanceof class_423);
   }

   private void v2(class_310 var1) {
      if (var1.field_1687 != null && var1.field_1724 != null) {
         class_5498 var2 = var1.field_1690.method_31044();
         if (var2.method_31034() && !Freelook.v17()) {
            this.enabled = var2;
            this.v14 = this.smooth.getValue() ? 1.4F : this.distance.getValue();
            this.v15 = 0L;
            this.disableAction = true;
            this.v1(var1, this.v22());
         }
      }
   }

   private void v3(class_310 var1) {
      if (Freelook.v17() || var1.field_1690.method_31044() != this.v13) {
         this.v21();
      } else if (v1(var1) && var1.field_1687 != null) {
         this.v1(var1, this.v22());
         this.v24();
      } else {
         this.v4(var1);
      }
   }

   private void v4(@Nullable class_310 var1) {
      if (this.disableAction) {
         class_5498 var2 = this.enabled;
         this.v21();
         if (var1 != null && var2 != null) {
            uiSupport191.v1(var1, var2);
         }
      }
   }

   private void v1(class_310 var1, class_5498 var2) {
      this.v13 = var2;
      uiSupport191.v1(var1, var2);
   }

   private void v21() {
      this.disableAction = false;
      this.enabled = null;
      this.v13 = null;
      this.v14 = 0.0F;
      this.v15 = 0L;
   }

   private class_5498 v22() {
      return this.defaultEnabled.getValue().v2();
   }

   private void v24() {
      long var1 = System.nanoTime();
      float var3 = this.v15 == 0L ? 0.0F : Math.min((float)(var1 - this.v15) / 1.0E9F, 0.1F);
      this.v15 = var1;
      float var4 = this.distance.getValue();
      if (!this.smooth.getValue()) {
         this.v14 = var4;
      } else if (var3 > 0.0F) {
         this.v14 = this.v14 + (var4 - this.v14) * (float)(1.0 - Math.exp(-14.0F * var3));
      }
   }

   public static float v17() {
      ChatCamera var0 = group;
      return var0 != null && var0.disableAction ? var0.v14 / 4.0F : 1.0F;
   }
}
