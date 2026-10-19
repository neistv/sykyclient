package cc.syky;

import cc.syky.cloud.cloudSupport60;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record sykyRecord6(List<String> manifestUrls, Map<String, sykyRecord6.Part1> releases) {
   private static final Logger LOG = LoggerFactory.getLogger("syky.update.manifest");

   @Nullable
   public static sykyRecord6 v1(String var0) {
      try {
         JsonElement var1 = JsonParser.parseString(var0);
         if (var1 != null && var1.isJsonObject()) {
            JsonObject var2 = var1.getAsJsonObject();
            Map var3 = v1(var2.getAsJsonObject("releases"));
            return var3 == null ? null : new sykyRecord6(cloudSupport60.v1(var2, "manifests", sykyRecord6::v3), var3);
         } else {
            return null;
         }
      } catch (RuntimeException var4) {
         LOG.debug("manifest body did not parse", var4);
         return null;
      }
   }

   public Optional<sykyRecord6.Part1> v2(String var1) {
      return Optional.ofNullable(this.releases.get(var1));
   }

   @Nullable
   private static Map<String, sykyRecord6.Part1> v1(@Nullable JsonObject var0) {
      if (var0 == null) {
         return null;
      } else {
         HashMap var1 = new HashMap();

         for (Entry var3 : var0.entrySet()) {
            if (((JsonElement)var3.getValue()).isJsonObject()) {
               sykyRecord6.Part1 var4 = v2(((JsonElement)var3.getValue()).getAsJsonObject());
               if (var4 != null) {
                  var1.put((String)var3.getKey(), var4);
               }
            }
         }

         return var1;
      }
   }

   @Nullable
   private static sykyRecord6.Part1 v2(JsonObject var0) {
      String var1 = cloudSupport60.v1(var0, "version");
      String var2 = cloudSupport60.v1(var0, "sha256");
      List var3 = cloudSupport60.v1(var0, "urls", sykyRecord6::v3);
      if (var1 == null || var2 == null || var3.isEmpty()) {
         return null;
      } else if (!var2.matches("[0-9a-fA-F]{64}")) {
         LOG.warn("release {} carries a malformed sha256 and is ignored", var1);
         return null;
      } else {
         long var4 = cloudSupport60.v3(var0, "size");
         int var6 = (int)cloudSupport60.v3(var0, "minJava");
         return new sykyRecord6.Part1(var1, var2.toLowerCase(Locale.ROOT), var4, cloudSupport60.v1(var0, "minLoader"), var6, var3);
      }
   }

   private static boolean v3(String var0) {
      return var0.startsWith("https://");
   }

   public List<String> v1() {
      return this.manifestUrls;
   }

   public Map<String, sykyRecord6.Part1> v2() {
      return this.releases;
   }

   public record Part1(String version, String sha256, long size, @Nullable String minLoader, int minJava, List<String> urls) {
      public String v1() {
         return this.version;
      }

      public String v2() {
         return this.sha256;
      }

      public long v3() {
         return this.size;
      }

      @Nullable
      public String v4() {
         return this.minLoader;
      }

      public int v5() {
         return this.minJava;
      }

      public List<String> v6() {
         return this.urls;
      }
   }
}
