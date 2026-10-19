package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;

@ModuleInfo(
   name = "thirdperson",
   displayName = "Third Person",
   category = ModuleCategory.UTILITIES,
   group = "Camera Tools",
   description = "module.thirdperson.description"
)
public final class ThirdPerson extends Module {
   private final uiRecord14 v2;
   private final EnumSetting<BackSupport> name = this.settings.add(new EnumSetting<>("view", BackSupport.BACK));
   private final BooleanSetting smooth = this.settings.add(new BooleanSetting("smooth", true));
   private final BooleanSetting scrollZoom = this.settings.add(new BooleanSetting("scrollZoom", false));
   private BackSupport group = BackSupport.BACK;

   public ThirdPerson(uiRecord14 var1) {
      this.v2 = var1;
   }

   @Override
   public void onEnableHook() {
      this.v17();
   }

   @Override
   public void onTickHook() {
      this.v17();
   }

   @Override
   public void onDisableHook() {
      utilitiesSupport5.v1(this.v2.v2().v1());
   }

   @Override
   public void onRenderHook() {
      utilitiesSupport5.v1(this.v2.v2().v1());
   }

   private void v17() {
      this.group = this.name.getValue();
      utilitiesSupport5.v1(this.v2.v2().v1(), this.group, this.smooth.getValue(), this.scrollZoom.getValue());
   }

   @Override
   public void onResetHook() {
      utilitiesSupport5.v1(this.smooth.getValue(), this.scrollZoom.getValue());
      BackSupport var1 = this.name.getValue();
      if (var1 != this.group) {
         this.group = var1;
         utilitiesSupport5.v1(this.v2.v2().v1(), var1);
      }
   }
}
