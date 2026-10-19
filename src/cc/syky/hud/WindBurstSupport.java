package cc.syky.hud;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_2396;
import net.minecraft.class_2398;

public enum WindBurstSupport implements hudSupport64 {
   CRITS("Crits", class_2398.field_11205),
   ENCHANT_HIT("Enchant Hit", class_2398.field_11208),
   SWEEP("Sweep", class_2398.field_11227),
   DAMAGE("Damage", class_2398.field_11209),
   TOTEM("Totem", class_2398.field_11220),
   EXPLOSIONS("Explosions", class_2398.field_11236, class_2398.field_11221),
   WIND_BURST("Wind Burst", class_2398.field_47494, class_2398.field_50252, class_2398.field_49140, class_2398.field_49139),
   POTION_SWIRLS("Potion Swirls", class_2398.field_11245, class_2398.field_11226, class_2398.field_11213),
   FIREWORKS("Fireworks", class_2398.field_11248),
   DRAGON_BREATH("Dragon Breath", class_2398.field_11216),
   FLAME("Flame & Lava", class_2398.field_11240, class_2398.field_27783, class_2398.field_22246, class_2398.field_11239),
   SMOKE("Smoke", class_2398.field_11251, class_2398.field_11237),
   BLOCKS("Block Dust", class_2398.field_11217, class_2398.field_35434, class_2398.field_11206),
   ENDER_PEARL("Portal & Pearl", class_2398.field_11214, class_2398.field_23190);

   private final String label;
   private final class_2396<?>[] types;

   private WindBurstSupport(String var3, class_2396<?>... var4) {
      this.label = var3;
      this.types = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public static Set<class_2396<?>> v1(Collection<WindBurstSupport> var0) {
      if (var0.isEmpty()) {
         return Set.of();
      } else {
         HashSet var1 = new HashSet();

         for (WindBurstSupport var3 : var0) {
            for (class_2396 var7 : var3.types) {
               var1.add(var7);
            }
         }

         return var1;
      }
   }
}
