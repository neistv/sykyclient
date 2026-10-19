package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.hud.OverItemSupport;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "slothighlight",
   displayName = "Slot Highlight",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.slothighlight.description"
)
public final class SlotHighlight extends Module {
   private final EnumSetting<OverItemSupport> v2 = this.settings.add(new EnumSetting<>("style", OverItemSupport.BEHIND));
   private final BooleanSetting[] name = new BooleanSetting[EndCrystalSupport.COUNT];
   private final ColorSetting[] displayName = new ColorSetting[EndCrystalSupport.COUNT];

   public SlotHighlight() {
      for (EndCrystalSupport var2 : EndCrystalSupport.VALUES) {
         if (v1(var2)) {
            int var3 = var2.v3();
            BooleanSetting var4 = this.settings.add(new BooleanSetting(var2.v2(), var2 == EndCrystalSupport.TOTEM));
            this.name[var3] = var4;
            this.displayName[var3] = this.settings.add(new ColorSetting(var2.v2() + "Color", v2(var2)).setCondition(var4));
         }
      }

      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      boolean var1 = false;

      for (int var2 = 0; var2 < EndCrystalSupport.COUNT; var2++) {
         BooleanSetting var3 = this.name[var2];
         ColorSetting var4 = this.displayName[var2];
         int var5 = var3 != null && var4 != null && var3.getValue() ? var4.getValue() : 0;
         utilitiesSupport6.v2[var2] = var5;
         var1 |= var5 >>> 24 != 0;
      }

      utilitiesSupport6.v3 = this.v2.getValue() == OverItemSupport.OVER;
      utilitiesSupport6.v1 = var1;
   }

   private void onDisable() {
      utilitiesSupport6.v1 = false;
   }

   private static boolean v1(EndCrystalSupport var0) {
      return var0 != EndCrystalSupport.ARROW;
   }

   private static int v2(EndCrystalSupport var0) {
      return switch (var0) {
         case GOLDEN_APPLE -> -1593858266;
         case ENCHANTED_GOLDEN_APPLE -> -1596824321;
         case HEALING_POTION -> -1594350557;
         case STRENGTH_POTION -> -1600969693;
         case SPEED_POTION -> -1602441274;
         case XP_BOTTLE -> -1600067534;
         case TOTEM -> -65536;
         case END_CRYSTAL -> -1593873450;
         case OBSIDIAN -> -1606735266;
         case RESPAWN_ANCHOR -> -1601297192;
         case GLOWSTONE -> -1593846449;
         case ARROW -> 0;
         case CROSSBOW -> -1599049668;
         case MACE -> -1601401632;
         case FIREWORK -> -1593872317;
         case ELYTRA -> -1597387562;
         case WIND_CHARGE -> -1598822916;
         case COBWEB -> -1596136472;
         case ENDER_PEARL -> -1609184848;
         case CHORUS_FRUIT -> -1602332734;
      };
   }
}
