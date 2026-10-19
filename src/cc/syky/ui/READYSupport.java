package cc.syky.ui;

import cc.syky.cloud.cloudSupport60;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.Closeable;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class READYSupport implements Closeable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.discord");
   private static final long v2 = 10000L;
   private static final long v3 = 5000L;
   private static final int v4 = 1;
   private final TMPSupport v5;
   private final long v6 = ProcessHandle.current().pid();
   private boolean v7;

   private READYSupport(TMPSupport var1) {
      this.v5 = var1;
   }

   @Nullable
   public static READYSupport v1(String var0) throws IOException {
      TMPSupport var1 = TMPSupport.v1();
      if (var1 == null) {
         return null;
      } else {
         READYSupport var2 = new READYSupport(var1);

         try {
            var2.v2(var0);
            return var2;
         } catch (RuntimeException | IOException var4) {
            var2.close();
            throw var4;
         }
      }
   }

   public void v1(@Nullable DiscordRecord var1) throws IOException {
      JsonObject var2 = new JsonObject();
      var2.addProperty("pid", this.v6);
      var2.add("activity", (JsonElement)(var1 == null ? JsonNull.INSTANCE : var1.v1()));
      String var3 = UUID.randomUUID().toString();
      JsonObject var4 = new JsonObject();
      var4.addProperty("cmd", "SET_ACTIVITY");
      var4.addProperty("nonce", var3);
      var4.add("args", var2);
      this.v5.v1(new uiRecord11(1, var4.toString()).v1());
      this.v3(var3);
   }

   private void v2(String var1) throws IOException {
      JsonObject var2 = new JsonObject();
      var2.addProperty("v", 1);
      var2.addProperty("client_id", var1);
      this.v5.v1(new uiRecord11(0, var2.toString()).v1());
      JsonObject var3 = this.v1(10000L);
      String var4 = cloudSupport60.v1(var3, "evt");
      if (!"READY".equals(var4)) {
         throw new IOException("discord answered the handshake with " + var3);
      }
   }

   private void v3(String var1) throws IOException {
      long var2 = System.currentTimeMillis() + 5000L;

      JsonObject var4;
      do {
         var4 = this.v1(Math.max(1L, var2 - System.currentTimeMillis()));
      } while (!var1.equals(cloudSupport60.v1(var4, "nonce")));

      if ("ERROR".equals(cloudSupport60.v1(var4, "evt")) && !this.v7) {
         this.v7 = true;
         v1.warn("Discord rejected the presence update: {}", var4);
      }
   }

   private JsonObject v1(long var1) throws IOException {
      long var3 = System.currentTimeMillis() + var1;

      while (true) {
         uiRecord11 var5 = uiRecord11.v1(this.v5, Math.max(1L, var3 - System.currentTimeMillis()));
         switch (var5.v2()) {
            case 1:
               return v5(var5.v3());
            case 2:
               throw v4(var5.v3());
            case 3:
               this.v5.v1(new uiRecord11(4, var5.v3()).v1());
               break;
            default:
               throw new IOException("unexpected discord opcode " + var5.v2());
         }
      }
   }

   private static IOException v4(String var0) {
      JsonObject var1;
      try {
         var1 = v5(var0);
      } catch (IOException var5) {
         return new IOException("discord closed the connection");
      }

      String var2 = cloudSupport60.v1(var1, "message");
      JsonElement var3 = var1.get("code");
      String var4 = (var2 == null ? "no reason given" : var2) + (var3 == null ? "" : " (" + var3 + ")");
      return (IOException)(v1(var3) ? new READYSupport.Part1(var4) : new IOException("discord closed the connection: " + var4));
   }

   private static boolean v1(@Nullable JsonElement var0) {
      try {
         return var0 != null && var0.getAsInt() == 4000;
      } catch (RuntimeException var2) {
         return false;
      }
   }

   private static JsonObject v5(String var0) throws IOException {
      try {
         JsonElement var1 = JsonParser.parseString(var0);
         if (!var1.isJsonObject()) {
            throw new IOException("discord sent a non-object frame: " + var0);
         } else {
            return var1.getAsJsonObject();
         }
      } catch (RuntimeException var2) {
         throw new IOException("discord sent an unreadable frame", var2);
      }
   }

   @Override
   public void close() {
      try {
         this.v5.close();
      } catch (IOException var2) {
         v1.debug("closing the discord pipe failed", var2);
      }
   }

   public static final class Part1 extends IOException {
      private static final long v1 = 1L;

      public Part1(String var1) {
         super(var1);
      }
   }
}
