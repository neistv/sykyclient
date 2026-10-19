package cc.syky.ui;

import java.math.BigInteger;
import java.util.Arrays;
import org.jetbrains.annotations.Nullable;

public final class uiSupport179 {
   public static final int v1 = 256;
   public static final int v2 = 16384;
   private static final long v9 = 1592594791L;
   private static final int v10 = 4;
   private static final int v11 = 4096;
   public static final int v3 = 0;
   public static final int v4 = 1;
   public static final int v5 = 2;
   public static final int v6 = 3;
   public static final int v7 = 4;
   public static final int v8 = 5;
   private final int v12;
   private final int v13;
   private final int v14;
   private final byte[] v15;
   @Nullable
   private final byte[] v16;
   private final int v18;
   private final int v19;
   private final int v17;
   private final int v20;
   private final uiSupport179.Part2 v21;
   private final int[] v22;
   private final byte[] v24;
   private int v25;
   private final int[][] v26 = new int[16][];
   private final int[] v27 = new int[16];
   private int[] v28 = new int[256];
   private int v29;
   private int[] v30 = new int[0];
   private int[] v32 = new int[0];
   private int[][] v23 = new int[0][];
   private int[] v33 = new int[0];
   private int[] v31 = new int[0];
   private int[] v34 = new int[0];
   private int v36 = Integer.MAX_VALUE;
   private int v38 = -1;

   private uiSupport179(uiSupport179.Part1 var1, int var2, int var3, uiSupport179.Part2 var4) {
      this.v12 = var1.v1();
      this.v13 = var1.v2();
      this.v14 = var1.v3();
      this.v15 = var1.v4();
      this.v16 = var1.v5();
      this.v18 = var1.v6();
      this.v19 = var1.v7();
      this.v17 = var2;
      this.v20 = var3;
      this.v21 = var4;
      int var5 = this.v12 * this.v13 * this.v14;
      this.v22 = new int[var5];
      this.v24 = new byte[var5];

      for (int var6 = 0; var6 < this.v26.length; var6++) {
         this.v26[var6] = new int[64];
      }
   }

   public static uiSupport179.Part4 v1(uiSupport179.Part1 var0, int[] var1, int[] var2, int[] var3, int var4, int var5, int var6, uiSupport179.Part2 var7) {
      uiSupport179.Part5 var8 = v2(var0, var1, var2, var3, var4, var5, var6, var7);
      return new uiSupport179.Part4(var8.v1(), var8.v2());
   }

   public static int[] v1(uiSupport179.Part1 var0, int[] var1, int[] var2, int[] var3, int var4, int var5) {
      return v2(var0, var1, var2, var3, var4, var5, -1, uiSupport179.Part2.PLAY).v1();
   }

   public static uiSupport179.Part5 v2(uiSupport179.Part1 var0, int[] var1, int[] var2, int[] var3, int var4, int var5, int var6, uiSupport179.Part2 var7) {
      if (var1.length != 0 && var4 >= var5 && var5 >= 1) {
         uiSupport179 var8 = new uiSupport179(var0, Math.min(var4, 15), var5, var7);
         int var9 = var8.v1(var1, var2, var3);
         int var10 = var8.v23.length - var9;
         var8.v36 = var10;
         int var11 = var8.v2();
         int var12 = var6 >= 0 && var6 < var11 ? var6 : -1;
         int[] var13;
         int var14;
         if (var9 == 0) {
            int[] var15 = var8.v1(var11, var10, var12);
            var14 = var8.v38;
            int[] var16 = var8.v1(var8.v1(new int[0], var10));
            var13 = var15 != null && var16.length >= var15.length ? var15 : var16;
         } else {
            var14 = var12;
            if (var12 < 0 && var11 > 0) {
               var8.v1(var11, var10, -1);
               var14 = var8.v38;
            }

            int[] var19 = var14 >= 0 ? var8.v2(var14, var11, var10) : new int[0];
            int[] var21 = new int[var9 + var19.length];

            for (int var17 = 0; var17 < var9; var17++) {
               var21[var17] = var10 + var17;
            }

            System.arraycopy(var19, 0, var21, var9, var19.length);
            var13 = var8.v1(var8.v1(var21, var10));
         }

         var13 = var8.v1(var13, var7.v3(), System.nanoTime() + var7.v1());
         int[] var20 = new int[var13.length];

         for (int var22 = 0; var22 < var13.length; var22++) {
            var20[var22] = var8.v32[var13[var22]];
         }

         return new uiSupport179.Part5(var20, var14);
      } else {
         return new uiSupport179.Part5(new int[0], var6);
      }
   }

