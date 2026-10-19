package cc.syky.internal;

import cc.syky.ui.uiSupport258;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport56 {
   private static final Logger v3 = LoggerFactory.getLogger("syky.main-thread");
   public static final int v1 = 100;
   public static final int v2 = 50;
   private final ConcurrentLinkedQueue<Runnable> v4 = new ConcurrentLinkedQueue<>();
   private final AtomicInteger v5 = new AtomicInteger();
   private volatile boolean v6;
   private final uiSupport258 v7;

   public InternalSupport56() {
      this(uiSupport258.v1);
   }

   public InternalSupport56(uiSupport258 var1) {
      this.v7 = var1;
   }

   public void v1(Runnable var1) {
      this.v4.offer(var1);
      int var2 = this.v5.incrementAndGet();
      if (!this.v6 && var2 >= 100) {
         this.v6 = true;
         v3.warn("main-thread backlog reached {} pending tasks — likely a runaway producer; check JobScheduler tasks calling runOnMain in a loop", var2);
      }
   }

   public void v1() {
      if (this.v4.peek() != null) {
         long var1 = this.v7.v3();

         Runnable var3;
         try {
            while ((var3 = this.v4.poll()) != null) {
               int var4 = this.v5.decrementAndGet();
               if (this.v6 && var4 <= 50) {
                  this.v6 = false;
                  v3.info("main-thread backlog cleared (now {} pending)", var4);
               }

               var3.run();
            }
         } finally {
            this.v7.v1("mainthread.drain", var1);
         }
      }
   }

   public int v2() {
      return this.v5.get();
   }
}
