package cc.syky.ui;

import cc.syky.hud.hudRecord4;
import java.util.List;

public final class uiSupport27 {
   public static final float v1 = 4.0F;
   private static final int v6 = 8;
   private static final float v7 = 0.25F;
   private static final int v8 = 0;
   private static final int v9 = 1;
   private static final int v10 = 2;
   private static final int v11 = 3;
   public float v2;
   public float v3;
   public boolean v4;
   public boolean v5;
   private final float[] v12 = new float[8];
   private int v13;
   private float v14 = Float.NaN;
   private float v15;
   private float v16;
   private int v18;

   public uiSupport27() {
   }

   public void v1(
      float var1, float var2, float var3, float var4, List<hudRecord4> var5, float var6, float var7, float var8, float var9, float var10, uiSupport30 var11
   ) {
      var11.v1();
      float var12 = 4.0F * var8;
      float var13 = var9 * var8;
      float var14 = var10 * var8;
      this.v1(true, var5, var6);
      float var15 = this.v1(true, var1, var3, var2, var2 + var4, var5, var6, var13, var14, var12);
      this.v4 = !Float.isNaN(var15);
      this.v2 = v1(this.v4 ? var15 : var1, var8);
      this.v1(false, var5, var7);
      float var16 = this.v1(false, var2, var4, this.v2, this.v2 + var3, var5, var7, var13, var14, var12);
      this.v5 = !Float.isNaN(var16);
      this.v3 = v1(this.v5 ? var16 : var2, var8);
      float var17 = 0.51F * var8;
      if (this.v4) {
         this.v1(true, var5, var6);
         this.v1(true, this.v2, var3, this.v3, this.v3 + var4, var5, var6, var7, var13, var14, var17, var8, var11);
      }

      if (this.v5) {
         this.v1(false, var5, var7);
         this.v1(false, this.v3, var4, this.v2, this.v2 + var3, var5, var7, var6, var13, var14, var17, var8, var11);
      }
   }

   public void v1(float var1) {
      this.v14 = var1;
   }

   public void v1(float var1, float var2, float var3, uiSupport30 var4) {
      var4.v1();
      this.v2 = v1(var1, var3);
      this.v3 = v1(var2, var3);
      this.v4 = false;
      this.v5 = false;
   }

   public static float v1(float var0, float var1) {
      return var1 > 0.0F ? Math.round(var0 / var1) * var1 : var0;
   }

   private float v1(boolean var1, float var2, float var3, float var4, float var5, List<hudRecord4> var6, float var7, float var8, float var9, float var10) {
      this.v15 = var10;
      this.v16 = Float.NaN;
      this.v18 = Integer.MAX_VALUE;
      this.v1(var2, (var7 - var3) * 0.5F, 1);
      this.v1(var2, var8, 3);
      this.v1(var2, var7 - var8 - var3, 3);
      float var11 = Float.NEGATIVE_INFINITY;
      float var12 = Float.POSITIVE_INFINITY;
      float var13 = var2 + var3 * 0.5F;
      int var14 = 0;

      for (int var15 = var6.size(); var14 < var15; var14++) {
         hudRecord4 var16 = (hudRecord4)var6.get(var14);
         float var17 = v1(var16, var1);
         float var18 = v2(var16, var1);
         this.v1(var2, var17, 0);
         this.v1(var2, var18, 0);
         this.v1(var2, (var17 + var18) * 0.5F - var3 * 0.5F, 0);
         this.v1(var2, var18 - var3, 0);
         this.v1(var2, var17 - var3, 0);
         this.v1(var2, var7 - var18, 3);
         this.v1(var2, var7 - var17 - var3, 3);
         if (v1(v3(var16, var1), v4(var16, var1), var4, var5)) {
            if (!this.v2(var9)) {
               this.v1(var2, var18 + var9, 2);
               this.v1(var2, var17 - var9 - var3, 2);
            }

            for (int var19 = 0; var19 < this.v13; var19++) {
               if (!this.v2(this.v12[var19])) {
                  this.v1(var2, var18 + this.v12[var19], 2);
                  this.v1(var2, var17 - this.v12[var19] - var3, 2);
               }
            }

            if (var18 <= var13 && var18 > var11) {
               var11 = var18;
            }

            if (var17 >= var13 && var17 < var12) {
               var12 = var17;
            }
         }
      }

      if (var11 != Float.NEGATIVE_INFINITY && var12 != Float.POSITIVE_INFINITY && var12 - var11 > var3) {
         this.v1(var2, (var11 + var12 - var3) * 0.5F, 2);
      }

      return this.v16;
   }

