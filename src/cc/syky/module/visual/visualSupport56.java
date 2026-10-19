package cc.syky.module.visual;

import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleOpenHashMap;

public final class visualSupport56 {
   private static final Int2DoubleMap v1 = new Int2DoubleOpenHashMap();

   private visualSupport56() {
   }

   public static void v1() {
      v1.clear();
   }

   public static void v1(int var0, double var1) {
      double var3 = v1.get(var0);
      if (Double.isNaN(var3) || var1 > var3) {
         v1.put(var0, var1);
      }
   }

   public static double v2(int var0, double var1) {
      double var3 = v1.get(var0);
      return Double.isNaN(var3) ? var1 : var3;
   }

   static {
      v1.defaultReturnValue(Double.NaN);
   }
}
