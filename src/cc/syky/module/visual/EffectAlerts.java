package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.FloatSetting;
import cc.syky.config.HoldSupport;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_310;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "effectalerts",
   displayName = "Effect Alerts",
   category = ModuleCategory.VISUAL,
   group = "Hit Feedback",
   description = "module.effectalerts.description"
)
public final class EffectAlerts extends Module implements cloudSupport100 {
   private static final long v2 = 1400000000L;
   private static final long name = 1000000000L;
   private final uiRecord14 displayName;
   private final FloatSetting radius = this.settings.add(new FloatSetting("radius", 0.4F, 0.0F, 0.95F));
   private final HoldSupport group = HoldSupport.v1(this.settings, "noStrength", true, 1728044078);
   private final IntSetting description = this.v1(this.group);
   private final IntSetting noStrengthMemory = this.settings.add(new IntSetting("noStrengthMemory", 180, 10, 900).v1("s"), SettingCondition.v1(this.group.v2));
   private final HoldSupport subscriptions = HoldSupport.v1(this.settings, "lowHealth", true, 1724912917, true);
   private final IntSetting lowHealthBelow = this.settings
      .add(new IntSetting("lowHealthBelow", 4, 2, 10).v1(" hearts"), SettingCondition.v1(this.subscriptions.v2));
   private final HoldSupport disableAction = HoldSupport.v1(this.settings, "weakness", true, 1721409710, false);
   private final IntSetting enabled = this.v1(this.disableAction);
   private final HoldSupport v13 = HoldSupport.v1(this.settings, "slowness", true, 1720430560, false);
   private final IntSetting v14 = this.v1(this.v13);
   private final HoldSupport v15 = HoldSupport.v1(this.settings, "poison", true, 1720173130, false);
   private final IntSetting v16 = this.v1(this.v15);
   private final HoldSupport v18 = HoldSupport.v1(this.settings, "burning", true, 1728018970, true);
   private final HoldSupport v19 = HoldSupport.v1(this.settings, "absorption", true, 1442828860, true);
   private final HoldSupport v17 = HoldSupport.v1(this.settings, "hunger", false, 1718324794, false);
   private final IntSetting v20 = this.v1(this.v17);
   private final HoldSupport[] v21 = new HoldSupport[]{this.group, this.subscriptions, this.disableAction, this.v13, this.v15, this.v18, this.v19, this.v17};
   @Nullable
   private class_746 v22;
   private long v24;
   @Nullable
   private String v25;
   private long v26;
   private int v27;

   public EffectAlerts(uiRecord14 var1) {
      this.displayName = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   @Override
   public void onEnableHook() {
      this.addSubscription(this.displayName.v1().v1(visualSupport64.class, this::v1, 0));
   }

   @Override
   public void onRenderHook() {
      this.v21();
   }

   @Override
   public void onResetHook() {
      class_310 var1 = this.displayName.v2().v1();
      class_746 var2 = var1 == null ? null : var1.field_1724;
      if (var2 != null) {
         boolean var3 = var2 == this.v22;
         this.v22 = var2;
         if (var2.method_6059(class_1294.field_5910)) {
            this.v24 = System.nanoTime();
         }

         this.subscriptions.v1(var2.method_5805() && var2.method_6032() < this.lowHealthBelow.getValue().intValue() * 2.0F, var3);
         this.disableAction.v1(v1(var2, class_1294.field_5911) >= this.enabled.getValue(), var3);
         this.v13.v1(v1(var2, class_1294.field_5909) >= this.v14.getValue(), var3);
         this.v15.v1(v1(var2, class_1294.field_5899) >= this.v16.getValue(), var3);
         this.v18.v1(var2.method_5809() && !var2.method_6059(class_1294.field_5918), var3);
         this.v19.v1(var2.method_6067() > 0.0F, var3);
         this.v17.v1(v1(var2, class_1294.field_5903) >= this.v20.getValue(), var3);
      }
   }

   private IntSetting v1(HoldSupport var1) {
      return this.settings.add(new IntSetting(var1.v1 + "Level", 1, 1, 10), SettingCondition.v1(var1.v2));
   }

   private boolean v1(class_746 var1) {
      int var2 = v1(var1, class_1294.field_5910);
      if (var2 >= this.description.getValue()) {
         return false;
      } else {
         return var2 > 0 ? true : this.v24 != 0L && System.nanoTime() - this.v24 <= this.noStrengthMemory.getValue().intValue() * 1000000000L;
      }
   }

   private static int v1(class_746 var0, class_6880<class_1291> var1) {
      class_1293 var2 = var0.method_6112(var1);
      return var2 == null ? 0 : var2.method_5578() + 1;
   }

   private void v1(visualSupport64 var1) {
      class_310 var2 = this.displayName.v2().v1();
      class_746 var3 = var2 == null ? null : var2.field_1724;
      if (var3 != null && var1.v1() instanceof class_1309 var4 && var4 != var3 && var4.method_5805()) {
         if (this.v1(var3)) {
            this.group.v1();
         }
      }
   }

   private void onEnable() {
      visualSupport34.v1 = this.v21;
      visualSupport34.v4 = this.radius.getValue();
      visualSupport34.v2 = true;
   }

   private void onDisable() {
      visualSupport34.v2 = false;
      this.v21();
   }

   private void v21() {
      this.v22 = null;
      this.v24 = 0L;

      for (HoldSupport var4 : this.v21) {
         var4.v2();
      }
   }

   @Override
   public void v1(@Nullable String var1) {
      this.v25 = var1;
   }

   @Override
   public void v1() {
      if (!this.isEnabled()) {
         visualSupport34.v1 = this.v21;
         visualSupport34.v4 = this.radius.getValue();
      }

      visualSupport34.v3 = true;
      HoldSupport var1 = this.v22();

      for (HoldSupport var5 : this.v21) {
         var5.v1(var5 == var1);
      }

      long var6 = System.nanoTime();
      if (var1 != null && (this.v26 == 0L || var6 - this.v26 >= 1400000000L)) {
         this.v26 = var6;
         this.v27++;
         var1.v1();
      }
   }

   @Override
   public void v2() {
      visualSupport34.v3 = false;
      this.v26 = 0L;

      for (HoldSupport var4 : this.v21) {
         var4.v1(false);
      }
   }

   @Nullable
   private HoldSupport v22() {
      if (this.v25 != null) {
         for (HoldSupport var13 : this.v21) {
            if (var13.v1.equals(this.v25)) {
               return var13.v2.getValue() ? var13 : null;
            }
         }

         return null;
      } else {
         int var1 = 0;

         for (HoldSupport var5 : this.v21) {
            if (var5.v2.getValue()) {
               var1++;
            }
         }

         if (var1 == 0) {
            return null;
         } else {
            int var8 = Math.floorMod(this.v27, var1);

            for (HoldSupport var6 : this.v21) {
               if (var6.v2.getValue() && var8-- == 0) {
                  return var6;
               }
            }

            return null;
         }
      }
   }
}
