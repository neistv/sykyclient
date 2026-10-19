package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.WindBurstSupport;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import java.util.EnumSet;
import java.util.Set;
import net.minecraft.class_2396;

@ModuleInfo(
   name = "removals",
   displayName = "Removals",
   category = ModuleCategory.VISUAL,
   group = "View & Motion",
   description = "module.removals.description"
)
public final class Removals extends Module {
   private final BooleanSetting viewBob = this.settings.add(new BooleanSetting("viewBob", true));
   private final BooleanSetting keepHandBob = this.settings.add(new BooleanSetting("keepHandBob", false), SettingCondition.v1(this.viewBob));
   private final BooleanSetting hurtCamera = this.settings.add(new BooleanSetting("hurtCamera", true));
   private final BooleanSetting dynamicFov = this.settings.add(new BooleanSetting("dynamicFov", true));
   private final BooleanSetting vignette = this.settings.add(new BooleanSetting("vignette", true));
   private final BooleanSetting portalOverlay = this.settings.add(new BooleanSetting("portalOverlay", false));
   private final BooleanSetting toasts = this.settings.add(new BooleanSetting("toasts", false));
   private final BooleanSetting entityShadow = this.settings.add(new BooleanSetting("entityShadow", true));
   private final BooleanSetting stuckArrows = this.settings.add(new BooleanSetting("stuckArrows", false));
   private final visualSupport6<WindBurstSupport> disableAction = this.settings
      .add(new visualSupport6<>("particles", WindBurstSupport.class, EnumSet.noneOf(WindBurstSupport.class)));
   private EnumSet<WindBurstSupport> enabled = EnumSet.noneOf(WindBurstSupport.class);
   private Set<class_2396<?>> v13 = Set.of();

   public Removals() {
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      visualSupport21.v1 = this.viewBob.getValue();
      visualSupport21.v2 = this.keepHandBob.getValue();
      visualSupport21.v3 = this.hurtCamera.getValue();
      visualSupport21.v4 = this.dynamicFov.getValue();
      visualSupport21.v5 = this.vignette.getValue();
      visualSupport21.v6 = this.portalOverlay.getValue();
      visualSupport21.v9 = this.toasts.getValue();
      visualSupport21.v7 = this.entityShadow.getValue();
      visualSupport21.v8 = this.stuckArrows.getValue();
      EnumSet var1 = this.disableAction.v9();
      if (!var1.equals(this.enabled)) {
         this.enabled = EnumSet.copyOf(var1);
         this.v13 = WindBurstSupport.v1(var1);
      }

      visualSupport21.v13 = this.v13;
      visualSupport21.v12 = !this.v13.isEmpty();
      visualSupport21.v10 = var1.contains(WindBurstSupport.BLOCKS);
      visualSupport21.v11 = var1.contains(WindBurstSupport.EXPLOSIONS);
   }

   private void onDisable() {
      visualSupport21.v1 = false;
      visualSupport21.v2 = false;
      visualSupport21.v3 = false;
      visualSupport21.v4 = false;
      visualSupport21.v5 = false;
      visualSupport21.v6 = false;
      visualSupport21.v9 = false;
      visualSupport21.v7 = false;
      visualSupport21.v8 = false;
      visualSupport21.v12 = false;
      visualSupport21.v10 = false;
      visualSupport21.v11 = false;
      visualSupport21.v13 = Set.of();
   }
}
