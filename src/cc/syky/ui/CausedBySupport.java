package cc.syky.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public final class CausedBySupport {
   private static final Pattern v1 = Pattern.compile("^(?:[\\w.$-]*//)?(?:[\\w.$-]+(?:@[\\w.+-]*)?/)?");
   private static final Pattern v2 = Pattern.compile("(?m)^Thread: (.+)$");
   private static final Pattern v3 = Pattern.compile("(?m)^\\s+syky: .* (\\S+)\\s*$");

   private CausedBySupport() {
   }

   @Nullable
   public static JsonObject v1(String var0) {
      List var1 = var0.lines().toList();
      int var2 = 0;

      while (var2 < var1.size() && !((String)var1.get(var2)).startsWith("Description:")) {
         var2++;
      }

      var2++;

      while (var2 < var1.size() && ((String)var1.get(var2)).isBlank()) {
         var2++;
      }

      if (var2 >= var1.size()) {
         return null;
      } else {
         JsonObject var3 = null;
         JsonObject var4 = null;
         JsonArray var5 = null;
         StringBuilder var6 = null;

         for (boolean var7 = false; var2 < var1.size(); var2++) {
            String var8 = (String)var1.get(var2);
            if (var8.isBlank() || var8.startsWith("A detailed walkthrough")) {
               break;
            }

            String var9 = var8.strip();
            if (var9.startsWith("at ") && var5 != null) {
               if (!var7 && var5.size() < 128) {
                  var5.add(v4(var9.substring(3)));
               }
            } else if (!var9.startsWith("...")) {
               if (var9.startsWith("Suppressed: ")) {
                  var7 = true;
               } else if (var8.startsWith("Caused by: ") && var4 != null) {
                  var7 = false;
                  v1(var4, var6);
                  JsonObject var10 = v5(var8.substring("Caused by: ".length()).strip());
                  var4.add("cause", var10);
                  var4 = var10;
                  var5 = var10.getAsJsonArray("frames");
                  var6 = v1(var10);
               } else if (var4 == null) {
                  var4 = v5(var9);
                  var3 = var4;
                  var5 = var4.getAsJsonArray("frames");
                  var6 = v1(var4);
               } else if (!var7 && var6 != null && var5 != null && var5.isEmpty()) {
                  var6.append('\n').append(var8);
               }
            }
         }

         if (var4 != null) {
            v1(var4, var6);
         }

         return var3;
      }
   }

   @Nullable
   public static String v2(String var0) {
      Matcher var1 = v2.matcher(var0);
      return var1.find() ? var1.group(1).strip() : null;
   }

   @Nullable
   public static String v3(String var0) {
      Matcher var1 = v3.matcher(var0);
      return var1.find() ? var1.group(1) : null;
   }

   public static String v4(String var0) {
      return v1.matcher(var0).replaceFirst("");
   }

   private static JsonObject v5(String var0) {
      JsonObject var1 = new JsonObject();
      int var2 = var0.indexOf(": ");
      String var3 = var2 > 0 ? var0.substring(0, var2) : var0;
      if (var3.contains(" ")) {
         var1.addProperty("class", "unknown");
         var1.addProperty("message", var0);
      } else {
         var1.addProperty("class", var3);
         if (var2 > 0) {
            var1.addProperty("message", var0.substring(var2 + 2));
         }
      }

      var1.add("frames", new JsonArray());
      return var1;
   }

   @Nullable
   private static StringBuilder v1(JsonObject var0) {
      return var0.has("message") ? new StringBuilder(var0.get("message").getAsString()) : null;
   }

   private static void v1(JsonObject var0, @Nullable StringBuilder var1) {
      if (var1 != null) {
         var0.addProperty("message", NativeMethodSupport.v1(var1.toString(), 4096));
      }
   }
}
