package cc.syky.ui;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.jetbrains.annotations.Nullable;

public final class uiSupport142 {
   @Nullable
   public static uiSupport141 v1;
   public static final double v2 = -1000000.0;

   private uiSupport142() {
   }

   public static double v1(class_310 var0) {
      return class_312.method_68880(var0.method_22683(), var0.field_1729.method_1603());
   }

   public static double v2(class_310 var0) {
      return class_312.method_68884(var0.method_22683(), var0.field_1729.method_1604());
   }

   public static void v1(class_310 var0, uiSupport141 var1) {
      v1 = var1;
      if (var0.field_1755 == null) {
         var0.method_1507(var1);
      } else {
         class_1041 var2 = var0.method_22683();
         var1.method_25423(var2.method_4486(), var2.method_4502());
      }
   }

   public static void v3(class_310 var0) {
      uiSupport141 var1 = v1;
      if (var1 != null) {
         v1 = null;
         uiSupport139.v6();
         var1.v1();
         if (var0.field_1755 == var1) {
            var0.method_1507(null);
         }
      }
   }

   public static void v4(class_310 var0) {
      uiSupport141 var1 = v1;
      if (var1 != null && var0.field_1755 == null && var0.field_1687 != null) {
         var0.method_1507(var1);
      }
   }

   public static void v1(class_310 var0, float var1) {
      uiSupport141 var2 = v1;
      if (var2 != null) {
         if (var2 != var0.field_1755) {
            class_1041 var3 = var0.method_22683();
            int var4 = var3.method_4486();
            int var5 = var3.method_4502();
            if (var2.field_22789 != var4 || var2.field_22790 != var5) {
               var2.method_25410(var4, var5);
            }
         }

         var2.v1((int)v1(var0), (int)v2(var0), var1);
      }
   }
}
