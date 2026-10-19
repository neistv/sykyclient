package cc.syky.ui;

import cc.syky.account.MinecraftAccount;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public final class uiSupport264 {
   public static final int v1 = 1;

   private uiSupport264() {
   }

   public static byte[] v1(List<MinecraftAccount> var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("version", 1);
      JsonArray var2 = new JsonArray();

      for (MinecraftAccount var4 : var0) {
         JsonObject var5 = new JsonObject();
         var5.addProperty("id", var4.v2());
         var5.addProperty("kind", var4.v3().name().toLowerCase(Locale.ROOT));
         var5.addProperty("name", var4.v4());
         var5.addProperty("uuid", var4.v5().toString());
         var5.addProperty("added", var4.v6());
         var5.addProperty("lastUsed", var4.v7());
         if (var4.v8() != null) {
            var5.addProperty("lastPlace", var4.v8());
         }

         if (var4.v9()) {
            var5.addProperty("pinned", true);
         }

         if (var4.v10() != null) {
            var5.addProperty("note", var4.v10());
         }

         if (var4.v11() != null) {
            JsonObject var6 = new JsonObject();
            var6.addProperty("url", var4.v11());
            var6.addProperty("slim", var4.v12());
            var5.add("skin", var6);
         }

         if (var4.v3() == uiSupport272.MICROSOFT) {
            JsonObject var7 = new JsonObject();
            if (var4.v13() != null) {
               var7.addProperty("refresh", var4.v13());
            }

            if (var4.v14() != null) {
               var7.addProperty("access", var4.v14());
               var7.addProperty("expires", var4.v15());
            }

            var7.addProperty("signInAgain", var4.v16());
            var5.add("microsoft", var7);
         }

         var2.add(var5);
      }

      var1.add("accounts", var2);
      return var1.toString().getBytes(StandardCharsets.UTF_8);
   }

   public static List<MinecraftAccount> v1(byte[] var0) throws uiSupport264.Part1 {
      JsonObject var1;
      try {
         JsonElement var2 = JsonParser.parseString(new String(var0, StandardCharsets.UTF_8));
         if (!var2.isJsonObject()) {
            throw new uiSupport264.Part1("the account list is not a JSON object");
         }

         var1 = var2.getAsJsonObject();
      } catch (JsonParseException var8) {
         throw new uiSupport264.Part1("the account list is not JSON");
      }

      JsonElement var9 = var1.get("accounts");
      if (var9 != null && var9.isJsonArray()) {
         ArrayList var3 = new ArrayList();
         HashSet var4 = new HashSet();

         for (JsonElement var6 : var9.getAsJsonArray()) {
            MinecraftAccount var7 = var6.isJsonObject() ? v1(var6.getAsJsonObject()) : null;
            if (var7 != null && var4.add(var7.v2())) {
               var3.add(var7);
            }
         }

         return var3;
      } else {
         throw new uiSupport264.Part1("the account list has no accounts array");
      }
   }

   @Nullable
   private static MinecraftAccount v1(JsonObject var0) {
      String var1 = v1(var0, "id");
      String var2 = v1(var0, "kind");
      String var3 = v1(var0, "name");
      UUID var4 = v1(v1(var0, "uuid"));
      if (var1 != null && !var1.isEmpty() && var2 != null && var3 != null && !var3.isEmpty() && var4 != null) {
         uiSupport272 var5 = switch (var2) {
            case "offline" -> uiSupport272.OFFLINE;
            case "microsoft" -> uiSupport272.MICROSOFT;
            default -> null;
         };
         if (var5 == null) {
            return null;
         } else {
            String var6 = null;
            boolean var16 = false;
            JsonElement var8 = var0.get("skin");
            if (var8 != null && var8.isJsonObject()) {
               JsonObject var9 = var8.getAsJsonObject();
               var6 = v1(var9, "url");
               var16 = v3(var9, "slim");
            }

            String var17 = null;
            String var10 = null;
            long var11 = 0L;
            boolean var13 = false;
            JsonElement var14 = var0.get("microsoft");
            if (var5 == uiSupport272.MICROSOFT) {
               if (var14 == null || !var14.isJsonObject()) {
                  return null;
               }

               JsonObject var15 = var14.getAsJsonObject();
               var17 = v1(var15, "refresh");
               var10 = v1(var15, "access");
               var11 = var10 == null ? 0L : v2(var15, "expires");
               var13 = v3(var15, "signInAgain") || var17 == null;
            }

            return new MinecraftAccount(
               var1,
               var5,
               var3,
               var4,
               v2(var0, "added"),
               v2(var0, "lastUsed"),
               v1(var0, "lastPlace"),
               v3(var0, "pinned"),
               v1(var0, "note"),
               var6,
               var16,
               var17,
               var10,
               var11,
               var13
            );
         }
      } else {
         return null;
      }
   }

   @Nullable
   private static String v1(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString() ? var2.getAsString() : null;
   }

   private static long v2(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      if (var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isNumber()) {
         try {
            return var2.getAsLong();
         } catch (NumberFormatException var4) {
            return 0L;
         }
      } else {
         return 0L;
      }
   }

   private static boolean v3(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isBoolean() && var2.getAsBoolean();
   }

   @Nullable
   private static UUID v1(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         try {
            return UUID.fromString(var0);
         } catch (IllegalArgumentException var2) {
            return null;
         }
      }
   }

   public static final class Part1 extends Exception {
      private static final long v1 = 1L;

      public Part1(String var1) {
         super(var1);
      }
   }
}
