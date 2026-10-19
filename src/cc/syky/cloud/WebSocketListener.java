package cc.syky.cloud;

import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

public final class WebSocketListener implements Listener {
   private final Executor v1;
   private final Consumer<String> v2;
   private final Consumer<WebSocketListener.Part1> v3;
   private final StringBuilder v4 = new StringBuilder();
   private boolean v5;
   private static final int v6 = 1048576;

   public WebSocketListener(Executor var1, Consumer<String> var2, Consumer<WebSocketListener.Part1> var3) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
   }

   @Override
   public void onOpen(WebSocket var1) {
      var1.request(1L);
   }

   @Nullable
   @Override
   public CompletionStage<?> onText(WebSocket var1, CharSequence var2, boolean var3) {
      this.v4.append(var2);
      if (this.v4.length() > 1048576) {
         this.v4.setLength(0);
         var1.abort();
         this.v1(new WebSocketListener.Part1(1009, "message too big"));
         return null;
      } else {
         if (var3) {
            String var4 = this.v4.toString();
            this.v4.setLength(0);
            this.v1.execute(() -> this.v2.accept(var4));
         }

         var1.request(1L);
         return null;
      }
   }

   @Nullable
   @Override
   public CompletionStage<?> onBinary(WebSocket var1, ByteBuffer var2, boolean var3) {
      var1.request(1L);
      return null;
   }

   @Nullable
   @Override
   public CompletionStage<?> onClose(WebSocket var1, int var2, String var3) {
      this.v1(new WebSocketListener.Part1(var2, var3));
      return CompletableFuture.completedFuture(null);
   }

   @Override
   public void onError(WebSocket var1, Throwable var2) {
      this.v1(new WebSocketListener.Part1(1006, String.valueOf(var2.getMessage())));
   }

   private void v1(WebSocketListener.Part1 var1) {
      if (!this.v5) {
         this.v5 = true;
         this.v1.execute(() -> this.v3.accept(var1));
      }
   }

   public record Part1(int code, String reason) {
      public int v1() {
         return this.code;
      }

      public String v2() {
         return this.reason;
      }
   }
}
