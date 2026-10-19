package cc.syky.account;

import cc.syky.hud.hudSupport52;
import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;

public final class accountSupport6 {
   public static final int v1 = -1;
   public static final int v2 = 0;
   public static final int v3 = 1;
   public static final int v4 = 2;
   public static final int v5 = 3;
   public static final int v6 = 0;
   public static final int v7 = 1;
   public static final int v8 = 2;
   private static final int v23 = 4;
   private static final int[] v33 = new int[]{1, 0, 3, 2};
   public int v9;
   public int[] v10 = new int[0];
   public int[] v11 = new int[0];
   public int[] v12 = new int[0];
   public int[] v13 = new int[0];
   public int[] v14 = new int[0];
   public float[] v15 = new float[0];
   public float[] v16 = new float[0];
   public boolean[] v18 = new boolean[0];
   public boolean[] v19 = new boolean[0];
   public hudSupport52[] v17 = new hudSupport52[0];
   public float[] v20 = new float[0];
   public float[] v21 = new float[0];
   public float[] v22 = new float[0];
   public float[] v24 = new float[0];
   public int[] v25 = new int[0];
   public float[] v26 = new float[0];
   public float[] v27 = new float[0];
   public float[] v28 = new float[0];
   public float[] v29 = new float[0];
   public boolean v30 = true;
   public int v32;
   private int[] v31 = new int[0];
   private int[] v34 = new int[0];
   private int[] v36 = new int[0];
   private int[] v38 = new int[0];
   private int[] v42 = new int[0];
   private int[] v43 = new int[0];
   private float[] v37 = new float[0];
   private float[] v48 = new float[0];
   private final int[] v40 = new int[4];

   public accountSupport6() {
   }

   public void v1(int var1) {
      this.v9(var1);
      this.v9 = var1;
      Arrays.fill(this.v10, 0, var1, -1);
      Arrays.fill(this.v11, 0, var1, 0);
      Arrays.fill(this.v12, 0, var1, 0);
      Arrays.fill(this.v13, 0, var1 * 4, -1);
      int var2 = 0;

      while (var2 < var1) {
         this.v14[var2] = var2++;
      }
   }

   private void v9(int var1) {
      if (this.v10.length < var1) {
         int var2 = Math.max(var1, this.v10.length * 2);
         this.v10 = new int[var2];
         this.v11 = new int[var2];
         this.v12 = new int[var2];
         this.v13 = new int[var2 * 4];
         this.v14 = new int[var2];
         this.v15 = new float[var2];
         this.v16 = new float[var2];
         this.v18 = new boolean[var2];
         this.v19 = new boolean[var2];
         this.v17 = new hudSupport52[var2];
         this.v20 = new float[var2];
         this.v21 = new float[var2];
         this.v22 = new float[var2];
         this.v24 = new float[var2];
         this.v25 = new int[var2];
         this.v26 = new float[var2];
         this.v27 = new float[var2];
         this.v28 = new float[var2];
         this.v29 = new float[var2];
         this.v31 = new int[var2];
         this.v34 = new int[var2];
         this.v36 = new int[var2];
         this.v38 = new int[var2 * 4];
         this.v42 = new int[var2];
         this.v43 = new int[var2];
         this.v37 = new float[var2];
         this.v48 = new float[var2];
      }
   }

   public int v1(int var1, int var2) {
      return this.v13[var1 * 4 + var2];
   }

   public boolean v2(int var1, int var2) {
      int var3 = var2;

      for (int var4 = 0; var3 != -1 && var4 <= this.v9; var4++) {
         if (var3 == var1) {
            return true;
         }

         var3 = this.v10[var3];
      }

      return false;
   }

   public boolean v1(int var1, int var2, int var3, int var4) {
      if (var1 != var2 && this.v10[var1] == -1 && this.v13[var2 * 4 + var3] == -1 && !this.v2(var1, var2)) {
         this.v5(var1, var2, var3, var4);
         return true;
      } else {
         return false;
      }
   }

   public boolean v2(int var1, int var2, int var3, int var4) {
      if (var1 != var2 && this.v10[var1] == -1 && !this.v2(var1, var2)) {
         int var5 = this.v13[var2 * 4 + var3];
         if (var5 != -1) {
            this.v10[var5] = -1;
            this.v13[var2 * 4 + var3] = -1;
         }

         this.v5(var1, var2, var3, var4);
         if (var5 != -1) {
            int var6 = var1;

            while (this.v13[var6 * 4 + var3] != -1) {
               var6 = this.v13[var6 * 4 + var3];
            }

            this.v5(var5, var6, var3, this.v12[var5]);
         }

         return true;
      } else {
         return false;
      }
   }

