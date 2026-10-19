package cc.syky.ui;

import cc.syky.cloud.cloudSupport60;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_156;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DiscordPTBSupport {
   private static final Logger v1 = LoggerFactory.getLogger("syky.discord");
   private static final int v2 = 6463;
   private static final int v3 = 6472;
   private static final String v4 = "https://discord.com";
   private static final Duration v5 = Duration.ofMillis(500L);
   private static final long v6 = 3000L;
   private static final long v7 = 45000L;
   private static final long v8 = 1000L;
   private static final long v9 = 2000L;
   private static final AtomicBoolean v10 = new AtomicBoolean();

   private DiscordPTBSupport() {
   }

   public static void v1() {
      if (v10.compareAndSet(false, true)) {
         Thread var0 = new Thread(() -> {
            try {
               v3("https://discord.gg/Gz3rZfQJvv");
            } catch (RuntimeException var4) {
               v1.warn("could not hand the invite to Discord; opening it in the browser", var4);
               class_156.method_668().method_670("https://discord.gg/Gz3rZfQJvv");
            } finally {
               v10.set(false);
            }
         }, "syky-discord-invite");
         var0.setDaemon(true);
         var0.start();
      }
   }

   private static void v3(String var0) {
      String var1 = v1(var0);
      if (v4(var1)) {
         DiscordCanarySupport.v1();
      } else {
         if (v2()) {
            class_156.method_668().method_670("discord://");
            long var2 = System.currentTimeMillis() + 45000L;

            while (System.currentTimeMillis() < var2) {
               try {
                  Thread.sleep(1000L);
               } catch (InterruptedException var5) {
                  Thread.currentThread().interrupt();
                  return;
               }

               if (v4(var1)) {
                  DiscordCanarySupport.v1();
                  return;
               }
            }

            v1.info("Discord did not answer within {} s of starting; opening the invite in the browser", 45L);
         }

         class_156.method_668().method_670(var0);
      }
   }

   public static String v1(String var0) {
      String var1 = var0.endsWith("/") ? var0.substring(0, var0.length() - 1) : var0;
      return var1.substring(var1.lastIndexOf(47) + 1);
   }

   private static boolean v4(String var0) {
      try (HttpClient var1 = HttpClient.newBuilder().connectTimeout(v5).build()) {
         for (int var2 = 6463; var2 <= 6472; var2++) {
            if (v1(var1, var2, var0)) {
               return true;
            }
         }
      }

      return false;
   }

   private static boolean v1(HttpClient var0, int var1, String var2) {
      LinkedBlockingQueue var3 = new LinkedBlockingQueue();

      WebSocket var4;
      try {
         var4 = var0.newWebSocketBuilder()
            .header("Origin", "https://discord.com")
            .connectTimeout(v5)
            .buildAsync(URI.create("ws://127.0.0.1:" + var1 + "/?v=1"), new DiscordPTBSupport.Part1(var3))
            .get(v5.toMillis() * 2L, TimeUnit.MILLISECONDS);
      } catch (InterruptedException var21) {
         Thread.currentThread().interrupt();
         return false;
      } catch (Exception var22) {
         return false;
      }

      boolean var12;
      try {
         JsonObject var5 = v1(var3);
         if (var5 == null || !"READY".equals(cloudSupport60.v1(var5, "evt"))) {
            return false;
         }

         String var26 = UUID.randomUUID().toString();
         JsonObject var7 = new JsonObject();
         var7.addProperty("code", var2);
         JsonObject var8 = new JsonObject();
         var8.addProperty("cmd", "INVITE_BROWSER");
         var8.add("args", var7);
         var8.addProperty("nonce", var26);

         try {
            var4.sendText(var8.toString(), true).get(3000L, TimeUnit.MILLISECONDS);
         } catch (TimeoutException | ExecutionException var23) {
            return false;
         }

         long var9 = System.currentTimeMillis() + 3000L;

         JsonObject var11;
         do {
            if (System.currentTimeMillis() >= var9) {
               return false;
            }

            var11 = v1(var3);
            if (var11 == null) {
               return false;
            }
         } while (!var26.equals(cloudSupport60.v1(var11, "nonce")));

         if (!"ERROR".equals(cloudSupport60.v1(var11, "evt"))) {
            return true;
         }

         v1.info("Discord on port {} refused the invite: {}", var1, var11.get("data"));
         var12 = false;
      } catch (InterruptedException var24) {
         Thread.currentThread().interrupt();
         return false;
      } finally {
         CompletableFuture var15 = var4.sendClose(1000, "").whenComplete((var1x, var2x) -> var4.abort());
      }

      return var12;
   }

   @Nullable
   private static JsonObject v1(BlockingQueue<String> var0) throws InterruptedException {
      String var1 = (String)var0.poll(3000L, TimeUnit.MILLISECONDS);
      if (var1 == null) {
         return null;
      } else {
         try {
            JsonElement var2 = JsonParser.parseString(var1);
            return var2.isJsonObject() ? var2.getAsJsonObject() : null;
         } catch (RuntimeException var3) {
            return null;
         }
      }
   }

   private static boolean v2() {
      return switch (class_156.method_668()) {
         case field_1133 -> v3();
         case field_1137 -> v4();
         case field_1135 -> {
            String var0 = v1(List.of("xdg-mime", "query", "default", "x-scheme-handler/discord"));
            yield var0 != null && !var0.isBlank();
         }
         default -> false;
      };
   }

   private static boolean v3() {
      String var0 = v1(List.of("reg", "query", "HKCR\\discord\\shell\\open\\command", "/ve"));
      if (var0 == null) {
         return false;
      } else {
         String var1 = v2(var0);
         return var1 == null ? false : !StandardCharsets.US_ASCII.newEncoder().canEncode(var1) || Files.isRegularFile(Path.of(var1));
      }
   }

   @Nullable
   public static String v2(String var0) {
      int var1 = var0.indexOf("REG_SZ");
      if (var1 < 0) {
         return null;
      } else {
         String var2 = var0.substring(var1 + "REG_SZ".length()).strip();
         if (var2.startsWith("\"")) {
            int var6 = var2.indexOf(34, 1);
            return var6 > 1 ? var2.substring(1, var6) : null;
         } else {
            String var3 = var2.lines().findFirst().orElse("");
            int var4 = var3.indexOf(32);
            var3 = var4 < 0 ? var3 : var3.substring(0, var4);
            return var3.isBlank() ? null : var3;
         }
      }
   }

   private static boolean v4() {
      String var0 = System.getProperty("user.home", "");

      for (String var2 : List.of("Discord.app", "Discord PTB.app", "Discord Canary.app")) {
         if (Files.isDirectory(Path.of("/Applications", var2)) || Files.isDirectory(Path.of(var0, "Applications", var2))) {
            return true;
         }
      }

      return false;
   }

   @Nullable
   private static String v1(List<String> var0) {
      try {
         Process var1 = new ProcessBuilder(var0).redirectErrorStream(true).start();
         var1.getOutputStream().close();
         if (!var1.waitFor(2000L, TimeUnit.MILLISECONDS)) {
            var1.destroyForcibly();
            return null;
         } else if (var1.exitValue() != 0) {
            return null;
         } else {
            String var3;
            try (InputStream var2 = var1.getInputStream()) {
               var3 = new String(var2.readAllBytes(), StandardCharsets.ISO_8859_1);
            }

            return var3;
         }
      } catch (IOException var7) {
         return null;
      } catch (InterruptedException var8) {
         Thread.currentThread().interrupt();
         return null;
      }
   }

   public static final class Part1 implements Listener {
      private final BlockingQueue<String> v1;
      private final StringBuilder v2 = new StringBuilder();

      public Part1(BlockingQueue<String> var1) {
         this.v1 = var1;
      }

      @Nullable
      @Override
      public CompletionStage<?> onText(WebSocket var1, CharSequence var2, boolean var3) {
         this.v2.append(var2);
         if (var3) {
            this.v1.add(this.v2.toString());
            this.v2.setLength(0);
         }

         var1.request(1L);
         return null;
      }
   }
}
