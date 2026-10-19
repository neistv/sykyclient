package cc.syky.hud;

public final class hudSupport19 {
   private static final int v1 = 20;

   private hudSupport19() {
   }

   public static void v1(StringBuilder var0, long var1) {
      if (var1 < 0L) {
         var0.append('-');
      }

      int var5 = var0.length();
      long var6 = var1 > 0L ? -var1 : var1;
      int var8 = 0;

      do {
         if (var8 > 0 && var8 % 3 == 0) {
            var0.append(',');
         }

         var0.append((char)(48 - (int)(var6 % 10L)));
         var8++;
         var6 /= 10L;
      } while (var6 < 0L);

      int var9 = var5;

      for (int var10 = var0.length() - 1; var9 < var10; var10--) {
         char var11 = var0.charAt(var9);
         var0.setCharAt(var9, var0.charAt(var10));
         var0.setCharAt(var10, var11);
         var9++;
      }
   }

   public static String v1(long var0) {
      StringBuilder var2 = new StringBuilder(27);
      v1(var2, var0);
      return var2.toString();
   }
}
