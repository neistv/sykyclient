package cc.syky.module.visual;

import cc.syky.account.accountSupport16;
import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.EnderPearlSupport;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport243;
import cc.syky.ui.uiSupport244;
import java.util.EnumSet;
import net.minecraft.class_1297;
import net.minecraft.class_1676;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "particles",
   displayName = "Particles",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.particles.description"
)
public final class Particles extends Module implements cloudSupport100 {
   private static final String v2 = "dust";
   private static final String name = "hit";
   private static final String displayName = "trail";
   private final uiRecord14 category;
   @Nullable
   private String group;
   private final BooleanSetting description = this.settings.addHidden(new BooleanSetting("dust", true));
   private final IntSetting dustCount = this.settings.add(new IntSetting("dustCount", 14000, 50, 50000), SettingCondition.v1(this.description));
   private final ColorSetting dustColor = this.settings.add(new ColorSetting("dustColor", -10129409), SettingCondition.v1(this.description));
   private final EnumSetting<visualSupport22> enableAction = this.settings
      .add(new EnumSetting<>("dustShape", visualSupport22.ORB), SettingCondition.v1(this.description));
   private final FloatSetting dustSize = this.settings.add(new FloatSetting("dustSize", 0.1F, 0.02F, 0.4F), SettingCondition.v1(this.description));
   private final FloatSetting dustRadius = this.settings.add(new FloatSetting("dustRadius", 96.0F, 4.0F, 128.0F), SettingCondition.v1(this.description));
   private final FloatSetting dustSpeed = this.settings.add(new FloatSetting("dustSpeed", 3.0F, 0.0F, 3.0F), SettingCondition.v1(this.description));
   private final FloatSetting dustTwinkle = this.settings.add(new FloatSetting("dustTwinkle", 0.6F, 0.0F, 1.0F), SettingCondition.v1(this.description));
   private final FloatSetting dustAura = this.settings.add(new FloatSetting("dustAura", 0.4F, 0.0F, 1.0F), SettingCondition.v1(this.description));
   private final BooleanSetting v16 = this.settings.addHidden(new BooleanSetting("hit", true));
   private final BooleanSetting hitOnlyCrit = this.settings.add(new BooleanSetting("hitOnlyCrit", false), SettingCondition.v1(this.v16));
   private final IntSetting hitCount = this.settings.add(new IntSetting("hitCount", 54, 8, 400), SettingCondition.v1(this.v16));
   private final ColorSetting hitColor = this.settings.add(new ColorSetting("hitColor", -10129409), SettingCondition.v1(this.v16));
   private final EnumSetting<visualSupport22> v20 = this.settings.add(new EnumSetting<>("hitShape", visualSupport22.ORB), SettingCondition.v1(this.v16));
   private final FloatSetting hitSize = this.settings.add(new FloatSetting("hitSize", 0.06F, 0.02F, 0.4F), SettingCondition.v1(this.v16));
   private final FloatSetting hitSpeed = this.settings.add(new FloatSetting("hitSpeed", 7.5F, 0.5F, 20.0F), SettingCondition.v1(this.v16));
   private final FloatSetting hitGravity = this.settings.add(new FloatSetting("hitGravity", 1.4F, 0.0F, 32.0F), SettingCondition.v1(this.v16));
   private final FloatSetting hitLife = this.settings.add(new FloatSetting("hitLife", 0.9F, 0.15F, 3.0F), SettingCondition.v1(this.v16));
   private final FloatSetting hitSpread = this.settings.add(new FloatSetting("hitSpread", 1.0F, 0.0F, 1.0F), SettingCondition.v1(this.v16));
   private final FloatSetting hitAura = this.settings.add(new FloatSetting("hitAura", 0.35F, 0.0F, 1.0F), SettingCondition.v1(this.v16));
   private final BooleanSetting v28 = this.settings.addHidden(new BooleanSetting("trail", true));
   private final visualSupport6<EnderPearlSupport> v29 = this.settings
      .add(
         new visualSupport6<>(
            "trailTargets",
            EnderPearlSupport.class,
            EnumSet.of(
               EnderPearlSupport.ENDER_PEARL,
               EnderPearlSupport.SNOWBALL,
               EnderPearlSupport.EGG,
               EnderPearlSupport.ARROW,
               EnderPearlSupport.TRIDENT,
               EnderPearlSupport.FIREWORK,
               EnderPearlSupport.WIND_CHARGE
            )
         ),
         SettingCondition.v1(this.v28)
      );
   private final IntSetting trailCount = this.settings.add(new IntSetting("trailCount", 3, 1, 32), SettingCondition.v1(this.v28));
   private final FloatSetting trailDensity = this.settings.add(new FloatSetting("trailDensity", 8.0F, 0.5F, 8.0F), SettingCondition.v1(this.v28));
   private final ColorSetting trailColor = this.settings.add(new ColorSetting("trailColor", -10129409), SettingCondition.v1(this.v28));
   private final EnumSetting<visualSupport22> v33 = this.settings.add(new EnumSetting<>("trailShape", visualSupport22.ORB), SettingCondition.v1(this.v28));
   private final FloatSetting trailSize = this.settings.add(new FloatSetting("trailSize", 0.085F, 0.02F, 0.4F), SettingCondition.v1(this.v28));
   private final FloatSetting trailLife = this.settings.add(new FloatSetting("trailLife", 1.2F, 0.1F, 3.0F), SettingCondition.v1(this.v28));
   private final FloatSetting trailDrift = this.settings.add(new FloatSetting("trailDrift", 3.0F, 0.0F, 6.0F), SettingCondition.v1(this.v28));
   private final FloatSetting trailGravity = this.settings.add(new FloatSetting("trailGravity", 1.25F, -8.0F, 24.0F), SettingCondition.v1(this.v28));
   private final FloatSetting trailSpread = this.settings.add(new FloatSetting("trailSpread", 1.0F, 0.0F, 1.0F), SettingCondition.v1(this.v28));
   private final FloatSetting trailAura = this.settings.add(new FloatSetting("trailAura", 0.4F, 0.0F, 1.0F), SettingCondition.v1(this.v28));

