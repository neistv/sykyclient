package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import net.minecraft.class_3532;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "zoom",
   displayName = "Zoom",
   category = ModuleCategory.UTILITIES,
   group = "Camera Tools",
   description = "module.zoom.description"
)
public final class Zoom extends Module {
   private static final double v2 = 200.0;
   private static final double name = 1.15;
   private static final double displayName = 1.4;
   @Nullable
   private static Zoom category;
   private final FloatSetting zoom = this.settings.add(new FloatSetting("zoom", 6.0F, 1.0F, 50.0F));
   private final BooleanSetting smooth = this.settings.add(new BooleanSetting("smooth", true));
   private final FloatSetting speed = this.settings.add(new FloatSetting("speed", 10.5F, 1.0F, 40.0F).setCondition(this.smooth));
   private final BooleanSetting scroll = this.settings.add(new BooleanSetting("scroll", true));
   private final FloatSetting scrollStep = this.settings.add(new FloatSetting("scrollStep", 2.5F, 0.25F, 4.0F).setCondition(this.scroll));
   private final BooleanSetting reduceSensitivity = this.settings.add(new BooleanSetting("reduceSensitivity", true));
   private double enabled = 4.0;
   private float v13 = 4.0F;

   public Zoom() {
      category = this;
   }

   @Override
   public void onEnableHook() {
      this.v13 = this.zoom.getValue();
      this.enabled = this.v13;
      this.v20();
      utilitiesSupport.v1(this.enabled);
   }

   @Override
   public void onDisableHook() {
      utilitiesSupport.v1(1.0);
   }

   @Override
   public void onResetHook() {
      if (this.zoom.getValue() != this.v13) {
         this.v13 = this.zoom.getValue();
         this.enabled = this.v13;
      }

      this.v20();
      utilitiesSupport.v1(this.enabled);
   }

   private void v20() {
      utilitiesSupport.v1(this.speed.getValue(), this.smooth.getValue());
   }

   public static boolean v1(double var0) {
      Zoom var2 = category;
      if (var2 != null && var2.isEnabled() && var2.scroll.getValue() && var0 != 0.0) {
         double var3 = Math.pow(1.15, var2.scrollStep.getValue().floatValue() * var0);
         var2.enabled = class_3532.method_15350(var2.enabled * var3, 1.0, 200.0);
         utilitiesSupport.v1(var2.enabled);
         return true;
      } else {
         return false;
      }
   }

   public static double v17() {
      Zoom var0 = category;
      if (var0 != null && var0.reduceSensitivity.getValue()) {
         double var1 = utilitiesSupport.v1();
         return var1 <= 1.001 ? 1.0 : 1.0 / Math.pow(var1, 1.4);
      } else {
         return 1.0;
      }
   }
}
