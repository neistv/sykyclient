package cc.syky.module.utilities;

import cc.syky.ui.uiSupport155;

public final class utilitiesSupport4 {
   private final StringBuilder v1 = new StringBuilder(8);

   public utilitiesSupport4() {
   }

   public String v1(float var1) {
      int var2 = (int)(Math.max(0.0F, var1) * 100.0F);
      this.v1.setLength(0);
      this.v1.append(var2 / 100).append('.');
      int var3 = var2 % 100;
      if (var3 < 10) {
         this.v1.append('0');
      }

      return this.v1.append(var3).append('s').toString();
   }

   public static int v1(float var0, int var1, int var2, float var3) {
      return !(var3 <= 0.0F) && !(var0 >= var3) ? uiSupport155.v1(var1, var2, 1.0F - Math.max(0.0F, var0) / var3) : var1;
   }
}