   public Particles(uiRecord14 var1) {
      this.category = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      this.v21();
      visualSupport24.v1 = this.description.getValue();
      visualSupport23.v1 = this.v16.getValue();
      accountSupport16.v1 = this.v28.getValue();
   }

   private void onDisable() {
      visualSupport24.v1 = false;
      visualSupport23.v1 = false;
      visualSupport23.v4();
      accountSupport16.v1 = false;
      accountSupport16.v5();
   }

   private void v21() {
      visualSupport24.v3 = this.dustCount.getValue();
      visualSupport24.v4 = this.dustColor.getValue();
      visualSupport24.v10 = this.enableAction.getValue();
      visualSupport24.v5 = this.dustSize.getValue();
      visualSupport24.v6 = this.dustRadius.getValue();
      visualSupport24.v7 = this.dustSpeed.getValue();
      visualSupport24.v8 = this.dustTwinkle.getValue();
      visualSupport24.v9 = this.dustAura.getValue();
      visualSupport23.v3 = this.hitCount.getValue();
      visualSupport23.v4 = this.hitColor.getValue();
      visualSupport23.v11 = this.v20.getValue();
      visualSupport23.v5 = this.hitSize.getValue();
      visualSupport23.v7 = this.hitSpeed.getValue();
      visualSupport23.v8 = this.hitGravity.getValue();
      visualSupport23.v6 = this.hitLife.getValue();
      visualSupport23.v9 = this.hitSpread.getValue();
      visualSupport23.v10 = this.hitAura.getValue();
      accountSupport16.v3 = this.trailCount.getValue();
      accountSupport16.v4 = this.trailDensity.getValue();
      accountSupport16.v5 = this.trailColor.getValue();
      accountSupport16.v12 = this.v33.getValue();
      accountSupport16.v6 = this.trailSize.getValue();
      accountSupport16.v7 = this.trailLife.getValue();
      accountSupport16.v8 = this.trailDrift.getValue();
      accountSupport16.v9 = this.trailGravity.getValue();
      accountSupport16.v10 = this.trailSpread.getValue();
      accountSupport16.v11 = this.trailAura.getValue();
   }

   @Override
   public void onEnableHook() {
      visualSupport24.v2();
      visualSupport23.v4();
      accountSupport16.v5();
      visualSupport25.v1();
      this.addSubscription(this.category.v1().v1(visualSupport64.class, this::v1, 30));
      this.addSubscription(this.category.v1().v1(uiSupport243.class, this::v1, 30));
      this.addSubscription(this.category.v1().v1(uiSupport244.class, this::v1, 30));
   }

   @Override
   public void onTickHook() {
      visualSupport24.v2();
      visualSupport23.v4();
      accountSupport16.v5();
      visualSupport25.v1();
   }

   @Override
   public void onRenderHook() {
      visualSupport24.v2();
      visualSupport23.v4();
      accountSupport16.v5();
      visualSupport25.v1();
   }

