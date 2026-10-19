package cc.syky.cloud;

import java.util.Arrays;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;

public final class cloudSupport41 {
   public static final float v1 = 0.016666668F;
   private static final int v5 = 6;
   public static final float v2 = 0.25F;
   public static final double v3 = 8.0;
   private static final float v6 = 40.0F;
   private static final int v7 = 30;
   public static final int v4 = 6;
   private final cloudRecord6 v8;
   private final int v9;
   private final int v10;
   private final int v11;
   private final float[] v12;
   private final float[] v13;
   private final float[] v14;
   private final float[] v15;
   private final float[] v16;
   private final float[] v18;
   private final float[] v19;
   private final float[] v17;
   private final int[] v20;
   private final float[] v21;
   private final float[] v22;
   private final float[] v24;
   private final Matrix4f v25 = new Matrix4f();
   private final Matrix3f v26 = new Matrix3f();
   private final Vector3f v27 = new Vector3f();
   private final float v28;
   private double v29;
   private double v30;
   private double v32;
   private double v23;
   private boolean v33;
   private int v31 = -1;
   private final float[] v34;

   public cloudSupport41(cloudRecord6 var1, int var2) {
      this.v8 = var1;
      this.v9 = var1.v2();
      this.v10 = var1.v3();
      this.v11 = this.v9 * this.v10;
      this.v12 = new float[this.v11 * 3];
      this.v13 = new float[this.v11 * 3];
      this.v14 = new float[this.v11 * 3];
      this.v15 = new float[this.v11 * 3];
      this.v16 = new float[this.v11 * 3];
      this.v18 = new float[this.v11 * 3];
      this.v19 = new float[this.v9 * 3];
      this.v17 = new float[this.v9 * 3];
      this.v28 = (var2 * -1640531527 >>> 8) / 1.6777216E7F * (float) (Math.PI * 2);
      float var3 = var1.v4() / (this.v9 - 1);
      float var4 = var1.v5() / (this.v10 - 1);

      for (int var5 = 0; var5 < this.v10; var5++) {
         for (int var6 = 0; var6 < this.v9; var6++) {
            int var7 = (var5 * this.v9 + var6) * 3;
            this.v18[var7] = -var1.v4() / 2.0F + var6 * var3;
            this.v18[var7 + 1] = var1.v7() + var5 * var4;
            this.v18[var7 + 2] = var1.v8();
         }
      }

      System.arraycopy(this.v18, 0, this.v16, 0, this.v18.length);
      this.v24 = new float[this.v11];

      for (int var12 = 0; var12 < this.v11; var12++) {
         int var14 = var12 / this.v9;
         this.v24[var12] = var14 * var4;
      }

      int var13 = (this.v9 - 1) * this.v10 + this.v9 * (this.v10 - 1);
      int var15 = 2 * (this.v9 - 1) * (this.v10 - 1);
      int var16 = Math.max(0, this.v9 - 2) * this.v10 + this.v9 * Math.max(0, this.v10 - 2);
      int var8 = var13 + var15 + var16;
      this.v20 = new int[var8 * 2];
      this.v21 = new float[var8];
      this.v22 = new float[var8];
      this.v34 = new float[var8];
      int var9 = 0;

      for (int var10 = 0; var10 < this.v10; var10++) {
         for (int var11 = 0; var11 < this.v9; var11++) {
            if (var11 + 1 < this.v9) {
               var9 = this.v1(var9, var10, var11, var10, var11 + 1, 1.0F);
            }

            if (var10 + 1 < this.v10) {
               var9 = this.v1(var9, var10, var11, var10 + 1, var11, 1.0F);
            }

            if (var11 + 1 < this.v9 && var10 + 1 < this.v10) {
               var9 = this.v1(var9, var10, var11, var10 + 1, var11 + 1, 0.9F);
               var9 = this.v1(var9, var10, var11 + 1, var10 + 1, var11, 0.9F);
            }

            if (var11 + 2 < this.v9) {
               var9 = this.v1(var9, var10, var11, var10, var11 + 2, var1.v12());
            }

            if (var10 + 2 < this.v10) {
               var9 = this.v1(var9, var10, var11, var10 + 2, var11, var1.v12());
            }
         }
      }
   }

