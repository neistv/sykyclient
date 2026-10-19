package cc.syky.cloud;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport84 {
   private cloudSupport84() {
   }

   public static String v1(String var0, int var1, JsonElement var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty("op", var0);
      if (var1 != 0) {
         var3.addProperty("id", var1);
      }

      var3.add("d", var2);
      return var3.toString();
   }

   @Nullable
   public static cloudSupport84.Part1 v1(String var0) {
      try {
         JsonElement var1 = JsonParser.parseString(var0);
         if (!var1.isJsonObject()) {
            return null;
         } else {
            JsonObject var2 = var1.getAsJsonObject();
            String var3 = cloudSupport60.v2(var2, "op");
            if (var3.isEmpty()) {
               return null;
            } else {
               int var4 = var2.has("re") && var2.get("re").isJsonPrimitive() ? var2.get("re").getAsInt() : 0;
               JsonElement var5 = var2.get("d");
               return new cloudSupport84.Part1(var3, var4, var5 != null && !var5.isJsonNull() ? var5 : null);
            }
         }
      } catch (IllegalStateException | NumberFormatException | UnsupportedOperationException | JsonParseException var6) {
         return null;
      }
   }

   @Nullable
   public static SykySession.Part1 v1(@Nullable JsonElement var0) {
      if (var0 != null && var0.isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject();
         long var2 = cloudSupport60.v3(var1, "uid");
         String var4 = cloudSupport60.v2(var1, "username");
         return var2 > 0L && !var4.isEmpty() ? new SykySession.Part1(var2, var4) : null;
      } else {
         return null;
      }
   }

   public record Part1(String op, int re, @Nullable JsonElement d) {
      @Nullable
      public JsonObject v1() {
         return this.d != null && this.d.isJsonObject() ? this.d.getAsJsonObject() : null;
      }

      public boolean v2() {
         return "error".equals(this.op);
      }

      public String v3() {
         JsonObject var1 = this.v1();
         return var1 != null ? cloudSupport60.v2(var1, "code") : "";
      }

      public String v4() {
         return this.op;
      }

      public int v5() {
         return this.re;
      }

      @Nullable
      public JsonElement v6() {
         return this.d;
      }
   }
}
