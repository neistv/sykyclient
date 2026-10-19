package cc.syky.module.visual;

import cc.syky.ui.uiSupport155;

public final class PingSupport2 {
   private PingSupport2() {
   }

   public static String v1(int var0) {
      return "Ping " + Math.max(0, var0);
   }

   public static int v1(int var0, int var1, int var2, int var3) {
      if (var3 <= 0) {
         return var2;
      } else {
         float var4 = Math.min(1.0F, Math.max(0.0F, (float)var0) / var3);
         float var5 = var4 * var4 * var4;
         return uiSupport155.v1(var1, var2, var5 * var5);
      }
   }
}
