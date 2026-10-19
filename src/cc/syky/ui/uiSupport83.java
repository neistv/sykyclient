package cc.syky.ui;

public final class uiSupport83 {
   public static final int v1 = -1;
   private static final char[] v2 = "0123456789ABCDEF".toCharArray();
   private static final String[] v3 = new String[101];

   private uiSupport83() {
   }

   public static String v1(int var0) {
      char[] var1 = new char[7];
      var1[0] = '#';

      for (int var2 = 0; var2 < 6; var2++) {
         var1[6 - var2] = v2[var0 >>> var2 * 4 & 15];
      }

      return new String(var1);
   }

   public static String v2(int var0) {
      int var1 = var0 >>> 24 & 0xFF;
      if (var1 == 255) {
         return v1(var0);
      } else {
         char[] var2 = new char[9];
         var2[0] = '#';

         for (int var3 = 0; var3 < 6; var3++) {
            var2[6 - var3] = v2[var0 >>> var3 * 4 & 15];
         }

         var2[7] = v2[var1 >>> 4 & 15];
         var2[8] = v2[var1 & 15];
         return new String(var2);
      }
   }

   public static String v3(int var0) {
      return v3[Math.round(var0 * 100.0F / 255.0F)];
   }

   public static int v4(int var0) {
      return Math.round(var0 * 255.0F / 100.0F);
   }

   public static int v1(String var0) {
      String var1 = v4(var0);

      return switch (var1.length()) {
         case 3 -> v5(var1);
         case 6, 8 -> (int)Long.parseLong(var1.substring(0, 6), 16);
         default -> -1;
      };
   }

   public static int v2(String var0) {
      String var1 = v4(var0);
      return var1.length() == 8 ? (int)Long.parseLong(var1.substring(6), 16) : -1;
   }

   public static int v3(String var0) {
      int var1 = 0;
      boolean var2 = false;

      for (int var3 = 0; var3 < var0.length(); var3++) {
         char var4 = var0.charAt(var3);
         if (var4 >= '0' && var4 <= '9') {
            var1 = Math.min(1000, var1 * 10 + (var4 - '0'));
            var2 = true;
         } else if (var4 != '%' && var4 != ' ') {
            return -1;
         }
      }

      return var2 ? Math.min(100, var1) : -1;
   }

   private static String v4(String var0) {
      StringBuilder var1 = new StringBuilder(8);

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         if (Character.digit(var3, 16) >= 0) {
            var1.append(var3);
         } else if (var3 != '#') {
            return "";
         }
      }

      return var1.toString();
   }

   private static int v5(String var0) {
      int var1 = Character.digit(var0.charAt(0), 16);
      int var2 = Character.digit(var0.charAt(1), 16);
      int var3 = Character.digit(var0.charAt(2), 16);
      return var1 * 17 << 16 | var2 * 17 << 8 | var3 * 17;
   }

   static {
      for (int var0 = 0; var0 < v3.length; var0++) {
         v3[var0] = var0 + "%";
      }
   }
}
