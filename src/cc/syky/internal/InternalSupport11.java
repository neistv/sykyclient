package cc.syky.internal;

import java.util.Arrays;

public final class InternalSupport11 {
   public static final int v1 = 7;
   public static final int v2 = 8;
   public static final int v3 = 1;
   public static final int v4 = 2;
   public static final InternalSupport11 v5 = new InternalSupport11(new int[0], new int[0], 0, 0, 0, 0, 0, 0);
   private static final int[][] v6 = new int[][]{{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
   private static final int v7 = 3;
   private final int[] v8;
   private final int[] v9;
   private final int v10;
   private final int v11;
   private final int v12;
   private final int v13;
   private final int v14;
   private final int v15;

   private InternalSupport11(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.v8 = var1;
      this.v9 = var2;
      this.v10 = var3;
      this.v11 = var4;
      this.v12 = var5;
      this.v13 = var6;
      this.v14 = var7;
      this.v15 = var8;
   }

   public int[] v1() {
      return this.v8;
   }

   public int[] v2() {
      return this.v9;
   }

   public int v3() {
      return this.v8.length / 7;
   }

   public int v4() {
      return this.v9.length / 8;
   }

   public int v5() {
      return this.v10;
   }

   public int v6() {
      return this.v11;
   }

   public int v7() {
      return this.v12;
   }

   public int v8() {
      return this.v13;
   }

   public int v9() {
      return this.v14;
   }

   public int v10() {
      return this.v15;
   }

   public static InternalSupport11 v1(InternalSupport10 var0) {
      long[] var1 = new long[var0.v1()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = var0.v1(var2);
      }

      return v1(var1, false);
   }

   public static InternalSupport11 v1(long[] var0) {
      long[] var1 = (long[])var0.clone();
      Arrays.sort(var1);
      int var2 = 0;

      for (int var3 = 0; var3 < var1.length; var3++) {
         if (var3 == 0 || var1[var3] != var1[var3 - 1]) {
            var1[var2++] = var1[var3];
         }
      }

      return v1(Arrays.copyOf(var1, var2), true);
   }

   private static InternalSupport11 v1(long[] var0, boolean var1) {
      if (var0.length == 0) {
         return v5;
      } else {
         int var2 = var0.length;
         int var3 = Integer.MAX_VALUE;
         int var4 = Integer.MAX_VALUE;
         int var5 = Integer.MAX_VALUE;
         int var6 = Integer.MIN_VALUE;
         int var7 = Integer.MIN_VALUE;
         int var8 = Integer.MIN_VALUE;

         for (int var9 = 0; var9 < var2; var9++) {
            long var10 = var0[var9];
            int var12 = InternalSupport10.v1(var10);
            int var13 = InternalSupport10.v3(var10);
            int var14 = InternalSupport10.v2(var10);
            var3 = Math.min(var3, var12);
            var4 = Math.min(var4, var13);
            var5 = Math.min(var5, var14);
            var6 = Math.max(var6, var12 + 1);
            var7 = Math.max(var7, var13 + 1);
            var8 = Math.max(var8, var14 + 1);
         }

         InternalSupport11.Part4 var24 = InternalSupport11.Part4.v1(var0, var3, var4, var5, var6, var7, var8);
         InternalSupport11.Part5[] var25 = new InternalSupport11.Part5[6];
         InternalSupport11.Part5[] var11 = new InternalSupport11.Part5[12];

         for (int var26 = 0; var26 < 6; var26++) {
            var25[var26] = new InternalSupport11.Part5();
         }

         for (int var27 = 0; var27 < 12; var27++) {
            var11[var27] = new InternalSupport11.Part5();
         }

         int[] var28 = new int[3];
         int[] var29 = new int[3];
         boolean[] var30 = new boolean[4];
         int var15 = var1 ? 3 : 0;
         int var16 = var1 ? 3 : 5;

         for (int var17 = 0; var17 < var2; var17++) {
            long var18 = var0[var17];
            var28[0] = InternalSupport10.v1(var18);
            var28[1] = InternalSupport10.v3(var18);
            var28[2] = InternalSupport10.v2(var18);

            for (int var20 = var15; var20 <= var16; var20++) {
               int[] var21 = v6[var20];
               if (!var24.v1(var28[0] + var21[0], var28[1] + var21[1], var28[2] + var21[2])) {
                  int var22 = var20 >> 1;
                  int var23 = var28[var22] + (var20 & 1);
                  var25[var20].v1(v1(var22, var23, var28));
               }
            }

            for (int var34 = 0; var34 < 3; var34++) {
               if (!var1 || var34 != 1) {
                  v1(var24, var34, var28, var29, var30, var11, var1);
               }
            }
         }

         InternalSupport11.Part1 var31 = new InternalSupport11.Part1(7);

         for (int var32 = 0; var32 < 6; var32++) {
            v1(var32 >> 1, var32 & 1, var25[var32], var31);
         }

         InternalSupport11.Part1 var33 = new InternalSupport11.Part1(8);

         for (int var19 = 0; var19 < 12; var19++) {
            v1(var24, var19, var11[var19], var33);
         }

         return new InternalSupport11(var31.v1(), var33.v1(), var3, var4, var5, var6, var7, var8);
      }
   }

   private static long v1(int var0, int var1, int[] var2) {
      return switch (var0) {
         case 0 -> v1(var1, 26, var2[1], 12, var2[2], 26);
         case 1 -> v1(var1, 12, var2[2], 26, var2[0], 26);
         default -> v1(var1, 26, var2[1], 12, var2[0], 26);
      };
   }

   private static void v1(int var0, int var1, InternalSupport11.Part5 var2, InternalSupport11.Part1 var3) {
      if (var2.v2 != 0) {
         long[] var4 = var2.v1();
         int var5 = var0 == 1 ? 12 : 26;
         int var6 = var0 == 1 ? 26 : 12;
         InternalSupport11.Part1 var7 = new InternalSupport11.Part1(3);
         InternalSupport11.Part1 var8 = new InternalSupport11.Part1(3);
         int var9 = 0;
         int var10 = 0;
         byte var11 = 0;
         int var12 = 0;

         while (var12 < var4.length) {
            long var13 = var4[var12];
            int var15 = var12 + 1;

            while (var15 < var4.length && var4[var15] == var4[var15 - 1] + 1L) {
               var15++;
            }

            int var16 = v1(var13, 26 + var6, var5);
            int var17 = v1(var13, 26, var6);
            int var18 = v1(var13, 0, 26);
            int var19 = var18 + (var15 - var12);
            if (var12 == 0 || var16 != var9 || var17 != var10) {
               boolean var20 = var12 != 0 && var16 == var9 && var17 == var10 + 1;
               InternalSupport11.Part1 var21 = var7;
               var7 = var8;
               var8 = var21;
               var21.v2 = 0;
               if (!var20) {
                  var7.v2 = 0;
               }

               var9 = var16;
               var10 = var17;
               var11 = 0;
            }

            while (var11 < var7.v2 && var7.v1[var11] < var18) {
               var11 += 3;
            }

            int var22;
            if (var11 < var7.v2 && var7.v1[var11] == var18 && var7.v1[var11 + 1] == var19) {
               var22 = var7.v1[var11 + 2];
               var3.v1[var22 + 6] = var17 + 1;
            } else {
               var22 = var3.v2;
               var3.v1(var0, var1, var9, var18, var19, var17, var17 + 1);
            }

            var8.v1(var18, var19, var22);
            var12 = var15;
         }
      }
   }

   private static void v1(InternalSupport11.Part4 var0, int var1, int[] var2, int[] var3, boolean[] var4, InternalSupport11.Part5[] var5, boolean var6) {
      int var7 = var1 == 0 ? 1 : 0;
      int var8 = var1 == 2 ? 1 : 2;

      for (int var9 = 0; var9 < 2; var9++) {
         for (int var10 = 0; var10 < 2; var10++) {
            int var11 = var2[var7] + var9;
            int var12 = var2[var8] + var10;
            int var13 = (1 - var9) * 2 + (1 - var10);
            int var14 = 0;
            int var15 = -1;

            for (int var16 = 0; var16 < 4; var16++) {
               var3[var1] = var2[var1];
               var3[var7] = var11 - 1 + (var16 >> 1);
               var3[var8] = var12 - 1 + (var16 & 1);
               var4[var16] = var16 == var13 || var0.v1(var3[0], var3[1], var3[2]);
               if (var4[var16]) {
                  var14++;
                  if (var15 < 0) {
                     var15 = var16;
                  }
               }
            }

            if (var15 == var13) {
               int var17;
               int var20;
               if (var14 == 1) {
                  var20 = var13;
                  var17 = -1;
               } else if (var14 == 3) {
                  int var18 = 0;

                  while (var4[var18]) {
                     var18++;
                  }

                  var20 = var18 ^ 3;
                  var17 = -1;
               } else {
                  if (var14 != 2 || !var4[3 - var13]) {
                     continue;
                  }

                  var20 = var13;
                  var17 = 3 - var13;
               }

               var3[var1] = var2[var1];
               var3[var7] = var11;
               var3[var8] = var12;
               long var21 = v1(var1, var3);
               if (!var6 || v1(var1, var20)) {
                  var5[var1 * 4 + var20].v1(var21);
               }

               if (var17 >= 0 && (!var6 || v1(var1, var17))) {
                  var5[var1 * 4 + var17].v1(var21);
               }
            }
         }
      }
   }

   private static boolean v1(int var0, int var1) {
      return (var0 == 0 ? var1 >> 1 : var1 & 1) == 0;
   }

   private static long v1(int var0, int[] var1) {
      return switch (var0) {
         case 0 -> v1(var1[1], 12, var1[2], 26, var1[0], 26);
         case 1 -> v1(var1[0], 26, var1[2], 26, var1[1], 12);
         default -> v1(var1[1], 12, var1[0], 26, var1[2], 26);
      };
   }

   private static void v1(InternalSupport11.Part4 var0, int var1, InternalSupport11.Part5 var2, InternalSupport11.Part1 var3) {
      if (var2.v2 != 0) {
         int var4 = var1 / 4;
         int var5 = var1 % 4;
         int var6 = var5 >> 1 == 0 ? -1 : 1;
         int var7 = (var5 & 1) == 0 ? -1 : 1;
         int var8 = var4 == 0 ? 1 : 0;
         int var9 = var4 == 2 ? 1 : 2;
         int[] var10 = new int[3];
         long[] var11 = var2.v1();
         int var12 = 0;

         while (var12 < var11.length) {
            long var13 = var11[var12];
            int var15 = var12 + 1;

            while (var15 < var11.length && var11[var15] == var11[var15 - 1] + 1L) {
               var15++;
            }

            int var16;
            int var17;
            int var18;
            switch (var4) {
               case 0:
                  var17 = v1(var13, 52, 12);
                  var18 = v1(var13, 26, 26);
                  var16 = v1(var13, 0, 26);
                  break;
               case 1:
                  var16 = v1(var13, 38, 26);
                  var18 = v1(var13, 12, 26);
                  var17 = v1(var13, 0, 12);
                  break;
               default:
                  var17 = v1(var13, 52, 12);
                  var16 = v1(var13, 26, 26);
                  var18 = v1(var13, 0, 26);
            }

            int var19 = var15 - var12;
            var10[0] = var16;
            var10[1] = var17;
            var10[2] = var18;
            var10[var8] += var6 < 0 ? -1 : 0;
            var10[var9] += var7 < 0 ? -1 : 0;
            int var20 = var10[var4];
            int var21 = (v1(var0, var10, var4, var20 - 1) ? 1 : 0) | (v1(var0, var10, var4, var20 + var19) ? 2 : 0);
            var3.v1(var4, var16, var17, var18, var19, var6, var7, var21);
            var12 = var15;
         }
      }
   }

   private static boolean v1(InternalSupport11.Part4 var0, int[] var1, int var2, int var3) {
      int var4 = var1[var2];
      var1[var2] = var3;
      boolean var5 = var0.v1(var1[0], var1[1], var1[2]);
      var1[var2] = var4;
      return var5;
   }

   private static long v1(int var0, int var1, int var2, int var3, int var4, int var5) {
      long var6 = var0 + (1L << var1 - 1);
      long var8 = var2 + (1L << var3 - 1);
      long var10 = var4 + (1L << var5 - 1);
      return (var6 << var3 + var5 | var8 << var5 | var10) ^ Long.MIN_VALUE;
   }

   private static int v1(long var0, int var2, int var3) {
      long var4 = (var0 ^ Long.MIN_VALUE) >>> var2 & (1L << var3) - 1L;
      return (int)(var4 - (1L << var3 - 1));
   }

   public static final class Part1 {
      public int[] v1;
      public int v2;

      public Part1(int var1) {
         this.v1 = new int[var1 * 16];
      }

      private void v1(int var1) {
         if (this.v2 + var1 > this.v1.length) {
            this.v1 = Arrays.copyOf(this.v1, Math.max(this.v1.length * 2, this.v2 + var1));
         }
      }

      public void v1(int var1, int var2, int var3) {
         this.v1(3);
         this.v1[this.v2++] = var1;
         this.v1[this.v2++] = var2;
         this.v1[this.v2++] = var3;
      }

      public void v1(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
         this.v1(7);
         this.v1[this.v2++] = var1;
         this.v1[this.v2++] = var2;
         this.v1[this.v2++] = var3;
         this.v1[this.v2++] = var4;
         this.v1[this.v2++] = var5;
         this.v1[this.v2++] = var6;
         this.v1[this.v2++] = var7;
      }

      public void v1(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
         this.v1(var1, var2, var3, var4, var5, var6, var7);
         this.v1(1);
         this.v1[this.v2++] = var8;
      }

      public int[] v1() {
         return Arrays.copyOf(this.v1, this.v2);
      }
   }

   public static final class Part2 extends InternalSupport11.Part4 {
      private final long[] v1;
      private final int v2;

      public Part2(long[] var1) {
         int var2 = Integer.highestOneBit(Math.max(4, var1.length * 2 - 1)) << 1;
         this.v1 = new long[var2];
         this.v2 = var2 - 1;

         for (long var6 : var1) {
            int var8 = this.v1(var6);

            while (this.v1[var8] != 0L) {
               var8 = var8 + 1 & this.v2;
            }

            this.v1[var8] = var6;
         }
      }

      private int v1(long var1) {
         return (int)(var1 * -7046029254386353131L >>> 40) & this.v2;
      }

      @Override
      public boolean v1(int var1, int var2, int var3) {
         long var4 = InternalSupport10.v1(var1, var2, var3);
         int var6 = this.v1(var4);

         while (true) {
            long var7 = this.v1[var6];
            if (var7 == var4) {
               return true;
            }

            if (var7 == 0L) {
               return false;
            }

            var6 = var6 + 1 & this.v2;
         }
      }
   }

   public static final class Part3 extends InternalSupport11.Part4 {
      private final long[] v1;
      private final int v2;
      private final int v3;
      private final int v4;
      private final int v5;
      private final int v6;
      private final int v7;

      public Part3(long[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
         this.v2 = var2;
         this.v3 = var3;
         this.v4 = var4;
         this.v5 = var5;
         this.v6 = var6;
         this.v7 = var7;
         this.v1 = new long[(int)((long)var5 * var6 * var7 + 63L >>> 6)];

         for (long var11 : var1) {
            int var13 = ((InternalSupport10.v3(var11) - var3) * var7 + (InternalSupport10.v2(var11) - var4)) * var5 + (InternalSupport10.v1(var11) - var2);
            this.v1[var13 >>> 6] = this.v1[var13 >>> 6] | 1L << var13;
         }
      }

      @Override
      public boolean v1(int var1, int var2, int var3) {
         int var4 = var1 - this.v2;
         int var5 = var2 - this.v3;
         int var6 = var3 - this.v4;
         if (var4 >= 0 && var5 >= 0 && var6 >= 0 && var4 < this.v5 && var5 < this.v6 && var6 < this.v7) {
            int var7 = (var5 * this.v7 + var6) * this.v5 + var4;
            return (this.v1[var7 >>> 6] & 1L << var7) != 0L;
         } else {
            return false;
         }
      }
   }

   public abstract static class Part4 {
      private static final long v1 = 16777216L;

      public Part4() {
      }

      public abstract boolean v1(int var1, int var2, int var3);

      public static InternalSupport11.Part4 v1(long[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
         long var7 = (long)var4 - var1 + 2L;
         long var9 = (long)var5 - var2 + 2L;
         long var11 = (long)var6 - var3 + 2L;
         return (InternalSupport11.Part4)(var7 * var9 * var11 <= 16777216L
            ? new InternalSupport11.Part3(var0, var1 - 1, var2 - 1, var3 - 1, (int)var7, (int)var9, (int)var11)
            : new InternalSupport11.Part2(var0));
      }
   }

   public static final class Part5 {
      private long[] v1 = new long[16];
      public int v2;

      public Part5() {
      }

      public void v1(long var1) {
         if (this.v2 == this.v1.length) {
            this.v1 = Arrays.copyOf(this.v1, this.v2 * 2);
         }

         this.v1[this.v2++] = var1;
      }

      public long[] v1() {
         long[] var1 = Arrays.copyOf(this.v1, this.v2);
         Arrays.sort(var1);
         return var1;
      }
   }
}
