package cc.syky.crash;

import cc.syky.cloud.RenderThreadSupport;
import cc.syky.cloud.cloudSupport63;
import cc.syky.storage.SykyPaths;
import cc.syky.ui.HHMmSupport2;
import cc.syky.ui.NativeMethodSupport;
import cc.syky.ui.SykyBuildSupport;
import cc.syky.ui.uiSupport247;
import cc.syky.ui.uiSupport248;
import cc.syky.ui.uiSupport249;
import cc.syky.ui.uiSupport250;
import cc.syky.ui.uiSupport251;
import cc.syky.ui.uiSupport252;
import cc.syky.ui.uiSupport253;
import cc.syky.ui.uiSupport254;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.Thread.State;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.management.ManagementFactory;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CrashReporter implements uiSupport249.Part1, cloudSupport63.Part1 {
   public static final long v1 = 5000L;
   private static final Logger v2 = LoggerFactory.getLogger("syky.crash");
   private static final Duration v3 = Duration.ofMillis(2500L);
   private static final long v4 = 60000L;
   private static final long v5 = 600000L;
   private static final long v6 = 500L;
   private static final long v7 = 5L;
   private static final int v8 = 64;
   private static final int v9 = 50;
   private static final int v10 = 8;
   private static final int v11 = 32;
   private static final String v12 = "syky.Hang";
   @Nullable
   public static volatile CrashReporter v13;
   private static final RenderThreadSupport.Part1 v14 = new RenderThreadSupport.Part1() {
      @Override
      public void v1(Thread var1, long var2) {
         CrashReporter var4 = CrashReporter.v13;
         if (var4 != null) {
            var4.v1(var1, var2);
         }
      }

      @Override
      public void v1() {
         CrashReporter var1 = CrashReporter.v13;
         if (var1 != null) {
            var1.v34 = false;
            var1.v36 = 0L;
         }
      }
   };
   private final String v15 = UUID.randomUUID().toString();
   private final Path v16;
   private final Path v18;
   private final Path v19;
   private final uiSupport252 v17 = new uiSupport252();
   private final uiSupport254 v20 = new uiSupport254();
   private final HHMmSupport2 v21 = new HHMmSupport2();
   private final SykyBuildSupport v22 = new SykyBuildSupport();
   private final uiSupport248 v24;
   private final crashSupport2 v25;
   private final uiSupport253<CrashReporter.Part1> v26 = new uiSupport253<>(64, 50);
   private final uiSupport251 v27;
   private final uiSupport249 v28;
   private final ScheduledExecutorService v29;
   private final AtomicBoolean v30 = new AtomicBoolean();
   private final AtomicBoolean v32 = new AtomicBoolean();
   @Nullable
   private volatile crashSupport v23;
   private volatile boolean v33;
   private volatile Supplier<? extends Collection<String>> v31 = List::of;
   public volatile boolean v34;
   public volatile long v36;
   private int v38;

   private CrashReporter(SykyPaths var1, Path var2) {
      this.v16 = var2;
      this.v18 = var1.v7();
      this.v19 = var1.v10().resolve("cloud.json");
      this.v24 = new uiSupport248(this.v18.resolve("outbox"));
      this.v25 = new crashSupport2(this.v18);
      this.v27 = new uiSupport251(this.v17, this::v1);
      this.v28 = new uiSupport249(this.v21, this);
      this.v29 = Executors.newSingleThreadScheduledExecutor(var0 -> {
         Thread var1x = new Thread(var0, "syky-crash");
         var1x.setDaemon(true);
         return var1x;
      });
   }

   public static void v1(SykyPaths var0, Path var1) {
      if (v13 == null) {
         try {
            CrashReporter var2 = new CrashReporter(var0, var1);
            v13 = var2;
            var2.v6();
         } catch (Throwable var3) {
            v2.warn("crash reporting is off for this session", var3);
         }
      }
   }

   @Nullable
   public static uiSupport248 v1() {
      CrashReporter var0 = v13;
      return var0 == null ? null : var0.v24;
   }

   public static void v1(Supplier<? extends Collection<String>> var0) {
      CrashReporter var1 = v13;
      if (var1 != null) {
         var1.v31 = var0;
      }
   }

   public static void v2(String var0, String var1) {
      CrashReporter var2 = v13;
      if (var2 != null) {
         var2.v1(var0, var1);
      }
   }

   public static void v2() {
      CrashReporter var0 = v13;
      if (var0 != null) {
         var0.v27.v1();
         int var1 = var0.v17.v1();
         if (var1 != var0.v38) {
            var0.v38 = var1;
            var0.v29.execute(v1(var0::v9));
         }
      }
   }

   public static RenderThreadSupport.Part1 v3() {
      return v14;
   }

   public static void v4() {
      CrashReporter var0 = v13;
      if (var0 != null) {
         var0.v17.v6 = "shutdown";
         var0.v1("lifecycle", "stopping");

         try {
            Future var1 = var0.v29.submit(v1(var0::v12));
            var1.get(500L, TimeUnit.MILLISECONDS);
         } catch (Throwable var2) {
         }
      }
   }

   public static void v1(String var0, @Nullable Throwable var1, @Nullable Path var2) {
      CrashReporter var3 = v13;
      if (var3 != null && var3.v30.compareAndSet(false, true)) {
         var3.v2(var0, var1, var2);
      }
   }

   public static void v5() {
      CrashReporter var0 = v13;
      if (var0 != null) {
         try {
            ScheduledFuture var1 = var0.v29.schedule(v1((Runnable)(() -> CrashUploader.v1(var0.v19, var0.v24))), 5L, TimeUnit.SECONDS);
         } catch (Throwable var2) {
         }
      }
   }

   private void v6() {
      cloudSupport63.v1(this);
      this.v28.v1();
      this.v11();
      uiSupport250.v1(this::v1);
      this.v1("lifecycle", "start");
      this.v29.execute(v1(this::v7));
      ScheduledFuture var1 = this.v29.scheduleWithFixedDelay(v1(this::v8), 60000L, 60000L, TimeUnit.MILLISECONDS);
      ScheduledFuture var2 = this.v29.scheduleWithFixedDelay(v1(this::v12), 600000L, 600000L, TimeUnit.MILLISECONDS);
      Runtime.getRuntime().addShutdownHook(new Thread(this::v10, "syky-crash-exit"));
   }

   private void v7() {
      long var1 = System.currentTimeMillis();

      try {
         this.v23 = crashSupport.v1(this.v18, this.v15, v15(), var1 - v14());
         if (this.v33) {
            this.v10();
         }

         this.v9();
      } catch (RuntimeException | IOException var4) {
         v2.debug("no session marker this launch", var4);
      }

      this.v22.v1();
      this.v24.v2();
      new CrashCollector(this.v16, Path.of("").toAbsolutePath(), this.v18, this.v15, this.v25, this.v17).v1(var1, (var1x, var2, var3) -> {
         var1x.v3(this.v22.v1(new uiSupport252(), var2));
         this.v1(var1x, var3);
      });
   }

   private void v8() {
      this.v9();
      this.v28.v1();
   }

   private void v9() {
      crashSupport var1 = this.v23;
      if (var1 != null) {
         var1.v1(this.v17.v6, v14(), System.currentTimeMillis(), List.copyOf(this.v17.v18), List.copyOf(this.v17.v16));
      }
   }

   private void v10() {
      this.v33 = true;
      crashSupport var1 = this.v23;
      this.v23 = null;
      if (var1 != null) {
         var1.v1();
      }
   }

   private void v11() {
      UncaughtExceptionHandler var1 = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler((var2, var3) -> {
         try {
            if (var2.getName().startsWith("syky")) {
               this.v1("uncaught", var3, var2.getName());
            }
         } catch (Throwable var5) {
         }

         if (var1 != null) {
            var1.uncaughtException(var2, var3);
         } else {
            System.err.print("Exception in thread \"" + var2.getName() + "\" ");
            var3.printStackTrace(System.err);
         }
      });
   }

   @Override
   public void v1(String var1, Throwable var2) {
      this.v1("guard", var1 + ": " + var2.getClass().getSimpleName());
      this.v1(var1, var2, Thread.currentThread().getName());
   }

   @Override
   public void v1(String var1) {
      this.v17.v2(var1);
   }

   @Override
   public void v1(String var1, String var2) {
      this.v20.v1(v14(), var1, var2);
   }

   @Override
   public void v1(String var1, Throwable var2, String var3) {
      if (!this.v30.get()) {
         CrashReporter.Part1 var4 = new CrashReporter.Part1(var1, var3, var2);
         if (this.v26.v1(var1 + "|" + NativeMethodSupport.v1(var2, 3), var4)) {
            this.v29.execute(v1((Runnable)(() -> this.v1(var4, 1))));
         }
      }
   }

   @Override
   public void v1(Throwable var1, String var2) {
      if (!this.v30.get() && this.v32.compareAndSet(false, true)) {
         this.v29.execute(v1((Runnable)(() -> {
            uiSupport247 var3 = uiSupport247.v1("crash", Instant.now()).v3(var2).v1(NativeMethodSupport.v1(var1));
            this.v1(var3);
            this.v2(var3);
         })));
      }
   }

   private void v1(CrashReporter.Part1 var1, int var2) {
      uiSupport247 var3 = uiSupport247.v1("error", Instant.now()).v3(var1.v2()).v4(var1.v1()).v1(var2).v1(NativeMethodSupport.v1(var1.v3()));
      this.v1(var3);
      this.v2(var3);
   }

   private void v12() {
      for (uiSupport253.Part1 var2 : this.v26.v1()) {
         this.v1((CrashReporter.Part1)var2.v3(), var2.v2());
      }
   }

   public void v1(Thread var1, long var2) {
      if (var2 < this.v36) {
         this.v34 = false;
      }

      this.v36 = var2;
      String var4 = this.v17.v6;
      if (!this.v34 && !this.v30.get() && var2 >= 5000L && !"boot".equals(var4) && !"shutdown".equals(var4)) {
         this.v34 = true;
         StackTraceElement[] var5 = var1.getStackTrace();
         JsonArray var6 = v1(var1);
         String var7 = var1.getName();
         this.v29
            .execute(
               v1(
                  (Runnable)(() -> {
                     uiSupport247 var6x = uiSupport247.v1("hang", Instant.now())
                        .v3(var7)
                        .v2(var2)
                        .v1(NativeMethodSupport.v1("syky.Hang", "the main thread did not tick or draw for " + var2 + " ms", var5))
                        .v1(var6);
                     this.v1(var6x);
                     this.v2(var6x);
                  })
               )
            );
      }
   }

   private static JsonArray v1(Thread var0) {
      ArrayList var1 = new ArrayList();

      for (Entry var3 : Thread.getAllStackTraces().entrySet()) {
         String var4 = ((Thread)var3.getKey()).getName();
         if (var3.getKey() != var0 && (var4.startsWith("syky") || var4.equals("Server thread"))) {
            var1.add(var3);
         }
      }

      var1.sort(Entry.comparingByKey(Comparator.<Thread>comparingInt(var0x -> v1(var0x.getState()) ? 1 : 0).thenComparing(Thread::getName)));
      JsonArray var9 = new JsonArray();

      for (int var10 = 0; var10 < var1.size() && var10 < 8; var10++) {
         Thread var11 = (Thread)((Entry)var1.get(var10)).getKey();
         StackTraceElement[] var5 = (StackTraceElement[])((Entry)var1.get(var10)).getValue();
         JsonObject var6 = new JsonObject();
         var6.addProperty("name", var11.getName());
         var6.addProperty("state", var11.getState().name());
         JsonArray var7 = new JsonArray();

         for (int var8 = 0; var8 < var5.length && var8 < 32; var8++) {
            var7.add(NativeMethodSupport.v1(var5[var8]));
         }

         var6.add("frames", var7);
         var9.add(var6);
      }

      return var9;
   }

   private void v2(String var1, @Nullable Throwable var2, @Nullable Path var3) {
      uiSupport247 var4 = uiSupport247.v1("crash", Instant.now())
         .v3(Thread.currentThread().getName())
         .v1(var2 == null ? null : NativeMethodSupport.v1(var2))
         .v7(var1);
      this.v1(var4);
      Path var5 = this.v2(var4);
      if (var3 != null && var5 != null) {
         this.v25.v1(var3.getFileName().toString());
      }

      this.v10();
      if (var5 != null && CrashUploader.v1(this.v19, uiSupport248.v1(var4), v3)) {
         this.v24.v2(var5);
      }
   }

   private void v1(uiSupport247 var1) {
      var1.v3(this.v22.v1(this.v17, null))
         .v1(this.v15)
         .v1(v14())
         .v2(this.v17.v6)
         .v5(this.v17.v7)
         .v6(this.v17.v8)
         .v2(this.v22.v2())
         .v1(this.v13())
         .v3(this.v20.v1())
         .v2(this.v21.v1());
   }

   @Nullable
   private Path v2(uiSupport247 var1) {
      return this.v1(var1, LogScrubber.v1(this.v17.v16, this.v17.v18));
   }

   @Nullable
   private Path v1(uiSupport247 var1, LogScrubber var2) {
      var2.v1(var1.v4());
      return this.v24.v1(var1, System.currentTimeMillis());
   }

   @Nullable
   private Collection<String> v13() {
      try {
         return List.copyOf((Collection<? extends String>)this.v31.get());
      } catch (Throwable var2) {
         return null;
      }
   }

   private static long v14() {
      return ManagementFactory.getRuntimeMXBean().getUptime();
   }

   private static String v15() {
      return FabricLoader.getInstance().getModContainer("syky").map(var0 -> var0.getMetadata().getVersion().getFriendlyString()).orElse("");
   }

   private static boolean v1(State var0) {
      return var0 == State.WAITING || var0 == State.TIMED_WAITING;
   }

   private static Runnable v1(Runnable var0) {
      return () -> {
         try {
            var0.run();
         } catch (Throwable var2) {
            v2.debug("crash report task failed", var2);
         }
      };
   }

   public record Part1(String guard, String thread, Throwable thrown) {
      public String v1() {
         return this.guard;
      }

      public String v2() {
         return this.thread;
      }

      public Throwable v3() {
         return this.thrown;
      }
   }
}
