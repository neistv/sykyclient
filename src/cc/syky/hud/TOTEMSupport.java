package cc.syky.hud;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TOTEMSupport {
   private static final Logger v3 = LoggerFactory.getLogger("syky.settings.migrate");
   public static final String v1 = "_schema";
   private static final List<Consumer<JsonObject>> v4 = List.of(
      TOTEMSupport::v3,
      TOTEMSupport::v4,
      TOTEMSupport::v5,
      TOTEMSupport::v6,
      TOTEMSupport::v7,
      TOTEMSupport::v8,
      TOTEMSupport::v9,
      TOTEMSupport::v10,
      TOTEMSupport::v11,
      TOTEMSupport::v12,
      TOTEMSupport::v13,
      TOTEMSupport::v14,
      TOTEMSupport::v15,
      TOTEMSupport::v16,
      TOTEMSupport::v19,
      TOTEMSupport::v17,
      TOTEMSupport::v20,
      TOTEMSupport::v21,
      TOTEMSupport::v22,
      TOTEMSupport::v24
   );
   public static final int v2 = v4.size();
   private static final List<String> v5 = List.of("hideName", "hideSkin", "hideCoords", "hideServerIp");
   private static final List<String> v6 = List.of("hideBedrock", "hideRotation", "hideOres", "hideStoneVariants", "hideBiomeColors", "hideClouds");
   private static final Map<String, String> v7 = Map.ofEntries(
      Map.entry("GOLDEN_APPLE", "goldenApple"),
      Map.entry("ENCHANTED_GOLDEN_APPLE", "enchantedGoldenApple"),
      Map.entry("HEALING_POTION", "healingPotion"),
      Map.entry("STRENGTH_POTION", "strengthPotion"),
      Map.entry("SPEED_POTION", "speedPotion"),
      Map.entry("XP_BOTTLE", "xpBottle"),
      Map.entry("TOTEM", "totem"),
      Map.entry("END_CRYSTAL", "endCrystal"),
      Map.entry("OBSIDIAN", "obsidian"),
      Map.entry("RESPAWN_ANCHOR", "respawnAnchor"),
      Map.entry("GLOWSTONE", "glowstone"),
      Map.entry("ARROW", "arrow"),
      Map.entry("FIREWORK", "firework"),
      Map.entry("WIND_CHARGE", "windCharge"),
      Map.entry("COBWEB", "cobweb"),
      Map.entry("ENDER_PEARL", "enderPearl"),
      Map.entry("CHORUS_FRUIT", "chorusFruit")
   );
   private static final List<String> v8 = List.of(
      "GOLDEN_APPLE",
      "ENCHANTED_GOLDEN_APPLE",
      "HEALING_POTION",
      "STRENGTH_POTION",
      "SPEED_POTION",
      "XP_BOTTLE",
      "TOTEM",
      "END_CRYSTAL",
      "ARROW",
      "FIREWORK",
      "WIND_CHARGE",
      "COBWEB",
      "ENDER_PEARL",
      "CHORUS_FRUIT"
   );
   private static final int v9 = -60653;

   private TOTEMSupport() {
   }

   public static boolean v1(JsonObject var0) {
      return v1(var0, v4, v2);
   }

   public static boolean v1(JsonObject var0, List<Consumer<JsonObject>> var1, int var2) {
      int var3 = v2(var0);
      if (var3 >= var2) {
         return false;
      } else {
         for (int var4 = var3; var4 < var2; var4++) {
            ((Consumer)var1.get(var4)).accept(var0);
         }

         var0.addProperty("_schema", var2);
         if (v3.isInfoEnabled()) {
            v3.info("migrated config schema {} -> {}", var3, var2);
         }

         return true;
      }
   }

   public static int v2(JsonObject var0) {
      if (var0.has("_schema") && var0.get("_schema").isJsonPrimitive()) {
         try {
            return Math.max(0, var0.get("_schema").getAsInt());
         } catch (RuntimeException var2) {
         }
      }

      return 0;
   }

   private static void v3(JsonObject var0) {
      if (var0.has("hurtcolor") && var0.get("hurtcolor").isJsonObject()) {
         var0.getAsJsonObject("hurtcolor").remove("gear");
      }
   }

   private static void v4(JsonObject var0) {
      if (var0.has("shield") && var0.get("shield").isJsonObject()) {
         var0.getAsJsonObject("shield").remove("noShieldDelay");
      }
   }

   private static void v5(JsonObject var0) {
      if (var0.has("weather") && var0.get("weather").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("weather");
         JsonElement var2 = var1.get("mode");
         if (var2 != null && var2.isJsonPrimitive() && "OFF".equals(var2.getAsString())) {
            var1.remove("mode");
            var1.addProperty("_enabled", false);
         }
      }
   }

   private static void v6(JsonObject var0) {
      if (var0.has("worldtint") && var0.get("worldtint").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("worldtint");
         JsonElement var2 = var1.get("color");
         if (var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString()) {
            String var3 = var2.getAsString().trim();
            if (var3.startsWith("#")) {
               var3 = var3.substring(1);
            }

            if (var3.length() == 8) {
               int var4;
               try {
                  var4 = (int)Long.parseUnsignedLong(var3, 16);
               } catch (NumberFormatException var6) {
                  return;
               }

               var1.addProperty("color", String.format("#%06X", var4 & 16777215));
               var1.addProperty("strength", Math.round((var4 >>> 24 & 0xFF) * 100.0F / 255.0F));
            }
         }
      }
   }

   private static void v7(JsonObject var0) {
      if (var0.has("shield") && var0.get("shield").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("shield");
         v1(var1, "ownDisabledColor");
         v1(var1, "enemyDisabledColor");
      }
   }

   private static void v1(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      if (var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString()) {
         String var3 = var2.getAsString().trim();
         if (var3.startsWith("#")) {
            var3 = var3.substring(1);
         }

         if (var3.length() == 8 && var3.regionMatches(true, 0, "FF", 0, 2)) {
            var0.addProperty(var1, "#99" + var3.substring(2));
         }
      }
   }

   private static void v8(JsonObject var0) {
      if (var0.has("water") && var0.get("water").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("water");
         if (var1.has("fog") || var1.has("hideOverlay")) {
            boolean var2 = !v1(var1, "fog", true) || v1(var1, "hideOverlay", false);
            var1.remove("fog");
            var1.remove("hideOverlay");
            var1.addProperty("hideFog", var2);
         }
      }
   }

   private static void v9(JsonObject var0) {
      if (var0.has("shield") && var0.get("shield").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("shield");
         JsonElement var2 = var1.get("ownDisabledColor");
         if (var2 != null) {
            var1.remove("ownDisabledColor");
            if (!var1.has("disabledColor")) {
               var1.add("disabledColor", var2);
            }
         }

         var1.remove("enemyDisabledColor");
         var1.remove("tintEnemy");
      }
   }

   private static void v10(JsonObject var0) {
      if (var0.has("sky") && var0.get("sky").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("sky");
         v3(var1, "disableSun", "hideSun");
         v3(var1, "disableMoon", "hideMoon");
         v3(var1, "disableStars", "hideStars");
      }
   }

   private static void v11(JsonObject var0) {
      for (String var4 : new String[]{"targetesp", "stardust"}) {
         if (var0.has(var4) && var0.get(var4).isJsonObject()) {
            var0.getAsJsonObject(var4).remove("throughWalls");
         }
      }
   }

   private static void v12(JsonObject var0) {
      v2(var0, "customhitbox", "maxTargets");
      v2(var0, "healthindicator", "maxTargets");
      v2(var0, "pingtags", "maxTargets");
      v2(var0, "tnttimer", "maxLabels");
   }

   private static void v13(JsonObject var0) {
      if (var0.has("healthindicator") && var0.get("healthindicator").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("healthindicator");
         if (!var1.has("customHeartColor")) {
            JsonElement var2 = var1.get("heartColor");
            if (var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString()) {
               Integer var3 = v1(var2.getAsString());
               if (var3 != null && var3 != -60653) {
                  var1.addProperty("customHeartColor", true);
               }
            }
         }
      }
   }

   private static void v14(JsonObject var0) {
      v3(var0, "stardust", "particles");
      if (var0.has("particles") && var0.get("particles").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("particles");

         for (String var5 : new String[]{"count", "color", "shape", "size", "radius", "speed", "twinkle", "aura"}) {
            v3(var1, var5, "dust" + Character.toUpperCase(var5.charAt(0)) + var5.substring(1));
         }
      }

      if (var0.has("_binds") && var0.get("_binds").isJsonObject()) {
         v3(var0.getAsJsonObject("_binds"), "stardust", "particles");
      }
   }

   private static void v15(JsonObject var0) {
      if (var0.has("targetesp") && var0.get("targetesp").isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject("targetesp");
         if (var1.has("shape") && var1.get("shape").isJsonPrimitive() && "STRANDS".equals(var1.get("shape").getAsString())) {
            var1.addProperty("shape", "ORBS");
         }
      }
   }

   private static void v16(JsonObject var0) {
      v18(v2(var0, "_hudstyle_global"));
      JsonObject var1 = v2(var0, "_hudstyle");
      if (var1 != null) {
         for (Entry var3 : var1.entrySet()) {
            if (((JsonElement)var3.getValue()).isJsonObject()) {
               v18(((JsonElement)var3.getValue()).getAsJsonObject());
            }
         }
      }
   }

   private static void v18(@Nullable JsonObject var0) {
      if (var0 != null) {
         v3(var0, "textColor", "mainColor");
         v3(var0, "iconColor", "secondColor");
      }
   }

   private static void v19(JsonObject var0) {
      JsonObject var1 = v2(var0, "colorgrade");
      if (var1 != null && var1.has("brightness")) {
         v1(var1, "brightness", "exposure");
         v1(var1, "contrast", "contrast");
         v1(var1, "saturation", "saturation");
         var1.remove("brightness");
      }
   }

   private static void v17(JsonObject var0) {
      JsonObject var1 = v2(var0, "_hotkeyHud");
      if (var1 != null) {
         JsonArray var2 = new JsonArray();
         JsonObject var3 = v2(var0, "_hudstyle");
         JsonObject var4 = var3 == null ? null : v2(var3, "hotkeys");
         JsonElement var5 = var4 == null ? null : var4.get("modules");
         if (var5 != null && var5.isJsonArray()) {
            var2.addAll(var5.getAsJsonArray());
         }

         for (Entry var7 : var1.entrySet()) {
            JsonElement var8 = (JsonElement)var7.getValue();
            boolean var9 = var8.isJsonPrimitive() && var8.getAsJsonPrimitive().isBoolean() && !var8.getAsBoolean();
            JsonPrimitive var10 = new JsonPrimitive((String)var7.getKey());
            if (var9 && !var2.contains(var10)) {
               var2.add(var10);
            }
         }

         var0.remove("_hotkeyHud");
         if (!var2.isEmpty()) {
            if (var3 == null) {
               var3 = new JsonObject();
               var0.add("_hudstyle", var3);
            }

            if (var4 == null) {
               var4 = new JsonObject();
               var3.add("hotkeys", var4);
            }

            var4.add("modules", var2);
         }
      }
   }

   private static void v20(JsonObject var0) {
      JsonObject var1 = v2(var0, "_hudstyle");
      JsonObject var2 = var1 == null ? null : v2(var1, "item_counter");
      if (var2 != null && var2.has("items")) {
         JsonElement var3 = var2.remove("items");
         if (var3.isJsonObject()) {
            for (Entry var5 : var3.getAsJsonObject().entrySet()) {
               String var6 = v7.get(var5.getKey());
               JsonElement var7 = (JsonElement)var5.getValue();
               if (var6 != null && !var2.has(var6) && var7.isJsonPrimitive() && var7.getAsJsonPrimitive().isBoolean()) {
                  var2.addProperty(var6, var7.getAsBoolean());
               }
            }
         } else if (var3.isJsonArray()) {
            JsonArray var8 = var3.getAsJsonArray();

            for (String var10 : v8) {
               String var11 = v7.get(var10);
               if (var11 != null && !var2.has(var11)) {
                  var2.addProperty(var11, var8.contains(new JsonPrimitive(var10)));
               }
            }
         }
      }
   }

   private static void v21(JsonObject var0) {
      JsonObject var1 = v2(var0, "fireoverlay");
      if (var1 != null) {
         var1.remove("scale");
      }
   }

   private static void v22(JsonObject var0) {
      JsonObject var1 = v2(var0, "fullbright");
      if (var1 != null && var1.has("disableBlockShadow")) {
         JsonElement var2 = var1.remove("disableBlockShadow");
         if (var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isBoolean() && var2.getAsBoolean() && !var0.has("noshading")) {
            JsonElement var3 = var1.get("_enabled");
            JsonObject var4 = new JsonObject();
            var4.addProperty("_enabled", var3 != null && var3.isJsonPrimitive() && var3.getAsBoolean());
            var4.addProperty("blocks", false);
            var4.addProperty("clouds", false);
            var4.addProperty("entities", false);
            var4.addProperty("cornerShadows", true);
            var0.add("noshading", var4);
         }
      }
   }

   private static void v24(JsonObject var0) {
      JsonObject var1 = v2(var0, "antileak");
      JsonObject var2 = v2(var0, "streamermode");
      var0.remove("antileak");
      JsonObject var3 = v2(var0, "_binds");
      if (var3 != null) {
         v3(var3, "antileak", "streamermode");
      }

      JsonObject var4 = v2(var0, "_hudstyle");
      JsonObject var5 = var4 == null ? null : v2(var4, "hotkeys");
      JsonElement var6 = var5 == null ? null : var5.get("modules");
      if (var6 != null && var6.isJsonArray()) {
         var6.getAsJsonArray().remove(new JsonPrimitive("antileak"));
      }

      if (var1 != null || var2 != null) {
         if (var2 != null) {
            for (String var8 : v6) {
               if (var2.has(var8)) {
                  return;
               }
            }
         }

         boolean var13 = var2 != null && v1(var2, "_enabled", false);
         boolean var14 = var1 != null && v1(var1, "_enabled", false);
         JsonObject var9 = var2 != null ? var2 : new JsonObject();

         for (String var11 : v6) {
            boolean var12 = var1 == null ? true : v1(var1, var11, true);
            var9.addProperty(var11, !var14 && var13 ? false : var12);
         }

         if (var14 && !var13) {
            for (String var16 : v5) {
               var9.addProperty(var16, false);
            }
         }

         var9.addProperty("_enabled", var13 || var14);
         var0.add("streamermode", var9);
      }
   }

   private static void v1(JsonObject var0, String var1, String var2) {
      JsonElement var3 = var0.get(var1);
      if (var3 != null && var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isNumber()) {
         float var4 = var3.getAsFloat();
         var0.addProperty(var2, Math.max(-100.0F, Math.min(100.0F, var4 - 100.0F)));
      }
   }

   @Nullable
   private static JsonObject v2(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonObject() ? var2.getAsJsonObject() : null;
   }

   @Nullable
   private static Integer v1(String var0) {
      String var1 = var0.trim();
      if (var1.startsWith("#")) {
         var1 = var1.substring(1);
      }

      try {
         if (var1.length() == 6) {
            return 0xFF000000 | Integer.parseInt(var1, 16);
         }

         if (var1.length() == 8) {
            return (int)Long.parseUnsignedLong(var1, 16);
         }
      } catch (NumberFormatException var3) {
      }

      return null;
   }

   private static void v2(JsonObject var0, String var1, String var2) {
      if (var0.has(var1) && var0.get(var1).isJsonObject()) {
         var0.getAsJsonObject(var1).remove(var2);
      }
   }

   private static void v3(JsonObject var0, String var1, String var2) {
      JsonElement var3 = var0.get(var1);
      if (var3 != null) {
         var0.remove(var1);
         if (!var0.has(var2)) {
            var0.add(var2, var3);
         }
      }
   }

   private static boolean v1(JsonObject var0, String var1, boolean var2) {
      JsonElement var3 = var0.get(var1);
      return var3 != null && var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isBoolean() ? var3.getAsBoolean() : var2;
   }
}
