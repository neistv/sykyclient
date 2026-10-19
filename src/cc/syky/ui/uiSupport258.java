package cc.syky.ui;

import cc.syky.cloud.cloudSupport53;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport258 {
   public static final uiSupport258 v1 = new uiSupport258(null);
   @Nullable
   private final cloudSupport53 v2;

   public uiSupport258(@Nullable cloudSupport53 var1) {
      this.v2 = var1;
   }

   public boolean v1() {
      cloudSupport53 var1 = this.v2;
      return var1 != null && var1.v2();
   }

   @Nullable
   public cloudSupport53 v2() {
      return this.v2;
   }

   public long v3() {
      cloudSupport53 var1 = this.v2;
      return var1 != null && var1.v2() ? System.nanoTime() : 0L;
   }

   public void v1(@Nullable String var1, long var2) {
      if (var2 != 0L) {
         cloudSupport53 var4 = this.v2;
         if (var4 != null) {
            var4.v1(var1, System.nanoTime() - var2);
         }
      }
   }

   public void v1(String var1, Runnable var2) {
      cloudSupport53 var3 = this.v2;
      if (var3 != null && var3.v2()) {
         long var4 = System.nanoTime();

         try {
            var2.run();
         } finally {
            var3.v1(var1, System.nanoTime() - var4);
         }
      } else {
         var2.run();
      }
   }

   public <T> T v1(String var1, Supplier<T> var2) {
      cloudSupport53 var3 = this.v2;
      if (var3 != null && var3.v2()) {
         long var4 = System.nanoTime();

         Object var6;
         try {
            var6 = var2.get();
         } finally {
            var3.v1(var1, System.nanoTime() - var4);
         }

         return (T)var6;
      } else {
         return (T)var2.get();
      }
   }
}