   public void v2(int var1) {
      int var2 = this.v10[var1];
      if (var2 != -1) {
         this.v13[var2 * 4 + this.v11[var1]] = -1;
         this.v10[var1] = -1;
         this.v14[var1] = var1;
      }
   }

   public static boolean v3(int var0) {
      return var0 == 0 || var0 == 1;
   }

   public boolean v3(int var1, int var2) {
      return this.v13[var1 * 4 + var2] == -1 && (this.v10[var1] == -1 || v3(this.v11[var1]) != v3(var2));
   }

   public boolean v3(int var1, int var2, int var3, int var4) {
      int var5 = this.v10[var2];
      if (var5 != -1 && var1 != var2 && this.v10[var1] == -1 && this.v3(var2, var3) && !this.v2(var1, var2)) {
         int var6 = this.v11[var2];
         this.v13[var5 * 4 + var6] = -1;
         this.v10[var2] = -1;
         this.v5(var1, var5, var6, this.v12[var2]);
         int var7 = this.v13[var2 * 4 + var6];
         if (var7 != -1 && this.v13[var1 * 4 + var6] == -1) {
            this.v13[var2 * 4 + var6] = -1;
            this.v10[var7] = -1;
            this.v5(var7, var1, var6, this.v12[var7]);
         }

         this.v5(var2, var1, v6(var3), var4);
         return true;
      } else {
         return false;
      }
   }

   public boolean v4(int var1, int var2, int var3, int var4) {
      if (this.v10[var2] == -1 && var1 != var2 && this.v10[var1] == -1 && this.v3(var2, var3) && !this.v2(var1, var2)) {
         if (v3(var3)) {
            for (int var5 = 2; var5 <= 3; var5++) {
               int var6 = this.v13[var2 * 4 + var5];
               if (var6 != -1) {
                  this.v13[var2 * 4 + var5] = -1;
                  this.v10[var6] = -1;
                  this.v5(var6, var1, var5, this.v12[var6]);
               }
            }
         }

         this.v5(var2, var1, v6(var3), var4);
         this.v14[var1] = this.v14[var2];
         this.v14[var2] = var2;
         return true;
      } else {
         return false;
      }
   }

   public void v4(int var1) {
      int var2 = this.v7(var1);
      if (var2 != var1) {
         int var3 = 0;

         for (int var4 = var1; var4 != -1 && var3 <= this.v9; var4 = this.v10[var4]) {
            var3++;
         }

         int[] var9 = new int[var3];
         int[] var5 = new int[var3];
         int[] var6 = new int[var3];
         int var7 = 0;

         for (int var8 = var1; var8 != -1 && var7 < var3; var8 = this.v10[var8]) {
            var9[var7] = var8;
            var5[var7] = this.v11[var8];
            var6[var7] = this.v12[var8];
            var7++;
         }

         for (int var10 = 0; var10 + 1 < var3; var10++) {
            this.v13[var9[var10 + 1] * 4 + var5[var10]] = -1;
            this.v10[var9[var10]] = -1;
         }

         for (int var11 = 0; var11 + 1 < var3; var11++) {
            this.v5(var9[var11 + 1], var9[var11], v6(var5[var11]), var6[var11]);
         }

         this.v14[var1] = this.v14[var2];
         this.v14[var2] = var2;
      }
   }

   private void v5(int var1, int var2, int var3, int var4) {
      this.v10[var1] = var2;
      this.v11[var1] = var3;
      this.v12[var1] = var4;
      this.v13[var2 * 4 + var3] = var1;
   }

   public void v5(int var1) {
      int var2 = this.v10[var1];
      int var3 = this.v11[var1];
      int var4 = this.v12[var1];
      int var5 = this.v10(var1);
      if (var2 != -1) {
         this.v13[var2 * 4 + var3] = -1;
         this.v10[var1] = -1;
      }

      int var6 = var1 * 4;

      for (int var7 = 0; var7 < 4; var7++) {
         int var8 = this.v13[var6 + var7];
         this.v40[var7] = var8;
         if (var8 != -1) {
            this.v10[var8] = -1;
            this.v13[var6 + var7] = -1;
         }
      }

      if (var5 == -1) {
         this.v14[var1] = var1;
      } else {
         if (var2 != -1) {
            this.v5(var5, var2, var3, this.v11[var5] == var3 ? this.v12[var5] : var4);
            int var12 = this.v13[var5 * 4 + v6(var3)];
            if (var12 != -1) {
               this.v13[var5 * 4 + v6(var3)] = -1;
               this.v10[var12] = -1;
               this.v2(var12, var2, var3, this.v12[var12]);
            }
         } else {
            this.v14[var5] = this.v14[var1];
         }

         this.v14[var1] = var1;

         for (int var10 : v33) {
            int var11 = this.v40[var10];
            if (var11 != -1 && var11 != var5) {
               this.v2(var11, var5, var10, this.v12[var11]);
            }
         }
      }
   }

