package cc.syky.cloud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CloudConfig {
   private static final Logger v6 = LoggerFactory.getLogger("syky.cloud");
   private static final Gson v7 = new GsonBuilder().setPrettyPrinting().create();
   private static final String v8 = "sd_";
   public boolean v1 = true;
   public boolean v2;
   public boolean v3;
   public Map<String, CloudConfig.Part1> v4 = new HashMap<>();
   public boolean v5;
   private static final int v9 = 3;
   private static final long v10 = 50L;

   public CloudConfig() {
   }

   public static CloudConfig v1(Path var0) {
      int var2 = 1;

      String var1;
      while (true) {
         try {
            var1 = Files.readString(var0, StandardCharsets.UTF_8);
            break;
         } catch (NoSuchFileException var6) {
            return new CloudConfig();
         } catch (IOException var7) {
            if (var2 >= 3 || !v6()) {
               v6.warn("cloud.json is unreadable; online features are off this session and the file is left alone", var7);
               return v5();
            }

            var2++;
         }
      }

      try {
         JsonElement var8 = JsonParser.parseString(var1);
         if (!var8.isJsonObject()) {
            throw new JsonParseException("not an object");
         } else {
            return v2(var8.getAsJsonObject());
         }
      } catch (IllegalStateException | NumberFormatException | JsonParseException var5) {
         v6.warn("cloud.json is not valid JSON; keeping it as cloud.json.broken and starting from defaults", var5);

         try {
            Files.move(var0, var0.resolveSibling(var0.getFileName() + ".broken"), StandardCopyOption.REPLACE_EXISTING);
         } catch (IOException var4) {
            v6.warn("could not set the broken cloud.json aside", var4);
         }

         return new CloudConfig();
      }
   }

   private static CloudConfig v5() {
      CloudConfig var0 = new CloudConfig();
      var0.v1 = false;
      var0.v2 = true;
      var0.v3 = true;
      var0.v5 = true;
      return var0;
   }

   private static boolean v6() {
      try {
         Thread.sleep(50L);
         return true;
      } catch (InterruptedException var1) {
         Thread.currentThread().interrupt();
         return false;
      }
   }

   public void v1(Path var1, Consumer<CloudConfig> var2) {
      var2.accept(this);
      if (!this.v5) {
         Path var3 = var1.resolveSibling(var1.getFileName() + ".lock");

         try {
            try (
               FileChannel var4 = FileChannel.open(var3, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
               FileLock var5 = var4.lock();
            ) {
               CloudConfig var6 = v1(var1);
               if (!var6.v5) {
                  var2.accept(var6);
                  var6.v2(var1);
                  this.v1 = var6.v1;
                  this.v2 = var6.v2;
                  this.v3 = var6.v3;
                  this.v4 = var6.v4;
                  return;
               }
            }
         } catch (RuntimeException | IOException var12) {
            v6.warn("could not update cloud.json", var12);
         }
      }
   }

   private static CloudConfig v2(JsonObject var0) {
      if (!var0.has("installs") && !var0.has("online")) {
         CloudConfig var1 = v1(var0);
         if (var1 != null) {
            return var1;
         }
      }

      CloudConfig var7 = new CloudConfig();
      var7.v1 = cloudSupport60.v1(var0, "online", true);
      var7.v2 = cloudSupport60.v1(var0, "moduleStatsOff", false);
      var7.v3 = cloudSupport60.v1(var0, "crashReportsOff", false);
      JsonElement var2 = var0.get("installs");
      if (var2 != null && var2.isJsonObject()) {
         for (Entry var4 : var2.getAsJsonObject().entrySet()) {
            if (((JsonElement)var4.getValue()).isJsonObject()) {
               JsonObject var5 = ((JsonElement)var4.getValue()).getAsJsonObject();
               CloudConfig.Part1 var6 = new CloudConfig.Part1();
               var6.v1 = cloudSupport60.v1(var5, "token");
               var6.v2 = cloudSupport60.v3(var5, "accountUid");
               var6.v3 = cloudSupport60.v1(var5, "accountName");
               var7.v4.put((String)var4.getKey(), var6);
            }
         }
      }

      return var7;
   }

   @Nullable
   public static CloudConfig v1(JsonObject var0) {
      ArrayList var1 = new ArrayList();
      JsonObject var2 = null;

      for (Entry var4 : var0.entrySet()) {
         JsonElement var5 = (JsonElement)var4.getValue();
         if (var5.isJsonPrimitive() && var5.getAsJsonPrimitive().isBoolean()) {
            var1.add(var5.getAsBoolean());
         } else if (var5.isJsonObject()) {
            if (var2 != null) {
               return null;
            }

            var2 = var5.getAsJsonObject();
         }
      }

      if (var2 != null && var1.size() == 2) {
         CloudConfig var11 = new CloudConfig();
         var11.v1 = (Boolean)var1.get(0);
         var11.v2 = (Boolean)var1.get(1);

         for (Entry var13 : var2.entrySet()) {
            if (((String)var13.getKey()).startsWith("http") && ((JsonElement)var13.getValue()).isJsonObject()) {
               CloudConfig.Part1 var6 = new CloudConfig.Part1();

               for (Entry var8 : ((JsonElement)var13.getValue()).getAsJsonObject().entrySet()) {
                  JsonElement var9 = (JsonElement)var8.getValue();
                  if (var9.isJsonPrimitive()) {
                     if (var9.getAsJsonPrimitive().isNumber()) {
                        var6.v2 = var9.getAsLong();
                     } else if (var9.getAsJsonPrimitive().isString()) {
                        String var10 = var9.getAsString();
                        if (var10.startsWith("sd_") && var6.v1 == null) {
                           var6.v1 = var10;
                        } else {
                           var6.v3 = var10;
                        }
                     }
                  }
               }

               var11.v4.put((String)var13.getKey(), var6);
            }
         }

         v6.info("read cloud.json written by an older release");
         return var11;
      } else {
         return null;
      }
   }

   public void v2(Path var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("online", this.v1);
      var2.addProperty("moduleStatsOff", this.v2);
      var2.addProperty("crashReportsOff", this.v3);
      JsonObject var3 = new JsonObject();
      this.v4.forEach((var1x, var2x) -> {
         JsonObject var3x = new JsonObject();
         if (var2x.v1 != null) {
            var3x.addProperty("token", var2x.v1);
         }

         var3x.addProperty("accountUid", var2x.v2);
         if (var2x.v3 != null) {
            var3x.addProperty("accountName", var2x.v3);
         }

         var3.add(var1x, var3x);
      });
      var2.add("installs", var3);

      try {
         cloudSupport66.v1(var1, v7.toJson(var2));
      } catch (IOException var5) {
         v6.warn("could not write cloud.json", var5);
      }
   }

   public String v1() {
      return CloudEndpoints.v1;
   }

   public CloudConfig.Part1 v2() {
      return this.v4.computeIfAbsent(this.v1(), var0 -> new CloudConfig.Part1());
   }

   @Nullable
   public String v3() {
      return this.v2().v1;
   }

   public void v1(@Nullable String var1) {
      this.v2().v1 = var1;
   }

   @Nullable
   public SykySession.Part1 v4() {
      CloudConfig.Part1 var1 = this.v2();
      String var2 = var1.v3;
      return var1.v2 > 0L && var2 != null ? new SykySession.Part1(var1.v2, var2) : null;
   }

   public boolean v1(@Nullable SykySession.Part1 var1) {
      CloudConfig.Part1 var2 = this.v2();
      return var1 == null ? var2.v2 == 0L && var2.v3 == null : var2.v2 == var1.v1() && Objects.equals(var2.v3, var1.v2());
   }

   public void v2(@Nullable SykySession.Part1 var1) {
      CloudConfig.Part1 var2 = this.v2();
      var2.v2 = var1 == null ? 0L : var1.v1();
      var2.v3 = var1 == null ? null : var1.v2();
   }

   public static final class Part1 {
      @Nullable
      public String v1;
      public long v2;
      @Nullable
      public String v3;

      public Part1() {
      }
   }
}
