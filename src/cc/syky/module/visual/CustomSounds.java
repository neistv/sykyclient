package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport149;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

@ModuleInfo(
   name = "customsounds",
   displayName = "Custom Sounds",
   category = ModuleCategory.VISUAL,
   group = "Sound",
   description = "module.customsounds.description"
)
public final class CustomSounds extends Module {
   private final uiRecord14 v2;
   private final Path name;
   private static final Supplier<List<String>> displayName = visualSupport3::v3;
   private final uiSupport149 category = this.settings.add(new uiSupport149(visualSupport4.CRIT.v1()).v1(displayName));
   private final uiSupport149 group = this.settings.add(new uiSupport149(visualSupport4.KNOCKBACK.v1()).v1(displayName));
   private final uiSupport149 description = this.settings.add(new uiSupport149(visualSupport4.SWEEP.v1()).v1(displayName));
   private final uiSupport149 defaultEnabled = this.settings.add(new uiSupport149(visualSupport4.HIT.v1()).v1(displayName));
   private final uiSupport149 subscriptions = this.settings.add(new uiSupport149(visualSupport4.NO_DAMAGE.v1()).v1(displayName));
   private final uiSupport149 enableAction = this.settings.add(new uiSupport149(visualSupport4.MACE.v1()).v1(displayName));
   private final uiSupport149 disableAction = this.settings.add(new uiSupport149(visualSupport4.TOTEM_SELF.v1()).v1(displayName));
   private final uiSupport149 enabled = this.settings.add(new uiSupport149(visualSupport4.TOTEM_ENEMY.v1()).v1(displayName));
   private final uiSupport149 v13 = this.settings.add(new uiSupport149(visualSupport4.EXPLOSION.v1()).v1(displayName));
   private final FloatSetting volume = this.settings.add(new FloatSetting("volume", 100.0F, 0.0F, 200.0F).setSuffix("%"));
   private final BooleanSetting replaceVanilla = this.settings.add(new BooleanSetting("replaceVanilla", true));

   public CustomSounds(uiRecord14 var1, Path var2) {
      this.v2 = var1;
      this.name = var2;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      visualSupport3.v1(false);
   }

   @Override
   public void onEnableHook() {
      visualSupport3.v1(this.v2.v2(), this.v2.v3(), this.name);
      visualSupport3.v1(true);
      this.addSubscription(this.v2.v1().v1(visualSupport64.class, var0 -> visualSupport3.v5(), 50));
   }

   private void onEnable() {
      visualSupport3.v1(this.volume.getValue() / 100.0F);
      visualSupport3.v2(this.replaceVanilla.getValue());
      visualSupport3.v1(visualSupport4.CRIT, this.category.v8());
      visualSupport3.v1(visualSupport4.KNOCKBACK, this.group.v8());
      visualSupport3.v1(visualSupport4.SWEEP, this.description.v8());
      visualSupport3.v1(visualSupport4.HIT, this.defaultEnabled.v8());
      visualSupport3.v1(visualSupport4.NO_DAMAGE, this.subscriptions.v8());
      visualSupport3.v1(visualSupport4.MACE, this.enableAction.v8());
      visualSupport3.v1(visualSupport4.TOTEM_SELF, this.disableAction.v8());
      visualSupport3.v1(visualSupport4.TOTEM_ENEMY, this.enabled.v8());
      visualSupport3.v1(visualSupport4.EXPLOSION, this.v13.v8());
   }
}