   public static int[] v1(uiSupport179.Part1 var0, int var1, int var2, int var3) {
      return v1(var0, new int[]{var1}, var2, var3)[0];
   }

   public static int[][] v1(uiSupport179.Part1 var0, int[] var1, int var2, int var3) {
      int[][] var4 = new int[var1.length][];
      if (var2 >= var3 && var3 >= 1) {
         uiSupport179 var5 = new uiSupport179(var0, Math.min(var2, 15), var3, uiSupport179.Part2.PLAY);

         for (int var6 = 0; var6 < var1.length; var6++) {
            var5.v2(var1[var6]);
            var4[var6] = Arrays.copyOf(var5.v28, var5.v29);
         }

         return var4;
      } else {
         Arrays.fill(var4, new int[0]);
         return var4;
      }
   }

   public static uiSupport179.Part3 v1(uiSupport179.Part1 var0, int[] var1, int[] var2, int[] var3, int var4, int var5, int var6, int[] var7) {
      long var8 = System.nanoTime();
      int var10 = v2(var0, var1, var2, var3, var4, var5, var6, uiSupport179.Part2.THOROUGH).v1().length;
      long var11 = System.nanoTime() - var8;
      uiSupport179 var13 = new uiSupport179(var0, Math.min(var4, 15), var5, uiSupport179.Part2.PLAY);
      var13.v1(var1, var2, new int[0]);
      int[] var14 = new int[var13.v22.length];
      Arrays.fill(var14, -1);
      int var15 = 0;

      while (var15 < var13.v30.length) {
         var14[var13.v30[var15]] = var15++;
      }

      int[][] var29 = new int[var7.length][];
      int[] var16 = new int[var13.v30.length];
      long var17 = 0L;

      for (int var19 = 0; var19 < var7.length; var19++) {
         var13.v2(var7[var19]);
         int var20 = 0;

         for (int var21 = 0; var21 < var13.v29; var21++) {
            int var22 = var14[var13.v28[var21]];
            if (var22 >= 0) {
               var13.v28[var20++] = var22;
               var16[var22]++;
            }
         }

         var29[var19] = Arrays.copyOf(var13.v28, var20);
         var17 += var20;
      }

      int var30 = 0;

      for (int[] var23 : var29) {
         int var24 = 0;

         for (int var28 : var23) {
            var24 += var16[var28] == 1 ? 1 : 0;
         }

         var30 += var24 <= 4 ? 1 : 0;
      }

      long var32 = Arrays.stream(var16).filter(var0x -> var0x > 0).count();
      double var35 = var17 == 0L ? 0.0 : 1.0 - (double)var32 / var17;
      return new uiSupport179.Part3(var7.length, var10, var13.v1(), var30, var35, var11);
   }

   private int v1() {
      int var1 = this.v30.length;
      Integer[] var2 = new Integer[var1];

      for (int var3 = 0; var3 < var1; var3++) {
         var2[var3] = var3;
      }

      Arrays.sort(var2, (var1x, var2x) -> {
         int var3x = this.v33[var1x + 1] - this.v33[var1x];
         int var4x = this.v33[var2x + 1] - this.v33[var2x];
         return var3x != var4x ? var3x - var4x : var1x - var2x;
      });
      boolean[] var14 = new boolean[var1];
      int var4 = 0;
      Integer[] var5 = var2;
      int var6 = var2.length;

      for (int var7 = 0; var7 < var6; var7++) {
         int var8 = var5[var7];
         if (!var14[var8] && this.v33[var8 + 1] != this.v33[var8]) {
            var4++;

            for (int var9 = this.v33[var8]; var9 < this.v33[var8 + 1]; var9++) {
               for (int var13 : this.v23[this.v31[var9]]) {
                  var14[var13] = true;
               }
            }
         }
      }

      return var4;
   }

