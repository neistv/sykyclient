package cc.syky.cloud;

import cc.syky.hud.MySettingsSupport;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport99 {
   public static final String v1 = "_actions";
   public static final String v2 = "clickgui";
   private static final Logger v3 = LoggerFactory.getLogger("syky.bind");
   private final MySettingsSupport v4;
   private final Map<String, cloudSupport99.Part1> v5 = new LinkedHashMap<>();
   private final Map<String, cloudRecord10> v6 = new LinkedHashMap<>();
   private int v7;

   public cloudSupport99(MySettingsSupport var1) {
      this.v4 = var1;
   }

   public void v1(String var1, String var2, cloudRecord10 var3) {
      if (var1 != null && !var1.isBlank()) {
         if (var3 != null && var3.v1() != -1) {
            if (this.v5.putIfAbsent(var1, new cloudSupport99.Part1(var2, var3)) != null) {
               throw new IllegalStateException("duplicate action: " + var1);
            }
         } else {
            throw new IllegalArgumentException("action '" + var1 + "' needs a real default key");
         }
      } else {
         throw new IllegalArgumentException("id must not be blank");
      }
   }

   public List<String> v1() {
      return List.copyOf(this.v5.keySet());
   }

   public String v1(String var1) {
      return this.v6(var1).v1();
   }

   public cloudRecord10 v2(String var1) {
      cloudRecord10 var2 = this.v6.get(var1);
      return var2 != null ? var2 : this.v6(var1).v2();
   }

   public cloudRecord10 v3(String var1) {
      return this.v6(var1).v2();
   }

   public boolean v4(String var1) {
      this.v6(var1);
      return !this.v6.containsKey(var1);
   }

   public void v1(String var1, cloudRecord10 var2) {
      cloudSupport99.Part1 var3 = this.v6(var1);
      if (var2 == null) {
         throw new IllegalArgumentException("key must not be null");
      } else if (var2.v1() == -1 || var2.equals(var3.v2())) {
         this.v5(var1);
      } else if (!var2.equals(this.v6.get(var1))) {
         this.v6.put(var1, var2);
         this.v7++;
         this.v5();
      }
   }

   public void v5(String var1) {
      this.v6(var1);
      if (this.v6.remove(var1) != null) {
         this.v7++;
         this.v5();
      }
   }

   public void v2() {
      if (!this.v6.isEmpty()) {
         this.v6.clear();
         this.v7++;
         this.v5();
      }
   }

   public boolean v1(String var1, int var2, int var3) {
      cloudRecord10 var4 = this.v2(var1);
      if (var4.v1() == -1) {
         return false;
      } else if (var4.v1() != var2) {
         return false;
      } else {
         int var5 = var4.v2();
         return (var3 & 15 & var5) == var5;
      }
   }

   public int v3() {
      return this.v7;
   }

   public void v4() {
      this.v6.clear();
      this.v7++;
      JsonObject var1 = this.v4.v11("_actions");
      if (var1 != null) {
         boolean var2 = false;

         for (Entry var4 : var1.entrySet()) {
            String var5 = (String)var4.getKey();
            cloudSupport99.Part1 var6 = this.v5.get(var5);
            if (var6 == null) {
               v3.info("dropping key for unknown action '{}'", var5);
               var2 = true;
            } else {
               cloudRecord10 var7 = v1(var5, (JsonElement)var4.getValue());
               if (var7 != null && var7.v1() != -1 && !var7.equals(var6.v2())) {
                  this.v6.put(var5, var7);
               }
            }
         }

         if (var2) {
            this.v5();
         }
      }
   }

   public void v5() {
      JsonObject var1 = new JsonObject();

      for (Entry var3 : this.v6.entrySet()) {
         JsonObject var4 = new JsonObject();
         var4.add("code", new JsonPrimitive(((cloudRecord10)var3.getValue()).v1()));
         var4.add("modifiers", new JsonPrimitive(((cloudRecord10)var3.getValue()).v2()));
         var1.add((String)var3.getKey(), var4);
      }

      this.v4.v2("_actions", var1);
   }

   private cloudSupport99.Part1 v6(String var1) {
      cloudSupport99.Part1 var2 = this.v5.get(var1);
      if (var2 == null) {
         throw new IllegalArgumentException("unknown action: " + var1);
      } else {
         return var2;
      }
   }

   @Nullable
   private static cloudRecord10 v1(String var0, JsonElement var1) {
      try {
         if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
            return cloudRecord10.v1(var1.getAsInt());
         } else if (!var1.isJsonObject()) {
            return null;
         } else {
            JsonObject var2 = var1.getAsJsonObject();
            int var3 = var2.has("code") && var2.get("code").isJsonPrimitive() ? var2.get("code").getAsInt() : -1;
            int var4 = var2.has("modifiers") && var2.get("modifiers").isJsonPrimitive() ? var2.get("modifiers").getAsInt() : 0;
            return new cloudRecord10(var3, var4);
         }
      } catch (RuntimeException var5) {
         v3.warn("invalid key for action {}: {}", new Object[]{var0, var1, var5});
         return null;
      }
   }

   public record Part1(String label, cloudRecord10 defaultKey) {
      public String v1() {
         return this.label;
      }

      public cloudRecord10 v2() {
         return this.defaultKey;
      }
   }
}
