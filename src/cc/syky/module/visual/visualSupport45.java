package cc.syky.module.visual;

import net.minecraft.class_10799;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_329.class_6411;
import org.jetbrains.annotations.Nullable;

public final class visualSupport45 {
   private static final visualSupport54 v13 = visualSupport54.v1(
      "hotbar", "full", "half", "full_blinking", "half_blinking", "hardcore_full", "hardcore_half", "hardcore_full_blinking", "hardcore_half_blinking"
   );
   private static final visualSupport54 v14 = visualSupport54.v1(
      "hotbar_gold",
      "absorbing_full",
      "absorbing_half",
      "absorbing_full_blinking",
      "absorbing_half_blinking",
      "absorbing_hardcore_full",
      "absorbing_hardcore_half",
      "absorbing_hardcore_full_blinking",
      "absorbing_hardcore_half_blinking"
   );
   public static boolean v1 = false;
   public static boolean v2 = false;
   public static boolean v3 = false;
   public static int v4 = -60653;
   public static boolean v5 = false;
   public static int v6 = -2838729;
   public static boolean v7 = true;
   public static boolean v8 = true;
   public static boolean v9 = true;
   public static boolean v10 = true;
   public static boolean v11 = true;
   public static boolean v12 = true;

   private visualSupport45() {
   }

   public static void v1() {
      if (v3) {
         v13.v1(v4);
      }

      if (v5) {
         v14.v1(v6);
      }
   }

   public static class_6411 v1(class_1657 var0, class_6411 var1) {
      if (var1 != class_6411.field_33945 && (!v7 || !v8 || !v9)) {
         if (v7 && var0.method_6059(class_1294.field_5899)) {
            return class_6411.field_33946;
         } else if (v8 && var0.method_6059(class_1294.field_5920)) {
            return class_6411.field_33947;
         } else {
            return v9 && var0.method_32314() ? class_6411.field_33949 : class_6411.field_33945;
         }
      } else {
         return var1;
      }
   }

   public static boolean v1(class_332 var0, class_2960 var1, int var2, int var3, int var4, int var5) {
      visualSupport54.Part3 var6 = v1(var1);
      if (var6 == null) {
         return false;
      } else {
         var0.method_25302(class_10799.field_56883, var6.v1(), var2, var3, 0.0F, 0.0F, var4, var5, var6.v2(), var6.v3(), var6.v2(), var6.v3());
         return true;
      }
   }

   @Nullable
   private static visualSupport54.Part3 v1(class_2960 var0) {
      if (v3) {
         visualSupport54.Part3 var1 = v13.v1(var0);
         if (var1 != null) {
            return var1;
         }
      }

      return v5 ? v14.v1(var0) : null;
   }
}
