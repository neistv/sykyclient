package cc.syky.module.utilities;

import java.util.List;
import java.util.function.Predicate;

public final class utilitiesSupport11 {
   public static final int v1 = -1;
   public static final int v2 = -2;

   private utilitiesSupport11() {
   }

   public static <T> int v1(List<T> var0, int var1, Predicate<? super T> var2) {
      if (var0.isEmpty()) {
         return -2;
      } else if (!var2.test(var0.get(0))) {
         return -1;
      } else {
         int var3 = 0;
         int var4 = 0;

         for (int var5 = var0.size(); var4 < var5; var4++) {
            if (var2.test(var0.get(var4)) && var3++ == var1) {
               return var4;
            }
         }

         return -2;
      }
   }

   public static <T> int v2(List<T> var0, int var1, Predicate<? super T> var2) {
      int var3 = var1 + 1;

      while (var3 < var0.size() && !var2.test(var0.get(var3))) {
         var3++;
      }

      return var3;
   }
}
