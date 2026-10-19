package cc.syky.internal;

public final class InternalSupport22 {
   public static final int v1 = 12;
   public static final long v2 = 25165824L;
   public static final long v3 = 268435456L;
   public static final int v4 = 2048;
   public static final int v5 = 1024;
   public static final int v6 = 64;
   public static final int v7 = 128;
   public static final int v8 = 240;
   public static final int v9 = 4096;
   public static final long v10 = 4194304L;
   public static final long v11 = 16777216L;
   public static final int v12 = 10;
   public static final int v13 = 100;

   private InternalSupport22() {
   }

   public static int v1(int var0, boolean var1) {
      int var2 = var1 ? 1024 : 2048;
      int var3 = Math.max(128, var0);
      int var4 = (var3 + 64 - 1) / 64 * 64;
      return Math.min(var2, var4);
   }

   public static boolean v1(int var0, int var1, int var2, int var3, boolean var4) {
      if (var1 <= 0) {
         return false;
      } else {
         int var5 = v1(var2, var4);
         int var6 = Math.min(var4 ? 1024 : 2048, Math.max(1, var3));
         return var5 > Math.max(var0, var1) && var1 < var6 ? true : var5 * 2 <= var1 && var1 > 128;
      }
   }

   public static int v1(int var0, int var1, int var2) {
      if (var0 > 0 && var1 > 0 && var2 > 0) {
         int var3 = 0;

         for (int var4 = Math.max(var0, var1); var4 > var2 && var0 >> var3 + 1 >= 1 && var1 >> var3 + 1 >= 1; var4 >>= 1) {
            var3++;
         }

         return var3;
      } else {
         return 0;
      }
   }

   public static int v1(int var0, int var1, int var2, long var3, int var5) {
      int var6 = v1(var1, var2, var5);
      if (var0 > 0 && var3 > 0L) {
         while ((long)var0 * Math.max(1, var1 >> var6) * Math.max(1, var2 >> var6) > var3 && var1 >> var6 + 1 >= 1 && var2 >> var6 + 1 >= 1) {
            var6++;
         }

         return var6;
      } else {
         return var6;
      }
   }

   public static int v1(int var0) {
      return Math.max(1, Math.min(var0, 240));
   }

   public static int v2(int var0, int var1, int var2) {
      if (var0 <= 1) {
         return 1;
      } else {
         int var3 = Math.max(1, 4096 / Math.max(1, var1));
         int var4 = (int)Math.ceil(Math.sqrt(var0));
         return Math.max(1, Math.min(var3, Math.max(var4, 1)));
      }
   }

   public static int v1(int var0, int var1) {
      return var1 <= 0 ? var0 : (var0 + var1 - 1) / var1;
   }

   public static boolean v1(int var0, int var1, int var2, int var3) {
      return (long)var0 * var2 <= 4096L && (long)var1 * var3 <= 4096L;
   }

   public static int v2(int var0) {
      return var0 <= 10 ? 100 : var0;
   }

   public static int[] v1(int[] var0) {
      int[] var1 = new int[var0.length];
      int var2 = 0;

      for (int var3 = 0; var3 < var0.length; var3++) {
         var2 += v2(var0[var3]);
         var1[var3] = var2;
      }

      return var1;
   }

   public static int v1(long var0, int[] var2) {
      int var3 = var2.length;
      if (var3 <= 1) {
         return 0;
      } else {
         int var4 = var2[var3 - 1];
         if (var4 <= 0) {
            return 0;
         } else {
            long var5 = var0 % var4;
            if (var5 < 0L) {
               var5 += var4;
            }

            int var7 = 0;
            int var8 = var3 - 1;

            while (var7 < var8) {
               int var9 = var7 + var8 >>> 1;
               if (var5 < var2[var9]) {
                  var8 = var9;
               } else {
                  var7 = var9 + 1;
               }
            }

            return var7;
         }
      }
   }
}
