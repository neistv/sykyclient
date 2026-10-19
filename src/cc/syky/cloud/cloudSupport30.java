package cc.syky.cloud;

public final class cloudSupport30 {
   private static final char[] v1 = "0123456789ABCDEF".toCharArray();
   private static final String[] v2 = new String[256];

   private cloudSupport30() {
   }

   public static String v1(int var0) {
      return v2[v2(var0)];
   }

   public static int v2(int var0) {
      int var1 = var0 ^ var0 >>> 8 ^ var0 >>> 16 ^ var0 >>> 24;
      return var1 & 0xFF;
   }

   static {
      for (int var0 = 0; var0 < v2.length; var0++) {
         v2[var0] = new String(new char[]{'0', 'x', v1[var0 >> 4 & 15], v1[var0 & 15]});
      }
   }
}
