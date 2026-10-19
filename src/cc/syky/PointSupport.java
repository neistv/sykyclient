package cc.syky;

import cc.syky.cloud.cloudSupport58;
import cc.syky.cloud.cloudSupport96;
import cc.syky.internal.InternalSupport10;
import cc.syky.internal.InternalSupport7;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class PointSupport {
   public static final int v1 = 2;

   private PointSupport() {
   }

   @Nullable
   public static String v1(String var0) {
      try {
         if (JsonParser.parseString(var0) instanceof JsonObject var1) {
            return v1(var1.get("world"), null);
         }
      } catch (JsonParseException var3) {
      }

      return null;
   }

   public static String v1(LANRecord var0, List<sykyRecord4> var1) {
      JsonObject var2 = new JsonObject();
      boolean var3 = false;

      for (sykyRecord4 var5 : var1) {
         var3 |= var5.v3();
      }

      var2.addProperty("format", var3 ? 2 : 1);
      var2.addProperty("world", var0.v2());
      JsonArray var9 = new JsonArray();

      for (sykyRecord4 var6 : var1) {
         JsonObject var7 = new JsonObject();
         var7.addProperty("id", var6.v4());
         var7.addProperty("name", var6.v5());
         var7.addProperty("x", var6.v6());
         var7.addProperty("y", var6.v7());
         var7.addProperty("z", var6.v8());
         var7.addProperty("dimension", var6.v9());
         var7.addProperty("visible", var6.v10());
         if (var6.v11()) {
            var7.addProperty("linked", true);
         }

         if (var6.v12() != -2181380) {
            var7.addProperty("color", String.format(Locale.ROOT, "#%08X", var6.v12()));
         }

         if (var6.v13()) {
            var7.addProperty("alwaysLabel", true);
         }

         if (var6.v14()) {
            var7.addProperty("death", true);
         }

         if (var6.v15()) {
            var7.addProperty("pinned", true);
         }

         if (var6.v16() != null) {
            var7.addProperty("note", var6.v16());
         }

         if (var6.v17() != 0.0F) {
            var7.addProperty("size", var6.v17());
         }

         if (var6.v3()) {
            var7.add("blocks", v1(var6.v18()));
            if (!var6.v19().equals(sykyRecord5.DEFAULT)) {
               JsonObject var8 = new JsonObject();
               var8.addProperty("fill", var6.v19().v1());
               var8.addProperty("outline", var6.v19().v2());
               var8.addProperty("lift", var6.v19().v3());
               var7.add("style", var8);
            }
         }

         if (var6.v1() || var6.v22() != cloudSupport96.TOGGLE) {
            JsonObject var11 = new JsonObject();
            var11.addProperty("code", var6.v20());
            var11.addProperty("modifiers", var6.v21());
            var11.addProperty("mode", var6.v22().name());
            var7.add("bind", var11);
         }

         var9.add(var7);
      }

      var2.add("waypoints", var9);
      return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(var2);
   }

   public static List<sykyRecord4> v2(String var0) throws PointSupport.Part1 {
      JsonObject var1;
      try {
         JsonElement var2 = JsonParser.parseString(var0);
         if (!var2.isJsonObject()) {
            throw new PointSupport.Part1("not a JSON object");
         }

         var1 = var2.getAsJsonObject();
      } catch (IllegalStateException | JsonParseException var9) {
         throw new PointSupport.Part1("not JSON: " + var9.getMessage());
      }

      int var10 = v1(var1.get("format"), -1);
      if (var10 < 1) {
         throw new PointSupport.Part1("no format");
      } else if (var10 > 2) {
         throw new PointSupport.Part1("written by a newer client (format " + var10 + ")");
      } else {
         JsonElement var3 = var1.get("waypoints");
         if (var3 != null && var3.isJsonArray()) {
            ArrayList var4 = new ArrayList();
            HashSet var5 = new HashSet();

            for (JsonElement var7 : var3.getAsJsonArray()) {
               sykyRecord4 var8 = var7.isJsonObject() ? v1(var7.getAsJsonObject()) : null;
               if (var8 != null && var5.add(var8.v4())) {
                  var4.add(var8);
               }
            }

            return var4;
         } else {
            throw new PointSupport.Part1("no waypoint list");
         }
      }
   }

   @Nullable
   private static sykyRecord4 v1(JsonObject var0) {
      String var1 = v1(var0.get("id"), null);
      if (var1 != null && InternalSupport7.v4(var1)) {
         if (var0.get("x") instanceof JsonPrimitive var2
            && var2.isNumber()
            && var0.get("y") instanceof JsonPrimitive var3
            && var3.isNumber()
            && var0.get("z") instanceof JsonPrimitive var4
            && var4.isNumber()) {
            String var24 = AreaSupport.v1(v2(var0.get("name"), ""));
            String var6 = v2(var0.get("dimension"), "minecraft:overworld");
            boolean var7 = v1(var0.get("visible"), true);
            boolean var8 = v1(var0.get("linked"), false);
            int var9 = v3(var0.get("color"));
            boolean var10 = v1(var0.get("alwaysLabel"), false);
            boolean var11 = v1(var0.get("death"), false);
            boolean var12 = v1(var0.get("pinned"), false);
            String var13 = cloudSupport58.v1(v1(var0.get("note"), null));
            InternalSupport10 var14 = v2(var0.get("blocks"));
            sykyRecord5 var15 = v1(var0.get("style"));
            float var16 = v1(var0.get("size"), 0.0F);
            int var17 = -1;
            int var18 = 0;
            cloudSupport96 var19 = cloudSupport96.TOGGLE;
            if (var0.get("bind") instanceof JsonObject var20) {
               var17 = v1(var20.get("code"), -1);
               var18 = v1(var20.get("modifiers"), 0);
               cloudSupport96 var25 = cloudSupport96.v1(v1(var20.get("mode"), null), cloudSupport96.TOGGLE);
               var19 = var25 == null ? cloudSupport96.TOGGLE : var25;
            }

            return new sykyRecord4(
               var1,
               var24.isEmpty() ? "Point" : var24,
               v1(var2),
               v1(var3),
               v1(var4),
               var6,
               var7,
               var8,
               var9,
               var10,
               var11,
               var12,
               var13,
               var14,
               var15,
               var16,
               var17,
               var18,
               var19
            );
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private static JsonArray v1(InternalSupport10 var0) {
      JsonArray var1 = new JsonArray();
      int var2 = var0.v1();
      int var3 = 0;

      while (var3 < var2) {
         long var4 = var0.v1(var3);
         int var6 = var3 + 1;

         while (var6 < var2 && var0.v1(var6) == var0.v1(var6 - 1) + 1L) {
            var6++;
         }

         JsonArray var7 = new JsonArray();
         var7.add(InternalSupport10.v1(var4));
         var7.add(InternalSupport10.v3(var4));
         var7.add(InternalSupport10.v2(var4));
         var7.add(var6 - var3);
         var1.add(var7);
         var3 = var6;
      }

      return var1;
   }

   private static sykyRecord5 v1(@Nullable JsonElement var0) {
      sykyRecord5 var1 = sykyRecord5.DEFAULT;
      return var0 instanceof JsonObject var2
         ? new sykyRecord5(v1(var2.get("fill"), var1.v1()), v1(var2.get("outline"), var1.v2()), v1(var2.get("lift"), var1.v3()))
         : var1;
   }

   private static float v1(@Nullable JsonElement var0, float var1) {
      return var0 instanceof JsonPrimitive var2 && var2.isNumber() ? var2.getAsFloat() : var1;
   }

   private static InternalSupport10 v2(@Nullable JsonElement var0) {
      if (!(var0 instanceof JsonArray var1)) {
         return InternalSupport10.v2;
      } else {
         long[] var2 = new long[256];
         int var3 = 0;

         for (JsonElement var5 : var1) {
            if (var5 instanceof JsonArray var6 && var6.size() == 4) {
               int var7 = v1(var6.get(0), Integer.MIN_VALUE);
               int var8 = v1(var6.get(1), Integer.MIN_VALUE);
               int var9 = v1(var6.get(2), Integer.MIN_VALUE);
               int var10 = v1(var6.get(3), 0);
               if (var7 != Integer.MIN_VALUE && var8 != Integer.MIN_VALUE && var9 != Integer.MIN_VALUE && var10 >= 1) {
                  for (int var11 = 0; var11 < var10 && var3 < 16384; var11++) {
                     if (var3 == var2.length) {
                        var2 = Arrays.copyOf(var2, Math.min(16384, var2.length * 2));
                     }

                     var2[var3++] = InternalSupport10.v1(var7 + var11, var8, var9);
                  }
               }
            }
         }

         return InternalSupport10.v1(Arrays.copyOf(var2, var3));
      }
   }

   private static int v1(JsonPrimitive var0) {
      double var1 = var0.getAsDouble();
      return Double.isNaN(var1) ? 0 : (int)Math.max(-3.0E7, Math.min(3.0E7, Math.floor(var1)));
   }

   private static int v3(@Nullable JsonElement var0) {
      String var1 = v2(var0, "");
      String var2 = var1.startsWith("#") ? var1.substring(1) : var1;
      if (var2.length() != 6 && var2.length() != 8) {
         return -2181380;
      } else {
         try {
            int var3 = HexFormat.fromHexDigits(var2);
            return var2.length() == 6 ? 0xFF000000 | var3 : var3;
         } catch (IllegalArgumentException var4) {
            return -2181380;
         }
      }
   }

   private static boolean v1(@Nullable JsonElement var0, boolean var1) {
      return var0 instanceof JsonPrimitive var2 && var2.isBoolean() ? var2.getAsBoolean() : var1;
   }

   private static int v1(@Nullable JsonElement var0, int var1) {
      if (var0 instanceof JsonPrimitive var2 && var2.isNumber()) {
         double var3 = var2.getAsDouble();
         return var3 >= -2.1474836E9F && var3 <= 2.147483647E9 ? (int)var3 : var1;
      } else {
         return var1;
      }
   }

   @Nullable
   private static String v1(@Nullable JsonElement var0, @Nullable String var1) {
      return var0 instanceof JsonPrimitive var2 && var2.isString() ? var2.getAsString() : var1;
   }

   private static String v2(@Nullable JsonElement var0, String var1) {
      return var0 instanceof JsonPrimitive var2 && var2.isString() ? var2.getAsString() : var1;
   }

   public static final class Part1 extends Exception {
      private static final long v1 = 1L;

      public Part1(String var1) {
         super(var1);
      }
   }
}
