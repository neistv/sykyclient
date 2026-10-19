package cc.syky.internal;

public final class Support774 {
   public static final int v1 = 16;

   private Support774() {
   }

   public static int v1(int var0, int var1, int var2) {
      float var3 = var2 / 15.0F;
      float var4 = (var0 >>> 24) * (1.0F - var3);
      float var5 = (var1 >>> 24) * var3;
      float var6 = var4 + var5;
      int var7 = 255 - Math.round(var6);
      if (var6 <= 0.0F) {
         return var7 << 24 | var1 & 16777215;
      } else {
         int var8 = v1(var0 >>> 16, var1 >>> 16, var4, var5, var6);
         int var9 = v1(var0 >>> 8, var1 >>> 8, var4, var5, var6);
         int var10 = v1(var0, var1, var4, var5, var6);
         return var7 << 24 | var8 << 16 | var9 << 8 | var10;
      }
   }

   private static int v1(int var0, int var1, float var2, float var3, float var4) {
      return Math.round(((var0 & 0xFF) * var2 + (var1 & 0xFF) * var3) / var4);
   }
}
