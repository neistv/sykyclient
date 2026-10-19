package cc.syky.cloud;

import cc.syky.module.ModuleSubscription;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport91 implements cloudSupport92 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.bus");
   private final Map<Class<?>, CopyOnWriteArrayList<cloudSupport91.Part1<?>>> v2 = new HashMap<>();

   public cloudSupport91() {
   }

   @Override
   public <E> ModuleSubscription v1(Class<E> var1, Consumer<E> var2, int var3) {
      cloudSupport91.Part1 var4 = new cloudSupport91.Part1(var2, var3);
      this.v2.compute(var1, (var1x, var2x) -> {
         ArrayList var3x = new ArrayList((Collection<? extends E>)(var2x == null ? List.of() : var2x));
         var3x.add(var4);
         var3x.sort(Comparator.<cloudSupport91.Part1>comparingInt(var0x -> var0x.v2).reversed());
         return new CopyOnWriteArrayList<>(var3x);
      });
      return () -> this.v2.computeIfPresent(var1, (var1xx, var2xx) -> {
         ArrayList var3x = new ArrayList<>(var2xx);
         var3x.remove(var4);
         return var3x.isEmpty() ? null : new CopyOnWriteArrayList<>(var3x);
      });
   }

   @Override
   public <E> void v1(E var1) {
      CopyOnWriteArrayList var2 = this.v2.get(var1.getClass());
      if (var2 != null) {
         for (cloudSupport91.Part1 var4 : var2) {
            try {
               var4.v1.accept((E)var1);
               if (var4.v3 > 0) {
                  v1.info("subscriber {} recovered after {} consecutive failure(s) on {}", new Object[]{var4.v1(), var4.v3, var1.getClass().getSimpleName()});
                  var4.v3 = 0;
               }
            } catch (Throwable var6) {
               var4.v3++;
               if (var4.v3 == 1) {
                  v1.error(
                     "subscriber {} threw on {} — isolated, remaining subscribers still run", new Object[]{var4.v1(), var1.getClass().getSimpleName(), var6}
                  );
               }
            }
         }
      }
   }

   public static final class Part1<E> {
      public final Consumer<E> v1;
      public final int v2;
      public int v3;

      public Part1(Consumer<E> var1, int var2) {
         this.v1 = var1;
         this.v2 = var2;
      }

      public String v1() {
         return this.v1.getClass().getName();
      }
   }
}