   @Nullable
   private int[] v1(int var1, int var2, int var3) {
      this.v38 = -1;
      if (var1 <= 0) {
         return null;
      } else {
         int var4 = Math.min(this.v21.v2(), var1);
         int[] var5 = new int[var4 + 1];
         var5[0] = var3 >= 0 ? var3 : 0;

         for (int var6 = 0; var6 < var4; var6++) {
            var5[var6 + 1] = (int)((long)var6 * var1 / var4);
         }

         int[] var12 = null;

         for (int var10 : var5) {
            int[] var11 = this.v1(this.v1(this.v2(var10, var1, var2), var2));
            if (var12 == null || var11.length < var12.length) {
               var12 = var11;
               this.v38 = var10;
            }
         }

         return var12;
      }
   }

   private int v1(int[] var1, int[] var2, int[] var3) {
      this.v30 = (int[])var1.clone();
      Arrays.sort(this.v30);
      int var4 = this.v30.length;
      int[] var5 = Arrays.stream(var2).sorted().distinct().toArray();
      int[] var6 = Arrays.stream(var5).filter(var1x -> Arrays.binarySearch(this.v30, var1x) >= 0).toArray();
      int[] var7 = Arrays.stream(var5).filter(var1x -> Arrays.binarySearch(this.v30, var1x) < 0).toArray();
      int var8 = Math.max(0, 16384 - var6.length);
      int var9 = var7.length <= var8 ? 1 : (var7.length + Math.max(1, var8) - 1) / Math.max(1, var8);
      int var10 = var8 == 0 ? 0 : (var7.length + var9 - 1) / var9;
      int[] var11 = new int[var6.length + var10];
      System.arraycopy(var6, 0, var11, 0, var6.length);

      for (int var12 = 0; var12 < var10; var12++) {
         var11[var6.length + var12] = var7[var12 * var9];
      }

      Arrays.sort(var11);
      int var13 = var11.length;
      this.v32 = new int[var13 + var3.length];
      System.arraycopy(var11, 0, this.v32, 0, var13);
      System.arraycopy(var3, 0, this.v32, var13, var3.length);
      this.v1(var4);
      return var3.length;
   }

