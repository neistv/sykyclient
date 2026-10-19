package cc.syky.ui;

import cc.syky.cloud.HttpTransport;
import cc.syky.cloud.cloudSupport62;
import cc.syky.cloud.cloudSupport65;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map.Entry;

public final class UserAgentSupport implements HttpTransport {
   private static final Duration v1 = Duration.ofSeconds(10L);
   private static final Duration v2 = Duration.ofSeconds(15L);
   private static final Duration v3 = Duration.ofSeconds(20L);
   private static final int v4 = 262144;
   private final HttpClient v5 = HttpClient.newBuilder().connectTimeout(v1).followRedirects(Redirect.NEVER).build();
   private final String v6;

   public UserAgentSupport(String var1) {
      this.v6 = var1;
   }

   @Override
   public HttpTransport.Part1 v1(HttpTransport.Part2 var1) throws IOException {
      Builder var2 = HttpRequest.newBuilder(var1.v2())
         .timeout(v2)
         .header("User-Agent", this.v6)
         .method(var1.v1(), var1.v5() == null ? BodyPublishers.noBody() : BodyPublishers.ofString(var1.v5(), StandardCharsets.UTF_8));
      if (var1.v4() != null) {
         var2.header("Content-Type", var1.v4());
      }

      for (Entry var4 : var1.v3().entrySet()) {
         var2.header((String)var4.getKey(), (String)var4.getValue());
      }

      try {
         HttpResponse var8 = cloudSupport62.v2(this.v5, var2.build(), cloudSupport65.v1(262144), v3);
         return new HttpTransport.Part1(var8.statusCode(), new String((byte[])var8.body(), StandardCharsets.UTF_8));
      } catch (cloudSupport62.Part1 var5) {
         throw new IOException(var1 + " took longer than " + v3.toSeconds() + " s");
      } catch (InterruptedException var6) {
         Thread.currentThread().interrupt();
         throw new IOException(var1 + " was interrupted");
      } catch (IOException var7) {
         throw new IOException(var1 + " failed: " + var7, var7);
      }
   }
}
