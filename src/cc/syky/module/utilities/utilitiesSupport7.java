package cc.syky.module.utilities;

import net.minecraft.class_10799;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_9288;
import net.minecraft.class_9334;

public final class utilitiesSupport7 {
   public static boolean v1 = false;
   private static final class_2960 v2 = class_2960.method_60656("container/bundle/slot_background");
   private static final int v3 = 9;
   private static final int v4 = 18;
   private static final int v5 = 1;
   private static final int v6 = 3;
   private static final int v7 = 12;
   private static final int v8 = 4;
   private static final int v9 = -535949804;
   private static final int v10 = 1090519039;
   private static final class_2371<class_1799> v11 = class_2371.method_10213(27, class_1799.field_8037);

   private utilitiesSupport7() {
   }

   public static void v1(class_332 var0, class_1799 var1, int var2, int var3) {
      if (v1 && !var1.method_7960()) {
         class_9288 var4 = (class_9288)var1.method_58694(class_9334.field_49622);
         if (var4 != null) {
            var4.method_57492(v11);
            int var5 = -1;

            for (int var6 = v11.size() - 1; var6 >= 0; var6--) {
               if (!((class_1799)v11.get(var6)).method_7960()) {
                  var5 = var6;
                  break;
               }
            }

            if (var5 >= 0) {
               int var21 = var5 + 1;
               int var7 = (var21 + 9 - 1) / 9;
               short var8 = 168;
               int var9 = var7 * 18 + 6;
               int var10 = var0.method_51421();
               int var11 = var0.method_51443();
               int var12 = var2 - var8 / 2;
               int var13 = var3 - var9 - 12;
               if (var13 < 4) {
                  var13 = var3 + 12 + 8;
               }

               var12 = class_3532.method_15340(var12, 4, var10 - var8 - 4);
               var13 = class_3532.method_15340(var13, 4, var11 - var9 - 4);
               var0.method_25294(var12, var13, var12 + var8, var13 + var9, -535949804);
               v1(var0, var12, var13, var8, var9);
               int var14 = var12 + 3;
               int var15 = var13 + 3;
               class_327 var16 = class_310.method_1551().field_1772;

               for (int var17 = 0; var17 <= var5; var17++) {
                  int var18 = var14 + var17 % 9 * 18;
                  int var19 = var15 + var17 / 9 * 18;
                  var0.method_52706(class_10799.field_56883, v2, var18, var19, 18, 18);
                  class_1799 var20 = (class_1799)v11.get(var17);
                  if (!var20.method_7960()) {
                     var0.method_51427(var20, var18 + 1, var19 + 1);
                     var0.method_51431(var16, var20, var18 + 1, var19 + 1);
                  }
               }
            }
         }
      }
   }

   private static void v1(class_332 var0, int var1, int var2, int var3, int var4) {
      var0.method_25294(var1, var2, var1 + var3, var2 + 1, 1090519039);
      var0.method_25294(var1, var2 + var4 - 1, var1 + var3, var2 + var4, 1090519039);
      var0.method_25294(var1, var2 + 1, var1 + 1, var2 + var4 - 1, 1090519039);
      var0.method_25294(var1 + var3 - 1, var2 + 1, var1 + var3, var2 + var4 - 1, 1090519039);
   }
}