   private void v1(int var1) {
      int var2 = this.v32.length;
      int[] var3 = new int[this.v22.length];
      Arrays.fill(var3, -1);
      int[] var4 = new int[var2];
      boolean[] var5 = new boolean[var2];

      for (int var6 = var2 - 1; var6 >= 0; var6--) {
         int var7 = this.v32[var6];
         var4[var6] = var3[var7];
         var3[var7] = var6;
         var5[var6] = this.v15[var7] > 1;
      }

      int[] var19 = new int[var1 + 1];
      int[] var20 = new int[Math.max(16, var1 * 16)];
      int var8 = 0;

      for (int var9 = 0; var9 < var1; var9++) {
         int var10 = this.v30[var9];
         var19[var9] = var8;
         this.v1(var10, this.v17 - Math.max(1, this.v15[var10]) + 1);

         for (int var11 = 0; var11 < this.v29; var11++) {
            for (int var12 = var3[this.v28[var11]]; var12 >= 0; var12 = var4[var12]) {
               if (!var5[var12]) {
                  if (var8 == var20.length) {
                     var20 = Arrays.copyOf(var20, var8 * 2);
                  }

                  var20[var8++] = var12;
               }
            }
         }
      }

      var19[var1] = var8;
      int[] var21 = new int[this.v22.length];
      Arrays.fill(var21, -1);
      int var22 = 0;

      while (var22 < var1) {
         var21[this.v30[var22]] = var22++;
      }

      int[] var23 = new int[0];
      int var24 = 0;
      int[] var26 = new int[var1];

      for (int var13 = 0; var13 < var1; var13++) {
         var26[var13] = var19[var13 + 1] - var19[var13];
      }

      for (int var27 = 0; var27 < var2; var27++) {
         if (var5[var27]) {
            this.v1(this.v32[var27], this.v17);

            for (int var14 = 0; var14 < this.v29; var14++) {
               int var15 = var21[this.v28[var14]];
               if (var15 >= 0) {
                  if (var24 + 2 > var23.length) {
                     var23 = Arrays.copyOf(var23, Math.max(32, var23.length * 2));
                  }

                  var23[var24++] = var15;
                  var23[var24++] = var27;
                  var26[var15]++;
               }
            }
         }
      }

      this.v34 = new int[var1];
      this.v33 = new int[var1 + 1];

      for (int var28 = 0; var28 < var1; var28++) {
         this.v34[var28] = 4096 / Math.max(1, var26[var28]);
         this.v33[var28 + 1] = this.v33[var28] + var26[var28];
      }

      this.v31 = new int[this.v33[var1]];
      int[] var29 = (int[])this.v33.clone();
      int[] var30 = new int[var2];

      for (int var31 = 0; var31 < var1; var31++) {
         for (int var16 = var19[var31]; var16 < var19[var31 + 1]; var16++) {
            this.v31[var29[var31]++] = var20[var16];
            var30[var20[var16]]++;
         }
      }

      for (byte var32 = 0; var32 < var24; var32 += 2) {
         this.v31[var29[var23[var32]]++] = var23[var32 + 1];
         var30[var23[var32 + 1]]++;
      }

      this.v23 = new int[var2][];

      for (int var33 = 0; var33 < var2; var33++) {
         this.v23[var33] = new int[var30[var33]];
      }

      int[] var34 = new int[var2];

      for (int var35 = 0; var35 < var1; var35++) {
         for (int var17 = this.v33[var35]; var17 < this.v33[var35 + 1]; var17++) {
            int var18 = this.v31[var17];
            this.v23[var18][var34[var18]++] = var35;
         }
      }
   }

   private int[] v1(int[] var1, int var2) {
      boolean[] var3 = new boolean[this.v30.length];
      int[] var4 = new int[256];
      int var5 = 0;

      for (int var9 : var1) {
         if (var5 < 256 && this.v1(var9, var3) > 0) {
            this.v2(var9, var3);
            var4[var5++] = var9;
         }
      }

      long[] var12 = new long[var2];
      int var13 = 0;

      for (int var14 = 0; var14 < var2; var14++) {
         var13 = v1(var12, var13, v3(Integer.MAX_VALUE, var14));
      }

      while (var13 > 0 && var5 < 256) {
         long var15 = var12[0];
         var13 = v1(var12, var13);
         int var10 = ~((int)var15);
         int var11 = this.v1(var10, var3);
         if (var11 != 0) {
            if (var13 > 0 && var11 < (int)(var12[0] >>> 32)) {
               var13 = v1(var12, var13, v3(var11, var10));
            } else {
               this.v2(var10, var3);
               var4[var5++] = var10;
            }
         }
      }

      return Arrays.copyOf(var4, var5);
   }

   private int v1(int var1, boolean[] var2) {
      int var3 = 0;

      for (int var7 : this.v23[var1]) {
         if (!var2[var7]) {
            var3 += this.v34[var7];
         }
      }

      return var3;
   }

   private void v2(int var1, boolean[] var2) {
      for (int var6 : this.v23[var1]) {
         var2[var6] = true;
      }
   }

