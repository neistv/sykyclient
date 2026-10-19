package cc.syky.cloud;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.LongSupplier;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RenderThreadSupport implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.watchdog");
   private static final int v2 = 25;
   private static final String v3 = "Render thread";
   private final LongSupplier v4;
   private final long v5;
   private final long v6;
   @Nullable
   private final RenderThreadSupport.Part1 v7;
   private final LongSupplier v8;
   private final AtomicBoolean v9 = new AtomicBoolean(false);
   @Nullable
   private Thread v10;
   @Nullable
   private Thread v11;

   public RenderThreadSupport(LongSupplier var1, long var2, long var4) {
      this(var1, var2, var4, null);
   }

   public RenderThreadSupport(LongSupplier var1, long var2, long var4, @Nullable RenderThreadSupport.Part1 var6) {
      this(var1, var2, var4, var6, System::currentTimeMillis);
   }

   public RenderThreadSupport(LongSupplier var1, long var2, long var4, @Nullable RenderThreadSupport.Part1 var6, LongSupplier var7) {
      if (var2 <= 0L) {
         throw new IllegalArgumentException("stuckThresholdMillis must be > 0");
      } else if (var4 <= 0L) {
         throw new IllegalArgumentException("pollIntervalMillis must be > 0");
      } else {
         this.v4 = var1;
         this.v5 = var2;
         this.v6 = var4;
         this.v7 = var6;
         this.v8 = var7;
      }
   }

   public synchronized void v1() {
      if (this.v9.compareAndSet(false, true)) {
         this.v10 = new Thread(this::v2, "syky-watchdog");
         this.v10.setDaemon(true);
         this.v10.start();
      }
   }

   @Override
   public synchronized void close() {
      if (this.v9.compareAndSet(true, false)) {
         Thread var1 = this.v10;
         if (var1 != null) {
            var1.interrupt();

            try {
               var1.join(1000L);
            } catch (InterruptedException var3) {
               Thread.currentThread().interrupt();
            }
         }

         this.v10 = null;
      }
   }

   private void v2() {
      boolean var1 = false;
      long var2 = 0L;
      long var4 = this.v8.getAsLong();
      long var6 = 0L;

      while (this.v9.get()) {
         try {
            Thread.sleep(this.v6);
         } catch (InterruptedException var12) {
            return;
         }

         long var8 = this.v8.getAsLong();
         if (var8 - var4 > this.v6 + this.v5) {
            var6 = var8;
         }

         var4 = var8;

         try {
            var2 = this.v1(var1, var2, var8, var6);
            var1 = var2 > 0L;
         } catch (Throwable var11) {
            v1.warn("watchdog poll failed — continuing", var11);
            var1 = false;
            var2 = 0L;
         }
      }
   }

   private long v1(boolean var1, long var2, long var4, long var6) {
      long var8 = this.v4.getAsLong();
      if (var8 == 0L) {
         return 0L;
      } else {
         long var10 = var4 - Math.max(var8, var6);
         if (var10 >= this.v5) {
            if (!var1) {
               this.v1(var10);
            }

            RenderThreadSupport.Part1 var14 = this.v7;
            Thread var13 = var14 == null ? null : this.v3();
            if (var14 != null && var13 != null) {
               var14.v1(var13, var10);
            }

            return Math.max(var2, var10);
         } else {
            if (var1) {
               v1.info("main-thread recovered after {} ms freeze", var2);
               RenderThreadSupport.Part1 var12 = this.v7;
               if (var12 != null) {
                  var12.v1();
               }
            }

            return 0L;
         }
      }
   }

   private void v1(long var1) {
      Thread var3 = this.v3();
      if (var3 == null) {
         v1.warn("main-thread frozen for {} ms; could not locate render thread for stack dump", var1);
      } else {
         StackTraceElement[] var4 = var3.getStackTrace();
         StringBuilder var5 = new StringBuilder(512);
         var5.append("main-thread frozen for ").append(var1).append(" ms — stack trace of \"").append(var3.getName()).append("\":");
         int var6 = Math.min(var4.length, 25);

         for (int var7 = 0; var7 < var6; var7++) {
            var5.append("\n\tat ").append(var4[var7]);
         }

         if (var4.length > var6) {
            var5.append("\n\t... ").append(var4.length - var6).append(" more");
         }

         v1.warn("{}", var5);
      }
   }

   @Nullable
   private Thread v3() {
      Thread var1 = this.v11;
      if (var1 != null) {
         return var1;
      } else {
         Thread var2 = null;

         for (Thread var4 : Thread.getAllStackTraces().keySet()) {
            String var5 = var4.getName();
            if ("Render thread".equals(var5)) {
               this.v11 = var4;
               return var4;
            }

            if (var2 == null && var5.contains("Render")) {
               var2 = var4;
            }
         }

         this.v11 = var2;
         return var2;
      }
   }

   public interface Part1 {
      void v1(Thread var1, long var2);

      void v1();
   }
}
