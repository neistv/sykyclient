package cc.syky.config;

import cc.syky.cloud.cloudSupport66;
import cc.syky.hud.MySettingsSupport;
import cc.syky.hud.hudSupport63;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NewConfigSupport {
   private static final Logger v3 = LoggerFactory.getLogger("syky.profiles");
   private static final Gson v4 = new Gson();
   public static final String v1 = "_current.json";
   public static final String v2 = "_client.json";
   private static final String v5 = "autoSave";
   private static final long v6 = 1500L;
   private static final long v7 = 500L;
   private static final String v8 = "New config";
   private final MySettingsSupport v9;
   private final Path v10;
   private final List<ActionSetting> v11;
   private final configSupport12 v12 = new configSupport12();
   @Nullable
   private String v13;
   @Nullable
   private String v14;
   private long v15;
   private long v16;
   private boolean v18 = true;
   private boolean v19;

   public NewConfigSupport(MySettingsSupport var1, List<ActionSetting> var2) {
      this(var1, var1.v1(), var2);
   }

   public NewConfigSupport(MySettingsSupport var1, Path var2, List<ActionSetting> var3) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = List.copyOf(var3);
   }

   public void v1() {
      this.v9.v12();
      cloudSupport66.v1(this.v10, 3600000L);
      this.v13();
   }

   private void v13() {
      if (this.v9.v9().isEmpty()) {
         JsonObject var1 = new JsonObject();

         try {
            this.v9.v1("My settings", var1);
            v3.info("seeded {}{}", "My settings", ".syky");
         } catch (IOException var3) {
            v3.error("failed to seed the default config", var3);
         }
      }
   }

   public void v2() {
      this.v18 = this.v16();
      Optional var1 = this.v19();
      if (var1.isPresent() && MySettingsSupport.v12((String)var1.get()) && this.v9.v8((String)var1.get())) {
         this.v9.v9((String)var1.get());
         v3.info("bootstrap → {}", var1.get());
      } else {
         String var2 = this.v9.v8("My settings") ? "My settings" : this.v14();
         if (var2 != null) {
            this.v9.v9(var2);
            v3.info("bootstrap → {} (fallback)", var2);
         }
      }
   }

   @Nullable
   private String v14() {
      List var1 = this.v9.v9();
      return var1.isEmpty() ? null : (String)var1.get(0);
   }

   public void v3() {
      this.v14 = this.v9.v8();
      this.v15();
      this.v13 = this.v9.v11();
      this.v19 = false;
      v3.info("active config '{}' auto-save={}", this.v9.v3(), this.v18);
   }

   public List<String> v4() {
      return this.v9.v9();
   }

   public String v5() {
      return this.v9.v3();
   }

   public boolean v1(String var1) {
      return this.v9.v8(var1);
   }

   public Path v2(String var1) {
      return this.v9.v1(var1);
   }

   public long v3(String var1) {
      return this.v9.v3(var1);
   }

   public boolean v6() {
      return this.v18;
   }

   public boolean v7() {
      return this.v19;
   }

   public boolean v4(String var1) {
      if (!MySettingsSupport.v12(var1) || !this.v9.v8(var1)) {
         return false;
      } else if (var1.equals(this.v9.v3())) {
         return true;
      } else if (!this.v9.v2(var1)) {
         v3.warn("refusing to load unparseable config {}", var1);
         return false;
      } else {
         this.v9();
         this.v10();
         this.v9.v9(var1);
         this.v9.v5();

         for (ActionSetting var3 : this.v11) {
            var3.v2().run();
         }

         this.v11(var1);
         this.v14 = this.v9.v8();
         this.v13 = this.v9.v11();
         this.v19 = false;
         v3.info("switched → {}", var1);
         return true;
      }
   }

   public boolean v1(boolean var1) {
      this.v18 = var1;
      this.v18();
      return this.v2(true) == MySettingsSupport.Part1.WRITTEN;
   }

   public boolean v8() {
      return this.v2(true) == MySettingsSupport.Part1.WRITTEN;
   }

   public void v1(long var1) {
      if (var1 < this.v16) {
         this.v16 = var1;
         this.v15 = var1;
      }

      long var3 = this.v18 ? 1500L : 500L;
      if (var1 - this.v16 >= var3) {
         this.v16 = var1;
         boolean var5 = var1 - this.v15 >= 1500L;
         if (var5) {
            this.v15 = var1;
         }

         if (this.v18 && var5) {
            if (this.v12.v2()) {
               this.v13 = null;
            }

            String var6 = this.v12.v1();
            if (var6 != null) {
               this.v14 = var6;
            }
         }

         this.v15();
         String var7 = this.v9.v11();
         this.v19 = !var7.equals(this.v13);
         if (this.v18 && var5 && this.v19) {
            if (this.v9.v7()) {
               this.v13 = var7;
               this.v19 = false;
            } else {
               if (this.v12.v1(this.v9.v4(), var7, this.v14, this.v13)) {
                  this.v13 = var7;
                  this.v19 = false;
               }
            }
         }
      }
   }

   public void v9() {
      if (this.v18) {
         this.v2(false);
      } else {
         v3.info("quit without flush: auto-save is off, leaving {} as it is on disk", this.v9.v3());
      }
   }

   private MySettingsSupport.Part1 v2(boolean var1) {
      this.v15();
      String var2 = this.v9.v11();
      this.v12.v3();
      if (this.v12.v2()) {
         this.v13 = null;
      }

      String var3 = this.v12.v1();
      if (var3 != null) {
         this.v14 = var3;
      }

      if (!var1 && var2.equals(this.v13)) {
         this.v19 = false;
         return MySettingsSupport.Part1.WRITTEN;
      } else {
         MySettingsSupport.Part2 var4 = this.v9.v1(this.v14, this.v13);
         if (var4.v1() != MySettingsSupport.Part1.FAILED) {
            this.v13 = var2;
            this.v19 = false;
            if (var4.v2() != null) {
               this.v14 = var4.v2();
            }
         }

         return var4.v1();
      }
   }

   public void v10() {
      this.v12.v3();
   }

   public void v11() {
      this.v12.close();
   }

   private void v15() {
      for (ActionSetting var2 : this.v11) {
         var2.v3().run();
      }
   }

   @Nullable
   public String v12() {
      this.v15();
      JsonObject var1 = this.v9.v10();
      String var2 = this.v9("New config");

      try {
         this.v9.v1(var2, var1);
      } catch (IOException var4) {
         v3.warn("failed to create config", var4);
         return null;
      }

      v3.info("created {}", var2);
      return var2;
   }

   @Nullable
   public String v5(String var1) {
      if (MySettingsSupport.v12(var1) && this.v9.v8(var1)) {
         if (var1.equals(this.v9.v3())) {
            this.v15();
            this.v2(true);
         }

         JsonObject var2;
         try {
            var2 = this.v9.v7(var1);
         } catch (RuntimeException | IOException var6) {
            v3.warn("failed to read {} to duplicate it", var1, var6);
            return null;
         }

         String var3 = this.v9(v8(var1));

         try {
            this.v9.v1(var3, var2);
         } catch (IOException var5) {
            v3.warn("failed to duplicate {}", var1, var5);
            return null;
         }

         v3.info("duplicated {} -> {}", var1, var3);
         return var3;
      } else {
         return null;
      }
   }

   private static String v8(String var0) {
      String var1 = " copy";
      int var2 = 48 - var1.length() - " 9999".length();
      String var3 = (var0.length() > var2 ? var0.substring(0, var2) : var0).stripTrailing() + var1;
      return hudSupport63.v1(var3) ? var3 : "New config";
   }

   public boolean v1(String var1, String var2) {
      if (!MySettingsSupport.v12(var2) || !this.v9.v8(var1)) {
         return false;
      } else if (var1.equals(var2)) {
         return true;
      } else if (this.v2(var1, var2)) {
         return false;
      } else {
         boolean var3 = var1.equals(this.v9.v3());
         if (var3 && this.v9.v7()) {
            v3.warn("refusing to rename the active config {} while its save is refused (no backup to recover)", var1);
            return false;
         } else {
            if (var3) {
               this.v9();
               this.v10();
            }

            try {
               this.v9.v2(var1, var2);
            } catch (IOException var5) {
               v3.warn("failed to rename {} -> {}", new Object[]{var1, var2, var5});
               return false;
            }

            if (var3) {
               this.v9.v6(var2);
               this.v11(var2);
            }

            v3.info("renamed {} -> {}", var1, var2);
            return true;
         }
      }
   }

   public void v6(String var1) throws IOException {
      if (!MySettingsSupport.v12(var1)) {
         throw new IllegalArgumentException("invalid name: " + var1);
      } else if (var1.equals(this.v9.v3())) {
         throw new IllegalStateException("cannot delete the active config");
      } else {
         this.v9.v10(var1);
      }
   }

   private boolean v2(String var1, String var2) {
      for (String var4 : this.v9.v9()) {
         if (!var4.equals(var1) && var4.equalsIgnoreCase(var2)) {
            return true;
         }
      }

      return false;
   }

   private String v9(String var1) {
      if (!this.v10(var1)) {
         return var1;
      } else {
         for (int var2 = 2; var2 < 10000; var2++) {
            String var3 = var1 + " " + var2;
            if (hudSupport63.v1(var3) && !this.v10(var3)) {
               return var3;
            }
         }

         return var1;
      }
   }

   private boolean v10(String var1) {
      for (String var3 : this.v9.v9()) {
         if (var3.equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }

   public MySettingsSupport.Part1 v7(String var1) {
      if (!MySettingsSupport.v12(var1)) {
         throw new IllegalArgumentException("invalid name: " + var1);
      } else {
         this.v10();
         this.v15();
         MySettingsSupport.Part1 var2 = this.v9.v5(var1);
         if (var2 != MySettingsSupport.Part1.WRITTEN) {
            v3.warn("save as {} did not reach disk ({}); active config unchanged", var1, var2);
            return var2;
         } else {
            if (!var1.equals(this.v9.v3())) {
               this.v9.v6(var1);
            }

            this.v11(var1);
            this.v13 = this.v9.v11();
            this.v14 = this.v13;
            this.v19 = false;
            v3.info("saved as {}", var1);
            return var2;
         }
      }
   }

   private boolean v16() {
      Path var1 = this.v10.resolve("_client.json");
      if (!Files.exists(var1)) {
         return true;
      } else {
         try {
            JsonObject var2 = (JsonObject)v4.fromJson(Files.readString(var1), JsonObject.class);
            if (var2 != null && var2.has("autoSave") && var2.get("autoSave").isJsonPrimitive()) {
               return var2.get("autoSave").getAsBoolean();
            }
         } catch (RuntimeException | IOException var3) {
            v3.warn("failed to read {}", "_client.json", var3);
         }

         return true;
      }
   }

   private void v18() {
      Path var1 = this.v10.resolve("_client.json");
      JsonObject var2 = new JsonObject();
      var2.addProperty("autoSave", this.v18);

      try {
         MySettingsSupport.v1(var1, var2);
      } catch (IOException var4) {
         v3.warn("failed to write {}", "_client.json", var4);
      }
   }

   private Optional<String> v19() {
      Path var1 = this.v10.resolve("_current.json");
      if (!Files.exists(var1)) {
         return Optional.empty();
      } else {
         try {
            String var2 = Files.readString(var1);
            JsonObject var3 = (JsonObject)v4.fromJson(var2, JsonObject.class);
            if (var3 != null && var3.has("name") && var3.get("name").isJsonPrimitive()) {
               return Optional.of(var3.get("name").getAsString());
            }
         } catch (RuntimeException | IOException var4) {
            v3.warn("failed to read {}", "_current.json", var4);
         }

         return Optional.empty();
      }
   }

   private void v11(String var1) {
      Path var2 = this.v10.resolve("_current.json");
      JsonObject var3 = new JsonObject();
      var3.addProperty("name", var1);

      try {
         MySettingsSupport.v1(var2, var3);
      } catch (IOException var5) {
         v3.warn("failed to write {}", "_current.json", var5);
      }
   }
}
