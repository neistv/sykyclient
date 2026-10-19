package cc.syky.ui;

import java.nio.ByteBuffer;

public final class uiSupport155 {
   public static final int v1 = 0;
   public static final int v2 = -16777216;
   public static final int v3 = -1;
   private static final float[] v4 = new float[256];

   private uiSupport155() {
   }

   public static int v1(int var0, int var1, int var2, int var3) {
      return (var3 & 0xFF) << 24 | (var0 & 0xFF) << 16 | (var1 & 0xFF) << 8 | var2 & 0xFF;
   }

   public static int v1(int var0, int var1, int var2) {
      return v1(var0, var1, var2, 255);
   }

   public static int v1(int var0) {
      return var0 >>> 24 & 0xFF;
   }

   public static int v2(int var0) {
      return var0 >>> 16 & 0xFF;
   }

   public static int v3(int var0) {
      return var0 >>> 8 & 0xFF;
   }

   public static int v4(int var0) {
      return var0 & 0xFF;
   }

   public static int v1(int var0, float var1) {
      int var2 = (int)(v1(var0) * Math.clamp(var1, 0.0F, 1.0F));
      return var0 & 16777215 | (var2 & 0xFF) << 24;
   }

   public static int v1(int var0, int var1) {
      return var0 & 16777215 | (var1 & 0xFF) << 24;
   }

   public static int v1(int var0, int var1, float var2) {
      float var3 = Math.clamp(var2, 0.0F, 1.0F);
      int var4 = v1(var0);
      int var5 = v2(var0);
      int var6 = v3(var0);
      int var7 = v4(var0);
      int var8 = v1(var1);
      int var9 = v2(var1);
      int var10 = v3(var1);
      int var11 = v4(var1);
      return v1(
         (int)(var5 + (var9 - var5) * var3), (int)(var6 + (var10 - var6) * var3), (int)(var7 + (var11 - var7) * var3), (int)(var4 + (var8 - var4) * var3)
      );
   }

   public static int v2(int var0, float var1) {
      float var2 = Math.clamp(var1, 0.0F, 1.0F);
      return v1((int)(v2(var0) * var2), (int)(v3(var0) * var2), (int)(v4(var0) * var2), v1(var0));
   }

   public static void v1(ByteBuffer var0, int var1) {
      var0.putFloat(v2(var1) / 255.0F);
      var0.putFloat(v3(var1) / 255.0F);
      var0.putFloat(v4(var1) / 255.0F);
      var0.putFloat(v1(var1) / 255.0F);
   }

   public static void v2(ByteBuffer var0, int var1) {
      float var2 = v1(var1) / 255.0F;
      var0.putFloat(v4[v2(var1)] * var2);
      var0.putFloat(v4[v3(var1)] * var2);
      var0.putFloat(v4[v4(var1)] * var2);
      var0.putFloat(var2);
   }

   public static float v5(int var0) {
      return v4[var0];
   }

   public static int v1(float var0) {
      int var1 = Math.round((float)Math.pow(Math.max(var0, 0.0F), 0.45454544F) * 255.0F);
      return Math.min(255, Math.max(0, var1));
   }

   public static int v2(int var0, int var1) {
      return v1(v2(var0) + v2(var1) >>> 1, v3(var0) + v3(var1) >>> 1, v4(var0) + v4(var1) >>> 1, v1(var0) + v1(var1) >>> 1);
   }

   public static int v2(int var0, int var1, int var2, int var3) {
      return v1(
         v2(var0) + v2(var1) + v2(var2) + v2(var3) >>> 2,
         v3(var0) + v3(var1) + v3(var2) + v3(var3) >>> 2,
         v4(var0) + v4(var1) + v4(var2) + v4(var3) >>> 2,
         v1(var0) + v1(var1) + v1(var2) + v1(var3) >>> 2
      );
   }

   static {
      for (int var0 = 0; var0 < 256; var0++) {
         v4[var0] = (float)Math.pow(var0 / 255.0F, 2.2);
      }
   }
}
