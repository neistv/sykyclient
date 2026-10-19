package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.EnumSetting;
import cc.syky.config.IntSetting;
import cc.syky.hud.hudSupport60;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "time",
   displayName = "Time Changer",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.time.description"
)
public final class TimeChanger extends Module {
   private static final long name = 24000L;
   private static final long displayName = 1200L;
   public static final visualSupport57 v2 = new visualSupport57(2.5F);
   private final EnumSetting<visualSupport15> category = this.settings.add(new EnumSetting<>("mode", visualSupport15.MIDNIGHT));
   private final IntSetting time = this.settings.add(new IntSetting("time", 18000, 0, 24000));
   @Nullable
   private visualSupport15 description;
   private int defaultEnabled;
   private long subscriptions;
   private long enableAction = -1L;
   private long disableAction;
   private long enabled;
   @Nullable
   private visualSupport2 v13;

   public TimeChanger() {
   }

   @Override
   public void onEnableHook() {
      this.v1(this.category.getValue());
      this.description = this.category.getValue();
      this.defaultEnabled = this.time.getValue();
      this.enableAction = this.time.getValue().intValue();
      this.subscriptions = this.enableAction;
      this.v13 = null;
      v2.v1(true);
      this.v20();
   }

   @Override
   public void onTickHook() {
      v2.v1();
   }

   @Override
   public void onDisableHook() {
      v2.v1(false);
      this.v13 = null;
      this.enableAction = -1L;
   }

   @Override
   public void onResetHook() {
      this.v17();
      long var1 = this.time.getValue().intValue();
      if (this.category.getValue() == visualSupport15.CUSTOM) {
         this.subscriptions = var1;
         this.enableAction = var1;
         this.v13 = null;
      } else {
         if (var1 != this.enableAction) {
            this.enableAction = var1;
            this.disableAction = this.subscriptions;
            this.enabled = Math.floorMod(var1 - this.disableAction, 24000L);
            this.v13 = this.enabled == 0L ? null : new visualSupport2(1200L, hudSupport60::v5);
         }

         if (this.v13 != null) {
            long var3 = Math.round((double)this.enabled * this.v13.v1());
            this.subscriptions = Math.floorMod(this.disableAction + var3, 24000L);
            if (this.v13.v2()) {
               this.subscriptions = this.enableAction;
               this.v13 = null;
            }
         }
      }

      this.v20();
   }

   private void v17() {
      visualSupport15 var1 = this.category.getValue();
      if (var1 != this.description) {
         this.description = var1;
         if (var1 != visualSupport15.CUSTOM) {
            this.v1(var1);
            this.defaultEnabled = this.time.getValue();
         }
      } else if (this.time.getValue() != this.defaultEnabled) {
         this.defaultEnabled = this.time.getValue();
         if (var1 != visualSupport15.CUSTOM) {
            this.category.setValue(visualSupport15.CUSTOM);
            this.description = visualSupport15.CUSTOM;
         }
      }
   }

   private void v1(visualSupport15 var1) {
      if (var1 != visualSupport15.CUSTOM) {
         this.time.setValue((int)var1.v1());
      }
   }

   private void v20() {
      visualSupport51.v19 = this.subscriptions;
   }
}
