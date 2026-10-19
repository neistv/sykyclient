package cc.syky.ui;

public final class uiSupport10 {
   public static final long v1 = 3000000000L;
   public static final long v2 = 10000000000L;
   private static final double v4 = 20.0;
   private static final long v5 = 3L;
   public static final float v3 = 20.0F;
   private static final double v6 = 1.5;
   private static final double v7 = 1.0E9;
   private boolean v8;
   private long v9;
   private long v10;
   private boolean v11;
   private long v12;
   private long v13;
   private float v14 = 20.0F;
   private boolean v15;
   private double v16 = Double.NaN;
   private long v18;

   public uiSupport10() {
   }

   public void v1(long var1, long var3, float var5, boolean var6) {
      this.v11 = true;
      this.v12 = var1;
      this.v13 = var3;
      this.v14 = var5;
      this.v15 = var6;
   }

   public void v1(long var1) {
      if (this.v11) {
         this.v11 = false;
         this.v1(this.v12, this.v13);
      }

      if (this.v3() && var1 - this.v18 > this.v4()) {
         this.v16 = Double.NaN;
         this.v8 = false;
      }
   }

   private void v1(long var1, long var3) {
      if (!this.v8) {
         this.v2(var1, var3);
      } else {
         long var5 = var1 - this.v9;
         long var7 = var3 - this.v10;
         if (var5 < 0L) {
            this.v2(var1, var3);
         } else if (var7 >= 3000000000L) {
            if (var5 == 0L) {
               if (this.v15) {
                  this.v1(0.0, var3);
               }

               this.v2(var1, var3);
            } else {
               double var9 = Math.max((double)this.v14, 1.0);
               double var11 = var5 * 1.0E9 / var7;
               if (var11 > var9 * 1.5) {
                  this.v2(var1, var3);
               } else {
                  this.v1(Math.min(var11, var9), var3);
                  this.v2(var1, var3);
               }
            }
         }
      }
   }

   private long v4() {
      double var1 = this.v3() ? Math.max(this.v16, 0.5) : Math.max((double)this.v14, 1.0);
      long var3 = (long)(20.0 / var1 * 1.0E9);
      return Math.max(10000000000L, 3L * var3);
   }

   public void v2(long var1) {
      this.v8 = false;
      this.v11 = false;
      this.v18 = var1;
   }

   public void v1() {
      this.v8 = false;
      this.v11 = false;
      this.v16 = Double.NaN;
      this.v18 = 0L;
      this.v14 = 20.0F;
      this.v15 = false;
   }

   public double v2() {
      return this.v16;
   }

   public boolean v3() {
      return !Double.isNaN(this.v16);
   }

   private void v1(double var1, long var3) {
      this.v16 = var1;
      this.v18 = var3;
   }

   private void v2(long var1, long var3) {
      this.v8 = true;
      this.v9 = var1;
      this.v10 = var3;
   }
}
