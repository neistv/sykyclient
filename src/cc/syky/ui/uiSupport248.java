package cc.syky.ui;

import cc.syky.cloud.cloudSupport66;
import cc.syky.crash.CrashUploader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class uiSupport248 implements CrashUploader.Part2 {
   public static final int v1 = 50;
   public static final long v2 = 8388608L;
   private static final String v3 = ".json";
   private static final long v4 = 3600000L;
   private final Path v5;
   private final int v6;
   private final long v7;
   @Nullable
   private volatile Runnable v8;

   public uiSupport248(Path var1) {
      this(var1, 50, 8388608L);
   }

   public uiSupport248(Path var1, int var2, long var3) {
      this.v5 = var1;
      this.v6 = var2;
      this.v7 = var3;
   }

   public void v2() {
      cloudSupport66.v1(this.v5, 3600000L);
   }

   @Nullable
   public Path v1(uiSupport247 var1, long var2) {
      String var4 = String.format(Locale.ROOT, "%013d-%s-%s", var2, var1.v3() ? "f" : "n", var1.v1());
      Path var5 = this.v5.resolve(var4 + ".json");
      synchronized (this) {
         try {
            cloudSupport66.v1(var5, var1.v4().toString());
         } catch (IOException var9) {
            return null;
         }

         this.v3();
      }

      Runnable var6 = this.v8;
      if (var6 != null) {
         var6.run();
      }

      return var5;
   }

   @Override
   public synchronized List<Path> v1() {
      List var1 = this.v4();
      var1.sort(Comparator.<Path, Boolean>comparing(var0 -> !v3(var0)).thenComparing(var0 -> var0.getFileName().toString()));
      return var1;
   }

   @Nullable
   @Override
   public byte[] v1(Path var1) {
      try {
         return Files.readAllBytes(var1);
      } catch (IOException var3) {
         return null;
      }
   }

   @Override
   public synchronized void v2(Path var1) {
      try {
         Files.deleteIfExists(var1);
      } catch (IOException var3) {
      }
   }

   @Override
   public void v1(Runnable var1) {
      this.v8 = var1;
   }

   private void v3() {
      List var1 = this.v4();
      var1.sort(Comparator.comparing(var0 -> var0.getFileName().toString()));
      long var2 = 0L;

      for (Path var5 : var1) {
         var2 += v4(var5);
      }

      while (!var1.isEmpty() && (var1.size() > this.v6 || var2 > this.v7)) {
         Path var7 = var1.stream().filter(var0 -> !v3(var0)).findFirst().orElse((Path)var1.get(0));
         var2 -= v4(var7);
         var1.remove(var7);

         try {
            Files.deleteIfExists(var7);
         } catch (IOException var6) {
         }
      }
   }

   private List<Path> v4() {
      ArrayList var1 = new ArrayList();
      if (!Files.isDirectory(this.v5)) {
         return var1;
      } else {
         try (DirectoryStream var2 = Files.newDirectoryStream(this.v5, "*.json")) {
            var2.forEach(var1::add);
         } catch (IOException var7) {
         }

         return var1;
      }
   }

   private static boolean v3(Path var0) {
      String var1 = var0.getFileName().toString();
      int var2 = var1.indexOf(45);
      return var2 >= 0 && var1.startsWith("f-", var2 + 1);
   }

   private static long v4(Path var0) {
      try {
         return Files.size(var0);
      } catch (IOException var2) {
         return 0L;
      }
   }

   public static byte[] v1(uiSupport247 var0) {
      return var0.v4().toString().getBytes(StandardCharsets.UTF_8);
   }
}
