package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.internal.InternalSupport55;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "reconnectbutton",
   displayName = "Reconnect Button",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.reconnectbutton.description"
)
public final class ReconnectButton extends Module {
   private final BooleanSetting disconnectScreen = this.settings.add(new BooleanSetting("disconnectScreen", true));
   private final BooleanSetting pauseMenu = this.settings.add(new BooleanSetting("pauseMenu", true));

   public ReconnectButton() {
      this.setToggleActions(this::v17, ReconnectButton::v20);
   }

   private void v17() {
      InternalSupport55.v1 = this.disconnectScreen.getValue();
      InternalSupport55.v2 = this.pauseMenu.getValue();
   }

   private static void v20() {
      InternalSupport55.v1 = false;
      InternalSupport55.v2 = false;
   }
}