   private int v1(int var1, int var2, int var3, int var4, int var5, float var6) {
      int var7 = var2 * this.v9 + var3;
      int var8 = var4 * this.v9 + var5;
      this.v20[var1 * 2] = var7;
      this.v20[var1 * 2 + 1] = var8;
      float var9 = this.v18[var8 * 3] - this.v18[var7 * 3];
      float var10 = this.v18[var8 * 3 + 1] - this.v18[var7 * 3 + 1];
      float var11 = this.v18[var8 * 3 + 2] - this.v18[var7 * 3 + 2];
      this.v21[var1] = (float)Math.sqrt(var9 * var9 + var10 * var10 + var11 * var11);
      this.v22[var1] = var6;
      return var1 + 1;
   }

   public cloudRecord6 v1() {
      return this.v8;
   }

   public int v2() {
      return this.v9;
   }

   public int v3() {
      return this.v10;
   }

   public float[] v4() {
      return this.v16;
   }

   public void v5() {
      this.v33 = false;
   }

   public void v1(float var1, float var2, float var3) {
      this.v33 = false;
      this.v26.rotationXYZ(var1, 0.0F, 0.0F).rotateZ(var2).rotateY(var3);
      float var4 = 0.0F;
      float var5 = this.v8.v7();
      float var6 = this.v8.v8();

      for (byte var7 = 0; var7 < this.v11 * 3; var7 += 3) {
         this.v27.set(this.v18[var7] - var4, this.v18[var7 + 1] - var5, this.v18[var7 + 2] - var6);
         this.v26.transform(this.v27);
         this.v16[var7] = this.v27.x + var4;
         this.v16[var7 + 1] = this.v27.y + var5;
         this.v16[var7 + 2] = this.v27.z + var6;
      }
   }

   public void v1(double var1, double var3, double var5, double var7, Matrix4fc var9, int var10) {
      if (Math.abs(var9.determinant()) > 1.0E-12F) {
         var9.invert(this.v25);
         this.v1(Math.max(1, Math.min(6, var10)));
         double var11 = var3 - this.v29;
         double var13 = var5 - this.v30;
         double var15 = var7 - this.v32;
         float var17 = (float)(var1 - this.v23);
         if (!this.v33 || !(var17 >= 0.0F) || var17 > 0.25F || var11 * var11 + var13 * var13 + var15 * var15 > 64.0) {
            this.v1(var1, var3, var5, var7, var9);
         } else if (var17 == 0.0F) {
            this.v9();
         } else {
            this.v2((float)(-var11), (float)(-var13), (float)(-var15));
            this.v29 = var3;
            this.v30 = var5;
            this.v32 = var7;
            this.v1(var9, this.v17);
            int var18 = Math.min(6, (int)Math.ceil(var17 / 0.016666668F));
            float var19 = var17 / var18;

            for (int var20 = 1; var20 <= var18; var20++) {
               this.v1(var19, this.v23 + var19 * var20, (float)var20 / var18, var9);
            }

            System.arraycopy(this.v17, 0, this.v19, 0, this.v17.length);
            this.v23 = var1;
            this.v9();
         }
      }
   }

   private void v1(double var1, double var3, double var5, double var7, Matrix4fc var9) {
      this.v29 = var3;
      this.v30 = var5;
      this.v32 = var7;

      for (int var10 = 0; var10 < this.v11; var10++) {
         this.v1(var9, this.v18, var10 * 3, this.v12, var10 * 3);
      }

      Arrays.fill(this.v13, 0.0F);
      this.v1(var9, this.v17);
      System.arraycopy(this.v17, 0, this.v19, 0, this.v17.length);

      for (int var11 = 0; var11 < 30; var11++) {
         this.v1(0.016666668F, var1, 1.0F, var9);
      }

      Arrays.fill(this.v13, 0.0F);
      this.v23 = var1;
      this.v33 = true;
      this.v9();
   }

