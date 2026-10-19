package cc.syky.module.visual;

import cc.syky.ui.uiSupport173;
import java.nio.ByteBuffer;
import java.util.stream.IntStream;

public final class visualSupport38 {
   public static final int v1 = 6;
   private static final int v2 = 4;
   private static final int v3 = 4;
   private static final float[] v4 = new float[256];
   private static final int v5 = 16383;
   private static final byte[] v6 = new byte[16384];

   private visualSupport38() {
   }

   public static int v1(int var0) {
      return 32 - Integer.numberOfLeadingZeros(Math.max(1, var0));
   }

   public static int v1(int var0, int var1) {
      return Math.max(1, var0 >> var1);
   }

   public static long v2(int var0) {
      return v1(var0, v1(var0), 0);
   }

   public static long v1(int var0, int var1, int var2) {
      long var3 = 0L;

      for (int var5 = 0; var5 < var1; var5++) {
         long var6 = v1(var0, var5);
         var3 += 6L * var6 * var6 * 4L;
      }

      long var8 = v1(var0, var1);
      return var3 + var2 * var8 * var8 * 4L;
   }

   public static void v1(ByteBuffer var0, int var1, int var2, uiSupport173 var3, int var4, ByteBuffer var5) {
      int var6 = Math.max(1, Math.min(4, (int)Math.ceil((double)var3.v1(var1) / var4)));
      IntStream.range(0, 6 * var4).parallel().forEach(var7x -> v1(var0, var1, var2, var3, var4, var6, var7x / var4, var7x % var4, var5));

      for (int var7 = 1; var7 < v1(var4); var7++) {
         v1(var5, var4, var7);
      }
   }

   private static void v1(ByteBuffer var0, int var1, int var2, uiSupport173 var3, int var4, int var5, int var6, int var7, ByteBuffer var8) {
      double[] var9 = new double[3];
      double[] var10 = new double[6];
      double[] var11 = new double[3];
      double var12 = 1.0 / (var5 * var5);
      int var14 = (int)v1(var4, 0, var6);

      for (int var15 = 0; var15 < var4; var15++) {
         double var16 = 0.0;
         double var18 = 0.0;
         double var20 = 0.0;

         for (int var22 = 0; var22 < var5; var22++) {
            double var23 = (var7 + (var22 + 0.5) / var5) / var4;

            for (int var25 = 0; var25 < var5; var25++) {
               double var26 = (var15 + (var25 + 0.5) / var5) / var4;
               v1(var6, 2.0 * var26 - 1.0, 2.0 * var23 - 1.0, var9);
               var3.v1(var9[0], var9[1], var9[2], var1, var2, var10);
               v1(var0, var1, var10, var11);
               var16 += var11[0];
               var18 += var11[1];
               var20 += var11[2];
            }
         }

         v1(var8, var14 + (var7 * var4 + var15) * 4, var16 * var12, var18 * var12, var20 * var12);
      }
   }

   public static int v1(ByteBuffer var0, int var1, int var2, uiSupport173 var3) {
      double[] var4 = new double[6];
      double[] var5 = new double[3];
      double var6 = 0.0;
      double var8 = 0.0;
      double var10 = 0.0;
      int var12 = 0;

      for (byte var13 = -2; var13 <= 2; var13 += 2) {
         double var14 = Math.toRadians(var13);

         for (int var16 = 0; var16 < 360; var16++) {
            double var17 = Math.toRadians(var16);
            var3.v1(Math.sin(var17) * Math.cos(var14), Math.sin(var14), -Math.cos(var17) * Math.cos(var14), var1, var2, var4);
            v1(var0, var1, var4, var5);
            var6 += var5[0];
            var8 += var5[1];
            var10 += var5[2];
            var12++;
         }
      }

      return 0xFF000000 | (v1(var6 / var12) & 0xFF) << 16 | (v1(var8 / var12) & 0xFF) << 8 | v1(var10 / var12) & 0xFF;
   }

   public static void v1(int var0, double var1, double var3, double[] var5) {
      switch (var0) {
         case 0:
            v1(var5, 1.0, -var3, -var1);
            break;
         case 1:
            v1(var5, -1.0, -var3, var1);
            break;
         case 2:
            v1(var5, var1, 1.0, var3);
            break;
         case 3:
            v1(var5, var1, -1.0, -var3);
            break;
         case 4:
            v1(var5, var1, -var3, 1.0);
            break;
         default:
            v1(var5, -var1, -var3, -1.0);
      }
   }

   private static void v1(double[] var0, double var1, double var3, double var5) {
      var0[0] = var1;
      var0[1] = var3;
      var0[2] = var5;
   }

