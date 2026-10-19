package cc.syky.ui;

import java.util.Arrays;
import java.util.SplittableRandom;

public final class uiSupport177 {
   private final int[][] v1;
   private final int[] v2;
   private final int[] v3;
   private final boolean[] v4;
   private final int[] v5;
   private final int[] v6;
   private final int[] v7;
   private final long[] v8;
   private final boolean[] v9;
   private final boolean[] v10;
   private final long[] v11;
   private final int[] v12;
   private final int[] v13;
   private int v14;
   private final int[] v15;
   private final int[] v16;
   private int v18;
   private long v19;

   private uiSupport177(int[][] var1, int var2, int[] var3, int[] var4, boolean[] var5) {
      this.v1 = var1;
      this.v2 = var3;
      this.v3 = var4;
      this.v4 = var5;
      int var6 = var1.length;
      this.v5 = new int[var2];
      this.v6 = new int[var2];
      this.v7 = new int[var2];
      this.v8 = new long[var6];
      this.v9 = new boolean[var6];
      this.v10 = new boolean[var6];
      this.v11 = new long[var6];
      this.v12 = new int[var2];
      this.v13 = new int[var2];
      this.v15 = new int[var6];
      this.v16 = new int[var6];
      Arrays.fill(this.v16, -1);
      Arrays.fill(this.v10, true);
      Arrays.fill(this.v13, -1);

      for (int var7 = 0; var7 < var2; var7++) {
         if (var3[var7 + 1] > var3[var7]) {
            this.v7[var7] = 1;
            this.v13[var7] = this.v14;
            this.v12[this.v14++] = var7;
         }
      }

      for (int var14 = 0; var14 < var6; var14++) {
         long var8 = 0L;

         for (int var13 : var1[var14]) {
            var8 += this.v7[var13];
         }

         this.v8[var14] = var8;
      }
   }

   public static int[] v1(int[][] var0, int var1, int[] var2, int[] var3, int[] var4, boolean[] var5, long var6, long var8, long var10) {
      uiSupport177 var12 = new uiSupport177(var0, var1, var2, var3, var5);

      for (int var16 : var4) {
         if (!var12.v9[var16]) {
            var12.v3(var16);
         }
      }

      if (var12.v14 > 0) {
         return var4;
      } else {
         SplittableRandom var19 = new SplittableRandom(var10);
         int[] var20 = (int[])var4.clone();
         int var21 = -1;

         for (var12.v19 = 1L; var12.v19 <= var6 && ((var12.v19 & 255L) != 0L || System.nanoTime() <= var8); var12.v19++) {
            while (var12.v14 == 0) {
               if (var12.v18 < var20.length) {
                  var20 = Arrays.copyOf(var12.v15, var12.v18);
               }

               int var22 = var12.v1(-1);
               if (var22 < 0) {
                  return var20;
               }

               var12.v4(var22);
            }

            int var23 = var12.v1(var21);
            if (var23 >= 0) {
               var12.v4(var23);
               var12.v10[var23] = false;
            }

            int var17 = var12.v12[var19.nextInt(var12.v14)];
            int var18 = var12.v2(var17);
            var12.v3(var18);
            var21 = var18;
            var12.v1();
         }

         if (var12.v14 == 0 && var12.v18 < var20.length) {
            var20 = Arrays.copyOf(var12.v15, var12.v18);
         }

         return var20;
      }
   }

   private int v1(int var1) {
      int var2 = -1;

      for (int var3 = 0; var3 < this.v18; var3++) {
         int var4 = this.v15[var3];
         if (var4 != var1 && !this.v4[var4] && (var2 < 0 || this.v8[var4] > this.v8[var2] || this.v8[var4] == this.v8[var2] && this.v11[var4] < this.v11[var2])
            )
          {
            var2 = var4;
         }
      }

      return var2;
   }

   private int v2(int var1) {
      int var2 = -1;

      for (int var3 = this.v2[var1]; var3 < this.v2[var1 + 1]; var3++) {
         int var4 = this.v3[var3];
         if (this.v10[var4] && (var2 < 0 || this.v8[var4] > this.v8[var2] || this.v8[var4] == this.v8[var2] && this.v11[var4] < this.v11[var2])) {
            var2 = var4;
         }
      }

      return var2 >= 0 ? var2 : this.v3[this.v2[var1]];
   }

   private void v3(int var1) {
      this.v9[var1] = true;
      this.v16[var1] = this.v18;
      this.v15[this.v18++] = var1;
      this.v11[var1] = this.v19;
      long var2 = 0L;

      for (int var7 : this.v1[var1]) {
         if (this.v7[var7] != 0) {
            int var8 = this.v5[var7]++;
            int var9 = this.v6[var7] - 1;
            this.v6[var7] = this.v6[var7] ^ var1 + 1;
            if (var8 != 0) {
               if (var8 == 1) {
                  this.v8[var9] = this.v8[var9] + this.v7[var7];
               }
            } else {
               this.v6(var7);

               for (int var10 = this.v2[var7]; var10 < this.v2[var7 + 1]; var10++) {
                  int var11 = this.v3[var10];
                  if (var11 != var1) {
                     this.v8[var11] = this.v8[var11] - this.v7[var7];
                     this.v10[var11] = true;
                  }
               }

               var2 += this.v7[var7];
            }
         }
      }

      this.v8[var1] = -var2;
   }

   private void v4(int var1) {
      this.v9[var1] = false;
      int var2 = this.v16[var1];
      int var3 = this.v15[--this.v18];
      this.v15[var2] = var3;
      this.v16[var3] = var2;
      this.v16[var1] = -1;
      this.v11[var1] = this.v19;
      long var4 = 0L;

      for (int var9 : this.v1[var1]) {
         if (this.v7[var9] != 0) {
            this.v6[var9] = this.v6[var9] ^ var1 + 1;
            int var10 = --this.v5[var9];
            if (var10 != 0) {
               if (var10 == 1) {
                  this.v8[this.v6[var9] - 1] = this.v8[this.v6[var9] - 1] - this.v7[var9];
               }
            } else {
               this.v5(var9);

               for (int var11 = this.v2[var9]; var11 < this.v2[var9 + 1]; var11++) {
                  int var12 = this.v3[var11];
                  if (var12 != var1) {
                     this.v8[var12] = this.v8[var12] + this.v7[var9];
                     this.v10[var12] = true;
                  }
               }

               var4 += this.v7[var9];
            }
         }
      }

      this.v8[var1] = var4;
   }

   private void v1() {
      for (int var1 = 0; var1 < this.v14; var1++) {
         int var2 = this.v12[var1];
         this.v7[var2]++;

         for (int var3 = this.v2[var2]; var3 < this.v2[var2 + 1]; var3++) {
            this.v8[this.v3[var3]]++;
         }
      }
   }

   private void v5(int var1) {
      this.v13[var1] = this.v14;
      this.v12[this.v14++] = var1;
   }

   private void v6(int var1) {
      int var2 = this.v13[var1];
      int var3 = this.v12[--this.v14];
      this.v12[var2] = var3;
      this.v13[var3] = var2;
      this.v13[var1] = -1;
   }
}
