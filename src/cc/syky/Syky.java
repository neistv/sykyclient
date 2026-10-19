package cc.syky;

import cc.syky.cloud.cloudSupport59;
import cc.syky.cloud.cloudSupport92;
import cc.syky.crash.CrashReporter;
import cc.syky.internal.InternalSupport56;
import cc.syky.storage.SykyPaths;
import cc.syky.ui.uiSupport258;
import cc.syky.ui.uiSupport260;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents.ClientStopping;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Syky implements ClientModInitializer {
   private static final Logger LOG = LoggerFactory.getLogger("syky");
   private static final uiSupport260 SHUTDOWN_GUARD = new uiSupport260("lifecycle (shutdown)");
   private static final uiSupport260 CRASH_STOP_GUARD = new uiSupport260("lifecycle (crash reports)");
   @Nullable
   private static volatile SykyRuntime ROOT;
   private static long tickCounter;
   private static volatile long lastTickAtMillis;

   public Syky() {
   }

   public void onInitializeClient() {
      SykyRuntime var1 = null;
      long var2 = System.nanoTime();

      try {
         FabricLoader var4 = FabricLoader.getInstance();
         SykyPaths var5 = SykyPaths.v1(var4.getGameDir());
         CrashReporter.v1(var5, var4.getGameDir());
         ClientLifecycleEvents.CLIENT_STOPPING.register((ClientStopping)var0 -> CRASH_STOP_GUARD.v1(CrashReporter::v4));
         cloudSupport59.v1(var4.getConfigDir().resolve("syky"), var5);
         var1 = new SykyRuntime(var5);
         var1.v30();
         ROOT = var1;
         ClientLifecycleEvents.CLIENT_STOPPING.register((ClientStopping)var1x -> SHUTDOWN_GUARD.v1(var1::v32));
         Runtime.getRuntime().addShutdownHook(new Thread(() -> SHUTDOWN_GUARD.v1(var1::v32), "syky-shutdown"));
         CrashReporter.v2("lifecycle", "bootstrapped");
         LOG.info("bootstrapped in {} ms", (System.nanoTime() - var2) / 1000000L);
      } catch (Throwable var8) {
         ROOT = null;
         LOG.error("bootstrap failed — syky disabled for this session", var8);
         CrashReporter.v5();
         if (var1 != null) {
            try {
               var1.v32();
            } catch (Throwable var7) {
               LOG.error("cleanup after failed bootstrap also failed", var7);
            }
         }
      }
   }

   public static SykyRuntime root() {
      SykyRuntime var0 = ROOT;
      if (var0 == null) {
         throw new IllegalStateException("syky not initialized");
      } else {
         return var0;
      }
   }

   @Nullable
   public static SykyRuntime rootOrNull() {
      return ROOT;
   }

   public static cloudSupport92 bus() {
      return root().v5();
   }

   public static InternalSupport56 main() {
      return root().v21();
   }

   public static long nextTick() {
      return ++tickCounter;
   }

   public static long tickCounter() {
      return tickCounter;
   }

   public static void heartbeat() {
      lastTickAtMillis = System.currentTimeMillis();
   }

   public static long lastTickAtMillis() {
      return lastTickAtMillis;
   }

   @Nullable
   public static uiSupport258 profilerOrNull() {
      SykyRuntime var0 = ROOT;
      return var0 == null ? null : var0.v24();
   }
}
