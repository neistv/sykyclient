package cc.syky.update;

import cc.syky.internal.InternalSupport12;
import cc.syky.storage.SykyPaths;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.fabricmc.loader.api.metadata.ModOrigin;
import net.fabricmc.loader.api.metadata.ModOrigin.Kind;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UpdateBootWatch implements PreLaunchEntrypoint {
   private static final Logger LOG = LoggerFactory.getLogger("syky.update.boot");
   private static final List<String> ROLLBACK_LEFTOVERS = List.of("previous.jar", "rollback.jar");
   private static final String ROLLBACK_MARKER_GLOB = "boot-*.marker";

   public UpdateBootWatch() {
   }

   public void onPreLaunch() {
      try {
         this.run();
      } catch (Throwable var2) {
         LOG.warn("update boot check failed", var2);
      }
   }

   private void run() {
      FabricLoader var1 = FabricLoader.getInstance();
      if (!var1.isDevelopmentEnvironment()) {
         Path var2 = SykyPaths.v1(var1.getGameDir()).v5();
         if (Files.isDirectory(var2)) {
            InternalSupport12 var3 = InternalSupport12.v1(var2);
            if (consumeSwapResult(var2, var3)) {
               var3.v1();
            }
         }
      }
   }

   private static boolean consumeSwapResult(Path var0, InternalSupport12 var1) {
      Path var2 = var0.resolve("swap-result.properties");
      if (!Files.isRegularFile(var2)) {
         return false;
      } else {
         Properties var3 = read(var2);
         deleteQuietly(var2);
         InternalSupport12.Part1 var4 = var1.v5();
         if (var3 != null && var4 != null) {
            if (!var4.v1().equals(var3.getProperty("sha256", "").toLowerCase(Locale.ROOT))) {
               return false;
            } else {
               String var5 = var3.getProperty("result", "");
               if ("ok".equals(var5)) {
                  LOG.info("update to {} was installed", var4.v2());
                  var1.v6();
                  var1.v2(var4.v5());
                  dropRollbackLeftovers(var0, var1);
                  return true;
               } else if ("rejected".equals(var5)) {
                  LOG.warn("staged update {} was rejected by the swapper: {}", var4.v2(), var3.getProperty("detail"));
                  var1.v6();
                  deleteQuietly(var0.resolve(var4.v3()));
                  return true;
               } else {
                  long var6 = var4.v6() + 1L;
                  if (var6 >= 5L) {
                     LOG.warn("giving up on staged update {} after {} attempts", var4.v2(), var6);
                     var1.v6();
                     deleteQuietly(var0.resolve(var4.v3()));
                  } else {
                     LOG.info("swap of {} did not happen ({}), retrying on exit", var4.v2(), var3.getProperty("detail"));
                     var1.v1(new InternalSupport12.Part1(var4.v2(), var4.v3(), var4.v1(), var4.v4(), var4.v5(), var6, var4.v7()));
                  }

                  return true;
               }
            }
         } else {
            return false;
         }
      }
   }

   private static void dropRollbackLeftovers(Path var0, InternalSupport12 var1) {
      var1.v8();

      for (String var3 : ROLLBACK_LEFTOVERS) {
         deleteQuietly(var0.resolve(var3));
      }

      try (DirectoryStream var8 = Files.newDirectoryStream(var0, "boot-*.marker")) {
         for (Path var4 : var8) {
            deleteQuietly(var4);
         }
      } catch (RuntimeException | IOException var7) {
         LOG.debug("could not list the old boot markers", var7);
      }
   }

   @Nullable
   public static Path ownJar() {
      ModContainer var0 = (ModContainer)FabricLoader.getInstance().getModContainer("syky").orElse(null);
      if (var0 == null) {
         return null;
      } else {
         ModOrigin var1 = var0.getOrigin();
         if (var1.getKind() != Kind.PATH) {
            return null;
         } else {
            List var2 = var1.getPaths();
            if (var2.size() != 1) {
               return null;
            } else {
               Path var3 = (Path)var2.get(0);
               return Files.isRegularFile(var3) && var3.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".jar") ? var3 : null;
            }
         }
      }
   }

   @Nullable
   private static Properties read(Path var0) {
      Properties var1 = new Properties();

      try {
         Properties var3;
         try (InputStream var2 = Files.newInputStream(var0)) {
            var1.load(var2);
            var3 = var1;
         }

         return var3;
      } catch (IllegalArgumentException | IOException var7) {
         LOG.debug("could not read {}", var0, var7);
         return null;
      }
   }

   private static void deleteQuietly(Path var0) {
      try {
         Files.deleteIfExists(var0);
      } catch (IOException var2) {
         LOG.debug("could not remove {}", var0, var2);
      }
   }
}