   private boolean v2(float var1) {
      return Math.abs(var1 - this.v14) < 0.5F;
   }

   private void v1(float var1, float var2, int var3) {
      float var4 = Math.abs(var2 - var1);
      if (!(var4 > this.v15 + 1.0E-4F)) {
         if (var4 < this.v15 - 1.0E-4F || var3 < this.v18) {
            this.v15 = var4;
            this.v16 = var2;
            this.v18 = var3;
         }
      }
   }

   private void v1(boolean var1, List<hudRecord4> var2, float var3) {
      this.v13 = 0;
      float var4 = var3 * 0.25F;
      int var5 = 0;

      for (int var6 = var2.size(); var5 < var6; var5++) {
         hudRecord4 var7 = (hudRecord4)var2.get(var5);
         float var8 = v2(var7, var1);
         float var9 = Float.POSITIVE_INFINITY;

         for (int var10 = 0; var10 < var6; var10++) {
            if (var5 != var10) {
               hudRecord4 var11 = (hudRecord4)var2.get(var10);
               float var12 = v1(var11, var1);
               if (var12 >= var8 && var12 < var9 && v1(v3(var7, var1), v4(var7, var1), v3(var11, var1), v4(var11, var1))) {
                  var9 = var12;
               }
            }
         }

         float var13 = var9 - var8;
         if (var9 != Float.POSITIVE_INFINITY && var13 > 0.5F && var13 <= var4) {
            this.v3(var13);
         }
      }
   }

   private void v3(float var1) {
      for (int var2 = 0; var2 < this.v13; var2++) {
         if (Math.abs(this.v12[var2] - var1) < 0.5F) {
            return;
         }
      }

      if (this.v13 < 8) {
         this.v12[this.v13++] = var1;
      }
   }

