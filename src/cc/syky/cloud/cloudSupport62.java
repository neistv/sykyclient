package cc.syky.cloud;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class cloudSupport62 {
   private cloudSupport62() {
   }

   public static <T> CompletableFuture<HttpResponse<T>> v1(HttpClient var0, HttpRequest var1, BodyHandler<T> var2, Duration var3) {
      CompletableFuture var4 = var0.sendAsync(var1, var2);
      CompletableFuture.delayedExecutor(var3.toMillis(), TimeUnit.MILLISECONDS, Runnable::run).execute(() -> var4.cancel(true));
      return var4;
   }

   public static <T> HttpResponse<T> v2(HttpClient var0, HttpRequest var1, BodyHandler<T> var2, Duration var3) throws IOException, InterruptedException {
      CompletableFuture var4 = var0.sendAsync(var1, var2);

      try {
         return (HttpResponse<T>)var4.get(var3.toMillis(), TimeUnit.MILLISECONDS);
      } catch (TimeoutException var8) {
         var4.cancel(true);
         throw new cloudSupport62.Part1(var1.uri() + " took longer than " + var3.toMillis() + " ms", var8);
      } catch (InterruptedException var9) {
         var4.cancel(true);
         throw var9;
      } catch (ExecutionException var10) {
         Throwable var6 = var10.getCause();
         if (var6 instanceof IOException var7) {
            throw var7;
         } else {
            throw new IOException(var1.uri() + " failed", var6);
         }
      }
   }

   public static final class Part1 extends IOException {
      private static final long v1 = 1L;

      public Part1(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
