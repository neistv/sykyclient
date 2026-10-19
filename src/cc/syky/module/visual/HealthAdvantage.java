package cc.syky.module.visual;

import cc.syky.account.accountSupport19;
import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.hud.hudSupport64;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_1309;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

@ModuleInfo(
   name = "healthring",
   displayName = "Health Advantage",
   category = ModuleCategory.VISUAL,
   group = "Player Info",
   description = "module.healthring.description"
)
public final class HealthAdvantage extends Module implements cloudSupport100 {
   private static final double v2 = 3.4;
   private static final double name = 0.95;
   private static final float displayName = 0.35F;
   private static final float category = 0.8F;
   private final uiRecord14 group;
   private final visualSupport18 description;
   private final EnumSetting<HealthAdvantage.Part1> defaultEnabled = this.settings.add(new EnumSetting<>("who", HealthAdvantage.Part1.TARGET));
   private final BooleanSetting arc = this.settings.add(new BooleanSetting("arc", true));
   private final ColorSetting winColor = this.settings.add(new ColorSetting("winColor", -7667916));
   private final ColorSetting loseColor = this.settings.add(new ColorSetting("loseColor", -62435));

   public HealthAdvantage(uiRecord14 var1, visualSupport18 var2) {
      this.group = var1;
      this.description = var2;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      accountSupport19.v8 = this.group.v2();
      accountSupport19.v2 = true;
      accountSupport19.v3 = this.defaultEnabled.getValue() == HealthAdvantage.Part1.TARGET;
      this.v20();
   }

   private void v20() {
      accountSupport19.v4 = this.arc.getValue();
      accountSupport19.v5 = this.winColor.getValue();
      accountSupport19.v6 = this.loseColor.getValue();
   }

   private void onDisable() {
      accountSupport19.v2 = false;
      accountSupport19.v7 = -1;
      accountSupport19.v4();
   }

   @Override
   public void onResetHook() {
      class_310 var1 = this.group.v2().v1();
      class_746 var2 = var1 == null ? null : var1.field_1724;
      class_1309 var3 = var2 != null && accountSupport19.v3 ? this.description.v1() : null;
      accountSupport19.v7 = var3 == null ? -1 : var3.method_5628();
      accountSupport19.v1(var1 == null ? null : var1.field_1687, var2);
   }

   @Override
   public void onRenderHook() {
      accountSupport19.v4();
   }

   @Override
   public void v1() {
      accountSupport19.v8 = this.group.v2();
      this.v20();
      class_310 var1 = this.group.v2().v1();
      if (var1 != null && var1.field_1724 != null) {
         double var2 = visualSupport9.v7();
         double var4 = visualSupport9.v8();
         double var6 = visualSupport9.v9();
         float var8 = var1.field_1724.method_36454() * (float) (Math.PI / 180.0);
         double var9 = -class_3532.method_15374(var8);
         double var11 = class_3532.method_15362(var8);

         for (int var13 = 0; var13 < 2; var13++) {
            double var14 = var13 == 0 ? -0.95 : 0.95;
            double var16 = var2 + var9 * 3.4 - var11 * var14;
            double var18 = var6 + var11 * 3.4 + var9 * var14;
            float var20 = visualSupport9.v1(var16, var4, var18);
            if (Float.isNaN(var20)) {
               accountSupport19.v3();
               return;
            }

            accountSupport19.v1(var13, var16, var20, var18, var13 == 0 ? 1.0F : -1.0F, var13 == 0 ? 0.35F : 0.8F);
         }
      } else {
         accountSupport19.v3();
      }
   }

   @Override
   public void v2() {
      accountSupport19.v3();
   }

   public static enum Part1 implements hudSupport64 {
      TARGET("Target only"),
      EVERYONE("Every player");

      private final String label;

      private Part1(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
