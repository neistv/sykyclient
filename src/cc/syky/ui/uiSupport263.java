package cc.syky.ui;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport263 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.account");
   private static final Pattern v2 = Pattern.compile("[0-9a-z]{1,32}");
   private final Path v3;
   private final Map<String, uiSupport263.Part1> v4 = new HashMap<>();

   public uiSupport263(Path var1) {
      this.v3 = var1;
   }

   public boolean v1(String var1) {
      if (this.v4.containsKey(var1)) {
         return true;
      } else if (!v2.matcher(var1).matches()) {
         return false;
      } else {
         FileChannel var2 = null;

         try {
            Files.createDirectories(this.v3);
            var2 = FileChannel.open(this.v3.resolve(var1 + ".lock"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            FileLock var3 = var2.tryLock();
            if (var3 != null) {
               this.v4.put(var1, new uiSupport263.Part1(var2, var3));
               return true;
            }
         } catch (OverlappingFileLockException var4) {
         } catch (IOException var5) {
            v1.debug("could not claim account {}: {}", var1, var5.getMessage());
         }

         v1(var2);
         return false;
      }
   }

   public void v1(Set<String> var1) {
      Iterator var2 = this.v4.entrySet().iterator();

      while (var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (!var1.contains(var3.getKey())) {
            v1((uiSupport263.Part1)var3.getValue());
            var2.remove();
         }
      }
   }

   private static void v1(uiSupport263.Part1 var0) {
      try {
         var0.v2().release();
      } catch (IOException var2) {
         v1.debug("could not release an account lock: {}", var2.getMessage());
      }

      v1(var0.v1());
   }

   private static void v1(@Nullable FileChannel var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
         }
      }
   }

   public record Part1(FileChannel channel, FileLock lock) {
      public FileChannel v1() {
         return this.channel;
      }

      public FileLock v2() {
         return this.lock;
      }
   }
}
