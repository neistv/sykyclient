package cc.syky.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.jetbrains.annotations.Nullable;

public final class WARNSupport {
   private static final int v1 = 2000;
   private static final long v2 = 268435456L;
   private static final Pattern v3 = Pattern.compile("^\\[[^\\]]+\\] \\[[^\\]]*/(TRACE|DEBUG|INFO|WARN|ERROR|FATAL)\\]");
   private static final Set<String> v4 = Set.of("WARN", "ERROR", "FATAL");

   private WARNSupport() {
   }

   @Nullable
   public static Path v1(Path var0, long var1) {
      Path var3 = null;
      long var4 = Long.MIN_VALUE;
      if (!Files.isDirectory(var0)) {
         return null;
      } else {
         try {
            try (DirectoryStream var6 = Files.newDirectoryStream(var0, "*.log.gz")) {
               for (Path var8 : var6) {
                  long var9 = Files.getLastModifiedTime(var8).toMillis();
                  if (var9 >= var1 && var9 > var4) {
                     var3 = var8;
                     var4 = var9;
                  }
               }
            }

            return var3;
         } catch (IOException var13) {
            return null;
         }
      }
   }

   public static List<String> v1(Path var0, int var1) {
      try {
         List var3;
         try (GZIPInputStream var2 = new GZIPInputStream(Files.newInputStream(var0))) {
            var3 = v1(var2, var1);
         }

         return var3;
      } catch (IOException var7) {
         return List.of();
      }
   }

   public static List<String> v1(InputStream var0, int var1) throws IOException {
      ArrayDeque var2 = new ArrayDeque(var1);
      long var3 = 0L;
      BufferedReader var5 = new BufferedReader(new InputStreamReader(var0, StandardCharsets.UTF_8));
      boolean var7 = false;

      String var6;
      while ((var6 = var5.readLine()) != null && var3 < 268435456L) {
         var3 += var6.length() + 1;
         Matcher var8 = v3.matcher(var6);
         if (var8.find()) {
            var7 = v4.contains(var8.group(1));
         }

         if (var7 && !var6.contains("[CHAT]")) {
            if (var2.size() == var1) {
               var2.removeFirst();
            }

            var2.addLast(NativeMethodSupport.v1(var6, 2000));
         }
      }

      return new ArrayList<>(var2);
   }
}
