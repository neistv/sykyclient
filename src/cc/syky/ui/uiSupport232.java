package cc.syky.ui;

import cc.syky.cloud.cloudSupport90;
import cc.syky.module.visual.visualSupport16;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_11719.class_11721;
import org.jetbrains.annotations.Nullable;

public final class uiSupport232 {
   private static final class_2960 v1 = class_2960.method_60655("syky", "badge");
   private static final class_2561 v2 = class_2561.method_43470('\ue800' + "\ue801").method_27694(var0 -> var0.method_27704(new class_11721(v1)));
   private static final Map<class_2561, class_2561> v3 = new IdentityHashMap<>();
   private static final int v4 = 512;

   private uiSupport232() {
   }

   @Nullable
   public static class_2561 v1(UUID var0, @Nullable String var1, @Nullable class_2561 var2) {
      if (uiSupport223.v1(var0)) {
         return uiSupport223.v1();
      } else {
         return var2 == null ? null : v1(var0, var1, var2, visualSupport16.v1 && visualSupport16.v3);
      }
   }

   public static class_2561 v2(UUID var0, @Nullable String var1, class_2561 var2) {
      return v1(var0, var1, var2, visualSupport16.v1 && visualSupport16.v4);
   }

   public static boolean v1(class_2561 var0) {
      List var1 = var0.method_10855();
      if (var1.isEmpty()) {
         return false;
      } else {
         class_2561 var2 = (class_2561)var1.get(0);
         if (var2 == v2) {
            return true;
         } else {
            List var3 = var2.method_10855();
            return !var3.isEmpty() && var3.get(0) == v2;
         }
      }
   }

   private static class_2561 v1(UUID var0, @Nullable String var1, class_2561 var2, boolean var3) {
      boolean var4 = var1 != null && cloudSupport90.v1(var0, var1);
      class_2561 var5 = var3 ? visualSupport16.v1(var0, var1) : null;
      class_2561 var6 = var4 ? v2(var5) : var5;
      return (class_2561)(var6 == null ? var2 : class_2561.method_43473().method_10852(var6).method_10852(var2));
   }

   private static class_2561 v2(@Nullable class_2561 var0) {
      if (var0 == null) {
         return v2;
      } else {
         synchronized (v3) {
            Object var2 = v3.get(var0);
            if (var2 == null) {
               if (v3.size() >= 512) {
                  v3.clear();
               }

               var2 = class_2561.method_43473().method_10852(v2).method_10852(var0);
               v3.put(var0, (class_2561)var2);
            }

            return (class_2561)var2;
         }
      }
   }
}
