package cc.syky.ui;

public final class uiSupport12 {
   public static final long v1 = 10000L;
   public static final long v2 = 8000000000L;
   private static final double v3 = 0.6;
   private static final int v4 = 2;
   private double v5 = Double.NaN;
   private long v6;
   private int v7 = -1;
   private boolean v8;
   private int v9;

   public uiSupport12() {
   }

   public void v1(long var1, long var3) {
      if (var1 >= 0L && var1 <= 10000L) {
         this.v5 = Double.isNaN(this.v5) ? var1 : this.v5 * 0.6 + var1 * 0.4;
         this.v6 = var3;
      }
   }

   public void v1(long var1) {
      if (!Double.isNaN(this.v5) && var1 - this.v6 > 8000000000L) {
         this.v5 = Double.NaN;
      }
   }

   public void v1(int var1) {
      this.v7 = var1;
      if (var1 > 0 || var1 == 0 && this.v9 >= 2) {
         this.v8 = true;
      }
   }

   public void v1() {
      if (this.v9 < 2) {
         this.v9++;
      }
   }

   public void v2() {
      this.v5 = Double.NaN;
      this.v6 = 0L;
      this.v7 = -1;
      this.v8 = false;
      this.v9 = 0;
   }

   public boolean v3() {
      return !Double.isNaN(this.v5) || this.v8 && this.v7 >= 0;
   }

   public int v4() {
      if (!Double.isNaN(this.v5)) {
         return (int)Math.round(this.v5);
      } else {
         return this.v8 && this.v7 >= 0 ? this.v7 : -1;
      }
   }
}
