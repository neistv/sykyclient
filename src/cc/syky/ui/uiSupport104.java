package cc.syky.ui;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class uiSupport104 {
   private uiSupport104() {
   }

   public static <R> void v1(List<R> var0, List<R> var1, Predicate<R> var2, Consumer<R> var3) {
      int var4 = 0;

      for (Object var6 : var0) {
         int var7 = var1.indexOf(var6);
         if (var7 >= 0) {
            var4 = var7 + 1;
         } else if (var2.test(var6)) {
            var3.accept(var6);
            var1.add(Math.min(var4, var1.size()), var6);
            var4++;
         }
      }
   }
}
