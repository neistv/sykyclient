package cc.syky.crash;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public final class LogScrubber {
   private static final Pattern v1 = Pattern.compile("(?i)(--(?:accessToken|session|uuid|xuid|clientId))(\\s+|=)(\"[^\"]*\"|\\S+)");
   private static final Pattern v2 = Pattern.compile("(?i)\\b(Bearer)\\s+[A-Za-z0-9._~+/=-]+");
   private static final Pattern v3 = Pattern.compile("\\beyJ[A-Za-z0-9_-]{4,}\\.[A-Za-z0-9_-]{4,}(?:\\.[A-Za-z0-9_-]*)?");
   private static final Pattern v4 = Pattern.compile("(?<![A-Za-z0-9])s[dwmsolcgt]_[A-Za-z0-9_-]{16,}");
   private static final Pattern v5 = Pattern.compile("(?i)([a-z]:[\\\\/]+(?:users|documents and settings)[\\\\/]+)(?!<user>)[^\\\\/\\s\"'<>|:*?]+");
   private static final Pattern v6 = Pattern.compile("(/(?:home|Users)/)(?!<user>)[^/\\s\"']+");
   private static final Pattern v7 = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}");
   private static final String v8 = "(?:25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)";
   private static final Pattern v9 = Pattern.compile(
      "(?<!\\d|\\d\\.)(?:(?:25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(?!\\d|\\.\\d)"
   );
   private static final String v10 = "[0-9A-Fa-f]{1,4}";
   private static final Pattern v11 = Pattern.compile(
      "(?<![\\w:.])(?:(?:[0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}|(?:[0-9A-Fa-f]{1,4}:){1,7}:(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4}){0,6})?|::(?:[0-9A-Fa-f]{1,4}:){0,6}[0-9A-Fa-f]{1,4})(?![\\w:])"
   );
   private static final Pattern v12 = Pattern.compile("(Connecting to |Failed to ping server |Couldn't resolve server |Failed to parse URL )[^\\s,]+");
   private static final Pattern v13 = Pattern.compile("(?m)(Can't ping )[^\\n]+?(?=: |$)");
   private static final Pattern v14 = Pattern.compile("(?<![\\w.-])[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)+(?=/(?:\\[?<ip>|<unresolved>))");
   private final List<Pattern> v15 = new ArrayList<>();
   private final List<String> v16 = new ArrayList<>();
   @Nullable
   private final Pattern v18;
   @Nullable
   private final Pattern v19;
   @Nullable
   private final Pattern v17;

   public LogScrubber(String var1, String var2, Collection<String> var3, Collection<String> var4) {
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();

      for (String var8 : var3) {
         String var9 = v3(var8);
         if (var9.length() >= 4 && !var9.equals("localhost")) {
            (var9.indexOf(46) >= 0 ? var5 : var6).add(var9);
         }
      }

      String var12 = v1(var5);
      this.v18 = var12 == null ? null : Pattern.compile("(?<![\\w-])(?:" + var12 + ")(?![\\w-])", 2);
      String var13 = v1(var6);
      this.v19 = var13 == null ? null : Pattern.compile("(?<![\\w.-])(?:" + var13 + ")(?![\\w-])", 2);
      if (var1.length() >= 3) {
         this.v1(var1, "~");
         this.v1(var1.replace('\\', '/'), "~");
      }

      if (var2.length() >= 3) {
         this.v15.add(Pattern.compile("(?i)(?<=[\\\\/])" + Pattern.quote(var2) + "(?=[\\\\/])"));
         this.v16.add("<user>");
      }

      ArrayList var14 = new ArrayList();

      for (String var11 : var4) {
         if (var11.length() >= 3) {
            var14.add(var11);
         }
      }

      String var15 = v1(var14);
      this.v17 = var15 == null ? null : Pattern.compile("(?<![A-Za-z0-9_])(?:" + var15 + ")(?![A-Za-z0-9_])", 2);
   }

   public static LogScrubber v1(Collection<String> var0, Collection<String> var1) {
      return new LogScrubber(System.getProperty("user.home", ""), System.getProperty("user.name", ""), var0, var1);
   }

   @Nullable
   private static String v1(Collection<String> var0) {
      if (var0.isEmpty()) {
         return null;
      } else {
         TreeSet var1 = new TreeSet<>(Comparator.comparingInt(String::length).reversed().thenComparing(var0x -> var0x.toLowerCase(Locale.ROOT)));
         var1.addAll(var0);
         StringBuilder var2 = new StringBuilder();

         for (String var4 : var1) {
            if (var2.length() > 0) {
               var2.append('|');
            }

            var2.append(Pattern.quote(var4));
         }

         return var2.toString();
      }
   }

   private void v1(String var1, String var2) {
      this.v15.add(Pattern.compile(Pattern.quote(var1), 2));
      this.v16.add(Matcher.quoteReplacement(var2));
   }

   public String v1(String var1) {
      String var2 = v1.matcher(var1).replaceAll("$1$2<redacted>");
      var2 = v2.matcher(var2).replaceAll("$1 <redacted>");
      var2 = v3.matcher(var2).replaceAll("<jwt>");
      var2 = v4.matcher(var2).replaceAll("<secret>");
      if (this.v18 != null) {
         var2 = this.v18.matcher(var2).replaceAll("<server>");
      }

      for (int var3 = 0; var3 < this.v15.size(); var3++) {
         var2 = this.v15.get(var3).matcher(var2).replaceAll(this.v16.get(var3));
      }

      var2 = v5.matcher(var2).replaceAll("$1<user>");
      var2 = v6.matcher(var2).replaceAll("$1<user>");
      var2 = v7.matcher(var2).replaceAll("<email>");
      var2 = v12.matcher(var2).replaceAll("$1<server>");
      var2 = v13.matcher(var2).replaceAll("$1<server>");
      var2 = v9.matcher(var2).replaceAll("<ip>");
      var2 = v11.matcher(var2).replaceAll("<ip>");
      return v14.matcher(var2).replaceAll("<server>");
   }

   public String v2(String var1) {
      return this.v4(this.v1(var1));
   }

   private String v4(String var1) {
      String var2 = this.v17 == null ? var1 : this.v17.matcher(var1).replaceAll("<player>");
      return this.v19 == null ? var2 : this.v19.matcher(var2).replaceAll("<server>");
   }

   public void v1(JsonObject var1) {
      for (Entry var3 : var1.entrySet()) {
         var3.setValue(this.v3((JsonElement)var3.getValue()));
      }

      if (this.v17 != null || this.v19 != null) {
         this.v1(var1, "report");
         this.v2(var1.get("log"));
         JsonElement var5 = var1.get("breadcrumbs");
         if (var5 != null && var5.isJsonArray()) {
            for (JsonElement var4 : var5.getAsJsonArray()) {
               if (var4.isJsonObject()) {
                  this.v1(var4.getAsJsonObject(), "m");
               }
            }
         }

         JsonElement var7 = var1.get("native");
         if (var7 != null && var7.isJsonObject()) {
            this.v1(var7.getAsJsonObject(), "error");
            this.v1(var7.getAsJsonObject(), "summary");
         }

         this.v1(var1.get("throwable"));
      }
   }

   private void v1(@Nullable JsonElement var1) {
      if (var1 != null && var1.isJsonObject()) {
         JsonObject var2 = var1.getAsJsonObject();
         this.v1(var2, "message");
         this.v1(var2.get("cause"));
         JsonElement var3 = var2.get("suppressed");
         if (var3 != null && var3.isJsonArray()) {
            for (JsonElement var5 : var3.getAsJsonArray()) {
               this.v1(var5);
            }
         }
      }
   }

   private void v1(JsonObject var1, String var2) {
      JsonElement var3 = var1.get(var2);
      if (var3 != null && var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isString()) {
         var1.addProperty(var2, this.v4(var3.getAsString()));
      }
   }

   private void v2(@Nullable JsonElement var1) {
      if (var1 != null && var1.isJsonArray()) {
         JsonArray var2 = var1.getAsJsonArray();

         for (int var3 = 0; var3 < var2.size(); var3++) {
            JsonElement var4 = var2.get(var3);
            if (var4.isJsonPrimitive() && var4.getAsJsonPrimitive().isString()) {
               var2.set(var3, new JsonPrimitive(this.v4(var4.getAsString())));
            }
         }
      }
   }

   private JsonElement v3(JsonElement var1) {
      if (var1.isJsonPrimitive()) {
         JsonPrimitive var7 = var1.getAsJsonPrimitive();
         return (JsonElement)(var7.isString() ? new JsonPrimitive(this.v1(var7.getAsString())) : var1);
      } else if (var1.isJsonArray()) {
         JsonArray var6 = var1.getAsJsonArray();
         JsonArray var8 = new JsonArray(var6.size());

         for (JsonElement var5 : var6) {
            var8.add(this.v3(var5));
         }

         return var8;
      } else {
         if (var1.isJsonObject()) {
            for (Entry var3 : var1.getAsJsonObject().entrySet()) {
               var3.setValue(this.v3((JsonElement)var3.getValue()));
            }
         }

         return var1;
      }
   }

   public static String v3(String var0) {
      String var1 = var0.trim().toLowerCase(Locale.ROOT);
      int var2 = var1.lastIndexOf(58);
      if (var2 > 0 && var1.indexOf(58) == var2) {
         var1 = var1.substring(0, var2);
      }

      return var1.endsWith(".") ? var1.substring(0, var1.length() - 1) : var1;
   }
}
