package cc.syky.ui;

import net.minecraft.class_10799;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_1702;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3486;
import net.minecraft.class_3532;

public final class uiSupport186 {
   private static final class_2960 v4 = class_2960.method_60655("syky", "hud/saturation_outline");
   private static final class_2960 v5 = class_2960.method_60655("syky", "hud/saturation_outline_half");
   private static final class_2960 v6 = class_2960.method_60656("hud/food_empty");
   private static final class_2960 v7 = class_2960.method_60656("hud/food_half");
   private static final class_2960 v8 = class_2960.method_60656("hud/food_full");
   private static final class_2960 v9 = class_2960.method_60656("hud/food_empty_hunger");
   private static final class_2960 v10 = class_2960.method_60656("hud/food_half_hunger");
   private static final class_2960 v11 = class_2960.method_60656("hud/food_full_hunger");
   private static final int v12 = 9;
   private static final int v13 = 8;
   private static final int v14 = 10;
   private static final int v15 = 20;
   public static boolean v1 = false;
   public static uiSupport187 v2 = uiSupport187.OUTLINE;
   public static int v3 = -11702;

   private uiSupport186() {
   }

   public static void v1(class_332 var0, class_1657 var1, int var2, int var3) {
      class_1702 var4 = var1.method_7344();
      float var5 = class_3532.method_15363(var4.method_7589(), 0.0F, class_3532.method_15340(var4.method_7586(), 0, 20));
      if (v2 == uiSupport187.BAR) {
         v1(var0, var1, var5, v1(var1, var2), var3);
      } else {
         v1(var0, var5, var2, var3);
      }
   }

   private static void v1(class_332 var0, float var1, int var2, int var3) {
      int var4 = class_3532.method_15386(var1 / 2.0F);

      for (int var5 = 0; var5 < var4; var5++) {
         float var6 = var1 / 2.0F - var5;
         class_2960 var7 = var6 >= 1.0F ? v4 : v5;
         int var8 = var3 - var5 * 8 - 9;
         var0.method_52707(class_10799.field_56883, var7, var8, var2, 9, 9, v3);
      }
   }

   private static void v1(class_332 var0, class_1657 var1, float var2, int var3, int var4) {
      boolean var5 = var1.method_6059(class_1294.field_5903);
      class_2960 var6 = var5 ? v9 : v6;
      class_2960 var7 = var5 ? v10 : v7;
      class_2960 var8 = var5 ? v11 : v8;
      int var9 = class_3532.method_15386(var2 / 2.0F);

      for (int var10 = 0; var10 < var9; var10++) {
         int var11 = var4 - var10 * 8 - 9;
         float var12 = var2 / 2.0F - var10;
         var0.method_52706(class_10799.field_56883, var6, var11, var3, 9, 9);
         var0.method_52706(class_10799.field_56883, var12 >= 1.0F ? var8 : var7, var11, var3, 9, 9);
      }
   }

   private static int v1(class_1657 var0, int var1) {
      boolean var2 = var0.method_5777(class_3486.field_15517) || var0.method_5669() < var0.method_5748();
      return var1 - (var2 ? 20 : 10);
   }
}
