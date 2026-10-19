package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "safeinteraction",
   displayName = "Safe Interaction",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.safeinteraction.description"
)
public final class SafeInteraction extends Module {
   private final BooleanSetting ownPets = this.settings.add(new BooleanSetting("ownPets", true));
   private final BooleanSetting otherPets = this.settings.add(new BooleanSetting("otherPets", true));
   private final BooleanSetting villagers = this.settings.add(new BooleanSetting("villagers", true));
   private final BooleanSetting players = this.settings.add(new BooleanSetting("players", false));

   public SafeInteraction() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      utilitiesSupport8.v1 = this.ownPets.getValue();
      utilitiesSupport8.v2 = this.otherPets.getValue();
      utilitiesSupport8.v3 = this.villagers.getValue();
      utilitiesSupport8.v4 = this.players.getValue();
   }

   private void onDisable() {
      utilitiesSupport8.v1 = false;
      utilitiesSupport8.v2 = false;
      utilitiesSupport8.v3 = false;
      utilitiesSupport8.v4 = false;
   }
}
