package cc.syky.cloud;

import cc.syky.crash.CrashUploader;
import cc.syky.internal.InternalSupport60;
import cc.syky.serverrules.ServerRulesStore;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocketHandshakeException;
import java.net.http.HttpClient.Redirect;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.random.RandomGenerator;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CloudClient implements AutoCloseable {
   private static final Logger v2 = LoggerFactory.getLogger("syky.cloud");
   private static final String v3 = "syky-";
   private final Path v4;
   private final cloudSupport89 v5;
   private final CloudConfig v6;
   public final ScheduledExecutorService v7;
   private final ExecutorService v8;
   private final ExecutorService v9;
   @Nullable
   private HttpClient v10;
   @Nullable
   private CloudHttp v11;
   @Nullable
   private WebSocket v12;
   private int v13;
   private CompletableFuture<WebSocket> v14 = CompletableFuture.failedFuture(new IOException("not connected"));
   private boolean v15;
   private boolean v16;
   private int v18;
   private static final String v19 = "unofficial_client";
   private long v17;
   @Nullable
   private ScheduledFuture<?> v20;
   @Nullable
   private ScheduledFuture<?> v21;
   @Nullable
   private ScheduledFuture<?> v22;
   @Nullable
   private ScheduledFuture<?> v24;
   @Nullable
   private volatile ServerRulesStore v25;
   private long v26;
   @Nullable
   private ScheduledFuture<?> v27;
   @Nullable
   private CrashUploader.Part2 v28;
   private final CrashUploader v29 = new CrashUploader();
   private int v30;
   private final Map<Integer, Consumer<cloudSupport84.Part1>> v32 = new HashMap<>();
   private PresenceSnapshot v23 = PresenceSnapshot.NOWHERE;
   @Nullable
   private cloudSupport89.Part2 v33;
   private boolean v31;
   private long v34 = -1L;
   private boolean v36;
   @Nullable
   private SykyLinkLogin v38;
   @Nullable
   private String v42;
   private volatile boolean v43;
   private List<String> v37 = List.of();
   private volatile boolean v48;
   private volatile boolean v40;
   private volatile boolean v44;
   private volatile boolean v47;
   private volatile boolean v49;
   private volatile String v46;
   private final String v51;
   private volatile String v50 = "not in a world";
   private volatile String v60 = "";
   private final List<BiConsumer<String, JsonObject>> v59 = new CopyOnWriteArrayList<>();
   @Nullable
   private volatile InternalSupport60 v53;
   private final GETSupport2 v63;
   private final GETSupport v64;
   private final cloudSupport88 v61;
   private final cloudSupport87 v66 = new cloudSupport87();
   private final cloudSupport89.Part1 v68 = this.v66::v2;
   private final cloudSupport87.Part1 v52 = new cloudSupport87.Part1();
   private volatile long v75;
   private volatile long v73;
   private volatile boolean v74;
   public static final String v1 = "gateway_ready";
   private static final Pattern v72 = Pattern.compile("[0-9a-f]{64}");
   private static final Pattern v80 = Pattern.compile("[a-z][a-z0-9_-]{1,63}");

   public CloudClient(Path var1, final cloudSupport89 var2) {
      this.v4 = var1;
      this.v5 = var2;
      this.v6 = CloudConfig.v1(var1);
      this.v40 = this.v6.v1;
      this.v44 = !this.v6.v2;
      this.v47 = !this.v6.v3;
      this.v46 = this.v6.v1();
      this.v51 = CloudEndpoints.v1(this.v46);
      SykySession.v1(this.v6.v4());
      this.v7 = Executors.newSingleThreadScheduledExecutor(var0 -> v1(var0, "syky-cloud"));
      this.v8 = Executors.newFixedThreadPool(2, var0 -> v1(var0, "syky-cloud-net"));
      this.v9 = Executors.newFixedThreadPool(2, var0 -> v1(var0, "syky-cloud-assets"));
      this.v63 = new GETSupport2(this::v1);
      this.v59.add(this.v63::v1);
      this.v64 = new GETSupport(new GETSupport.Part8() {
         @Override
         public void v1(String var1, String var2x, @Nullable JsonObject var3, Consumer<JsonObject> var4, Consumer<GETSupport.Part12> var5) {
            CloudClient.this.v2(var1, var2x, var3, var4, var5);
         }

         @Override
         public void v1(long var1, Runnable var3) {
            CloudClient.this.v1((Runnable)(() -> {
               ScheduledFuture var5 = CloudClient.this.v7.schedule(() -> var2.v1(var3), var1, TimeUnit.MILLISECONDS);
            }));
         }
      });
      this.v59.add(this.v64::v1);
      this.v61 = cloudSupport88.v1(var1.resolveSibling("recently_met.json"), this::v1);
   }

   public cloudSupport88 v1() {
      return this.v61;
   }

   public void v2() {
      String var1 = this.v5.v1();
      long var2 = System.currentTimeMillis();
      boolean var4 = var2 < this.v73;
      if (cloudSupport90.v1 && !var1.isEmpty() && var2 >= this.v75 && (var4 || !this.v74)) {
         this.v75 = var2 + (var4 ? 0L : 10000L);
         this.v66.v1();
         long[] var5 = this.v66.v1(this.v5.v1(this.v68));
         if (var5.length > 0) {
            this.v1((Runnable)(() -> this.v1(var5)));
         }
      }

      SykySession.Part1 var6 = SykySession.v1();
      if (var6 != null) {
         this.v5.v1((var5x, var6x, var7, var8) -> {
            cloudSupport90.v1(var5x, var6x);
            cloudSupport90.Part2 var9 = cloudSupport90.v1(var5x);
            if (var9 != null && var9.v1() != var6.v1()) {
               this.v61.v1(new cloudSupport88.Part1(var9.v1(), var9.v2(), var6x, var5x, var1, var7, var8, var2, var2));
            }
         });
         this.v5.v2((var5x, var6x, var7, var8) -> {
            cloudSupport90.Part2 var9 = cloudSupport90.v1(var5x);
            if (var9 != null && var9.v1() != var6.v1()) {
               this.v61.v1(new cloudSupport88.Part1(var9.v1(), var9.v2(), var6x, var5x, var1, var7, var8, var2, 0L));
            }
         });
         this.v61.v4(var2);
      }
   }

   public GETSupport2 v3() {
      return this.v63;
   }

   public GETSupport v4() {
      return this.v64;
   }

   private static Thread v1(Runnable var0, String var1) {
      Thread var2 = new Thread(var0, var1);
      var2.setDaemon(true);
      return var2;
   }

   public void v5() {
      this.v1((Runnable)(() -> {
         this.v26();
         this.v24 = this.v7.scheduleWithFixedDelay(() -> v2(this::v24), 0L, 1800000L, TimeUnit.MILLISECONDS);
         this.v21 = this.v7.scheduleWithFixedDelay(() -> v2(this::v32), 500L, 500L, TimeUnit.MILLISECONDS);
      }));
   }

   public boolean v6() {
      return this.v40;
   }

   public boolean v7() {
      return this.v44;
   }

   public boolean v8() {
      return this.v49;
   }

   public String v9() {
      return this.v46;
   }

   public String v10() {
      return this.v50;
   }

   public void v1(BiConsumer<String, JsonObject> var1) {
      this.v59.add(var1);
   }

   public void v1(String var1, int var2, Consumer<byte[]> var3) {
      this.v1((Runnable)(() -> {
         CloudHttp var4 = this.v22();
         String var5 = this.v46;
         this.v9.execute(() -> {
            byte[] var5x = null;

            try {
               var5x = var4.v1(var5, var1, var2);
            } catch (CloudHttp.Part2 var7) {
               if (var7.v1 != 404) {
                  v2.debug("could not fetch {}: {}", var1, var7.getMessage());
               }
            } catch (RuntimeException var8) {
               v2.debug("could not fetch {}", var1, var8);
            }

            var3.accept(var5x);
         });
      }));
   }

   public void v1(InternalSupport60 var1) {
      this.v53 = var1;
      var1.v1(cloudSupport90::v1);
   }

   public InternalSupport60.Part6 v1(Path var1) {
      return (var2, var3) -> {
         int var4 = var2.indexOf(64);
         String var5 = var4 < 0 ? "" : var2.substring(var4 + 1);
         if (!v72.matcher(var5).matches()) {
            var3.v1("not a server cosmetic: " + var2);
         } else {
            this.v1((Runnable)(() -> {
               CloudHttp var4x = this.v22();
               String var5x = this.v46;
               this.v9.execute(() -> v1(var4x, var5x, var1, var5, var3));
            }));
         }
      };
   }

   public static void v1(CloudHttp var0, String var1, Path var2, String var3, InternalSupport60.Part4 var4) {
      Path var5 = var2.resolve(var3 + ".sykc");

      try {
         byte[] var6 = null;
         if (Files.isRegularFile(var5)) {
            byte[] var7 = Files.readAllBytes(var5);
            if (PNGNotSupport.v2(var7).equals(var3)) {
               var6 = var7;
            } else {
               Files.deleteIfExists(var5);
            }
         }

         if (var6 == null) {
            var6 = var0.v1(var1, "/v1/cosmetics/assets/" + var3, 8388608);
            if (!PNGNotSupport.v2(var6).equals(var3)) {
               var4.v1("the server's asset does not match its hash");
               return;
            }

            Files.createDirectories(var2);
            Path var11 = Files.createTempFile(var2, var3, ".part");
            Files.write(var11, var6);
            Files.move(var11, var5, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
         }

         var4.v1(PNGNotSupport.v1(var6));
      } catch (PNGNotSupport.Part1 var8) {
         var4.v1("made for a newer syky");
      } catch (CloudHttp.Part2 var9) {
         var4.v1(var9.getMessage() == null ? var9.v2 : var9.getMessage());
      } catch (RuntimeException | IOException var10) {
         var4.v1(String.valueOf(var10.getMessage()));
      }
   }

   public void v1(PresenceSnapshot var1, @Nullable cloudSupport89.Part2 var2) {
      cloudSupport90.v4(var1.v4());
      this.v30();
      this.v1((Runnable)(() -> {
         this.v23 = var1;
         this.v60 = "";
         this.v33 = var2;
         this.v31 = false;
         this.v52.v1();
         this.v74 = false;
         cloudSupport90.v2();
         InternalSupport60 var3 = this.v53;
         if (var3 != null) {
            var3.v1();
         }

         this.v17();
         this.v29();
      }));
   }

   private void v17() {
      InternalSupport60 var1 = this.v53;
      UUID var2 = this.v23.v4();
      if (var1 != null && var2 != null) {
         var1.v1(var2, this.v37);
      }
   }

   public void v1(long var1) {
      this.v30();
      this.v1((Runnable)(() -> {
         if (this.v23.v1() && this.v23.v6() != var1) {
            this.v23 = this.v23.v1(var1);
            cloudSupport90.v1();
            this.v29();
         }
      }));
   }

   public String v11() {
      return this.v60;
   }

   public void v1(ServerRulesStore var1) {
      this.v25 = var1;
   }

   public void v12() {
      this.v1((Runnable)(() -> {
         if (System.currentTimeMillis() - this.v26 >= 600000L) {
            this.v24();
         }
      }));
   }

   public void v13() {
      this.v1(PresenceSnapshot.NOWHERE, null);
   }

   public void v1(boolean var1) {
      this.v40 = var1;
      this.v1((Runnable)(() -> {
         this.v6.v1(this.v4, var1xx -> var1xx.v1 = var1);
         if (var1) {
            this.v18 = 0;
            this.v26();
            this.v24();
         } else {
            this.v1(1000, "online features off");
         }
      }));
   }

   public void v2(boolean var1) {
      this.v44 = var1;
      this.v1((Runnable)(() -> this.v6.v1(this.v4, var1xx -> var1xx.v2 = !var1)));
   }

   public boolean v14() {
      return this.v47;
   }

   public void v3(boolean var1) {
      this.v47 = var1;
      this.v1((Runnable)(() -> {
         this.v6.v1(this.v4, var1xx -> var1xx.v3 = !var1);
         this.v25();
      }));
   }

   public void v1(CrashUploader.Part2 var1) {
      var1.v1(() -> this.v1(this::v25));
      this.v1((Runnable)(() -> {
         this.v28 = var1;
         this.v22 = this.v7.scheduleWithFixedDelay(() -> v2(this::v25), 20000L, 300000L, TimeUnit.MILLISECONDS);
      }));
   }

   public void v1(cloudSupport85.Part2 var1) {
      if (this.v44 && (!var1.v1().isEmpty() || !var1.v2().isEmpty() || !var1.v3().isEmpty())) {
         Map var2 = Map.copyOf(var1.v1());
         Map var3 = Map.copyOf(var1.v2());
         List var4 = var1.v3().stream().sorted().limit(128L).toList();
         this.v1((Runnable)(() -> {
            JsonObject var4x = new JsonObject();
            var2.forEach(var4x::addProperty);
            JsonObject var5 = new JsonObject();
            var5.add("modules", var4x);
            if (!var3.isEmpty()) {
               JsonObject var6 = new JsonObject();
               var3.forEach(var6::addProperty);
               var5.add("activations", var6);
            }

            if (!var4.isEmpty()) {
               JsonArray var7 = new JsonArray();
               var4.forEach(var7::add);
               var5.add("bound", var7);
            }

            this.v1("usage", var5, null);
            this.v20();
         }));
      }
   }

   private void v20() {
      long var1 = Math.floorDiv(System.currentTimeMillis(), TimeUnit.DAYS.toMillis(1L));
      if (this.v44 && !this.v36 && this.v34 != var1) {
         List var3;
         try {
            var3 = v1(this.v5.v2());
         } catch (RuntimeException var6) {
            v2.debug("could not list the installed mods", var6);
            this.v34 = var1;
            return;
         }

         JsonArray var4 = new JsonArray(var3.size());
         var3.forEach(var4::add);
         JsonObject var5 = new JsonObject();
         var5.add("mods", var4);
         this.v36 = true;
         this.v1("mods", var5, var3x -> {
            this.v36 = false;
            if (var3x != null) {
               this.v34 = var1;
            }
         });
      }
   }

   public static List<String> v1(List<String> var0) {
      TreeSet var1 = new TreeSet();

      for (String var3 : var0) {
         if (v80.matcher(var3).matches()) {
            var1.add(var3);
         }
      }

      return var1.stream().limit(384L).toList();
   }

   public void v15() {
      this.v1((Runnable)(() -> this.v5(false)));
   }

   public void v16() {
      this.v1((Runnable)(() -> this.v5(true)));
   }

   public boolean v18() {
      return this.v43;
   }

   public void v1(String var1) {
      if (var1.startsWith("/") && !var1.startsWith("//")) {
         this.v5.v1(URI.create(this.v51 + var1));
      }
   }

   public void v19() {
      this.v1(this::v23);
   }

   public void v1(String var1, String var2, @Nullable JsonObject var3, Consumer<JsonObject> var4, Consumer<String> var5) {
      this.v2(var1, var2, var3, var4, var1x -> var5.accept(var1x.v4()));
   }

   public void v2(String var1, String var2, @Nullable JsonObject var3, Consumer<JsonObject> var4, Consumer<GETSupport.Part12> var5) {
      this.v1((Runnable)(() -> {
         String var6 = this.v6.v3();
         if (var6 == null) {
            var6 = this.v27();
         }

         if (var6 == null) {
            this.v5.v1(() -> var5.accept(new GETSupport.Part12(0, "unreachable", "The syky server is not reachable.")));
         } else {
            try {
               JsonObject var7 = this.v22().v1(this.v46, var1, var2, var3, var6);
               this.v5.v1(() -> var4.accept(var7));
            } catch (CloudHttp.Part2 var11) {
               String var8 = var11.getMessage();
               String var9 = var8 != null && !var8.isEmpty() ? var8 : var11.v2;
               GETSupport.Part12 var10 = new GETSupport.Part12(var11.v1, var11.v2, var9);
               this.v5.v1(() -> var5.accept(var10));
            }
         }
      }));
   }

   @Override
   public void close() {
      this.v48 = true;
      this.v1((Runnable)(() -> {
         ScheduledFuture var1 = this.v21;
         if (var1 != null) {
            var1.cancel(false);
         }

         ScheduledFuture var2x = this.v22;
         if (var2x != null) {
            var2x.cancel(false);
         }

         ScheduledFuture var3 = this.v24;
         if (var3 != null) {
            var3.cancel(false);
         }

         ScheduledFuture var4 = this.v27;
         if (var4 != null) {
            var4.cancel(false);
         }

         SykyLinkLogin var5 = this.v38;
         if (var5 != null) {
            var5.close();
         }

         this.v1(1000, "client closing");
      }));
      this.v7.shutdown();

      try {
         this.v7.awaitTermination(1L, TimeUnit.SECONDS);
      } catch (InterruptedException var2) {
         Thread.currentThread().interrupt();
      }

      this.v7.shutdownNow();
      this.v8.shutdownNow();
      this.v9.shutdownNow();
      cloudSupport90.v1(false);
   }

   public void v1(Runnable var1) {
      if (!this.v7.isShutdown()) {
         try {
            this.v7.execute(() -> v2(var1));
         } catch (RuntimeException var3) {
            v2.debug("cloud task rejected during shutdown", var3);
         }
      }
   }

   private static void v2(Runnable var0) {
      try {
         var0.run();
      } catch (Throwable var2) {
         v2.error("cloud task failed", var2);
      }
   }

   private HttpClient v21() {
      HttpClient var1 = this.v10;
      if (var1 == null) {
         var1 = HttpClient.newBuilder().connectTimeout(CloudEndpoints.v2).followRedirects(Redirect.NEVER).executor(this.v8).build();
         this.v10 = var1;
      }

      return var1;
   }

   private CloudHttp v22() {
      CloudHttp var1 = this.v11;
      if (var1 == null) {
         var1 = new CloudHttp(this.v21(), this.v5.v3());
         this.v11 = var1;
      }

      return var1;
   }

   private void v24() {
      ServerRulesStore var1 = this.v25;
      if (var1 != null && this.v40 && !this.v48) {
         this.v26 = System.currentTimeMillis();

         try {
            CloudHttp.Part1 var2 = this.v22().v1(this.v46, "/v1/server-rules", var1.v2(), 524288);
            if (var2.v1() == 200) {
               var1.v2(var2.v2());
            }
         } catch (CloudHttp.Part2 var3) {
            v2.debug("server rules not fetched: {}", var3.getMessage());
         }
      }
   }

   private void v25() {
      CrashUploader.Part2 var1 = this.v28;
      if (var1 != null && !this.v48) {
         if (this.v6.v3) {
            var1.v1().forEach(var1::v2);
         } else {
            long var2 = System.currentTimeMillis();
            if (this.v6.v1 && !var1.v1().isEmpty()) {
               if (this.v29.v1(var2)) {
                  String var5 = this.v6.v3();
                  if (var5 == null) {
                     var5 = this.v27();
                  }

                  if (var5 != null) {
                     this.v29.v1(this.v22(), this.v46, var5, var1, var2);
                  }
               } else {
                  ScheduledFuture var4 = this.v27;
                  if (var4 == null || var4.isDone()) {
                     this.v27 = this.v7.schedule(() -> v2(this::v25), this.v29.v2() - var2 + 1L, TimeUnit.MILLISECONDS);
                  }
               }
            }
         }
      }
   }

   public static long v1(int var0, boolean var1, long var2, RandomGenerator var4) {
      long var5;
      if (var1) {
         var5 = 1000L + var4.nextLong(14000L);
      } else {
         long var7 = Math.min(60000L, 1000L << Math.min(var0, 16));
         var5 = var7 + var4.nextLong(var7);
      }

      if (var2 > 0L) {
         var5 = Math.max(var5, var2 + var4.nextLong(Math.max(1L, var2 / 4L)));
      }

      return var5;
   }

   private void v26() {
      if (!this.v48 && this.v6.v1 && this.v12 == null && !this.v15 && this.v20 == null) {
         String var1 = this.v6.v3();
         if (var1 == null) {
            var1 = this.v27();
            if (var1 == null) {
               this.v4(false);
               return;
            }
         }

         this.v15 = true;
         int var2 = ++this.v13;
         CloudHttp.Part4 var3 = this.v5.v3();
         WebSocketListener var4 = new WebSocketListener(this.v7, var2x -> v2(() -> {
            if (var2 == this.v13) {
               this.v4(var2x);
            }
         }), var2x -> v2(() -> {
            if (var2 == this.v13) {
               this.v1(var2x);
            }
         }));
         CompletableFuture var5 = this.v21()
            .newWebSocketBuilder()
            .connectTimeout(CloudEndpoints.v2)
            .header("Authorization", "Bearer " + var1)
            .header("User-Agent", "syky/" + var3.v1())
            .header("X-Syky-Client", var3.v1())
            .header("X-Syky-MC", var3.v2())
            .header("X-Syky-OS", var3.v3())
            .header("X-Syky-HW", var3.v4())
            .header("X-Syky-Auth", var3.v5())
            .buildAsync(CloudEndpoints.v2(this.v46), var4)
            .whenCompleteAsync((var2x, var3x) -> v2(() -> this.v1(var2, var2x, var3x)), this.v7);
      }
   }

   @Nullable
   private String v27() {
      try {
         JsonObject var1 = this.v22().v1(this.v46, "POST", "/v1/devices", null, null);
         String var2 = cloudSupport60.v2(var1, "token");
         if (var2.isEmpty()) {
            return null;
         } else {
            this.v6.v1(this.v4, var1x -> var1x.v1(var2));
            return var2;
         }
      } catch (CloudHttp.Part2 var3) {
         v2.debug("device registration failed: {} {}", var3.v1, var3.v2);
         return null;
      }
   }

   private void v1(int var1, @Nullable WebSocket var2, @Nullable Throwable var3) {
      if (var1 != this.v13) {
         if (var2 != null) {
            var2.abort();
         }
      } else {
         this.v15 = false;
         if (var3 == null && var2 != null) {
            if (!this.v48 && this.v6.v1) {
               this.v12 = var2;
               this.v14 = CompletableFuture.completedFuture(var2);
            } else {
               var2.abort();
            }
         } else {
            Throwable var4 = var3 instanceof CompletionException && var3.getCause() != null ? var3.getCause() : var3;
            long var5 = 0L;
            if (var4 instanceof WebSocketHandshakeException var7 && var7.getResponse().statusCode() == 401) {
               v2.info("the server did not recognise this install; registering again");
               this.v6.v1(this.v4, var0 -> var0.v1(null));
               this.v1(null);
            } else if (var4 instanceof WebSocketHandshakeException var8) {
               var5 = 1000L * var8.getResponse().headers().firstValue("Retry-After").map(CloudClient::v3).orElse(0L);
               v2.debug("gateway refused the connection ({})", var8.getResponse().statusCode());
            } else {
               v2.debug("gateway connection failed", var4);
            }

            this.v1(false, var5);
         }
      }
   }

   private void v1(WebSocketListener.Part1 var1) {
      boolean var2 = this.v16;
      this.v12 = null;
      this.v16 = false;
      this.v49 = false;
      this.v14 = CompletableFuture.failedFuture(new IOException("closed"));
      cloudSupport90.v1(false);
      this.v28();
      if (var2) {
         v2.info("gateway connection closed ({} {})", var1.v1(), var1.v2());
      }

      if (!this.v48 && this.v6.v1) {
         if ("unofficial_client".equals(var1.v2())) {
            v2.info("the gateway does not accept this build; trying again in {} min", 30L);
            this.v1(false, 1800000L);
         } else {
            boolean var3 = var2 && System.currentTimeMillis() - this.v17 >= 60000L;
            if (var3) {
               this.v18 = 0;
            }

            this.v4(var1.v1() == 1001 || var3);
         }
      }
   }

   private static long v3(String var0) {
      try {
         return Math.max(0L, Long.parseLong(var0.trim()));
      } catch (NumberFormatException var2) {
         return 0L;
      }
   }

   private void v1(int var1, String var2) {
      this.v13++;
      this.v15 = false;
      ScheduledFuture var3 = this.v20;
      if (var3 != null) {
         var3.cancel(false);
         this.v20 = null;
      }

      WebSocket var4 = this.v12;
      if (var4 != null) {
         CompletableFuture var5 = var4.sendClose(var1, var2).orTimeout(2L, TimeUnit.SECONDS).whenComplete((var1x, var2x) -> var4.abort());
      }

      this.v12 = null;
      this.v16 = false;
      this.v49 = false;
      cloudSupport90.v1(false);
      this.v28();
   }

   private void v4(boolean var1) {
      this.v1(var1, 0L);
   }

   private void v1(boolean var1, long var2) {
      if (!this.v48 && this.v20 == null) {
         long var4 = v1(this.v18, var1, var2, ThreadLocalRandom.current());
         if (!var1) {
            this.v18++;
         }

         this.v20 = this.v7.schedule(() -> v2(() -> {
            this.v20 = null;
            this.v26();
         }), var4, TimeUnit.MILLISECONDS);
      }
   }

   private boolean v1(String var1, JsonObject var2, @Nullable Consumer<cloudSupport84.Part1> var3) {
      WebSocket var4 = this.v12;
      if (var4 != null && this.v16) {
         int var5 = 0;
         if (var3 != null) {
            var5 = ++this.v30;
            if (var5 <= 0) {
               var5 = 1;
               this.v30 = 1;
            }

            this.v32.put(var5, var3);
         }

         String var6 = cloudSupport84.v1(var1, var5, var2);
         this.v14 = this.v14.thenCompose(var1x -> var1x.sendText(var6, true));
         CompletableFuture var7 = this.v14.whenCompleteAsync((var2x, var3x) -> {
            if (var3x != null && this.v12 == var4) {
               v2.debug("gateway send failed", var3x);
               var4.abort();
            }
         }, this.v7);
         return true;
      } else {
         if (var3 != null) {
            var3.accept(null);
         }

         return false;
      }
   }

   private void v28() {
      if (!this.v32.isEmpty()) {
         List var1 = List.copyOf(this.v32.values());
         this.v32.clear();

         for (Consumer var3 : var1) {
            v2(() -> var3.accept(null));
         }
      }
   }

   private void v4(String var1) {
      cloudSupport84.Part1 var2 = cloudSupport84.v1(var1);
      if (var2 != null) {
         if (var2.v5() != 0) {
            Consumer var8 = this.v32.remove(var2.v5());
            if (var8 != null) {
               var8.accept(var2);
            }
         } else {
            String var3 = var2.v4();
            switch (var3) {
               case "hello":
                  this.v1(var2);
                  break;
               case "account":
                  this.v1(cloudSupport84.v1(var2.v6()));
                  break;
               case "outfit":
                  JsonObject var10 = var2.v1();
                  this.v37 = var10 == null ? List.of() : v1(var10.get("cosmetics"));
                  this.v17();
                  break;
               case "claimed":
                  JsonObject var9 = var2.v1();
                  if (var9 != null) {
                     try {
                        cloudSupport90.v3(UUID.fromString(cloudSupport60.v2(var9, "uuid")));
                     } catch (IllegalArgumentException var7) {
                     }
                  }
                  break;
               case "error":
                  v2.debug("gateway error: {}", var2.v3());
                  break;
               default:
                  JsonObject var5 = var2.v1();
                  if (var5 != null && !this.v59.isEmpty()) {
                     this.v5.v1(() -> {
                        for (BiConsumer var4 : this.v59) {
                           var4.accept(var2.v4(), var5);
                        }
                     });
                  }
            }
         }
      }
   }

   private void v1(cloudSupport84.Part1 var1) {
      JsonObject var2 = var1.v1();
      this.v16 = true;
      this.v49 = true;
      this.v17 = System.currentTimeMillis();
      this.v31 = false;
      if (var2 != null) {
         this.v5(cloudSupport60.v2(var2, "nonce"));
         this.v1(cloudSupport84.v1(var2.get("account")));
      }

      cloudSupport90.v1(true);
      this.v52.v1();
      this.v74 = false;
      this.v30();
      this.v29();
      this.v20();
      this.v5.v1(() -> {
         JsonObject var1x = new JsonObject();

         for (BiConsumer var3 : this.v59) {
            var3.accept("gateway_ready", var1x);
         }
      });
   }

   private void v5(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         byte[] var2;
         try {
            var2 = HexFormat.of().parseHex(var1);
         } catch (IllegalArgumentException var4) {
            v2.debug("attestation nonce was not hex");
            return;
         }

         JsonObject var3 = new JsonObject();
         var3.addProperty("proof", HexFormat.of().formatHex(Attestation.v1(var2)));
         this.v1("attest", var3, null);
      }
   }

   private void v1(@Nullable SykySession.Part1 var1) {
      if (var1 == null && !this.v37.isEmpty()) {
         this.v37 = List.of();
         this.v17();
      }

      SykySession.v1(var1);
      if (!this.v6.v1(var1)) {
         this.v6.v1(this.v4, var1x -> var1x.v2(var1));
      }
   }

   private void v29() {
      PresenceSnapshot var1 = this.v23;
      UUID var2 = var1.v4();
      JsonObject var3 = new JsonObject();
      var3.addProperty("server", var1.v1() ? var1.v2() : "");
      var3.addProperty("name", var1.v1() ? var1.v3() : "");
      var3.addProperty("uuid", var1.v1() && var2 != null ? var2.toString() : "");
      if (var1.v1()) {
         if (!var1.v5().isEmpty()) {
            var3.addProperty("endpoint", var1.v5());
         }

         if (var1.v6() != 0L) {
            var3.addProperty("seed", Long.toString(var1.v6()));
         }
      }

      this.v1("presence", var3, var2x -> {
         if (var2x != null && this.v23.equals(var1)) {
            JsonObject var3x = var2x.v1();
            if (!var2x.v2() && var3x != null) {
               String var4 = cloudSupport60.v2(var3x, "network");
               this.v60 = var4;
               String var5 = cloudSupport60.v2(var3x, "reason");
               this.v50 = cloudSupport60.v1(var3x, "tracked", false) ? "visible on " + var4 : v1(var5, var4);
               if ("unverified".equals(var5)) {
                  this.v1(var1);
               }
            } else {
               this.v50 = "refused: " + var2x.v3();
            }
         }
      });
   }

   private void v30() {
      this.v73 = System.currentTimeMillis() + 10000L;
      this.v75 = 0L;
   }

   private void v1(long[] var1) {
      if (this.v16 && this.v23.v1()) {
         cloudSupport87.Part1.Part1 var2 = this.v52.v1(var1, System.currentTimeMillis());
         if (var2 != null) {
            JsonArray var3 = new JsonArray(var2.v1().length);

            for (long var7 : var2.v1()) {
               var3.add(var7);
            }

            JsonObject var9 = new JsonObject();
            var9.add("h", var3);
            PresenceSnapshot var10 = this.v23;
            this.v1("roster", var9, var2x -> {
               JsonObject var3x = var2x != null && !var2x.v2() ? var2x.v1() : null;
               if (var3x != null && this.v23.v1(var10)) {
                  boolean var4 = cloudSupport60.v1(var3x, "aliased", false);
                  this.v52.v1(var4);
                  this.v74 = var4;
               }
            });
            if (var2.v2()) {
               cloudSupport90.v1();
            }
         }
      }
   }

   private static String v1(String var0, String var1) {
      return switch (var0) {
         case "no_network" -> "not on a public server";
         case "name_taken" -> "hidden on " + var1 + ": another syky player holds this name there";
         case "unverified" -> "hidden on " + var1 + ": licence not verified yet";
         default -> "hidden (" + var0 + ")";
      };
   }

   private void v1(PresenceSnapshot var1) {
      cloudSupport89.Part2 var2 = this.v33;
      if (var2 != null && !this.v31 && var2.v2().equals(var1.v4())) {
         this.v31 = true;
         this.v1("verify_begin", new JsonObject(), var3 -> {
            JsonObject var4 = var3 != null && !var3.v2() ? var3.v1() : null;
            String var5 = var4 == null ? "" : cloudSupport60.v2(var4, "server_id");
            if (!v2(var5)) {
               if (!var5.isEmpty()) {
                  v2.warn("the gateway asked to join a serverId that is not a syky challenge; refused");
               }
            } else {
               CompletableFuture var6 = CompletableFuture.runAsync(() -> {
                  try {
                     var2.v4().join(var5);
                  } catch (Exception var3x) {
                     throw new CompletionException(var3x);
                  }
               }, this.v8).whenCompleteAsync((var3x, var4x) -> v2(() -> {
                  if (var4x != null) {
                     v2.debug("session join for licence verification failed", var4x);
                     this.v50 = "hidden: the session server did not accept this login";
                  } else {
                     JsonObject var4xx = new JsonObject();
                     var4xx.addProperty("provider", var2.v1());
                     var4xx.addProperty("name", var2.v3());
                     this.v1("verify_finish", var4xx, var2xxxx -> {
                        if (var2xxxx != null) {
                           if (var2xxxx.v2()) {
                              this.v50 = "hidden: licence not verified (" + var2xxxx.v3() + ")";
                           } else if (this.v23.v1(var1)) {
                              this.v50 = "visible, licence verified";
                           }
                        }
                     });
                  }
               }), this.v7);
            }
         });
      }
   }

   public static boolean v2(String var0) {
      if (var0.startsWith("syky-") && var0.length() <= "syky-".length() + 64) {
         for (int var1 = "syky-".length(); var1 < var0.length(); var1++) {
            char var2 = var0.charAt(var1);
            if ((var2 < '0' || var2 > '9') && (var2 < 'a' || var2 > 'f')) {
               return false;
            }
         }

         return var0.length() > "syky-".length();
      } else {
         return false;
      }
   }

   private void v32() {
      if (this.v16) {
         List var1 = cloudSupport90.v1(256);
         if (!var1.isEmpty()) {
            JsonArray var2 = new JsonArray();

            for (cloudSupport90.Part1 var4 : var1) {
               JsonObject var5 = new JsonObject();
               var5.addProperty("uuid", var4.v1().toString());
               var5.addProperty("name", var4.v2());
               var2.add(var5);
            }

            JsonObject var6 = new JsonObject();
            var6.add("players", var2);
            PresenceSnapshot var7 = this.v23;
            this.v1("lookup", var6, var3 -> {
               long var4x = System.currentTimeMillis();
               JsonObject var6x = var3 != null && !var3.v2() ? var3.v1() : null;
               if (var6x != null && this.v23.v1(var7)) {
                  HashSet var7x = new HashSet();
                  HashMap var8 = new HashMap();
                  HashMap var9 = new HashMap();
                  JsonElement var11 = var6x.get("players");
                  if (var11 instanceof JsonArray) {
                     for (JsonElement var12 : (JsonArray)var11) {
                        if (var12.isJsonObject()) {
                           try {
                              JsonObject var13 = var12.getAsJsonObject();
                              UUID var14 = UUID.fromString(cloudSupport60.v2(var13, "uuid"));
                              var7x.add(var14);
                              var8.put(var14, v1(var13.get("c")));
                              long var15 = cloudSupport60.v3(var13, "uid");
                              String var17 = cloudSupport60.v2(var13, "username");
                              if (var15 > 0L && !var17.isEmpty()) {
                                 var9.put(var14, new cloudSupport90.Part2(var15, var17));
                              }
                           } catch (IllegalArgumentException var18) {
                           }
                        }
                     }
                  }

                  cloudSupport90.v1(var1, var7x, var9, var4x);
                  InternalSupport60 var19 = this.v53;
                  UUID var21 = this.v23.v4();
                  if (var19 != null) {
                     for (cloudSupport90.Part1 var23 : var1) {
                        if (!var23.v1().equals(var21)) {
                           var19.v1(var23.v1(), var8.getOrDefault(var23.v1(), List.of()));
                        }
                     }
                  }
               } else {
                  cloudSupport90.v1(var1, var4x);
               }
            });
         }
      }
   }

   public static List<String> v1(@Nullable JsonElement var0) {
      if (var0 instanceof JsonArray var1) {
         ArrayList var2 = new ArrayList(var1.size());

         for (JsonElement var4 : var1) {
            if (var4.isJsonObject() && var2.size() < 16) {
               String var5 = cloudSupport60.v2(var4.getAsJsonObject(), "id");
               String var6 = cloudSupport60.v2(var4.getAsJsonObject(), "h");
               if (!var5.isEmpty() && v72.matcher(var6).matches()) {
                  var2.add(var5 + "@" + var6);
               }
            }
         }

         return List.copyOf(var2);
      } else {
         return List.of();
      }
   }

   private void v5(boolean var1) {
      String var2 = this.v42;
      if (this.v38 != null && var2 != null) {
         this.v5.v1(this.v1(var2, var1));
         this.v5.v1("Finish signing in in your browser.", false);
      } else if (!this.v6.v1) {
         this.v5.v1("Online features are off. Turn them on with .syky account online on", true);
      } else {
         String var3 = this.v6.v3();
         if (var3 == null) {
            var3 = this.v27();
         }

         if (var3 == null) {
            this.v5.v1("Could not reach the syky server. Try again in a moment.", true);
         } else {
            SykyLinkLogin var4;
            try {
               var4 = new SykyLinkLogin(var1x -> this.v1((Runnable)(() -> this.v6(var1x))), var1x -> this.v1((Runnable)(() -> {
                  this.v1(null, null);
                  this.v5.v1(var1x, true);
               })));
            } catch (IOException var9) {
               this.v5.v1("Could not start the sign-in (no local port available).", true);
               return;
            }

            JsonObject var5 = new JsonObject();
            var5.addProperty("port", var4.v1());
            var5.addProperty("code_challenge", var4.v3());

            String var6;
            try {
               var6 = cloudSupport60.v2(this.v22().v1(this.v46, "POST", "/v1/link", var5, var3), "url");
            } catch (CloudHttp.Part2 var8) {
               var4.close();
               this.v5.v1("Could not start the sign-in: " + var8.getMessage(), true);
               return;
            }

            if (!var6.startsWith(this.v51 + "/")) {
               var4.close();
               this.v5.v1("The syky server answered with an unexpected sign-in address.", true);
            } else {
               String var7 = var6.substring(this.v51.length());
               this.v1(var4, var7);
               var4.v4();
               this.v5.v1(this.v1(var7, var1));
               this.v5.v1("Finish signing in in your browser.", false);
            }
         }
      }
   }

   private URI v1(String var1, boolean var2) {
      return URI.create(var2 ? this.v51 + "/register?next=" + URLEncoder.encode(var1, StandardCharsets.UTF_8) : this.v51 + var1);
   }

   private void v1(@Nullable SykyLinkLogin var1, @Nullable String var2) {
      this.v38 = var1;
      this.v42 = var2;
      this.v43 = var1 != null;
   }

   private void v6(String var1) {
      SykyLinkLogin var2 = this.v38;
      this.v1(null, null);
      String var3 = this.v6.v3();
      if (var2 != null && var3 != null) {
         JsonObject var4 = new JsonObject();
         var4.addProperty("code", var1);
         var4.addProperty("code_verifier", var2.v2());

         try {
            JsonObject var5 = this.v22().v1(this.v46, "POST", "/v1/link/exchange", var4, var3);
            SykySession.Part1 var6 = cloudSupport84.v1(var5.get("account"));
            this.v1(var6);
            if (var6 != null) {
               this.v5.v1("Signed in as " + var6.v2() + " (UID " + var6.v1() + ").", false);
            }
         } catch (CloudHttp.Part2 var7) {
            this.v5.v1("Sign-in failed: " + var7.getMessage(), true);
         }
      }
   }

   private void v23() {
      String var1 = this.v6.v3();
      if (var1 != null && SykySession.v1() != null) {
         try {
            this.v22().v1(this.v46, "DELETE", "/v1/link", null, var1);
            this.v1(null);
            this.v5.v1("Signed out of your syky account.", false);
         } catch (CloudHttp.Part2 var3) {
            this.v5.v1("Could not sign out: " + var3.getMessage(), true);
         }
      } else {
         this.v5.v1("You are not signed in.", false);
      }
   }
}
