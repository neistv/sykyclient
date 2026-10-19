package cc.syky.hud;

import cc.syky.ui.uiSupport169;

public final class hudSupport16 {
   public static final String[] v1 = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
   private static final char v2 = 's';

   private hudSupport16() {
   }

   public static void v1(StringBuilder var0, long var1) {
      long var3 = Math.max(0L, var1);
      var0.append(var3 / 10L).append('.').append(var3 % 10L).append('s');
   }

   public static void v1(StringBuilder var0, String var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         var0.append(var1);
      }

      var0.append('.').append(var1).append('s');
   }

   public static int v1(long var0) {
      long var2 = var0 > 0L ? var0 / 10L : 0L;

      int var4;
      for (var4 = 1; var2 >= 10L; var4++) {
         var2 /= 10L;
      }

      return var4;
   }

   public static final class Part1 {
      private float v1 = -1.0F;
      private int v2;

      public Part1() {
      }

      public String v1(float var1) {
         if (var1 == this.v1) {
            return hudSupport16.v1[this.v2];
         } else {
            int var2 = 0;
            float var3 = 0.0F;

            for (int var4 = 0; var4 < hudSupport16.v1.length; var4++) {
               float var5 = uiSupport169.v2("syky_sans_strong", hudSupport16.v1[var4], var1);
               if (var5 > var3) {
                  var3 = var5;
                  var2 = var4;
               }
            }

            if (var3 > 0.0F) {
               this.v1 = var1;
               this.v2 = var2;
            }

            return hudSupport16.v1[var2];
         }
      }
   }
}
