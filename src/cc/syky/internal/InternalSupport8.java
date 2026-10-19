package cc.syky.internal;

import cc.syky.LANRecord;
import cc.syky.PointSupport;
import cc.syky.sykyRecord4;
import cc.syky.cloud.cloudSupport66;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.UnaryOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport8 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.waypoints");
   private static final ConcurrentHashMap<Path, Object> v2 = new ConcurrentHashMap<>();
   private static final String v3 = ".json";
   private static final String v4 = "_options.json";
   private static final long v5 = 3600000L;
   private final Path v6;
   private final Path v7;
   private final Object v8;

   public InternalSupport8(Path var1) {
      this.v6 = var1;
      this.v7 = var1.resolve(".lock");
      this.v8 = v2.computeIfAbsent(this.v7.toAbsolutePath().normalize(), var0 -> new Object());
   }

   public void v1() {
      cloudSupport66.v1(this.v6, 3600000L);
   }

   public Path v1(LANRecord var1) {
      return this.v6.resolve(var1.v1() + ".json");
   }

   public List<sykyRecord4> v2(LANRecord var1) throws IOException {
      return this.v1(() -> this.v3(var1));
   }

   public List<sykyRecord4> v1(LANRecord var1, UnaryOperator<List<sykyRecord4>> var2) throws IOException {
      return this.v1(() -> {
         List var3 = this.v3(var1);
         List var4 = List.copyOf(var2.apply(var3));
         if (!var4.equals(var3)) {
            this.v1(var1, var4);
         }

         return var4;
      });
   }

   public Optional<String> v2() throws IOException {
      return this.v1(() -> {
         Path var1 = this.v6.resolve("_options.json");
         return Files.exists(var1) ? Optional.of(Files.readString(var1, StandardCharsets.UTF_8)) : Optional.empty();
      });
   }

   public void v1(String var1) throws IOException {
      this.v1(() -> {
         cloudSupport66.v1(this.v6.resolve("_options.json"), var1);
         return Boolean.TRUE;
      });
   }

   public Map<LANRecord, List<sykyRecord4>> v3() throws IOException {
      return this.v1(() -> {
         LinkedHashMap var1 = new LinkedHashMap();
         if (!Files.isDirectory(this.v6)) {
            return var1;
         } else {
            ArrayList var2 = new ArrayList();

            try (DirectoryStream var3 = Files.newDirectoryStream(this.v6, "*.json")) {
               for (Path var5 : var3) {
                  if (!var5.getFileName().toString().equals("_options.json")) {
                     var2.add(var5);
                  }
               }
            }

            var2.sort(null);

            for (Path var13 : var2) {
               String var14 = Files.readString(var13, StandardCharsets.UTF_8);
               String var6 = PointSupport.v1(var14);
               LANRecord var7 = var6 == null ? null : LANRecord.v5(var6);
               if (var7 != null && this.v1(var7).equals(var13)) {
                  try {
                     List var8 = PointSupport.v2(var14);
                     if (!var8.isEmpty()) {
                        var1.put(var7, List.copyOf(var8));
                     }
                  } catch (PointSupport.Part1 var10) {
                     v1.debug("skipping unreadable waypoints {}: {}", var13.getFileName(), var10.getMessage());
                  }
               }
            }

            return var1;
         }
      });
   }

   private List<sykyRecord4> v3(LANRecord var1) throws IOException {
      Path var2 = this.v1(var1);
      if (!Files.exists(var2)) {
         return List.of();
      } else {
         String var3 = Files.readString(var2, StandardCharsets.UTF_8);

         try {
            return List.copyOf(PointSupport.v2(var3));
         } catch (PointSupport.Part1 var6) {
            Path var5 = var2.resolveSibling(var2.getFileName() + ".unreadable");
            v1.warn(
               "waypoints for {} cannot be read ({}); moved to {} and starting an empty list", new Object[]{var1.v2(), var6.getMessage(), var5.getFileName()}
            );
            Files.move(var2, var5, StandardCopyOption.REPLACE_EXISTING);
            return List.of();
         }
      }
   }

   private void v1(LANRecord var1, List<sykyRecord4> var2) throws IOException {
      Path var3 = this.v1(var1);
      if (var2.isEmpty()) {
         Files.deleteIfExists(var3);
      } else {
         cloudSupport66.v1(var3, PointSupport.v1(var1, var2));
      }
   }

   private <T> T v1(InternalSupport8.Part1<T> var1) throws IOException {
      Files.createDirectories(this.v6);
      synchronized (this.v8) {
         Object var5;
         try (FileChannel var3 = FileChannel.open(this.v7, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            FileLock var4 = var3.lock();

            try {
               var5 = var1.call();
            } finally {
               var4.release();
            }
         }

         return (T)var5;
      }
   }

   @FunctionalInterface
   public interface Part1<T> {
      T call() throws IOException;
   }
}
