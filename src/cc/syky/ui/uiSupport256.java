package cc.syky.ui;

public final class uiSupport256 {
   public static final int v1 = 8;
   private static final int v4 = 4;
   public static final int v2 = 65536;
   public static final uiSupport256 v3 = new uiSupport256(new float[0], new int[0]);
   private final float[] v5;
   private final int[] v6;

   public uiSupport256(float[] var1, int[] var2) {
      if (var1.length % 32 != 0) {
         throw new IllegalArgumentException("vertex data is not whole quads: " + var1.length + " floats");
      } else if (var1.length / 8 > 65536) {
         throw new IllegalArgumentException(var1.length / 8 + " vertices is over 65536");
      } else if (var2.length % 4 != 0) {
         throw new IllegalArgumentException("part table is not whole parts: " + var2.length + " ints");
      } else {
         for (float var6 : var1) {
            if (!Float.isFinite(var6)) {
               throw new IllegalArgumentException("non-finite vertex data");
            }
         }

         int var7 = var1.length / 8;

         for (byte var8 = 0; var8 < var2.length; var8 += 4) {
            int var9 = var2[var8 + 2];
            int var10 = var2[var8 + 3];
            if (var2[var8] < 0 || var2[var8 + 1] < 0 || var9 < 0 || var10 <= 0 || var10 % 4 != 0 || var9 % 4 != 0 || var9 + var10 > var7) {
               throw new IllegalArgumentException("part " + var8 / 4 + " is out of range");
            }
         }

         this.v5 = var1;
         this.v6 = var2;
      }
   }

   public float[] v1() {
      return this.v5;
   }

   public int v2() {
      return this.v5.length / 8;
   }

   public int v3() {
      return this.v6.length / 4;
   }

   public int v1(int var1) {
      return this.v6[var1 * 4];
   }

   public int v2(int var1) {
      return this.v6[var1 * 4 + 1];
   }

   public int v3(int var1) {
      return this.v6[var1 * 4 + 2];
   }

   public int v4(int var1) {
      return this.v6[var1 * 4 + 3];
   }

   public int[] v4() {
      return this.v6;
   }
}
