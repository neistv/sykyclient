package cc.syky.config;

import cc.syky.hud.MySettingsSupport;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class configSupport12 implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.settings.writer");
   private final ExecutorService v2 = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "syky-config-writer");
      var1.setDaemon(true);
      return var1;
   });
   @Nullable
   private volatile Future<?> v3;
   private final AtomicBoolean v4 = new AtomicBoolean();
   private final AtomicReference<String> v5 = new AtomicReference<>();

   public configSupport12() {
   }

   public boolean v1(Path var1, String var2, @Nullable String var3, @Nullable String var4) {
      if (this.v3 != null && !this.v3.isDone()) {
         return false;
      } else {
         this.v4.set(false);
         this.v3 = this.v2.submit(() -> {
            try {
               this.v5.set(MySettingsSupport.v1(var1, var2, var3, var4));
               v1.info("saved {} (async)", var1);
            } catch (Throwable var6) {
               this.v4.set(true);
               v1.error("async save failed for {}", var1, var6);
            }
         });
         return true;
      }
   }

   @Nullable
   public String v1() {
      return this.v5.getAndSet(null);
   }

   public boolean v2() {
      return this.v4.getAndSet(false);
   }

   public void v3() {
      Future var1 = this.v3;
      if (var1 != null) {
         try {
            var1.get();
         } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
         } catch (ExecutionException var4) {
         }

         this.v3 = null;
      }
   }

   @Override
   public void close() {
      this.v3();
      this.v2.shutdown();
   }
}
