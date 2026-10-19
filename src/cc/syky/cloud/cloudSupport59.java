package cc.syky.cloud;

import cc.syky.storage.SykyPaths;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport59 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.migrate");
   private static final List<String> v2 = List.of("scripts", "nav.json", "nav-trace.jsonl", "default.json");

   private cloudSupport59() {
   }

   public static void v1(Path var0, SykyPaths var1) {
      if (Files.isDirectory(var0, LinkOption.NOFOLLOW_LINKS)) {
         try {
            v2(var0, var1);
         } catch (RuntimeException | IOException var3) {
            v1.warn("could not finish moving {} into {}; will retry next launch", new Object[]{var0, var1.v10(), var3});
         }
      }
   }

   private static void v2(Path var0, SykyPaths var1) throws IOException {
      v1.info("moving {} into {}", var0, var1.v10());
      ArrayList var2 = new ArrayList();

      try (DirectoryStream var3 = Files.newDirectoryStream(var0)) {
         var3.forEach(var2::add);
      }

      ArrayList var8 = new ArrayList();

      for (Path var5 : var2) {
         if (!v3(var5, var1)) {
            var8.add(var5.getFileName().toString());
         }
      }

      if (var8.isEmpty() && v2(var0)) {
         v1.info("{} is now empty and has been removed", var0);
      } else if (!var8.isEmpty()) {
         v1.warn("left in {} (not recognised, or the same name already exists in {}): {}", new Object[]{var0, var1.v10(), var8});
      }
   }

   private static boolean v3(Path var0, SykyPaths var1) throws IOException {
      String var2 = var0.getFileName().toString();
      String var3 = var2.toLowerCase(Locale.ROOT);
      if (!v2.contains(var2) && !var3.startsWith("perfstats-") && !var3.endsWith(".tmp")) {
         switch (var2) {
            case "_instance.lock":
            case "cache":
               return v1(var0);
            case "_current.json":
            case "_client.json":
               return v1(var0, var1.v10().resolve(var2));
            case "sounds":
               return v1(var0, var1.v3());
            default:
               if (var3.endsWith(".syky.bak") || var3.contains(".syky.corrupt-")) {
                  return v1(var0, var1.v2().resolve(var2));
               } else {
                  return var3.endsWith(".syky") && Files.isRegularFile(var0) ? v1(var0, var1.v1().resolve(var2)) : false;
               }
         }
      } else {
         return v1(var0);
      }
   }

   private static boolean v1(Path var0, Path var1) throws IOException {
      Path var2 = var1.getParent();
      if (var2 != null) {
         Files.createDirectories(var2);
      }

      try {
         Files.move(var0, var1);
         return true;
      } catch (NoSuchFileException var9) {
         return !Files.exists(var0, LinkOption.NOFOLLOW_LINKS);
      } catch (DirectoryNotEmptyException | FileAlreadyExistsException var10) {
         if (Files.isDirectory(var0, LinkOption.NOFOLLOW_LINKS) && Files.isDirectory(var1)) {
            boolean var3 = true;

            try (DirectoryStream var4 = Files.newDirectoryStream(var0)) {
               for (Path var6 : var4) {
                  var3 &= v1(var6, var1.resolve(var6.getFileName().toString()));
               }
            }

            return var3 && v2(var0);
         } else {
            return Files.isRegularFile(var0, LinkOption.NOFOLLOW_LINKS) && Files.isRegularFile(var1) && Files.mismatch(var0, var1) == -1L && v2(var0);
         }
      }
   }

   private static boolean v1(Path var0) throws IOException {
      if (!Files.exists(var0, LinkOption.NOFOLLOW_LINKS)) {
         return true;
      } else {
         List var1;
         try (Stream var2 = Files.walk(var0)) {
            var1 = var2.sorted(Comparator.reverseOrder()).toList();
         }

         boolean var7 = true;

         for (Path var4 : var1) {
            var7 &= v2(var4);
         }

         return var7;
      }
   }

   private static boolean v2(Path var0) {
      try {
         Files.deleteIfExists(var0);
         return true;
      } catch (IOException var2) {
         v1.debug("could not delete {}", var0, var2);
         return false;
      }
   }
}
