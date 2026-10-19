package cc.syky.ui;

import cc.syky.cloud.cloudSupport100;
import cc.syky.cloud.cloudSupport92;
import cc.syky.hud.MySettingsSupport;
import cc.syky.module.ModuleCategory;
import cc.syky.module.ModuleContract;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport226 {
   private static final Logger v2 = LoggerFactory.getLogger("syky.modules");
   public static final int v1 = 3;
   private static final String v3 = "modules.tick";
   private static final String v4 = "modules.render";
   private static final String v5 = "modules.worldJoin";
   private static final String v6 = "modules.worldLeave";
   private static final String v7 = "_enabled";
   private final MySettingsSupport v8;
   private final uiSupport258 v9;
   private final Map<String, ModuleContract> v10 = new LinkedHashMap<>();
   private final Map<String, Boolean> v11 = new HashMap<>();
   private final Set<String> v12 = new LinkedHashSet<>();
   private boolean v13;
   private final Map<String, Integer> v14 = new HashMap<>();
   private final Map<String, String> v15 = new HashMap<>();
   private final Map<String, String> v16 = new HashMap<>();
   private final Map<String, String> v18 = new HashMap<>();
   private final Map<String, String> v19 = new HashMap<>();
   private final Map<ModuleCategory, List<ModuleContract>> v17 = new EnumMap<>(ModuleCategory.class);
   @Nullable
   private cloudSupport92 v20;
   private boolean v21;
   @Nullable
   private cloudSupport100 v22;
   private Set<String> v24 = Set.of();
   @Nullable
   private String v25;
   private static final uiSupport226.Part1 v26 = (var0, var1) -> var0.reset();
   private static final uiSupport226.Part1 v27 = ModuleContract::onWorldRender;
   private static final uiSupport226.Part1 v28 = (var0, var1) -> var0.onTick();
   private static final uiSupport226.Part1 v29 = (var0, var1) -> var0.onRender();

   public uiSupport226(MySettingsSupport var1) {
      this(var1, uiSupport258.v1);
   }

   public uiSupport226(MySettingsSupport var1, uiSupport258 var2) {
      this.v8 = var1;
      this.v9 = var2;
   }

   public void v1(cloudSupport92 var1) {
      this.v20 = var1;
   }

   public <M extends ModuleContract> M v1(M var1) {
      if (this.v10.putIfAbsent(var1.getName(), var1) != null) {
         throw new IllegalStateException("duplicate module: " + var1.getName());
      } else {
         String var2 = var1.getName();
         this.v15.put(var2, "modules.tick." + var2);
         this.v16.put(var2, "modules.render." + var2);
         this.v18.put(var2, "modules.worldJoin." + var2);
         this.v19.put(var2, "modules.worldLeave." + var2);
         this.v17.computeIfAbsent(var1.getCategory(), var0 -> new ArrayList<>()).add(var1);
         this.v8.v1(var2, var1.getSettings());
         boolean var3 = v1(this.v8.v11(var2), var1.isDefaultEnabled());
         this.v11.put(var2, var3);
         this.v21 = true;

         try {
            if (var3) {
               this.v11(var2);
            }
         } finally {
            this.v21 = false;
         }

         var1.getSettings().setOnChange(() -> this.v13(var2));
         v2.info("registered: {}", var2);
         return (M)var1;
      }
   }

   public void v1(String var1) {
      if (this.v10.get(var1) != null) {
         Boolean var2 = this.v11.put(var1, true);
         this.v11(var1);
         if (!Boolean.TRUE.equals(var2)) {
            this.v13(var1);
         }
      }
   }

   public void v2(String var1) {
      this.v11(var1);
   }

   private void v11(String var1) {
      ModuleContract var2 = this.v10.get(var1);
      if (var2 != null && !this.v24.contains(var1)) {
         boolean var3 = var2.isEnabled();

         try {
            var2.enable();
            this.v14.remove(var1);
         } catch (Throwable var5) {
            v2.error("module {} failed to enable", var1, var5);
            if (!this.v13 && this.v11.getOrDefault(var1, false)) {
               this.v12.add(var1);
            }

            return;
         }

         if (!var3 && var2.isEnabled()) {
            if (this.v20 != null) {
               this.v20.v1(new uiRecord9(var1));
            }

            this.v13(var1);
         }
      }
   }

   public void v3(String var1) {
      if (this.v10.get(var1) != null) {
         Boolean var2 = this.v11.put(var1, false);
         this.v12(var1);
         if (!Boolean.FALSE.equals(var2)) {
            this.v13(var1);
         }
      }
   }

   public void v4(String var1) {
      this.v12(var1);
   }

   private void v12(String var1) {
      ModuleContract var2 = this.v10.get(var1);
      if (var2 != null) {
         boolean var3 = var2.isEnabled();

         try {
            var2.disable();
            this.v14.remove(var1);
         } catch (Throwable var5) {
            v2.error("module {} failed to disable", var1, var5);
            return;
         }

         if (var3 && !var2.isEnabled()) {
            if (this.v20 != null) {
               this.v20.v1(new uiRecord10(var1));
            }

            this.v13(var1);
         }
      }
   }

   public void v5(String var1) {
      ModuleContract var2 = this.v10.get(var1);
      if (var2 != null && !this.v24.contains(var1)) {
         if (var2.isEnabled()) {
            this.v3(var1);
         } else {
            this.v1(var1);
         }
      }
   }

   public Collection<ModuleContract> v1() {
      return this.v10.values();
   }

   @Nullable
   public ModuleContract v6(String var1) {
      return this.v10.get(var1);
   }

   public List<ModuleContract> v1(ModuleCategory var1) {
      List var2 = this.v17.get(var1);
      return var2 == null ? Collections.emptyList() : Collections.unmodifiableList(var2);
   }

   public void v2() {
      for (ModuleContract var2 : this.v10.values()) {
         this.v8.v2(var2.getName(), this.v2(var2));
      }
   }

   public void v3() {
      this.v21 = true;

      try {
         for (ModuleContract var2 : this.v10.values()) {
            var2.getSettings().v8();
            this.v8.v1(var2.getName(), var2.getSettings());
            boolean var3 = v1(this.v8.v11(var2.getName()), var2.isDefaultEnabled());
            this.v11.put(var2.getName(), var3);
            if (var3 && !var2.isEnabled()) {
               this.v11(var2.getName());
            } else if (!var3 && var2.isEnabled()) {
               this.v12(var2.getName());
            } else if (var3) {
               this.v12(var2.getName());
               this.v11(var2.getName());
            }
         }
      } finally {
         this.v21 = false;
      }

      v2.info("reloaded {} module(s)", this.v10.size());
   }

   public void v7(String var1) {
      ModuleContract var2 = this.v10.get(var1);
      if (var2 != null) {
         var2.getSettings().v7();
      }
   }

   public void v4() {
      for (ModuleContract var2 : this.v10.values()) {
         var2.getSettings().v8();
      }
   }

   public void v5() {
      for (ModuleContract var2 : this.v10.values()) {
         boolean var3 = this.v11.getOrDefault(var2.getName(), false);
         if (!var2.isDefaultEnabled()) {
            if (var2.isEnabled() || var3) {
               this.v3(var2.getName());
            }
         } else if (!var2.isEnabled() || !var3) {
            this.v1(var2.getName());
         }
      }
   }

   public void v1(Set<String> var1, @Nullable String var2, boolean var3) {
      Set var4 = this.v24;
      this.v24 = Set.copyOf(var1);
      this.v25 = this.v24.isEmpty() ? null : var2;

      for (String var6 : this.v24) {
         this.v12(var6);
      }

      for (String var10 : var4) {
         ModuleContract var7 = this.v10.get(var10);
         if (var7 != null && !this.v24.contains(var10) && !var7.isEnabled() && this.v11.getOrDefault(var10, false)) {
            this.v11(var10);
            if (var3 && var7.isEnabled()) {
               Throwable var8 = this.v1(var7, this.v18.get(var10), v28, null);
               if (var8 != null) {
                  this.v1(var7, "worldJoin", var8);
               }
            }
         }
      }
   }

   @Nullable
   public String v8(String var1) {
      return this.v24.contains(var1) ? this.v25 : null;
   }

   public boolean v9(String var1) {
      ModuleContract var2 = this.v10.get(var1);
      return var2 != null && this.v11.getOrDefault(var1, var2.isEnabled());
   }

   private void v13(String var1) {
      if (!this.v21) {
         ModuleContract var2 = this.v10.get(var1);
         if (var2 != null) {
            this.v8.v2(var1, this.v2(var2));
         }
      }
   }

   private JsonObject v2(ModuleContract var1) {
      JsonObject var2 = var1.getSettings().save();
      var2.addProperty("_enabled", this.v11.getOrDefault(var1.getName(), var1.isEnabled()));
      return var2;
   }

   private static boolean v1(@Nullable JsonObject var0, boolean var1) {
      if (var0 != null && var0.has("_enabled")) {
         JsonElement var2 = var0.get("_enabled");
         return var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isBoolean() ? var2.getAsBoolean() : var1;
      } else {
         return var1;
      }
   }

   public void v6() {
      this.v9();
      this.v1("modules.tick", this.v15, "tick", v26, null);
   }

   private void v9() {
      if (!this.v12.isEmpty()) {
         ArrayList var1 = new ArrayList<>(this.v12);
         this.v12.clear();
         this.v13 = true;

         try {
            for (String var3 : var1) {
               ModuleContract var4 = this.v10.get(var3);
               if (var4 != null && !var4.isEnabled() && this.v11.getOrDefault(var3, false)) {
                  v2.info("retrying activation of module {} now that the client is up", var3);
                  this.v11(var3);
               }
            }
         } finally {
            this.v13 = false;
         }
      }
   }

   public void v1(Object var1) {
      this.v1("modules.render", this.v16, "worldRender", v27, var1);
   }

   public void v1(@Nullable String var1, @Nullable String var2) {
      cloudSupport100 var4 = (var1 != null && !this.v24.contains(var1) ? (ModuleContract)this.v10.get(var1) : null) instanceof cloudSupport100 var5
         ? var5
         : null;
      cloudSupport100 var6 = this.v22;
      if (var4 != var6) {
         this.v22 = var4;
         if (var6 != null) {
            var6.v2();
         }
      }

      if (var4 != null) {
         var4.v1(var2);
         var4.v1();
      }
   }

   public void v7() {
      this.v1("modules.worldJoin", this.v18, "worldJoin", v28, null);
   }

   public void v8() {
      this.v1("modules.worldLeave", this.v19, "worldLeave", v29, null);
   }

   public int v10(String var1) {
      Integer var2 = this.v14.get(var1);
      return var2 == null ? 0 : var2;
   }

   private void v1(String var1, Map<String, String> var2, String var3, uiSupport226.Part1 var4, @Nullable Object var5) {
      long var6 = this.v9.v3();

      try {
         for (ModuleContract var9 : this.v10.values()) {
            if (!var9.isEnabled()) {
               this.v14.remove(var9.getName());
            } else {
               Throwable var10 = this.v1(var9, (String)var2.get(var9.getName()), var4, var5);
               if (var10 == null) {
                  this.v14.remove(var9.getName());
               } else {
                  this.v1(var9, var3, var10);
               }
            }
         }
      } finally {
         this.v9.v1(var1, var6);
      }
   }

   @Nullable
   private Throwable v1(ModuleContract var1, @Nullable String var2, uiSupport226.Part1 var3, @Nullable Object var4) {
      long var5 = this.v9.v3();

      Throwable var8;
      try {
         var3.invoke(var1, var4);
         return null;
      } catch (Throwable var12) {
         var8 = var12;
      } finally {
         this.v9.v1(var2, var5);
      }

      return var8;
   }

   private void v1(ModuleContract var1, String var2, Throwable var3) {
      int var4 = this.v14.merge(var1.getName(), 1, Integer::sum);
      v2.error("module {} threw in {} (#{} consecutive)", new Object[]{var1.getName(), var2, var4, var3});
      if (var4 >= 3) {
         v2.warn("auto-disabling module {} after {} consecutive errors", var1.getName(), var4);
         boolean var5 = var1.isEnabled();

         try {
            var1.disable();
         } catch (Throwable var7) {
            v2.error("module {} failed to auto-disable", var1.getName(), var7);
         }

         this.v14.remove(var1.getName());
         if (var5 && !var1.isEnabled()) {
            if (this.v20 != null) {
               this.v20.v1(new uiRecord10(var1.getName()));
            }

            this.v13(var1.getName());
         }
      }
   }

   @FunctionalInterface
   public interface Part1 {
      void invoke(ModuleContract var1, @Nullable Object var2);
   }
}
