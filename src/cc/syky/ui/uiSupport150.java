package cc.syky.ui;

import cc.syky.config.Setting;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport150 implements Setting<Set<String>> {
   private final String v1;
   private final LinkedHashSet<String> v2 = new LinkedHashSet<>();
   private int v3;
   private Supplier<List<uiSupport150.Part1>> v4 = List::of;
   @Nullable
   private Runnable v5;

   public uiSupport150(String var1) {
      this.v1 = var1;
   }

   public uiSupport150 v1(Supplier<List<uiSupport150.Part1>> var1) {
      this.v4 = var1 != null ? var1 : List::of;
      return this;
   }

   public List<uiSupport150.Part1> v1() {
      return this.v4.get();
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public Set<String> v8() {
      return this.v2;
   }

   public void v1(Set<String> var1) {
      LinkedHashSet var2 = new LinkedHashSet<>(this.v2);
      this.v2.clear();
      if (var1 != null) {
         this.v2.addAll(var1);
      }

      this.v3++;
      if (!var2.equals(this.v2) && this.v5 != null) {
         this.v5.run();
      }
   }

   public boolean v1(String var1) {
      return !this.v2.contains(var1);
   }

   public void v2(String var1) {
      if (!this.v2.add(var1)) {
         this.v2.remove(var1);
      }

      this.v3++;
      if (this.v5 != null) {
         this.v5.run();
      }
   }

   public int v9() {
      int var1 = 0;

      for (uiSupport150.Part1 var3 : this.v1()) {
         if (this.v1(var3.v1())) {
            var1++;
         }
      }

      return var1;
   }

   public void v2(Set<String> var1) {
      if (this.v2.retainAll(var1)) {
         this.v3++;
         if (this.v5 != null) {
            this.v5.run();
         }
      }
   }

   @Override
   public Class<Set<String>> getType() {
      return Set.class;
   }

   @Override
   public void onChange(Runnable var1) {
      this.v5 = var1;
   }

   @Override
   public JsonElement toJson() {
      JsonArray var1 = new JsonArray();

      for (String var3 : this.v2) {
         var1.add(var3);
      }

      return var1;
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonArray()) {
         this.v2.clear();

         for (JsonElement var3 : var1.getAsJsonArray()) {
            if (var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isString()) {
               this.v2.add(var3.getAsString());
            }
         }

         this.v3++;
      }
   }

   @Override
   public void reset() {
      this.v2.clear();
      this.v3++;
   }

   public int v10() {
      return this.v3;
   }

   @Override
   public boolean isModified() {
      return !this.v2.isEmpty();
   }

   public record Part1(String id, String label) {
      public String v1() {
         return this.id;
      }

      public String v2() {
         return this.label;
      }
   }
}
