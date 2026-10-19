package cc.syky.cloud;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public interface HttpTransport {
   HttpTransport.Part1 v1(HttpTransport.Part2 var1) throws IOException;

   public record Part1(int status, String body) {
      @Override
      public String toString() {
         return "HTTP " + this.status;
      }

      public int v1() {
         return this.status;
      }

      public String v2() {
         return this.body;
      }
   }

   public record Part2(String method, URI uri, Map<String, String> headers, @Nullable String contentType, @Nullable String body) {
      @Override
      public String toString() {
         return this.method + " " + this.uri.getHost() + this.uri.getPath();
      }

      public String v1() {
         return this.method;
      }

      public URI v2() {
         return this.uri;
      }

      public Map<String, String> v3() {
         return this.headers;
      }

      @Nullable
      public String v4() {
         return this.contentType;
      }

      @Nullable
      public String v5() {
         return this.body;
      }
   }
}
