package cc.syky.hud;

import cc.syky.cloud.cloudSupport66;
import cc.syky.config.SettingRegistry;
import cc.syky.ui.uiSupport258;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MySettingsSupport {
   private static final Logger v4 = LoggerFactory.getLogger("syky.settings");
   private static final Gson v5 = new GsonBuilder().setPrettyPrinting().create();
   public static final String v1 = "My settings";
   public static final String v2 = ".syky";
   private static final int v6 = 3;
   private static final long v7 = 100L;
   private static final char v8 = '\ufeff';
   private final Path v9;
   private final Path v10;
   private final uiSupport258 v11;
   private String v12 = "My settings";
   private JsonObject v13 = new JsonObject();
   private boolean v14;
   @Nullable
   private String v15;
   public static final long v3 = 3600000L;

   public MySettingsSupport(Path var1) {
      this(var1, var1.resolve("backups"), uiSupport258.v1);
   }

   public MySettingsSupport(Path var1, Path var2, uiSupport258 var3) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = var3;
   }

   public Path v1() {
      return this.v9;
   }

   public Path v2() {
      return this.v10;
   }

   public String v3() {
      return this.v12;
   }

   public Path v4() {
      return this.v1(this.v12);
   }

   public Path v1(String var1) {
      return this.v9.resolve(var1 + ".syky");
   }

   public boolean v2(String var1) {
      Path var2 = this.v1(var1);
      if (!Files.exists(var2)) {
         return false;
      } else {
         try {
            return v5.fromJson(v4(var2), JsonObject.class) != null;
         } catch (RuntimeException | IOException var4) {
            return false;
         }
      }
   }

   public long v3(String var1) {
      try {
         return Files.getLastModifiedTime(this.v1(var1)).toMillis();
      } catch (RuntimeException | IOException var3) {
         return 0L;
      }
   }

   public void v5() {
      long var1 = this.v11.v3();
      Path var3 = this.v4();
      this.v14 = false;
      this.v15 = null;

      try {
         if (!Files.exists(var3)) {
            v4.info("no config at {}, using defaults", var3);
            this.v13 = new JsonObject();
            return;
         }

         String var4 = this.v3(var3);
         if (var4 == null) {
            this.v1(var3);
            return;
         }

         JsonObject var5 = this.v1(var3, var4);
         if (var5 == null) {
            this.v2(var3, "empty, null, or unparseable document");
            return;
         }

         this.v13 = var5;
         v4.info("loaded {}", var3);
         this.v2(var3, var5);
         this.v15 = v5.toJson(this.v13);
         TOTEMSupport.v1(this.v13);
      } finally {
         this.v11.v1("settings.load", var1);
      }
   }

   private void v1(Path var1) {
      this.v13 = new JsonObject();
      JsonObject var2 = this.v2(this.v5(var1));
      if (var2 != null) {
         this.v13 = var2;
         TOTEMSupport.v1(this.v13);
         v4.warn("config {} could not be read (locked?); loaded backup {}, will not overwrite the original", var1, this.v5(var1));
      } else {
         v4.error("config {} could not be read and has no backup; using defaults, will not overwrite it", var1);
      }

      this.v14 = true;
   }

   @Nullable
   private JsonObject v1(Path var1, String var2) {
      try {
         return (JsonObject)v5.fromJson(var2, JsonObject.class);
      } catch (RuntimeException var4) {
         v4.warn("failed to parse {}", var1, var4);
         return null;
      }
   }

   @Nullable
   private JsonObject v2(Path var1) {
      if (!Files.exists(var1)) {
         return null;
      } else {
         try {
            return (JsonObject)v5.fromJson(v4(var1), JsonObject.class);
         } catch (RuntimeException | IOException var3) {
            v4.warn("failed to parse {}", var1, var3);
            return null;
         }
      }
   }

   @Nullable
   private String v3(Path var1) {
      IOException var2 = null;

      for (int var3 = 0; var3 < 3; var3++) {
         try {
            return v4(var1);
         } catch (IOException var7) {
            var2 = var7;
            if (var3 < 2) {
               try {
                  Thread.sleep(100L);
               } catch (InterruptedException var6) {
                  Thread.currentThread().interrupt();
                  break;
               }
            }
         }
      }

      v4.warn("failed to read {} after {} attempt(s)", new Object[]{var1, 3, var2});
      return null;
   }

   private static String v4(Path var0) throws IOException {
      String var1 = Files.readString(var0);
      return !var1.isEmpty() && var1.charAt(0) == '\ufeff' ? var1.substring(1) : var1;
   }

   private void v2(Path var1, String var2) {
      this.v13 = new JsonObject();
      boolean var3 = this.v3(var1, var2);
      JsonObject var4 = this.v2(this.v5(var1));
      if (var4 != null) {
         this.v13 = var4;
         v4.warn("recovered {} from backup {}", var1, this.v5(var1));
         TOTEMSupport.v1(this.v13);
      } else {
         this.v14 = !var3;
      }
   }

   private boolean v3(Path var1, String var2) {
      Path var3 = this.v10.resolve(var1.getFileName() + ".corrupt-" + System.currentTimeMillis());

      try {
         Files.createDirectories(this.v10);
         Files.move(var1, var3, StandardCopyOption.REPLACE_EXISTING);
         v4.warn("config {} is unreadable ({}); moved to {}", new Object[]{var1, var2, var3});
         return true;
      } catch (IOException var5) {
         v4.error("config {} is unreadable ({}) and could not be moved aside", new Object[]{var1, var2, var5});
         return false;
      }
   }

   private void v2(Path var1, JsonObject var2) {
      try {
         v1(this.v5(var1), var2);
      } catch (IOException var4) {
         v4.warn("failed to write config backup for {}", var1, var4);
      }
   }

   private Path v5(Path var1) {
      return this.v10.resolve(var1.getFileName() + ".bak");
   }

   public MySettingsSupport.Part2 v4(@Nullable String var1) {
      return this.v1(var1, var1);
   }

   public MySettingsSupport.Part2 v1(@Nullable String var1, @Nullable String var2) {
      long var3 = this.v11.v3();
      Path var5 = this.v4();

      MySettingsSupport.Part2 var6;
      try {
         if (!this.v14) {
            String var13 = v1(var5, v5.toJson(this.v13), var1, var2);
            v4.info("saved {}", var5);
            return new MySettingsSupport.Part2(MySettingsSupport.Part1.WRITTEN, var13);
         }

         v4.warn("refusing to overwrite the config at {} — it could not be read this session", var5);
         var6 = new MySettingsSupport.Part2(MySettingsSupport.Part1.REFUSED, null);
      } catch (IOException var11) {
         v4.error("failed to save {}", var5, var11);
         return new MySettingsSupport.Part2(MySettingsSupport.Part1.FAILED, null);
      } finally {
         this.v11.v1("settings.save", var3);
      }

      return var6;
   }

   public MySettingsSupport.Part1 v6() {
      return this.v1(null, null).v1();
   }

   public boolean v7() {
      return this.v14;
   }

   @Nullable
   public String v8() {
      return this.v15;
   }

   public MySettingsSupport.Part1 v5(String var1) {
      if (!v12(var1)) {
         throw new IllegalArgumentException("invalid profile name: " + var1);
      } else if (this.v14 && var1.equals(this.v12)) {
         v4.warn("refusing to overwrite the config at {} — it could not be read this session", this.v1(var1));
         return MySettingsSupport.Part1.REFUSED;
      } else {
         long var2 = this.v11.v3();
         Path var4 = this.v9.resolve(var1 + ".syky");

         MySettingsSupport.Part1 var6;
         try {
            v1(var4, this.v13);
            v4.info("saved {}", var4);
            return MySettingsSupport.Part1.WRITTEN;
         } catch (IOException var10) {
            v4.error("failed to save {}", var4, var10);
            var6 = MySettingsSupport.Part1.FAILED;
         } finally {
            this.v11.v1("settings.save", var2);
         }

         return var6;
      }
   }

   public void v6(String var1) {
      if (!v12(var1)) {
         throw new IllegalArgumentException("invalid profile name: " + var1);
      } else {
         this.v12 = var1;
         this.v14 = false;
      }
   }

   public JsonObject v7(String var1) throws IOException {
      if (!v12(var1)) {
         throw new IllegalArgumentException("invalid profile name: " + var1);
      } else {
         Path var2 = this.v9.resolve(var1 + ".syky");
         if (!Files.exists(var2)) {
            return new JsonObject();
         } else {
            JsonObject var3 = (JsonObject)v5.fromJson(v4(var2), JsonObject.class);
            return var3 != null ? var3 : new JsonObject();
         }
      }
   }

   public void v1(String var1, JsonObject var2) throws IOException {
      if (!v12(var1)) {
         throw new IllegalArgumentException("invalid profile name: " + var1);
      } else {
         Path var3 = this.v9.resolve(var1 + ".syky");
         v1(var3, var2);
      }
   }

   public boolean v8(String var1) {
      return !v12(var1) ? false : Files.exists(this.v9.resolve(var1 + ".syky"));
   }

   public static JsonObject v1(JsonObject var0, @Nullable JsonObject var1, JsonObject var2, @Nullable JsonObject var3) {
      for (String var5 : var2.keySet()) {
         JsonElement var6 = var2.get(var5);
         JsonElement var7 = var1 == null ? null : var1.get(var5);
         if (var7 == null || !var7.equals(var6)) {
            JsonElement var8 = var0.get(var5);
            if (var6.isJsonObject() && var8 != null && var8.isJsonObject()) {
               JsonElement var9 = var3 == null ? null : var3.get(var5);
               v1(
                  var8.getAsJsonObject(),
                  var7 != null && var7.isJsonObject() ? var7.getAsJsonObject() : null,
                  var6.getAsJsonObject(),
                  var9 != null && var9.isJsonObject() ? var9.getAsJsonObject() : null
               );
            } else {
               var0.add(var5, var6);
            }
         }
      }

      if (var3 != null) {
         for (String var11 : var3.keySet()) {
            if (!var2.has(var11)) {
               JsonElement var12 = var0.get(var11);
               if (var12 != null && var12.equals(var3.get(var11))) {
                  var0.remove(var11);
               }
            }
         }
      }

      return var0;
   }

   public static void v1(Path var0, JsonObject var1) throws IOException {
      v1(var0, v5.toJson(var1).getBytes(StandardCharsets.UTF_8));
   }

   public static String v1(Path var0, String var1, @Nullable String var2, @Nullable String var3) throws IOException {
      JsonObject var4 = (JsonObject)v5.fromJson(var1, JsonObject.class);
      if (var4 == null) {
         throw new IOException("refusing to write a non-object config document");
      } else {
         JsonObject var5 = null;
         if (Files.exists(var0)) {
            try {
               var5 = (JsonObject)v5.fromJson(v4(var0), JsonObject.class);
            } catch (RuntimeException | IOException var8) {
               v4.debug("could not read {} before merging; writing our state as-is", var0, var8);
            }
         }

         JsonObject var6 = var5 == null
            ? var4
            : v1(
               var5,
               var2 == null ? null : (JsonObject)v5.fromJson(var2, JsonObject.class),
               var4,
               var3 == null ? null : (JsonObject)v5.fromJson(var3, JsonObject.class)
            );
         String var7 = v5.toJson(var6);
         v1(var0, var7.getBytes(StandardCharsets.UTF_8));
         return var7;
      }
   }

   public static void v1(Path var0, byte[] var1) throws IOException {
      cloudSupport66.v1(var0, var1);
   }

   public void v9(String var1) {
      if (var1 == null || var1.isBlank()) {
         throw new IllegalArgumentException("profile must not be blank");
      } else if (!v12(var1)) {
         throw new IllegalArgumentException("invalid profile name (allowed: a-z A-Z 0-9 _ - and length 1..32): " + var1);
      } else {
         this.v12 = var1;
         this.v13 = new JsonObject();
         this.v14 = false;
      }
   }

   public List<String> v9() {
      ArrayList var1 = new ArrayList();
      if (!Files.isDirectory(this.v9)) {
         return var1;
      } else {
         try (DirectoryStream var2 = Files.newDirectoryStream(this.v9, "*.syky")) {
            for (Path var4 : var2) {
               String var5 = hudSupport63.v2(var4.getFileName().toString());
               if (var5 != null) {
                  var1.add(var5);
               }
            }
         } catch (IOException var8) {
            v4.warn("failed to list configs in {}", this.v9, var8);
         }

         Collections.sort(var1);
         return var1;
      }
   }

   public void v10(String var1) throws IOException {
      if (!v12(var1)) {
         throw new IllegalArgumentException("invalid config name: " + var1);
      } else {
         Files.deleteIfExists(this.v1(var1));

         try {
            Files.deleteIfExists(this.v5(this.v1(var1)));
         } catch (IOException var3) {
            v4.warn("failed to delete backup for {}", var1, var3);
         }
      }
   }

   public void v2(String var1, String var2) throws IOException {
      if (v12(var1) && v12(var2)) {
         Files.move(this.v1(var1), this.v1(var2));

         try {
            Path var3 = this.v5(this.v1(var1));
            if (Files.exists(var3)) {
               Files.move(var3, this.v5(this.v1(var2)), StandardCopyOption.REPLACE_EXISTING);
            }
         } catch (IOException var4) {
            v4.warn("failed to move backup {} to {}", new Object[]{var1, var2, var4});
         }
      } else {
         throw new IllegalArgumentException("invalid config name");
      }
   }

   public JsonObject v10() {
      return (JsonObject)v5.fromJson(v5.toJson(this.v13), JsonObject.class);
   }

   public String v11() {
      return v5.toJson(this.v13);
   }

   public void v1(String var1, SettingRegistry var2) {
      if (this.v13.has(var1) && this.v13.get(var1).isJsonObject()) {
         var2.load(this.v13.getAsJsonObject(var1));
      }
   }

   public void v2(String var1, SettingRegistry var2) {
      this.v13.add(var1, var2.save());
   }

   @Nullable
   public JsonObject v11(String var1) {
      return this.v13.has(var1) && this.v13.get(var1).isJsonObject() ? this.v13.getAsJsonObject(var1) : null;
   }

   public void v2(String var1, JsonObject var2) {
      if (var2 == null) {
         this.v13.remove(var1);
      } else {
         this.v13.add(var1, var2);
      }
   }

   public List<String> v1(Set<String> var1) {
      if (TOTEMSupport.v2(this.v13) > TOTEMSupport.v2) {
         v4.info("config is from a newer build (schema {} > {}); skipping self-clean to keep its sections", TOTEMSupport.v2(this.v13), TOTEMSupport.v2);
         return new ArrayList<>();
      } else {
         ArrayList var2 = new ArrayList();

         for (String var4 : new ArrayList(this.v13.keySet())) {
            if (!var4.startsWith("_") && !var1.contains(var4)) {
               this.v13.remove(var4);
               var2.add(var4);
            }
         }

         return var2;
      }
   }

   public void v12() {
      cloudSupport66.v1(this.v9, 3600000L);
      cloudSupport66.v1(this.v10, 3600000L);
   }

   public static boolean v12(String var0) {
      return hudSupport63.v1(var0);
   }

   public static enum Part1 {
      WRITTEN,
      REFUSED,
      FAILED;

      private Part1() {
      }
   }

   public record Part2(MySettingsSupport.Part1 result, @Nullable String writtenJson) {
      public MySettingsSupport.Part1 v1() {
         return this.result;
      }

      @Nullable
      public String v2() {
         return this.writtenJson;
      }
   }
}