   private void v1(int var1) {
      if (var1 != this.v31) {
         this.v31 = var1;

         for (int var2 = 0; var2 < this.v22.length; var2++) {
            this.v34[var2] = 1.0F - (float)Math.pow(1.0F - this.v22[var2], 1.0 / var1);
         }
      }
   }

   private void v2(float var1, float var2, float var3) {
      for (byte var4 = 0; var4 < this.v11 * 3; var4 += 3) {
         this.v12[var4] = this.v12[var4] + var1;
         this.v12[var4 + 1] = this.v12[var4 + 1] + var2;
         this.v12[var4 + 2] = this.v12[var4 + 2] + var3;
      }

      for (byte var5 = 0; var5 < this.v9 * 3; var5 += 3) {
         this.v19[var5] = this.v19[var5] + var1;
         this.v19[var5 + 1] = this.v19[var5 + 1] + var2;
         this.v19[var5 + 2] = this.v19[var5 + 2] + var3;
      }
   }

   private void v1(Matrix4fc var1, float[] var2) {
      for (int var3 = 0; var3 < this.v9; var3++) {
         this.v1(var1, this.v18, var3 * 3, var2, var3 * 3);
      }
   }

   private void v1(float var1, double var2, float var4, Matrix4fc var5) {
      this.v8();
      float var6 = this.v8.v11() * var1;
      float var7 = (float)Math.exp(-this.v8.v10() * var1);
      float var8 = this.v8.v9() * var1;
      float var9 = this.v28 + 0.35F * (float)Math.sin(var2 * 0.21 + this.v28);
      float var10 = (float)Math.cos(var9);
      float var11 = (float)Math.sin(var9);

      for (int var12 = 0; var12 < this.v9; var12++) {
         int var13 = var12 * 3;
         this.v14[var13] = this.v19[var13] + (this.v17[var13] - this.v19[var13]) * var4;
         this.v14[var13 + 1] = this.v19[var13 + 1] + (this.v17[var13 + 1] - this.v19[var13 + 1]) * var4;
         this.v14[var13 + 2] = this.v19[var13 + 2] + (this.v17[var13 + 2] - this.v19[var13 + 2]) * var4;
      }

      for (int var27 = this.v9; var27 < this.v11; var27++) {
         int var30 = var27 * 3;
         int var14 = var27 % this.v9;
         int var15 = var27 / this.v9;
         float var16 = this.v8.v13()
            * (0.6F + 0.4F * (float)(Math.sin(var2 * 1.9 + this.v28 + var14 * 0.45F - var15 * 0.3F) * Math.sin(var2 * 0.73 + this.v28 * 2.1F)));
         float var17 = var10 * var16;
         float var18 = var11 * var16;
         float var19 = this.v13[var30];
         float var20 = this.v13[var30 + 1] - var8;
         float var21 = this.v13[var30 + 2];
         float var22 = this.v15[var30];
         float var23 = this.v15[var30 + 1];
         float var24 = this.v15[var30 + 2];
         float var25 = (var19 - var17) * var22 + var20 * var23 + (var21 - var18) * var24;
         float var26 = var25 * Math.min(1.0F, var6 * Math.abs(var25));
         var19 -= var22 * var26;
         var20 -= var23 * var26;
         var21 -= var24 * var26;
         var19 = var17 + (var19 - var17) * var7;
         var20 *= var7;
         var21 = var18 + (var21 - var18) * var7;
         this.v13[var30] = var19;
         this.v13[var30 + 1] = var20;
         this.v13[var30 + 2] = var21;
         this.v14[var30] = this.v12[var30] + var19 * var1;
         this.v14[var30 + 1] = this.v12[var30 + 1] + var20 * var1;
         this.v14[var30 + 2] = this.v12[var30 + 2] + var21 * var1;
      }

      for (int var28 = 0; var28 < this.v31; var28++) {
         this.v6();
         this.v7();
      }

      this.v1(var5);
      float var29 = 1.0F / var1;

      for (int var31 = 0; var31 < this.v11; var31++) {
         int var32 = var31 * 3;
         if (var31 < this.v9) {
            this.v12[var32] = this.v14[var32];
            this.v12[var32 + 1] = this.v14[var32 + 1];
            this.v12[var32 + 2] = this.v14[var32 + 2];
         } else {
            float var33 = (this.v14[var32] - this.v12[var32]) * var29;
            float var34 = (this.v14[var32 + 1] - this.v12[var32 + 1]) * var29;
            float var35 = (this.v14[var32 + 2] - this.v12[var32 + 2]) * var29;
            float var36 = var33 * var33 + var34 * var34 + var35 * var35;
            if (!(var36 <= 1600.0F)) {
               float var39 = Float.isFinite(var36) ? 40.0F / (float)Math.sqrt(var36) : 0.0F;
               var33 *= var39;
               var34 *= var39;
               var35 *= var39;
            }

            this.v13[var32] = var33;
            this.v13[var32 + 1] = var34;
            this.v13[var32 + 2] = var35;
            if (Float.isFinite(this.v14[var32]) && Float.isFinite(this.v14[var32 + 1]) && Float.isFinite(this.v14[var32 + 2])) {
               this.v12[var32] = this.v14[var32];
               this.v12[var32 + 1] = this.v14[var32 + 1];
               this.v12[var32 + 2] = this.v14[var32 + 2];
            } else {
               this.v33 = false;
            }
         }
      }
   }

