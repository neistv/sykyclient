package cc.syky.crash;

import cc.syky.cloud.cloudSupport60;
import cc.syky.cloud.cloudSupport66;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public final class crashSupport {
   private static final String v1 = "session-";
   private final Path v2;
   private final Path v3;
   private final String v4;
   private final String v5;
   private final long v6;
   @Nullable
   private FileChannel v7;
   @Nullable
   private FileLock v8;

   private crashSupport(Path var1, String var2, String var3, long var4) {
      this.v2 = var1.resolve("session-" + var2 + ".json");
      this.v3 = var1.resolve("session-" + var2 + ".lock");
      this.v4 = var2;
      this.v5 = var3;
      this.v6 = var4;
   }

   public static crashSupport v1(Path var0, String var1, String var2, long var3) throws IOException {
      Files.createDirectories(var0);
      crashSupport var5 = new crashSupport(var0, var1, var2, var3);
      FileChannel var6 = FileChannel.open(var5.v3, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

      FileLock var7;
      try {
         var7 = var6.tryLock();
      } catch (RuntimeException | IOException var9) {
         var6.close();
         throw var9;
      }

      if (var7 == null) {
         var6.close();
         throw new IOException("session lock is taken");
      } else {
         var5.v7 = var6;
         var5.v8 = var7;
         var5.v1("boot", 0L, var3, List.of(), List.of());
         return var5;
      }
   }

   public synchronized void v1(String var1, long var2, long var4, Collection<String> var6, Collection<String> var7) {
      if (this.v8 != null) {
         JsonObject var8 = new JsonObject();
         var8.addProperty("session", this.v4);
         var8.addProperty("start", this.v6);
         var8.addProperty("version", this.v5);
         var8.addProperty("phase", var1);
         var8.addProperty("uptime_ms", var2);
         var8.addProperty("beat", var4);
         var8.add("players", v1(var6));
         var8.add("servers", v1(var7));
         var8.addProperty("pid", ProcessHandle.current().pid());

         try {
            cloudSupport66.v1(this.v2, var8.toString());
         } catch (IOException var10) {
         }
      }
   }

   private static JsonArray v1(Collection<String> var0) {
      JsonArray var1 = new JsonArray(var0.size());
      var0.forEach(var1::add);
      return var1;
   }

   public synchronized void v1() {
      try {
         Files.deleteIfExists(this.v2);
      } catch (IOException var3) {
      }

      this.v2();

      try {
         Files.deleteIfExists(this.v3);
      } catch (IOException var2) {
      }
   }

   private void v2() {
      FileLock var1 = this.v8;
      FileChannel var2 = this.v7;
      this.v8 = null;
      this.v7 = null;

      try {
         if (var1 != null) {
            var1.release();
         }

         if (var2 != null) {
            var2.close();
         }
      } catch (IOException var4) {
      }
   }

   public static List<crashSupport.Part1> v1(Path var0, String var1) {
      ArrayList var2 = new ArrayList();
      if (!Files.isDirectory(var0)) {
         return var2;
      } else {
         ArrayList var3 = new ArrayList();

         try (DirectoryStream var4 = Files.newDirectoryStream(var0, "session-*.lock")) {
            var4.forEach(var3::add);
         } catch (IOException var18) {
            return var2;
         }

         try (DirectoryStream var19 = Files.newDirectoryStream(var0, "session-*.json")) {
            for (Path var6 : var19) {
               Path var7 = var6.resolveSibling(var6.getFileName().toString().replaceFirst("\\.json$", ".lock"));
               if (!var3.contains(var7)) {
                  var3.add(var6);
               }
            }
         } catch (IOException var17) {
            return var2;
         }

         for (Path var21 : var3) {
            String var22 = var21.getFileName().toString();
            String var23 = var22.substring("session-".length(), var22.lastIndexOf(46));
            if (!var23.equals(var1)) {
               Path var8 = var0.resolve("session-" + var23 + ".lock");
               if (!Files.exists(var8) || v1(var8)) {
                  Path var9 = var0.resolve("session-" + var23 + ".json");
                  crashSupport.Part1 var10 = v2(var9, var23);

                  try {
                     Files.deleteIfExists(var9);
                     Files.deleteIfExists(var8);
                  } catch (IOException var15) {
                     continue;
                  }

                  if (var10 != null) {
                     var2.add(var10);
                  }
               }
            }
         }

         return var2;
      }
   }

   private static boolean v1(Path var0) {
      try {
         boolean var3;
         try (FileChannel var1 = FileChannel.open(var0, StandardOpenOption.WRITE)) {
            FileLock var2 = var1.tryLock();
            if (var2 == null) {
               return false;
            }

            var2.release();
            var3 = true;
         }

         return var3;
      } catch (IOException | OverlappingFileLockException var6) {
         return false;
      }
   }

   @Nullable
   private static crashSupport.Part1 v2(Path var0, String var1) {
      try {
         JsonElement var2 = JsonParser.parseString(Files.readString(var0, StandardCharsets.UTF_8));
         if (!var2.isJsonObject()) {
            return null;
         } else {
            JsonObject var3 = var2.getAsJsonObject();
            return new crashSupport.Part1(
               var1,
               cloudSupport60.v3(var3, "start"),
               cloudSupport60.v2(var3, "version"),
               cloudSupport60.v2(var3, "phase"),
               cloudSupport60.v3(var3, "uptime_ms"),
               cloudSupport60.v3(var3, "beat"),
               cloudSupport60.v1(var3, "players", var0x -> !var0x.isBlank()),
               cloudSupport60.v1(var3, "servers", var0x -> !var0x.isBlank()),
               cloudSupport60.v3(var3, "pid")
            );
         }
      } catch (RuntimeException | IOException var4) {
         return null;
      }
   }

   public record Part1(
      String session, long start, String version, String phase, long uptimeMillis, long beat, List<String> players, List<String> servers, long pid
   ) {
      public String v1() {
         return this.session;
      }

      public long v2() {
         return this.start;
      }

      public String v3() {
         return this.version;
      }

      public String v4() {
         return this.phase;
      }

      public long v5() {
         return this.uptimeMillis;
      }

      public long v6() {
         return this.beat;
      }

      public List<String> v7() {
         return this.players;
      }

      public List<String> v8() {
         return this.servers;
      }

      public long v9() {
         return this.pid;
      }
   }
}
