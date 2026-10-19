package cc.syky.ui;

import cc.syky.config.Setting;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport149 implements Setting<Set<String>> {
   private final String v1;
   private final LinkedHashSet<String> v2 = new LinkedHashSet<>();
   private Supplier<List<String>> v3 = List::of;
   @Nullable
   private Runnable v4;

   public uiSupport149(String var1) {
      this.v1 = var1;
   }

   public uiSupport149 v1(Supplier<List<String>> var1) {
      this.v3 = var1 != null ? var1 : List::of;
      return this;
   }

   public List<String> v1() {
      return this.v3.get();
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

      if (!var2.equals(this.v2) && this.v4 != null) {
         this.v4.run();
      }
   }

   public boolean v1(String var1) {
      return this.v2.contains(var1);
   }

   public void v2(String var1) {
      if (!this.v2.add(var1)) {
         this.v2.remove(var1);
      }

      if (this.v4 != null) {
         this.v4.run();
      }
   }

   @Override
   public Class<Set<String>> getType() {
      return Set.class;
   }

   @Override
   public void onChange(Runnable var1) {
      this.v4 = var1;
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
      }
   }

   @Override
   public void reset() {
      this.v2.clear();
   }

   @Override
   public boolean isModified() {
      return !this.v2.isEmpty();
   }
}
