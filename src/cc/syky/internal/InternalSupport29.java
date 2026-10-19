package cc.syky.internal;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport29 implements AutoCloseable {
   private static final Logger v2 = LoggerFactory.getLogger("syky.settings.lock");
   public static final String v1 = "_instance.lock";
   private final boolean v3;
   @Nullable
   private final FileChannel v4;
   @Nullable
   private final FileLock v5;

   private InternalSupport29(boolean var1, @Nullable FileChannel var2, @Nullable FileLock var3) {
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = var3;
   }

   public static InternalSupport29 v1(Path var0) {
      try {
         Files.createDirectories(var0);
         Path var1 = var0.resolve("_instance.lock");
         FileChannel var2 = FileChannel.open(var1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
         FileLock var3 = v1(var2);
         if (var3 != null) {
            v2.info("config folder {} — this is the only instance using it", var0);
            return new InternalSupport29(true, var2, var3);
         } else {
            v2(var2);
            v2.info(
               "config folder {} is SHARED with another running syky instance — saves from both are merged per setting, and the newest write of the same setting wins",
               var0
            );
            return new InternalSupport29(false, null, null);
         }
      } catch (RuntimeException | IOException var4) {
         v2.debug("could not probe the instance lock in {}", var0, var4);
         return new InternalSupport29(true, null, null);
      }
   }

   @Nullable
   private static FileLock v1(FileChannel var0) throws IOException {
      try {
         return var0.tryLock();
      } catch (OverlappingFileLockException var2) {
         return null;
      }
   }

   public boolean v1() {
      return this.v3;
   }

   @Override
   public void close() {
      if (this.v5 != null) {
         try {
            this.v5.release();
         } catch (IOException var2) {
            v2.debug("failed to release the instance lock", var2);
         }
      }

      if (this.v4 != null) {
         v2(this.v4);
      }
   }

   private static void v2(FileChannel var0) {
      try {
         var0.close();
      } catch (IOException var2) {
         v2.debug("failed to close the instance lock channel", var2);
      }
   }
}