   private int v10(int var1) {
      int var2 = var1 * 4;
      if (this.v10[var1] == -1) {
         return this.v1(var2, 1, 0, 3, 2);
      } else {
         int var3 = this.v11[var1];
         return var3 != 0 && var3 != 1 ? this.v1(var2, 1, 0, var3, v6(var3)) : this.v1(var2, var3, 3, 2, v6(var3));
      }
   }

   private int v1(int var1, int var2, int var3, int var4, int var5) {
      if (this.v13[var1 + var2] != -1) {
         return this.v13[var1 + var2];
      } else if (this.v13[var1 + var3] != -1) {
         return this.v13[var1 + var3];
      } else {
         return this.v13[var1 + var4] != -1 ? this.v13[var1 + var4] : this.v13[var1 + var5];
      }
   }

   public static int v6(int var0) {
      return switch (var0) {
         case 0 -> 1;
         case 1 -> 0;
         case 2 -> 3;
         default -> 2;
      };
   }

   public void v4(int var1, int var2) {
      if (var1 != var2) {
         v1(this.v10, var1, var2);
         v1(this.v11, var1, var2);
         v1(this.v12, var1, var2);
         v1(this.v14, var1, var2);

         for (int var3 = 0; var3 < 4; var3++) {
            v1(this.v13, var1 * 4 + var3, var2 * 4 + var3);
         }

         for (int var5 = 0; var5 < this.v9; var5++) {
            this.v10[var5] = v1(this.v10[var5], var1, var2);
         }

         int var6 = 0;

         for (int var4 = this.v9 * 4; var6 < var4; var6++) {
            this.v13[var6] = v1(this.v13[var6], var1, var2);
         }
      }
   }

   private static int v1(int var0, int var1, int var2) {
      return var0 == var1 ? var2 : (var0 == var2 ? var1 : var0);
   }

   private static void v1(int[] var0, int var1, int var2) {
      int var3 = var0[var1];
      var0[var1] = var0[var2];
      var0[var2] = var3;
   }

   public void v1(float var1, float var2, float var3, float var4, DoubleUnaryOperator var5) {
      this.v32 = 0;

      for (int var6 = 0; var6 < this.v9; var6++) {
         if (!this.v18[var6]) {
            this.v5(var6);
         }
      }

      for (int var7 = 0; var7 < this.v9; var7++) {
         this.v22[var7] = Float.NaN;
         this.v24[var7] = Float.NaN;
         this.v25[var7] = -1;
      }

      for (int var8 = 0; var8 < this.v9; var8++) {
         if (this.v18[var8] && this.v10[var8] == -1) {
            this.v1(var8, var1, var2, var3, var4, var5);
         }
      }
   }

   public void v2(float var1, float var2, float var3, float var4, DoubleUnaryOperator var5) {
      System.arraycopy(this.v10, 0, this.v31, 0, this.v9);
      System.arraycopy(this.v11, 0, this.v34, 0, this.v9);
      System.arraycopy(this.v12, 0, this.v36, 0, this.v9);
      System.arraycopy(this.v13, 0, this.v38, 0, this.v9 * 4);
      System.arraycopy(this.v14, 0, this.v42, 0, this.v9);
      this.v1(var1, var2, var3, var4, var5);
      System.arraycopy(this.v31, 0, this.v10, 0, this.v9);
      System.arraycopy(this.v34, 0, this.v11, 0, this.v9);
      System.arraycopy(this.v36, 0, this.v12, 0, this.v9);
      System.arraycopy(this.v38, 0, this.v13, 0, this.v9 * 4);
      System.arraycopy(this.v42, 0, this.v14, 0, this.v9);
   }

   public int v7(int var1) {
      int var2 = var1;

      for (int var3 = 0; this.v10[var2] != -1 && var3 <= this.v9; var3++) {
         var2 = this.v10[var2];
      }

      return var2;
   }

   public int v8(int var1) {
      return this.v10(var1);
   }

