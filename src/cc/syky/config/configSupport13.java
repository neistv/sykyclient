package cc.syky.config;

import cc.syky.module.visual.CISSupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.net.URI;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public final class configSupport13 {
   private static final String v1 = "https://mctiers.com/api/v2/profile/";
   private static final String v2 = "https://api.qaztiers.net/api/users/profile/";
   private static final String v3 = "https://api.atiers.net/api/v1/player/";
   private static final String v4 = "https://mytiers.ru/api/player/";
   private static final String v5 = "https://cistiers.com/api/dump";
   private static final Pattern v6 = Pattern.compile("[A-Za-z0-9_]{1,16}");
   private static final Pattern v7 = Pattern.compile("[a-z0-9_]{1,24}");
   private static final int v8 = 32;
   private static final int v9 = 512;
   private static final Pattern v10 = Pattern.compile("(R?)([HL])T([0-9]{1,2})", 2);
   private static final int v11 = 64;
   private static final int v12 = 10;
   private static final HTTPSupport<UUID> v13 = new HTTPSupport<>(
      "mctiers", var0 -> URI.create("https://mctiers.com/api/v2/profile/" + var0 + "/rankings"), configSupport13::v2
   );
   private static final HTTPSupport<String> v14 = new HTTPSupport<>(
      "qaztiers", var0 -> URI.create("https://api.qaztiers.net/api/users/profile/" + var0), configSupport13::v3
   );
   private static final HTTPSupport<String> v15 = new HTTPSupport<>(
      "atiers", var0 -> URI.create("https://api.atiers.net/api/v1/player/" + var0), configSupport13::v4
   );
   private static final HTTPSupport<String> v16 = new HTTPSupport<>("mytiers", var0 -> URI.create("https://mytiers.ru/api/player/" + var0), configSupport13::v5);
   private static final AcceptSupport v18 = new AcceptSupport("cistiers", URI.create("https://cistiers.com/api/dump"));
   private static final Optional<Map<String, configRecord2>> v19 = Optional.of(Map.of());
   private static volatile boolean v17;

   private configSupport13() {
   }

   public static void v1() {
      v17 = true;
   }

   public static int v2() {
      return HTTPSupport.v1();
   }

   public static Optional<Map<String, configRecord2>> v1(CISSupport var0, UUID var1, @Nullable String var2) {
      if (!v17) {
         return v19;
      } else {
         return switch (var0) {
            case MCTIERS -> v1(var1);
            case QAZTIERS -> v1(v14, var2);
            case ATIERS -> v1(v15, var2);
            case MYTIERS -> v1(v16, var2);
            case CISTIERS -> v8(var2);
         };
      }
   }

   private static Optional<Map<String, configRecord2>> v1(UUID var0) {
      return var0.version() == 4 ? v13.v1(var0) : v19;
   }

   private static Optional<Map<String, configRecord2>> v8(@Nullable String var0) {
      String var1 = v1(var0);
      return var1 == null ? v19 : v18.v1(var1);
   }

   private static Optional<Map<String, configRecord2>> v1(HTTPSupport<String> var0, @Nullable String var1) {
      String var2 = v1(var1);
      return var2 == null ? v19 : var0.v1(var2);
   }

   @Nullable
   public static String v1(@Nullable String var0) {
      return var0 != null && v6.matcher(var0).matches() ? var0.toLowerCase(Locale.ROOT) : null;
   }

   @Nullable
   public static Map<String, configRecord2> v2(String var0) {
      JsonObject var1 = v9(var0);
      if (var1 == null) {
         return null;
      } else {
         HashMap var2 = new HashMap();

         for (Entry var4 : var1.entrySet()) {
            if (var2.size() >= 32) {
               break;
            }

            String var5 = v7((String)var4.getKey());
            if (var5 != null && ((JsonElement)var4.getValue()).isJsonObject()) {
               JsonObject var6 = ((JsonElement)var4.getValue()).getAsJsonObject();
               Integer var7 = v2(var6, "tier");
               if (var7 != null) {
                  Integer var8 = v2(var6, "peak_tier");
                  boolean var9 = v4(var6, "retired") && v1(var6.get("retired"));
                  var2.put(var5, new configRecord2(var7, v3(var6, "pos"), var8, var8 == null ? null : v3(var6, "peak_pos"), var9));
               }
            }
         }

         return var2;
      }
   }

   @Nullable
   public static Map<String, configRecord2> v3(String var0) {
      JsonObject var1 = v9(var0);
      if (var1 != null && var1.has("tiers")) {
         JsonElement var2 = var1.get("tiers");
         if (!var2.isJsonArray()) {
            return null;
         } else {
            JsonArray var3 = var2.getAsJsonArray();
            HashMap var4 = new HashMap();

            for (JsonElement var6 : var3) {
               if (var4.size() >= 32) {
                  break;
               }

               if (var6.isJsonObject()) {
                  JsonObject var7 = var6.getAsJsonObject();
                  String var8 = v1(var7);
                  Integer var9 = v2(var7, "tier");
                  Boolean var10 = v2(var7);
                  if (var8 != null && var9 != null && var10 != null) {
                     var4.put(var8, new configRecord2(var9, var10, null, null, false));
                  }
               }
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   @Nullable
   private static JsonObject v9(String var0) {
      try {
         JsonElement var1 = JsonParser.parseString(var0);
         return var1 != null && var1.isJsonObject() ? var1.getAsJsonObject() : null;
      } catch (JsonParseException var2) {
         return null;
      }
   }

   @Nullable
   public static Map<String, configRecord2> v4(String var0) {
      JsonObject var1 = v9(var0);
      if (var1 != null && v4(var1, "ranks") && var1.get("ranks").isJsonObject()) {
         HashMap var2 = new HashMap();

         for (Entry var4 : var1.getAsJsonObject("ranks").entrySet()) {
            if (var2.size() >= 32) {
               break;
            }

            String var5 = v7((String)var4.getKey());
            configRecord2 var6 = ((JsonElement)var4.getValue()).isJsonPrimitive() ? v6(((JsonElement)var4.getValue()).getAsString()) : null;
            if (var5 != null && var6 != null) {
               var2.put(var5, var6);
            }
         }

         return var2;
      } else {
         return null;
      }
   }

   @Nullable
   public static Map<String, configRecord2> v5(String var0) {
      JsonObject var1 = v9(var0);
      if (var1 != null && v4(var1, "history") && var1.get("history").isJsonArray()) {
         HashMap var2 = new HashMap();
         HashMap var3 = new HashMap();
         int var4 = 0;

         for (JsonElement var6 : var1.getAsJsonArray("history")) {
            if (++var4 > 512) {
               break;
            }

            if (var6.isJsonObject()) {
               JsonObject var7 = var6.getAsJsonObject();
               String var8 = v7(v1(var7, "kit_name"));
               String var9 = v1(var7, "rank");
               if (var8 != null && var9 != null) {
                  String var10 = v1(var7, "created_at");
                  String var11 = (String)var2.get(var8);
                  if (var11 == null || var11.compareTo(var10 == null ? "" : var10) < 0) {
                     var2.put(var8, var10 == null ? "" : var10);
                     var3.put(var8, var9);
                  }
               }
            }
         }

         HashMap var12 = new HashMap();

         for (Entry var14 : var3.entrySet()) {
            if (var12.size() >= 32) {
               break;
            }

            configRecord2 var15 = v6((String)var14.getValue());
            if (var15 != null) {
               var12.put((String)var14.getKey(), var15);
            }
         }

         return var12;
      } else {
         return null;
      }
   }

   @Nullable
   public static configRecord2 v6(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         Matcher var1 = v10.matcher(var0);
         if (!var1.matches()) {
            return null;
         } else {
            int var2 = Integer.parseInt(var1.group(3));
            return var2 >= 1 && var2 <= 10 ? new configRecord2(var2, "H".equalsIgnoreCase(var1.group(2)), null, null, !var1.group(1).isEmpty()) : null;
         }
      }
   }

   @Nullable
   private static String v1(JsonObject var0, String var1) {
      if (v4(var0, var1) && var0.get(var1).isJsonPrimitive()) {
         String var2 = var0.get(var1).getAsString();
         return var2.length() <= 64 ? var2 : null;
      } else {
         return null;
      }
   }

   @Nullable
   private static String v1(JsonObject var0) {
      return v4(var0, "category") && var0.get("category").isJsonObject() ? v7(v1(var0.getAsJsonObject("category"), "slug")) : null;
   }

   @Nullable
   private static Boolean v2(JsonObject var0) {
      if (v4(var0, "variant") && var0.get("variant").isJsonPrimitive()) {
         String var1 = var0.get("variant").getAsString();
         if ("HT".equalsIgnoreCase(var1)) {
            return Boolean.TRUE;
         } else {
            return "LT".equalsIgnoreCase(var1) ? Boolean.FALSE : null;
         }
      } else {
         return null;
      }
   }

   @Nullable
   public static String v7(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.toLowerCase(Locale.ROOT);
         return v7.matcher(var1).matches() ? var1 : null;
      }
   }

   @Nullable
   private static Integer v2(JsonObject var0, String var1) {
      if (v4(var0, var1) && var0.get(var1).isJsonPrimitive()) {
         try {
            int var2 = var0.get(var1).getAsInt();
            return var2 >= 1 && var2 <= 10 ? var2 : null;
         } catch (NumberFormatException var3) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static boolean v3(JsonObject var0, String var1) {
      if (v4(var0, var1) && var0.get(var1).isJsonPrimitive()) {
         try {
            return var0.get(var1).getAsInt() == 0;
         } catch (NumberFormatException var3) {
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean v1(JsonElement var0) {
      return var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isBoolean() && var0.getAsBoolean();
   }

   private static boolean v4(JsonObject var0, String var1) {
      return var0.has(var1) && !var0.get(var1).isJsonNull();
   }
}
