package cc.syky.account;

public final class accountSupport10 {
   private accountSupport10() {
   }

   public static float v1(float var0, float var1, float var2, float var3) {
      if (var1 >= var2) {
         return 0.0F;
      } else {
         float var4;
         if (var0 < 0.0F) {
            var4 = -var0;
         } else {
            if (!(var0 + var1 > var2)) {
               return 0.0F;
            }

            var4 = var2 - (var0 + var1);
         }

         if ((var2 - var1) * var3 < 1.0F) {
            return var4;
         } else {
            float var5 = var4 * var3;
            var5 = var4 > 0.0F ? (float)Math.ceil(var5) : (float)Math.floor(var5);
            return var5 / var3;
         }
      }
   }
}
