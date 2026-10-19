package cc.syky.cloud;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class cloudSupport24 {
   public static final int v1 = 4;
   public static final int v2 = 40;
   public static final int v3 = 160;
   public static final int v4 = 1;
   public static final int v5 = 162;
   public static final int v6 = 49;
   public static final int v7 = 7;
   public static final int v8 = 1134;
   public static final int v9 = 2;
   public static final float v10 = 2.0F;
   private static final float v11 = 0.55F;
   private static final float v12 = 0.1F;
   private static final float v13 = 0.25F;
   private static final float v14 = 0.12F;

   private cloudSupport24() {
   }

   public static ByteBuffer v1() {
      ByteBuffer var0 = ByteBuffer.allocateDirect(5143824).order(ByteOrder.nativeOrder());

      for (int var1 = 0; var1 < 5143824; var1++) {
         var0.put(var1, (byte)-128);
      }

      float[] var4 = v1(0);
      v1(var0, 0, var4, 0);

      for (int var2 = 1; var2 < 49; var2++) {
         float[] var3 = v1(var2);
         v1(var0, var2, var3, 0);
         v1(var0, var2 - 1, var3, 2);
      }

      v1(var0, 48, var4, 2);
      return var0;
   }

   public static float[] v1(int var0) {
      float[] var1 = new float[51200];
      float var2 = var0 * 2.0F / 49.0F;
      float var3 = (float) (Math.PI * 20);

      for (int var4 = 0; var4 < 4; var4++) {
         for (int var5 = 0; var5 < 4; var5++) {
            float var6 = var2 + v2(v1(var5, var4, 0)) * 2.0F;
            int var7 = (int)Math.floor(var6);
            float var8 = var6 - var7;
            int var9 = Math.floorMod(var7, 2);
            float var10 = var5 + 0.2F + 0.6F * v2(v1(var5, var4, 1 + 2 * var9));
            float var11 = var4 + 0.2F + 0.6F * v2(v1(var5, var4, 2 + 2 * var9));
            float var12 = (1.0F - var8) * (1.0F - var8) * v1(0.0F, 0.1F, var8);
            float var13 = 0.0F;
            if (var8 < 0.25F) {
               float var14 = var8 / 0.25F;
               var13 = v1(0.0F, 0.3F, var14) * (1.0F - v1(0.3F, 1.0F, var14));
            }

            float var31 = Math.max(var8 * 0.55F + 0.030000001F, var13 > 0.0F ? 0.35999998F : 0.0F);
            int var15 = (int)Math.floor((var10 - var31) * 40.0F);
            int var16 = (int)Math.ceil((var10 + var31) * 40.0F);
            int var17 = (int)Math.floor((var11 - var31) * 40.0F);
            int var18 = (int)Math.ceil((var11 + var31) * 40.0F);

            for (int var19 = var17; var19 <= var18; var19++) {
               for (int var20 = var15; var20 <= var16; var20++) {
                  float var21 = (var20 + 0.5F) / 40.0F - var10;
                  float var22 = (var19 + 0.5F) / 40.0F - var11;
                  float var23 = (float)Math.sqrt(var21 * var21 + var22 * var22);
                  if (!(var23 > var31) && !(var23 < 1.0E-4F)) {
                     float var24 = var23 - var8 * 0.55F;
                     float var25 = v1(-0.25F, -0.05F, var24) * (1.0F - v1(-0.020000001F, 0.030000001F, var24));
                     float var26 = var3 * (float)Math.cos(var3 * var24) * var25 * var12 / var23;
                     float var27 = var21 * var26;
                     float var28 = var22 * var26;
                     if (var13 > 0.0F) {
                        float var29 = (float)Math.exp(-var23 * var23 / 0.0144F);
                        float var30 = 1.17F * var3 * var29 * var13 / 0.12F;
                        var27 -= var21 * var30;
                        var28 -= var22 * var30;
                     }

                     int var32 = (Math.floorMod(var20, 160) + Math.floorMod(var19, 160) * 160) * 2;
                     var1[var32] += var27 / var3;
                     var1[var32 + 1] = var1[var32 + 1] + var28 / var3;
                  }
               }
            }
         }
      }

      return var1;
   }

   private static void v1(ByteBuffer var0, int var1, float[] var2, int var3) {
      int var4 = var1 % 7 * 162;
      int var5 = var1 / 7 * 162;

      for (int var6 = 0; var6 < 162; var6++) {
         int var7 = Math.floorMod(var6 - 1, 160);

         for (int var8 = 0; var8 < 162; var8++) {
            int var9 = Math.floorMod(var8 - 1, 160);
            int var10 = (var9 + var7 * 160) * 2;
            int var11 = (var4 + var8 + (var5 + var6) * 1134) * 4 + var3;
            var0.put(var11, v1(var2[var10]));
            var0.put(var11 + 1, v1(var2[var10 + 1]));
         }
      }
   }

   public static byte v1(float var0) {
      int var1 = 128 + Math.round(var0 / 2.0F * 127.0F);
      return (byte)Math.max(1, Math.min(255, var1));
   }

   public static float v1(byte var0) {
      return ((var0 & 255) - 128) / 127.0F * 2.0F;
   }

   private static float v1(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, (var2 - var0) / (var1 - var0)));
      return var3 * var3 * (3.0F - 2.0F * var3);
   }

   private static float v2(int var0) {
      return (var0 >>> 8) * 5.9604645E-8F;
   }

   private static int v1(int var0, int var1, int var2) {
      int var3 = var0 * 668265261 ^ var1 * 374761393 ^ var2 * -1640531527;
      var3 ^= var3 >>> 16;
      var3 *= 2146121005;
      var3 ^= var3 >>> 15;
      var3 *= -2073254261;
      return var3 ^ var3 >>> 16;
   }
}
