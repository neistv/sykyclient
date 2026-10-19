package cc.syky.cloud;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public final class cloudSupport66 {
   private static final String v1 = "." + ProcessHandle.current().pid() + ".tmp";
   private static final int v2 = 4;
   private static final long v3 = 40L;

   private cloudSupport66() {
   }

   public static void v1(Path var0, String var1) throws IOException {
      v1(var0, var1.getBytes(StandardCharsets.UTF_8));
   }

   public static void v1(Path var0, byte[] var1) throws IOException {
      Path var2 = var0.getParent();
      if (var2 != null) {
         Files.createDirectories(var2);
      }

      Path var3 = var0.resolveSibling(var0.getFileName() + v1);

      try {
         try (FileChannel var4 = FileChannel.open(var3, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            var4.write(ByteBuffer.wrap(var1));
            var4.force(true);
         }

         v1(var3, var0);
      } catch (IOException var10) {
         try {
            Files.deleteIfExists(var3);
         } catch (IOException var7) {
         }

         throw var10;
      }
   }

   private static void v1(Path var0, Path var1) throws IOException {
      AccessDeniedException var2 = null;

      for (int var3 = 0; var3 < 4; var3++) {
         try {
            Files.move(var0, var1, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            return;
         } catch (AtomicMoveNotSupportedException var7) {
            Files.move(var0, var1, StandardCopyOption.REPLACE_EXISTING);
            return;
         } catch (AccessDeniedException var8) {
            var2 = var8;
            if (var3 < 3) {
               try {
                  Thread.sleep(40L);
               } catch (InterruptedException var6) {
                  Thread.currentThread().interrupt();
                  throw var8;
               }
            }
         }
      }

      throw var2;
   }

   public static void v1(Path var0, long var1) {
      long var3 = System.currentTimeMillis() - var1;

      try (DirectoryStream var5 = Files.newDirectoryStream(var0, "*.tmp")) {
         for (Path var7 : var5) {
            try {
               if (Files.getLastModifiedTime(var7).toMillis() < var3) {
                  Files.deleteIfExists(var7);
               }
            } catch (IOException var10) {
            }
         }
      } catch (IOException var12) {
      }
   }
}
