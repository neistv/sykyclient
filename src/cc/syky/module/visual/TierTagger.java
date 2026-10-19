package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.SettingCondition;
import cc.syky.config.configSupport13;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import java.util.EnumSet;

@ModuleInfo(
   name = "tiertagger",
   displayName = "Tier Tagger",
   category = ModuleCategory.VISUAL,
   group = "Player Info",
   description = "module.tiertagger.description"
)
public final class TierTagger extends Module {
   private final visualSupport6<CISSupport> v2 = this.settings.add(new visualSupport6<>("sources", CISSupport.class, EnumSet.allOf(CISSupport.class)));
   private final BooleanSetting showIcons = this.settings.add(new BooleanSetting("showIcons", true));
   private final BooleanSetting tabList = this.settings.add(new BooleanSetting("tabList", true));
   private final BooleanSetting nametags = this.settings.add(new BooleanSetting("nametags", true));
   private final EnumSetting<WhenNotSupport> group = this.settings.add(new EnumSetting<>("highest", WhenNotSupport.NOT_FOUND));
   private final EnumSetting<NethPotSupport> description = this.settings
      .add(new EnumSetting<>("gamemode", NethPotSupport.VANILLA), SettingCondition.v1(this.group, WhenNotSupport.NEVER, WhenNotSupport.NOT_FOUND));

   public TierTagger(uiRecord14 var1) {
      configSupport13.v1();
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport16.v1 = false;
      visualSupport16.v1();
   }

   private void onEnable() {
      if (visualSupport16.v2 != this.showIcons.getValue()
         || visualSupport16.v5 != this.description.getValue()
         || visualSupport16.v6 != this.group.getValue()
         || !visualSupport16.v7.equals(this.v2.v9())) {
         visualSupport16.v1();
      }

      visualSupport16.v7.clear();
      visualSupport16.v7.addAll(this.v2.v9());
      visualSupport16.v2 = this.showIcons.getValue();
      visualSupport16.v3 = this.tabList.getValue();
      visualSupport16.v4 = this.nametags.getValue();
      visualSupport16.v5 = this.description.getValue();
      visualSupport16.v6 = this.group.getValue();
      visualSupport16.v1 = true;
   }
}
