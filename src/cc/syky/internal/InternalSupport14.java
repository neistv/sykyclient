package cc.syky.internal;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport14 {
   private static final Logger v4 = LoggerFactory.getLogger("syky.update.swap");
   private static final String v5 = "/cc/syky/update/swapper.jar";
   public static final String v1 = "swapper.jar";
   public static final String v2 = "swap-result.properties";
   public static final String v3 = "swapper.log";
   @Nullable
   private static volatile Path v6;

   private InternalSupport14() {
   }

   public static synchronized boolean v1(Path var0, InternalSupport12.Part1 var1) {
      Path var2 = v1(var0);
      return var2 != null && v1(var0, var2, var1);
   }

   @Nullable
   public static synchronized Path v1(Path var0) {
      Path var1 = v6;
      if (var1 != null) {
         return var1;
      } else {
         Path var2 = var0.resolve("session-" + ProcessHandle.current().pid() + ".lock");

         try {
            Files.createDirectories(var0);
            FileChannel var3 = FileChannel.open(var2, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            FileLock var4 = var3.tryLock();
            if (var4 == null) {
               var3.close();
               v4.warn("session lock {} is already held - skipping the swap this session", var2);
               return null;
            } else {
               v6 = var2;
               return var2;
            }
         } catch (OverlappingFileLockException | IOException var5) {
            v4.warn("could not take the session lock at {}", var2, var5);
            return null;
         }
      }
   }

   @Nullable
   public static Path v2(Path var0) {
      Path var1 = var0.resolve("swapper.jar");

      try {
         Path var4;
         try (InputStream var2 = InternalSupport14.class.getResourceAsStream("/cc/syky/update/swapper.jar")) {
            if (var2 == null) {
               v4.error("{} is missing from the client jar — the build did not embed the swapper", "/cc/syky/update/swapper.jar");
               return null;
            }

            Files.createDirectories(var0);
            Path var3 = var0.resolve("swapper.jar." + ProcessHandle.current().pid() + ".tmp");
            Files.copy(var2, var3, StandardCopyOption.REPLACE_EXISTING);
            Files.move(var3, var1, StandardCopyOption.REPLACE_EXISTING);
            var4 = var1;
         }

         return var4;
      } catch (IOException var7) {
         v4.warn("could not unpack the swapper into {}", var0, var7);
         return null;
      }
   }

   private static boolean v1(Path var0, Path var1, InternalSupport12.Part1 var2) {
      Path var3 = v2(var0);
      if (var3 == null) {
         return false;
      } else {
         Path var4 = v1();
         if (var4 == null) {
            v4.warn("no java binary could be located — the update stays staged for the next launch");
            return false;
         } else {
            ArrayList var5 = new ArrayList();
            var5.add(var4.toString());
            var5.add("-jar");
            var5.add(var3.toString());
            var5.add(var1.toString());
            var5.add(var0.resolve(var2.v3()).toString());
            var5.add(var2.v4());
            var5.add(var2.v1());
            var5.add("-");
            var5.add(var0.resolve("swap-result.properties").toString());
            var5.add(var0.resolve("swapper.log").toString());

            try {
               new ProcessBuilder(var5).directory(var0.toFile()).redirectOutput(Redirect.DISCARD).redirectError(Redirect.DISCARD).start();
               v4.info("swapper started for {}", var2.v2());
               return true;
            } catch (SecurityException | IOException var7) {
               v4.warn("could not start the swapper", var7);
               return false;
            }
         }
      }
   }

   @Nullable
   private static Path v1() {
      String var0 = System.getProperty("java.home");
      if (var0 != null && !var0.isBlank()) {
         Path var1 = Path.of(var0).resolve("bin");

         for (String var3 : v2() ? List.of("javaw.exe", "java.exe") : List.of("java")) {
            Path var4 = var1.resolve(var3);
            if (Files.isExecutable(var4)) {
               return var4;
            }
         }
      }

      return ProcessHandle.current().info().command().map(var0x -> Path.of(var0x)).filter(Files::isExecutable).orElse(null);
   }

   private static boolean v2() {
      return System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");
   }
}
