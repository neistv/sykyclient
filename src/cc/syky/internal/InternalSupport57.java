package cc.syky.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport57 implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.jobs");
   private final ScheduledExecutorService v2;

   public InternalSupport57(int var1) {
      this.v2 = Executors.newScheduledThreadPool(var1, new InternalSupport57.Part1("syky-worker"));
   }

   @CanIgnoreReturnValue
   public Future<?> v1(Runnable var1) {
      return this.v2.submit(v2(var1));
   }

   public <T> Future<T> v1(Callable<T> var1) {
      return this.v2.submit(var1);
   }

   @CanIgnoreReturnValue
   public ScheduledFuture<?> v1(Runnable var1, long var2, TimeUnit var4) {
      return this.v2.schedule(v2(var1), var2, var4);
   }

   private static Runnable v2(Runnable var0) {
      return () -> {
         try {
            var0.run();
         } catch (Throwable var2) {
            v1.error("background job threw", var2);
         }
      };
   }

   @Override
   public void close() {
      this.v2.shutdown();

      try {
         if (!this.v2.awaitTermination(5L, TimeUnit.SECONDS)) {
            v1.warn("workers did not terminate in 5s, forcing");
            this.v2.shutdownNow();
         }
      } catch (InterruptedException var2) {
         Thread.currentThread().interrupt();
         this.v2.shutdownNow();
      }
   }

   public static final class Part1 implements ThreadFactory {
      private final String v1;
      private final AtomicInteger v2 = new AtomicInteger();

      public Part1(String var1) {
         this.v1 = var1;
      }

      @Override
      public Thread newThread(Runnable var1) {
         Thread var2 = new Thread(var1, this.v1 + "-" + this.v2.getAndIncrement());
         var2.setDaemon(true);
         return var2;
      }
   }
}
