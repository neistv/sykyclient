package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.internal.InternalSupport48;
import cc.syky.internal.InternalSupport49;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "motionblur",
   displayName = "Motion Blur",
   category = ModuleCategory.VISUAL,
   group = "View & Motion",
   description = "module.motionblur.description"
)
public final class MotionBlur extends Module {
   private final FloatSetting strength = this.settings.add(new FloatSetting("strength", 25.0F, 0.0F, 100.0F));
   private final EnumSetting<InternalSupport49> name = this.settings.add(new EnumSetting<>("quality", InternalSupport49.OPTIMIZED));

   public MotionBlur() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport51.v44 = false;
      InternalSupport48.v2();
   }

   private void onEnable() {
      visualSupport51.v44 = true;
      visualSupport51.v47 = this.strength.getValue() / 100.0F;
      visualSupport51.v49 = this.name.getValue();
   }

   @Override
   public void onTickHook() {
      InternalSupport48.v2();
   }

   @Override
   public void onRenderHook() {
      InternalSupport48.v2();
   }
}
