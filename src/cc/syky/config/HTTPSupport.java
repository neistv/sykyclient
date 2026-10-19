package cc.syky.config;

import cc.syky.cloud.cloudSupport62;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.BodySubscribers;
import java.net.http.HttpResponse.ResponseInfo;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HTTPSupport<K> {
   private static final Logger v1 = LoggerFactory.getLogger("syky.tiers");
   public static final Duration v2 = Duration.ofSeconds(6L);
   private static final Duration v3 = Duration.ofSeconds(20L);
   private static final int v4 = 512;
   private static final int v5 = 4;
   private static final int v6 = 131072;
   private static final Optional<Map<String, configRecord2>> v7 = Optional.of(Map.of());
   public static final ExecutorService v8 = Executors.newFixedThreadPool(2, var0 -> {
      Thread var1 = new Thread(var0, "syky-tiers");
      var1.setDaemon(true);
      var1.setPriority(4);
      return var1;
   });
   private static final AtomicInteger v9 = new AtomicInteger();
   private final String v10;
   private final Function<K, URI> v11;
   private final HTTPSupport.Part1 v12;
   private final Semaphore v13 = new Semaphore(4);
   private final AtomicBoolean v14 = new AtomicBoolean();
   private final Map<K, Optional<Map<String, configRecord2>>> v15 = Collections.synchronizedMap(
      new LinkedHashMap<K, Optional<Map<String, configRecord2>>>(64, 0.75F, true) {
         @Override
         public boolean removeEldestEntry(Entry<K, Optional<Map<String, configRecord2>>> var1) {
            return this.size() > 512;
         }
      }
   );

   public static int v1() {
      return v9.get();
   }

   public static void v2() {
      v9.incrementAndGet();
   }

   public static void v1(Runnable var0) {
      v8.execute(var0);
   }

   public static HttpClient v3() {
      return HTTPSupport.Part2.v1;
   }

   public HTTPSupport(String var1, Function<K, URI> var2, HTTPSupport.Part1 var3) {
      this.v10 = var1;
      this.v11 = var2;
      this.v12 = var3;
   }

   public Optional<Map<String, configRecord2>> v1(K var1) {
      Optional var2 = this.v15.get(var1);
      if (var2 != null) {
         return var2;
      } else if (!this.v13.tryAcquire()) {
         return Optional.empty();
      } else {
         this.v15.put((K)var1, Optional.empty());

         try {
            v8.execute(() -> this.v2((K)var1));
         } catch (Throwable var4) {
            this.v13.release();
            this.v15.put((K)var1, v7);
            v9.incrementAndGet();
            v1.debug("{} lookup for {} could not be started", new Object[]{this.v10, var1, var4});
         }

         return Optional.empty();
      }
   }

   private void v2(K var1) {
      try {
         HttpRequest var2 = HttpRequest.newBuilder(this.v11.apply((K)var1)).timeout(v2).header("Accept", "application/json").GET().build();
         cloudSupport62.v1(HTTPSupport.Part2.v1, var2, HTTPSupport::v1, v3)
            .whenComplete((var2x, var3x) -> this.v1((K)var1, (HttpResponse<String>)var2x, var3x));
      } catch (Throwable var3) {
         this.v1((K)var1, null, var3);
      }
   }

   private void v1(K var1, @Nullable HttpResponse<String> var2, @Nullable Throwable var3) {
      try {
         this.v15.put((K)var1, this.v2((K)var1, var2, var3));
      } catch (Throwable var8) {
         this.v15.put((K)var1, v7);
         v1.debug("{} lookup for {} returned a body we could not use", new Object[]{this.v10, var1, var8});
      } finally {
         this.v13.release();
         v9.incrementAndGet();
      }
   }

   private Optional<Map<String, configRecord2>> v2(K var1, @Nullable HttpResponse<String> var2, @Nullable Throwable var3) {
      if (var3 != null) {
         this.v1("request failed: " + var3);
         return v7;
      } else if (var2 == null) {
         this.v1("no response");
         return v7;
      } else if (var2.statusCode() != 200) {
         if (var2.statusCode() != 404) {
            this.v1("HTTP " + var2.statusCode());
         }

         return v7;
      } else if (((String)var2.body()).isEmpty()) {
         this.v1("body refused: it declared a type other than json, or ran past the size ceiling");
         return v7;
      } else {
         Map var4 = this.v12.parse((String)var2.body());
         return var4 != null && !var4.isEmpty() ? Optional.of(var4) : v7;
      }
   }

   private void v1(String var1) {
      if (this.v14.compareAndSet(false, true)) {
         v1.warn("{} is not answering ({}) - its tiers stay missing for this session", this.v10, var1);
      }
   }

   private static BodySubscriber<String> v1(ResponseInfo var0) {
      return (BodySubscriber<String>)(var0.statusCode() == 200 && v2(var0) && v3(var0) <= 131072L ? new HTTPSupport.Part3() : BodySubscribers.replacing(""));
   }

   private static boolean v2(ResponseInfo var0) {
      return var0.headers().firstValue("content-type").map(var0x -> var0x.toLowerCase(Locale.ROOT).startsWith("application/json")).orElse(true);
   }

   private static long v3(ResponseInfo var0) {
      return var0.headers().firstValueAsLong("content-length").orElse(0L);
   }

   @FunctionalInterface
   public interface Part1 {
      @Nullable
      Map<String, configRecord2> parse(String var1);
   }

   public static final class Part2 {
      public static final HttpClient v1 = HttpClient.newBuilder()
         .connectTimeout(HTTPSupport.v2)
         .followRedirects(Redirect.NEVER)
         .executor(HTTPSupport.v8)
         .build();

      private Part2() {
      }
   }

   public static final class Part3 implements BodySubscriber<String> {
      private final CompletableFuture<String> v1 = new CompletableFuture<>();
      private final List<ByteBuffer> v2 = new ArrayList<>();
      @Nullable
      private Subscription v3;
      private int v4;

      public Part3() {
      }

      @Override
      public CompletionStage<String> getBody() {
         return this.v1;
      }

      @Override
      public void onSubscribe(Subscription var1) {
         this.v3 = var1;
         var1.request(Long.MAX_VALUE);
      }

      public void v1(List<ByteBuffer> var1) {
         for (ByteBuffer var3 : var1) {
            this.v4 = this.v4 + var3.remaining();
            if (this.v4 > 131072) {
               this.v2.clear();
               if (this.v3 != null) {
                  this.v3.cancel();
               }

               this.v1.complete("");
               return;
            }

            this.v2.add(var3);
         }
      }

      @Override
      public void onError(Throwable var1) {
         this.v1.completeExceptionally(var1);
      }

      @Override
      public void onComplete() {
         if (!this.v1.isDone()) {
            byte[] var1 = new byte[this.v4];
            int var2 = 0;

            for (ByteBuffer var4 : this.v2) {
               int var5 = var4.remaining();
               var4.get(var1, var2, var5);
               var2 += var5;
            }

            this.v2.clear();
            this.v1.complete(new String(var1, 0, var2, StandardCharsets.UTF_8));
         }
      }
   }
}
