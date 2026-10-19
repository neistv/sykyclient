package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1144;
import net.minecraft.class_310;
import net.minecraft.class_3419;

@ModuleInfo(
   name = "focusfade",
   displayName = "Focus Fade",
   category = ModuleCategory.VISUAL,
   group = "Sound",
   description = "module.focusfade.description"
)
public final class FocusFade extends Module {
   private static final float v2 = 0.004F;
   private final FloatSetting amount = this.settings.add(new FloatSetting("amount", 70.0F, 0.0F, 100.0F));
   private final FloatSetting fade = this.settings.add(new FloatSetting("fade", 0.35F, 0.0F, 2.0F));
   private final uiRecord14 category;
   private float group;
   private float description = 1.0F;
   private long defaultEnabled;

   public FocusFade(uiRecord14 var1) {
      this.category = var1;
   }

   @Override
   public void onEnableHook() {
      this.group = 0.0F;
      this.description = 1.0F;
      this.defaultEnabled = System.nanoTime();
      v1(this.category.v2().v1(), 1.0F);
   }

   @Override
   public void onDisableHook() {
      v1(this.category.v2().v1(), 1.0F);
      this.group = 0.0F;
      this.description = 1.0F;
   }

   @Override
   public void onResetHook() {
      this.v17();
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      this.v17();
   }

   private void v17() {
      class_310 var1 = this.category.v2().v1();
      if (var1 != null) {
         long var2 = System.nanoTime();
         float var4 = (float)(var2 - this.defaultEnabled) / 1.0E9F;
         this.defaultEnabled = var2;
         this.group = visualSupport32.v1(this.group, var1.method_1569(), var4, this.fade.getValue());
         float var5 = visualSupport32.v1(this.group, this.amount.getValue() / 100.0F);
         boolean var6 = this.group <= 0.0F || this.group >= 1.0F;
         if (Math.abs(var5 - this.description) > 0.004F || var6 && var5 != this.description) {
            v1(var1, var5);
            this.description = var5;
         }
      }
   }

   private static void v1(class_310 var0, float var1) {
      visualSupport31.v1 = var1;
      visualSupport3.v2(var1);
      if (var0 != null) {
         class_1144 var2 = var0.method_1483();
         if (var2 != null) {
            var2.method_76569(class_3419.field_15250);
         }
      }
   }
}
