package cc.syky.hud;

public final class hudSupport59 {
   public static final hudSupport59 v1 = new hudSupport59();
   public static final float v2 = 4.0F;
   public static final float v3 = 6.0F;
   public static final float v4 = 25.0F;
   public static final float v5 = 35.0F;
   public static final float v6 = 600.0F;
   public static final long v7 = 50000000L;
   private static final double v8 = 1.0E-6;
   private boolean v9;
   private boolean v10;
   private float v11;
   private float v12;
   private long v13;
   private double v14;
   private double v15;

   public hudSupport59() {
   }

   public boolean v1() {
      return this.v9;
   }

   public boolean v2() {
      return this.v10;
   }

   public void v1(float var1) {
      if (this.v9 && Math.abs(var1 - this.v12) > 4.0F) {
         this.v10 = true;
      }
   }

   public float v3() {
      return this.v11;
   }

   public float v4() {
      return this.v12;
   }

   public void v1(float var1, float var2, long var3, double var5) {
      this.v9 = true;
      this.v10 = false;
      this.v11 = var1;
      this.v12 = var2;
      this.v13 = var3;
      this.v14 = Math.max(0.0, var5);
      this.v15 = 0.0;
   }

   public void v5() {
      this.v9 = false;
      this.v10 = false;
      this.v15 = 0.0;
   }

   public double v1(float var1, long var2) {
      if (!this.v9) {
         return 0.0;
      } else {
         double var4 = Math.min(Math.max(0L, var2 - this.v13), 50000000L) / 1.0E9;
         this.v13 = var2;
         this.v1(var1);
         if (!this.v10) {
            return 0.0;
         } else {
            double var6 = -v2(var1 - this.v12) * var4;
            if (this.v14 <= 0.0) {
               return var6;
            } else {
               this.v15 += var6;
               long var8 = (long)(this.v15 / this.v14);
               if (var8 == 0L) {
                  return 0.0;
               } else {
                  this.v15 = this.v15 - var8 * this.v14;
                  return (var8 + Math.signum((float)var8) * 1.0E-6) * this.v14;
               }
            }
         }
      }
   }

   public static double v2(float var0) {
      double var1 = Math.abs(var0) / 6.0F;
      if (var1 <= 1.0) {
         return 0.0;
      } else {
         double var3 = (var1 * Math.sqrt(var1) - 1.0) * 25.0;
         return Math.signum(var0) * Math.min(600.0, var3 / 35.0);
      }
   }
}
