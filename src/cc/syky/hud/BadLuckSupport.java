package cc.syky.hud;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public enum BadLuckSupport implements hudSupport64 {
   ABSORPTION("Absorption", "absorption"),
   UNLUCK("Bad Luck", "unluck"),
   BAD_OMEN("Bad Omen", "bad_omen"),
   BLINDNESS("Blindness", "blindness"),
   BREATH_OF_THE_NAUTILUS("Breath of the Nautilus", "breath_of_the_nautilus"),
   CONDUIT_POWER("Conduit Power", "conduit_power"),
   DARKNESS("Darkness", "darkness"),
   DOLPHINS_GRACE("Dolphin's Grace", "dolphins_grace"),
   FIRE_RESISTANCE("Fire Resistance", "fire_resistance"),
   GLOWING("Glowing", "glowing"),
   HASTE("Haste", "haste"),
   HEALTH_BOOST("Health Boost", "health_boost"),
   HERO_OF_THE_VILLAGE("Hero of the Village", "hero_of_the_village"),
   HUNGER("Hunger", "hunger"),
   INFESTED("Infested", "infested"),
   INVISIBILITY("Invisibility", "invisibility"),
   JUMP_BOOST("Jump Boost", "jump_boost"),
   LEVITATION("Levitation", "levitation"),
   LUCK("Luck", "luck"),
   MINING_FATIGUE("Mining Fatigue", "mining_fatigue"),
   NAUSEA("Nausea", "nausea"),
   NIGHT_VISION("Night Vision", "night_vision"),
   OOZING("Oozing", "oozing"),
   POISON("Poison", "poison"),
   RAID_OMEN("Raid Omen", "raid_omen"),
   REGENERATION("Regeneration", "regeneration"),
   RESISTANCE("Resistance", "resistance"),
   SATURATION("Saturation", "saturation"),
   SLOW_FALLING("Slow Falling", "slow_falling"),
   SLOWNESS("Slowness", "slowness"),
   SPEED("Speed", "speed"),
   STRENGTH("Strength", "strength"),
   TRIAL_OMEN("Trial Omen", "trial_omen"),
   WATER_BREATHING("Water Breathing", "water_breathing"),
   WEAKNESS("Weakness", "weakness"),
   WEAVING("Weaving", "weaving"),
   WIND_CHARGED("Wind Charged", "wind_charged"),
   WITHER("Wither", "wither");

   private static final String VANILLA = "minecraft";
   private static final Map<String, BadLuckSupport> BY_PATH = v3();
   private final String label;
   private final String path;

   private BadLuckSupport(String var3, String var4) {
      this.label = var3;
      this.path = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public String v2() {
      return this.path;
   }

   @Nullable
   public static BadLuckSupport v1(String var0, String var1) {
      return "minecraft".equals(var0) ? BY_PATH.get(var1) : null;
   }

   private static Map<String, BadLuckSupport> v3() {
      BadLuckSupport[] var0 = values();
      HashMap var1 = new HashMap(var0.length * 2);

      for (BadLuckSupport var5 : var0) {
         var1.put(var5.path, var5);
      }

      return var1;
   }
}
