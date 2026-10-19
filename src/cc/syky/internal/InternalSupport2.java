package cc.syky.internal;

import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport2 {
   private static final Set<String> v1 = new LinkedHashSet<>();
   @Nullable
   private static Path v2;

   private InternalSupport2() {
   }

   public static boolean v1(String var0) {
      return v1.contains(var0);
   }

   public static void v2(String var0) {
      if (v1.remove(var0)) {
         Path var1 = v2;
         if (var1 != null) {
            InternalSupport12 var2 = InternalSupport12.v1(var1);
            var2.v1(v1);
            var2.v1();
         }
      }
   }

   public static void v1(Set<String> var0, @Nullable Path var1) {
      v1.clear();
      v1.addAll(var0);
      v2 = var1;
   }
}