   private void v6() {
      for (int var1 = 0; var1 < this.v21.length; var1++) {
         int var2 = this.v20[var1 * 2];
         int var3 = this.v20[var1 * 2 + 1];
         float var4 = var2 < this.v9 ? 0.0F : 1.0F;
         float var5 = var3 < this.v9 ? 0.0F : 1.0F;
         float var6 = var4 + var5;
         if (var6 != 0.0F) {
            int var7 = var2 * 3;
            int var8 = var3 * 3;
            float var9 = this.v14[var8] - this.v14[var7];
            float var10 = this.v14[var8 + 1] - this.v14[var7 + 1];
            float var11 = this.v14[var8 + 2] - this.v14[var7 + 2];
            float var12 = (float)Math.sqrt(var9 * var9 + var10 * var10 + var11 * var11);
            if (!(var12 < 1.0E-6F)) {
               float var13 = this.v34[var1] * (var12 - this.v21[var1]) / (var6 * var12);
               this.v14[var7] = this.v14[var7] + var4 * var13 * var9;
               this.v14[var7 + 1] = this.v14[var7 + 1] + var4 * var13 * var10;
               this.v14[var7 + 2] = this.v14[var7 + 2] + var4 * var13 * var11;
               this.v14[var8] = this.v14[var8] - var5 * var13 * var9;
               this.v14[var8 + 1] = this.v14[var8 + 1] - var5 * var13 * var10;
               this.v14[var8 + 2] = this.v14[var8 + 2] - var5 * var13 * var11;
            }
         }
      }
   }

   private void v7() {
      for (int var1 = this.v9; var1 < this.v11; var1++) {
         int var2 = var1 * 3;
         int var3 = var1 % this.v9 * 3;
         float var4 = this.v14[var2] - this.v14[var3];
         float var5 = this.v14[var2 + 1] - this.v14[var3 + 1];
         float var6 = this.v14[var2 + 2] - this.v14[var3 + 2];
         float var7 = var4 * var4 + var5 * var5 + var6 * var6;
         float var8 = this.v24[var1];
         if (var7 > var8 * var8) {
            float var9 = var8 / (float)Math.sqrt(var7);
            this.v14[var2] = this.v14[var3] + var4 * var9;
            this.v14[var2 + 1] = this.v14[var3 + 1] + var5 * var9;
            this.v14[var2 + 2] = this.v14[var3 + 2] + var6 * var9;
         }
      }
   }

