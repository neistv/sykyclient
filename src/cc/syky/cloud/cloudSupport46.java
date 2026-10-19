package cc.syky.cloud;

public final class cloudSupport46 {
   private static final cloudSupport46.Part2[] v1 = cloudSupport46.Part2.values();
   private final int v2;
   private final cloudSupport46.Part1 v3;
   private final float[] v4;
   private final float[] v5;
   private final byte[] v6;
   private final boolean v7;

   public cloudSupport46(int var1, cloudSupport46.Part1 var2, float[] var3, float[] var4, byte[] var5) {
      int var6 = var3.length;
      if (var6 != 0 && var4.length == var6 * 3 && var5.length == var6) {
         int var7 = 0;

         while (var7 < var6) {
            if (Float.isFinite(var3[var7]) && (var7 <= 0 || var3[var7] > var3[var7 - 1])) {
               if (var5[var7] >= 0 && var5[var7] < v1.length) {
                  var7++;
                  continue;
               }

               throw new IllegalArgumentException("interpolation " + var5[var7]);
            }

            throw new IllegalArgumentException("key times must be finite and increasing");
         }

         for (float var10 : var4) {
            if (!Float.isFinite(var10)) {
               throw new IllegalArgumentException("non-finite key value");
            }
         }

         this.v2 = var1;
         this.v3 = var2;
         this.v4 = var3;
         this.v5 = var4;
         this.v6 = var5;
         this.v7 = var6 > 2 && var4[0] == var4[(var6 - 1) * 3] && var4[1] == var4[(var6 - 1) * 3 + 1] && var4[2] == var4[(var6 - 1) * 3 + 2];
      } else {
         throw new IllegalArgumentException("inconsistent channel of " + var6 + " keys");
      }
   }

   public int v1() {
      return this.v2;
   }

   public cloudSupport46.Part1 v2() {
      return this.v3;
   }

   public int v3() {
      return this.v4.length;
   }

   public float v1(int var1) {
      return this.v4[var1];
   }

   public float v1(int var1, int var2) {
      return this.v5[var1 * 3 + var2];
   }

   public cloudSupport46.Part2 v2(int var1) {
      return v1[this.v6[var1]];
   }

   public void v1(float var1, float[] var2, int var3) {
      this.v1(var1, var2, var3, false);
   }

   public void v1(float var1, float[] var2, int var3, boolean var4) {
      int var5 = this.v4.length;
      if (var5 == 1 || var1 <= this.v4[0]) {
         this.v1(0, var2, var3);
      } else if (var1 >= this.v4[var5 - 1]) {
         this.v1(var5 - 1, var2, var3);
      } else {
         int var6 = this.v1(var1);
         float var7 = this.v4[var6];
         float var8 = (var1 - var7) / (this.v4[var6 + 1] - var7);
         switch (v1[this.v6[var6]]) {
            case LINEAR:
               for (int var13 = 0; var13 < 3; var13++) {
                  float var14 = this.v5[var6 * 3 + var13];
                  var2[var3 + var13] = var14 + (this.v5[(var6 + 1) * 3 + var13] - var14) * var8;
               }
               break;
            case STEP:
               this.v1(var6, var2, var3);
               break;
            case SMOOTH:
               boolean var9 = var4 && this.v7;
               int var10 = var6 > 0 ? var6 - 1 : (var9 ? var5 - 2 : 0);
               int var11 = var6 + 2 < var5 ? var6 + 2 : (var9 ? 1 : var5 - 1);

               for (int var12 = 0; var12 < 3; var12++) {
                  var2[var3 + var12] = v1(
                     this.v5[var10 * 3 + var12], this.v5[var6 * 3 + var12], this.v5[(var6 + 1) * 3 + var12], this.v5[var11 * 3 + var12], var8
                  );
               }
         }
      }
   }

   private void v1(int var1, float[] var2, int var3) {
      var2[var3] = this.v5[var1 * 3];
      var2[var3 + 1] = this.v5[var1 * 3 + 1];
      var2[var3 + 2] = this.v5[var1 * 3 + 2];
   }

   private int v1(float var1) {
      int var2 = 0;
      int var3 = this.v4.length - 1;

      while (var3 - var2 > 1) {
         int var4 = var2 + var3 >>> 1;
         if (this.v4[var4] <= var1) {
            var2 = var4;
         } else {
            var3 = var4;
         }
      }

      return var2;
   }

   private static float v1(float var0, float var1, float var2, float var3, float var4) {
      float var5 = var4 * var4;
      float var6 = var5 * var4;
      return 0.5F
         * (2.0F * var1 + (-var0 + var2) * var4 + (2.0F * var0 - 5.0F * var1 + 4.0F * var2 - var3) * var5 + (-var0 + 3.0F * var1 - 3.0F * var2 + var3) * var6);
   }

   public static enum Part1 {
      ROTATION,
      POSITION,
      SCALE;

      private Part1() {
      }
   }

   public static enum Part2 {
      LINEAR,
      STEP,
      SMOOTH;

      private Part2() {
      }
   }
}
