package cc.syky.module.visual;

import cc.syky.config.configSupport14;
import cc.syky.config.configSupport15;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;

public final class visualSupport36 {
   public static final int v1 = 1056964607;
   public static final float v2 = 3.0F;
   public static final float v3 = 0.95F;
   public static boolean v4;
   public static boolean v5;
   public static float v6 = 1.0F;
   public static float v7;
   public static boolean v8 = true;
   public static int v9 = 1056964607;
   public static float v10 = 0.4F;
   private static final configSupport15 v11 = new configSupport15(0.7F);
   private static final long v12 = 2200000000L;
   private static long v13;

   private visualSupport36() {
   }

   public static void v1() {
      v11.v1();
   }

   public static void v2() {
      v11.v2();
   }

   public static void v3() {
      if (!v5) {
         v13 = 0L;
      } else {
         long var0 = System.nanoTime();
         if (v13 == 0L || var0 - v13 >= 2200000000L) {
            class_310 var2 = class_310.method_1551();
            if (var2 != null && var2.field_1724 != null && var2.field_1687 != null && var2.field_1773 != null) {
               v13 = var0;
               var2.field_1773.method_3189(new class_1799(class_1802.field_8288));
            }
         }
      }
   }

   public static float v4() {
      return !v4 && !v5 ? 1.0F : v6;
   }

   public static float v1(float var0) {
      return !v4 && !v5 ? 0.0F : v7 * -var0;
   }

   public static void v5() {
      if ((v4 || v5) && v8) {
         configSupport14.v1(v9, v11.v3(), v10);
      }
   }
}
