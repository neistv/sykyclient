package cc.syky.cloud;

public final class cloudSupport3 {
   public static final int v1 = 1000;
   public static final int v2 = 20;
   private static final double v4 = 0.01;
   public static final long v3 = 2000000000L;
   private static final double v5 = 2.5E8;
   private static final long v6 = 250000000L;
   private static final long v7 = 500000000L;
   private final long[] v8 = new long[1000];
   private final long[] v9 = new long[1000];
   private int v10;
   private int v11;
   private boolean v12;
   private long v13;
   private double v14;
   private double v15;
   private long v16;
   private long v18;
   private int v19;

   public cloudSupport3() {
   }

   public void v1(long var1) {
      if (!this.v12) {
         this.v12 = true;
         this.v13 = var1;
      } else {
         long var3 = var1 - this.v13;
         this.v13 = var1;
         if (var3 > 0L && var3 <= 2000000000L) {
            this.v14 = this.v14 <= 0.0 ? var3 : this.v14 + (var3 - this.v14) * (1.0 - Math.exp(-var3 / 2.5E8));
            this.v16 += var3;
            if (this.v15 <= 0.0 || this.v16 >= 500000000L) {
               this.v16 = 0L;
               this.v15 = this.v14;
            }

            this.v8[this.v11] = var3;
            this.v11 = this.v11 + 1 == 1000 ? 0 : this.v11 + 1;
            if (this.v10 < 1000) {
               this.v10++;
            }

            this.v18 += var3;
            if (this.v18 >= 250000000L) {
               this.v18 = 0L;
               this.v3();
            }
         }
      }
   }

   public double v1() {
      return this.v15 / 1000000.0;
   }

   public int v2() {
      return this.v19;
   }

   private void v3() {
      if (this.v10 < 20) {
         this.v19 = 0;
      } else {
         System.arraycopy(this.v8, 0, this.v9, 0, this.v10);
         int var1 = Math.max(1, (int)Math.round(this.v10 * 0.01));
         long var2 = v1(this.v9, this.v10, this.v10 - var1);
         this.v19 = var2 > 0L ? (int)Math.round(1.0E9 / var2) : 0;
      }
   }

   public static long v1(long[] var0, int var1, int var2) {
      int var3 = 0;
      int var4 = var1 - 1;

      while (var3 < var4) {
         long var5 = var0[var3 + var4 >>> 1];
         int var7 = var3;
         int var8 = var4;

         while (var7 <= var8) {
            while (var0[var7] < var5) {
               var7++;
            }

            while (var0[var8] > var5) {
               var8--;
            }

            if (var7 <= var8) {
               long var9 = var0[var7];
               var0[var7] = var0[var8];
               var0[var8] = var9;
               var7++;
               var8--;
            }
         }

         if (var2 <= var8) {
            var4 = var8;
         } else {
            if (var2 < var7) {
               return var0[var2];
            }

            var3 = var7;
         }
      }

      return var0[var2];
   }
}
