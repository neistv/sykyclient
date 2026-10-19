package cc.syky.ui;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public abstract class TMPSupport implements Closeable {
   private static final int v1 = 10;
   private static final long v2 = 25L;
   private static final List<String> v3 = List.of("XDG_RUNTIME_DIR", "TMPDIR", "TMP", "TEMP");
   private static final List<String> v4 = List.of("", "snap.discord/", "app/com.discordapp.Discord/", "app/com.discordapp.DiscordCanary/");

   public TMPSupport() {
   }

   public abstract int v1(byte[] var1, int var2, int var3) throws IOException;

   public abstract void v1(byte[] var1) throws IOException;

   public final void v1(byte[] var1, long var2) throws IOException {
      long var4 = System.currentTimeMillis() + var2;
      int var6 = 0;

      while (var6 < var1.length) {
         int var7 = this.v1(var1, var6, var1.length - var6);
         if (var7 < 0) {
            throw new EOFException("discord closed the pipe");
         }

         if (var7 > 0) {
            var6 += var7;
         } else {
            if (System.currentTimeMillis() >= var4) {
               throw new IOException("discord did not answer within " + var2 + " ms");
            }

            try {
               Thread.sleep(25L);
            } catch (InterruptedException var9) {
               Thread.currentThread().interrupt();
               throw new InterruptedIOException("interrupted while reading from discord");
            }
         }
      }
   }

   @Nullable
   public static TMPSupport v1() {
      boolean var0 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).startsWith("windows");

      for (int var1 = 0; var1 < 10; var1++) {
         TMPSupport var2 = var0 ? v1(var1) : v2(var1);
         if (var2 != null) {
            return var2;
         }
      }

      return null;
   }

   @Nullable
   private static TMPSupport v1(int var0) {
      try {
         return new TMPSupport.Part1(new RandomAccessFile("\\\\.\\pipe\\discord-ipc-" + var0, "rw"));
      } catch (RuntimeException | IOException var2) {
         return null;
      }
   }

   @Nullable
   private static TMPSupport v2(int var0) {
      for (Path var2 : v2()) {
         for (String var4 : v4) {
            Path var5 = var2.resolve(var4 + "discord-ipc-" + var0);
            if (Files.exists(var5)) {
               try {
                  return new TMPSupport.Part2(SocketChannel.open(UnixDomainSocketAddress.of(var5)));
               } catch (RuntimeException | IOException var7) {
               }
            }
         }
      }

      return null;
   }

   private static List<Path> v2() {
      ArrayList var0 = new ArrayList(v3.size() + 2);

      for (String var2 : v3) {
         v1(var0, System.getenv(var2));
      }

      v1(var0, System.getProperty("java.io.tmpdir"));
      v1(var0, "/tmp");
      return var0;
   }

   private static void v1(List<Path> var0, @Nullable String var1) {
      if (var1 != null && !var1.isBlank()) {
         try {
            Path var2 = Path.of(var1);
            if (Files.isDirectory(var2, LinkOption.NOFOLLOW_LINKS) && !var0.contains(var2)) {
               var0.add(var2);
            }
         } catch (InvalidPathException var3) {
         }
      }
   }

   public static final class Part1 extends TMPSupport {
      private final RandomAccessFile v1;

      public Part1(RandomAccessFile var1) {
         this.v1 = var1;
      }

      @Override
      public int v1(byte[] var1, int var2, int var3) throws IOException {
         return this.v1.length() <= 0L ? 0 : this.v1.read(var1, var2, var3);
      }

      @Override
      public void v1(byte[] var1) throws IOException {
         this.v1.write(var1);
      }

      @Override
      public void close() throws IOException {
         this.v1.close();
      }
   }

   public static final class Part2 extends TMPSupport {
      private final SocketChannel v1;

      public Part2(SocketChannel var1) throws IOException {
         this.v1 = var1;
         var1.configureBlocking(false);
      }

      @Override
      public int v1(byte[] var1, int var2, int var3) throws IOException {
         return this.v1.read(ByteBuffer.wrap(var1, var2, var3));
      }

      @Override
      public void v1(byte[] var1) throws IOException {
         ByteBuffer var2 = ByteBuffer.wrap(var1);

         while (var2.hasRemaining()) {
            if (this.v1.write(var2) == 0) {
               try {
                  Thread.sleep(25L);
               } catch (InterruptedException var4) {
                  Thread.currentThread().interrupt();
                  throw new InterruptedIOException("interrupted while writing to discord");
               }
            }
         }
      }

      @Override
      public void close() throws IOException {
         this.v1.close();
      }
   }
}
