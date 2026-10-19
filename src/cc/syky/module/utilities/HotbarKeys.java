package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiSupport181;
import cc.syky.ui.uiSupport182;

@ModuleInfo(
   name = "hotbarkeys",
   displayName = "Hotbar Keys",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.hotbarkeys.description"
)
public final class HotbarKeys extends Module {
   private final EnumSetting<uiSupport182> v2 = this.settings.add(new EnumSetting<>("position", uiSupport182.TOP_LEFT));
   private final FloatSetting size = this.settings.add(new FloatSetting("size", 8.0F, 4.0F, 14.0F));
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -1));

   public HotbarKeys() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      uiSupport181.v1 = false;
   }

   private void onEnable() {
      uiSupport181.v1 = true;
      uiSupport181.v2 = this.v2.getValue();
      uiSupport181.v3 = this.size.getValue();
      uiSupport181.v4 = this.color.getValue();
   }
}
