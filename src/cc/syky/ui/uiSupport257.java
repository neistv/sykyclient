package cc.syky.ui;

import cc.syky.cloud.cloudSupport45;
import cc.syky.cloud.cloudSupport47;
import cc.syky.cloud.cloudSupport51;
import cc.syky.internal.InternalSupport63;
import java.util.Arrays;

public final class uiSupport257 {
   public static final int v1 = 60;
   public static final int v2 = 4096;
   private static final cloudSupport51[] v3 = cloudSupport51.values();
   private final float[] v4;
   private final float[] v5;
   private final float v6;

   private uiSupport257(float[] var1) {
      this.v4 = var1;
      this.v5 = new float[v3.length];
      float var2 = 0.0F;

      for (int var3 = 0; var3 < v3.length; var3++) {
         int var4 = var3 * 6;
         if (!(var1[var4] > var1[var4 + 3])) {
            float var5 = Math.max(Math.abs(var1[var4]), Math.abs(var1[var4 + 3]));
            float var6 = Math.max(Math.abs(var1[var4 + 1]), Math.abs(var1[var4 + 4]));
            float var7 = Math.max(Math.abs(var1[var4 + 2]), Math.abs(var1[var4 + 5]));
            this.v5[var3] = (float)Math.sqrt(var5 * var5 + var6 * var6 + var7 * var7);
            var2 = Math.max(var2, this.v5[var3]);
         }
      }

      this.v6 = var2;
   }

   public static uiSupport257 v1(uiSupport255 var0, uiSupport256 var1, cloudSupport45[] var2) {
      int var3 = var0.v1();
      float[] var4 = v1(var3);
      float[] var5 = var1.v1();

      for (int var6 = 0; var6 < var1.v3(); var6++) {
         int var7 = var1.v1(var6) * 6;
         int var8 = (var1.v3(var6) + var1.v4(var6)) * 8;

         for (int var9 = var1.v3(var6) * 8; var9 < var8; var9 += 8) {
            for (int var10 = 0; var10 < 3; var10++) {
               var4[var7 + var10] = Math.min(var4[var7 + var10], var5[var9 + var10]);
               var4[var7 + 3 + var10] = Math.max(var4[var7 + 3 + var10], var5[var9 + var10]);
            }
         }
      }

      float[] var18 = v1(v3.length);
      InternalSupport63 var19 = new InternalSupport63(var3);
      float[] var20 = new float[var3 * 3];
      float[] var21 = new float[var3 * 3];
      float[] var22 = new float[var3 * 3];
      Arrays.fill(var22, 1.0F);
      var19.v1(var0, var20, var21, var22);
      v1(var0, var19, var4, var18);
      int var11 = 4096 / Math.max(1, var2.length);

      for (cloudSupport45 var15 : var2) {
         int var16 = Math.max(1, Math.min(var11, (int)Math.ceil(var15.v2() * 60.0F)));

         for (int var17 = 0; var17 <= var16; var17++) {
            Arrays.fill(var20, 0.0F);
            Arrays.fill(var21, 0.0F);
            Arrays.fill(var22, 1.0F);
            var15.v1(var15.v2() * var17 / var16, var20, var21, var22);
            var19.v1(var0, var20, var21, var22);
            v1(var0, var19, var4, var18);
         }
      }

      return new uiSupport257(var18);
   }

   private static float[] v1(int var0) {
      float[] var1 = new float[var0 * 6];

      for (byte var2 = 0; var2 < var1.length; var2 += 6) {
         Arrays.fill(var1, var2, var2 + 3, Float.POSITIVE_INFINITY);
         Arrays.fill(var1, var2 + 3, var2 + 6, Float.NEGATIVE_INFINITY);
      }

      return var1;
   }

   private static void v1(uiSupport255 var0, InternalSupport63 var1, float[] var2, float[] var3) {
      float[] var4 = new float[6];

      for (int var5 = 0; var5 < var0.v1(); var5++) {
         int var6 = var5 * 6;
         if (!(var2[var6] > var2[var6 + 3])) {
            cloudSupport47.v1(var1.v1(var5), var2[var6], var2[var6 + 1], var2[var6 + 2], var2[var6 + 3], var2[var6 + 4], var2[var6 + 5], var4);
            int var7 = var0.v3(var5).ordinal() * 6;

            for (int var8 = 0; var8 < 3; var8++) {
               var3[var7 + var8] = Math.min(var3[var7 + var8], var4[var8]);
               var3[var7 + 3 + var8] = Math.max(var3[var7 + 3 + var8], var4[3 + var8]);
            }
         }
      }
   }

   public boolean v1(cloudSupport51 var1) {
      int var2 = var1.ordinal() * 6;
      return this.v4[var2] <= this.v4[var2 + 3];
   }

   public float v1(cloudSupport51 var1, int var2) {
      return this.v4[var1.ordinal() * 6 + var2];
   }

   public float v2(cloudSupport51 var1) {
      return this.v5[var1.ordinal()];
   }

   public float v1() {
      return this.v6;
   }
}
