package cc.syky.module.utilities;

import cc.syky.hud.hudSupport64;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_1847;
import net.minecraft.class_2371;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import org.jetbrains.annotations.Nullable;

public enum EndCrystalSupport implements hudSupport64 {
   GOLDEN_APPLE("Golden Apple", "goldenApple"),
   ENCHANTED_GOLDEN_APPLE("Enchanted Golden Apple", "enchantedGoldenApple"),
   HEALING_POTION("Healing Potion", "healingPotion"),
   STRENGTH_POTION("Strength Potion", "strengthPotion"),
   SPEED_POTION("Speed Potion", "speedPotion"),
   XP_BOTTLE("XP Bottle", "xpBottle"),
   TOTEM("Totem", "totem"),
   END_CRYSTAL("End Crystal", "endCrystal"),
   OBSIDIAN("Obsidian", "obsidian"),
   RESPAWN_ANCHOR("Respawn Anchor", "respawnAnchor"),
   GLOWSTONE("Glowstone", "glowstone"),
   ARROW("Arrow", "arrow"),
   CROSSBOW("Crossbow", "crossbow"),
   MACE("Mace", "mace"),
   FIREWORK("Firework", "firework"),
   ELYTRA("Elytra", "elytra"),
   WIND_CHARGE("Wind Charge", "windCharge"),
   COBWEB("Cobweb", "cobweb"),
   ENDER_PEARL("Ender Pearl", "enderPearl"),
   CHORUS_FRUIT("Chorus Fruit", "chorusFruit");

   public static final List<EndCrystalSupport> VALUES = List.of(values());
   public static final int COUNT = VALUES.size();
   public static final EnumSet<EndCrystalSupport> CONSUMABLES = EnumSet.complementOf(EnumSet.of(CROSSBOW, MACE, ELYTRA));
   private static final int SPLASH = 0;
   private static final int DRINKABLE = 1;
   private static final int LINGERING = 2;
   private static final int FORMS = 3;
   private final String label;
   private final String id;
   private final int slot = this.ordinal();
   @Nullable
   private class_1799[] icons;

