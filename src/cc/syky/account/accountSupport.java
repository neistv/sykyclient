package cc.syky.account;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.jetbrains.annotations.Nullable;

public final class accountSupport {
   public static final int v1 = 3;
   public static final int v2 = 8388612;
   public static final int v3 = 2;
   public static final int v4 = 0;
   public static final int v5 = 1;
   public static final int v6 = 2;
   public static final int v7 = 0;
   public static final int v8 = 3;
   public static final String v9 = "toggle";
   public static final String v10 = "next";
   public static final String v11 = "prev";
   public static final String v12 = "active";
   public static final String v13 = "idle";
   private static final int v14 = 0;
   private static final int v15 = 1;
   private static final int v16 = 2;
   private static final int v18 = 3;
   private static final int v19 = 4;
   private static final int v17 = 5;
   private static final int v20 = 1;
   private static final int v21 = 2;
   private static final int v22 = 4;
   private static final int v24 = 8;
   private static final int v25 = 16;

   private accountSupport() {
   }

   public static String v1(long var0) {
      return "seek " + var0;
   }

   @Nullable
   public static accountSupport.Part2 v1(DataInputStream var0) throws IOException {
      int var1 = var0.read();
      if (var1 < 0) {
         return null;
      } else {
         int var2 = var0.readInt();
         if (var2 >= 0 && var2 <= 8388612) {
            byte[] var3 = var0.readNBytes(var2);
            if (var3.length != var2) {
               throw new EOFException("frame cut at " + var3.length + " of " + var2 + " bytes");
            } else {
               try {
                  return v1(var1, var3);
               } catch (BufferUnderflowException var5) {
                  throw new IOException("frame of kind " + var1 + " shorter than its fields", var5);
               }
            }
         } else {
            throw new IOException("frame length " + var2);
         }
      }
   }

   private static accountSupport.Part2 v1(int var0, byte[] var1) {
      ByteBuffer var2 = ByteBuffer.wrap(var1);

      return (accountSupport.Part2)(switch (var0) {
         case 0 -> new accountSupport.Part1(Short.toUnsignedInt(var2.getShort()));
         case 1 -> {
            byte var3 = var2.get();
            long var4 = var2.getLong();
            long var6 = var2.getLong();
            byte var8 = var2.get();
            int var9 = var2.getInt();
            String var10 = v1(var2);
            String var11 = v1(var2);
            String var12 = v1(var2);
            yield new accountSupport.Part5(
               (var3 & 1) != 0, (var3 & 2) != 0, (var3 & 4) != 0, (var3 & 8) != 0, (var3 & 16) != 0, var4, var6, var8, var9, var10, var11, var12
            );
         }
         case 2 -> new accountSupport.Part4(var2.getInt(), Arrays.copyOfRange(var1, 4, var1.length));
         case 3 -> new accountSupport.Part6(new String(var1, StandardCharsets.UTF_8));
         case 4 -> new accountSupport.Part3(Byte.toUnsignedInt(var2.get()), var2.get() != 0);
         case 5 -> new accountSupport.Part8(var1);
         default -> new accountSupport.Part7(var0);
      });
   }

   private static String v1(ByteBuffer var0) {
      int var1 = Short.toUnsignedInt(var0.getShort());
      if (var1 > var0.remaining()) {
         throw new BufferUnderflowException();
      } else {
         String var2 = new String(var0.array(), var0.position(), var1, StandardCharsets.UTF_8);
         var0.position(var0.position() + var1);
         return var2;
      }
   }

   public record Part1(int version) implements accountSupport.Part2 {
      public int v1() {
         return this.version;
      }
   }

   public sealed interface Part2
      permits accountSupport.Part1,
      accountSupport.Part5,
      accountSupport.Part4,
      accountSupport.Part6,
      accountSupport.Part3,
      accountSupport.Part8,
      accountSupport.Part7 {
   }

   public record Part3(int command, boolean accepted) implements accountSupport.Part2 {
      public int v1() {
         return this.command;
      }

      public boolean v2() {
         return this.accepted;
      }
   }

   public record Part4(int hash, byte[] png) implements accountSupport.Part2 {
      public int v1() {
         return this.hash;
      }

      public byte[] v2() {
         return this.png;
      }
   }

   public record Part5(
      boolean present,
      boolean playing,
      boolean canSeek,
      boolean live,
      boolean advancing,
      long durationMs,
      long positionMs,
      int artState,
      int artHash,
      String title,
      String artist,
      String owner
   ) implements accountSupport.Part2 {
      public boolean v1() {
         return this.present;
      }

      public boolean v2() {
         return this.playing;
      }

      public boolean v3() {
         return this.canSeek;
      }

      public boolean v4() {
         return this.live;
      }

      public boolean v5() {
         return this.advancing;
      }

      public long v6() {
         return this.durationMs;
      }

      public long v7() {
         return this.positionMs;
      }

      public int v8() {
         return this.artState;
      }

      public int v9() {
         return this.artHash;
      }

      public String v10() {
         return this.title;
      }

      public String v11() {
         return this.artist;
      }

      public String v12() {
         return this.owner;
      }
   }

   public record Part6(String line) implements accountSupport.Part2 {
      public String v1() {
         return this.line;
      }
   }

   public record Part7(int kind) implements accountSupport.Part2 {
      public int v1() {
         return this.kind;
      }
   }

   public record Part8(byte[] values) implements accountSupport.Part2 {
      public byte[] v1() {
         return this.values;
      }
   }
}
