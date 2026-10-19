package cc.syky.cloud;

public final class AttestationKey {
   private static final byte[] v1 = new byte[]{
      -74, -85, 12, 43, -84, 25, -7, 3, 89, -113, -102, 78, 53, 6, 60, 100, 39, 78, -79, -54, 27, 79, -127, 86, 65, -10, -44, -94, -81, 103, 59, -19
   };
   private static final byte[] v2 = new byte[]{
      78, 27, 67, 16, -92, -99, 109, 5, -35, 121, -75, -127, 13, -59, 72, 98, 77, -103, -52, -101, 29, -102, 3, 75, -22, 64, 105, 45, 115, -108, -42, -44
   };

   private AttestationKey() {
   }

   public static byte[] v1() {
      byte[] var0 = new byte[v1.length];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = (byte)(v1[var1] ^ v2[var1]);
      }

      return var0;
   }
}
