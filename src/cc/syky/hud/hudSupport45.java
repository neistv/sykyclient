package cc.syky.hud;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class hudSupport45 {
   public static final String v1 = "_hud";
   public static final int v2 = 6;
   private static final int v3 = 5;
   private static final String v4 = "_version";
   private static final String v5 = "_rows";
   private static final String v6 = "members";
   private static final String v7 = "dock";
   private static final Logger v8 = LoggerFactory.getLogger("syky.hud.persist");
   private final MySettingsSupport v9;

   public hudSupport45(MySettingsSupport var1) {
      this.v9 = var1;
   }

   public int v1(Map<String, HudElement> var1, hudSupport41 var2) {
      JsonObject var3 = this.v9.v11("_hud");
      if (var3 == null) {
         return 0;
      } else {
         int var4 = v1(var3);
         if (var4 != 6 && var4 != 5) {
            v8.info("hud layout version mismatch (stored={}, current={}); resetting to defaults", var4, 6);
            return 0;
         } else {
            List var5 = v1(var3, var2);
            var2.v4();
            int var6 = v1(var3, var1);
            if (var4 == 5) {
               v1(var3, var1, var2);
            } else {
               v2(var3, var2);
            }

            for (int var7 = 0; var7 < var5.size(); var7++) {
               hudSupport45.Part1 var8 = (hudSupport45.Part1)var5.get(var7);
               var2.v3(var8.v1(), var8.v2().v1(), var8.v2().v2(), var8.v2().v3());
            }

            return var6;
         }
      }
   }

   public void v2(Map<String, HudElement> var1, hudSupport41 var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty("_version", 6);

      for (HudElement var5 : var1.values()) {
         JsonObject var6 = new JsonObject();
         var6.addProperty("anchor", var5.v3().name());
         var6.addProperty("x", var5.v7());
         var6.addProperty("y", var5.v8());
         hudRecord3 var7 = var5.v11();
         if (var7 != null && var2.v1(var7.v1())) {
            JsonObject var8 = new JsonObject();
            var8.addProperty("to", var7.v1().v1());
            var8.addProperty("side", var7.v2().name());
            var8.addProperty("align", var7.v3().name());
            var6.add("dock", var8);
         }

         var3.add(var5.v1(), var6);
      }

      this.v9.v2("_hud", var3);
   }

   private static int v1(JsonObject var0) {
      if (!var0.has("_version")) {
         return 0;
      } else {
         try {
            return var0.get("_version").getAsInt();
         } catch (RuntimeException var2) {
            return 0;
         }
      }
   }

   private static List<hudSupport45.Part1> v1(JsonObject var0, hudSupport41 var1) {
      ArrayList var2 = new ArrayList();
      List var3 = var1.v1();

      for (int var4 = 0; var4 < var3.size(); var4++) {
         HudElement var5 = (HudElement)var3.get(var4);
         hudRecord3 var6 = var5.v11();
         if (var6 != null && !var0.has(var5.v1())) {
            var2.add(new hudSupport45.Part1(var5, var6));
         }
      }

      return var2;
   }

   private static void v2(JsonObject var0, hudSupport41 var1) {
      List var2 = var1.v1();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         HudElement var4 = (HudElement)var2.get(var3);
         JsonElement var5 = var0.get(var4.v1());
         if (var5 != null && var5.isJsonObject()) {
            JsonElement var6 = var5.getAsJsonObject().get("dock");
            if (var6 != null && var6.isJsonObject()) {
               try {
                  JsonObject var7 = var6.getAsJsonObject();
                  HudElement var8 = v1(var1, v1(var7, "to"));
                  hudRecord3.Part1 var9 = hudRecord3.Part1.v1(v1(var7, "side"));
                  hudRecord3.Part2 var10 = hudRecord3.Part2.v1(v1(var7, "align"));
                  if (var8 == null || var9 == null || var10 == null || !var1.v2(var4, var8, var9, var10)) {
                     v8.warn("hud piece '{}' cannot dock as saved; it stands on its own", var4.v1());
                  }
               } catch (RuntimeException var11) {
                  v8.warn("invalid hud dock for '{}', it stands on its own", var4.v1(), var11);
               }
            }
         }
      }
   }

   private static void v1(JsonObject var0, Map<String, HudElement> var1, hudSupport41 var2) {
      JsonElement var3 = var0.get("_rows");
      if (var3 != null && var3.isJsonObject()) {
         EnumMap var4 = new EnumMap<>(hudSupport52.class);

         record Part2(hudSupport52 anchor, float x, float y, List<HudElement> members) {
            public hudSupport52 v1() {
               return this.anchor;
            }

            public float v2() {
               return this.x;
            }

            public float v3() {
               return this.y;
            }

            public List<HudElement> v4() {
               return this.members;
            }
         }

         for (Entry var6 : var3.getAsJsonObject().entrySet()) {
            if (var6.getValue() != null && ((JsonElement)var6.getValue()).isJsonObject()) {
               try {
                  JsonObject var7 = ((JsonElement)var6.getValue()).getAsJsonObject();
                  hudSupport52 var8 = hudSupport52.v1(v1(var7, "anchor"), hudSupport52.TOP_LEFT);
                  float var9 = var7.has("x") && var7.get("x").isJsonPrimitive() ? var7.get("x").getAsFloat() : 0.0F;
                  float var10 = var7.has("y") && var7.get("y").isJsonPrimitive() ? var7.get("y").getAsFloat() : 0.0F;
                  ArrayList var11 = new ArrayList();
                  JsonElement var12 = var7.get("members");
                  if (var12 != null && var12.isJsonArray()) {
                     for (JsonElement var14 : var12.getAsJsonArray()) {
                        HudElement var15 = var14 != null && var14.isJsonPrimitive() ? (HudElement)var1.get(var14.getAsString()) : null;
                        if (var15 != null && var2.v1(var15) && !var11.contains(var15)) {
                           var11.add(var15);
                        }
                     }
                  }

                  if (!var11.isEmpty()) {
                     var4.computeIfAbsent(var8, var0x -> new ArrayList<>()).add(new Part2(var8, var9, var10, var11));
                  }
               } catch (RuntimeException var16) {
                  v8.warn("invalid hud row '{}' in a v5 layout, skipping it", var6.getKey(), var16);
               }
            }
         }

         for (List var18 : var4.values()) {
            var18.sort(Comparator.comparingDouble(Part2::v3));
            HudElement var19 = null;

            for (Part2 var21 : var18) {
               hudSupport52 var22 = var21.v1();
               HudElement var23 = var21.v4().get(0);
               if (var19 == null) {
                  var23.v1(var22);
                  var23.v1(var21.v2(), var21.v3());
               } else {
                  hudRecord3.Part1 var24 = var22.v2() == hudSupport52.Part1.BOTTOM ? hudRecord3.Part1.ABOVE : hudRecord3.Part1.BELOW;

                  hudRecord3.Part2 var26 = switch (var22.v1()) {
                     case LEFT -> hudRecord3.Part2.START;
                     case CENTER -> hudRecord3.Part2.CENTER;
                     case RIGHT -> hudRecord3.Part2.END;
                  };
                  var2.v2(var23, var19, var24, var26);
               }

               for (int var25 = 1; var25 < var21.v4().size(); var25++) {
                  var2.v2(var21.v4().get(var25), var21.v4().get(var25 - 1), hudRecord3.Part1.RIGHT, hudRecord3.Part2.CENTER);
               }

               var19 = var23;
            }
         }
      }
   }

   @Nullable
   private static HudElement v1(hudSupport41 var0, @Nullable String var1) {
      if (var1 == null) {
         return null;
      } else {
         List var2 = var0.v1();

         for (int var3 = 0; var3 < var2.size(); var3++) {
            if (((HudElement)var2.get(var3)).v1().equals(var1)) {
               return (HudElement)var2.get(var3);
            }
         }

         return null;
      }
   }

   @Nullable
   private static String v1(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() ? var2.getAsString() : null;
   }

   private static int v1(JsonObject var0, Map<String, HudElement> var1) {
      int var2 = 0;

      for (HudElement var4 : var1.values()) {
         if (var0.has(var4.v1())) {
            try {
               JsonObject var5 = var0.getAsJsonObject(var4.v1());
               v1(var4, var5);
               var2++;
            } catch (RuntimeException var6) {
               v8.warn("invalid hud state for '{}', keeping defaults", var4.v1(), var6);
            }
         }
      }

      return var2;
   }

   private static void v1(HudElement var0, JsonObject var1) {
      if (var1.has("anchor") && var1.get("anchor").isJsonPrimitive()) {
         var0.v1(hudSupport52.v1(var1.get("anchor").getAsString(), var0.v3()));
      }

      if (var1.has("x") && var1.get("x").isJsonPrimitive()) {
         var0.v1(var1.get("x").getAsFloat());
      }

      if (var1.has("y") && var1.get("y").isJsonPrimitive()) {
         var0.v2(var1.get("y").getAsFloat());
      }
   }

   public record Part1(HudElement piece, hudRecord3 dock) {
      public HudElement v1() {
         return this.piece;
      }

      public hudRecord3 v2() {
         return this.dock;
      }
   }
}