   @Override
   public void onResetHook() {
      if (this.v28.getValue()) {
         class_310 var1 = this.category.v2().v1();
         class_638 var2 = var1 == null ? null : var1.field_1687;
         class_746 var3 = var1 == null ? null : var1.field_1724;
         if (var2 != null && var3 != null) {
            accountSupport16.v1();

            for (class_1297 var5 : var2.method_18112()) {
               if (!var5.method_31481() && var5 instanceof class_1676 var6) {
                  EnderPearlSupport var7 = EnderPearlSupport.v1(var6);
                  if (var7 != null && this.v29.v1(var7) && var6.method_24921() == var3) {
                     accountSupport16.v1(var6.field_6014, var6.field_6036, var6.field_5969, var6.method_23317(), var6.method_23318(), var6.method_23321());
                  }
               }
            }
         }
      }
   }

   private void v1(visualSupport64 var1) {
      if (this.v16.getValue()) {
         class_310 var2 = this.category.v2().v1();
         class_1297 var3 = var1.v1();
         if (var2 != null && var3 != null) {
            class_746 var4 = var2.field_1724;
            if (var4 != null && var3 != var4) {
               if (!this.hitOnlyCrit.getValue()) {
                  if (!visualSupport44.v2(var3)) {
                     v1(var4, var3);
                  }
               }
            }
         }
      }
   }

   private void v1(uiSupport243 var1) {
      if (this.v16.getValue() && this.hitOnlyCrit.getValue()) {
         class_310 var2 = this.category.v2().v1();
         class_746 var3 = var2 == null ? null : var2.field_1724;
         if (var3 != null) {
            visualSupport25.v1(var1.v1(), var1.v2() == var3.method_5628());
         }
      }
   }

   private void v1(uiSupport244 var1) {
      if (this.v16.getValue() && this.hitOnlyCrit.getValue()) {
         class_310 var2 = this.category.v2().v1();
         class_638 var3 = var2 == null ? null : var2.field_1687;
         class_746 var4 = var2 == null ? null : var2.field_1724;
         if (var3 != null && var4 != null) {
            if (visualSupport25.v1(var1.v1()) && !visualSupport44.v1(var1.v1())) {
               class_1297 var5 = var3.method_8469(var1.v1());
               if (var5 != null && var5 != var4) {
                  v1(var4, var5);
               }
            }
         }
      }
   }

   private static void v1(class_746 var0, class_1297 var1) {
      double var2 = var1.method_23318() + var1.method_17682() * 0.5;
      double var4 = var1.method_23317() - var0.method_23317();
      double var6 = var1.method_23321() - var0.method_23321();
      double var8 = Math.sqrt(var4 * var4 + var6 * var6);
      float var10 = var8 > 1.0E-4 ? (float)(var4 / var8) : 0.0F;
      float var11 = var8 > 1.0E-4 ? (float)(var6 / var8) : 0.0F;
      visualSupport23.v1(var1.method_23317(), var2, var1.method_23321(), var10, 0.45F, var11);
   }

   @Override
   public void v1(@Nullable String var1) {
      this.group = var1;
   }

   @Override
   public void v1() {
      this.v21();
      boolean var1 = this.description.getValue() && (this.group == null || "dust".equals(this.group));
      boolean var2 = this.v16.getValue() && "hit".equals(this.group);
      boolean var3 = this.v28.getValue() && "trail".equals(this.group);
      visualSupport24.v2 = var1;
      if (!var2) {
         visualSupport23.v3();
      }

      if (!var3) {
         accountSupport16.v4();
      }

      if (var2 || var3) {
         class_310 var4 = this.category.v2().v1();
         class_746 var5 = var4 == null ? null : var4.field_1724;
         if (var5 != null) {
            float var6 = var5.method_36455() * (float) (Math.PI / 180.0);
            float var7 = -var5.method_36454() * (float) (Math.PI / 180.0);
            float var8 = class_3532.method_15362(var6);
            float var9 = class_3532.method_15374(var7) * var8;
            float var10 = -class_3532.method_15374(var6);
            float var11 = class_3532.method_15362(var7) * var8;
            if (var2) {
               visualSupport23.v2 = true;
               visualSupport23.v2(var5.method_23317(), var5.method_23320(), var5.method_23321(), var9, var10, var11);
            }

            if (var3) {
               accountSupport16.v2 = true;
               accountSupport16.v1(var5.method_23317(), var5.method_23320(), var5.method_23321(), var9, var10, var11);
            }
         }
      }
   }

   @Override
   public void v2() {
      this.group = null;
      visualSupport24.v2 = false;
      visualSupport23.v3();
      accountSupport16.v4();
   }
}
