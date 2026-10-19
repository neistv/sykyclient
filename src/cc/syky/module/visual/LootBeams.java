package cc.syky.module.visual;

import cc.syky.account.accountSupport18;
import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_1814;
import net.minecraft.class_310;
import net.minecraft.class_3532;

@ModuleInfo(
   name = "lootbeams",
   displayName = "Loot Beams",
   category = ModuleCategory.VISUAL,
   group = "Entities & Items",
   description = "module.lootbeams.description"
)
public final class LootBeams extends Module implements cloudSupport100 {
   private static final double v2 = 4.5;
   private static final double name = 1.3;
   private static final class_1814[] displayName = class_1814.values();
   private final uiRecord14 category;
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -1642753));
   private final BooleanSetting rarity = this.settings.add(new BooleanSetting("rarity", true));
   private final FloatSetting height = this.settings.add(new FloatSetting("height", 3.0F, 1.0F, 8.0F).setSuffix(" blocks"));

   public LootBeams(uiRecord14 var1) {
      this.category = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      accountSupport18.v6 = this.category.v2();
      accountSupport18.v2 = true;
      this.v21();
   }

   private void onDisable() {
      accountSupport18.v2 = false;
      accountSupport18.v4();
   }

   private void v21() {
      accountSupport18.v3 = this.color.getValue();
      accountSupport18.v4 = this.rarity.getValue();
      accountSupport18.v5 = this.height.getValue();
   }

   @Override
   public void onResetHook() {
      accountSupport18.v1(this.category.v2().v1());
   }

   @Override
   public void onRenderHook() {
      accountSupport18.v4();
   }

   @Override
   public void v1() {
      accountSupport18.v6 = this.category.v2();
      this.v21();
      class_310 var1 = this.category.v2().v1();
      if (var1 != null && var1.field_1724 != null) {
         double var2 = visualSupport9.v7();
         double var4 = visualSupport9.v8();
         double var6 = visualSupport9.v9();
         float var8 = var1.field_1724.method_36454() * (float) (Math.PI / 180.0);
         double var9 = -class_3532.method_15374(var8);
         double var11 = class_3532.method_15362(var8);

         for (int var13 = 0; var13 < displayName.length; var13++) {
            double var14 = (var13 - (displayName.length - 1) * 0.5) * 1.3;
            double var16 = var2 + var9 * 4.5 - var11 * var14;
            double var18 = var6 + var11 * 4.5 + var9 * var14;
            float var20 = visualSupport9.v1(var16, var4, var18);
            if (Float.isNaN(var20)) {
               accountSupport18.v3();
               return;
            }

            accountSupport18.v1(var13, var16, var20, var18, displayName[var13].ordinal());
         }
      } else {
         accountSupport18.v3();
      }
   }

   @Override
   public void v2() {
      accountSupport18.v3();
   }
}
