package cc.syky.ui;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public record uiRecord11(int op, String payload) {
   public static final int OP_HANDSHAKE = 0;
   public static final int OP_FRAME = 1;
   public static final int OP_CLOSE = 2;
   public static final int OP_PING = 3;
   public static final int OP_PONG = 4;
   private static final int HEADER_BYTES = 8;
   private static final int MAX_PAYLOAD_BYTES = 65536;

   public byte[] v1() {
      byte[] var1 = this.payload.getBytes(StandardCharsets.UTF_8);
      return ByteBuffer.allocate(8 + var1.length).order(ByteOrder.LITTLE_ENDIAN).putInt(this.op).putInt(var1.length).put(var1).array();
   }

   public static uiRecord11 v1(TMPSupport var0, long var1) throws IOException {
      long var3 = System.currentTimeMillis() + var1;
      byte[] var5 = new byte[8];
      var0.v1(var5, var1);
      ByteBuffer var6 = ByteBuffer.wrap(var5).order(ByteOrder.LITTLE_ENDIAN);
      int var7 = var6.getInt();
      int var8 = var6.getInt();
      if (var8 < 0 || var8 > 65536) {
         throw new IOException("discord frame claims " + var8 + " bytes of payload");
      } else if (var8 == 0) {
         return new uiRecord11(var7, "");
      } else {
         byte[] var9 = new byte[var8];
         var0.v1(var9, Math.max(1L, var3 - System.currentTimeMillis()));
         return new uiRecord11(var7, new String(var9, StandardCharsets.UTF_8));
      }
   }

   public int v2() {
      return this.op;
   }

   public String v3() {
      return this.payload;
   }
}
