package cc.syky.crash;

import cc.syky.ui.CausedBySupport;
import cc.syky.ui.JavaFramesSupport;
import cc.syky.ui.WARNSupport;
import cc.syky.ui.uiSupport247;
import cc.syky.ui.uiSupport252;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public final class CrashCollector {
   public static final int v1 = 5;
   public static final int v2 = 3;
   public static final int v3 = 300;
   private static final int v5 = 1048576;
   private static final int v6 = 4194304;
   public static final long v4 = 150000L;
   private static final Pattern v7 = Pattern.compile("^hs_err_pid(\\d+)\\.log$");
   private final Path v8;
   private final Set<Path> v9;
   private final Path v10;
   private final String v11;
   private final crashSupport2 v12;
   private final uiSupport252 v13;

   public CrashCollector(Path var1, Path var2, Path var3, String var4, crashSupport2 var5, uiSupport252 var6) {
      this.v8 = var1;
      this.v9 = new LinkedHashSet<>(List.of(v3(var1), v3(var2)));
      this.v10 = var3;
      this.v11 = var4;
      this.v12 = var5;
      this.v13 = var6;
   }

   public void v1(long var1, CrashCollector.Part1 var3) {
      crashSupport2.Part1 var4 = this.v12.v1();
      long var5 = var4.v1() == 0L ? var1 : var4.v1();
      ArrayList var7 = new ArrayList<>(crashSupport.v1(this.v10, this.v11));
      var7.sort(Comparator.comparingLong(crashSupport.Part1::v2).reversed());
      LogScrubber var8 = this.v1(var7);
      ArrayList var9 = new ArrayList();
      int var10 = 0;

      for (Path var12 : v1(List.of(this.v8.resolve("crash-reports")), "crash-*.txt", var5)) {
         long var13 = v2(var12);
         if (var4.v2().contains(var12.getFileName().toString())) {
            var9.add(var13);
         } else {
            String var15 = v1(var12, 1048576);
            String var16 = var15 == null ? null : CausedBySupport.v3(var15);
            if (var15 != null && var16 != null) {
               var9.add(var13);
               if (var10 < 5) {
                  uiSupport247 var17 = uiSupport247.v1("crash", Instant.ofEpochMilli(var13))
                     .v1(CausedBySupport.v1(var15))
                     .v3(CausedBySupport.v2(var15))
                     .v7(var15);
                  v1(var17, v1(var7, var13));
                  var3.report(var17, var16, var8);
                  var10++;
               }
            }
         }
      }

      int var20 = 0;

      for (Path var23 : v1(this.v9, "hs_err_pid*.log", var5)) {
         if (var20 >= 5) {
            break;
         }

         long var14 = v2(var23);
         crashSupport.Part1 var27 = v1(var7, v1(var23), var14);
         String var29 = v1(var23, 4194304);
         if (var29 != null) {
            if (var27 == null) {
               var27 = JavaFramesSupport.v1(var29) ? v1(var7, var14) : null;
               if (var27 == null) {
                  continue;
               }
            }

            JsonObject var18 = JavaFramesSupport.v2(var29);
            if (var18 != null) {
               var9.add(var14);
               uiSupport247 var19 = uiSupport247.v1("native", Instant.ofEpochMilli(var14)).v2(var18);
               v1(var19, var27);
               var3.report(var19, var27.v3(), var8);
               var20++;
            }
         }
      }

      int var22 = 0;

      for (crashSupport.Part1 var25 : var7) {
         if (var22 >= 3) {
            break;
         }

         if (!var9.stream().anyMatch(var1x -> var1x >= var25.v2())) {
            uiSupport247 var26 = uiSupport247.v1("unclean_exit", Instant.ofEpochMilli(var25.v6() > 0L ? var25.v6() : var25.v2())).v1(var25.v5());
            v1(var26, var25);
            if (var22 == 0) {
               Path var28 = WARNSupport.v1(this.v8.resolve("logs"), var25.v2());
               if (var28 != null) {
                  var26.v2(WARNSupport.v1(var28, 300));
               }
            }

            var3.report(var26, var25.v3(), var8);
            var22++;
         }
      }

      this.v12.v1(var1);
   }

   private LogScrubber v1(List<crashSupport.Part1> var1) {
      LinkedHashSet var2 = new LinkedHashSet<>(this.v13.v18);
      LinkedHashSet var3 = new LinkedHashSet<>(this.v13.v16);

      for (crashSupport.Part1 var5 : var1) {
         var2.addAll(var5.v7());
         var3.addAll(var5.v8());
      }

      return LogScrubber.v1(var3, var2);
   }

   private static void v1(uiSupport247 var0, @Nullable crashSupport.Part1 var1) {
      if (var1 != null) {
         var0.v1(var1.v1()).v2(var1.v4().isEmpty() ? null : var1.v4());
      }
   }

   @Nullable
   private static crashSupport.Part1 v1(List<crashSupport.Part1> var0, long var1) {
      for (crashSupport.Part1 var4 : var0) {
         if (var4.v2() <= var1 && var1 <= Math.max(var4.v6(), var4.v2()) + 150000L) {
            return var4;
         }
      }

      return null;
   }

   @Nullable
   private static crashSupport.Part1 v1(List<crashSupport.Part1> var0, long var1, long var3) {
      if (var1 <= 0L) {
         return null;
      } else {
         for (crashSupport.Part1 var6 : var0) {
            if (var6.v9() == var1 && var6.v2() <= var3) {
               return var6;
            }
         }

         return null;
      }
   }

   public static long v1(Path var0) {
      Matcher var1 = v7.matcher(var0.getFileName().toString());
      if (!var1.matches()) {
         return 0L;
      } else {
         try {
            return Long.parseLong(var1.group(1));
         } catch (NumberFormatException var3) {
            return 0L;
         }
      }
   }

   private static List<Path> v1(Iterable<Path> var0, String var1, long var2) {
      ArrayList var4 = new ArrayList();

      for (Path var6 : var0) {
         if (Files.isDirectory(var6)) {
            try (DirectoryStream var7 = Files.newDirectoryStream(var6, var1)) {
               for (Path var9 : var7) {
                  if (v2(var9) > var2) {
                     var4.add(var9);
                  }
               }
            } catch (IOException var12) {
            }
         }
      }

      var4.sort(Comparator.comparingLong(CrashCollector::v2));
      return var4;
   }

   private static long v2(Path var0) {
      try {
         return Files.getLastModifiedTime(var0).toMillis();
      } catch (IOException var2) {
         return 0L;
      }
   }

   @Nullable
   private static String v1(Path var0, int var1) {
      try {
         String var3;
         try (InputStream var2 = Files.newInputStream(var0)) {
            var3 = new String(var2.readNBytes(var1), StandardCharsets.UTF_8);
         }

         return var3;
      } catch (IOException var7) {
         return null;
      }
   }

   private static Path v3(Path var0) {
      try {
         return var0.toAbsolutePath().normalize();
      } catch (RuntimeException var2) {
         return var0;
      }
   }

   @FunctionalInterface
   public interface Part1 {
      void report(uiSupport247 var1, @Nullable String var2, LogScrubber var3);
   }
}
