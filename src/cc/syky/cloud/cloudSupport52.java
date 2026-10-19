package cc.syky.cloud;

import java.util.Arrays;

public final class cloudSupport52 {
   private final long[] v1;
   private int v2;
   private int v3;

   public cloudSupport52(int var1) {
      if (var1 <= 0) {
         throw new IllegalArgumentException("size must be > 0, got " + var1);
      } else {
         this.v1 = new long[var1];
      }
   }

   public void v1(long var1) {
      this.v1[this.v2] = var1;
      this.v2 = (this.v2 + 1) % this.v1.length;
      if (this.v3 < this.v1.length) {
         this.v3++;
      }
   }

   public cloudRecord7 v1() {
      if (this.v3 == 0) {
         return cloudRecord7.EMPTY;
      } else {
         long[] var1 = new long[this.v3];
         System.arraycopy(this.v1, 0, var1, 0, this.v3);
         Arrays.sort(var1);
         long var2 = var1[0];
         long var4 = var1[this.v3 - 1];
         long var6 = 0L;

         for (int var8 = 0; var8 < this.v3; var8++) {
            var6 += var1[var8];
         }

         double var16 = (double)var6 / this.v3;
         long var10 = var1[Math.min(this.v3 - 1, (int)(this.v3 * 0.5))];
         long var12 = var1[Math.min(this.v3 - 1, (int)(this.v3 * 0.95))];
         long var14 = var1[Math.min(this.v3 - 1, (int)(this.v3 * 0.99))];
         return new cloudRecord7(this.v3, var2, var4, var16, var10, var12, var14);
      }
   }

   public void v2() {
      Arrays.fill(this.v1, 0L);
      this.v2 = 0;
      this.v3 = 0;
   }

   public int v3() {
      return this.v1.length;
   }
}