   private void v1(Matrix4fc var1) {
      float var2 = this.v8.v7() - 0.0625F;
      float var3 = this.v8.v7() + this.v8.v14();
      float var4 = this.v8.v8();
      float var5 = this.v8.v15();

      for (int var6 = this.v9; var6 < this.v11; var6++) {
         int var7 = var6 * 3;
         this.v25.transformPosition(this.v14[var7], this.v14[var7 + 1], this.v14[var7 + 2], this.v27);
         if (this.v27.y > var2 && this.v27.y < var3 && Math.abs(this.v27.x) < var5 && this.v27.z < var4) {
            this.v27.z = var4;
            var1.transformPosition(this.v27);
            this.v14[var7] = this.v27.x;
            this.v14[var7 + 1] = this.v27.y;
            this.v14[var7 + 2] = this.v27.z;
         }
      }
   }

   private void v8() {
      for (int var1 = 0; var1 < this.v10; var1++) {
         int var2 = Math.max(0, var1 - 1);
         int var3 = Math.min(this.v10 - 1, var1 + 1);

         for (int var4 = 0; var4 < this.v9; var4++) {
            int var5 = (var1 * this.v9 + Math.max(0, var4 - 1)) * 3;
            int var6 = (var1 * this.v9 + Math.min(this.v9 - 1, var4 + 1)) * 3;
            int var7 = (var2 * this.v9 + var4) * 3;
            int var8 = (var3 * this.v9 + var4) * 3;
            float var9 = this.v12[var6] - this.v12[var5];
            float var10 = this.v12[var6 + 1] - this.v12[var5 + 1];
            float var11 = this.v12[var6 + 2] - this.v12[var5 + 2];
            float var12 = this.v12[var8] - this.v12[var7];
            float var13 = this.v12[var8 + 1] - this.v12[var7 + 1];
            float var14 = this.v12[var8 + 2] - this.v12[var7 + 2];
            float var15 = var10 * var14 - var11 * var13;
            float var16 = var11 * var12 - var9 * var14;
            float var17 = var9 * var13 - var10 * var12;
            float var18 = (float)Math.sqrt(var15 * var15 + var16 * var16 + var17 * var17);
            int var19 = (var1 * this.v9 + var4) * 3;
            if (var18 > 1.0E-9F) {
               this.v15[var19] = var15 / var18;
               this.v15[var19 + 1] = var16 / var18;
               this.v15[var19 + 2] = var17 / var18;
            } else {
               this.v15[var19] = 0.0F;
               this.v15[var19 + 1] = 0.0F;
               this.v15[var19 + 2] = 0.0F;
            }
         }
      }
   }

   private void v9() {
      for (int var1 = 0; var1 < this.v11; var1++) {
         int var2 = var1 * 3;
         if (var1 < this.v9) {
            this.v16[var2] = this.v18[var2];
            this.v16[var2 + 1] = this.v18[var2 + 1];
            this.v16[var2 + 2] = this.v18[var2 + 2];
         } else {
            this.v25.transformPosition(this.v12[var2], this.v12[var2 + 1], this.v12[var2 + 2], this.v27);
            this.v16[var2] = this.v27.x;
            this.v16[var2 + 1] = this.v27.y;
            this.v16[var2 + 2] = this.v27.z;
         }
      }
   }

   private void v1(Matrix4fc var1, float[] var2, int var3, float[] var4, int var5) {
      var1.transformPosition(var2[var3], var2[var3 + 1], var2[var3 + 2], this.v27);
      var4[var5] = this.v27.x;
      var4[var5 + 1] = this.v27.y;
      var4[var5 + 2] = this.v27.z;
   }
}
