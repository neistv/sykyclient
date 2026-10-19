package cc.syky.module.visual;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import org.jetbrains.annotations.Nullable;

public final class visualSupport39 {
   public static final int v1 = 1;
   private static final int v2 = 1397446979;
   private static final int v3 = 32;

   private visualSupport39() {
   }

   public static String v1(Path var0) throws IOException {
      Path var1 = var0.toAbsolutePath().normalize();
      return var1 + "|" + Files.size(var1) + "|" + Files.getLastModifiedTime(var1).toMillis();
   }

   @Nullable
   public static visualSupport39.Part1 v1(Path var0, String var1, IntUnaryOperator var2, IntFunction<ByteBuffer> var3, Consumer<ByteBuffer> var4) {
      if (!Files.isRegularFile(var0)) {
         return null;
      } else {
         byte[] var5 = var1.getBytes(StandardCharsets.UTF_8);

         try {
            Object var8;
            try (FileChannel var6 = FileChannel.open(var0, StandardOpenOption.READ)) {
               ByteBuffer var7 = ByteBuffer.allocate(32 + var5.length).order(ByteOrder.LITTLE_ENDIAN);
               if (!v1(var6, var7)) {
                  return null;
               }

               var7.flip();
               if (var7.getInt() == 1397446979 && var7.getInt() == 1) {
                  int var26 = var7.getInt();
                  int var9 = var7.getInt();
                  int var10 = var7.getInt();
                  long var11 = var7.getLong();
                  int var13 = var7.getInt();
                  if (var13 == var5.length
                     && var26 > 0
                     && var26 <= var9
                     && var26 == var2.applyAsInt(var9)
                     && var11 == visualSupport38.v2(var26)
                     && var6.size() == 32 + var5.length + var11) {
                     byte[] var28 = new byte[var13];
                     var7.get(var28);
                     if (!Arrays.equals(var28, var5)) {
                        return null;
                     }

                     ByteBuffer var15 = (ByteBuffer)var3.apply((int)var11);
                     boolean var16 = false;

                     try {
                        var16 = v1(var6, var15);
                     } finally {
                        if (!var16) {
                           var4.accept(var15);
                        }
                     }

                     if (!var16) {
                        return null;
                     }

                     var15.flip();
                     return new visualSupport39.Part1(var15, var26, var9, var10);
                  }

                  return null;
               }

               var8 = null;
            }

            return (visualSupport39.Part1)var8;
         } catch (RuntimeException | IOException var25) {
            return null;
         }
      }
   }

   public static boolean v1(Path var0, String var1, ByteBuffer var2, int var3, int var4, int var5) {
      byte[] var6 = var1.getBytes(StandardCharsets.UTF_8);
      Path var7 = null;

      try {
         Path var8 = var0.toAbsolutePath().getParent();
         Files.createDirectories(var8);
         var7 = Files.createTempFile(var8, var0.getFileName().toString(), ".part");

         try (FileChannel var9 = FileChannel.open(var7, StandardOpenOption.WRITE)) {
            ByteBuffer var10 = ByteBuffer.allocate(32 + var6.length).order(ByteOrder.LITTLE_ENDIAN);
            var10.putInt(1397446979).putInt(1).putInt(var3).putInt(var4).putInt(var5).putLong(var2.remaining()).putInt(var6.length).put(var6).flip();
            v2(var9, var10);
            v2(var9, var2.duplicate());
         }

         Files.move(var7, var0, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
         return true;
      } catch (RuntimeException | IOException var15) {
         if (var7 != null) {
            try {
               Files.deleteIfExists(var7);
            } catch (IOException var12) {
            }
         }

         return false;
      }
   }

   public static void v2(Path var0) {
      try {
         Files.deleteIfExists(var0);
      } catch (IOException var2) {
      }
   }

   private static boolean v1(FileChannel var0, ByteBuffer var1) throws IOException {
      while (var1.hasRemaining()) {
         if (var0.read(var1) < 0) {
            return false;
         }
      }

      return true;
   }

   private static void v2(FileChannel var0, ByteBuffer var1) throws IOException {
      while (var1.hasRemaining()) {
         var0.write(var1);
      }
   }

   public record Part1(ByteBuffer data, int face, int sourceFace, int horizonColor) {
      public ByteBuffer v1() {
         return this.data;
      }

      public int v2() {
         return this.face;
      }

      public int v3() {
         return this.sourceFace;
      }

      public int v4() {
         return this.horizonColor;
      }
   }
}