   private void v1(int var1, float var2, float var3, float var4, float var5, DoubleUnaryOperator var6) {
      int var7 = 0;
      int var8 = 0;
      this.v43[var8++] = var1;
      this.v37[var1] = 0.0F;
      this.v48[var1] = 0.0F;
      float var9 = 0.0F;
      float var10 = 0.0F;
      float var11 = this.v15[var1];
      float var12 = this.v16[var1];
      boolean var13 = this.v19[var1];

      while (var7 < var8) {
         int var14 = this.v43[var7++];

         for (int var15 = 0; var15 < 4; var15++) {
            int var16 = this.v13[var14 * 4 + var15];
            if (var16 != -1 && var8 < this.v9) {
               switch (var15) {
                  case 0:
                     this.v37[var16] = this.v37[var14] - var5 - this.v15[var16];
                     this.v48[var16] = v1(this.v48[var14], this.v16[var14], this.v16[var16], this.v12[var16]);
                     break;
                  case 1:
                     this.v37[var16] = this.v37[var14] + this.v15[var14] + var5;
                     this.v48[var16] = v1(this.v48[var14], this.v16[var14], this.v16[var16], this.v12[var16]);
                     break;
                  case 2:
                  default:
                     this.v48[var16] = this.v48[var14] - var5 - this.v16[var16];
                     this.v37[var16] = v1(this.v37[var14], this.v15[var14], this.v15[var16], this.v12[var16]);
                     break;
                  case 3:
                     this.v48[var16] = this.v48[var14] + this.v16[var14] + var5;
                     this.v37[var16] = v1(this.v37[var14], this.v15[var14], this.v15[var16], this.v12[var16]);
               }

               this.v1(var16, var15, var8, var5);
               var9 = Math.min(var9, this.v37[var16]);
               var10 = Math.min(var10, this.v48[var16]);
               var11 = Math.max(var11, this.v37[var16] + this.v15[var16]);
               var12 = Math.max(var12, this.v48[var16] + this.v16[var16]);
               var13 &= this.v19[var16];
               this.v43[var8++] = var16;
            }
         }
      }

      float var27 = var11 - var9;
      float var28 = var12 - var10;
      int var29 = this.v14[var1];
      hudSupport52 var17 = this.v17[var29];
      float var18 = var17.v1(var2, var27, this.v20[var29] * var4);
      float var19 = var17.v2(var3, var28, this.v21[var29] * var4);
      if (this.v30) {
         var18 = v1(var18, var27, var2);
         var19 = v1(var19, var28, var3);
      }

      float var20 = var18 - var9;
      float var21 = var19 - var10;

      for (int var22 = 0; var22 < var8; var22++) {
         int var23 = this.v43[var22];
         float var24 = this.v37[var23] + var20;
         float var25 = this.v48[var23] + var21;
         this.v22[var23] = var13 ? (float)var6.applyAsDouble(var24) : var24;
         this.v24[var23] = var13 ? (float)var6.applyAsDouble(var25) : var25;
         this.v25[var23] = var1;
      }

      this.v26[var1] = var18;
      this.v27[var1] = var19;
      this.v28[var1] = var27;
      this.v29[var1] = var28;
   }

   private void v1(int var1, int var2, int var3, float var4) {
      float var5 = 0.01F;

      for (int var6 = 0; var6 <= var3; var6++) {
         int var7 = -1;

         for (int var8 = 0; var8 < var3; var8++) {
            int var9 = this.v43[var8];
            if (this.v37[var1] < this.v37[var9] + this.v15[var9] + var4 - var5
               && this.v37[var9] < this.v37[var1] + this.v15[var1] + var4 - var5
               && this.v48[var1] < this.v48[var9] + this.v16[var9] + var4 - var5
               && this.v48[var9] < this.v48[var1] + this.v16[var1] + var4 - var5
               && var9 != this.v10[var1]) {
               var7 = var9;
               break;
            }
         }

         if (var7 == -1) {
            return;
         }

         if (var6 == 0) {
            this.v32++;
         }

         switch (var2) {
            case 0:
               this.v37[var1] = this.v37[var7] - var4 - this.v15[var1];
               break;
            case 1:
               this.v37[var1] = this.v37[var7] + this.v15[var7] + var4;
               break;
            case 2:
            default:
               this.v48[var1] = this.v48[var7] - var4 - this.v16[var1];
               break;
            case 3:
               this.v48[var1] = this.v48[var7] + this.v16[var7] + var4;
         }
      }
   }

   private static float v1(float var0, float var1, float var2) {
      return var1 >= var2 ? 0.0F : Math.max(0.0F, Math.min(var0, var2 - var1));
   }

   public static float v1(float var0, float var1, float var2, int var3) {
      return switch (var3) {
         case 0 -> var0;
         case 1 -> var0 + (var1 - var2) * 0.5F;
         default -> var0 + var1 - var2;
      };
   }

   public static float v1(float var0, float var1, int var2, int var3, float var4, float var5) {
      return switch (var2) {
         case 0 -> var0 - var5 - var4;
         case 1 -> var0 + var1 + var5;
         default -> v1(var0, var1, var4, var3);
      };
   }

   public static float v2(float var0, float var1, int var2, int var3, float var4, float var5) {
      return switch (var2) {
         case 2 -> var0 - var5 - var4;
         case 3 -> var0 + var1 + var5;
         default -> v1(var0, var1, var4, var3);
      };
   }
}
