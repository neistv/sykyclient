package cc.syky.serverrules;

import cc.syky.cloud.cloudSupport60;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class serverrulesSupport {
   private static final Logger v6 = LoggerFactory.getLogger("syky.serverrules");
   public static final int v1 = 1;
   public static final int v2 = 2000;
   public static final int v3 = 64;
   public static final int v4 = 256;
   private static final Pattern v7 = Pattern.compile("[a-z0-9][a-z0-9-]{0,31}");
   private static final Pattern v8 = Pattern.compile("[a-z0-9_]{1,48}");
   private static final int v9 = 48;
   public static final serverrulesSupport v5 = new serverrulesSupport(-1L, List.of());
   private final long v10;
   private final List<serverrulesSupport.Part1> v11;
   private final Map<String, serverrulesSupport.Part1> v12;

   private serverrulesSupport(long var1, List<serverrulesSupport.Part1> var3) {
      this(var1, var3, Map.of());
   }

   private serverrulesSupport(long var1, List<serverrulesSupport.Part1> var3, Map<String, serverrulesSupport.Part1> var4) {
      this.v10 = var1;
      this.v11 = List.copyOf(var3);
      this.v12 = Map.copyOf(var4);
   }

   public long v1() {
      return this.v10;
   }

   public List<serverrulesSupport.Part1> v2() {
      return this.v11;
   }

   @Nullable
   public serverrulesSupport.Part1 v1(@Nullable String var1) {
      String var2 = serverrulesSupport2.v1(var1);
      if (var2 == null || this.v12.isEmpty()) {
         return null;
      } else if (serverrulesSupport2.v2(var2)) {
         return this.v12.get(var2);
      } else {
         String var3 = var2;

         while (true) {
            serverrulesSupport.Part1 var4 = this.v12.get(var3);
            if (var4 != null) {
               return var4;
            }

            int var5 = var3.indexOf(46);
            if (var5 < 0) {
               return null;
            }

            var3 = var3.substring(var5 + 1);
         }
      }
   }

   public static serverrulesSupport v2(String var0) {
      JsonObject var1;
      try {
         JsonElement var2 = JsonParser.parseString(var0);
         if (!var2.isJsonObject()) {
            throw new IllegalArgumentException("server rules: not a JSON object");
         }

         var1 = var2.getAsJsonObject();
      } catch (JsonParseException var18) {
         throw new IllegalArgumentException("server rules: not JSON", var18);
      }

      long var19 = cloudSupport60.v3(var1, "format");
      if (var19 != 1L) {
         throw new IllegalArgumentException("server rules: format " + var19 + ", this build reads 1");
      } else {
         JsonElement var4 = var1.get("revision");
         if (var4 != null && var4.isJsonPrimitive() && var4.getAsJsonPrimitive().isNumber()) {
            JsonElement var5 = var1.get("servers");
            if (var5 != null && var5.isJsonArray()) {
               if (var5.getAsJsonArray().size() > 2000) {
                  throw new IllegalArgumentException("server rules: more than 2000 servers");
               } else {
                  ArrayList var6 = new ArrayList();
                  HashMap var7 = new HashMap();
                  LinkedHashSet var8 = new LinkedHashSet();

                  for (JsonElement var10 : var5.getAsJsonArray()) {
                     if (var10.isJsonObject()) {
                        JsonObject var11 = var10.getAsJsonObject();
                        serverrulesSupport.Part1 var12 = v1(var11);
                        if (var12 != null && var8.add(var12.v1())) {
                           List var13 = cloudSupport60.v1(var11, "domains", var0x -> true);
                           if (!var13.isEmpty() && var13.size() <= 64) {
                              for (String var15 : var13) {
                                 String var16 = serverrulesSupport2.v1(var15);
                                 if (var16 != null && serverrulesSupport2.v3(var16)) {
                                    serverrulesSupport.Part1 var17 = var7.putIfAbsent(var16, var12);
                                    if (var17 != null && var17 != var12) {
                                       v6.warn("server rules: {} and {} both claim {}; {} keeps it", new Object[]{var17.v1(), var12.v1(), var16, var17.v1()});
                                    }
                                 } else {
                                    v6.warn("server rules: {} names an invalid domain {}", var12.v1(), var15);
                                 }
                              }

                              var6.add(var12);
                           } else {
                              v6.warn("server rules: {} has no domains or too many, skipped", var12.v1());
                           }
                        } else {
                           v6.warn("server rules: skipped an invalid or repeated entry {}", cloudSupport60.v2(var11, "id"));
                        }
                     }
                  }

                  return new serverrulesSupport(var4.getAsLong(), var6, var7);
               }
            } else {
               throw new IllegalArgumentException("server rules: no servers array");
            }
         } else {
            throw new IllegalArgumentException("server rules: no revision");
         }
      }
   }

   @Nullable
   private static serverrulesSupport.Part1 v1(JsonObject var0) {
      String var1 = cloudSupport60.v1(var0, "id");
      if (var1 != null && v7.matcher(var1).matches()) {
         String var2 = cloudSupport60.v2(var0, "name").strip();
         if (var2.isEmpty() || var2.length() > 48 || !v3(var2)) {
            var2 = var1;
         }

         List var3 = cloudSupport60.v1(var0, "blocked", var0x -> v8.matcher(var0x).matches());
         return var3.size() > 256 ? null : new serverrulesSupport.Part1(var1, var2, Set.copyOf(var3));
      } else {
         return null;
      }
   }

   private static boolean v3(String var0) {
      for (int var1 = 0; var1 < var0.length(); var1++) {
         char var2 = var0.charAt(var1);
         if (var2 < ' ' || var2 > '~') {
            return false;
         }
      }

      return true;
   }

   public record Part1(String id, String name, Set<String> blocked) {
      public String v1() {
         return this.id;
      }

      public String v2() {
         return this.name;
      }

      public Set<String> v3() {
         return this.blocked;
      }
   }
}
