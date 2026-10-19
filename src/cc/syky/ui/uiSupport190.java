package cc.syky.ui;

import net.minecraft.class_1657;
import net.minecraft.class_1661;

public final class uiSupport190 {
   private static final int v4 = 9;
   public static boolean v1;
   public static int v2;
   public static boolean v3;

   private uiSupport190() {
   }

   public static boolean v1(class_1657 var0) {
      if (!v1) {
         return false;
      } else {
         class_1661 var1 = var0.method_31548();
         if (!v1(v2, var1.method_67532())) {
            return false;
         } else if (var1.method_7391().method_7960()) {
            return false;
         } else {
            v3 = true;
            return true;
         }
      }
   }

   public static boolean v1(int var0, int var1) {
      return var1 >= 0 && var1 < 9 && (var0 & 1 << var1) != 0;
   }
}
