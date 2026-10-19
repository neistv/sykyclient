package cc.syky.module.visual;

import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_6880;
import net.minecraft.class_746;

public final class visualSupport44 {
   private static final long v1 = 1500000000L;
   private static final long v2 = 250000000L;
   private static final double v3 = 16.0;
   private static final double v4 = 6.25;
   private static boolean v5;
   private static boolean v6;
   private static int v7 = -1;
   private static boolean v8;
   private static int v9 = -1;
   private static long v10;
   private static double v11;
   private static double v12;
   private static double v13;
   private static int v14 = -1;
   private static long v15;
   private static double v16;
   private static double v18;
   private static double v19;
   private static boolean v17;

   private visualSupport44() {
   }

   public static void v1(boolean var0, boolean var1) {
      boolean var2 = var0 && var1;
      if (v6 && !var2) {
         v2();
      }

      v5 = var0;
      v6 = var2;
   }

   public static void v1(int var0, boolean var1) {
      v7 = var0;
      v8 = var1;
   }

   public static boolean v1(class_1297 var0) {
      return v5 && var0.method_5628() == v7 && !v8;
   }

   public static boolean v2(class_1297 var0) {
      return v6 && v1(var0);
   }

   public static void v1(class_1297 var0, class_1297 var1) {
      int var2 = var0.method_5628();
      if (v2(var0)) {
         v9 = var2;
         v10 = System.nanoTime() + 1500000000L;
         v11 = var1.method_23317();
         v12 = var1.method_23318();
         v13 = var1.method_23321();
      } else if (v9 == var2) {
         v9 = -1;
      }
   }

   public static boolean v1(class_1297 var0, class_1282 var1) {
      long var2 = System.nanoTime();
      boolean var4 = v6 && var1.method_5529() instanceof class_746 && var0.method_5628() == v9 && var2 <= v10;
      v17 = var4;
      if (!var4) {
         return false;
      } else {
         v9 = -1;
         v14 = var0.method_5628();
         v15 = var2 + 250000000L;
         v16 = var0.method_23317();
         v18 = var0.method_23318() + var0.method_17682() * 0.5;
         v19 = var0.method_23321();
         return true;
      }
   }

   public static boolean v1() {
      boolean var0 = v17;
      v17 = false;
      return var0;
   }

   public static boolean v1(int var0) {
      return var0 == v14 && System.nanoTime() <= v15;
   }

   public static boolean v1(class_6880<class_3414> var0, double var1, double var3, double var5) {
      if (!v6) {
         return false;
      } else {
         long var7 = System.nanoTime();
         boolean var9 = v9 >= 0 && var7 <= v10;
         boolean var10 = v14 >= 0 && var7 <= v15;
         if (!var9 && !var10) {
            return false;
         } else {
            return v1((class_3414)var0.comp_349()) && v1(var1, var3, var5, v11, v12, v13) <= 16.0 ? true : var10 && v1(var1, var3, var5, v16, v18, v19) <= 6.25;
         }
      }
   }

   public static boolean v1(class_2394 var0, double var1, double var3, double var5) {
      if (v6 && v14 >= 0 && System.nanoTime() <= v15) {
         boolean var7 = var0.method_10295() == class_2398.field_11209 || var0.method_10295() == class_2398.field_11227;
         return var7 && v1(var1, var3, var5, v16, v18, v19) <= 16.0;
      } else {
         return false;
      }
   }

   public static boolean v3(class_1297 var0) {
      return v6 && v1(var0.method_5628());
   }

   public static void v2() {
      v7 = -1;
      v9 = -1;
      v14 = -1;
      v17 = false;
   }

   private static boolean v1(class_3414 var0) {
      return var0 == class_3417.field_14999
         || var0 == class_3417.field_14840
         || var0 == class_3417.field_15016
         || var0 == class_3417.field_14625
         || var0 == class_3417.field_14706;
   }

   private static double v1(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = var0 - var6;
      double var14 = var2 - var8;
      double var16 = var4 - var10;
      return var12 * var12 + var14 * var14 + var16 * var16;
   }
}
