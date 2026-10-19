package cc.syky.config;

import cc.syky.cloud.cloudSupport62;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.BodySubscribers;
import java.net.http.HttpResponse.ResponseInfo;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AcceptSupport {
   private static final Logger v1 = LoggerFactory.getLogger("syky.tiers");
   private static final Duration v2 = Duration.ofSeconds(30L);
   private static final Duration v3 = Duration.ofMinutes(2L);
   private static final Duration v4 = Duration.ofMinutes(15L);
   private static final int v5 = 25165824;
   private static final int v6 = 200000;
   private final String v7;
   private final URI v8;
   private final AtomicBoolean v9 = new AtomicBoolean();
   @Nullable
   private volatile Map<String, Map<String, configRecord2>> v10;
   @Nullable
   private volatile String v11;
   private volatile long v12;
   private volatile boolean v13;

   public AcceptSupport(String var1, URI var2) {
      this.v7 = var1;
      this.v8 = var2;
   }

   public Optional<Map<String, configRecord2>> v1(String var1) {
      Map var2 = this.v10;
      if (!this.v13 || System.nanoTime() - this.v12 > v4.toNanos()) {
         this.v1();
      }

      if (var2 == null) {
         return Optional.empty();
      } else {
         Map var3 = (Map)var2.get(var1);
         return var3 == null ? Optional.of(Map.of()) : Optional.of(var3);
      }
   }

   private void v1() {
      if (this.v9.compareAndSet(false, true)) {
         try {
            HTTPSupport.v1(this::v2);
         } catch (Throwable var2) {
            this.v9.set(false);
            v1.debug("{} roster fetch could not be started", this.v7, var2);
         }
      }
   }

   private void v2() {
      Builder var1 = HttpRequest.newBuilder(this.v8).timeout(v2).header("Accept", "application/json").GET();
      String var2 = this.v11;
      if (var2 != null) {
         var1.header("If-None-Match", var2);
      }

      cloudSupport62.v1(HTTPSupport.v3(), var1.build(), AcceptSupport::v1, v3).whenComplete((var1x, var2x) -> this.v1((HttpResponse<byte[]>)var1x, var2x));
   }

   private void v1(@Nullable HttpResponse<byte[]> var1, @Nullable Throwable var2) {
      try {
         if (var2 != null || var1 == null) {
            return;
         }

         if (var1.statusCode() == 304) {
            return;
         }

         if (var1.statusCode() == 200 && ((byte[])var1.body()).length != 0) {
            Map var3 = v1((byte[])var1.body());
            if (var3 != null) {
               this.v10 = var3;
               this.v11 = var1.headers().firstValue("etag").orElse(null);
               HTTPSupport.v2();
            }

            return;
         }
      } catch (Throwable var7) {
         v1.debug("{} roster came back in a shape we could not use", this.v7, var7);
         return;
      } finally {
         if (this.v10 == null) {
            this.v10 = Map.of();
            HTTPSupport.v2();
         }

         this.v12 = System.nanoTime();
         this.v13 = true;
         this.v9.set(false);
      }
   }

   private static BodySubscriber<byte[]> v1(ResponseInfo var0) {
      long var1 = var0.headers().firstValueAsLong("content-length").orElse(-1L);
      boolean var3 = var0.headers().firstValue("content-type").map(var0x -> var0x.toLowerCase(Locale.ROOT).startsWith("application/json")).orElse(false);
      return var0.statusCode() == 200 && var3 && var1 >= 0L && var1 <= 25165824L ? BodySubscribers.ofByteArray() : BodySubscribers.replacing(new byte[0]);
   }

   @Nullable
   public static Map<String, Map<String, configRecord2>> v1(byte[] var0) throws Exception {
      HashMap var1 = new HashMap(32768);

      try (InputStreamReader var2 = new InputStreamReader(new ByteArrayInputStream(var0), StandardCharsets.UTF_8)) {
         JsonReader var3 = new JsonReader(var2);

         try {
            var3.beginObject();

            while (var3.hasNext()) {
               if (!"data".equals(var3.nextName())) {
                  var3.skipValue();
               } else {
                  v1(var3, var1);
               }
            }

            var3.endObject();
         } catch (Throwable var8) {
            try {
               var3.close();
            } catch (Throwable var7) {
               var8.addSuppressed(var7);
            }

            throw var8;
         }

         var3.close();
      }

      return var1.isEmpty() ? null : var1;
   }

   private static void v1(JsonReader var0, Map<String, Map<String, configRecord2>> var1) throws Exception {
      if (var0.peek() != JsonToken.BEGIN_OBJECT) {
         var0.skipValue();
      } else {
         HashMap var2 = new HashMap();
         var0.beginObject();

         while (var0.hasNext()) {
            String var3 = configSupport13.v1(var0.nextName());
            if (var3 != null && var1.size() < 200000) {
               Map var4 = v2(var0, var2);
               if (!var4.isEmpty()) {
                  var1.put(var3, Map.copyOf(var4));
               }
            } else {
               var0.skipValue();
            }
         }

         var0.endObject();
      }
   }

   private static Map<String, configRecord2> v2(JsonReader var0, Map<String, configRecord2> var1) throws Exception {
      if (var0.peek() != JsonToken.BEGIN_OBJECT) {
         var0.skipValue();
         return Map.of();
      } else {
         HashMap var2 = new HashMap(4);
         var0.beginObject();

         while (var0.hasNext()) {
            if ("tiers".equals(var0.nextName()) && var0.peek() == JsonToken.BEGIN_OBJECT) {
               var0.beginObject();

               while (var0.hasNext()) {
                  String var3 = configSupport13.v7(var0.nextName());
                  if (var3 != null && var0.peek() == JsonToken.STRING) {
                     String var4 = var0.nextString();
                     configRecord2 var5 = var1.computeIfAbsent(var4, configSupport13::v6);
                     if (var5 != null) {
                        var2.put(var3, var5);
                     }
                  } else {
                     var0.skipValue();
                  }
               }

               var0.endObject();
            } else {
               var0.skipValue();
            }
         }

         var0.endObject();
         return var2;
      }
   }
}