   private EndCrystalSupport(String var3, String var4) {
      this.label = var3;
      this.id = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public String v2() {
      return this.id;
   }

   public int v3() {
      return this.slot;
   }

   @Nullable
   public static EndCrystalSupport v1(String var0) {
      for (EndCrystalSupport var2 : VALUES) {
         if (var2.id.equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   public class_1799 v1(int var1) {
      class_1799[] var2 = this.icons;
      if (var2 == null) {
         var2 = new class_1799[3];

         for (int var3 = 0; var3 < 3; var3++) {
            var2[var3] = this.v3(var3);
         }

         this.icons = var2;
      }

      return var2[var1];
   }

   public static int v2(int var0) {
      if ((var0 & 1) != 0) {
         return 0;
      } else if ((var0 & 2) != 0) {
         return 1;
      } else {
         return (var0 & 4) != 0 ? 2 : 1;
      }
   }

   private class_1799 v3(int var1) {
      return switch (this) {
         case GOLDEN_APPLE -> new class_1799(class_1802.field_8463);
         case ENCHANTED_GOLDEN_APPLE -> new class_1799(class_1802.field_8367);
         case HEALING_POTION -> class_1844.method_57400(v4(var1), class_1847.field_8963);
         case STRENGTH_POTION -> class_1844.method_57400(v4(var1), class_1847.field_8978);
         case SPEED_POTION -> class_1844.method_57400(v4(var1), class_1847.field_9005);
         case XP_BOTTLE -> new class_1799(class_1802.field_8287);
         case TOTEM -> new class_1799(class_1802.field_8288);
         case END_CRYSTAL -> new class_1799(class_1802.field_8301);
         case OBSIDIAN -> new class_1799(class_1802.field_8281);
         case RESPAWN_ANCHOR -> new class_1799(class_1802.field_23141);
         case GLOWSTONE -> new class_1799(class_1802.field_8801);
         case ARROW -> new class_1799(class_1802.field_8107);
         case CROSSBOW -> new class_1799(class_1802.field_8399);
         case MACE -> new class_1799(class_1802.field_49814);
         case FIREWORK -> new class_1799(class_1802.field_8639);
         case ELYTRA -> new class_1799(class_1802.field_8833);
         case WIND_CHARGE -> new class_1799(class_1802.field_49098);
         case COBWEB -> new class_1799(class_1802.field_8786);
         case ENDER_PEARL -> new class_1799(class_1802.field_8634);
         case CHORUS_FRUIT -> new class_1799(class_1802.field_8233);
      };
   }

   private static class_1792 v4(int var0) {
      return switch (var0) {
         case 0 -> class_1802.field_8436;
         case 2 -> class_1802.field_8150;
         default -> class_1802.field_8574;
      };
   }

   public static void v1(@Nullable class_1657 var0, int[] var1, int[] var2) {
      Arrays.fill(var1, 0);
      Arrays.fill(var2, 0);
      if (var0 != null) {
         class_2371 var3 = var0.method_31548().method_67533();
         int var4 = 0;

         for (int var5 = var3.size(); var4 < var5; var4++) {
            v1((class_1799)var3.get(var4), var1, var2);
         }

         v1(var0.method_6079(), var1, var2);
      }
   }

   @Nullable
   public static EndCrystalSupport v1(class_1799 var0) {
      if (var0.method_7960()) {
         return null;
      } else {
         class_1792 var1 = var0.method_7909();
         EndCrystalSupport var2 = v1(var1);
         if (var2 != null) {
            return var2;
         } else if (var1 != class_1802.field_8574 && var1 != class_1802.field_8436 && var1 != class_1802.field_8150) {
            return null;
         } else {
            class_1844 var3 = (class_1844)var0.method_58694(class_9334.field_49651);
            if (var3 == null) {
               return null;
            } else {
               for (class_1293 var5 : var3.method_57397()) {
                  int var6 = v1(var5.method_5579());
                  if (var6 >= 0) {
                     return VALUES.get(var6);
                  }
               }

               return null;
            }
         }
      }
   }

   private static void v1(class_1799 var0, int[] var1, int[] var2) {
      if (!var0.method_7960()) {
         int var3 = var0.method_7947();
         class_1792 var4 = var0.method_7909();
         EndCrystalSupport var5 = v1(var4);
         if (var5 != null) {
            var1[var5.slot] = var1[var5.slot] + var3;
         } else if (var4 == class_1802.field_8574) {
            v1(var0, 2, var3, var1, var2);
         } else if (var4 == class_1802.field_8436) {
            v1(var0, 1, var3, var1, var2);
         } else if (var4 == class_1802.field_8150) {
            v1(var0, 4, var3, var1, var2);
         }
      }
   }

   @Nullable
   private static EndCrystalSupport v1(class_1792 var0) {
      if (var0 == class_1802.field_8463) {
         return GOLDEN_APPLE;
      } else if (var0 == class_1802.field_8367) {
         return ENCHANTED_GOLDEN_APPLE;
      } else if (var0 == class_1802.field_8287) {
         return XP_BOTTLE;
      } else if (var0 == class_1802.field_8288) {
         return TOTEM;
      } else if (var0 == class_1802.field_8301) {
         return END_CRYSTAL;
      } else if (var0 == class_1802.field_8281) {
         return OBSIDIAN;
      } else if (var0 == class_1802.field_23141) {
         return RESPAWN_ANCHOR;
      } else if (var0 == class_1802.field_8801) {
         return GLOWSTONE;
      } else if (var0 == class_1802.field_8107 || var0 == class_1802.field_8236 || var0 == class_1802.field_8087) {
         return ARROW;
      } else if (var0 == class_1802.field_8399) {
         return CROSSBOW;
      } else if (var0 == class_1802.field_49814) {
         return MACE;
      } else if (var0 == class_1802.field_8639) {
         return FIREWORK;
      } else if (var0 == class_1802.field_8833) {
         return ELYTRA;
      } else if (var0 == class_1802.field_49098) {
         return WIND_CHARGE;
      } else if (var0 == class_1802.field_8786) {
         return COBWEB;
      } else if (var0 == class_1802.field_8634) {
         return ENDER_PEARL;
      } else {
         return var0 == class_1802.field_8233 ? CHORUS_FRUIT : null;
      }
   }

   private static void v1(class_1799 var0, int var1, int var2, int[] var3, int[] var4) {
      class_1844 var5 = (class_1844)var0.method_58694(class_9334.field_49651);
      if (var5 != null) {
         for (class_1293 var7 : var5.method_57397()) {
            int var8 = v1(var7.method_5579());
            if (var8 >= 0) {
               var3[var8] += var2;
               var4[var8] |= var1;
            }
         }
      }
   }

   private static int v1(class_6880<class_1291> var0) {
      if (var0.method_40225(EndCrystalSupport.Part1.v1)) {
         return HEALING_POTION.slot;
      } else if (var0.method_40225(EndCrystalSupport.Part1.v2)) {
         return STRENGTH_POTION.slot;
      } else {
         return var0.method_40225(EndCrystalSupport.Part1.v3) ? SPEED_POTION.slot : -1;
      }
   }

   public static final class Part1 {
      public static final class_5321<class_1291> v1 = v1(class_1294.field_5915);
      public static final class_5321<class_1291> v2 = v1(class_1294.field_5910);
      public static final class_5321<class_1291> v3 = v1(class_1294.field_5904);

      private Part1() {
      }

      private static class_5321<class_1291> v1(class_6880<class_1291> var0) {
         return (class_5321<class_1291>)var0.method_40230().orElseThrow();
      }
   }
}
