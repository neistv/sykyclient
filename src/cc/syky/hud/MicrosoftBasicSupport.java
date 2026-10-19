package cc.syky.hud;

import cc.syky.render.renderSupport47;
import cc.syky.ui.uiSupport236;
import cc.syky.ui.uiSupport237;
import cc.syky.ui.uiSupport238;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.util.platform.windows.WmiQueryHandler;

public final class MicrosoftBasicSupport implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.hardware");
   private static final long v2 = 1L;
   private static final long v3 = 3000000000L;
   private static final AtomicLong v4 = new AtomicLong();
   private static final int v5 = 3;
   private final AtomicReference<hudRecord6> v6 = new AtomicReference<>(hudRecord6.EMPTY);
   private final ScheduledExecutorService v7;
   @Nullable
   private CentralProcessor v8;
   @Nullable
   private Sensors v9;
   @Nullable
   private long[] v10;
   private String v11 = "";
   private String v12 = "";
   @Nullable
   private volatile uiSupport236 v13;
   private boolean v14;
   @Nullable
   private WmiQueryHandler v15;
   private boolean v16;
   private boolean v18;
   private int v19;
   private volatile boolean v17;
   private volatile long v20;
   private volatile boolean v21;
   @Nullable
   private ScheduledFuture<?> v22;

   public MicrosoftBasicSupport() {
      this.v7 = Executors.newSingleThreadScheduledExecutor(var0 -> {
         Thread var1 = new Thread(var0, "syky-hwinfo");
         var1.setDaemon(true);
         return var1;
      });
   }

   public void v1() {
      if (!this.v17) {
         this.v7.execute(this::v7);
      }
   }

   @Nullable
   public hudRecord6 v2() {
      this.v20 = System.nanoTime();
      if (!this.v21) {
         this.v4();
      }

      return this.v6.get();
   }

   public static long v3() {
      return v4.get();
   }

   private synchronized void v4() {
      if (!this.v21 && !this.v17) {
         this.v21 = true;
         this.v22 = this.v7.scheduleWithFixedDelay(this::v6, 0L, 1L, TimeUnit.SECONDS);
      }
   }

   private synchronized void v5() {
      this.v21 = false;
      ScheduledFuture var1 = this.v22;
      this.v22 = null;
      if (var1 != null) {
         var1.cancel(false);
      }
   }

   private void v6() {
      if (System.nanoTime() - this.v20 > 3000000000L) {
         this.v5();
      } else {
         this.v7();
      }
   }

   private void v7() {
      try {
         v4.incrementAndGet();
         this.v8();
      } catch (Throwable var2) {
         v1.debug("hardware poll failed", var2);
      }
   }

   private void v8() {
      this.v9();
      this.v6.set(new hudRecord6(this.v11, this.v11(), this.v12(), this.v12, this.v13(), this.v15()));
   }

   private void v9() {
      if (!this.v14) {
         this.v14 = true;
         long var1 = System.nanoTime();
         v10();
         SystemInfo var3 = new SystemInfo();
         HardwareAbstractionLayer var4 = var3.getHardware();
         this.v8 = var4.getProcessor();
         this.v9 = var4.getSensors();
         this.v10 = this.v8.getSystemCpuLoadTicks();
         this.v11 = uiSupport237.v1(this.v8.getProcessorIdentifier().getName());
         this.v12 = uiSupport237.v2(v1(var4.getGraphicsCards()));
         this.v13 = uiSupport236.v1();
         v1.info("hardware: cpu='{}' gpu='{}' nvml={} ({} ms)", new Object[]{this.v11, this.v12, this.v13 != null, (System.nanoTime() - var1) / 1000000L});
      }
   }

   private static void v10() {
      try {
         Configurator.setLevel("oshi", Level.ERROR);
      } catch (Throwable var1) {
      }
   }

   private int v11() {
      try {
         double var1 = renderSupport47.v1(this.v8).getSystemCpuLoadBetweenTicks(this.v10);
         this.v10 = renderSupport47.v1(this.v8).getSystemCpuLoadTicks();
         return !Double.isNaN(var1) && !(var1 < 0.0) ? (int)Math.round(Math.min(1.0, var1) * 100.0) : -1;
      } catch (Throwable var3) {
         return -1;
      }
   }

   private int v12() {
      if (this.v18) {
         return -1;
      } else {
         try {
            double var1 = renderSupport47.v1(this.v9).getCpuTemperature();
            if (!Double.isNaN(var1) && !(var1 <= 0.0)) {
               this.v19 = 0;
               return (int)Math.round(var1);
            } else {
               this.v1("unreadable", null);
               return -1;
            }
         } catch (Throwable var3) {
            this.v1("threw", var3);
            return -1;
         }
      }
   }

   private void v1(String var1, @Nullable Throwable var2) {
      if (++this.v19 >= 3) {
         this.v18 = true;
         v1.debug("CPU temperature sensor {}; disabling to avoid per-second OSHI log spam", var1, var2);
      }
   }

   private int v13() {
      if (this.v13 != null) {
         int var1 = this.v13.v3();
         if (var1 >= 0) {
            return var1;
         }
      }

      return this.v14();
   }

   private int v14() {
      if (this.v16) {
         return -1;
      } else if (!System.getProperty("os.name", "").toLowerCase(Locale.ROOT).startsWith("windows")) {
         this.v16 = true;
         return -1;
      } else {
         try {
            if (this.v15 == null) {
               this.v15 = WmiQueryHandler.createInstance();
            }

            return uiSupport238.v1(this.v15);
         } catch (Throwable var2) {
            this.v16 = true;
            v1.debug("WMI GPU utilization unavailable; disabling", var2);
            return -1;
         }
      }
   }

   private int v15() {
      return this.v13 != null ? this.v13.v2() : -1;
   }

   private static String v1(List<GraphicsCard> var0) {
      GraphicsCard var1 = null;

      for (GraphicsCard var3 : var0) {
         String var4 = var3.getName();
         if (var4 != null && !var4.isBlank() && !var4.contains("Microsoft Basic") && (var1 == null || var3.getVRam() > var1.getVRam())) {
            var1 = var3;
         }
      }

      return var1 != null ? var1.getName() : "";
   }

   @Override
   public void close() {
      if (!this.v17) {
         this.v17 = true;
         this.v7.shutdownNow();
         boolean var1 = false;

         try {
            var1 = this.v7.awaitTermination(2L, TimeUnit.SECONDS);
         } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
         }

         uiSupport236 var2 = this.v13;
         if (var2 != null && var1) {
            var2.close();
         } else if (var2 != null) {
            v1.warn("hardware poll did not stop in time — leaving NVML to the process exit");
         }
      }
   }
}
