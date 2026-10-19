package cc.syky.ui;

import java.util.Arrays;
import org.jetbrains.annotations.Nullable;

public final class uiSupport172 {
   public static final int v1 = 176;
   public static final int v2 = 166;
   public static final int v3 = 6;
   public static final float v4 = 0.12F;
   public static final int v5 = 16;
   public static final int v6 = 26;
   public static final int v7 = 8;
   public static final int v8 = 75;
   public static final int v9 = 78;
   public static final int v10 = 1024;

   private uiSupport172() {
   }

   @Nullable
   public static uiSupport172.Part1 v1(int[] var0, int var1, int var2, float var3, boolean var4, int[] var5) {
      int var6 = var1 * var2;
      if (var6 > 0 && var0.length >= var6) {
         int[] var7 = new int[var6];
         int[] var8 = new int[var6];
         int[] var9 = new int[var6];
         int[] var10 = new int[var6];
         Arrays.fill(var7, -1);
         int var11 = 0;
         int var12 = 0;

         for (int var13 = 0; var13 < var6; var13++) {
            if (v1(var0[var13])) {
               var12++;
               if (var7[var13] < 0) {
                  var9[var11] = v1(var0, var1, var2, var13, var11, var7, var8);
                  var10[var11] = var0[var13];
                  var11++;
               }
            }
         }

         int var33 = -1;

         for (int var14 = 0; var14 < var11; var14++) {
            if (var33 < 0 || var9[var14] > var9[var33]) {
               var33 = var14;
            }
         }

         if (var33 >= 0 && !(var9[var33] < var12 * 0.12F)) {
            int var34 = var10[var33];
            int var15 = Math.max(1, Math.round(16.0F * var3 * var3));
            boolean[] var16 = new boolean[var11];

            for (int var17 = 0; var17 < var11; var17++) {
               var16[var17] = var17 == var33 || var9[var17] >= var15 && v1(var10[var17], var34);
            }

            boolean[] var35 = new boolean[var11];
            int var18 = Math.round(1024.0F * var3 * var3);

            for (byte var19 = 0; var19 + 1 < var5.length; var19 += 2) {
               int var20 = (int)Math.floor(var5[var19] * var3);
               int var21 = (int)Math.floor(var5[var19 + 1] * var3);
               if (var20 >= 0 && var21 >= 0 && var20 < var1 && var21 < var2) {
                  int var22 = var7[var21 * var1 + var20];
                  if (var22 >= 0 && !var16[var22] && var9[var22] < var18) {
                     var35[var22] = true;
                  }
               }
            }

            int[] var36 = (int[])var0.clone();
            int[] var37 = new int[var6];
            int var38 = var1;
            int var39 = var2;
            int var23 = -1;
            int var24 = -1;
            int var25 = Math.round(26.0F * var3);
            int var26 = Math.round(8.0F * var3);
            int var27 = Math.min(var1, Math.round(75.0F * var3));
            int var28 = Math.min(var2, Math.round(78.0F * var3));

            for (int var29 = 0; var29 < var2; var29++) {
               for (int var30 = 0; var30 < var1; var30++) {
                  int var31 = var29 * var1 + var30;
                  boolean var32 = var4 && var30 >= var25 && var30 < var27 && var29 >= var26 && var29 < var28;
                  if (!var32 && var7[var31] >= 0 && var35[var7[var31]]) {
                     var37[var31] = var0[var31];
                     var36[var31] = 0;
                  } else if (var32 || var7[var31] >= 0 && var16[var7[var31]]) {
                     var36[var31] = 0;
                     var38 = Math.min(var38, var30);
                     var39 = Math.min(var39, var29);
                     var23 = Math.max(var23, var30);
                     var24 = Math.max(var24, var29);
                  }
               }
            }

            return new uiSupport172.Part1(
               var36,
               var37,
               var1,
               var2,
               (int)Math.floor(var38 / var3),
               (int)Math.floor(var39 / var3),
               (int)Math.ceil((var23 + 1) / var3),
               (int)Math.ceil((var24 + 1) / var3)
            );
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private static int v1(int[] var0, int var1, int var2, int var3, int var4, int[] var5, int[] var6) {
      int var7 = var0[var3];
      int var8 = 0;
      int var9 = 0;
      var6[var9++] = var3;
      var5[var3] = var4;

      while (var8 < var9) {
         int var10 = var6[var8++];
         int var11 = var10 % var1;
         int var12 = var10 / var1;
         if (var11 > 0) {
            var9 = v1(var0, var10 - 1, var7, var4, var5, var6, var9);
         }

         if (var11 < var1 - 1) {
            var9 = v1(var0, var10 + 1, var7, var4, var5, var6, var9);
         }

         if (var12 > 0) {
            var9 = v1(var0, var10 - var1, var7, var4, var5, var6, var9);
         }

         if (var12 < var2 - 1) {
            var9 = v1(var0, var10 + var1, var7, var4, var5, var6, var9);
         }
      }

      return var9;
   }

   private static int v1(int[] var0, int var1, int var2, int var3, int[] var4, int[] var5, int var6) {
      if (var4[var1] < 0 && v1(var0[var1]) && v1(var0[var1], var2)) {
         var4[var1] = var3;
         var5[var6] = var1;
         return var6 + 1;
      } else {
         return var6;
      }
   }

   private static boolean v1(int var0) {
      return var0 >>> 24 == 255;
   }

   public static boolean v1(int var0, int var1) {
      return Math.abs((var0 >> 16 & 0xFF) - (var1 >> 16 & 0xFF)) <= 6
         && Math.abs((var0 >> 8 & 0xFF) - (var1 >> 8 & 0xFF)) <= 6
         && Math.abs((var0 & 0xFF) - (var1 & 0xFF)) <= 6;
   }

   public record Part1(int[] frame, int[] slots, int width, int height, int x0, int y0, int x1, int y1) {
      public int[] v1() {
         return this.frame;
      }

      public int[] v2() {
         return this.slots;
      }

      public int v3() {
         return this.width;
      }

      public int v4() {
         return this.height;
      }

      public int v5() {
         return this.x0;
      }

      public int v6() {
         return this.y0;
      }

      public int v7() {
         return this.x1;
      }

      public int v8() {
         return this.y1;
      }
   }
}
