package cc.syky.cloud;

import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport12<T> {
   private final Predicate<T> v1;
   @Nullable
   private T v2;

   public cloudSupport12(Predicate<T> var1) {
      this.v1 = var1;
   }

   @Nullable
   public T v1(@Nullable T var1, boolean var2) {
      if (var1 != null && this.v1.test((T)var1)) {
         this.v2 = (T)var1;
         return (T)var1;
      } else {
         Object var3 = this.v2;
         if (var2 && var3 != null) {
            return (T)var3;
         } else {
            this.v2 = null;
            return (T)var1;
         }
      }
   }

   public void v1() {
      this.v2 = null;
   }
}
