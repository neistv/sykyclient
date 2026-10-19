package cc.syky.internal;

import java.util.Arrays;

public final class InternalSupport35 {
   public static final int v1 = 1024;
   public static final int v2 = 4096;
   public static final int v3 = 7;
   public static final int v4 = 30000;
   private static final int v6 = 7;
   private static final int v7 = 8;
   private static final int v8 = 4;
   public static final InternalSupport35 v5 = new InternalSupport35(new int[0], new int[0], new int[0], new int[0]);
   private final int[] v9;
   private final int[] v10;
   private final int[] v11;
   private final int[] v12;

   private InternalSupport35(int[] var1, int[] var2, int[] var3, int[] var4) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = var3;
      this.v12 = var4;
   }

   public int[] v1() {
      return this.v9;
   }

   public int[] v2() {
      return this.v10;
   }

   public int[] v3() {
      return this.v11;
   }

   public int[] v4() {
      return this.v12;
   }

   public boolean v5() {
      return this.v10.length == 0 && this.v12.length == 0;
   }

   public static InternalSupport35 v1(int[] var0, int[] var1) {
      int var2 = var0.length / 7;
      int var3 = var1.length / 8;
      if (var2 == 0 && var3 == 0) {
         return v5;
      } else {
         int[] var4 = new int[var2 * 6];

         for (int var5 = 0; var5 < var2; var5++) {
            v3(var0, var5 * 7, var4, var5 * 6);
         }

         int[] var8 = new int[var3 * 6];

         for (int var6 = 0; var6 < var3; var6++) {
            v4(var1, var6 * 8, var8, var6 * 6);
         }

         InternalSupport35.Part1 var9 = v1(var0, 7, var4, var2, true);
         InternalSupport35.Part1 var7 = v1(var1, 8, var8, var3, false);
         return new InternalSupport35(var9.v1, var9.v2, var7.v1, var7.v2);
      }
   }

   private static InternalSupport35.Part1 v1(int[] var0, int var1, int[] var2, int var3, boolean var4) {
      if (var3 == 0) {
         return new InternalSupport35.Part1(new int[0], new int[0]);
      } else {
         int[] var5 = v1(var2, var3);
         int[] var6 = new int[7 * ((var3 + 1024 - 1) / 1024 * 2 + 1)];
         int[] var7 = new int[var6.length / 7 + 1];
         int var8 = 0;

         for (int var9 = 0; var9 < var3; var8++) {
            if ((var8 + 1) * 7 > var6.length) {
               var6 = Arrays.copyOf(var6, var6.length * 2);
               var7 = Arrays.copyOf(var7, var7.length * 2);
            }

            int var10 = var8 * 7;
            var7[var8] = var9;
            int var11 = var5[var9] * 6;
            System.arraycopy(var2, var11, var6, var10, 6);
            int var12 = 1;
            var9++;

            while (var9 < var3 && var12 < 1024 && v1(var6, var10, var2, var5[var9] * 6)) {
               v2(var6, var10, var2, var5[var9] * 6);
               var12++;
               var9++;
            }

            var6[var10 + 6] = var12;
         }

         int[] var19 = new int[var8 * 4096];

         for (int var20 = 0; var20 < var8; var20++) {
            int var21 = var20 * 7;
            int var13 = var6[var21];
            int var14 = var6[var21 + 1];
            int var15 = var6[var21 + 2];

            for (int var16 = 0; var16 < var6[var21 + 6]; var16++) {
               int var17 = var5[var7[var20] + var16] * var1;
               int var18 = var20 * 4096 + var16 * 4;
               if (var4) {
                  v1(var0, var17, var13, var14, var15, var19, var18);
               } else {
                  v2(var0, var17, var13, var14, var15, var19, var18);
               }
            }
         }

         return new InternalSupport35.Part1(var19, Arrays.copyOf(var6, var8 * 7));
      }
   }

   private static int[] v1(int[] var0, int var1) {
      int var2 = Integer.MAX_VALUE;
      int var3 = Integer.MAX_VALUE;
      int var4 = Integer.MAX_VALUE;

      for (int var5 = 0; var5 < var1; var5++) {
         var2 = Math.min(var2, var0[var5 * 6] >> 4);
         var3 = Math.min(var3, var0[var5 * 6 + 1] >> 4);
         var4 = Math.min(var4, var0[var5 * 6 + 2] >> 4);
      }

      long[] var13 = new long[var1];

      for (int var6 = 0; var6 < var1; var6++) {
         long var7 = Math.min((var0[var6 * 6] >> 4) - var2, 524287);
         long var9 = Math.min((var0[var6 * 6 + 1] >> 4) - var3, 255);
         long var11 = Math.min((var0[var6 * 6 + 2] >> 4) - var4, 524287);
         var13[var6] = (var9 << 56 | var11 << 37 | var7 << 18 | var6) ^ Long.MIN_VALUE;
      }

      Arrays.sort(var13);
      int[] var14 = new int[var1];

      for (int var15 = 0; var15 < var1; var15++) {
         var14[var15] = (int)(var13[var15] & 262143L);
      }

      return var14;
   }

   private static boolean v1(int[] var0, int var1, int[] var2, int var3) {
      for (int var4 = 0; var4 < 3; var4++) {
         int var5 = Math.min(var0[var1 + var4], var2[var3 + var4]);
         int var6 = Math.max(var0[var1 + 3 + var4], var2[var3 + 3 + var4]);
         if ((long)var6 - var5 > 30000L) {
            return false;
         }
      }

      return true;
   }

   private static void v2(int[] var0, int var1, int[] var2, int var3) {
      for (int var4 = 0; var4 < 3; var4++) {
         var0[var1 + var4] = Math.min(var0[var1 + var4], var2[var3 + var4]);
         var0[var1 + 3 + var4] = Math.max(var0[var1 + 3 + var4], var2[var3 + 3 + var4]);
      }
   }

   private static void v3(int[] var0, int var1, int[] var2, int var3) {
      int var4 = var0[var1];
      int var5 = var0[var1 + 2];
      int var6 = var0[var1 + 3];
      int var7 = var0[var1 + 4];
      int var8 = var0[var1 + 5];
      int var9 = var0[var1 + 6];
      switch (var4) {
         case 0:
            v1(var2, var3, var5, var8, var6, var5, var9, var7);
            break;
         case 1:
            v1(var2, var3, var6, var5, var8, var7, var5, var9);
            break;
         default:
            v1(var2, var3, var6, var8, var5, var7, var9, var5);
      }
   }

   private static void v1(int[] var0, int var1, int var2, int var3, int var4, int[] var5, int var6) {
      int var7 = var0[var1];
      int var8 = var0[var1 + 1];
      int var9 = var0[var1 + 2];
      int var10;
      int var11;
      int var12;
      switch (var7) {
         case 0:
            var12 = var2;
            var10 = var4;
            var11 = var3;
            break;
         case 1:
            var12 = var3;
            var10 = var2;
            var11 = var4;
            break;
         default:
            var12 = var4;
            var10 = var2;
            var11 = var3;
      }

      var5[var6] = var9 - var12 & 65535 | var7 << 16 | var8 << 18;
      var5[var6 + 1] = var0[var1 + 3] - var10 & 65535 | var0[var1 + 4] - var10 << 16;
      var5[var6 + 2] = var0[var1 + 5] - var11 & 65535 | var0[var1 + 6] - var11 << 16;
   }

   private static void v4(int[] var0, int var1, int[] var2, int var3) {
      int var4 = var0[var1];
      int var5 = var0[var1 + 1];
      int var6 = var0[var1 + 2];
      int var7 = var0[var1 + 3];
      int var8 = var0[var1 + 4];
      v1(
         var2,
         var3,
         var5 - 1,
         var6 - 1,
         var7 - 1,
         var4 == 0 ? var5 + var8 + 1 : var5 + 1,
         var4 == 1 ? var6 + var8 + 1 : var6 + 1,
         var4 == 2 ? var7 + var8 + 1 : var7 + 1
      );
   }

   private static void v2(int[] var0, int var1, int var2, int var3, int var4, int[] var5, int var6) {
      var5[var6] = var0[var1 + 1] - var2 & 65535 | var0[var1 + 2] - var3 << 16;
      var5[var6 + 1] = var0[var1 + 3] - var4 & 65535 | var0[var1 + 4] << 16;
      var5[var6 + 2] = var0[var1] | (var0[var1 + 5] > 0 ? 4 : 0) | (var0[var1 + 6] > 0 ? 8 : 0) | (var0[var1 + 7] & 3) << 4;
   }

   private static void v1(int[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      var0[var1] = var2;
      var0[var1 + 1] = var3;
      var0[var1 + 2] = var4;
      var0[var1 + 3] = var5;
      var0[var1 + 4] = var6;
      var0[var1 + 5] = var7;
   }

   public static final class Part1 {
      public final int[] v1;
      public final int[] v2;

      public Part1(int[] var1, int[] var2) {
         this.v1 = var1;
         this.v2 = var2;
      }
   }
}
