package cc.syky;

import cc.syky.cloud.cloudSupport60;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record sykyRecord3(List<sykyRecord2> entries, List<String> headingOrder) {
   private static final Logger LOG = LoggerFactory.getLogger("syky.whatsnew");
   private static final int MAX_ENTRIES = 64;

   public sykyRecord3(List<sykyRecord2> entries, List<String> headingOrder) {
      entries = List.copyOf(entries);
      headingOrder = List.copyOf(headingOrder);
      this.entries = entries;
      this.headingOrder = headingOrder;
   }

   @Nullable
   public static sykyRecord3 v1(String var0) {
      try {
         JsonElement var1 = JsonParser.parseString(var0);
         if (var1 != null && var1.isJsonObject()) {
            JsonElement var2 = var1.getAsJsonObject().get("entries");
            if (var2 != null && var2.isJsonArray()) {
               JsonArray var3 = var2.getAsJsonArray();
               ArrayList var4 = new ArrayList();

               for (JsonElement var6 : var3) {
                  if (var6.isJsonObject()) {
                     sykyRecord2 var7 = v1(var6.getAsJsonObject());
                     if (var7 != null) {
                        var4.add(var7);
                        if (var4.size() >= 64) {
                           break;
                        }
                     }
                  }
               }

               return new sykyRecord3(var4, cloudSupport60.v1(var1.getAsJsonObject(), "headingOrder", sykyRecord3::v5));
            } else {
               return null;
            }
         } else {
            return null;
         }
      } catch (RuntimeException var8) {
         LOG.debug("changelog body did not parse", var8);
         return null;
      }
   }

   public List<sykyRecord2> v1(@Nullable String var1, String var2) {
      int var3 = this.v4(var2);
      if (var3 >= 0 && var1 != null) {
         int var4 = this.v4(var1);
         if (var4 < 0) {
            return List.copyOf(this.entries.subList(var3, this.entries.size()));
         } else {
            return var4 <= var3 ? List.of() : List.copyOf(this.entries.subList(var3, var4));
         }
      } else {
         return List.of();
      }
   }

   public Set<String> v2(@Nullable String var1, String var2) {
      return v1(this.v1(var1, var2));
   }

   public Set<String> v1() {
      return v1(this.entries);
   }

   private static Set<String> v1(List<sykyRecord2> var0) {
      LinkedHashSet var1 = new LinkedHashSet();

      for (sykyRecord2 var3 : var0) {
         var1.addAll(var3.v4());
      }

      return var1;
   }

   public List<sykyRecord2> v2() {
      return this.entries;
   }

   public boolean v2(String var1) {
      return this.v4(var1) >= 0;
   }

   public String v3(String var1) {
      int var2 = this.v4(var1);
      return var2 < 0 ? var1 : this.entries.get(var2).v2();
   }

   private int v4(String var1) {
      for (int var2 = 0; var2 < this.entries.size(); var2++) {
         if (this.entries.get(var2).v1().equals(var1)) {
            return var2;
         }
      }

      return -1;
   }

   @Nullable
   private static sykyRecord2 v1(JsonObject var0) {
      String var1 = cloudSupport60.v1(var0, "version");
      if (var1 != null && !var1.isBlank()) {
         List var2 = v2(var0);
         if (var2.isEmpty()) {
            return null;
         } else {
            String var3 = cloudSupport60.v1(var0, "label");
            return new sykyRecord2(var1, var3 != null && !var3.isBlank() ? var3 : var1, var2, cloudSupport60.v1(var0, "modules", sykyRecord3::v5));
         }
      } else {
         return null;
      }
   }

   private static List<sykyRecord2.Part1> v2(JsonObject var0) {
      ArrayList var1 = new ArrayList();
      JsonElement var2 = var0.get("groups");
      if (var2 != null && var2.isJsonArray()) {
         for (JsonElement var4 : var2.getAsJsonArray()) {
            if (var4.isJsonObject()) {
               JsonObject var5 = var4.getAsJsonObject();
               List var6 = cloudSupport60.v1(var5, "lines", sykyRecord3::v5);
               if (!var6.isEmpty()) {
                  String var7 = cloudSupport60.v1(var5, "title");
                  var1.add(new sykyRecord2.Part1(var7 == null ? "" : var7, var6));
               }
            }
         }

         return var1;
      } else {
         List var3 = cloudSupport60.v1(var0, "lines", sykyRecord3::v5);
         if (!var3.isEmpty()) {
            var1.add(new sykyRecord2.Part1("", var3));
         }

         return var1;
      }
   }

   private static boolean v5(String var0) {
      return !var0.isBlank();
   }

   public List<sykyRecord2> v3() {
      return this.entries;
   }

   public List<String> v4() {
      return this.headingOrder;
   }
}