   private int[] v1(int[] var1) {
      int[] var2 = this.v2(var1);
      boolean[] var3 = new boolean[var1.length];
      int var4 = var1.length;

      for (int var5 = var1.length - 1; var5 >= 0; var5--) {
         boolean var6 = false;

         for (int var10 : this.v23[var1[var5]]) {
            if (var2[var10] < 2) {
               var6 = true;
               break;
            }
         }

         if (!var6) {
            var3[var5] = true;
            var4--;

            for (int var17 : this.v23[var1[var5]]) {
               var2[var17]--;
            }
         }
      }

      int[] var11 = new int[var4];
      int var12 = 0;

      for (int var14 = 0; var12 < var1.length; var12++) {
         if (!var3[var12]) {
            var11[var14++] = var1[var12];
         }
      }

      return var11;
   }

   private int[] v2(int[] var1) {
      int[] var2 = new int[this.v30.length];

      for (int var6 : var1) {
         for (int var10 : this.v23[var6]) {
            var2[var10]++;
         }
      }

      return var2;
   }

   private int v2() {
      int var1 = this.v17 - this.v20;
      return var1 < 1 ? 0 : 2 * var1 * var1 + 2 * var1 + 1;
   }

   private int[] v2(int var1, int var2, int var3) {
      int var4 = this.v17 - this.v20;
      long var5 = (var4 + 1) * BigInteger.valueOf(var4).modInverse(BigInteger.valueOf(var2)).longValue() % var2;
      int var7 = this.v12 * this.v14;
      int[] var8 = new int[var3];
      int var9 = 0;

      for (int var10 = 0; var10 < var3; var10++) {
         int var11 = this.v32[var10];
         long var12 = this.v19 + var11 % var7 / this.v12;
         long var14 = this.v18 + var11 % this.v12;
         if (Math.floorMod(var14 + var5 * var12 - var1, (long)var2) == 0L) {
            var8[var9++] = var10;
         }
      }

      return Arrays.copyOf(var8, var9);
   }

   private int[] v1(int[] var1, long var2, long var4) {
      if (var2 > 0L && var1.length >= 2) {
         boolean[] var6 = new boolean[this.v23.length];

         for (int var7 = this.v36; var7 < this.v23.length; var7++) {
            var6[var7] = true;
         }

         return uiSupport177.v1(this.v23, this.v30.length, this.v33, this.v31, var1, var6, var2, var4, 1592594791L);
      } else {
         return var1;
      }
   }

   private void v2(int var1) {
      this.v1(var1, this.v17);
   }

   private void v1(int var1, int var2) {
      this.v25++;
      this.v29 = 0;
      if (var2 >= this.v20) {
         this.v22[var1] = this.v25;
         this.v24[var1] = (byte)var2;
         this.v2(var2, var1);
         int var3 = this.v12 * this.v14;

         for (int var4 = var2; var4 >= this.v20; var4--) {
            int[] var5 = this.v26[var4];

            for (int var6 = 0; var6 < this.v27[var4]; var6++) {
               int var7 = var5[var6];
               if (this.v24[var7] == var4) {
                  if (this.v29 == this.v28.length) {
                     this.v28 = Arrays.copyOf(this.v28, this.v29 * 2);
                  }

                  this.v28[this.v29++] = var7;
                  int var8 = var7 / var3;
                  int var9 = var7 - var8 * var3;
                  int var10 = var9 / this.v12;
                  int var11 = var9 - var10 * this.v12;
                  if (var11 > 0) {
                     this.v1(var7, var7 - 1, var4, 4, 5);
                  }

                  if (var11 < this.v12 - 1) {
                     this.v1(var7, var7 + 1, var4, 5, 4);
                  }

                  if (var10 > 0) {
                     this.v1(var7, var7 - this.v12, var4, 2, 3);
                  }

                  if (var10 < this.v14 - 1) {
                     this.v1(var7, var7 + this.v12, var4, 3, 2);
                  }

                  if (var8 > 0) {
                     this.v1(var7, var7 - var3, var4, 0, 1);
                  }

                  if (var8 < this.v13 - 1) {
                     this.v1(var7, var7 + var3, var4, 1, 0);
                  }
               }
            }

            this.v27[var4] = 0;
         }
      }
   }

