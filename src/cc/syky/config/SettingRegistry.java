package cc.syky.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SettingRegistry {
   private static final Logger v1 = LoggerFactory.getLogger("syky.settings");
   private final Map<String, Setting<?>> v2 = new LinkedHashMap<>();
   private final Map<Setting<?>, SettingCondition> v3 = new IdentityHashMap<>();
   private final Set<Setting<?>> v4 = Collections.newSetFromMap(new IdentityHashMap<>());
   private final Map<String, JsonElement> v5 = new LinkedHashMap<>();
   @Nullable
   private Runnable v6;
   private boolean v7;

   public SettingRegistry() {
   }

   public <T, S extends Setting<T>> S add(S var1) {
      if (this.v2.putIfAbsent(var1.getName(), var1) != null) {
         throw new IllegalStateException("duplicate setting: " + var1.getName());
      } else {
         var1.onChange(this::notifyChange);
         return (S)var1;
      }
   }

   public <T, S extends Setting<T>> S add(S var1, SettingCondition var2) {
      this.add((S)var1);

      for (SettingCondition var3 = var2; var3 != null; var3 = var3.v2()) {
         Setting var4 = var3.v1();
         if (var4 != null && this.v2.get(var4.getName()) != var4) {
            throw new IllegalStateException("gate parent '" + var4.getName() + "' is not registered before '" + var1.getName() + "'");
         }
      }

      this.v3.put(var1, var2);
      return (S)var1;
   }

   public <T, S extends Setting<T>> S addHidden(S var1) {
      this.add((S)var1);
      this.v4.add(var1);
      return (S)var1;
   }

   public <T, S extends Setting<T>> S addHidden(S var1, SettingCondition var2) {
      this.add((S)var1, var2);
      this.v4.add(var1);
      return (S)var1;
   }

   public boolean isHidden(Setting<?> var1) {
      return this.v4.contains(var1);
   }

   @Nullable
   public Setting<?> getVisibleParent(Setting<?> var1) {
      Setting var2 = v8(var1);
      Setting var3 = var2 != null && this.v2.get(var2.getName()) == var2 ? var2 : var1;
      return this.findVisibleParent(var3);
   }

   @Nullable
   private Setting<?> findVisibleParent(Setting<?> var1) {
      for (SettingCondition var2 = this.v3.get(var1); var2 != null; var2 = var2.v2()) {
         Setting var3 = var2.v1();
         if (var3 != null) {
            if (this.v4.contains(var3)) {
               return var3;
            }

            Setting var4 = this.findVisibleParent(var3);
            if (var4 != null) {
               return var4;
            }
         }
      }

      return null;
   }

   public boolean isVisible(Setting<?> var1) {
      return this.isVisibleFor(var1, null);
   }

   public boolean isVisibleFor(Setting<?> var1, @Nullable Setting<?> var2) {
      if (var1 == var2) {
         return true;
      } else {
         Setting var3 = v8(var1);
         if (var3 != null && this.v2.get(var3.getName()) == var3 && !this.isVisibleFor(var3, var2)) {
            return false;
         } else {
            for (SettingCondition var4 = this.v3.get(var1); var4 != null; var4 = var4.v2()) {
               Setting var5 = var4.v1();
               if (var5 == null || var5 != var2) {
                  if (!var4.v3()) {
                     return false;
                  }

                  if (var5 != null && !this.isVisibleFor(var5, var2)) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }

   @Nullable
   private static Setting<?> v8(Setting<?> var0) {
      return var0 instanceof SettingOwner var1 ? var1.v1() : null;
   }

   public Collection<Setting<?>> all() {
      return this.v2.values();
   }

   @Nullable
   public Setting<?> byName(String var1) {
      return this.v2.get(var1);
   }

   public Map<Setting<?>, ColorSetting> colorMap() {
      IdentityHashMap var1 = new IdentityHashMap();

      for (Setting var3 : this.v2.values()) {
         if (var3 instanceof ColorSetting var4) {
            Setting var5 = var4.getCondition();
            if (var5 != null && this.v2.get(var5.getName()) == var5) {
               var1.putIfAbsent(var5, var4);
            }
         }
      }

      return var1;
   }

   public Set<Setting<?>> hiddenSet() {
      Set var1 = Collections.newSetFromMap(new IdentityHashMap());

      for (Setting var3 : this.v2.values()) {
         if (var3 instanceof ColorSetting var4 && var4.getConditionEnum() != null) {
            var1.add(var4.getConditionEnum());
         }
      }

      return var1;
   }

   public Map<BooleanSetting, Setting<?>> conditionMap() {
      Set var1 = this.v9();
      IdentityHashMap var2 = new IdentityHashMap();

      for (Setting var4 : this.v2.values()) {
         if (!(var4 instanceof ColorSetting) && v8(var4) instanceof BooleanSetting var5 && var1.contains(var5)) {
            var2.putIfAbsent(var5, var4);
         }
      }

      return var2;
   }

   private Set<BooleanSetting> v9() {
      Set var1 = Collections.newSetFromMap(new IdentityHashMap());

      for (Setting var3 : this.v2.values()) {
         if (var3 instanceof BooleanSetting var4) {
            var1.add(var4);
         }
      }

      return var1;
   }

   public void setOnChange(Runnable var1) {
      this.v6 = var1;
   }

   private void notifyChange() {
      if (!this.v7) {
         if (this.v6 != null) {
            this.v6.run();
         }
      }
   }

   public JsonObject save() {
      JsonObject var1 = new JsonObject();

      for (Setting var3 : this.v2.values()) {
         var1.add(var3.getName(), var3.toJson());
      }

      for (Entry var5 : this.v5.entrySet()) {
         if (!this.v2.containsKey(var5.getKey())) {
            var1.add((String)var5.getKey(), (JsonElement)var5.getValue());
         }
      }

      return var1;
   }

   public void load(JsonObject var1) {
      if (var1 != null) {
         this.v7 = true;

         try {
            for (Setting var3 : this.v2.values()) {
               try {
                  var3.fromJson(var1.get(var3.getName()));
               } catch (RuntimeException var8) {
                  v1.warn("failed to read setting '{}'; keeping its default", var3.getName(), var8);
               }
            }

            this.v5.clear();

            for (Entry var11 : var1.entrySet()) {
               String var4 = (String)var11.getKey();
               if (!var4.startsWith("_") && !this.v2.containsKey(var4)) {
                  this.v5.put(var4, (JsonElement)var11.getValue());
               }
            }
         } finally {
            this.v7 = false;
         }
      }
   }

   public boolean v6() {
      return v1(this.v2.values());
   }

   public static boolean v1(Collection<? extends Setting<?>> var0) {
      for (Setting var2 : var0) {
         if (var2.isModified()) {
            return true;
         }
      }

      return false;
   }

   public Set<Setting<?>> v6(Setting<?> var1) {
      Set var2 = Collections.newSetFromMap(new IdentityHashMap());
      var2.add(var1);
      ColorSetting var3 = this.colorMap().get(var1);
      if (var3 != null) {
         var2.add(var3);
      }

      if (var1 instanceof BooleanSetting var4) {
         Setting var5 = this.conditionMap().get(var4);
         if (var5 != null) {
            var2.add(var5);
         }
      }

      for (Setting var10 : this.v2.values()) {
         for (Setting var6 = this.getVisibleParent(var10); var6 != null; var6 = this.getVisibleParent(var6)) {
            if (var6 == var1) {
               var2.add(var10);
               break;
            }
         }
      }

      for (Setting var11 : List.copyOf(var2)) {
         EnumSetting var12 = var11 instanceof ColorSetting var7 ? var7.getConditionEnum() : null;
         if (var12 != null) {
            var2.add(var12);
         }
      }

      return var2;
   }

   public void v7() {
      this.v2(this.v2.values());
   }

   public void v2(Collection<? extends Setting<?>> var1) {
      for (Setting var3 : var1) {
         var3.reset();
      }

      this.notifyChange();
   }

   public void v8() {
      for (Setting var2 : this.v2.values()) {
         var2.reset();
      }

      this.v5.clear();
   }
}
