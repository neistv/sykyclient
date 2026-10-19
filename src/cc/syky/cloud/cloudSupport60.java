package cc.syky.cloud;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport60 {
   private cloudSupport60() {
   }

   @Nullable
   public static String v1(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() ? var2.getAsString() : null;
   }

   public static String v2(JsonObject var0, String var1) {
      String var2 = v1(var0, var1);
      return var2 != null ? var2 : "";
   }

   public static long v3(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);

      try {
         return var2 != null && var2.isJsonPrimitive() ? var2.getAsLong() : 0L;
      } catch (NumberFormatException var4) {
         return 0L;
      }
   }

   public static boolean v1(JsonObject var0, String var1, boolean var2) {
      JsonElement var3 = var0.get(var1);
      return var3 != null && var3.isJsonPrimitive() ? var3.getAsBoolean() : var2;
   }

   public static List<String> v1(JsonObject var0, String var1, Predicate<String> var2) {
      JsonElement var3 = var0.get(var1);
      if (var3 != null && var3.isJsonArray()) {
         ArrayList var4 = new ArrayList();

         for (JsonElement var6 : var3.getAsJsonArray()) {
            if (var6.isJsonPrimitive()) {
               String var7 = var6.getAsString();
               if (var2.test(var7)) {
                  var4.add(var7);
               }
            }
         }

         return var4;
      } else {
         return List.of();
      }
   }
}
