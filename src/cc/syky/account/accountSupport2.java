package cc.syky.account;

import cc.syky.cloud.cloudSupport62;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import net.minecraft.class_1011;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class accountSupport2 implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.music.art");
   private static final int v2 = 20;
   private static final Duration v3 = Duration.ofSeconds(5L);
   private static final Duration v4 = Duration.ofSeconds(15L);
   private static final long v5 = 5000000000L;
   private static final long v6 = 300000000000L;
   private final HttpClient v7;
   private final ExecutorService v8;
   private final Map<String, class_2960> v9;
   private final Map<String, Boolean> v10;
   private final Map<String, long[]> v11 = new ConcurrentHashMap<>();
   private final Supplier<class_2960> v12;
   private final Set<String> v13;

   public accountSupport2(Supplier<class_2960> var1) {
      this.v12 = var1;
      this.v7 = HttpClient.newBuilder().connectTimeout(v3).build();
      this.v8 = Executors.newSingleThreadExecutor(var0 -> {
         Thread var1x = new Thread(var0, "syky-art-lookup");
         var1x.setDaemon(true);
         return var1x;
      });
      this.v9 = new LinkedHashMap<>(32, 0.75F, false);
      this.v10 = new ConcurrentHashMap<>();
      this.v13 = ConcurrentHashMap.newKeySet();
   }

   @Nullable
   public synchronized class_2960 v1(String var1, String var2) {
      if (var1 != null && !var1.isEmpty()) {
         String var3 = v2(var1, var2);
         class_2960 var4 = this.v9.get(var3);
         if (var4 != null) {
            return var4;
         } else if (this.v13.contains(var3)) {
            return null;
         } else {
            long[] var5 = this.v11.get(var3);
            if (var5 != null && System.nanoTime() < var5[0]) {
               return null;
            } else {
               if (this.v10.putIfAbsent(var3, Boolean.TRUE) == null) {
                  this.v8.submit(() -> this.v1(var3, var1, var2));
               }

               return null;
            }
         }
      } else {
         return null;
      }
   }

   private void v1(String var1) {
      long[] var2 = this.v11.get(var1);
      int var3 = var2 == null ? 0 : (int)Math.min(var2[1], 6L);
      long var4 = Math.min(5000000000L << var3, 300000000000L);
      this.v11.put(var1, new long[]{System.nanoTime() + var4, var3 + 1L});
   }

   private static String v2(String var0, String var1) {
      return (var0 == null ? "" : var0) + "||" + (var1 == null ? "" : var1);
   }

   private void v1(String var1, String var2, String var3) {
      try {
         String var4 = URLEncoder.encode(var2 + " " + var3, StandardCharsets.UTF_8);
         URI var5 = URI.create("https://itunes.apple.com/search?term=" + var4 + "&media=music&limit=1");
         HttpResponse var6 = cloudSupport62.v2(this.v7, HttpRequest.newBuilder(var5).timeout(v3).GET().build(), BodyHandlers.ofString(), v4);
         if (var6.statusCode() != 200) {
            v1.debug("artwork: iTunes search HTTP {}", var6.statusCode());
            this.v1(var1);
            return;
         }

         JsonObject var7 = JsonParser.parseString((String)var6.body()).getAsJsonObject();
         JsonArray var8 = var7.getAsJsonArray("results");
         if (var8 == null || var8.size() == 0) {
            v1.info("artwork: no iTunes match for '{}' / '{}'", var2, var3);
            this.v13.add(var1);
            return;
         }

         JsonObject var9 = var8.get(0).getAsJsonObject();
         if (!var9.has("artworkUrl100")) {
            this.v13.add(var1);
            return;
         }

         String var10 = var9.get("artworkUrl100").getAsString().replace("100x100bb", "300x300bb");
         HttpResponse var11 = cloudSupport62.v2(this.v7, HttpRequest.newBuilder(URI.create(var10)).timeout(v3).GET().build(), BodyHandlers.ofByteArray(), v4);
         byte[] var12 = (byte[])var11.body();
         if (var12 != null && var12.length >= 256) {
            class_2960 var13 = this.v1(var12, var1.hashCode());
            if (var13 != null) {
               class_2960 var14;
               synchronized (this) {
                  var14 = this.v1();
                  this.v9.put(var1, var13);
                  this.v11.remove(var1);
               }

               v1(var14);
               v1.info("artwork: iTunes hit for '{}' / '{}', {} bytes", new Object[]{var2, var3, var12.length});
            }

            return;
         }

         v1.debug("artwork: iTunes image too small ({} bytes) for '{}'", var12 == null ? 0 : var12.length, var2);
         this.v13.add(var1);
      } catch (Exception var22) {
         this.v1(var1);
         v1.info("artwork: iTunes lookup error for '{}' / '{}': {}", new Object[]{var2, var3, var22.toString()});
         return;
      } finally {
         this.v10.remove(var1);
      }
   }

   @Nullable
   private class_2960 v1() {
      if (this.v9.size() < 20) {
         return null;
      } else {
         class_2960 var1 = this.v12.get();

         for (Entry var3 : this.v9.entrySet()) {
            if (!((class_2960)var3.getValue()).equals(var1)) {
               this.v9.remove(var3.getKey());
               return (class_2960)var3.getValue();
            }
         }

         return null;
      }
   }

   private static void v1(@Nullable class_2960 var0) {
      if (var0 != null) {
         class_310 var1 = class_310.method_1551();
         if (var1 != null) {
            var1.execute(() -> {
               try {
                  accountSupport3.v1(var0);
               } catch (Throwable var2) {
                  v1.debug("artwork: texture destroy failed", var2);
               }
            });
         }
      }
   }

   @Nullable
   private class_2960 v1(byte[] var1, int var2) {
      class_310 var3 = class_310.method_1551();
      if (var3 == null) {
         return null;
      } else {
         List var4;
         try {
            var4 = accountSupport3.v1(class_1011.method_4309(new ByteArrayInputStream(var1)));
         } catch (Exception var7) {
            v1.debug("artwork: NativeImage decode failed", var7);
            return null;
         }

         String var5 = Integer.toHexString(var2);
         class_2960 var6 = class_2960.method_60655("syky", "music_art_itunes/" + var5);
         var3.execute(() -> {
            try {
               accountSupport3.v1(var6, var4, "music_art_itunes_" + var5);
            } catch (Throwable var4x) {
               v1.debug("artwork: texture register failed", var4x);
            }
         });
         return var6;
      }
   }

   @Override
   public void close() {
      this.v8.shutdownNow();
      ArrayList var1;
      synchronized (this) {
         var1 = new ArrayList<>(this.v9.values());
         this.v9.clear();
         this.v11.clear();
      }

      for (class_2960 var3 : var1) {
         v1(var3);
      }

      this.v7.close();
   }
}
