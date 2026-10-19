package cc.syky.ui;

public final class uiSupport174 {
   private uiSupport174() {
   }

   public static double v1(double var0, double var2) {
      double var4 = Math.abs(var2);
      double var6 = Math.abs(var0);
      double var8 = Math.max(var4, var6);
      if (var8 == 0.0) {
         return 0.0;
      } else {
         double var10 = Math.min(var4, var6) / var8;
         double var12 = var10 * var10;
         double var14 = (
                  ((((-0.004054058 * var12 + 0.0218612288) * var12 - 0.0559098861) * var12 + 0.0964200441) * var12 - 0.1390853351) * var12 + 0.1994653599
               )
               * var12
            - 0.3332985605;
         var14 = var10 + var10 * var12 * var14;
         if (var6 > var4) {
            var14 = (Math.PI / 2) - var14;
         }

         if (var2 < 0.0) {
            var14 = Math.PI - var14;
         }

         return var0 < 0.0 ? -var14 : var14;
      }
   }
}
