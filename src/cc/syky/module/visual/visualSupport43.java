package cc.syky.module.visual;

public final class visualSupport43 {
   private visualSupport43() {
   }

   public static double v1(int var0) {
      return 1.0 - Math.max(0, Math.min(100, var0)) / 100.0;
   }

   public static boolean v1(
      double var0,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22
   ) {
      double var24 = 0.0;
      double var26 = Double.POSITIVE_INFINITY;

      for (int var28 = 0; var28 < 3; var28++) {
         double var29 = var28 == 0 ? var0 : (var28 == 1 ? var2 : var4);
         double var31 = var28 == 0 ? var6 : (var28 == 1 ? var8 : var10);
         double var33 = var28 == 0 ? var12 : (var28 == 1 ? var14 : var16);
         double var35 = var28 == 0 ? var18 : (var28 == 1 ? var20 : var22);
         if (var31 == 0.0) {
            if (var29 < var33 || var29 > var35) {
               return false;
            }
         } else {
            double var37 = (var33 - var29) / var31;
            double var39 = (var35 - var29) / var31;
            var24 = Math.max(var24, Math.min(var37, var39));
            var26 = Math.min(var26, Math.max(var37, var39));
            if (var24 > var26) {
               return false;
            }
         }
      }

      return true;
   }
}
