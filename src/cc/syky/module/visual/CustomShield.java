package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1796;
import net.minecraft.class_1799;
import net.minecraft.class_1819;
import net.minecraft.class_310;
import net.minecraft.class_746;

@ModuleInfo(
   name = "shield",
   displayName = "Custom Shield",
   category = ModuleCategory.VISUAL,
   group = "Combat Items",
   description = "module.shield.description"
)
public final class CustomShield extends Module implements cloudSupport100 {
   private final uiRecord14 name;
   private final FloatSetting opacity = this.settings.add(new FloatSetting("opacity", 1.0F, 0.0F, 1.0F));
   private final FloatSetting lower = this.settings.add(new FloatSetting("lower", 0.0F, 0.0F, 1.0F));
   private final FloatSetting scale = this.settings.add(new FloatSetting("scale", 1.0F, 0.2F, 2.0F));
   private final BooleanSetting showDisabled = this.settings.add(new BooleanSetting("showDisabled", true));
   private final ColorSetting disabledColor = this.settings.add(new ColorSetting("disabledColor", -1723825665).setCondition(this.showDisabled));
   private static final float subscriptions = 12.0F;
   private static final float enableAction = 0.1F;
   public static final visualSupport57 v2 = new visualSupport57(10.0F);
   private float disableAction = 1.0F;
   private float enabled;
   private float v13 = 1.0F;
   private long v14;

   public CustomShield(uiRecord14 var1) {
      this.name = var1;
   }

   @Override
   public void onEnableHook() {
      this.v21();
      this.v17();
      visualSupport40.v1 = true;
      v2.v1(true);
      this.v14 = 0L;
   }

   @Override
   public void onTickHook() {
      v2.v1();
   }

   @Override
   public void onRenderHook() {
      visualSupport40.v6 = false;
      visualSupport40.v13 = -1;
   }

   @Override
   public void onDisableHook() {
      visualSupport40.v1 = false;
      visualSupport40.v6 = false;
      visualSupport40.v13 = -1;
      this.v20();
      v2.v1(false);
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      long var2 = System.nanoTime();
      float var4 = this.v14 == 0L ? 0.0F : Math.min((float)(var2 - this.v14) / 1.0E9F, 0.1F);
      this.v14 = var2;
      float var5 = var4 <= 0.0F ? 0.0F : 1.0F - (float)Math.exp(-12.0F * var4);
      this.disableAction = this.disableAction + (this.opacity.getValue() - this.disableAction) * var5;
      this.enabled = this.enabled + (this.lower.getValue() - this.enabled) * var5;
      this.v13 = this.v13 + (this.scale.getValue() - this.v13) * var5;
      this.v17();
   }

   @Override
   public void onResetHook() {
      class_310 var1 = this.name.v2().v1();
      visualSupport40.v6 = var1 != null && var1.field_1724 != null && v1(var1.field_1724);
   }

   private void v17() {
      visualSupport40.v3 = this.disableAction;
      visualSupport40.v4 = this.enabled;
      visualSupport40.v5 = this.v13;
      visualSupport40.v7 = this.disabledColor.getValue();
      visualSupport40.v8 = this.showDisabled.getValue();
      this.v20();
   }

   private void v20() {
      class_310 var1 = this.name.v2().v1();
      if (var1 != null && var1.field_1773 != null) {
         if (var1.field_1773.method_22975() instanceof visualSupport52 var2) {
            var2.syky$syncRow(14, visualSupport40.v1() && visualSupport40.v8, 0, visualSupport40.v7);
         }
      }
   }

   private void v21() {
      this.disableAction = this.opacity.getValue();
      this.enabled = this.lower.getValue();
      this.v13 = this.scale.getValue();
   }

   @Override
   public void v1() {
      if (!this.isEnabled()) {
         this.v21();
         this.v17();
      }

      visualSupport40.v2 = true;
   }

   @Override
   public void v2() {
      visualSupport40.v2 = false;
   }

   private static boolean v1(class_746 var0) {
      class_1796 var1 = var0.method_7357();
      class_1799 var2 = var0.method_6047();
      if (var2.method_7909() instanceof class_1819 && var1.method_7904(var2)) {
         return true;
      } else {
         class_1799 var3 = var0.method_6079();
         return var3.method_7909() instanceof class_1819 && var1.method_7904(var3);
      }
   }
}
