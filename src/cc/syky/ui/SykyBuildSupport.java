package cc.syky.ui;

import cc.syky.cloud.cloudSupport67;
import cc.syky.cloud.cloudSupport70;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.management.OperatingSystemMXBean;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.jar.Manifest;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.jetbrains.annotations.Nullable;
import oshi.SystemInfo;

public final class SykyBuildSupport {
   private static final long v1 = 1048576L;
   private static final int v2 = 400;
   @Nullable
   private volatile JsonObject v3;
   @Nullable
   private volatile JsonArray v4;

   public SykyBuildSupport() {
   }

   public void v1() {
      JsonObject var1 = v3();
      String var2 = v6();
      if (var2 != null) {
         var1.addProperty("cpu", var2);
      }

      this.v3 = var1;
      this.v4 = v7();
   }

   public JsonObject v1(uiSupport252 var1, @Nullable String var2) {
      JsonObject var3 = this.v3;
      JsonObject var4 = var3 != null ? var3.deepCopy() : v3();
      if (var2 != null && !var2.isEmpty()) {
         var4.addProperty("syky", var2);
      }

      Runtime var5 = Runtime.getRuntime();
      var4.addProperty("heap_max_mb", var5.maxMemory() / 1048576L);
      var4.addProperty("heap_used_mb", (var5.totalMemory() - var5.freeMemory()) / 1048576L);
      v1(var4, "gpu", var1.v11);
      v1(var4, "gpu_vendor", var1.v12);
      v1(var4, "gl", var1.v13);
      v1(var4, "window", var1.v9);
      if (var1.v10 > 0) {
         var4.addProperty("gui_scale", var1.v10);
      }

      v1(var4, "auth", var1.v14);
      if (var1.v15) {
         v1(var4, "shaderpack", v8());
      }

      return var4;
   }

   @Nullable
   public JsonArray v2() {
      JsonArray var1 = this.v4;
      return var1 == null ? null : var1.deepCopy();
   }

   private static JsonObject v3() {
      JsonObject var0 = new JsonObject();
      v1(var0, "syky", v1("syky"));
      v1(var0, "build", v4());
      v1(var0, "mc", v1("minecraft"));
      v1(var0, "loader", v1("fabricloader"));
      v1(var0, "java", System.getProperty("java.version"));
      v1(var0, "java_vendor", System.getProperty("java.vendor"));
      v1(var0, "os", System.getProperty("os.name"));
      v1(var0, "os_version", System.getProperty("os.version"));
      v1(var0, "arch", System.getProperty("os.arch"));
      var0.addProperty("cpu_threads", Runtime.getRuntime().availableProcessors());
      long var1 = v5();
      if (var1 > 0L) {
         var0.addProperty("ram_mb", var1 / 1048576L);
      }

      v1(var0, "locale", Locale.getDefault().toString());
      String var3 = cloudSupport67.v1();
      if (var3 != null) {
         v1(var0, "sykyopt", var3);
         var0.addProperty("sykyopt_on", cloudSupport67.v2());
      }

      return var0;
   }

   private static void v1(JsonObject var0, String var1, @Nullable String var2) {
      if (var2 != null && !var2.isBlank()) {
         var0.addProperty(var1, var2.strip());
      }
   }

   @Nullable
   private static String v1(String var0) {
      try {
         return FabricLoader.getInstance().getModContainer(var0).map(var0x -> var0x.getMetadata().getVersion().getFriendlyString()).orElse(null);
      } catch (Throwable var2) {
         return null;
      }
   }

   @Nullable
   private static String v4() {
      try {
         Optional var0 = FabricLoader.getInstance().getModContainer("syky");
         if (var0.isEmpty()) {
            return null;
         } else {
            Optional var1 = ((ModContainer)var0.get()).findPath("META-INF/syky/build");
            if (var1.isPresent()) {
               for (String var3 : Files.readAllLines((Path)var1.get(), StandardCharsets.UTF_8)) {
                  if (var3.startsWith("id=")) {
                     return var3.substring(3).strip();
                  }
               }
            }

            Optional var9 = ((ModContainer)var0.get()).findPath("META-INF/MANIFEST.MF");
            if (var9.isPresent()) {
               String var4;
               try (InputStream var10 = Files.newInputStream((Path)var9.get())) {
                  var4 = new Manifest(var10).getMainAttributes().getValue("Syky-Build");
               }

               return var4;
            } else {
               return null;
            }
         }
      } catch (Throwable var8) {
         return null;
      }
   }

   private static long v5() {
      try {
         return ManagementFactory.getOperatingSystemMXBean() instanceof OperatingSystemMXBean var1 ? var1.getTotalMemorySize() : 0L;
      } catch (Throwable var2) {
         return 0L;
      }
   }

   @Nullable
   private static String v6() {
      try {
         return new SystemInfo().getHardware().getProcessor().getProcessorIdentifier().getName();
      } catch (Throwable var1) {
         return null;
      }
   }

   @Nullable
   private static JsonArray v7() {
      try {
         List var0 = cloudSupport70.v1();
         JsonArray var1 = new JsonArray();

         for (int var2 = 0; var2 < var0.size() && var2 < 400; var2++) {
            JsonObject var3 = new JsonObject();
            var3.addProperty("id", ((ModContainer)var0.get(var2)).getMetadata().getId());
            var3.addProperty("v", ((ModContainer)var0.get(var2)).getMetadata().getVersion().getFriendlyString());
            var1.add(var3);
         }

         return var1;
      } catch (Throwable var4) {
         return null;
      }
   }

   @Nullable
   private static String v8() {
      try {
         Path var0 = FabricLoader.getInstance().getConfigDir().resolve("iris.properties");
         if (!Files.isRegularFile(var0)) {
            return null;
         } else {
            Properties var1 = new Properties();

            try (InputStream var2 = Files.newInputStream(var0)) {
               var1.load(var2);
            }

            return var1.getProperty("shaderPack");
         }
      } catch (RuntimeException | IOException var7) {
         return null;
      }
   }
}
