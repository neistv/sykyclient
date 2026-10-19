package cc.syky.internal;

import cc.syky.sykyRecord8;
import cc.syky.account.SMTCMusicSupport;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport16 implements AutoCloseable, InternalSupport18 {
   private static final Logger v2 = LoggerFactory.getLogger("syky.music");
   private static final long v3 = TimeUnit.SECONDS.toNanos(60L);
   private static final long v4 = 10L;
   private static final AtomicLong v5 = new AtomicLong();
   private final Supplier<SMTCMusicSupport> v6;
   private final InternalSupport18 v7;
   private final InternalSupport57 v8;
   private final Object v9 = new Object();
   @Nullable
   private volatile SMTCMusicSupport v10;
   private volatile long v11 = System.nanoTime();
   private boolean v12;
   @Nullable
   private Consumer<InternalSupport18> v13;
   private volatile boolean v14;
   private boolean v15;
   @Nullable
   private ScheduledFuture<?> v16;
   @Nullable
   private InternalSupport18.Part1 v18;

   public InternalSupport16(Supplier<SMTCMusicSupport> var1, InternalSupport18 var2, InternalSupport57 var3) {
      this.v6 = var1;
      this.v7 = var2;
      this.v8 = var3;
   }

   public static long v7() {
      return v5.get();
   }

   public void v8() {
      this.v11 = System.nanoTime();
      this.v10();
   }

   @Nullable
   @Override
   public sykyRecord8 v1() {
      this.v11 = System.nanoTime();
      SMTCMusicSupport var1 = this.v10;
      if (var1 != null) {
         return var1.v1();
      } else if (this.v14) {
         return this.v7.v1();
      } else {
         this.v10();
         return null;
      }
   }

   @Override
   public void v2() {
      this.v1(InternalSupport18.Part2.PLAY_PAUSE);
      this.v1(InternalSupport18::v2);
   }

   @Override
   public void v3() {
      this.v1(InternalSupport18.Part2.NEXT);
      this.v1(InternalSupport18::v3);
   }

   @Override
   public void v4() {
      this.v1(InternalSupport18.Part2.PREVIOUS);
      this.v1(InternalSupport18::v4);
   }

   private void v1(InternalSupport18.Part2 var1) {
      InternalSupport18.Part1 var2 = this.v18;
      this.v18 = new InternalSupport18.Part1(var1, var2 == null ? 0L : var2.v2() + 1L);
   }

   @Nullable
   @Override
   public InternalSupport18.Part1 v6() {
      return this.v18;
   }

   @Override
   public boolean v5() {
      return this.v9().v5();
   }

   @Override
   public void v1(float var1) {
      this.v9().v1(var1);
   }

   @Override
   public boolean v1(float[] var1) {
      return this.v9().v1(var1);
   }

   @Override
   public void close() {
      SMTCMusicSupport var1;
      synchronized (this.v9) {
         this.v15 = true;
         var1 = this.v10;
         this.v10 = null;
         if (this.v16 != null) {
            this.v16.cancel(false);
            this.v16 = null;
         }
      }

      if (var1 != null) {
         var1.close();
      }
   }

   private void v1(Consumer<InternalSupport18> var1) {
      this.v11 = System.nanoTime();
      Object var2;
      synchronized (this.v9) {
         if (this.v15) {
            return;
         }

         var2 = this.v10 != null ? this.v10 : (this.v14 ? this.v7 : null);
         if (var2 == null) {
            this.v13 = var1;
         }
      }

      if (var2 == null) {
         this.v10();
      } else {
         var1.accept(var2);
      }
   }

   private InternalSupport18 v9() {
      SMTCMusicSupport var1 = this.v10;
      return (InternalSupport18)(var1 != null ? var1 : this.v7);
   }

   private void v10() {
      synchronized (this.v9) {
         if (this.v12 || this.v15 || this.v14 || this.v10 != null) {
            return;
         }

         this.v12 = true;
      }

      try {
         this.v8.v1(this::v11);
      } catch (RejectedExecutionException var5) {
         synchronized (this.v9) {
            this.v12 = false;
         }
      }
   }

   private void v11() {
      v5.incrementAndGet();
      SMTCMusicSupport var1 = null;

      try {
         var1 = this.v6.get();
      } catch (Throwable var6) {
         v2.warn("music bridge failed to start", var6);
      }

      boolean var2;
      Consumer var3;
      synchronized (this.v9) {
         this.v12 = false;
         var2 = this.v15;
         var3 = this.v13;
         this.v13 = null;
         if (!this.v15) {
            if (var1 == null) {
               this.v14 = true;
            } else {
               this.v10 = var1;
            }
         }
      }

      if (var1 == null) {
         if (var3 != null && !var2) {
            var3.accept(this.v7);
         }
      } else {
         if (var2) {
            var1.close();
         } else {
            if (var3 != null) {
               var3.accept(var1);
            }

            this.v12();
         }
      }
   }

   private void v12() {
      synchronized (this.v9) {
         if (!this.v15) {
            try {
               this.v16 = this.v8.v1(this::v13, 10L, TimeUnit.SECONDS);
            } catch (RejectedExecutionException var4) {
               this.v16 = null;
            }
         }
      }
   }

   private void v13() {
      SMTCMusicSupport var1;
      synchronized (this.v9) {
         var1 = this.v10;
         if (var1 == null) {
            return;
         }

         if (System.nanoTime() - this.v11 < v3) {
            var1 = null;
         } else {
            this.v10 = null;
         }
      }

      if (var1 == null) {
         this.v12();
      } else {
         var1.close();
      }
   }
}
