package cc.syky.module.advanced;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport220;
import cc.syky.ui.uiSupport223;

@ModuleInfo(
   name = "streamermode",
   displayName = "Streamer Mode",
   category = ModuleCategory.ADVANCED,
   group = "Privacy & Protection",
   description = "module.streamermode.description"
)
public final class StreamerMode extends Module {
   private final BooleanSetting hideName = this.settings.add(new BooleanSetting("hideName", true));
   private final BooleanSetting hideSkin = this.settings.add(new BooleanSetting("hideSkin", true));
   private final BooleanSetting hideCoords = this.settings.add(new BooleanSetting("hideCoords", true));
   private final BooleanSetting hideServerIp = this.settings.add(new BooleanSetting("hideServerIp", true));
   private final uiSupport220 group;

   public StreamerMode(uiRecord14 var1) {
      this.group = new uiSupport220(this.settings, var1);
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      uiSupport223.v2 = false;
      uiSupport223.v3 = false;
      uiSupport223.v4 = false;
      uiSupport223.v5 = false;
      this.group.v2();
   }

   private void onEnable() {
      uiSupport223.v2 = this.hideName.getValue();
      uiSupport223.v3 = this.hideSkin.getValue();
      uiSupport223.v4 = this.hideCoords.getValue();
      uiSupport223.v5 = this.hideServerIp.getValue();
      this.group.v1();
   }
}
