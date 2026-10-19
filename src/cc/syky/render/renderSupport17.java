package cc.syky.render;

import java.nio.ByteBuffer;

public final class renderSupport17 {
   public static final float v1 = 0.083333336F;
   public static final float v2 = 0.5405405F;
   public static final float v3 = 2.0F;
   public static final int v4 = 896;
   private static final float v5 = 0.7F;

   private renderSupport17() {
   }

   public static void v1(ByteBuffer var0, float var1, float var2, float var3, float var4) {
      float var5 = 0.083333336F * var3;
      float var6 = var5 * 0.5405405F;
      int var7 = (int)Math.floor(-0.5F * var4 / var5);
      int var8 = (int)Math.floor(0.5F * var4 / var5) - var7 + 1;
      int var9 = (int)Math.floor(-0.5F * var4 / var6);
      int var10 = (int)Math.floor(0.5F * var4 / var6) - var9 + 1;
      short var11 = 224;
      var8 = Math.min(var8, var11);
      var10 = Math.min(var10, var11 - var8);
      var0.putFloat(var7).putFloat(var8).putFloat(var9).putFloat(var10);
      int var12 = var0.position();

      for (int var13 = 0; var13 < var8; var13++) {
         v1(var0, var7 + var13, var5, 21, var1, var2);
      }

      for (int var16 = 0; var16 < var10; var16++) {
         v1(var0, var9 + var16, var6, 31, var1, var2);
      }

      var0.position(var12 + 14336);
   }

   private static void v1(ByteBuffer var0, int var1, float var2, int var3, float var4, float var5) {
      float var6 = var4 / 2.0F + v1(v1(var1, 0, var3));
      int var7 = (int)Math.floor(var6);
      float var8 = var6 - var7;
      int var9 = Math.max(1, Math.round(var5 / 2.0F));

      for (int var10 = 0; var10 < 2; var10++) {
         int var11 = Math.floorMod(var7 - var10, var9);
         float var12 = var8 + var10;
         int var13 = v1(var1, var11, var3 + 1);
         int var14 = v1(var1, var11, var3 + 2);
         boolean var15 = v1(var13) < 0.7F;
         float var16 = var2 * 0.4F;
         float var17 = (var1 + 0.5F + (v1(var13, 0) - 0.5F) * 0.2F) * var2;
         float var18 = -0.2F + 0.8F * v1(var14, 3);
         int var19 = 3 + (int)Math.floor(v1(var14, 2) * 3.0F);
         float var20 = Math.max(0.0F, Math.min(1.0F, var12));
         float var21 = var20 * var19;
         float var22 = v1(0.7F, 1.0F, var21 - (float)Math.floor(var21));
         float var23 = ((float)Math.floor(var21) + var22) / var19;
         float var24 = var12 <= 1.0F ? Math.max(0.0F, Math.min(1.0F, 4.0F * var22 * (1.0F - var22))) : 0.0F;
         float var25 = var18 - var23 * (var18 + 0.5F + 2.0F * var16);
         var0.putFloat(var17).putFloat(var18).putFloat(var25).putFloat(var15 ? var16 : 0.0F);
         var0.putFloat(var24).putFloat(var12).putFloat(v1(var14, 0)).putFloat(v1(var14, 1));
      }
   }

   private static float v1(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, (var2 - var0) / (var1 - var0)));
      return var3 * var3 * (3.0F - 2.0F * var3);
   }

   private static float v1(int var0) {
      return (var0 >>> 8) * 5.9604645E-8F;
   }

   private static float v1(int var0, int var1) {
      return (var0 >>> 8 * var1 & 0xFF) / 256.0F;
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