   private static void v1(ByteBuffer var0, int var1, double[] var2, double[] var3) {
      double var4 = var2[0] - 0.5;
      double var6 = var2[1] - 0.5;
      int var8 = (int)Math.floor(var4);
      int var9 = (int)Math.floor(var6);
      double var10 = var4 - var8;
      double var12 = var6 - var9;
      boolean var14 = var2[2] == Double.NEGATIVE_INFINITY;
      int var15 = v1(var8, var14, var1, var2);
      int var16 = v1(var8 + 1, var14, var1, var2);
      int var17 = (int)Math.max(var2[3], Math.min(var2[5], (double)var9));
      int var18 = (int)Math.max(var2[3], Math.min(var2[5], (double)(var9 + 1)));
      double var19 = (1.0 - var10) * (1.0 - var12);
      double var21 = var10 * (1.0 - var12);
      double var23 = (1.0 - var10) * var12;
      double var25 = var10 * var12;
      int var27 = (var17 * var1 + var15) * 4;
      int var28 = (var17 * var1 + var16) * 4;
      int var29 = (var18 * var1 + var15) * 4;
      int var30 = (var18 * var1 + var16) * 4;

      for (int var31 = 0; var31 < 3; var31++) {
         var3[var31] = var19 * v1(var0, var27 + var31) + var21 * v1(var0, var28 + var31) + var23 * v1(var0, var29 + var31) + var25 * v1(var0, var30 + var31);
      }
   }

   private static int v1(int var0, boolean var1, int var2, double[] var3) {
      return var1 ? Math.floorMod(var0, var2) : (int)Math.max(var3[2], Math.min(var3[4], (double)var0));
   }

   private static float v1(ByteBuffer var0, int var1) {
      return v4[var0.get(var1) & 255];
   }

   private static void v1(ByteBuffer var0, int var1, int var2) {
      int var3 = v1(var1, var2);
      IntStream.range(0, 6 * var3).parallel().forEach(var4 -> v1(var0, var1, var2, var4 / var3, var4 % var3));
   }

   private static void v1(ByteBuffer var0, int var1, int var2, int var3, int var4) {
      int var5 = v1(var1, var2 - 1);
      int var6 = v1(var1, var2);
      int var7 = (int)v1(var1, var2 - 1, var3);
      int var8 = (int)v1(var1, var2, var3);
      int var9 = Math.min(var5 - 1, 2 * var4);
      int var10 = Math.min(var5 - 1, 2 * var4 + 1);

      for (int var11 = 0; var11 < var6; var11++) {
         int var12 = Math.min(var5 - 1, 2 * var11);
         int var13 = Math.min(var5 - 1, 2 * var11 + 1);
         int var14 = var7 + (var9 * var5 + var12) * 4;
         int var15 = var7 + (var9 * var5 + var13) * 4;
         int var16 = var7 + (var10 * var5 + var12) * 4;
         int var17 = var7 + (var10 * var5 + var13) * 4;
         double var18 = v1(var0, var14) + v1(var0, var15) + v1(var0, var16) + v1(var0, var17);
         double var20 = v1(var0, var14 + 1) + v1(var0, var15 + 1) + v1(var0, var16 + 1) + v1(var0, var17 + 1);
         double var22 = v1(var0, var14 + 2) + v1(var0, var15 + 2) + v1(var0, var16 + 2) + v1(var0, var17 + 2);
         v1(var0, var8 + (var4 * var6 + var11) * 4, var18 * 0.25, var20 * 0.25, var22 * 0.25);
      }
   }

   private static void v1(ByteBuffer var0, int var1, double var2, double var4, double var6) {
      var0.put(var1, v1(var2));
      var0.put(var1 + 1, v1(var4));
      var0.put(var1 + 2, v1(var6));
      var0.put(var1 + 3, (byte)-1);
   }

   private static byte v1(double var0) {
      int var2 = (int)(var0 * 16383.0 + 0.5);
      return v6[Math.max(0, Math.min(16383, var2))];
   }

   static {
      for (int var0 = 0; var0 < 256; var0++) {
         double var1 = var0 / 255.0;
         v4[var0] = (float)(var1 <= 0.04045 ? var1 / 12.92 : Math.pow((var1 + 0.055) / 1.055, 2.4));
      }

      for (int var5 = 0; var5 <= 16383; var5++) {
         double var6 = var5 / 16383.0;
         double var3 = var6 <= 0.0031308 ? var6 * 12.92 : 1.055 * Math.pow(var6, 0.4166666666666667) - 0.055;
         v6[var5] = (byte)Math.round(Math.min(1.0, Math.max(0.0, var3)) * 255.0);
      }
   }
}
