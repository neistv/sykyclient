package cc.syky.cloud;

public final class cloudSupport8 {
   public static final double v1 = 8.0;
   private static final double v2 = 0.7;
   private boolean v3;
   private double v4;
   private double v5;
   private double v6;

   public cloudSupport8() {
   }

   public void v1(double var1, double var3, float var5) {
      if (!this.v3) {
         this.v1(var1, var3);
      } else {
         double var6 = var1 - this.v4;
         double var8 = var3 - this.v5;
         this.v4 = var1;
         this.v5 = var3;
         double var10 = Math.sqrt(var6 * var6 + var8 * var8);
         if (!(var10 > 8.0)) {
            double var12 = var10 * Math.max((double)var5, 1.0);
            this.v6 = this.v6 * 0.7 + var12 * 0.30000000000000004;
         }
      }
   }

   public void v1() {
      this.v3 = false;
      this.v6 = 0.0;
   }

   public double v2() {
      return this.v6;
   }

   private void v1(double var1, double var3) {
      this.v3 = true;
      this.v4 = var1;
      this.v5 = var3;
      this.v6 = 0.0;
   }
}
