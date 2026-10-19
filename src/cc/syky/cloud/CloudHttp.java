package cc.syky.cloud;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.BodySubscribers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import org.jetbrains.annotations.Nullable;

public final class CloudHttp {
   private final HttpClient v1;
   private final CloudHttp.Part4 v2;
   private final Duration v3;

   public CloudHttp(HttpClient var1, CloudHttp.Part4 var2) {
      this(var1, var2, CloudEndpoints.v4);
   }

   public CloudHttp(HttpClient var1, CloudHttp.Part4 var2, Duration var3) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
   }

   public JsonObject v1(String var1, String var2, String var3, @Nullable JsonObject var4, @Nullable String var5) throws CloudHttp.Part2 {
      Builder var6 = this.v1(var1, var3)
         .method(var2, var4 == null ? BodyPublishers.noBody() : BodyPublishers.ofString(var4.toString(), StandardCharsets.UTF_8));
      if (var4 != null) {
         var6.header("Content-Type", "application/json");
      }

      if (var5 != null) {
         var6.header("Authorization", "Bearer " + var5);
      }

      HttpResponse var7 = this.v1(var6.build(), cloudSupport65.v1(262144), this.v3);
      int var8 = var7.statusCode();
      JsonObject var9 = v2(new String((byte[])var7.body(), StandardCharsets.UTF_8));
      if (var8 >= 200 && var8 < 300) {
         if (var8 != 204 && var9 == null) {
            throw new CloudHttp.Part2(var8, "bad_answer", "the server answered with something that is not JSON");
         } else {
            return var9 == null ? new JsonObject() : var9;
         }
      } else {
         JsonObject var10 = var9 != null && var9.has("error") && var9.get("error").isJsonObject() ? var9.getAsJsonObject("error") : null;
         throw new CloudHttp.Part2(
            var8,
            var10 != null ? cloudSupport60.v2(var10, "code") : "http_" + var8,
            var10 != null ? cloudSupport60.v2(var10, "message") : "the server answered " + var8
         );
      }
   }

   public CloudHttp.Part3 v1(String var1, String var2, byte[] var3, String var4) {
      HttpRequest var5 = this.v1(var1, var2)
         .header("Content-Type", "application/json")
         .header("Content-Encoding", "gzip")
         .header("Authorization", "Bearer " + var4)
         .POST(BodyPublishers.ofByteArray(var3))
         .build();

      try {
         HttpResponse var6 = this.v1(var5, cloudSupport65.v1(262144), this.v3);
         return new CloudHttp.Part3(var6.statusCode(), v1(var6.headers().firstValue("Retry-After").orElse("")));
      } catch (CloudHttp.Part2 var7) {
         return new CloudHttp.Part3(var7.v1, 0L);
      }
   }

   public static long v1(String var0) {
      try {
         return Math.max(0L, Long.parseLong(var0.strip()));
      } catch (NumberFormatException var2) {
         return 0L;
      }
   }

   private Builder v1(String var1, String var2) {
      return HttpRequest.newBuilder(CloudEndpoints.v1(var1, var2))
         .timeout(CloudEndpoints.v3)
         .header("Accept", "application/json")
         .header("User-Agent", "syky/" + this.v2.v1())
         .header("X-Syky-Client", this.v2.v1())
         .header("X-Syky-MC", this.v2.v2())
         .header("X-Syky-OS", this.v2.v3())
         .header("X-Syky-HW", this.v2.v4())
         .header("X-Syky-Auth", this.v2.v5());
   }

   public byte[] v1(String var1, String var2, int var3) throws CloudHttp.Part2 {
      HttpRequest var4 = HttpRequest.newBuilder(CloudEndpoints.v1(var1, var2))
         .timeout(CloudEndpoints.v3)
         .header("User-Agent", "syky/" + this.v2.v1())
         .GET()
         .build();
      Duration var5 = this.v3.plusMillis(var3 * 1000L / 65536L);
      HttpResponse var6 = this.v1(
         var4, var1x -> (BodySubscriber<byte[]>)(var1x.statusCode() == 200 ? new cloudSupport65(var3, 200) : BodySubscribers.replacing(new byte[0])), var5
      );
      if (var6.statusCode() != 200) {
         throw new CloudHttp.Part2(var6.statusCode(), "http_" + var6.statusCode(), "the server answered " + var6.statusCode());
      } else {
         return (byte[])var6.body();
      }
   }

   public CloudHttp.Part1 v1(String var1, String var2, String var3, int var4) throws CloudHttp.Part2 {
      HttpRequest var5 = HttpRequest.newBuilder(CloudEndpoints.v1(var1, var2))
         .timeout(CloudEndpoints.v3)
         .header("Accept", "application/json")
         .header("User-Agent", "syky/" + this.v2.v1())
         .header("If-None-Match", var3)
         .GET()
         .build();
      HttpResponse var6 = this.v1(
         var5, var1x -> (BodySubscriber<byte[]>)(var1x.statusCode() == 200 ? new cloudSupport65(var4, 200) : BodySubscribers.replacing(new byte[0])), this.v3
      );
      int var7 = var6.statusCode();
      if (var7 == 200) {
         return new CloudHttp.Part1(200, new String((byte[])var6.body(), StandardCharsets.UTF_8));
      } else if (var7 == 304) {
         return new CloudHttp.Part1(304, "");
      } else {
         throw new CloudHttp.Part2(var7, "http_" + var7, "the server answered " + var7);
      }
   }

   private HttpResponse<byte[]> v1(HttpRequest var1, BodyHandler<byte[]> var2, Duration var3) throws CloudHttp.Part2 {
      try {
         return cloudSupport62.v2(this.v1, var1, var2, var3);
      } catch (cloudSupport62.Part1 var5) {
         throw new CloudHttp.Part2(0, "timeout", "the syky server took too long to answer");
      } catch (InterruptedException var6) {
         Thread.currentThread().interrupt();
         throw new CloudHttp.Part2(0, "interrupted", "interrupted");
      } catch (cloudSupport65.Part1 var7) {
         throw new CloudHttp.Part2(var7.v1, "too_large", "the server answered with an oversized body");
      } catch (IOException var8) {
         throw new CloudHttp.Part2(0, "unreachable", "the syky server could not be reached");
      }
   }

   @Nullable
   private static JsonObject v2(String var0) {
      if (var0.isBlank()) {
         return null;
      } else {
         try {
            JsonElement var1 = JsonParser.parseString(var0);
            return var1.isJsonObject() ? var1.getAsJsonObject() : null;
         } catch (JsonParseException var2) {
            return null;
         }
      }
   }

   public record Part1(int status, String body) {
      public int v1() {
         return this.status;
      }

      public String v2() {
         return this.body;
      }
   }

   public static final class Part2 extends Exception {
      private static final long v3 = 1L;
      public final int v1;
      public final String v2;

      public Part2(int var1, String var2, String var3) {
         super(var3);
         this.v1 = var1;
         this.v2 = var2;
      }

      public boolean v1() {
         return this.v1 == 0 || this.v1 >= 500 || this.v1 == 429;
      }
   }

   public record Part3(int status, long retryAfterSeconds) {
      public int v1() {
         return this.status;
      }

      public long v2() {
         return this.retryAfterSeconds;
      }
   }

   public record Part4(String client, String mc, String os, String hw, String auth) {
      public Part4(String var1, String var2, String var3) {
         this(var1, var2, var3, "", "");
      }

      public String v1() {
         return this.client;
      }

      public String v2() {
         return this.mc;
      }

      public String v3() {
         return this.os;
      }

      public String v4() {
         return this.hw;
      }

      public String v5() {
         return this.auth;
      }
   }
}