   private void v1(int var1, int var2, int var3, int var4, int var5) {
      byte[] var6 = this.v16;
      if (var6 == null || ((var6[var1] >> var4 | var6[var2] >> var5) & 1) == 0) {
         int var7 = var3 - Math.max(1, this.v15[var2]);
         if (var7 >= this.v20 && (this.v22[var2] != this.v25 || this.v24[var2] < var7)) {
            this.v22[var2] = this.v25;
            this.v24[var2] = (byte)var7;
            this.v2(var7, var2);
         }
      }
   }

   private void v2(int var1, int var2) {
      if (this.v27[var1] == this.v26[var1].length) {
         this.v26[var1] = Arrays.copyOf(this.v26[var1], this.v27[var1] * 2);
      }

      this.v26[var1][this.v27[var1]++] = var2;
   }

   private static long v3(int var0, int var1) {
      return (long)var0 << 32 | ~var1 & 4294967295L;
   }

   private static int v1(long[] var0, int var1, long var2) {
      int var4 = var1;
      var0[var1] = var2;

      while (var4 > 0) {
         int var5 = var4 - 1 >> 1;
         if (var0[var5] >= var0[var4]) {
            break;
         }

         long var6 = var0[var5];
         var0[var5] = var0[var4];
         var0[var4] = var6;
         var4 = var5;
      }

      return var1 + 1;
   }

   private static int v1(long[] var0, int var1) {
      int var2 = var1 - 1;
      var0[0] = var0[var2];
      int var3 = 0;

      while (true) {
         int var4 = 2 * var3 + 1;
         if (var4 >= var2) {
            break;
         }

         int var5 = var4 + 1;
         int var6 = var5 < var2 && var0[var5] > var0[var4] ? var5 : var4;
         if (var0[var3] >= var0[var6]) {
            break;
         }

         long var7 = var0[var6];
         var0[var6] = var0[var3];
         var0[var3] = var7;
         var3 = var6;
      }

      return var2;
   }

   public record Part1(int sx, int sy, int sz, byte[] opacity, @Nullable byte[] faces, int originX, int originZ) {
      public Part1(int var1, int var2, int var3, byte[] var4, @Nullable byte[] var5) {
         this(var1, var2, var3, var4, var5, 0, 0);
      }

      public int v1() {
         return this.sx;
      }

      public int v2() {
         return this.sy;
      }

      public int v3() {
         return this.sz;
      }

      public byte[] v4() {
         return this.opacity;
      }

      @Nullable
      public byte[] v5() {
         return this.faces;
      }

      public int v6() {
         return this.originX;
      }

      public int v7() {
         return this.originZ;
      }
   }

   public record Part2(long budgetNanos, int latticeTries, long searchSteps) {
      public static final uiSupport179.Part2 PLAY = new uiSupport179.Part2(10000000000L, 8, 10000L);
      public static final uiSupport179.Part2 THOROUGH = new uiSupport179.Part2(300000000000L, Integer.MAX_VALUE, 300000L);

      public long v1() {
         return this.budgetNanos;
      }

      public int v2() {
         return this.latticeTries;
      }

      public long v3() {
         return this.searchSteps;
      }
   }

   public record Part3(int planned, int searched, int lowerBound, int lonely, double overlap, long searchNanos) {
      public int v1() {
         return this.planned;
      }

      public int v2() {
         return this.searched;
      }

      public int v3() {
         return this.lowerBound;
      }

      public int v4() {
         return this.lonely;
      }

      public double v5() {
         return this.overlap;
      }

      public long v6() {
         return this.searchNanos;
      }
   }

   public record Part4(int[] shown, int lattice) {
      public int[] v1() {
         return this.shown;
      }

      public int v2() {
         return this.lattice;
      }
   }

   public record Part5(int[] spots, int lattice) {
      public int[] v1() {
         return this.spots;
      }

      public int v2() {
         return this.lattice;
      }
   }
}
