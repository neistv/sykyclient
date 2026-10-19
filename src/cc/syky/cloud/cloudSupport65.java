package cc.syky.cloud;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodySubscriber;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow.Subscription;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport65 implements BodySubscriber<byte[]> {
   private final int v1;
   private final int v2;
   private final CompletableFuture<byte[]> v3 = new CompletableFuture<>();
   private final ByteArrayOutputStream v4 = new ByteArrayOutputStream();
   @Nullable
   private Subscription v5;

   public cloudSupport65(int var1, int var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public static BodyHandler<byte[]> v1(int var0) {
      return var1 -> new cloudSupport65(var0, var1.statusCode());
   }

   @Override
   public CompletionStage<byte[]> getBody() {
      return this.v3;
   }

   @Override
   public void onSubscribe(Subscription var1) {
      this.v5 = var1;
      var1.request(Long.MAX_VALUE);
   }

   public void v1(List<ByteBuffer> var1) {
      if (!this.v3.isDone()) {
         for (ByteBuffer var3 : var1) {
            if (this.v4.size() + var3.remaining() > this.v1) {
               this.v3.completeExceptionally(new cloudSupport65.Part1(this.v2));
               Subscription var5 = this.v5;
               if (var5 != null) {
                  var5.cancel();
               }

               return;
            }

            byte[] var4 = new byte[var3.remaining()];
            var3.get(var4);
            this.v4.writeBytes(var4);
         }
      }
   }

   @Override
   public void onError(Throwable var1) {
      this.v3.completeExceptionally(var1);
   }

   @Override
   public void onComplete() {
      this.v3.complete(this.v4.toByteArray());
   }

   public static final class Part1 extends IOException {
      private static final long v2 = 1L;
      public final int v1;

      public Part1(int var1) {
         super("the body is over its cap");
         this.v1 = var1;
      }
   }
}
