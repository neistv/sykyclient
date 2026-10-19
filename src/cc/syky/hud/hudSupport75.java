package cc.syky.hud;

import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudRecord11;
import cc.syky.cloud.cloudSupport93;
import cc.syky.cloud.cloudSupport95;
import cc.syky.cloud.cloudSupport96;
import cc.syky.cloud.cloudSupport97;
import cc.syky.render.renderSupport47;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class hudSupport75 {
   public static final String v1 = "_binds";
   private static final Logger v2 = LoggerFactory.getLogger("syky.bind");
   private final cloudSupport95 v3;
   private final MySettingsSupport v4;
   private final Map<String, cloudRecord11> v5 = new LinkedHashMap<>();
   private final Map<String, cloudSupport96> v6 = new HashMap<>();
   private final Map<Integer, List<String>> v7 = new HashMap<>();
   private int v8;
   @Nullable
   private cloudSupport97 v9;
   @Nullable
   private cloudSupport93 v10;

   public hudSupport75(cloudSupport95 var1, MySettingsSupport var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   public void v1(cloudSupport93 var1) {
      this.v10 = var1;
      this.v7();
      this.v8++;
   }

   public void v1() {
      cloudSupport93 var1 = this.v10;
      if (var1 != null) {
         this.v5.keySet().removeIf(var1::v1);
         this.v6.keySet().removeIf(var1::v1);
         this.v7();
         this.v8++;
      }
   }

   private void v7() {
      cloudSupport93 var1 = this.v10;
      if (var1 != null) {
         for (cloudRecord11 var3 : var1.v1()) {
            String var4 = var3.v2();
            if (var1.v1(var4) && this.v3.v1(var4)) {
               this.v6.put(var4, var3.v5());
               if (var3.v3() != -1) {
                  this.v5.put(var4, var3);
               }
            }
         }
      }
   }

   private boolean v5(String var1) {
      cloudSupport93 var2 = this.v10;
      return var2 != null && var2.v1(var1);
   }

   public void v1(@Nullable cloudSupport97 var1) {
      this.v9 = var1;
   }

   public int v2() {
      return this.v8;
   }

   public void v3() {
      this.v5.clear();
      this.v7.clear();
      this.v6.clear();
      JsonObject var1 = this.v4.v11("_binds");
      boolean var2 = false;
      if (var1 != null) {
         for (Entry var4 : var1.entrySet()) {
            String var5 = (String)var4.getKey();
            if (this.v5(var5)) {
               var2 = true;
            } else if (!this.v3.v1(var5)) {
               v2.info("dropping orphaned bind for unknown target '{}'", var5);
               var2 = true;
            } else {
               cloudRecord11 var6 = v1(var5, (JsonElement)var4.getValue());
               if (var6 != null && var6.v3() != -1) {
                  this.v5.put(var5, var6);
                  this.v6.put(var5, var6.v5());
               }
            }
         }
      }

      this.v7();
      if (var2) {
         this.v4();
      }

      this.v8++;
      v2.info("loaded {} bind(s)", this.v5.size());
   }

   @Nullable
   private static cloudRecord11 v1(String var0, JsonElement var1) {
      try {
         if (var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
            return new cloudRecord11(var0, var1.getAsInt(), 0, cloudSupport96.TOGGLE);
         } else if (!var1.isJsonObject()) {
            return null;
         } else {
            JsonObject var2 = var1.getAsJsonObject();
            int var3 = var2.has("code") && var2.get("code").isJsonPrimitive() ? var2.get("code").getAsInt() : -1;
            int var4 = var2.has("modifiers") && var2.get("modifiers").isJsonPrimitive() ? var2.get("modifiers").getAsInt() : 0;
            cloudSupport96 var5 = cloudSupport96.v1(
               var2.has("mode") && var2.get("mode").isJsonPrimitive() ? var2.get("mode").getAsString() : null, cloudSupport96.TOGGLE
            );
            return new cloudRecord11(var0, var3, var4, renderSupport47.v1(var5));
         }
      } catch (RuntimeException var6) {
         v2.warn("invalid bind for target {}: {}", new Object[]{var0, var1, var6});
         return null;
      }
   }

   public void v4() {
      JsonObject var1 = new JsonObject();

      for (cloudRecord11 var3 : this.v5.values()) {
         if (!this.v5(var3.v2())) {
            JsonObject var4 = new JsonObject();
            var4.add("code", new JsonPrimitive(var3.v3()));
            var4.add("modifiers", new JsonPrimitive(var3.v4()));
            var4.add("mode", new JsonPrimitive(var3.v5().name()));
            var1.add(var3.v2(), var4);
         }
      }

      this.v4.v2("_binds", var1);
   }

   public void v1(String var1, cloudRecord10 var2, cloudSupport96 var3) {
      if (var2 != null && var3 != null) {
         this.v6.put(var1, var3);
         if (var2.v1() == -1) {
            boolean var4 = this.v5.remove(var1) != null;
            if (var4) {
               this.v8++;
            }

            this.v1(var1, null, var3, var4);
         } else {
            this.v5.put(var1, new cloudRecord11(var1, var2.v1(), var2.v2(), var3));
            this.v8++;
            this.v1(var1, var2, var3, true);
         }
      } else {
         throw new IllegalArgumentException("key and mode must not be null");
      }
   }

   public void v1(String var1, cloudRecord10 var2) {
      this.v1(var1, var2, this.v2(var1));
   }

   public boolean v1(String var1) {
      return this.v3.v7(var1);
   }

   public cloudSupport96 v2(String var1) {
      cloudRecord11 var2 = this.v5.get(var1);
      return var2 != null ? var2.v5() : this.v6.getOrDefault(var1, cloudSupport96.TOGGLE);
   }

   public Optional<cloudRecord11> v3(String var1) {
      return Optional.ofNullable(this.v5.get(var1));
   }

   public void v4(String var1) {
      if (this.v5.remove(var1) != null) {
         this.v8++;
         this.v1(var1, null, this.v2(var1), true);
      }
   }

   public void v5() {
      this.v5.clear();
      this.v7.clear();
      this.v6.clear();
      this.v7();
      this.v8++;
      this.v4();
   }

   private void v1(String var1, @Nullable cloudRecord10 var2, cloudSupport96 var3, boolean var4) {
      cloudSupport93 var5 = this.v10;
      if (var5 != null && var5.v1(var1)) {
         var5.v1(var1, var2, var3);
      } else {
         if (var4) {
            this.v4();
         }
      }
   }

   public List<String> v1(cloudRecord10 var1) {
      ArrayList var2 = new ArrayList(1);

      for (cloudRecord11 var4 : this.v5.values()) {
         if (var4.v1().equals(var1)) {
            var2.add(var4.v2());
         }
      }

      return var2;
   }

   public Collection<cloudRecord11> v6() {
      return Collections.unmodifiableCollection(new ArrayList<>(this.v5.values()));
   }

   public boolean v1(int var1, int var2) {
      int var3 = var2 & 15;
      List var4 = this.v2(var1, var3);
      if (var4.isEmpty()) {
         return false;
      } else {
         boolean var5 = false;
         boolean var6 = false;

         for (cloudRecord11 var8 : var4) {
            if (!this.v3.v8(var8.v2())) {
               var6 = true;
               if (var8.v5() == cloudSupport96.HOLD && this.v3.v7(var8.v2())) {
                  boolean var9 = this.v6(var8.v2());
                  this.v3.v4(var8.v2());
                  if (!var9 && this.v6(var8.v2())) {
                     this.v7.computeIfAbsent(var1, var0 -> new ArrayList<>(1)).add(var8.v2());
                  }
               } else {
                  this.v3.v3(var8.v2());
               }

               var5 |= this.v6(var8.v2());
            }
         }

         if (var6) {
            this.v1(var5);
         }

         return true;
      }
   }

   private List<cloudRecord11> v2(int var1, int var2) {
      ArrayList var3 = new ArrayList(2);
      int var4 = -1;

      for (cloudRecord11 var6 : this.v5.values()) {
         if (var6.v3() == var1) {
            int var7 = var6.v4();
            if ((var2 & var7) == var7) {
               int var8 = Integer.bitCount(var7);
               if (var8 > var4) {
                  var4 = var8;
                  var3.clear();
                  var3.add(var6);
               } else if (var8 == var4) {
                  var3.add(var6);
               }
            }
         }
      }

      return var3;
   }

   public boolean v1(int var1) {
      List var2 = this.v7.remove(var1);
      if (var2 != null && !var2.isEmpty()) {
         boolean var3 = false;

         for (String var5 : var2) {
            this.v3.v5(var5);
            var3 |= this.v6(var5);
         }

         this.v1(var3);
         return true;
      } else {
         return false;
      }
   }

   private void v1(boolean var1) {
      cloudSupport97 var2 = this.v9;
      if (var2 != null) {
         var2.bindFired(var1);
      }
   }

   private boolean v6(String var1) {
      return this.v3.v2(var1);
   }
}
