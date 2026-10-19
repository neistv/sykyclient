package cc.syky.module.utilities;

import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_332;

public final class utilitiesSupport6 {
   public static boolean v1 = false;
   public static final int[] v2 = new int[EndCrystalSupport.COUNT];
   public static boolean v3 = false;
   private static final int v4 = 128;
   private static final int v5 = 16;

   private utilitiesSupport6() {
   }

   public static void v1(class_332 var0, class_2371<class_1735> var1, boolean var2) {
      if (v1 && var2 == v3) {
         int var3 = 0;

         for (int var4 = var1.size(); var3 < var4; var3++) {
            class_1735 var5 = (class_1735)var1.get(var3);
            if (var5.method_7682()) {
               class_1799 var6 = var5.method_7677();
               EndCrystalSupport var7 = EndCrystalSupport.v1(var6);
               if (var7 != null) {
                  int var8 = v2[var7.v3()];
                  if (var8 >>> 24 != 0) {
                     if (var2 && var8 >>> 24 > 128) {
                        var8 = var8 & 16777215 | -2147483648;
                     }

                     var0.method_25294(var5.field_7873, var5.field_7872, var5.field_7873 + 16, var5.field_7872 + 16, var8);
                  }
               }
            }
         }
      }
   }
}
