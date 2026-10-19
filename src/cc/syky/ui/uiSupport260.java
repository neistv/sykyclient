package cc.syky.ui;

import cc.syky.cloud.cloudSupport63;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport260 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.guard");
   private static final String v2 = "cc.syky.opt.entity.ExtractBail";
   private final String v3;
   private final AtomicInteger v4 = new AtomicInteger();

   public uiSupport260(String var1) {
      this.v3 = var1;
   }

   public void v1(Runnable var1) {
      try {
         var1.run();
         this.v1();
      } catch (Throwable var3) {
         this.v1(var3);
      }
   }

   public boolean v1(BooleanSupplier var1, boolean var2) {
      try {
         boolean var3 = var1.getAsBoolean();
         this.v1();
         return var3;
      } catch (Throwable var4) {
         this.v1(var4);
         return var2;
      }
   }

   public void v1() {
      if (this.v4.get() > 0) {
         int var1 = this.v4.getAndSet(0);
         if (var1 > 0) {
            v1.info("{} recovered after {} consecutive failure(s)", this.v3, var1);
         }
      }
   }

   public void v1(Throwable var1) {
      if (var1 instanceof RuntimeException var2 && "cc.syky.opt.entity.ExtractBail".equals(var1.getClass().getName())) {
         throw var2;
      } else {
         if (this.v4.incrementAndGet() == 1) {
            v1.warn("{} failed — isolated, Minecraft continues", this.v3, var1);
            cloudSupport63.v1(this.v3, var1);
         }
      }
   }
}
