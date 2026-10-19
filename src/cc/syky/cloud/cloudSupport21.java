package cc.syky.cloud;

import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_3675;

public final class cloudSupport21 {
   private cloudSupport21() {
   }

   public static int v1() {
      class_1041 var0 = class_310.method_1551().method_22683();
      byte var1 = 0;
      if (v1(var0, 340) || v1(var0, 344)) {
         var1 |= 1;
      }

      if (v1(var0, 341) || v1(var0, 345)) {
         var1 |= 2;
      }

      if (v1(var0, 342) || v1(var0, 346)) {
         var1 |= 4;
      }

      if (v1(var0, 343) || v1(var0, 347)) {
         var1 |= 8;
      }

      return var1;
   }

   private static boolean v1(class_1041 var0, int var1) {
      return class_3675.method_15987(var0, var1);
   }
}
