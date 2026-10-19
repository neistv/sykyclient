package cc.syky.cloud;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class cloudSupport23 {
   public static final int v1 = 256;
   public static final int v2 = Integer.numberOfTrailingZeros(256) + 1;
   public static final float v3 = 0.25F;

   private cloudSupport23() {
   }

   public static ByteBuffer v1() {
      ByteBuffer var0 = ByteBuffer.allocateDirect(262144).order(ByteOrder.nativeOrder());

      for (int var1 = 0; var1 < 256; var1++) {
         for (int var2 = 0; var2 < 256; var2++) {
            float var3 = 0.6F * v1(var2 / 8.0F, var1 / 8.0F, 32, 0) + 0.28F * v1(var2 / 4.0F + 17.0F, var1 / 4.0F + 31.0F, 64, 1);
            float var4 = v1(var2 / 8.0F + 5.0F, var1 / 8.0F + 11.0F, 32, 2);
            float var5 = (v1(var2 + 0.5F, var1) - v1(var2 - 0.5F, var1)) * 16.0F;
            float var6 = (v1(var2, var1 + 0.5F) - v1(var2, var1 - 0.5F)) * 16.0F;
            var0.put(v1(var3 * 0.5F + 0.5F));
            var0.put(v1(var4 * 0.5F + 0.5F));
            var0.put(v1(var5 * 0.25F + 0.5F));
            var0.put(v1(var6 * 0.25F + 0.5F));
         }
      }

      return var0.flip();
   }

   public static ByteBuffer v1(ByteBuffer var0, int var1) {
      int var2 = var1 / 2;
      ByteBuffer var3 = ByteBuffer.allocateDirect(var2 * var2 * 4).order(ByteOrder.nativeOrder());

      for (int var4 = 0; var4 < var2; var4++) {
         for (int var5 = 0; var5 < var2; var5++) {
            for (int var6 = 0; var6 < 4; var6++) {
               int var7 = v1(var0, var1, 2 * var5, 2 * var4, var6)
                  + v1(var0, var1, 2 * var5 + 1, 2 * var4, var6)
                  + v1(var0, var1, 2 * var5, 2 * var4 + 1, var6)
                  + v1(var0, var1, 2 * var5 + 1, 2 * var4 + 1, var6);
               var3.put((byte)((var7 + 2) / 4));
            }
         }
      }

      return var3.flip();
   }

   private static int v1(ByteBuffer var0, int var1, int var2, int var3, int var4) {
      return var0.get((var2 + var3 * var1) * 4 + var4) & 0xFF;
   }

   private static float v1(float var0, float var1) {
      return v1(var0 / 16.0F + 41.0F, var1 / 16.0F + 7.0F, 16, 3);
   }

   private static byte v1(float var0) {
      return (byte)Math.round(Math.clamp(var0, 0.0F, 1.0F) * 255.0F);
   }

   public static float v1(float var0, float var1, int var2, int var3) {
      int var4 = (int)Math.floor(var0);
      int var5 = (int)Math.floor(var1);
      float var6 = var0 - var4;
      float var7 = var1 - var5;
      float var8 = v2(var6);
      float var9 = v2(var7);
      float var10 = v1(var4, var5, var6, var7, var2, var3);
      float var11 = v1(var4 + 1, var5, var6 - 1.0F, var7, var2, var3);
      float var12 = v1(var4, var5 + 1, var6, var7 - 1.0F, var2, var3);
      float var13 = v1(var4 + 1, var5 + 1, var6 - 1.0F, var7 - 1.0F, var2, var3);
      float var14 = var10 + (var11 - var10) * var8;
      float var15 = var12 + (var13 - var12) * var8;
      return var14 + (var15 - var14) * var9;
   }

   private static float v2(float var0) {
      return var0 * var0 * var0 * (var0 * (var0 * 6.0F - 15.0F) + 10.0F);
   }

   private static float v1(int var0, int var1, float var2, float var3, int var4, int var5) {
      int var6 = v1(Math.floorMod(var0, var4), Math.floorMod(var1, var4), var5);
      double var7 = (var6 & 65535) / 65536.0 * Math.PI * 2.0;
      return (float)(Math.cos(var7) * var2 + Math.sin(var7) * var3);
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