   private void v1(
      boolean var1,
      float var2,
      float var3,
      float var4,
      float var5,
      List<hudRecord4> var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      uiSupport30 var13
   ) {
      float var14 = var2 + var3;
      float var15 = var2 + var3 * 0.5F;
      float var16 = (var4 + var5) * 0.5F;
      if (Math.abs(var15 - var7 * 0.5F) <= var11) {
         v1(var1, var7 * 0.5F, 0.0F, var8, var13);
      }

      if (Math.abs(var2 - var9) <= var11) {
         v1(var1, 0.0F, var2, var16, var12, var13);
      }

      if (Math.abs(var7 - var14 - var9) <= var11) {
         v1(var1, var14, var7, var16, var12, var13);
      }

      float var17 = Float.NEGATIVE_INFINITY;
      float var18 = Float.POSITIVE_INFINITY;
      hudRecord4 var19 = null;
      hudRecord4 var20 = null;
      int var21 = 0;

      for (int var22 = var6.size(); var21 < var22; var21++) {
         hudRecord4 var23 = (hudRecord4)var6.get(var21);
         float var24 = v1(var23, var1);
         float var25 = v2(var23, var1);
         float var26 = (var24 + var25) * 0.5F;
         float var27 = v3(var23, var1);
         float var28 = v4(var23, var1);
         float var29 = Math.min(var4, var27);
         float var30 = Math.max(var5, var28);
         v1(var1, var2, var24, var29, var30, var11, var13);
         v1(var1, var2, var25, var29, var30, var11, var13);
         v1(var1, var15, var26, var29, var30, var11, var13);
         v1(var1, var14, var25, var29, var30, var11, var13);
         v1(var1, var14, var24, var29, var30, var11, var13);
         float var31 = (var27 + var28) * 0.5F;
         if (Math.abs(var2 - (var7 - var25)) <= var11 && var2 > var11) {
            v1(var1, 0.0F, var2, var16, var12, var13);
            v1(var1, var25, var7, var31, var12, var13);
         }

         if (Math.abs(var7 - var14 - var24) <= var11 && var24 > var11) {
            v1(var1, var14, var7, var16, var12, var13);
            v1(var1, 0.0F, var24, var31, var12, var13);
         }

         if (v1(var27, var28, var4, var5)) {
            float var32 = (Math.max(var4, var27) + Math.min(var5, var28)) * 0.5F;
            if (var25 <= var2 + var11 && this.v1(var2 - var25, var10, var11)) {
               v1(var1, var25, var2, var32, var12, var13);
            }

            if (var24 >= var14 - var11 && this.v1(var24 - var14, var10, var11)) {
               v1(var1, var14, var24, var32, var12, var13);
            }

            if (var25 <= var15 && var25 > var17) {
               var17 = var25;
               var19 = var23;
            }

            if (var24 >= var15 && var24 < var18) {
               var18 = var24;
               var20 = var23;
            }
         }
      }

      if (var19 != null && var20 != null) {
         float var33 = var2 - var17;
         float var34 = var18 - var14;
         if (var33 > var11 && var34 > var11 && Math.abs(var33 - var34) <= 2.0F * var11 && !this.v1(var33, var10, var11)) {
            v1(var1, var17, var2, v1(var19, var1, var4, var5), var12, var13);
            v1(var1, var14, var18, v1(var20, var1, var4, var5), var12, var13);
         }
      }
   }

   private boolean v1(float var1, float var2, float var3) {
      if (var1 <= var3) {
         return false;
      } else if (Math.abs(var1 - var2) <= var3) {
         return true;
      } else {
         for (int var4 = 0; var4 < this.v13; var4++) {
            if (Math.abs(var1 - this.v12[var4]) <= var3) {
               return true;
            }
         }

         return false;
      }
   }

   private static float v1(hudRecord4 var0, boolean var1, float var2, float var3) {
      return (Math.max(var2, v3(var0, var1)) + Math.min(var3, v4(var0, var1))) * 0.5F;
   }

   private static void v1(boolean var0, float var1, float var2, float var3, float var4, float var5, uiSupport30 var6) {
      if (Math.abs(var1 - var2) <= var5) {
         v1(var0, var2, var3, var4, var6);
      }
   }

   private static void v1(boolean var0, float var1, float var2, float var3, uiSupport30 var4) {
      if (var0) {
         var4.v1(uiSupport30.Part1.ALIGN, var1, var2, var1, var3, 0);
      } else {
         var4.v1(uiSupport30.Part1.ALIGN, var2, var1, var3, var1, 0);
      }
   }

   private static void v1(boolean var0, float var1, float var2, float var3, float var4, uiSupport30 var5) {
      int var6 = Math.round(Math.abs(var2 - var1) / var4);
      if (var6 > 0) {
         if (var0) {
            var5.v1(uiSupport30.Part1.SPACING, var1, var3, var2, var3, var6);
         } else {
            var5.v1(uiSupport30.Part1.SPACING, var3, var1, var3, var2, var6);
         }
      }
   }

   public static float v1(hudRecord4 var0, boolean var1) {
      return var1 ? var0.v2() : var0.v3();
   }

   public static float v2(hudRecord4 var0, boolean var1) {
      return var1 ? var0.v2() + var0.v4() : var0.v3() + var0.v5();
   }

   public static float v3(hudRecord4 var0, boolean var1) {
      return var1 ? var0.v3() : var0.v2();
   }

   public static float v4(hudRecord4 var0, boolean var1) {
      return var1 ? var0.v3() + var0.v5() : var0.v2() + var0.v4();
   }

   public static boolean v1(float var0, float var1, float var2, float var3) {
      return var0 < var3 && var2 < var1;
   }
}
