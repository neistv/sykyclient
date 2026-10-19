package cc.syky.cloud;

public final class cloudSupport5 {
   private static final long v1 = 1000000000L;
   private static final int v2 = 64;
   private final long[] v3 = new long[64];
   private final long[] v4 = new long[64];
   private int v5;
   private int v6;

   public cloudSupport5() {
   }

   public void v1(int var1, long var2) {
      if (var1 == 0) {
         this.v3[this.v5] = var2;
         this.v5 = (this.v5 + 1) % 64;
      } else if (var1 == 1) {
         this.v4[this.v6] = var2;
         this.v6 = (this.v6 + 1) % 64;
      }
   }

   public int v1(long var1) {
      return v1(this.v3, var1);
   }

   public int v2(long var1) {
      return v1(this.v4, var1);
   }

   private static int v1(long[] var0, long var1) {
      long var3 = var1 - 1000000000L;
      int var5 = 0;

      for (long var9 : var0) {
         if (var9 > var3) {
            var5++;
         }
      }

      return var5;
   }
}
