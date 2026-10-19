package cc.syky.ui;

import cc.syky.hud.hudSupport59;
import java.util.Optional;
import net.minecraft.class_11909;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_7528;
import org.jetbrains.annotations.Nullable;

public final class uiSupport229 {
   private static final double v1 = 0.14285714285714285;
   private static boolean v2;
   @Nullable
   private static class_437 v3;
   @Nullable
   private static uiSupport141 v4;
   @Nullable
   private static class_11909 v5;
   private static boolean v6;

   private uiSupport229() {
   }

   public static boolean v1() {
      return v6;
   }

   public static void v1(boolean var0) {
      v2 = var0;
   }

   public static boolean v2() {
      return hudSupport59.v1.v1();
   }

   public static boolean v1(class_437 var0, class_11909 var1) {
      if (!v1(var0, var1.comp_4798(), var1.comp_4799())) {
         return false;
      } else {
         v3 = var0;
         v4 = uiSupport142.v1;
         v5 = var1;
         double var2 = var0 instanceof class_408 ? 0.14285714285714285 : 0.0;
         hudSupport59.v1.v1((float)var1.comp_4798(), (float)var1.comp_4799(), System.nanoTime(), var2);
         return true;
      }
   }

   public static boolean v1(class_310 var0) {
      hudSupport59 var1 = hudSupport59.v1;
      if (!var1.v1()) {
         return false;
      } else {
         var1.v1((float)uiSupport142.v2(var0));
         boolean var2 = var1.v2();
         class_437 var3 = v3;
         class_11909 var4 = v5;
         v3();
         if (var2) {
            return true;
         } else {
            if (var3 != null && var4 != null && var3 == var0.field_1755) {
               Boolean var5 = uiSupport230.v1(var3, var4, false);
               if (var5 == null) {
                  var3.method_25402(var4, false);
               }
            }

            return false;
         }
      }
   }

   public static void v2(class_310 var0) {
      hudSupport59 var1 = hudSupport59.v1;
      if (var1.v1()) {
         class_437 var2 = var0.field_1755;
         if (var2 != null && var2 == v3 && uiSupport142.v1 == v4 && v2) {
            double var3 = var1.v1((float)uiSupport142.v2(var0), System.nanoTime());
            if (var3 != 0.0) {
               v1(var2, var1.v3(), var1.v4(), var3);
            }
         } else {
            v3();
         }
      }
   }

   private static boolean v1(class_437 var0, double var1, double var3) {
      if (uiSupport142.v1 == null && !(var0 instanceof uiSupport141) && !(var0 instanceof class_408)) {
         if (Boolean.TRUE.equals(uiSupport230.v1(var0, var1, var3, 0.0, 0.0))) {
            return true;
         } else if (var0 instanceof class_465) {
            return false;
         } else {
            Optional var5 = var0.method_19355(var1, var3);
            return var5.isPresent() && var5.get() instanceof class_7528 var6 && var6.method_44390() > 0;
         }
      } else {
         return v1(var0, var1, var3, 0.0);
      }
   }

   private static boolean v1(class_437 var0, double var1, double var3, double var5) {
      v6 = true;

      boolean var8;
      try {
         Boolean var7 = uiSupport230.v1(var0, var1, var3, 0.0, var5);
         var8 = var7 != null ? var7 : var0.method_25401(var1, var3, 0.0, var5);
      } finally {
         v6 = false;
      }

      return var8;
   }

   private static void v3() {
      hudSupport59.v1.v5();
      v3 = null;
      v4 = null;
      v5 = null;
   }
}
