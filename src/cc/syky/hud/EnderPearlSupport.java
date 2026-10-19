package cc.syky.hud;

import net.minecraft.class_1297;
import net.minecraft.class_1536;
import net.minecraft.class_1667;
import net.minecraft.class_1671;
import net.minecraft.class_1679;
import net.minecraft.class_1680;
import net.minecraft.class_1681;
import net.minecraft.class_1683;
import net.minecraft.class_1684;
import net.minecraft.class_1685;
import net.minecraft.class_1686;
import net.minecraft.class_8956;
import org.jetbrains.annotations.Nullable;

public enum EnderPearlSupport implements hudSupport64 {
   ENDER_PEARL("Ender Pearl"),
   SNOWBALL("Snowball"),
   EGG("Egg"),
   ARROW("Arrows"),
   TRIDENT("Trident"),
   FIREWORK("Firework"),
   WIND_CHARGE("Wind Charge"),
   XP_BOTTLE("XP Bottle"),
   POTION("Potions"),
   FISHING_BOBBER("Fishing Bobber");

   private final String label;

   private EnderPearlSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }

   @Nullable
   public static EnderPearlSupport v1(class_1297 var0) {
      if (var0 instanceof class_1684) {
         return ENDER_PEARL;
      } else if (var0 instanceof class_1680) {
         return SNOWBALL;
      } else if (var0 instanceof class_1681) {
         return EGG;
      } else if (var0 instanceof class_1667 || var0 instanceof class_1679) {
         return ARROW;
      } else if (var0 instanceof class_1685) {
         return TRIDENT;
      } else if (var0 instanceof class_1671) {
         return FIREWORK;
      } else if (var0 instanceof class_8956) {
         return WIND_CHARGE;
      } else if (var0 instanceof class_1683) {
         return XP_BOTTLE;
      } else if (var0 instanceof class_1686) {
         return POTION;
      } else {
         return var0 instanceof class_1536 ? FISHING_BOBBER : null;
      }
   }
}
